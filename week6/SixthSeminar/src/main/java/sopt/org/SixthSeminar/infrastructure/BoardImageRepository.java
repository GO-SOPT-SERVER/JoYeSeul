package sopt.org.SixthSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.SixthSeminar.domain.BoardImage;

public interface BoardImageRepository extends Repository<BoardImage, Long> {
    void save(BoardImage boardImage);
}
