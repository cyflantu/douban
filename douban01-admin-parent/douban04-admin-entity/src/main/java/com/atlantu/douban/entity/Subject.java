package com.atlantu.douban.entity;

public class Subject {
	private String subjectNmae;
	private Integer subjectScore;
	public Subject() {
	
	}
	public Subject(String subjectNmae, Integer subjectScore) {
		super();
		this.subjectNmae = subjectNmae;
		this.subjectScore = subjectScore;
	}
	@Override
	public String toString() {
		return "Subject [subjectNmae=" + subjectNmae + ", subjectScore=" + subjectScore + "]";
	}
	public String getSubjectNmae() {
		return subjectNmae;
	}
	public void setSubjectNmae(String subjectNmae) {
		this.subjectNmae = subjectNmae;
	}
	public Integer getSubjectScore() {
		return subjectScore;
	}
	public void setSubjectScore(Integer subjectScore) {
		this.subjectScore = subjectScore;
	}
	
	
	
	
}
