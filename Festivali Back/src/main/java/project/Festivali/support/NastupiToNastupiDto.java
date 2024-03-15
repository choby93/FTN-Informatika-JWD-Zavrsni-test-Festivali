package project.Festivali.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import project.Festivali.model.Nastup;
import project.Festivali.web.dto.NastupDto;

@Component
public class NastupiToNastupiDto implements Converter<Nastup, NastupDto> {

	@Override
	public NastupDto convert(Nastup n) {

		NastupDto dto = new NastupDto();

		dto.setId(n.getId());
		dto.setFestivalId(n.getFestival().getId());
		dto.setFestivalNaziv(n.getFestival().getNaziv());
		dto.setIzvodjacId(n.getIzvodjac().getId());
		dto.setIzvodjacIme(n.getIzvodjac().getIme());

		return dto;
	}

	public List<NastupDto> convert(List<Nastup> nastupi) {

		List<NastupDto> dtoS = new ArrayList<>();

		for (Nastup i : nastupi) {
			dtoS.add(convert(i));

		}

		return dtoS;

	}

}
