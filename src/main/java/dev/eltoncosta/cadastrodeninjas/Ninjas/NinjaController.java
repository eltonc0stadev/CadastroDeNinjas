package dev.eltoncosta.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/ninjaRotas")
    public String inicio(){
        return "Lista de rotas:<br><Strong>POST</Strong> <a href=\"/ninja/criar\">/ninja/criar</a>";
    }

    // Adicionar ninja

    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado com sucesso";
    }

    // Procurar ninja por ID

    @GetMapping("/buscar/{id}")
    public NinjaModel buscarNinja(@PathVariable Long id) {
        return ninjaService.buscarNinja(id);
    }

    // Mostrar todos os ninjas

    @GetMapping("/listar")
    public List<NinjaModel> buscarTodosOsNinjas() {
        return ninjaService.listarNinjas();
    }

    // Alterar dados dos ninjas

    @PutMapping("/alterar")
    public String atualizarNinja() {
        return "Ninja atualizado com sucesso";
    }

    // Deletar ninjas

    @DeleteMapping("/deletar")
    public String deletarNinja() {
        return "Ninja deletado com sucesso";
    }

}
