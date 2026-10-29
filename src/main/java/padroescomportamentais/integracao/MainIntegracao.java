package padroescomportamentais.integracao;

public class MainIntegracao {
    public static void main(String[] args) {
        Detector detectorAssinatura = new DetectorAssinatura();
        Detector detectorHeuristica = new DetectorHeuristica();
        detectorAssinatura.setProximo(detectorHeuristica);

        PipelineAnaliseAmeaca pipeline = new PipelineArquivo();

        // 1. Cenário A:
        Artefato arquivoSeguro = new Artefato("documento.pdf", "conteudo normal", 1024);
        pipeline.analisar(arquivoSeguro, detectorAssinatura, new RespostaQuarentena());

        // 2. Cenário B:
        Artefato arquivoTrojan = new Artefato("instalador_trojan.exe", "malware_payload", 2048);
        pipeline.analisar(arquivoTrojan, detectorAssinatura, new RespostaBloqueio());

        // 3. Cenário C:
        Artefato arquivoGrande = new Artefato("backup_dados.zip", "dados", 10000);
        pipeline.analisar(arquivoGrande, detectorAssinatura, new RespostaQuarentena());
    }
}