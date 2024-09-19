package service;

import dao.ClientesDao;
import entities.Cliente;

public class ClientesServiceImpl implements ClientesService {
	ClientesDao clientesDao;
	@Override
	public boolean autenticar(String usuario, String password) {
		
		Cliente cliente= clientesDao.findByUsuario(usuario);
		return cliente!=null&cliente.getPassword().equals(password);
	}

}
