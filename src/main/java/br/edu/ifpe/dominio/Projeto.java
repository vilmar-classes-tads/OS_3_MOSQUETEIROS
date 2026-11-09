import java.util.ArrayList;
import java.util.List;

/**
 * Representa um projeto/proposta submetido(a) à instituição.
 * Tudo (atributos, regra de status e exceção) está nesta única classe.
 */
public class Projeto {

    // Status possíveis
    public static final String RASCUNHO = "Rascunho";
    public static final String SUBMETIDO = "Submetido";
    public static final String EM_AVALIACAO = "Em Avaliação";
    public static final String EM_CORRECAO = "Em Correção";
    public static final String APROVADO = "Aprovado";
    public static final String REPROVADO = "Reprovado";

    private String titulo;
    private String resumo;
    private List<String> palavrasChave;
    private String publicoAlvo;
    private String areaTematica;
    private String campus;
    private List<String> ods; // Objetivos de Desenvolvimento Sustentável
    private boolean aceiteTermoCompromisso;
    private String status;

    /** Todo projeto nasce como Rascunho. */
    public Projeto(String titulo, String resumo, List<String> palavrasChave,
                   String publicoAlvo, String areaTematica, String campus,
                   List<String> ods, boolean aceiteTermoCompromisso) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.palavrasChave = copiar(palavrasChave);
        this.publicoAlvo = publicoAlvo;
        this.areaTematica = areaTematica;
        this.campus = campus;
        this.ods = copiar(ods);
        this.aceiteTermoCompromisso = aceiteTermoCompromisso;
        this.status = RASCUNHO;
    }

    /**
     * Edita os dados do projeto.
     * Permitido somente nos status "Rascunho" e "Em Correção".
     *
     * @throws IllegalStateException se o status atual não permitir edição
     */
    public void editarProjeto(String titulo, String resumo, List<String> palavrasChave,
                              String publicoAlvo, String areaTematica, String campus,
                              List<String> ods, boolean aceiteTermoCompromisso) {
        if (!RASCUNHO.equals(status) && !EM_CORRECAO.equals(status)) {
            throw new IllegalStateException("Projeto não pode ser editado no status '" + status
                    + "'. Edição permitida apenas nos status 'Rascunho' e 'Em Correção'.");
        }
        this.titulo = titulo;
        this.resumo = resumo;
        this.palavrasChave = copiar(palavrasChave);
        this.publicoAlvo = publicoAlvo;
        this.areaTematica = areaTematica;
        this.campus = campus;
        this.ods = copiar(ods);
        this.aceiteTermoCompromisso = aceiteTermoCompromisso;
    }

    private static List<String> copiar(List<String> origem) {
        return origem == null ? new ArrayList<>() : new ArrayList<>(origem);
    }

    // Getters

    public String getTitulo() { return titulo; }
    public String getResumo() { return resumo; }
    public List<String> getPalavrasChave() { return new ArrayList<>(palavrasChave); }
    public String getPublicoAlvo() { return publicoAlvo; }
    public String getAreaTematica() { return areaTematica; }
    public String getCampus() { return campus; }
    public List<String> getOds() { return new ArrayList<>(ods); }
    public boolean isAceiteTermoCompromisso() { return aceiteTermoCompromisso; }
    public String getStatus() { return status; }

    /** Mudança de status (fluxo de submissão/avaliação fica fora do escopo desta issue). */
    public void setStatus(String status) {
        this.status = status;
    }

    // Teste rápido
    public static void main(String[] args) {
        Projeto p = new Projeto("Horta Comunitária", "Resumo inicial",
                List.of("horta", "sustentabilidade"), "Comunidade local",
                "Meio Ambiente", "Campus Recife", List.of("ODS 2", "ODS 11"), false);

        p.editarProjeto("Horta Escolar", "Resumo revisado", List.of("horta"),
                "Estudantes", "Educação", "Campus Recife", List.of("ODS 4"), true);
        System.out.println("Editado em Rascunho: " + p.getTitulo());

        p.setStatus(EM_CORRECAO);
        p.editarProjeto("Horta Escolar Corrigida", "Resumo corrigido", List.of("horta"),
                "Estudantes", "Educação", "Campus Recife", List.of("ODS 4"), true);
        System.out.println("Editado em Correção: " + p.getTitulo());

        p.setStatus(SUBMETIDO);
        try {
            p.editarProjeto("Tentativa", "x", List.of(), "x", "x", "x", List.of(), true);
        } catch (IllegalStateException e) {
            System.out.println("Exceção esperada: " + e.getMessage());
        }
    }
}
