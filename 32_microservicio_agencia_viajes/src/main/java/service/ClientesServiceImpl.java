package service;

import org.springframework.stereotype.Service;

import dao.ClientesDao;
import entities.Cliente;
import jakarta.transaction.Transactional;
import model.ClienteDto;
import utilidades.Mapeador;

@Service
public class ClientesServiceImpl implements ClientesService {
	ClientesDao clientesDao;
	Mapeador mapeador;

	public ClientesServiceImpl(ClientesDao clientesDao, Mapeador mapeador) {
		super();
		this.clientesDao = clientesDao;
		this.mapeador = mapeador;
	}

	@Override
	@Transactional
	public ClienteDto autenticar(String usuario, String password) {

		Cliente cliente = clientesDao.findByUsuario(usuario);
		if (cliente != null && cliente.getPassword().equals(password)) {
			return mapeador.clienteEntityToDto(cliente);
		}
		return null;
	}

	@Override
	@Transactional
	public void altaUsuario(ClienteDto cliente) {
		Cliente clienteEntity= mapeador.clienteDtoToEntity(cliente);
		clientesDao.save(clienteEntity);
		
	}

	@Override
	@Transactional
	public ClienteDto buscarCliente(String usuario) {
		Cliente clienteAux=clientesDao.findByUsuario(usuario);
		if(clienteAux != null) {
			return mapeador.clienteEntityToDto(clienteAux);
		}
		return null;
	}
}
