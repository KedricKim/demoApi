package com.api.demo.controller;

import java.util.List;

import com.api.demo.repository.BookRepository;
import com.api.demo.service.BookService;
import com.api.demo.vo.BookVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/v1/book")
public class BookController {
    
    @Autowired
    BookService bookService;

    private HttpStatus httpStatus = HttpStatus.OK;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<BookVo>> getBooksByTitleOrWriter(@RequestBody BookVo bookVo){
        List<BookVo> books = bookService.findByTitleContainingOrWriterContaining(bookVo);
        return new ResponseEntity<List<BookVo>>(books, httpStatus);
    }

    @GetMapping(value = "/search/category", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<BookVo>> getBooksByCategory(@RequestBody BookVo bookVo){
        List<BookVo> books = bookService.findByCategoryContaining(bookVo.getCategory());
        return new ResponseEntity<List<BookVo>>(books, httpStatus);
    }

    @PostMapping
    public ResponseEntity postBook(@RequestBody BookVo bookVo) {
        BookVo books = bookService.postBook(bookVo);
        if(books == null)httpStatus = HttpStatus.BAD_REQUEST;

        return new ResponseEntity(httpStatus);
    }
    
    @PutMapping(value="/{idx}")
    public ResponseEntity putBookCategory(@PathVariable int idx, @RequestBody BookVo bookVo) {
        int result = bookService.putBookCategory(bookVo.getCategory(), idx);
        if(result == 0)httpStatus = HttpStatus.BAD_REQUEST;
        return new ResponseEntity(httpStatus);
    }

    @PutMapping(value="/use/{idx}")
    public ResponseEntity putBookUse(@PathVariable int idx, @RequestBody BookVo bookVo) {
        int result = bookService.putBookUse(idx, bookVo.getUseYn(), bookVo.getReason());
        if(result == 0)httpStatus = HttpStatus.BAD_REQUEST;
        return new ResponseEntity(httpStatus);
    }

}
