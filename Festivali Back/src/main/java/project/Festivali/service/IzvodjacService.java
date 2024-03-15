package project.Festivali.service;

import java.util.List;

import project.Festivali.model.Izvodjac;

public interface IzvodjacService {

	List<Izvodjac> getAll();

	Izvodjac getOne(Long id);

	Izvodjac save(Izvodjac izvodjac);

}
