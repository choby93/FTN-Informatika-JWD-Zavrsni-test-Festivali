package project.Festivali.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import project.Festivali.model.Izvodjac;
import project.Festivali.service.IzvodjacService;
import project.Festivali.web.dto.IzvodjacDto;

@Component
public class IzvodjacDtoToIzvodjac implements Converter<IzvodjacDto, Izvodjac> {

	@Autowired
	private IzvodjacService izvodjacService;

	@Override
	public Izvodjac convert(IzvodjacDto source) {

		Izvodjac izvodjac;

		if (source.getId() == null) {
			izvodjac = new Izvodjac();
		} else {
			izvodjac = izvodjacService.getOne(source.getId());
		}

		if (izvodjac != null) {
			izvodjac.setId(source.getId());
			izvodjac.setIme(source.getIme());
			izvodjac.setZanr(source.getZanr());
			izvodjac.setDrzava(source.getDrzava());
			izvodjac.setBrojClanova(source.getBrojClanova());
		}

		return izvodjac;
	}

}
