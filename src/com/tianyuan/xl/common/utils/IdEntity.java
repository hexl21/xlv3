package com.tianyuan.xl.common.utils;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

///**
// * 统一定义id的entity基类.
// * 
// * 基类统一定义id的属性名称、数据类型、列名映射及生成策略.
// * Oracle需要每个Entity独立定义id的SEQUCENCE时，不继承于本类而改为实现一个Idable的接口。
// * 
// * @author hexl
// */
//@MappedSuperclass
//public abstract class IdEntity {
//
//	protected Long id;
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

@MappedSuperclass
public class IdEntity {
	protected String id;
	@Id
	@Column(name="ID", length=32)
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
//	private Integer id;
//	@Id
//	@GeneratedValue(strategy = IDENTITY)
//	@Column(name = "ID", unique = true, nullable = false)
//	public Integer getId() {
//		return this.id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
}
