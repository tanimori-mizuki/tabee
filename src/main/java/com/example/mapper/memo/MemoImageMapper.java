package com.example.mapper.memo;

import com.example.domain.memo.MemoImage;
import com.example.example.memo.MemoImageExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * メモ画像情報を操作するマッパー.
 * @author yuri.okada
 *
 */
@Mapper
public interface MemoImageMapper {
	
	/**
	 * 複数件のメモ画像情報を一括登録する.
	 * @param memoImageList メモ画像リスト
	 * @return　挿入件数
	 */
	int insertMemoImageList(@Param("memoImageList")List<MemoImage> memoImageList);

    int countByExample(MemoImageExample example);

    int deleteByExample(MemoImageExample example);

    /**
     * 主キーからメモ画像を削除する.
     * @param id　主キー
     * @return　成功件数
     */
    int deleteByPrimaryKey(Integer id);

    int insert(MemoImage record);

    int insertSelective(MemoImage record);

    List<MemoImage> selectByExample(MemoImageExample example);

    /**
     * 主キーからメモ画像を取得する.
     * @param id メモ画像ID
     * @return　メモ情報
     */
    MemoImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemoImage record, @Param("example") MemoImageExample example);

    int updateByExample(@Param("record") MemoImage record, @Param("example") MemoImageExample example);

    int updateByPrimaryKeySelective(MemoImage record);

    int updateByPrimaryKey(MemoImage record);
}