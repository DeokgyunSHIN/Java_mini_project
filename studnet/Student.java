package it.korea.studnet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Student {

	private String stName;
	private int kor;
	private int eng;
	private int math;

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	// 총점
	public int getTotal() {
		return this.getKor() + this.getEng() + this.getMath();
	}

	// 평균
	public double getAvg() {
		return new BigDecimal((double) this.getTotal() / 3).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
}
