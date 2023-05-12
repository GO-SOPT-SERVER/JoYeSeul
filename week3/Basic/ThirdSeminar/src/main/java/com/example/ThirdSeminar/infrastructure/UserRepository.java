package com.example.ThirdSeminar.infrastructure;

import com.example.ThirdSeminar.domain.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {
    void save(User user);
}
