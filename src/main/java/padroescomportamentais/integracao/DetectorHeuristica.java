package padroescomportamentais.integracao;

public class DetectorHeuristica implements Detector {
    private Detector proximo;

    @Override
    public void setProximo(Detector proximo) {
        this.proximo = proximo;
    }

    @Override
    public Resultado detectar(Artefato artefato) {
        System.out.println("  [CHAIN] Executando análise heurística em: " + artefato.getNome());
        Resultado resultado = new Resultado();

        if (artefato.getTamanhoBytes() > 5000) {
            System.out.println("    -> Comportamento suspeito (arquivo grande).");
            resultado.adicionarRisco(50);
        } else {
            System.out.println("    -> Heurística normal.");
        }

        if (proximo != null) {
            Resultado proximoResultado = proximo.detectar(artefato);
            resultado.adicionarRisco(proximoResultado.getNivelRisco()); // Acumula risco
            return resultado;
        }
        return resultado;
    }
}