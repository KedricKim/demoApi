package com.api.demo.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="book_table")
@DynamicUpdate
@DynamicInsert
public class BookVo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;
    
    @Column(nullable = false)
    private String category; // 카테고리

    private String writer; // 지은이
    private String title; // 책 제목
    private String rentYn; // 렌트여부
    private String useYn; // 사용가능 여부
    private String reason; // 사용불가 이유

    @Builder
    public BookVo(String category, String writer, String title, String rentYn, String useYn, String reason){
        this.category = category;
        this.writer = writer;
        this.title = title;
        this.rentYn = rentYn;
        this.useYn = useYn;
        this.reason = reason;
    }
}
