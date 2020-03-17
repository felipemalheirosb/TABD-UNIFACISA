package com.tabd.consultorio.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tabd.consultorio.manytomany.Paciente;

@SpringBootApplication
public class Main implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private SintomaRepository sintomaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		
		Sintoma sintoma1 = new Sintoma("Febre");
		Sintoma sintoma2 = new Sintoma("Coriza");
		List<Sintoma> sintomas = new ArrayList<>();
		sintomas.add(sintoma1);
		sintomas.add(sintoma2);
		
		Paciente paciente = new Paciente("José", sintomas);

		pacienteRepository.save(paciente);
		
		for (Paciente pacienteOne : pacienteRepository.findAll()) {
			logger.info(pacienteOne.toString());
		}
	}
}
