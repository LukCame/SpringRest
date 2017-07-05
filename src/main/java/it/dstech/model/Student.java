package it.dstech.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private int id;
		
	private int eta;
	
	private String nome;
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="studenti",cascade=CascadeType.ALL)
	private List<Course> corsi;
	
	public Student(){
		this.corsi=new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Course> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Course> corsi) {
		this.corsi = corsi;
	}
}
