
    /**  
    * @Title: Student.java
    * @Package com.harvey.entity
    * @Description: TODO(用一句话描述该文件做什么)
    * @author rose
    * @Email  rose@maizuo.com
    * @date 2016年3月25日
    * @version V1.0  
    */
    
package com.harvey.entity;


    /**
 * @ClassName: Student
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author rose
 * @Email  rose@maizuo.com
 * @date 2016年3月25日
 *
 */

public class Student {
	private String name;
	private int id;
	private String grade;
	private double salary;
	/**
	 * @return name
	 */
	
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return id
	 */
	
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return grade
	 */
	
	public String getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * @return salary
	 */
	
	public double getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	/**
	 * @return age
	 */
	
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
}
