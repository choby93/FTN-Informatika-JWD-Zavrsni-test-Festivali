package project.Festivali.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.Festivali.model.Nastup;
import project.Festivali.service.NastupService;
import project.Festivali.support.NastupiDtoToNastupi;
import project.Festivali.support.NastupiToNastupiDto;
import project.Festivali.web.dto.NastupDto;

@RestController
@RequestMapping("/api/nastupi")
public class NastupiController {

	@Autowired
	private NastupService nastupService;
	@Autowired
	private NastupiToNastupiDto toDto;
	@Autowired
	private NastupiDtoToNastupi toEntity;

	@PreAuthorize("permitAll()")
	@GetMapping
	public ResponseEntity<List<NastupDto>> getAll(@RequestParam(required = false) Long izvodjacId,
			@RequestParam(required = false) Long festivalId,
			@RequestParam(required = false, defaultValue = "0") int pageNo) {
		Page<Nastup> nastupi = nastupService.search(izvodjacId, festivalId, pageNo);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("total-pages", Integer.toString(nastupi.getTotalPages()));

		return new ResponseEntity<>(toDto.convert(nastupi.getContent()), httpHeaders, HttpStatus.OK);
	}

	@PreAuthorize("permitAll()")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NastupDto> create(@RequestBody NastupDto dto) {

		Nastup nastup = toEntity.convert(dto);
		Nastup novNastup = nastupService.save(nastup);
		return new ResponseEntity<>(toDto.convert(novNastup), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NastupDto> edit(@PathVariable Long id, @RequestBody NastupDto dto) {

		if (!id.equals(dto.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Nastup nastup = toEntity.convert(dto);
		Nastup edited = nastupService.update(nastup);

		return new ResponseEntity<>(toDto.convert(edited), HttpStatus.OK);

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<NastupDto> delete(@PathVariable Long id) {

		Nastup obrisanNastup = nastupService.delete(id);

		if (obrisanNastup != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
