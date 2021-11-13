package pe.edu.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.demo.entity.Contacto;
import pe.edu.demo.service.ContactoService;


@RestController
public class ContactoController {
	@Autowired
	private ContactoService productoService;

	@GetMapping("/all")
	public ResponseEntity<List<Contacto>> getContacto(){
		try {
			List<Contacto> lista = new ArrayList<>();
			lista = productoService.readAll();
			if(lista.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(lista, HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Contacto> getProducto(@PathVariable("id") int id){
		Contacto p = productoService.read(id);
		if(p.getId()>0) {
			return new ResponseEntity<>(p, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			productoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/create")
	public ResponseEntity<Contacto> save(@RequestBody Contacto prod){
		try {
			Contacto pro = productoService.create(prod);
			return new ResponseEntity<>(pro, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Contacto> update(@RequestBody Contacto prod, @PathVariable("id") int id){
		try {
			Contacto p = productoService.read(id);
			if(p.getId()>0) {
				p.setNombres(prod.getNombres());
				p.setApellidos(prod.getApellidos());
				p.setCorreo(prod.getCorreo());
				return new ResponseEntity<>(productoService.create(p),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
