package com.example.controller.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.memo.Memo;
import com.example.service.memo.GetMomeListService;

/**
 * メモ一覧表示のコントローラー.
 * @author yuri.okada
 *
 */
@RestController
@RequestMapping("/memo")
public class ShowMemoListController {
	
	@Autowired
	private GetMomeListService getMemoListService;
	
	/**
	 * メモ一覧を表示する.
	 * @param shioriId　しおりID
	 * @return　メモ一覧
	 */
	@GetMapping("")
	public List<Memo> showMemoList(@RequestParam Integer shioriId) {
		//RequestParamなくてもパラメータは渡せる
		List <Memo> memoList=getMemoListService.getMemoList(shioriId);
		return memoList;
	}

}
