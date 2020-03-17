package com.tabd.consultorio.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.tabd.consultorio.onetomany.Medico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Entity
@Data
@NoArgsConstructor
@ToString(exclude = "cadastro")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nome;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "paciente_cadastro_id")
	private CadastroPaciente cadastro;
	
	@Id
	@ManyToOne
	@JoinColumn
	private Medico medico;
	
	public Paciente(String nome, CadastroPaciente cadastro) {
		this.nome = nome;
		this.cadastro = cadastro;
	}
	
	public Paciente() {
		
	}
}
