package com.api.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.api.demo.repository.BookRepository;
import com.api.demo.vo.BookVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    public List<BookVo> findAll(){
        List<BookVo> books = new ArrayList<>();
        bookRepository.findAll().forEach(e -> books.add(e));
        return books;
    }

    public List<BookVo> findByCategoryContaining(String category){
        List<BookVo> books = bookRepository.findByCategoryContaining(category);
        return books;
    }

    public List<BookVo> findByTitleContainingOrWriterContaining(BookVo bookVo){
        String title = bookVo.getTitle();
        String writer = bookVo.getWriter();
        if(title == null)title = "";
        if(writer == null)writer = "";
        List<BookVo> books = bookRepository.findByTitleContainingOrWriterContaining(title, writer);
        return books;
    }

    public BookVo postBook(BookVo bookVo){
        if(bookVo.getCategory() != null){
            BookVo books = bookRepository.save(bookVo);
            return books;
        }else{
            return null;
        }
    }

    public int putBookCategory(String category, int idx){
        if(category == null || "".equals(category)){
            return 0;
        }else{
            int result = bookRepository.putBookCategory(category, idx);
            return result;
        }
    }

    public int putBookUse(int idx, String useYn, String reason){
        if(useYn == null || "".equals(useYn)){
            return 0;
        }else{
            int books = bookRepository.putBookUse(idx, useYn, reason);
            return books;
        }
    }
    
}
