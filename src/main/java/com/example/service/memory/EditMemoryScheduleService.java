package com.example.service.memory;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.example.domain.memory.ScheForPost;
import com.example.form.memory.EditMemoryScheduleForm;
import com.example.mapper.memory.ScheForPostMapper;

/**
 * 思い出投稿用スケジュール編集用サービス.
 * 
 * @author masashi.nose
 *
 */
@Service
@Transactional
public class EditMemoryScheduleService {

	@Autowired
	private ScheForPostMapper scheForPostMapper;

	/**
	 * 思い出投稿用スケジュールを編集.
	 * 
	 * @param form フォーム.
	 */
	public void editMemorySchedule(EditMemoryScheduleForm form) {
		ScheForPost scheForPost = new ScheForPost();
		Integer id = Integer.parseInt(form.getId());
		Integer userId = Integer.parseInt(form.getUserId());
		Integer shioriId = Integer.parseInt(form.getShioriId());

		scheForPost.setId(id);
		scheForPost.setTitle(form.getTitle());

		if (!ObjectUtils.isEmpty(form.getStartAt())) {
			scheForPost.setStartAt(LocalDateTime.parse(form.getStartAt()));
		}

		if (!ObjectUtils.isEmpty(form.getFinishAt())) {
			scheForPost.setFinishAt(LocalDateTime.parse(form.getFinishAt()));
		}
		scheForPost.setIconPath(form.getIconPath());
		scheForPost.setShioriId(shioriId);
		scheForPost.setAddress(form.getAddress());
		scheForPost.setUrl(form.getUrl());
		scheForPost.setMemo(form.getMemo());

		if (!ObjectUtils.isEmpty(form.getCost())) {
			scheForPost.setCost(Integer.parseInt(form.getCost()));
		}

		scheForPost.setUpdaterId(userId);
		scheForPost.setUpdatedAt(LocalDateTime.now());
		
		scheForPostMapper.updateByPrimaryKeySelective(scheForPost);

	}
}
