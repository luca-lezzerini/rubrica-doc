package it.sirfin.rubricadoc.service.impl;

import it.sirfin.rubricadoc.model.Contatto;
import it.sirfin.rubricadoc.repository.ContattoRepository;
import it.sirfin.rubricadoc.service.RubricaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubricaServiceImpl implements RubricaService{

    @Autowired
    ContattoRepository contattoRepository;
    
    @Override
    public List<Contatto> leggiRubricaCompleta() {
        return contattoRepository.findAll();
    }

    @Override
    public List<Contatto> inserisciContatto(Contatto c) {
        // save ritorna il record aggiornato (es. con la chiave primaria valorizzata)
//        Contatto cx = contattoRepository.save(c);
        contattoRepository.save(c);
        return leggiRubricaCompleta();
    }

    @Override
    public List<Contatto> cancellaContatto(Contatto c) {
        contattoRepository.delete(c);
        return leggiRubricaCompleta();
    }

    @Override
    public List<Contatto> svuotaRubrica() {
        contattoRepository.deleteAllInBatch();
        return new ArrayList<>();
        // la cosa più corretta è quella sotto ma la più veloce è quella sopra.
//        return leggiRubricaCompleta();
    }

    @Override
    public List<Contatto> cercaNome(String nome) {
        return contattoRepository.findByNomeLikeOrderByNomeDesc(nome);
    }

    @Override
    public void testQuery() {
        List<Contatto> l1 = contattoRepository.findByNomeAndCognome("Mario", "Rossi");
        for (Contatto contatto : l1) {
            System.out.println(contatto);
        }
        List<Contatto> l2 = contattoRepository.findByNomeOrCognome("Mario", "Rossi");
        l2.forEach(t-> System.out.println(t));
        List<Contatto> l3 = contattoRepository.findByNomeIsNotNullAndCognome("Rossi");
        l3.stream().forEach(t-> System.out.println(t));
        List<Contatto> l4 = contattoRepository.findByNomeIsNullAndCognomeIsNotNull();
        l4.stream().forEach(t-> System.out.println(t));
        List<Contatto> l5 = contattoRepository.findByTelefonoIsNullOrderByNomeAsc();
        l5.stream().forEach(t-> System.out.println(t));
        List<Contatto> l6 = contattoRepository.findByOrderByNomeAscCognomeDesc();
        l6.stream().forEach(t-> System.out.println(t));
    }
    
    

}
