package init.service;

import java.util.List;

import init.model.LibroDto;

public interface LibrosService {
	boolean alta(LibroDto libro);
	List<LibroDto> buscarLibroPorTema(String tema);
	LibroDto buscarLibroPorIsbn(int isbn);
}
