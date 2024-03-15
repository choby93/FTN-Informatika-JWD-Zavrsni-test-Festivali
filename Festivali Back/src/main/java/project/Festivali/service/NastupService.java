package project.Festivali.service;

import java.util.List;

import org.springframework.data.domain.Page;

import project.Festivali.model.Nastup;

public interface NastupService {

	Nastup fiddOne(Long id);

	List<Nastup> getAll();

	Nastup save(Nastup nastup);

	Nastup update(Nastup nastup);

	Nastup delete(Long id);

	Page<Nastup> search(Long izvodjacId, Long nastupId, int pageNo);

}
