package com.ic.service.impl;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.ic.dao.BaseMapper;
import com.ic.entity.BaseEntity;
import com.ic.entity.BaseParam;
import com.ic.entity.Operator;
import com.ic.entity.PageResult;
import com.ic.service.BaseService;

public abstract class BaseServiceImpl<T, K> implements BaseService<T, K>{

	public abstract BaseMapper<T, K> getMapper();
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public K add(BaseEntity entity, Operator oper) {
		setCreateData(entity, oper);
		getMapper().insertSelective(entity);
		return (K) entity.getPrimaryKey();
	}

	@Transactional
	@Override
	public void update(BaseEntity entity, Operator oper) {
		setUpdateData(entity, oper);
		getMapper().updateByPrimaryKeySelective(entity);
		
	}

	@Transactional
	@Override
	public void delete(K id, Operator oper) {
		getMapper().deleteByPrimaryKey(id);
		
	}

	@Override
	public T get(K id) {
		return getMapper().selectiveByPrimaryKey(id);
	}

	@Override
	public PageResult<T> search(BaseParam param) {
		return new PageResult<T>(getMapper().search(param, param.getPageBounds()));
	}
	
	protected void setCreateData(BaseEntity entity, Operator oper) {
		if (entity instanceof BaseEntity) {
			Date now = new Date();
			((BaseEntity) entity).setCreateDate(now);
			((BaseEntity) entity).setCreateBy(oper.getUserId() + ":" + oper.getUserName());
			((BaseEntity) entity).setUpdateDate(now);
			((BaseEntity) entity).setUpdateBy(oper.getUserId() + ":" + oper.getUserName());
		}
	}

	protected void setUpdateData(BaseEntity entity, Operator oper) {
		if (entity instanceof BaseEntity) {
			Date now = new Date();
			((BaseEntity) entity).setUpdateDate(now);
			((BaseEntity) entity).setUpdateBy(oper.getUserId() + ":" + oper.getUserName());
		}
	}

}
