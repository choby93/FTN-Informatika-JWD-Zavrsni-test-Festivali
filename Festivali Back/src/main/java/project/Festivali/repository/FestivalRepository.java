package project.Festivali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.Festivali.model.Festival;

@Repository
public interface FestivalRepository extends JpaRepository<Festival, Long> {

}
