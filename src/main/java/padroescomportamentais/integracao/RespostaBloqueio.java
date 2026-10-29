package padroescomportamentais.integracao;

public class RespostaBloqueio implements EstrategiaResposta {
    @Override
    public void executar(Artefato artefato, int nivelRisco) {
        System.out.println("  [STRATEGY] Executando Bloqueio: IP/Arquivo '" + artefato.getNome() + "' bloqueado permanentemente (Risco: " + nivelRisco + ").");
    }
}