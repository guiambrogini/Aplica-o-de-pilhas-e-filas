import java.util.Date;

public class Documento {
    private String nomeArquivo;
    private String usuario;
    private long horarioSolicitacao;

    public Documento(String nomeArquivo, String usuario) {
        this.nomeArquivo = nomeArquivo;
        this.usuario = usuario;
        this.horarioSolicitacao = System.currentTimeMillis();
    }

    public String getNomeArquivo() { return nomeArquivo; }
    public String getUsuario() { return usuario; }
    public long getHorarioSolicitacao() { return horarioSolicitacao; }

    @Override
    public String toString() {
        return nomeArquivo + " - " + usuario + " - " + new Date(horarioSolicitacao);
    }
}
