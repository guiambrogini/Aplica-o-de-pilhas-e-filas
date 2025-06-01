import java.util.*;

public class ReimpressoraLIFO {
    private Stack<Documento> pilha;
    private int capacidade;

    public ReimpressoraLIFO(int capacidade) {
        this.capacidade = capacidade;
        this.pilha = new Stack<>();
    }

    public boolean adicionarReimpressao(Documento doc) {
        if (pilha.size() >= capacidade) return false;
        pilha.push(doc);
        return true;
    }

    public void imprimirReimpressao() {
        if (pilha.isEmpty()) {
            System.out.println("Pilha vazia.");
            return;
        }
        Documento doc = pilha.pop();
        long tempoDecorrido = System.currentTimeMillis() - doc.getHorarioSolicitacao();
        System.out.println("Reimprimindo: " + doc.getNomeArquivo() + ", Usuário: " + doc.getUsuario() + ", Tempo desde solicitação: " + tempoDecorrido + "ms");
    }

    public void consultarReimpressao(String nomeArquivo) {
        for (int i = pilha.size() - 1; i >= 0; i--) {
            Documento doc = pilha.get(i);
            if (doc.getNomeArquivo().equalsIgnoreCase(nomeArquivo)) {
                System.out.println("Encontrado na pilha: " + doc.getNomeArquivo() + ", Usuário: " + doc.getUsuario() + ", Posição: " + (pilha.size() - i) + ", Solicitado em: " + new java.util.Date(doc.getHorarioSolicitacao()));
                return;
            }
        }
        System.out.println("Documento não encontrado.");
    }

    public void exibirPilha() {
        if (pilha.isEmpty()) {
            System.out.println("Pilha vazia.");
            return;
        }
        for (Documento doc : pilha) {
            System.out.println(doc);
        }
    }
}
