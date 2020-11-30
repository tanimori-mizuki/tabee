package com.example.mapper.scrap;

import com.example.domain.scrap.Scrap;
import com.example.example.scrap.ScrapExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ScrapMapper {
	
	List<Scrap> findAll();

    int countByExample(ScrapExample example);

    int deleteByExample(ScrapExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Scrap record);

    int insertSelective(Scrap record);

    List<Scrap> selectByExample(ScrapExample example);

    Scrap selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Scrap record, @Param("example") ScrapExample example);

    int updateByExample(@Param("record") Scrap record, @Param("example") ScrapExample example);

    int updateByPrimaryKeySelective(Scrap record);

    int updateByPrimaryKey(Scrap record);
}