package com.group.libraryapp.controller.book;

import com.group.libraryapp.dto.book.BookCreateRequest;
import com.group.libraryapp.dto.book.BookLoanRequest;
import com.group.libraryapp.dto.book.BookReturnRequest;
import com.group.libraryapp.service.book.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public void saveBook(@RequestBody BookCreateRequest bookCreateRequest) {
        bookService.saveBook(bookCreateRequest);
    }

    @PostMapping("/book/loan")
    public void loanBook(@RequestBody BookLoanRequest bookLoanRequest) {
        bookService.loanBook(bookLoanRequest);
    }

    @PutMapping("/book/return")
    public void returnBook(@RequestBody BookReturnRequest bookReturnRequest) {
        bookService.returnBook(bookReturnRequest);
    }
}
