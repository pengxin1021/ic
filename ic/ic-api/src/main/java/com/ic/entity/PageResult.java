package com.ic.entity;

import java.io.Serializable;
import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;

public class PageResult<T> implements Serializable {

	private static final long serialVersionUID = -8839534677254003868L;
	
	private List<T> items;
	
	private Paginator paginator;
	
	public PageResult() {
		super();
	}

	public PageResult(List<T> items) {
		this.items = items;
		if (items instanceof PageList){
			PageList<T> pageList = (PageList<T>)items;
			this.paginator = pageList.getPaginator();
		}
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public Paginator getPaginator() {
		return paginator;
	}

	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}
	
	

}
