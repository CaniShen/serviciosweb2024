package service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dao.VuelosDao;
import entities.Vuelo;
import model.VueloDto;
import utilidades.Mapeador;
@Service
public class VuelosServiceImpl implements VuelosService {
	VuelosDao vuelosDao;
	Mapeador mapeador;
	

	public VuelosServiceImpl(VuelosDao vuelosDao, Mapeador mapeador) {
		super();
		this.vuelosDao = vuelosDao;
		this.mapeador = mapeador;
	}

	@Override
	public List<VueloDto> buscarVuelosPorPlazasDestino(int plazas, String destino) {
		return vuelosDao.findByPlazasDestino(plazas, destino)//List<Vuelo>
				.stream()
				.map(v->mapeador.vueloEntityToDto(v))
				.toList();

	}

	@Override
	public void actualizarVuelo(VueloDto vuelo) {
		VueloDto vueloActualizado= buscarPorId(vuelo.getIdvuelo());
		if (vueloActualizado !=null) {
			vuelosDao.updatVuelo(mapeador.vueloDtoToEntity(vueloActualizado));
		}
	
	}

	@Override
	public VueloDto buscarPorId(int id) {
	/*	Vuelo vueloAux= vuelosDao.findById(id)
				.orElse(null);
		if(vueloAux != null) {
			return mapeador.vueloEntityToDto(vueloAux);
		}
		return null;
	}*/
		;
		return mapeador.vueloEntityToDto(vuelosDao.findById(id).orElse(null));

	}
}
