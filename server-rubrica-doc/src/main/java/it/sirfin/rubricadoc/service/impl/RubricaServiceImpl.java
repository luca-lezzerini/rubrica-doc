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

}
