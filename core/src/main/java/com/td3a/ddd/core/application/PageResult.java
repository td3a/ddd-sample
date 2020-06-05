package com.td3a.ddd.core.application;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页查询对象
 */
public class PageResult<T> implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 4289171840045697554L;

	private int pageNo = 1; //页码，默认是第一页
	private int pageSize = 10; //每页显示的记录数，默认是10
	private long totalRecord = 1; //总记录数
	private int totalPage = 1; //总页数
	private String order = ""; //排序
	private List<T> list = new ArrayList<>(pageSize);

	public PageResult(int pageNo, int pageSize, long totalRecord, List<T> list) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		this.list = list;
	}

	public PageResult() {
	}

	public PageResult<T> setList(List<T> list) {
		this.list = list;
		return this;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		totalPage = (int)(totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1);
		this.setTotalPage(totalPage);
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public List<T> getList() {
		return list;
	}

	@Override
	public String toString() {
		return "PageVo [pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalRecord=" + totalRecord + ", totalPage="
				+ totalPage + ", order=" + order + "]";
	}
}
