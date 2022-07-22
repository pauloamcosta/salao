package com.salao;

import com.salao.entity.Cliente;
import com.salao.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SalaoApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(SalaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Cliente cliente1 = new Cliente();
		cliente1.setNome("Paulo");
		cliente1.setEmail("Paulo@Teste");
		cliente1.setDataNascimento(LocalDate.now());
		cliente1.setTelefone("434234234");


		Cliente cliente2 = new Cliente();
		cliente2.setNome("PAvao");
		cliente2.setEmail("pavao@Teste");
		cliente2.setDataNascimento(LocalDate.now());
		cliente2.setTelefone("4342234");

		clienteRepository.save(cliente1);
		clienteRepository.save(cliente2);

	}
}
