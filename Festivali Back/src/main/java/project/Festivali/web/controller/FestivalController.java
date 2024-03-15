package project.Festivali.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.Festivali.model.Festival;
import project.Festivali.service.FestivalService;
import project.Festivali.support.FestivaliToFestivaliDto;
import project.Festivali.web.dto.FestivalDto;

@Controller
@RequestMapping("/api/festivali")
public class FestivalController {

	@Autowired
	private FestivalService festivalService;
	@Autowired
	private FestivaliToFestivaliDto toDto;

	@GetMapping
	public ResponseEntity<List<FestivalDto>> getAll() {

		List<Festival> fetivali = festivalService.getAll();

		return new ResponseEntity<>(toDto.convert(fetivali),HttpStatus.OK);
	}

}
