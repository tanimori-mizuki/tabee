package com.example.mapper.shiori;

import com.example.domain.shiori.Shiori;
import com.example.example.shiori.ShioriExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * しおり情報を操作するマッパークラス.
 * @author yuri.okada
 *
 */
@Mapper
public interface ShioriMapper {
	
	/**
	 * ログインユーザIDからしおり情報を取得する.
	 * @param userId ユーザID
	 * @return　しおり情報
	 */
	List <Shiori> selectByUserId(@Param("userId") Integer userId);

    int countByExample(ShioriExample example);

    int deleteByExample(ShioriExample example);

    /**
     * 主キーからしおりを削除する.
     * @param id しおりID
     * @return　成功件数
     */
    int deleteByPrimaryKey(Integer id);

    int insert(Shiori record);

    /**
     * しおり情報を登録する.
     * 自動採番で主キーが返ってくる
     * @param record
     * @return　成功件数
     */
    int insertSelective(Shiori record);

    List<Shiori> selectByExample(ShioriExample example);

    Shiori selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Shiori record, @Param("example") ShioriExample example);

    int updateByExample(@Param("record") Shiori record, @Param("example") ShioriExample example);

    int updateByPrimaryKeySelective(Shiori record);
    
    int updateByPrimaryKey(Shiori record);
}