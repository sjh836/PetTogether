package syu.DBproject.biz.member;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MemberVO
{
	private int mno;
	private String id;
	private String password;
	private String name;
	private String tel;
	private int sex; //1=����, 2=����
	private int age;
	private int role; //ȸ������. 0=�Ϲ�����, 9=������
	private int grade; //Ȱ������
	private Date regDate; //���Գ�¥
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@JsonIgnore
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@JsonIgnore
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", tel=" + tel + ", sex=" + sex
				+ ", age=" + age + ", role=" + role + ", grade=" + grade + ", regDate=" + regDate + "]";
	}
}
