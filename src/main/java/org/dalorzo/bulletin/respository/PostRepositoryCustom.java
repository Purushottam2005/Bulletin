package org.dalorzo.bulletin.respository;

import org.dalorzo.bulletin.domain.Post;

import java.util.Date;
import java.util.List;

/**
 * @author Edwin Dalorzo
 */
public interface PostRepositoryCustom {
    public List<Post> allPostsForAuthorWithinDates(String author, Date from, Date to);
}
