package edital;

import java.util.ArrayList;
import java.util.List;

public class EditalService {

    private final List<Edital> editais = new ArrayList<>();
    private Long proximoId = 1L;

    public Edital cadastrar(Edital edital) {
        edital.validarDatas();
        edital.setId(proximoId++);
        editais.add(edital);
        return edital;
    }

    public List<Edital> listar() {
        return new ArrayList<>(editais);
    }

    public Edital buscarPorId(Long id) {
        return editais.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Edital não encontrado: " + id));
    }

    public Edital editar(Long id, Edital dados) {
        dados.validarDatas();
        Edital existente = buscarPorId(id);
        existente.setTitulo(dados.getTitulo());
        existente.setNumero(dados.getNumero());
        existente.setAno(dados.getAno());
        existente.setDataInicioSubmissao(dados.getDataInicioSubmissao());
        existente.setDataFimSubmissao(dados.getDataFimSubmissao());
        existente.setDataInicioAvaliacao(dados.getDataInicioAvaliacao());
        existente.setDataFimAvaliacao(dados.getDataFimAvaliacao());
        return existente;
    }
}
