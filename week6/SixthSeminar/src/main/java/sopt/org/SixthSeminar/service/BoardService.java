package sopt.org.SixthSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.SixthSeminar.controller.dto.request.BoardFileListDto;
import sopt.org.SixthSeminar.controller.dto.request.BoardRequestDto;
import sopt.org.SixthSeminar.domain.Board;
import sopt.org.SixthSeminar.domain.BoardImage;
import sopt.org.SixthSeminar.domain.User;
import sopt.org.SixthSeminar.exception.Error;
import sopt.org.SixthSeminar.exception.model.NotFoundException;
import sopt.org.SixthSeminar.infrastructure.BoardImageRepository;
import sopt.org.SixthSeminar.infrastructure.BoardRepository;
import sopt.org.SixthSeminar.infrastructure.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final BoardImageRepository boardImageRepository;

    @Transactional
    public void create(Long userId, String boardThumbnailImageUrl, BoardRequestDto request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        Board newBoard = Board.builder()
                .user(user)
                .title(request.getTitle())
                .content(request.getContent())
                .isPublic(request.getIsPublic())
                .thumbnail(boardThumbnailImageUrl)
                .build();

        BoardImage boardImage = BoardImage.newInstance(
                boardThumbnailImageUrl,
                newBoard
        );

        boardRepository.save(newBoard);
        boardImageRepository.save(boardImage);
    }

    @Transactional
    public void createList(Long userId, List<String> boardThumbnailImageUrls, BoardFileListDto request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        Board newBoard = Board.builder()
                .user(user)
                .title(request.getTitle())
                .content(request.getContent())
                .isPublic(request.getIsPublic())
                .build();

        boardRepository.save(newBoard);

        for (String boardThumbnailImageUrl : boardThumbnailImageUrls) {
            BoardImage boardImage = BoardImage.newInstance(
                    boardThumbnailImageUrl,
                    newBoard
            );
            boardImageRepository.save(boardImage);
        }


    }
}
