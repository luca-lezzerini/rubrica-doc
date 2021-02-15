package it.sirfin.rubricadoc.repository;

import it.sirfin.rubricadoc.model.Contatto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContattoRepository extends JpaRepository<Contatto, Long>{

}
