package com.example.mapper;

import com.example.domain.SplitMember;
import com.example.example.SplitMemberExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SplitMemberMapper {
    
	int countByExample(SplitMemberExample example);

    int deleteByExample(SplitMemberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SplitMember record);

    int insertSelective(SplitMember record);

    List<SplitMember> selectByExample(SplitMemberExample example);

    SplitMember selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SplitMember record, @Param("example") SplitMemberExample example);

    int updateByExample(@Param("record") SplitMember record, @Param("example") SplitMemberExample example);

    int updateByPrimaryKeySelective(SplitMember record);

    int updateByPrimaryKey(SplitMember record);
}