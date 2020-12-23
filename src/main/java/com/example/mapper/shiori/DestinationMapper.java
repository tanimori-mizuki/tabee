package com.example.mapper.shiori;

import com.example.domain.shiori.Destination;
import com.example.example.shiori.DestinationExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 目的地のマッパー.
 * @author yuri.okada
 *
 */
@Mapper
public interface DestinationMapper {
	
	/**
	 * 複数件の目的地を一括登録する.
	 * @param destinationList　目的地リスト
	 * @return　挿入件数
	 */
	int insertDestinationList(@Param("destinationList")List <Destination> destinationList);

    int countByExample(DestinationExample example);

    int deleteByExample(DestinationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Destination record);

    int insertSelective(Destination record);

    List<Destination> selectByExample(DestinationExample example);

    Destination selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Destination record, @Param("example") DestinationExample example);

    int updateByExample(@Param("record") Destination record, @Param("example") DestinationExample example);

    int updateByPrimaryKeySelective(Destination record);

    int updateByPrimaryKey(Destination record);
}