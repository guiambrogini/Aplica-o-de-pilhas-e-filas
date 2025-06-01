import java.util.*;

public class SimuladorReimpressaoPilha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReimpressoraLIFO reimpressora = new ReimpressoraLIFO(5); // capacidade da pilha
        int opcao;

        do {
            System.out.println("\n--- MENU REIMPRESSÃO (LIFO) ---");
            System.out.println("1 - Solicitar reimpressão");
            System.out.println("2 - Executar reimpressão");
            System.out.println("3 - Consultar documento");
            System.out.println("4 - Exibir pilha");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt(); scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do arquivo: ");
                    String nomeArquivo = scanner.nextLine();
                    System.out.print("Nome do usuário: ");
                    String usuario = scanner.nextLine();
                    boolean adicionado = reimpressora.adicionarReimpressao(new Documento(nomeArquivo, usuario));
                    if (!adicionado)
                        System.out.println("Pilha cheia. Não foi possível adicionar.");
                    break;
                case 2:
                    reimpressora.imprimirReimpressao();
                    break;
                case 3:
                    System.out.print("Nome do arquivo a consultar: ");
                    String consulta = scanner.nextLine();
                    reimpressora.consultarReimpressao(consulta);
                    break;
                case 4:
                    reimpressora.exibirPilha();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
