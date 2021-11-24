package com.api.demo.controller;

import java.util.List;

import com.api.demo.service.BookService;
import com.api.demo.vo.BookVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/book")
public class BookController {
    
    @Autowired
    BookService bookService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<BookVo>> getAllProducts(){
        List<BookVo> books = bookService.findAll();
        return new ResponseEntity<List<BookVo>>(books, HttpStatus.OK);
    }
}
