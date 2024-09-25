package init.service;

import java.util.List;

import org.springframework.stereotype.Service;

import init.dao.CursosDao;
import init.model.Curso;
@Service
public class CursosServiceImpl implements CursosService {
	CursosDao cursosDao;
	
	
	public CursosServiceImpl(CursosDao cursosDao) {
		super();
		this.cursosDao = cursosDao;
	}

	@Override
	public boolean guardarCurso(Curso curso) {
		if(cursosDao.findByCurso(curso.getCurso())!=null) {
			cursosDao.save(curso);
			return true;
		}
		return false;
	}

	@Override
	public List<Curso> cursoPorDuracionMaxima(int max) {
	
		return cursosDao.findByDuracionMax(max);
	}

	@Override
	public List<Curso> catalogo() {
		return cursosDao.findAll();
	}

	@Override
	public boolean eliminarCurso(String curso) {
		if(cursosDao.findByCurso(curso)==null) {
			return false;
		}
		cursosDao.deleteByCurso(curso);
		return true;
	}

}
