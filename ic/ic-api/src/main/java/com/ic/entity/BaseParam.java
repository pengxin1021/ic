package com.ic.entity;

import java.io.Serializable;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public class BaseParam implements Serializable{

	private static final long serialVersionUID = -7341577973969310725L;

	/**
	 * page number
	 */
	private int page = 1;	
	
	/**
	 * page size
	 */
	private int pageSize = 10; 	
	
	/**
	 * orders
	 * format : time.asc,id.desc
	 */
	private String orders;	
	
	/**
	 * Whether to calculate the total number 
	 */
	private boolean autoCount = false;	
	
	/**
	 * 获取mybatis分页对象
	 * @return PageBounds
	 */
	public PageBounds getPageBounds(){
		if(page == 0)
			return new PageBounds();
		else
			return new PageBounds(page,pageSize, Order.formString(orders), autoCount);
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrders() {
		return orders;
	}

	public void setOrders(String orders) {
		this.orders = orders;
	}

	public boolean isAutoCount() {
		return autoCount;
	}

	public void setAutoCount(boolean autoCount) {
		this.autoCount = autoCount;
	}
	
	
}
