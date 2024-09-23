package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import entities.Vuelo;

import java.util.List;



public interface VuelosDao extends JpaRepository<Vuelo, Integer> {
	@Query("select v from Vuelo v where v.plazas >= ?1 and v.destino = ?2 ")
	List<Vuelo> findByPlazasDestino(int plazas, String destino );
	@Modifying
 	@Transactional
 	@Query("update Vuelo v Set v.plazas = v.plazas-?2 where v.id = ?1 and v.plazas >= ?2")
	void updateVuelo(int idVuelo, int plazas);
	
	
}
