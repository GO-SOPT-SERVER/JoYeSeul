package sopt.org.ThirdAdvanced.infrastructure;

import org.springframework.data.repository.CrudRepository;
import sopt.org.ThirdAdvanced.domain.Comment;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
}
