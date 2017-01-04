package com.ic.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ic.entity.BaseEntity;
import com.ic.entity.BaseParam;

public interface BaseMapper<T, K> {

	public int insertSelective(BaseEntity entity);
	
	public T selectiveByPrimaryKey(K id);
	
	public int deleteByPrimaryKey(K id);
	
	public int updateByPrimaryKeySelective(BaseEntity entity);
	
	List<T> search(BaseParam param, PageBounds page);
}
