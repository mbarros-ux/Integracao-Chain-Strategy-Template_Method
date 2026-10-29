package padroescomportamentais.integracao;

public abstract class PipelineAnaliseAmeaca {

    public final void analisar(Artefato artefato, Detector detector, EstrategiaResposta estrategia) {
        System.out.println("\n=== INICIANDO PIPELINE DE ANÁLISE ===");
        System.out.println("Alvo: " + artefato.getNome());

        coletarMetadados(artefato);
        Resultado resultado = executarDetecção(artefato, detector);
        aplicarResposta(artefato, resultado, estrategia);

        System.out.println("=== ANÁLISE CONCLUÍDA ===\n");
    }

    protected abstract void coletarMetadados(Artefato artefato);
    protected abstract Resultado executarDetecção(Artefato artefato, Detector detector);
    protected abstract void aplicarResposta(Artefato artefato, Resultado resultado, EstrategiaResposta estrategia);
}