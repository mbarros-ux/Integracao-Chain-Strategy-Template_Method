package padroescomportamentais.integracao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PipelineIntegradoTest {

    private PipelineAnaliseAmeaca pipeline;
    private Detector detectorChain;

    @BeforeEach
    void setUp() {
        pipeline = new PipelineArquivo();

        Detector assinatura = new DetectorAssinatura();
        Detector heuristica = new DetectorHeuristica();
        assinatura.setProximo(heuristica);
        this.detectorChain = assinatura;
    }

    @Test
    void deveAprovarArquivoSeguro() {
        Artefato artefato = new Artefato("foto.jpg", "imagem", 500);
        assertDoesNotThrow(() -> pipeline.analisar(artefato, detectorChain, new RespostaBloqueio()));
    }

    @Test
    void deveDetectarAmeacaPorAssinaturaEInterromperChain() {
        Artefato artefato = new Artefato("virus_trojan.bat", "malware", 100);
        assertDoesNotThrow(() -> pipeline.analisar(artefato, detectorChain, new RespostaQuarentena()));
    }

    @Test
    void devePermitirTrocaDinamicaDeEstrategia() {
        Artefato artefato = new Artefato("script_suspeito.ps1", "comando estranho", 6000);

        assertDoesNotThrow(() -> pipeline.analisar(artefato, detectorChain, new RespostaQuarentena()));

        assertDoesNotThrow(() -> pipeline.analisar(artefato, detectorChain, new RespostaBloqueio()));
    }
}