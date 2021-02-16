package it.sirfin.rubricadoc.controller;

import it.sirfin.rubricadoc.dto.ListaContattiDto;
import it.sirfin.rubricadoc.dto.RichiestaContattoDto;
import it.sirfin.rubricadoc.model.Contatto;
import it.sirfin.rubricadoc.service.RubricaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class RubricaController {

    @Autowired
    RubricaService rubricaService;

    @RequestMapping("/leggi-rubrica")
    @ResponseBody
    public ListaContattiDto leggiRubricaCompleta() {
        return new ListaContattiDto(rubricaService.leggiRubricaCompleta());
    }

    @RequestMapping("/inserisci")
    @ResponseBody
    public ListaContattiDto inserisciContatto(@RequestBody RichiestaContattoDto dto) {
        // estraggo il contatto dal DTO
        Contatto c = dto.getContatto();
        // inserisco il contatto su DB e ottengo il DB aggiornato
        List<Contatto> lista = rubricaService.inserisciContatto(c);
        // creo un nuovo DTO per la risposta
        ListaContattiDto risp = new ListaContattiDto(lista);
        // ritorno il DTO
        return risp;
    }

    @RequestMapping("/cancella")
    @ResponseBody
    public ListaContattiDto cancellaContatto(@RequestBody RichiestaContattoDto dto) {
        return new ListaContattiDto(rubricaService.cancellaContatto(dto.getContatto()));
    }

    @RequestMapping("/svuota")
    @ResponseBody
    public ListaContattiDto svuotaRubrica() {
        return new ListaContattiDto(rubricaService.svuotaRubrica());
    }

    @RequestMapping("/cerca-nome")
    @ResponseBody
    public ListaContattiDto cercaNome(@RequestBody RichiestaContattoDto dto) {
        Contatto c = dto.getContatto();
        String nomeLike = "%" + c.getNome() + "%";
        List<Contatto> lista = rubricaService.cercaNome(nomeLike);
        ListaContattiDto risp = new ListaContattiDto(lista);
        return risp;
    }

}
