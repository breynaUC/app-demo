package pe.edu.demo.service;

import java.util.List;

import pe.edu.demo.entity.Contacto;

public interface ContactoService {
	Contacto create(Contacto contacto);
	Contacto update(Contacto contacto);
	Contacto read(int id);
	void delete(int id);
	List<Contacto> readAll();
}
