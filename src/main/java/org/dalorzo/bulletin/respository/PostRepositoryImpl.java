package org.dalorzo.bulletin.respository;

import org.dalorzo.bulletin.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

/**
 * @author Edwin Dalorzo
 */
@Component
public class PostRepositoryImpl implements PostRepositoryCustom {

    @Autowired
    private EntityManager em;

    @Override
    public List<Post> allPostsForAuthorWithinDates(String author, Date from, Date to) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery c = cb.createQuery(Post.class);
        Root post = c.from(Post.class);

        Predicate authorPredicate = cb.equal(post.get("author"),author);
        Predicate dateRangePredicate = cb.between(post.get("publishDate"), from, to);

        c.select(post).where(cb.and(authorPredicate, dateRangePredicate));
        TypedQuery<Post> q = em.createQuery(c);

        return q.getResultList();
    }
}
