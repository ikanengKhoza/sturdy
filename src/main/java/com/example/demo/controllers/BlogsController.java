package com.example.demo.controllers;

import com.example.demo.models.Blogs;
import com.example.demo.service.BlogsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
@CrossOrigin
public class BlogsController {
    private final BlogsService blogService;

    public BlogsController(BlogsService blogService) {

        this.blogService = blogService;
    }

    @GetMapping(path = "/blogs")
    public List<Blogs> findAllBlogs() {
        return blogService.findAllBlogs();
    }

    @PostMapping(path = "/blogs")
    public Blogs saveBlogs(@RequestBody Blogs blogs) {
        return blogService.save(blogs);

    }

    @PutMapping(path = "{blogsId}")
    public Blogs updateBlogs(@RequestBody Blogs blogs) {
        return blogService.updateBlogs(blogs);
    }

    public String deleteById(Long blogsId) {
        blogService.deleteById(blogsId);
        return "deleted recipe";
    }
}
