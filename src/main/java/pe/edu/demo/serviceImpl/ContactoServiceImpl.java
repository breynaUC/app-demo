package pe.edu.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.demo.entity.Contacto;
import pe.edu.demo.repository.ContactoRepository;
import pe.edu.demo.service.ContactoService;
@Service
public class ContactoServiceImpl implements ContactoService{

	@Autowired
	private ContactoRepository contactoRepository;
	@Override
	public Contacto create(Contacto contacto) {
		// TODO Auto-generated method stub
		return contactoRepository.save(contacto);
	}

	@Override
	public Contacto update(Contacto contacto) {
		// TODO Auto-generated method stub
		return contactoRepository.save(contacto);
	}

	@Override
	public Contacto read(int id) {
		// TODO Auto-generated method stub
		return contactoRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		contactoRepository.deleteById(id);
	}

	@Override
	public List<Contacto> readAll() {
		// TODO Auto-generated method stub
		return contactoRepository.findAll();
	}

}
