import java.util.*;

public class ImpressoraFIFO {
    private Queue<Documento> fila;
    private int capacidade;

    public ImpressoraFIFO(int capacidade) {
        this.capacidade = capacidade;
        this.fila = new LinkedList<>();
    }

    public boolean adicionarDocumento(Documento doc) {
        if (fila.size() >= capacidade) return false;
        return fila.offer(doc);
    }

    public void imprimirDocumento() {
        if (fila.isEmpty()) {
            System.out.println("Fila vazia.");
            return;
        }
        Documento doc = fila.poll();
        long tempoEspera = System.currentTimeMillis() - doc.getHorarioSolicitacao();
        System.out.println("Imprimindo: " + doc.getNomeArquivo() + ", Usuário: " + doc.getUsuario() + ", Espera: " + tempoEspera + "ms");
    }

    public void consultarDocumento(String nomeArquivo) {
        int pos = 1;
        for (Documento doc : fila) {
            if (doc.getNomeArquivo().equalsIgnoreCase(nomeArquivo)) {
                System.out.println("Encontrado: " + doc.getNomeArquivo() + ", Usuário: " + doc.getUsuario() + ", Posição: " + pos + ", Solicitado em: " + new java.util.Date(doc.getHorarioSolicitacao()));
                return;
            }
            pos++;
        }
        System.out.println("Documento não encontrado.");
    }

    public void exibirFila() {
        if (fila.isEmpty()) {
            System.out.println("Fila vazia.");
            return;
        }
        for (Documento doc : fila) {
            System.out.println(doc);
        }
    }
}
