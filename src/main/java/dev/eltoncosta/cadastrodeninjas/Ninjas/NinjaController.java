package dev.eltoncosta.cadastrodeninjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + ninjaDTO.getNome() + " " + ninjaDTO.getId());

    }

    // Procurar ninja por ID

    @GetMapping("/buscar/{id}")
    public ResponseEntity<NinjaDTO> buscarNinja(@PathVariable Long id) {
        if (ninjaService.buscarNinja(id) != null) {
            NinjaDTO ninja = ninjaService.buscarNinja(id);
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Mostrar todos os ninjas

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> buscarTodosOsNinjas() {
        List<NinjaDTO> listaDeNinjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(listaDeNinjas);
    }

    // Alterar dados dos ninjas

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        if (ninjaService.buscarNinja(id) != null) {
            ninjaService.atualizarNinja(id, ninjaAtualizado);
            return ResponseEntity.ok("Ninja atualizado com sucesso: " + ninjaAtualizado.toString());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja de ID, " + id + " não encontrado");
    }

    // Deletar ninjas

    @DeleteMapping("/deletar/{idDoNinja}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long idDoNinja) {

        if (ninjaService.buscarNinja(idDoNinja) != null) {
            ninjaService.excluirNinja(idDoNinja);
            return ResponseEntity.ok("Ninja deletado com sucesso");
        } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja de ID, " + idDoNinja + " não encontrado");
        }

    }

}
