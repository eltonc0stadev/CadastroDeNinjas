package dev.eltoncosta.cadastrodeninjas.Missoes;

import dev.eltoncosta.cadastrodeninjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
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

    public MissaoModel() {
    }

    public MissaoModel(Long id, String nome, String descricao, Byte nivel) {
        this.id = id;
        this.descricao = descricao;
        this.nivel = nivel;
    }

    public MissaoModel(Long id, String nome, String descricao, Byte nivel, List<NinjaModel> ninjas) {
        this(id, nome, descricao, nivel);
        this.ninjas = ninjas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Byte getNivel() {
        return nivel;
    }

    public void setNivel(Byte nivel) {
        this.nivel = nivel;
    }

    public List<NinjaModel> getNinjas() {
        return ninjas;
    }

    public void setNinjas(List<NinjaModel> ninjas) {
        this.ninjas = ninjas;
    }
}
