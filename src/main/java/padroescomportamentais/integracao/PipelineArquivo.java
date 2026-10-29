package padroescomportamentais.integracao;

public class PipelineArquivo extends PipelineAnaliseAmeaca {

    @Override
    protected void coletarMetadados(Artefato artefato) {
        System.out.println("  [TEMPLATE] Coletando metadados: Tamanho=" + artefato.getTamanhoBytes() + " bytes");
    }

    @Override
    protected Resultado executarDetecção(Artefato artefato, Detector detector) {
        System.out.println("  [TEMPLATE] Delegando para a Cadeia de Detectores...");
        return detector.detectar(artefato);
    }

    @Override
    protected void aplicarResposta(Artefato artefato, Resultado resultado, EstrategiaResposta estrategia) {
        System.out.println("  [TEMPLATE] Nível de risco calculado: " + resultado.getNivelRisco());
        if (resultado.isMalicioso()) {
            System.out.println("  [TEMPLATE] Delegando para a Estratégia de Resposta...");
            estrategia.executar(artefato, resultado.getNivelRisco());
        } else {
            System.out.println("  [TEMPLATE] Artefato considerado seguro. Nenhuma ação necessária.");
        }
    }
}