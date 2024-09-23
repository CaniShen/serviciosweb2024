package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import entities.Reserva;

public interface ReservasDao extends JpaRepository<Reserva, Integer> {
	
	List<Reserva> findByCliente(String usuario);
}
