package service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import dao.BuscadorDao;
import entities.Resultado;
import model.ResultadoDto;
import utilidades.Mapeador;
@Service("buscadorEstandar")
@Scope("singleton")
public class BuscadorServiceImpl implements BuscadorService {
	BuscadorDao buscadorDao;
	Mapeador mapeador;
	public BuscadorServiceImpl(BuscadorDao buscadorDao, Mapeador mapeador) {
		this.buscadorDao = buscadorDao;
		this.mapeador=mapeador;
	}

	@Override
	public List<ResultadoDto> buscar(String tematica) {
			return buscadorDao.findByTematica(tematica).stream()
					.map(r->mapeador.resultadoEntityToDto(r))
					.toList();
	
	}

	@Override
	public boolean agregar(ResultadoDto resultado) {
		Resultado r=mapeador.resultadoDtoToEntity(resultado);
		if(buscadorDao.findByUrl(r.getUrl())==null) {
			buscadorDao.save(r);
			return true;
		}
		return false;
	}

	@Override
	public ResultadoDto buscarPorUrl(String url) {
		Resultado r=buscadorDao.findByUrl(url);
		return r!=null?mapeador.resultadoEntityToDto(r):null; //如果 r 不为 null（即找到与给定 url 对应的记录），则调用 mapeador.resultadoEntityToDto(r) 方法，将 r 对象（可能是数据库实体 Resultado）转换为 ResultadoDto 并返回。
															 //	如果 r 为 null（即没有找到与该 url 对应的记录），则返回 null。
		
	}

	@Override
	public void eliminar(String url) {
		buscadorDao.deleteByUrl(url);
		
	}
}

