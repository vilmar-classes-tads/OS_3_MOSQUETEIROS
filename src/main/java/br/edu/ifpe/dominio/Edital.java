package br.edu.ifpe.dominio;
import java.time.LocalDate;
public class Edital {
 private Long id;
 private String titulo;
 private String numero;
 private int ano;
 private LocalDate dataInicioSubmissao;
 private LocalDate dataFimSubmissao;
 private LocalDate dataInicioAvaliacao;
 private LocalDate dataFimAvaliacao;
 public Edital() {
 }
 public Edital(String titulo, String numero, int ano,
 LocalDate dataInicioSubmissao, LocalDate dataFimSubmissao,
 LocalDate dataInicioAvaliacao, LocalDate dataFimAvaliacao) {
 this.titulo = titulo;
 this.numero = numero;
 this.ano = ano;
 this.dataInicioSubmissao = dataInicioSubmissao;
 this.dataFimSubmissao = dataFimSubmissao;
 this.dataInicioAvaliacao = dataInicioAvaliacao;
 this.dataFimAvaliacao = dataFimAvaliacao;
 }
 public void validarDatas() {
 if (dataInicioSubmissao == null || dataFimSubmissao == null
 || dataInicioAvaliacao == null || dataFimAvaliacao == null) {
 throw new IllegalArgumentException(
 "Todas as datas do edital sao obrigatorias.");
 }
 if (dataFimSubmissao.isBefore(dataInicioSubmissao)) {
 throw new IllegalArgumentException(
 "O fim da submissao nao pode ser anterior ao inicio.");
 }
 if (dataFimAvaliacao.isBefore(dataInicioAvaliacao)) {
 throw new IllegalArgumentException(
 "O fim da avaliacao nao pode ser anterior ao inicio.");
 }
 }
 public Long getId() { return id; }
 public void setId(Long id) { this.id = id; }
 public String getTitulo() { return titulo; }
 public void setTitulo(String titulo) { this.titulo = titulo; }
 public String getNumero() { return numero; }
 public void setNumero(String numero) { this.numero = numero; }
 public int getAno() { return ano; }
 public void setAno(int ano) { this.ano = ano; }
 public LocalDate getDataInicioSubmissao() { return dataInicioSubmissao; }
 public void setDataInicioSubmissao(LocalDate d) { this.dataInicioSubmissao = d; }
 public LocalDate getDataFimSubmissao() { return dataFimSubmissao; }
 public void setDataFimSubmissao(LocalDate d) { this.dataFimSubmissao = d; }
 public LocalDate getDataInicioAvaliacao() { return dataInicioAvaliacao; }
 public void setDataInicioAvaliacao(LocalDate d) { this.dataInicioAvaliacao = d; }
 public LocalDate getDataFimAvaliacao() { return dataFimAvaliacao; }
 public void setDataFimAvaliacao(LocalDate d) { this.dataFimAvaliacao = d; }
}
