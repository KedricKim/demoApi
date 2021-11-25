package com.api.demo.repository;

import java.util.List;

import com.api.demo.vo.BookVo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepository extends JpaRepository<BookVo, Integer>{

    List<BookVo> findByCategoryContaining(String category);

    List<BookVo> findByTitleContainingOrWriterContaining(String title, String writer);

    @Transactional
    @Modifying
    @Query("update book_table set category = :category where idx = :idx")
    int putBookCategory(@Param("category") String category, @Param("idx")int idx);

    @Transactional
    @Modifying
    @Query("update book_table set useYn = :useYn, reason = :reason where idx = :idx")
    int putBookUse(@Param("idx")int idx, @Param("useYn")String useYn, @Param("reason")String reason);
}