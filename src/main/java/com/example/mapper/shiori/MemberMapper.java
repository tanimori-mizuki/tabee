package com.example.mapper.shiori;

import com.example.domain.shiori.Member;
import com.example.example.shiori.MemberExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * メンバー情報のマッパー.
 * @author yuri.okada
 *
 */
@Mapper
public interface MemberMapper {

    int countByExample(MemberExample example);

    int deleteByExample(MemberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Member record);

    /**
     * メンバー情報を登録する.
     * @param record
     * @return 成功件数
     */
    int insertSelective(Member record);

    List<Member> selectByExample(MemberExample example);

    Member selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByExample(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}