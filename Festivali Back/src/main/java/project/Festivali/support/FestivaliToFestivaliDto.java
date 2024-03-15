package project.Festivali.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import project.Festivali.model.Festival;
import project.Festivali.web.dto.FestivalDto;

@Component
public class FestivaliToFestivaliDto implements Converter<Festival, FestivalDto> {

	@Override
	public FestivalDto convert(Festival f) {

		FestivalDto festival = new FestivalDto();

		festival.setId(f.getId());
		festival.setNaziv(f.getNaziv());

		return festival;
	}

	public List<FestivalDto> convert(List<Festival> festival) {

		List<FestivalDto> dto = new ArrayList<>();

		for (Festival f : festival) {
			dto.add(convert(f));
		}

		return dto;
	}

}
