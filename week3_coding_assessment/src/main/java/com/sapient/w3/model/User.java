package com.sapient.w3.model;

import java.io.Serializable
;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "User")
public class User implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
	private int id;
	
	
	@Column(name="name") 
	private String name;
	
	
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	private Address address;
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private List<Post> post;
 
	
	
	

}
