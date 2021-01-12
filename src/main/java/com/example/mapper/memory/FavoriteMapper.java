package com.example.mapper.memory;

import com.example.domain.memory.Favorite;
import com.example.example.memory.FavoriteExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FavoriteMapper {
    int countByExample(FavoriteExample example);
    
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

    List<Favorite> selectByExample(FavoriteExample example);

    Favorite selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Favorite record, @Param("example") FavoriteExample example);

    int updateByExample(@Param("record") Favorite record, @Param("example") FavoriteExample example);

    int updateByPrimaryKeySelective(Favorite record);

    int updateByPrimaryKey(Favorite record);
}