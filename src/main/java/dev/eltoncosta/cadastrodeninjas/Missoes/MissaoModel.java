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
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "nivel")
    private String nivel;

    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninjas;

}
