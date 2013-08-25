package org.dalorzo.bulletin.service;

import org.dalorzo.bulletin.domain.Post;
import org.dalorzo.bulletin.respository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Collection;

/**
 * @author Edwin Dalorzo
 */
@Controller
@RequestMapping("/bulletin")
public class BulletinService {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping(value="post", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Collection<Post> getAll(){
        return postRepository.findAll();
    }

    @RequestMapping(value="/post/{author}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Collection<Post> getPostByAuthor(@PathVariable String author){
        //return postRepository.findByAuthor(author);
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.add(Calendar.DATE, -30);
        end.add(Calendar.DATE, 30);
        return postRepository.allPostsForAuthorWithinDates(author,start.getTime(), end.getTime());
    }

    @RequestMapping(value="post", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post){
        return postRepository.save(post);
    }
}
