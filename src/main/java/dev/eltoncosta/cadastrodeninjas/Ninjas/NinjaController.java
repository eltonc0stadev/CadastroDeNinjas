package dev.eltoncosta.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/")
    public String inicio(){ return "Inicio<br><a href=\"/boasvindas\">boas vindas</a>"; }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Boas Vindas<br><a href=\"/\">Voltar para a página inicial</a>";
    }

}
