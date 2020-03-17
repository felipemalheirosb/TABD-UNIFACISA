package com.tabd.consultorio.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = "paciente")
public class CadastroPaciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "rg")
	private Integer rg;

	@OneToOne(mappedBy = "cadastro")
	private Paciente paciente;

	public CadastroPaciente(Integer rg) {
		super();
		this.rg = rg;
	}
	
	public CadastroPaciente() {
		
	}
	
}
