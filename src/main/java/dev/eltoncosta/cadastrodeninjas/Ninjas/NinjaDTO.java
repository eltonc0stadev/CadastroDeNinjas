package dev.eltoncosta.cadastrodeninjas.Ninjas;

import dev.eltoncosta.cadastrodeninjas.Missoes.MissaoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private int idade;
    private String rank;
    private MissaoModel missao;

}
