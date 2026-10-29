package padroescomportamentais.integracao;

public class Artefato {
    private final String nome;
    private final String conteudo;
    private final int tamanhoBytes;

    public Artefato(String nome, String conteudo, int tamanhoBytes) {
        this.nome = nome;
        this.conteudo = conteudo;
        this.tamanhoBytes = tamanhoBytes;
    }

    public String getNome() { return nome; }
    public String getConteudo() { return conteudo; }
    public int getTamanhoBytes() { return tamanhoBytes; }
}