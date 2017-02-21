package com.example.service.producer.dao;

import java.util.Map;

class SqlAndParams {
	private String sql;
	private Map<String, Object> params;
	
	public SqlAndParams(){
		
	}
	
	public SqlAndParams(String sql, Map<String, Object> params) {
		super();
		this.sql = sql;
		this.params = params;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
}
