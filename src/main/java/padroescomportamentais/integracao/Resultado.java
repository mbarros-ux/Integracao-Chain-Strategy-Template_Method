package padroescomportamentais.integracao;

public class Resultado {
    private int nivelRisco;
    private boolean malicioso;

    public Resultado() {
        this.nivelRisco = 0;
        this.malicioso = false;
    }

    public void adicionarRisco(int valor) {
        this.nivelRisco += valor;
        if (this.nivelRisco >= 80) {
            this.malicioso = true;
        }
    }

    public int getNivelRisco() { return nivelRisco; }
    public boolean isMalicioso() { return malicioso; }
}