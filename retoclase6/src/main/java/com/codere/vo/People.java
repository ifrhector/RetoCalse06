package com.codere.vo;

import java.time.LocalDate;

/**
 * Value object for people
 * Generate an object with simple people information
 * @author HFR
 *
 */
public class People {

	String name;
	String lastName;
	String gender;
	LocalDate birthDay;
	String mxDate;
	String age;
	boolean married;
	
	/**
	 * Class constructor
	 */
	public People() {
		super();
	}

	/**
	 * Class constructor
	 * 
	 * @param name
	 * @param lastName
	 * @param gender
	 * @param birthDay
	 * @param mxDate
	 * @param age
	 * @param married
	 */
	public People(String name, String lastName, String gender, LocalDate birthDay, String mxDate, String age,
			boolean married) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDay = birthDay;
		this.mxDate = mxDate;
		this.age = age;
		this.married = married;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate d) {
		this.birthDay = d;
	}
	
	public String getMxDate() {
		return mxDate;
	}

	public void setMxDate(String mxDate) {
		this.mxDate = mxDate;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", lastName=" + lastName + ", gender=" + gender + ", birthDay=" + birthDay
				+ ", mxDate=" + mxDate + ", age=" + age + ", married=" + married + "]";
	}
	
	
}
