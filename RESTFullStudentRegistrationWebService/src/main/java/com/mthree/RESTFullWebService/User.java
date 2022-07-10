package com.mthree.RESTFullWebService;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "usr") //JPA - Java Persistence API
public class User implements Serializable {
	@Id
	private Integer id;
	@Size(min=3,message="Name must have atleast 3 chars")
	@Column
	private String name;
	@Temporal(value = TemporalType.DATE)
//	@JsonFormat(pattern = "yyyy-MM-dd")
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private String age;
	private String mobile;
	private String address;
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String name, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.age = age;
		this.mobile = mobile;
		this.address = address;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthday=" + birthday + ", age=" + age + ", mobile=" + mobile
				+ ", address=" + address + "]";
	}

}

