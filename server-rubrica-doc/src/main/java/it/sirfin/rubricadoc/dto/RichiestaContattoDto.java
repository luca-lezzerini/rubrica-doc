package it.sirfin.rubricadoc.dto;

import it.sirfin.rubricadoc.model.Contatto;

public class RichiestaContattoDto {
    private Contatto contatto;

    public RichiestaContattoDto() {
    }

    public RichiestaContattoDto(Contatto contatto) {
        this.contatto = contatto;
    }

    public Contatto getContatto() {
        return contatto;
    }

    public void setContatto(Contatto contatto) {
        this.contatto = contatto;
    }

    @Override
    public String toString() {
        return "RichiestaContattoDto{" + "contatto=" + contatto + '}';
    }
    
}
