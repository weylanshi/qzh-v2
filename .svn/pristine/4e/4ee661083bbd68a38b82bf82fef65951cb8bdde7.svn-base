package com.qzh.search.controller;

import com.huidong.qzh.util.common.util.QzhResult;
import com.qzh.search.model.Book;
import com.qzh.search.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/insertBook")
    public QzhResult insertBook() {
        bookService.insertBook();
        return QzhResult.ok();
    }

    @RequestMapping("/get/{id}")
    public QzhResult getBookById(@PathVariable String id) {
        Book bookById = bookService.getBookById(id);
        return QzhResult.ok();
    }

    @RequestMapping("/search")
    public QzhResult search() {
        bookService.search();
        return QzhResult.ok();
    }
}
