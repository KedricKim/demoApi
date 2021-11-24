package com.api.demo.repository;

import com.api.demo.vo.BookVo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookVo, Integer>{
}