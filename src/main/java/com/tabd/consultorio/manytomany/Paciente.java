package com.tabd.consultorio.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity
@Data
@NoArgsConstructor
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nome;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Sintoma> sintomas;

	public Paciente(String nome, List<Sintoma> sintomas) {
		super();
		this.nome = nome;
		this.sintomas = sintomas;
	}

	public Paciente() {

	}
}
