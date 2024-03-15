package project.Festivali.web.dto;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class IzvodjacDto {

	private Long id;

	private String ime;

	private String zanr;
	@Size(min = 4, message = "Država mora da sadrži najmanje 4 karaktera.")
	private String drzava;
	@Positive(message = "Broj članova mora da bude pozitivan broj.")
	private Integer brojClanova;

	private Integer brojNastupa;

	public Integer getBrojNastupa() {
		return brojNastupa;
	}

	public void setBrojNastupa(Integer brojNastupa) {
		this.brojNastupa = brojNastupa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public Integer getBrojClanova() {
		return brojClanova;
	}

	public void setBrojClanova(Integer brojClanova) {
		this.brojClanova = brojClanova;
	}

}
