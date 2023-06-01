package sopt.org.ThirdAdvanced.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.ThirdAdvanced.controller.dto.request.UserSignUpDto;
import sopt.org.ThirdAdvanced.domain.User;
import sopt.org.ThirdAdvanced.exception.CustomException;
import sopt.org.ThirdAdvanced.infrastructure.UserRepository;
import sopt.org.ThirdAdvanced.response.FailStatus;
import sopt.org.ThirdAdvanced.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void signUp(UserSignUpDto request) {
        String nickname = request.getNickname();
        if (userRepository.existsByNickname(nickname)) {
            throw new DuplicateKeyException(FailStatus.CONFLICT_NICKNAME_EXCEPTION.getMessage());
        }

        User user = User.builder()
                .name(request.getName())
                .nickname(request.getNickname())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .build();

        userRepository.save(user);
    }

    @Transactional
    public User findById(Long userId) {
        User findUser = userRepository.findById(userId).orElseThrow(() -> new CustomException(FailStatus.NOT_FOUND_USER_EXCEPTION));
        return findUser;
    }
}
