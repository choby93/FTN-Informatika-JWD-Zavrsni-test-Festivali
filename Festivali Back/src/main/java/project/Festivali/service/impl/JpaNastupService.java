package project.Festivali.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import project.Festivali.model.Festival;
import project.Festivali.model.Izvodjac;
import project.Festivali.model.Nastup;
import project.Festivali.repository.NastupRepository;
import project.Festivali.service.NastupService;

@Service
public class JpaNastupService implements NastupService {

	@Autowired
	private NastupRepository nastupRepo;
	@Autowired
	NastupService nastupService;

	@Override
	public Nastup fiddOne(Long id) {
		return nastupRepo.findById(id).get();
	}

	@Override
	public List<Nastup> getAll() {
		return nastupRepo.findAll();
	}

	@Override
	public Nastup save(Nastup nastup) {
		
		Festival festival = nastup.getFestival();
		Izvodjac izvodjac = nastup.getIzvodjac();
		List<Nastup> nastupiFestivala = festival.getNastupi();
		for(Nastup n :nastupiFestivala) {
			if(n.getIzvodjac().getDrzava().equalsIgnoreCase(izvodjac.getDrzava())) {
				return null;
			}
		}
		
		return nastupRepo.save(nastup);
	}

	@Override
	public Nastup update(Nastup nastup) {
		return nastupRepo.save(nastup);

	}

	@Override
	public Nastup delete(Long id) {

		Nastup nastup = nastupService.fiddOne(id);

		if (nastup != null) {
			nastup.getFestival().getNastupi().remove(nastup);
			nastup.setFestival(null);
			nastup.getIzvodjac().getNastupi().remove(nastup);
			nastup.setIzvodjac(null);
			nastup = nastupRepo.save(nastup);
			nastupRepo.delete(nastup);
			return nastup;
		}

		return null;
	}

	@Override
	public Page<Nastup> search(Long izvodjacId, Long festivalId, int pageNo) {
		return nastupRepo.search(izvodjacId, festivalId, PageRequest.of(pageNo, 3));
	}

}
