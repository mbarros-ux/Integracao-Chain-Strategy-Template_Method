package padroescomportamentais.integracao;

public class RespostaQuarentena implements EstrategiaResposta {
    @Override
    public void executar(Artefato artefato, int nivelRisco) {
        System.out.println("  [STRATEGY] Executando Quarentena: '" + artefato.getNome() + "' isolado com risco " + nivelRisco + ".");
    }
}