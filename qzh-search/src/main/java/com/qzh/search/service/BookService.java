package com.qzh.search.service;

import com.qzh.search.model.Book;

public interface BookService {

    public void  insertBook();
    Book getBookById(String id);

    public void search();
}
