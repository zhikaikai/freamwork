package com.hogae.freamwork.web.model;

import lombok.Data;

@Data
public class Page {

	/**
	 * 总条数
	 */
	private Long count;
	/**
	 * 当前页数
	 */
	private int pageNum = 1;
	/**
	 * 显示条数
	 */
	private int pageSize = 10;
	/**
	 * 分页总数
	 */
	private int pageCount;

	private int rowCount;//查询开始行

	public Page() {

	}

	public Page(Long count, int pageNum, int pageSize) {
		super();
		this.count = count;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.pageCount = (count.intValue() + pageSize - 1) / pageSize;
		this.rowCount = (pageNum - 1) * pageSize;
	}

	public Page(Long count, int pageNum) {
		super();
		this.count = count;
		this.pageCount = (count.intValue() + pageSize - 1) / pageSize;
		if (this.pageCount < pageNum) {
			this.pageNum = 1;
		} else {
			this.pageNum = pageNum <= 0 ? 1 : pageNum;
		}
		this.rowCount = (pageNum - 1) * pageSize;
	}

	public Page(Long count) {
		super();
		this.count = count;
		this.pageCount = (count.intValue() + pageSize - 1) / pageSize;
		this.rowCount = (pageNum - 1) * pageSize;
	}

	public void setCount(Long count) {
		this.count = count;
		this.pageCount = (count.intValue() + pageSize - 1) / pageSize;
		this.rowCount = (pageNum - 1) * pageSize;
	}

}
