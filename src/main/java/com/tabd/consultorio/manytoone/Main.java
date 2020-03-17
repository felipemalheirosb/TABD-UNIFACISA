package com.tabd.consultorio.manytoone;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tabd.consultorio.manytoone.Medico;
import com.tabd.consultorio.manytoone.Paciente;

@SpringBootApplication
public class Main implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		
		Paciente paciente1 = new Paciente("João Silva");
		Paciente paciente2 = new Paciente("Maria Silva");
		List<Paciente> pacientes = new ArrayList<>();
		pacientes.add(paciente1);
		pacientes.add(paciente2);
		
		Medico medico = new Medico("Dr.House");

		medicoRepository.save(medico);
		
		for (Paciente pacienteOne : pacienteRepository.findAll()) {
			logger.info(pacienteOne.toString());
		}
	}
}
