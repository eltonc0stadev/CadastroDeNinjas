package dev.eltoncosta.cadastrodeninjas.Ninjas;

import dev.eltoncosta.cadastrodeninjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "idade")
    private int idade;

    @ManyToOne
    @JoinColumn(name = "missao_id")
    private MissaoModel missao;

}
