package com.example.lab6_20242_20210779_h791.repository;
import com.example.lab6_20242_20210779_h791.entity.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventosRepository extends JpaRepository<Eventos, Integer>{

}
