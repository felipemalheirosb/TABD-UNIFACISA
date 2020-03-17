package com.tabd.consultorio.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Entity
@Data
@NoArgsConstructor
@ToString(exclude = "pacientes")
public class Medico {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
	private List<Paciente> pacientes;

	public Medico(String nome, List<Paciente> pacientes) {
		this.nome = nome;
		this.pacientes = pacientes;
	}

	
}
