package it.dstech.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue
	private int id;

	private String nome;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="st_co",joinColumns=@JoinColumn(name="id_studente",referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="id_corso",referencedColumnName="id"))
	private List<Student> studenti;


	public Course(){
		this.studenti=new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}


}
