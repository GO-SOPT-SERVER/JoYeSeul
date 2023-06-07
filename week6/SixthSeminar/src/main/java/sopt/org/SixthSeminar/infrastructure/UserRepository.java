package sopt.org.SixthSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.SixthSeminar.domain.User;

import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {
    void save(User user);

    Optional<User> findByEmail(String userEmail);
    Optional<User> findById(Long userId);
    boolean existsByEmail(String email);
}
