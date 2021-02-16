package it.sirfin.rubricadoc.service;

import it.sirfin.rubricadoc.model.Contatto;
import java.util.List;

public interface RubricaService {

    List<Contatto> leggiRubricaCompleta();

    List<Contatto> inserisciContatto(Contatto c);

    List<Contatto> cancellaContatto(Contatto c);
    
    List<Contatto> svuotaRubrica();
    
    List<Contatto> cercaNome(String nome);
}
