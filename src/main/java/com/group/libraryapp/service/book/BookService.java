package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.Book;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.loanHistory.UserLoanHistory;
import com.group.libraryapp.domain.user.loanHistory.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.BookCreateRequest;
import com.group.libraryapp.dto.book.BookLoanRequest;
import com.group.libraryapp.dto.book.BookReturnRequest;
import com.group.libraryapp.repository.book.BookMemoryRepository;
import com.group.libraryapp.repository.book.BookRepository;
import com.group.libraryapp.repository.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserLoanHistoryRepository userLoanHistoryRepository,  UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveBook(BookCreateRequest bookCreateRequest) {
        bookRepository.save(new Book(bookCreateRequest.getName()));
    }

    @Transactional
    public void loanBook(BookLoanRequest bookLoanRequest) {
        Book book = bookRepository.findByName(bookLoanRequest.getBookName()).orElseThrow(IllegalAccessError::new);

        if(userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)){
            throw new IllegalAccessError("이미 대출된 책입니다.");
        }

        User user = userRepository.findByName(bookLoanRequest.getUserName()).orElseThrow(IllegalArgumentException::new);
        user.loanBook(book.getName());

    }

    @Transactional
    public void returnBook(BookReturnRequest bookReturnRequest){
        User user = userRepository.findByName(bookReturnRequest.getUserName()).orElseThrow(IllegalArgumentException::new);

//        UserLoanHistory history = userLoanHistoryRepository.findByUserIdAndBookName(user.getId(), bookReturnRequest.getBookName()).orElseThrow(IllegalArgumentException::new);
//
//        history.doReturn();
        user.returnBook(bookReturnRequest.getBookName());
    }
}
