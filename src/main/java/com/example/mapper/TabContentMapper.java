package com.example.mapper;

import com.example.domain.TabContent;
import com.example.example.TabContentExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TabContentMapper {
    
	int countByExample(TabContentExample example);

    int deleteByExample(TabContentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TabContent record);

    int insertSelective(TabContent record);

    List<TabContent> selectByExample(TabContentExample example);

    TabContent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TabContent record, @Param("example") TabContentExample example);

    int updateByExample(@Param("record") TabContent record, @Param("example") TabContentExample example);

    int updateByPrimaryKeySelective(TabContent record);

    int updateByPrimaryKey(TabContent record);
}