import java.util.*;

public class SimuladorFilaImpressao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ImpressoraFIFO impressora = new ImpressoraFIFO(5); // capacidade da fila
        int opcao;

        do {
            System.out.println("\n--- MENU IMPRESSORA (FIFO) ---");
            System.out.println("1 - Adicionar documento");
            System.out.println("2 - Imprimir documento");
            System.out.println("3 - Consultar documento");
            System.out.println("4 - Exibir fila");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt(); scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do arquivo: ");
                    String nomeArquivo = scanner.nextLine();
                    System.out.print("Nome do usuário: ");
                    String usuario = scanner.nextLine();
                    boolean adicionado = impressora.adicionarDocumento(new Documento(nomeArquivo, usuario));
                    if (!adicionado)
                        System.out.println("Fila cheia. Não foi possível adicionar.");
                    break;
                case 2:
                    impressora.imprimirDocumento();
                    break;
                case 3:
                    System.out.print("Nome do arquivo a consultar: ");
                    String consulta = scanner.nextLine();
                    impressora.consultarDocumento(consulta);
                    break;
                case 4:
                    impressora.exibirFila();
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
