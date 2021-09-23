package com.valtek.backend_database;

import com.valtek.backend_database.persistence.component.caseuse.ComponentDependency;
import com.valtek.backend_database.persistence.entity.Cliente;
import com.valtek.backend_database.persistence.entity.DetalleCliente;
import com.valtek.backend_database.persistence.entity.Usuario;
import com.valtek.backend_database.domain.repository.UsuarioRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class BackendPartApplication implements CommandLineRunner {
	private final Log LOGGER = LogFactory.getLog(BackendPartApplication.class);
	private ComponentDependency componentDependency;
	private UsuarioRepository usuarioRepository;

	public BackendPartApplication(ComponentDependency componentDependency, UsuarioRepository usuarioRepository){
		this.componentDependency = componentDependency;
		this.usuarioRepository = usuarioRepository;
	}
	public static void main(String[] args) {

		SpringApplication.run(BackendPartApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//componentDependency.saludar();
		//savesUsersInDataBase();
		getInformationFromUser();
	}
	/*
	private void saveastran(){
		Usuario user1 = new Usuario();
	}
	 */
	public void saveCostumer(Cliente cliente, DetalleCliente detalleCliente){

	}
	private void getInformationFromUser(){
				usuarioRepository.findBynombreUsuario("prueba")
				.stream()
				.forEach(usuario -> System.out.println("el usuario es: "+ usuario));
	}
	private void savesUsersInDataBase(){
		Usuario user1 = new Usuario("prueba","prueba123");
		List<Usuario> list = Arrays.asList(user1);
		list.stream().forEach(usuarioRepository::save);
		//usuarioRepository.save(user1);
	}
}
