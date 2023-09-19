package com.example.demo.service;

import com.example.demo.models.Blogs;
import com.example.demo.repositories.BlogsRepository;
import com.example.demo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogsService {

    private final BlogsRepository blogsRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public BlogsService(BlogsRepository blogsRepository, UsersRepository usersRepository) {
        this.blogsRepository = blogsRepository;
        this.usersRepository = usersRepository;
    }

    public Blogs save(Blogs blogs) {

        return blogsRepository.save(blogs);
    }

    public List<Blogs> findAllBlogs() {

        return blogsRepository.findAll();
    }

    public Blogs updateBlogs(Blogs blogs) {
        Blogs existingBlogs = blogsRepository.findById(blogs.getId()).orElseThrow();
        existingBlogs.setId(blogs.getId());
        existingBlogs.setAuthor(blogs.getAuthor());
        existingBlogs.setTitle(blogs.getTitle());
        existingBlogs.setText(blogs.getText());
        existingBlogs.setPostedOn(blogs.getPostedOn());
        return blogsRepository.save(existingBlogs);
    }

    public String deleteById(Long blogsId) {
        blogsRepository.deleteById(blogsId);
        return "post deleted";
    }

}
