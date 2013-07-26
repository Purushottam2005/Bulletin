package org.dalorzo.bulletin.respository;

import org.dalorzo.bulletin.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Edwin Dalorzo
 */
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAuthor(String author);

    @Transactional
    Post save(Post post);
}
