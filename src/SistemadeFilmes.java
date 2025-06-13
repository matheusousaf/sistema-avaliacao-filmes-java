import java.util.Scanner;

public class SistemadeFilmes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Arrays para armazenar informações de até 5 filmes
        String[] nomes = new String[5];                 // Nome dos filmes
        String[] categorias = new String[5];            // Categoria dos filmes
        double[] somasNotas = new double[5];            // Soma de todas as notas de cada filme
        int[] contadoresNotas = new int[5];             // Quantas notas foram dadas para cada filme

        // Contador de quantos filmes foram cadastrados
        int totalFilmes = 0;

        // Laço principal do menu (roda até o usuário escolher sair) pq tem um n?
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Cadastrar novo filme");
            System.out.println("2. Avaliar filme");
            System.out.println("3. Listar filmes");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            // Lê a opção digitada pelo usuário
            int opcao = input.nextInt();
            input.nextLine(); // Limpa o "enter" que ficou no buffer

            // CADASTRAR FILME
            if (opcao == 1) {
                // Verifica se ainda há espaço no array (máximo de 5 filmes)
                if (totalFilmes < 5) {
                    System.out.print("Nome do filme: ");
                    nomes[totalFilmes] = input.nextLine();

                    System.out.print("Categoria: ");
                    categorias[totalFilmes] = input.nextLine();

                    System.out.println("Filme cadastrado com sucesso!");
                    totalFilmes++; // Atualiza o total de filmes cadastrados (pq n tem "contine" para voltar ao menu?
                } else {
                    System.out.println("Limite de filmes atingido!");
                }

                // AVALIAR FILME
            } else if (opcao == 2) {
                // Verifica se há filmes para avaliar
                if (totalFilmes == 0) {
                    System.out.println("Nenhum filme cadastrado.");
                    continue; // volta para o menu
                }

                // Mostra a lista de filmes cadastrados (preciso entender pq tem [i]?
                for (int i = 0; i < totalFilmes; i++) {
                    System.out.println(i + " - " + nomes[i]);
                }

                System.out.print("Escolha o número do filme: ");
                int escolha = input.nextInt();

                // Verifica se o número do filme é válido
                if (escolha >= 0 && escolha < totalFilmes) {
                    System.out.print("Nota (0 a 10): ");
                    double nota = input.nextDouble();

                    // Verifica se a nota está entre 0 e 10
                    if (nota >= 0 && nota <= 10) {
                        somasNotas[escolha] += nota;           // Soma a nota
                        contadoresNotas[escolha]++;            // Conta uma nova avaliação
                        System.out.println("Nota registrada!");
                    } else {
                        System.out.println("Nota inválida.");
                    }
                } else {
                    System.out.println("Filme inválido.");
                }

                // LISTAR FILMES
            } else if (opcao == 3) {
                for (int i = 0; i < totalFilmes; i++) {
                    double media;

                    // Se o filme tiver avaliações, calcula a média
                    if (contadoresNotas[i] > 0) {
                        media = somasNotas[i] / contadoresNotas[i];
                    } else {
                        media = 0; // Se não teve nota, média é 0
                    }

                    System.out.println("\nFilme: " + nomes[i]);
                    System.out.println("Categoria: " + categorias[i]);
                    System.out.printf("Média: %.2f\n", media); // Mostra a média com 2 casas (pq do %)

                    // Mostra um comentário baseado na média
                    if (media >= 8) {
                        System.out.println("Comentário: Altamente recomendado!");
                    } else if (media >= 5) {
                        System.out.println("Comentário: Mediano, vale a pena se curtir o gênero.");
                    } else {
                        System.out.println("Comentário: Talvez não agrade a todos.");
                    }
                }

                // SAIR DO PROGRAMA
            } else if (opcao == 4) {
                System.out.println("Encerrando...");
                break; // Encerra o laço e o programa

                // OPÇÃO INVÁLIDA
            } else {
                System.out.println("Opção inválida!");
            }
        }

        // Fecha o Scanner no final do programa
        input.close();
    }
}