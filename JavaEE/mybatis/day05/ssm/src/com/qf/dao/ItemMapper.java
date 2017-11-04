package com.qf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qf.pojo.Items;
import com.qf.vo.QueryVo;

public interface ItemMapper {
	
	List<Items> selectItems();
	
	Items selectItemById(Integer id);
	
	List<Items> selectByPrice(QueryVo vo);
		/**
		 * 数组的话  不加@Param("ids")  注解的话  默认是array
		 * @param ids
		 */
	void deletByIds(@Param("ids")Integer[] ids);

}
