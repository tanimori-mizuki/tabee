package com.example.mapper.memory;

import com.example.domain.memory.Favorite;
import com.example.example.memory.FavoriteExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FavoriteMapper {
    int countByExample(FavoriteExample example);
    
    /**
     * 思い出IDとユーザーIDでいいね削除
     * 
     * @param example
     * @return
     */
    int deleteByExample(FavoriteExample example);

    int deleteByPrimaryKey(Integer id);

    /**
     * いいねする.
     * 
     * @param record
     * @return
     */
    int insert(Favorite record);

    int insertSelective(Favorite record);

    /**
     * 思い出IDとユーザーIDでいいね検索.
     * 
     * @param example
     * @return
     */
    List<Favorite> selectByExample(FavoriteExample example);

    Favorite selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Favorite record, @Param("example") FavoriteExample example);

    int updateByExample(@Param("record") Favorite record, @Param("example") FavoriteExample example);

    int updateByPrimaryKeySelective(Favorite record);

    int updateByPrimaryKey(Favorite record);
}