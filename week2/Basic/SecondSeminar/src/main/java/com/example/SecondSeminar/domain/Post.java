package com.example.SecondSeminar.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
public class Post {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime currentDate;

    public Post(String title, String content, String writer, LocalDateTime currentDate) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.currentDate = currentDate;
    }

}
