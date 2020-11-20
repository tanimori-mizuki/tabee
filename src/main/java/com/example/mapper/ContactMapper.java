package com.example.mapper;

import com.example.domain.Contact;
import com.example.example.ContactExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ContactMapper {

    /**
     * 問合せ登録.
     *
     * @param contact 問合せ内容
     * @return
     */
    public int insert(Contact contact);


    int insertSelective(Contact record);
    List<Contact> selectByExample(ContactExample example);


    Contact selectByPrimaryKey(Integer id);


    int updateByExampleSelective(@Param("record") Contact record, @Param("example") ContactExample example);


    int updateByExample(@Param("record") Contact record, @Param("example") ContactExample example);


    int updateByPrimaryKeySelective(Contact record);


    int updateByPrimaryKey(Contact record);
}