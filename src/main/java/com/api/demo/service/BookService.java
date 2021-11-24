package com.api.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.api.demo.repository.BookRepository;
import com.api.demo.vo.BookVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;


    public List<BookVo> findAll(){
        List<BookVo> books = new ArrayList<>();
        bookRepository.findAll().forEach(e -> books.add(e));
        return books;
        
    }
}
