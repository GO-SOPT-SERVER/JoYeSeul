package com.example.SecondSeminar.service;

import com.example.SecondSeminar.controller.post.dto.request.PostRequestDto;
import com.example.SecondSeminar.domain.Post;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.example.SecondSeminar.SecondSeminarApplication.postList;

@Service
public class PostService {
    public Long register(PostRequestDto request) {

        //Post 객체 생성
        Post newPost = new Post(
                request.getTitle(),
                request.getContent(),
                request.getWriter(),
                LocalDateTime.now()
        );

        //데이터 베이스에 저장
        postList.add(newPost);
        newPost.setId((long) postList.size());

        return newPost.getId();
    }

    public Post findById(Long id) {
        return postList.get(id.intValue()-1);
    }

    public Post findByTitle(String title) {
        for (Post post : postList) {
            if (post.getTitle().equals(title)) {
                return post;
            }
        }
        return null;
    }
}
