package sopt.org.SixthSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.SixthSeminar.controller.dto.request.BoardRequestDto;
import sopt.org.SixthSeminar.domain.Board;
import sopt.org.SixthSeminar.domain.User;
import sopt.org.SixthSeminar.exception.Error;
import sopt.org.SixthSeminar.exception.model.NotFoundException;
import sopt.org.SixthSeminar.infrastructure.BoardRepository;
import sopt.org.SixthSeminar.infrastructure.UserRepository;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public void create(Long userId, BoardRequestDto request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        Board newBoard = Board.newInstance(
                user,
                request.getTitle(),
                request.getContent(),
                request.getIsPublic()
        );

        boardRepository.save(newBoard);
    }
}
