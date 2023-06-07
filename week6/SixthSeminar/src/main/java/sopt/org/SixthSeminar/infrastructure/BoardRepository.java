package sopt.org.SixthSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.SixthSeminar.domain.Board;

public interface BoardRepository extends Repository<Board, Long> {
    void save(Board board);
}
