package com.ic.service;

import com.ic.entity.BaseEntity;
import com.ic.entity.BaseParam;
import com.ic.entity.Operator;
import com.ic.entity.PageResult;

public interface BaseService<T,K> {

	/**
	 * 新增实体
	 * @param entity 实体
	 * @param oper 操作人
	 */
	public K add(BaseEntity entity, Operator oper);

	/**
	 * 更新实体
	 * @param entity 实体，id不能为空
	 * @param oper 操作人
	 */
	void update(BaseEntity entity, Operator oper);
	
	/**
	 * 删除实体
	 * @param id 实体id
	 * @param oper 操作人
	 */
	void delete(K id, Operator oper);

	/**
	 * 根据id获取实体对象
	 * @param id 实体id
	 * @return 实体对象entity
	 */
	T get(K id);

	/**
	 * 根据搜索条件参数进行数据查询
	 * 若分页参数page的containsTotalCount设置为true，则返回的是PageList对象
	 * 可以通过((PageList)list).getPaginator()获得分页器
	 * @param param 搜索条件参数
	 * @return 返回数据列表List
	 */
	PageResult<T> search(BaseParam param);
}
