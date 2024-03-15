package project.Festivali.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import project.Festivali.model.Izvodjac;
import project.Festivali.web.dto.IzvodjacDto;

@Component
public class IzvodjaciToIzvodjaciDto implements Converter<Izvodjac, IzvodjacDto> {

	@Override
	public IzvodjacDto convert(Izvodjac i) {

		IzvodjacDto dto = new IzvodjacDto();

		dto.setId(i.getId());
		dto.setIme(i.getIme());
		dto.setZanr(i.getZanr());
		dto.setDrzava(i.getDrzava());
		dto.setBrojClanova(i.getBrojClanova());
		dto.setBrojNastupa(i.getNastupi().size());
		return dto;
	}

	public List<IzvodjacDto> convert(List<Izvodjac> izvodjaci) {

		List<IzvodjacDto> izvodjaciDtoS = new ArrayList<>();

		for (Izvodjac i : izvodjaci) {
			izvodjaciDtoS.add(convert(i));
		}

		return izvodjaciDtoS;
	}

}
