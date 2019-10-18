package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
//@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Article {

    private Long id;
    private String author;
    private String title;
    private String content;
    private Date createTime;


}
