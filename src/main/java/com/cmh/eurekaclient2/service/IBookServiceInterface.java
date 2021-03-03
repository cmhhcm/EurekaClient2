package com.cmh.eurekaclient2.service;

import com.cmh.eurekaclient2.value.BookQueryCondition;
import com.cmh.eurekaclient2.vo.BookVO;

import java.util.List;

public interface IBookServiceInterface {
    void addBook(BookVO bookVO);

    void updateBook(BookVO bookVO);

    void deleteBook(Integer id);

    BookVO getById(Integer id);

    List<BookVO> getBooks(BookQueryCondition condition);
}
