package project.Festivali.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import project.Festivali.model.Nastup;
import project.Festivali.service.FestivalService;
import project.Festivali.service.IzvodjacService;
import project.Festivali.service.NastupService;
import project.Festivali.web.dto.NastupDto;

@Component
public class NastupiDtoToNastupi implements Converter<NastupDto, Nastup> {

	@Autowired
	private NastupService nastupService;
	@Autowired
	private FestivalService festivalService;
	@Autowired
	private IzvodjacService izvodjacService;

	@Override
	public Nastup convert(NastupDto dto) {

		Nastup nastup;

		if (dto.getId() == null) {
			nastup = new Nastup();
		} else {
			nastup = nastupService.fiddOne(dto.getId());
		}

		if (nastup != null) {
			nastup.setId(dto.getId());
			nastup.setFestival(festivalService.fiddOne(dto.getFestivalId()));
			nastup.setIzvodjac(izvodjacService.getOne(dto.getIzvodjacId()));
		}

		return nastup;
	}

}
