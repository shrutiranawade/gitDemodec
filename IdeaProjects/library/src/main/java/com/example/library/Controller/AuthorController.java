package com.example.library.Controller;

import com.example.library.Entity.Author;
import com.example.library.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("/add_author")
    public String addAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }
    @GetMapping("/get_authors")
    public List<Author>getAuthors(){
       return authorService.getAuthors();
    }
}
