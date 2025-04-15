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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // Procurar ninja por ID

    @GetMapping("/buscar/{id}")
    public NinjaDTO buscarNinja(@PathVariable Long id) {
        return ninjaService.buscarNinja(id);
    }

    // Mostrar todos os ninjas

    @GetMapping("/listar")
    public List<NinjaDTO> buscarTodosOsNinjas() {
        return ninjaService.listarNinjas();
    }

    // Alterar dados dos ninjas

    @PutMapping("/alterar/{id}")
    public NinjaDTO atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    // Deletar ninjas

    @DeleteMapping("/deletar/{idDoNinja}")
    public void deletarNinja(@PathVariable Long idDoNinja) {
        ninjaService.excluirNinja(idDoNinja);
    }

}
