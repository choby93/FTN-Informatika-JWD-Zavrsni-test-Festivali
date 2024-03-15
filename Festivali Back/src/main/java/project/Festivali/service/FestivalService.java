package project.Festivali.service;

import java.util.List;

import project.Festivali.model.Festival;

public interface FestivalService {

	List<Festival> getAll();

	Festival fiddOne(Long festivalId);

}
