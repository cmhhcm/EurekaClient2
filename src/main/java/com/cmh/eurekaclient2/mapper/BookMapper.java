package com.cmh.eurekaclient2.mapper;

import com.cmh.eurekaclient2.value.BookQueryCondition;
import com.cmh.eurekaclient2.vo.BookVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    boolean insert(BookVO bookVO);

    boolean update(BookVO bookVO);

    void del(Integer id);

    BookVO getById(Integer id);

    List<BookVO> getBooks(BookQueryCondition condition);
}
