package project.Festivali.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project.Festivali.model.Nastup;

@Repository
public interface NastupRepository extends JpaRepository<Nastup, Long> {
	@Query("SELECT n FROM Nastup n WHERE "
			+ "(:izvodjacId IS NULL OR n.izvodjac.id = :izvodjacId) AND "
			+ "(:festivalId IS NULL or n.festival.id = :festivalId)")
	Page<Nastup> search (@Param ("izvodjacId") Long izvodjacId,
						@Param ("festivalId") Long festivalId, 
						Pageable pageable);


}
