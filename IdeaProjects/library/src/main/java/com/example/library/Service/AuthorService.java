package com.example.library.Service;

import com.example.library.Entity.Author;
import com.example.library.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public String addAuthor(Author author){
        authorRepository.save(author);
        return "Author Added Successfully";
    }
    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }



}
