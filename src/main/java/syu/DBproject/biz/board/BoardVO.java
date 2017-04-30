package syu.DBproject.biz.board;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BoardVO
{
	private int bno; //�۹�ȣ
	private String subject; //���Ӹ�
	private String title; //������
	private String writer; //�ۼ���
	private String id; //�ۼ��� ���̵�
	private String content; //�۳���
	private int count; //��ȸ��
	private Date regDate; //�۵�ϳ�¥
	private String searchCondition; //�˻� ����
	private String searchKeyword; //�˻� Ű����
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@JsonIgnore
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	@JsonIgnore
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", subject=" + subject + ", title=" + title + ", writer=" + writer + ", content="
				+ content + ", count=" + count + ", date=" + regDate + "]";
	}
}
