package it.dstech.model;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Course {

	@Id
	@GeneratedValue
	private int id;

	private String nome;

	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="st_co",joinColumns=@JoinColumn(name="id_corso",referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="id_studente",referencedColumnName="id"))
	@JsonIgnore
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

//	@Override
//	public int hashCode() {
//		return this.id;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if(obj==null|!(obj instanceof Course)){
//			return false;
//		}
//		Course course=(Course) obj;
//		if(course.getId()==this.id){
//			return true;
//		}else{
//			return false;
//		}
//	}


}
