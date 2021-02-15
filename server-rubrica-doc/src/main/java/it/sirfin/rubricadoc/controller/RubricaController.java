package it.sirfin.rubricadoc.controller;

import it.sirfin.rubricadoc.dto.ListaContattiDto;
import it.sirfin.rubricadoc.model.Contatto;
import it.sirfin.rubricadoc.service.RubricaService;
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
    public ListaContattiDto inserisciContatto(@RequestBody Contatto c) {
        return new ListaContattiDto(rubricaService.inserisciContatto(c));
    }

    @RequestMapping("/cancella")
    @ResponseBody
    public ListaContattiDto cancellaContatto(@RequestBody Contatto c) {
        return new ListaContattiDto(rubricaService.cancellaContatto(c));
    }

    @RequestMapping("/svuota")
    @ResponseBody
    public ListaContattiDto svuotaRubrica() {
        return new ListaContattiDto(rubricaService.svuotaRubrica());
    }
}
