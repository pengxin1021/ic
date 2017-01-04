package com.ic.entity;

public class Operator extends BaseEntity{

	private static final long serialVersionUID = -2231375381233667835L;

	/**
	 * 操作人id
	 */
	private Long userId;		

	/**
	 * 操作人名称
	 */
	private String userName;	

	/**
	 * 操作ip
	 */
	private String operIp;		

	/**
	 * 操作备注
	 */
	private String operMemo;	
	
	public Operator() {
		super();
	}
	
	public Operator(Long userId, String userName, String operIp, String operMemo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.operIp = operIp;
		this.operMemo = operMemo;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOperIp() {
		return operIp;
	}

	public void setOperIp(String operIp) {
		this.operIp = operIp;
	}

	public String getOperMemo() {
		return operMemo;
	}

	public void setOperMemo(String operMemo) {
		this.operMemo = operMemo;
	}

	@Override
	public Object getPrimaryKey() {
		return userId;
	}

}
