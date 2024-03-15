package project.Festivali.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Nastup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Festival festival;
	@ManyToOne
	private Izvodjac izvodjac;

	public Nastup() {
		super();
	}

	public Nastup(Long id, Festival festival, Izvodjac izvodjac) {
		super();
		this.id = id;
		this.festival = festival;
		this.izvodjac = izvodjac;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public Izvodjac getIzvodjac() {
		return izvodjac;
	}

	public void setIzvodjac(Izvodjac izvodjac) {
		this.izvodjac = izvodjac;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((festival == null) ? 0 : festival.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nastup other = (Nastup) obj;
		if (festival == null) {
			if (other.festival != null)
				return false;
		} else if (!festival.equals(other.festival))
			return false;
		return true;
	}

}
