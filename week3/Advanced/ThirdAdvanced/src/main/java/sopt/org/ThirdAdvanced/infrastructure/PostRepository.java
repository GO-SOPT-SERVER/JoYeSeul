package sopt.org.ThirdAdvanced.infrastructure;

import org.springframework.data.repository.CrudRepository;
import sopt.org.ThirdAdvanced.domain.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
}
