package service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dao.VuelosDao;
import entities.Vuelo;
import jakarta.transaction.Transactional;
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

	public boolean actualizarVuelo(int idVuelo, int plazas) {
		VueloDto vueloActualizado = buscarPorId(idVuelo);
		if (vueloActualizado != null) {
			if (vueloActualizado.getPlazas() >= plazas) {
				vuelosDao.updateVuelo(idVuelo, plazas);
				return true;
			}

		}
		return false;
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
