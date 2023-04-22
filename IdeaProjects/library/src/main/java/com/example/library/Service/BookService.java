package com.example.library.Service;

import com.example.library.Entity.Author;
import com.example.library.Entity.Book;
import com.example.library.Repository.AuthorRepository;
import com.example.library.Repository.BookRepository;
import com.example.library.RequestDto.BookRequestDto;
import com.example.library.ResponseDto.BookResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;

    public BookResponseDto addBook(BookRequestDto bookRequestDto){
 Book book = new Book();
 book.setTitle(bookRequestDto.getTitle());
 book.setPrice(bookRequestDto.getPrice());
 book.setGenre(bookRequestDto.getGenre());
 book.setIssued(false);
 //Author need to find from author repository & set to book

        Author author = authorRepository.findById(bookRequestDto.getAuthor_id()).get();

        book.setAuthor(author);

        //add book into authors id save book & author in repository author is parent so save him
        author.getBooks().add(book);
        authorRepository.save(author);

        //create response

        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setTitle(book.getTitle());
        bookResponseDto.setGenre(book.getGenre());
        bookResponseDto.setPrice(book.getPrice());

        return bookResponseDto;
    }
}
