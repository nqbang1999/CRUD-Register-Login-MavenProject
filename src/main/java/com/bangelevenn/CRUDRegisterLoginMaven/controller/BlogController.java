package com.bangelevenn.CRUDRegisterLoginMaven.controller;

import com.bangelevenn.CRUDRegisterLoginMaven.model.Blog;
import com.bangelevenn.CRUDRegisterLoginMaven.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class BlogController {
    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/create-blog") //create-blog
    public String showCreateForm(Blog blog) {return "create-blog"; }

    @PostMapping("/create-blog")
    public String createBlog(@Valid Blog blog, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "create-blog";
        }
        blogRepository.save(blog);
        model.addAttribute("blogs", blogRepository.findAll());
        return "index";
    }

    @GetMapping("/blogs")
    public String showListBlogs(Model model) {
        model.addAttribute("blogs", blogRepository.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid blog id: "+ id));
        model.addAttribute("blog", blog);
        return "edit-student";
    }

    @PostMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") long id, @Valid Blog blog,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            blog.setId(id);
            return "edit-student";
        }
        blogRepository.save(blog);
        model.addAttribute("blogs", blogRepository.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable("id") long id, Model model) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid blog ID: "+ id));
        blogRepository.delete(blog);
        model.addAttribute("blogs", blogRepository.findAll());
        return "index";
    }










}
