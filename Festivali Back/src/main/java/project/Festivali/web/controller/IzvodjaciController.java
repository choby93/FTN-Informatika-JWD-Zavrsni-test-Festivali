package project.Festivali.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.Festivali.model.Izvodjac;
import project.Festivali.service.IzvodjacService;
import project.Festivali.support.IzvodjacDtoToIzvodjac;
import project.Festivali.support.IzvodjaciToIzvodjaciDto;
import project.Festivali.web.dto.IzvodjacDto;

@RestController
@RequestMapping(value = "/api/izvodjaci", produces = MediaType.APPLICATION_JSON_VALUE)
public class IzvodjaciController {

	@Autowired
	private IzvodjacService izvodjacService;
	@Autowired
	private IzvodjaciToIzvodjaciDto toDto;
	@Autowired
	private IzvodjacDtoToIzvodjac toEntity;

	@PreAuthorize("permitAll()")
	@GetMapping
	public ResponseEntity<List<IzvodjacDto>> getAll() {
		List<Izvodjac> izvodjaci = izvodjacService.getAll();
		return new ResponseEntity<>(toDto.convert(izvodjaci), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IzvodjacDto> addIzvodjac(@Valid @RequestBody IzvodjacDto dto) {
		Izvodjac izvodjac = toEntity.convert(dto);
		Izvodjac novIzvodjac = izvodjacService.save(izvodjac);
		return new ResponseEntity<>(toDto.convert(novIzvodjac), HttpStatus.OK);
	}
}
