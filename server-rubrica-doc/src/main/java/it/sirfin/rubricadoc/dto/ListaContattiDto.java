package it.sirfin.rubricadoc.dto;

import it.sirfin.rubricadoc.model.Contatto;
import java.util.List;

public class ListaContattiDto {

    private List<Contatto> listaContatti;

    public ListaContattiDto() {
    }

    public ListaContattiDto(List<Contatto> listaContatti) {
        this.listaContatti = listaContatti;
    }

    public List<Contatto> getListaContatti() {
        return listaContatti;
    }

    public void setListaContatti(List<Contatto> listaContatti) {
        this.listaContatti = listaContatti;
    }

    @Override
    public String toString() {
        return "ListaContattiDto{" + "listaContatti=" + listaContatti + '}';
    }

}
