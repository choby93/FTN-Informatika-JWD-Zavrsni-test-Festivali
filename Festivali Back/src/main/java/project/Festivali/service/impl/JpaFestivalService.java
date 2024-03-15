package project.Festivali.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.Festivali.model.Festival;
import project.Festivali.repository.FestivalRepository;
import project.Festivali.service.FestivalService;

@Service
public class JpaFestivalService implements FestivalService {

	@Autowired
	private FestivalRepository festivalRepo;

	@Override
	public Festival fiddOne(Long festivalId) {
		return festivalRepo.findById(festivalId).get();
	}

	@Override
	public List<Festival> getAll() {
		return festivalRepo.findAll();
	}

}
