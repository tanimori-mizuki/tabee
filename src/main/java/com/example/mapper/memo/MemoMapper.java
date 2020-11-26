package com.example.mapper.memo;

import com.example.domain.memo.Memo;
import com.example.example.memo.MemoExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * メモテーブルを操作するマッパークラス
 * @author yuri.okada
 *
 */
@Mapper
public interface MemoMapper {
	
	/**
	 * しおりIDからメモ情報を取得する.
	 * @param shioriId　しおりID
	 * @return　メモ
	 */
	List <Memo> selectByshioriId(@Param("shioriId") Integer shioriId);

    int countByExample(MemoExample example);

    int deleteByExample(MemoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Memo record);

    int insertSelective(Memo record);

    List<Memo> selectByExample(MemoExample example);

    Memo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Memo record, @Param("example") MemoExample example);

    int updateByExample(@Param("record") Memo record, @Param("example") MemoExample example);

    int updateByPrimaryKeySelective(Memo record);

    int updateByPrimaryKey(Memo record);
    
}