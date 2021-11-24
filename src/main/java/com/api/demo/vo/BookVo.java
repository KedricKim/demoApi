package com.api.demo.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="book_table")
public class BookVo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;
    
    @Column(nullable = false)
    private String category;

    private String writer;
    private String title;
    private String rentYn;
    private String useYn;
    private String reason;

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
