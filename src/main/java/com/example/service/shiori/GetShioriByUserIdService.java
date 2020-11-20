package com.example.service.shiori;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.shiori.Shiori;
import com.example.mapper.shiori.ShioriMapper;

/**
 * ユーザIDからしおり情報を取得するサービス.
 * @author yuri.okada
 *
 */
@Service
@Transactional
public class GetShioriByUserIdService {
	
	@Autowired
	private ShioriMapper mapper;
	
	/**
	 * ユーザIDからしおり情報を取得する
	 * @param userId　ユーザID
	 * @return　しおり情報
	 */
	public List<Shiori> getShioriByUserId(Integer userId){
		List <Shiori> shioriList=mapper.selectByUserId(userId);
		if(shioriList.size()==0) {
			return null;
		}
		return shioriList;
	}
	

}
