package it.sirfin.rubricadoc.repository;

import it.sirfin.rubricadoc.model.Contatto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContattoRepository extends JpaRepository<Contatto, Long> {

    List<Contatto> findByNomeLikeOrderByNomeDesc(String nn);
    
    List<Contatto> findByNomeAndCognome(String n, String c);
    List<Contatto> findByNomeOrCognome(String n, String c);
    List<Contatto> findByNomeIsNotNullAndCognome(String c);
    List<Contatto> findByNomeIsNullAndCognomeIsNotNull();
    List<Contatto> findByTelefonoIsNullOrderByNomeAsc();
    List<Contatto> findByOrderByNomeAscCognomeDesc();
    
}
