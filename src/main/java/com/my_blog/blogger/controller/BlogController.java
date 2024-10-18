package com.my_blog.blogger.controller;

import com.my_blog.blogger.model.Blog;
import com.my_blog.blogger.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/blog")
@CrossOrigin(origins = "http://185.240.104.244/")
public class BlogController {
    BlogService service;

    @GetMapping("/getblog")
    public List<Blog> findAllBlog() {
        return service.findAllBlog();
    }

    @GetMapping("/getblog/{id}")
    public Blog findBlogById(@PathVariable Long id) {
        return service.findBlogById(id);
    }

    @PostMapping("/saveblog")
    public Blog saveBlog(@RequestBody Blog blog) {
        return service.saveBlog(blog);
    }

    @DeleteMapping("/deleteblog/{id}")
    public void deleteBlog(@PathVariable Long id) {
        service.deleteBlog(id);
    }

    @PutMapping("/editblog/{id}")
    public Blog editBlog(@RequestBody Blog blog, @PathVariable Long id) {
        return service.editBlog(blog, id);
    }
}

