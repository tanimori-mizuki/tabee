package com.example.mapper.dto;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.dto.ResetPassword;
import com.example.dto.ResetPasswordExample;

@Mapper
public interface ResetPasswordMapper {
    int countByExample(ResetPasswordExample example);

    int deleteByExample(ResetPasswordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ResetPassword record);

    int insertSelective(ResetPassword record);

    List<ResetPassword> selectByExample(ResetPasswordExample example);

    ResetPassword selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ResetPassword record, @Param("example") ResetPasswordExample example);

    int updateByExample(@Param("record") ResetPassword record, @Param("example") ResetPasswordExample example);

    int updateByPrimaryKeySelective(ResetPassword record);

    int updateByPrimaryKey(ResetPassword record);
}