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

    /**
     * メモ情報を挿入する.
     * 自動採番で主キーが返ってくる
     * @param record　メモ情報
     * @return　成功件数
     */
    int insertSelective(Memo record);

    List<Memo> selectByExample(MemoExample example);

    /**
     * 主キーからメモ情報を取得する.
     * @param id メモID
     * @return　メモ情報
     */
    Memo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Memo record, @Param("example") MemoExample example);

    int updateByExample(@Param("record") Memo record, @Param("example") MemoExample example);

    /**
     * 主キーでメモ情報を更新する.
     * @param record メモ情報
     * @return　更新件数
     */
    int updateByPrimaryKeySelective(Memo record);

    int updateByPrimaryKey(Memo record);
    
}