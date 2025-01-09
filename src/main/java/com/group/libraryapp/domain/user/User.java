package com.group.libraryapp.domain.user;

import com.group.libraryapp.domain.user.loanHistory.UserLoanHistory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    @Column(nullable = false, length = 20, name = "name")
    private String name;
    private Integer age;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserLoanHistory> userLoanHistories = new ArrayList<>();

    protected User() {}

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public User(String name, Integer age) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
        }
        this.name = name;
        this.age = age;
    }

    public void updateName(String name){
        this.name = name;
    }

    public void loanBook(String bookName){
        this.userLoanHistories.add(new UserLoanHistory(this, bookName));
    }

    public void returnBook(String bookName){
        List<UserLoanHistory> targetHistories = this.userLoanHistories.stream().filter(history -> history.getBookName().equals(bookName)).collect(Collectors.toList());
        UserLoanHistory targetHistory = targetHistories.stream().filter(history -> !history.isReturn()).findFirst().orElseThrow(IllegalArgumentException::new);

        targetHistory.doReturn();
    }
}
