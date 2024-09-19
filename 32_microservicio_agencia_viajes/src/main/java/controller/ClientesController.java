package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import model.ClienteDto;
import service.ClientesService;


@CrossOrigin("*")//(methods = {RequestMethod.GET})
@RestController
public class ClientesController {
	@Autowired
	ClientesService clientesService;

	public ClientesController(ClientesService clientesService) {
		super();
		this.clientesService = clientesService;
	}
	@GetMapping(value = "/autenticar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClienteDto autenticar(@RequestParam String usuario,@RequestParam String password) {
		return clientesService.autenticar(usuario, password);
	}
	@PostMapping(value = "/alta", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void altaUsuario(@RequestBody ClienteDto cliente) {
		clientesService.altaUsuario(cliente);
	}
	@GetMapping(value = "/buscar/{usuario}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClienteDto buscarCliente(@PathVariable("usuario") String usuario) {
		return clientesService.buscarCliente(usuario);
	}
	
}
