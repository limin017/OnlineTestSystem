package cn.hp.onlinetest.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Subject")
public class Subject {
	/*
	 * 试题ID
	 */
	private int subjectID;
	/*
	 * 试题题目
	 */
	private String subjectTitle;
	/*
	 * A选项
	 */
	private String subjectOptionA;
	/*
	 * B选项
	 */
	private String subjectOptionB;
	/*
	 * C选项
	 */
	private String subjectOptionC;
	/*
	 * D选项
	 */
	private String subjectOptionD;
	/*
	 * 试题答案
	 */
	private String subjectAnswer;
	/*
	 * 试题解析
	 */
	private String subjectParse;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getSubjectID() {
		return subjectID;
	}
	@Column
	public String getSubjectTitle() {
		return subjectTitle;
	}
	@Column
	public String getSubjectOptionA() {
		return subjectOptionA;
	}
	@Column
	public String getSubjectOptionB() {
		return subjectOptionB;
	}
	@Column
	public String getSubjectOptionC() {
		return subjectOptionC;
	}
	@Column
	public String getSubjectOptionD() {
		return subjectOptionD;
	}
	@Column
	public String getSubjectAnswer() {
		return subjectAnswer;
	}
	@Column
	public String getSubjectParse() {
		return subjectParse;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}

	public void setSubjectOptionA(String subjectOptionA) {
		this.subjectOptionA = subjectOptionA;
	}

	public void setSubjectOptionB(String subjectOptionB) {
		this.subjectOptionB = subjectOptionB;
	}

	public void setSubjectOptionC(String subjectOptionC) {
		this.subjectOptionC = subjectOptionC;
	}

	public void setSubjectOptionD(String subjectOptionD) {
		this.subjectOptionD = subjectOptionD;
	}

	public void setSubjectAnswer(String subjectAnswer) {
		this.subjectAnswer = subjectAnswer;
	}

	public void setSubjectParse(String subjectParse) {
		this.subjectParse = subjectParse;
	}
	@Override
	public String toString() {
		return "Subject [subjectID=" + subjectID + ", subjectTitle="
				+ subjectTitle + ", subjectOptionA=" + subjectOptionA
				+ ", subjectOptionB=" + subjectOptionB + ", subjectOptionC="
				+ subjectOptionC + ", subjectOptionD=" + subjectOptionD
				+ ", subjectAnswer=" + subjectAnswer + ", subjectParse="
				+ subjectParse + "]";
	}

}
