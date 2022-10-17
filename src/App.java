import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
         List<Pessoa> lista = Arrays.asList(
                new Pessoa(1, "Huguinho", Departamento.FINANCEIRO, 40),
                new Pessoa(4, "Zezinho", Departamento.FINANCEIRO, 32),
                new Pessoa(3, "Luizinho", Departamento.VENDAS, 57),
                new  Pessoa(9, "Patinhas",   Departamento.VENDAS, 40),
                new Pessoa(10, "Donald", Departamento.GERENCIA, 54),
                new Pessoa(2, "Margarida", Departamento.FINANCEIRO, 40),
                new Pessoa(8, "Joe Doe", Departamento.VENDAS, 34),
                new Pessoa(5, "Jane Doe", Departamento.VENDAS, 22),
                new Pessoa(6, "Sr Smith", Departamento.VENDAS, 40),
                new Pessoa(7, "Sra Smith", Departamento.GERENCIA, 39),
                new Pessoa(11, "Trinity", Departamento.VENDAS, 34),
                new Pessoa(14, "Morpheus", Departamento.FINANCEIRO, 22),
                new Pessoa(16, "AgenteSmith", Departamento.VENDAS, 47),
                new Pessoa(13, "Neo", Departamento.GERENCIA, 29)
        );

        /***
         * Exercício
         *      - escreva as consultas solicitadas utilizando
         *        apenas expressões lambda e operações de agregação
          */
        System.out.println("1. Funcionários do setor de vendas:");
        List<Pessoa> deptoVendas = lista.stream()
                                    .filter(p -> p.getDpto() == Departamento.VENDAS)
                                    .collect(Collectors.toList());
        deptoVendas.forEach(System.out::println);
        System.out.println();


        System.out.println("2. Funcionários do setor de vendas com idade entre 20 e 30 anos");
        List<Pessoa> deptoVendasIdade = lista.stream()
                                        .filter(p -> p.getDpto() == Departamento.VENDAS
                                        && p.getIdade() >= 20
                                        && p.getIdade() <= 30)
                                        .collect(Collectors.toList());
        deptoVendasIdade.forEach(System.out::println);
        System.out.println();


        System.out.println("3. Nomes (em maiúsculas) dos funcionários do setor de vendas (usando reduce");
        List<String> vendasMaiusculo = deptoVendas.stream()
                                       .map(p -> p.getNome()).map(String::toUpperCase)
                                       .collect(Collectors.toList());
        vendasMaiusculo.forEach(System.out::println);
        System.out.println();


        System.out.println("4. Todos os gerentes:");
		List<Pessoa> gerentes = lista.stream()
                                    .filter(p -> p.getDpto() == Departamento.GERENCIA)
                                    .collect(Collectors.toList());
        gerentes.forEach(System.out::println);
        System.out.println();


        System.out.println("5. Idade média dos gerentes:");
		double media = lista.stream()
						.filter(p -> p.getDpto() == Departamento.GERENCIA)
						.mapToDouble(p -> p.getIdade())
						.average().orElse(-1);
		System.out.printf("%.2f %n%n", media);

        System.out.println("6. Funcionarios ordenados pelo código:");

        System.out.println("7. Funcionários ordenados pela idade+nome:");

        System.out.println("8. Criar uma nova lista apenas com os funcionarios do financeiro:");

        System.out.println("9. Nome e setor da pessoa mais jovem:");

        /*
		System.out.println();
        double media = lista.stream()
                        .filter(p -> p.getDpto() == Departamento.GERENCIA)
                        .mapToDouble(p -> p.getIdade())
                        .average().orElse(-1);
        // ou
        System.out.println();
        OptionalDouble media2 = lista.stream()
                        .filter(p -> p.getDpto() == Departamento.GERENCIA)
                        .mapToDouble(p -> p.getIdade())
                        .average();
						*/

    }
}
