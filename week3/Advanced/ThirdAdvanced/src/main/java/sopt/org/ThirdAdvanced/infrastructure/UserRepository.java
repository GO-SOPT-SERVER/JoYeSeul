package sopt.org.ThirdAdvanced.infrastructure;

import org.springframework.data.repository.CrudRepository;
import sopt.org.ThirdAdvanced.domain.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByNickname(String nickname);
}
