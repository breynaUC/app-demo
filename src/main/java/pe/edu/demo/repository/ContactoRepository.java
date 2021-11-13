package pe.edu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.demo.entity.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer>{

}
