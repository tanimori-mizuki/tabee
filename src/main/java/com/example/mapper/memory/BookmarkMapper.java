package com.example.mapper.memory;

import com.example.domain.memory.Bookmark;
import com.example.example.memory.BookmarkExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BookmarkMapper {
    int countByExample(BookmarkExample example);

    int deleteByExample(BookmarkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bookmark record);

    int insertSelective(Bookmark record);

    List<Bookmark> selectByExample(BookmarkExample example);

    Bookmark selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bookmark record, @Param("example") BookmarkExample example);

    int updateByExample(@Param("record") Bookmark record, @Param("example") BookmarkExample example);

    int updateByPrimaryKeySelective(Bookmark record);

    int updateByPrimaryKey(Bookmark record);
}