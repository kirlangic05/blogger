package com.my_blog.blogger.service;

import com.my_blog.blogger.repository.BlogRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.my_blog.blogger.model.Blog;

import java.util.List;

@Service
@Transactional
public class BlogService {
    public BlogService(BlogRepository repo) {
        this.repo = repo;
    }

   private final BlogRepository repo;

    public List<Blog> findAllBlog() {
        return repo.findAll();
    }

    public Blog findBlogById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException(id + " -> This id doesn't exist"));
    }

    public Blog saveBlog(Blog blog) {
        return repo.save(blog);
    }

    public void deleteBlog(Long id) {
        repo.deleteById(id);
    }

//    public Blog editBlog(Blog blog, Long id) {
//        blog.setId(id);
//        return repo.save(blog);
//    }

    public Blog editBlog(Blog requestBlog, Long id) {
        Blog existingBlog = repo.findById(requestBlog.getId()).orElseThrow(() -> new RuntimeException(id + " -> This id doesn't exist"));
        existingBlog.setUseras(requestBlog.getUseras());
        existingBlog.setTitle(requestBlog.getTitle());
        existingBlog.setDescription(requestBlog.getDescription());
       return repo.save(existingBlog);
    }

}
