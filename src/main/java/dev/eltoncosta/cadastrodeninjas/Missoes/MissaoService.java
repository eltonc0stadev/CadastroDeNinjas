package dev.eltoncosta.cadastrodeninjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    private MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    public List<MissaoModel> listarMissoes() {
        return missaoRepository.findAll();
    }

    public MissaoModel buscarMissao(Long id) {
        Optional<MissaoModel> missao = missaoRepository.findById(id);
        return missao.orElse(null);
    }

    public MissaoModel criarMissao(MissaoModel missao) {
        return missaoRepository.save(missao);
    }

    public void excluirMissao(Long id) {
        missaoRepository.deleteById(id);
    }

    public MissaoModel alterarMissao(Long id, MissaoModel missaoAtualizada) {
        if (missaoRepository.existsById(id)) {
            missaoAtualizada.setId(id);
            return missaoRepository.save(missaoAtualizada);
        }
        return null;
    }

}
