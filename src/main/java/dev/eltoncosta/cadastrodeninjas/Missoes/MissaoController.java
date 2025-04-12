package dev.eltoncosta.cadastrodeninjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missao")
public class MissaoController {

    @GetMapping("/listar")
    public String buscarNinjas() {
        return "Ninjas encontrados com sucesso";
    }

    @GetMapping("/buscar")
    public String buscarNinja() {
        return "Ninja encontrado com sucesso";
    }

    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao criada com sucesso!";
    }

    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao alterado com sucesso!";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletado com sucesso!";
    }

}
