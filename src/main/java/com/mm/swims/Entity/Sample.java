package com.mm.swims.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="sample",schema = "postgres")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sample implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
  //  @DateTimeFormat(iso=ISO.DATE)

	@Column(name = "paying_date")
	private Date paying_date;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPaying_date() {
		return paying_date;
	}

	public void setPaying_date(Date paying_date) {
		this.paying_date = paying_date;
	}

}
