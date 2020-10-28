package com.example.mapper;

import com.example.domain.Tab;
import com.example.example.TabExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TabMapper {
    
	int countByExample(TabExample example);

    int deleteByExample(TabExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tab record);

    int insertSelective(Tab record);

    List<Tab> selectByExample(TabExample example);

    Tab selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tab record, @Param("example") TabExample example);

    int updateByExample(@Param("record") Tab record, @Param("example") TabExample example);

    int updateByPrimaryKeySelective(Tab record);

    int updateByPrimaryKey(Tab record);
}