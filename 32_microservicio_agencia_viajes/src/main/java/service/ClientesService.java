package service;


import model.ClienteDto;

public interface ClientesService {
	ClienteDto autenticar(String usuario, String password);
	
	void altaUsuario(ClienteDto cliente);
	
	ClienteDto buscarCliente(String usuario);

}
