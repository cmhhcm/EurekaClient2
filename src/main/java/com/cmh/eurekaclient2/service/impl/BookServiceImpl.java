package com.cmh.eurekaclient2.service.impl;

import com.cmh.eurekaclient2.mapper.BookMapper;
import com.cmh.eurekaclient2.service.IBookServiceInterface;
import com.cmh.eurekaclient2.value.BookQueryCondition;
import com.cmh.eurekaclient2.vo.BookVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookServiceImpl implements IBookServiceInterface {

    @Autowired
    private BookMapper bookMapper;

    @Override
//    @Transactional
    public void addBook(BookVO bookVO) {
        bookMapper.insert(bookVO);
    }

    @Override
    public void updateBook(BookVO bookVO) {
        if (bookVO == null) {
            log.info(" bookVo is null");
            return;
        }
        BookVO queryResult = bookMapper.getById(bookVO.getId());
        if (queryResult == null) {
            log.error("book is null");
            return;
        }
        bookMapper.update(bookVO);
    }

    @Override
    public void deleteBook(Integer id) {
        if (id == null) {
            log.info("id is null");
            return;
        }
        bookMapper.del(id);
    }

    @Override
    public BookVO getById(Integer id) {
        return bookMapper.getById(id);
    }

    @Override
    public List<BookVO> getBooks(BookQueryCondition condition) {
        return bookMapper.getBooks(condition);
    }
}
