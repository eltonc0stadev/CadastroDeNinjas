package dev.eltoncosta.cadastrodeninjas.Missoes;

import dev.eltoncosta.cadastrodeninjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissaoModel {

    //niveis: S -> 1, A -> 2, B -> 3, C -> 4

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Byte nivel;
    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninjas;

}
