package com.tabd.consultorio.onetoone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	@Autowired
	private PacienteRepository pacienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		Paciente paciente = new Paciente("João Silva", new CadastroPaciente(123));

		pacienteRepository.save(paciente);

		for (Paciente pacienteOne : pacienteRepository.findAll()) {
			logger.info(pacienteOne.toString());
		}
	}
}
