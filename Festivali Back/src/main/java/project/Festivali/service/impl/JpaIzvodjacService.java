package project.Festivali.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.Festivali.model.Izvodjac;
import project.Festivali.repository.IzvodjacRepository;
import project.Festivali.service.IzvodjacService;

@Service
public class JpaIzvodjacService implements IzvodjacService {

	@Autowired
	private IzvodjacRepository izvodjacRepo;

	@Override
	public List<Izvodjac> getAll() {
		return izvodjacRepo.findAll();
	}

	@Override
	public Izvodjac getOne(Long id) {
		return izvodjacRepo.findById(id).get();
	}

	@Override
	public Izvodjac save(Izvodjac izvodjac) {
		return izvodjacRepo.save(izvodjac);
	}

}
