package project.Festivali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.Festivali.model.Izvodjac;

@Repository
public interface IzvodjacRepository extends JpaRepository<Izvodjac, Long> {

}
