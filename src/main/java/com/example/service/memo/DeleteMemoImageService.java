package com.example.service.memo;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.common.UploadPathConfiguration;
import com.example.domain.memo.MemoImage;
import com.example.example.memo.MemoImageExample;
import com.example.mapper.memo.MemoImageMapper;

/**
 * メモ画像の削除を行うサービス.
 * @author yuri.okada
 *
 */
@Service
@Transactional
public class DeleteMemoImageService {
	
	@Autowired
	private MemoImageMapper memoImageMapper;
	
	@Autowired
	private UploadPathConfiguration uploadPathConfiguration;
	
	/**
	 *主キーから メモ画像を削除する
	 * @param memoImageId メモ画像ID
	 */
	public void deleteMemoImage(Integer memoImageId) {
		
		MemoImage memoImage=memoImageMapper.selectByPrimaryKey(memoImageId);
		String imagePath=memoImage.getImagePath();
		//他のメモで同じ画像が使われていないかチェックする
		MemoImageExample example=new MemoImageExample();
		example.createCriteria().andImagePathEqualTo(imagePath);
		List <MemoImage> memoImageList=memoImageMapper.selectByExample(example);
		
		//プロジェクト内の画像を削除する
		File file=new File(uploadPathConfiguration.getUploadPath() + "memo/"+imagePath);
		if(file.exists()&&memoImageList.size()==1) {
			if(file.delete()) {
				System.out.println("ファイル削除成功");
			}else {
				System.out.println("ファイル削除失敗");
			}
		}else {
			System.out.println("ファイルなしか他のメモでも使われています");
		}
		
		memoImageMapper.deleteByPrimaryKey(memoImageId);
	}

}
