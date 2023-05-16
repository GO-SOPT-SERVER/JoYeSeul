package com.example.SecondSeminar.controller.post.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostRequestDto {
    private String title;
    private String content;
    private String writer;

}
