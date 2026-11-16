package br.edu.ifpe;
import br.edu.ifpe.dominio.Edital;
import br.edu.ifpe.service.EditalService;
import java.time.LocalDate;
public class Main 
{
 public static void main(String[] args)
{
 EditalService service = new EditalService();
 Edital edital = new Edital(
 "Edital de Pesquisa", "01", 2026,
 LocalDate.of(2026, 3, 1), LocalDate.of(2026, 3, 31),
 LocalDate.of(2026, 4, 1), LocalDate.of(2026, 4, 30));
 service.cadastrar(edital);
 System.out.println("Sistema de Editais iniciado com sucesso!");
 System.out.println("Editais cadastrados: " + service.listar().size());
 }
}
