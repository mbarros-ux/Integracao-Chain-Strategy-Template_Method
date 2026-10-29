package padroescomportamentais.integracao;

public interface Detector {
    void setProximo(Detector proximo);
    Resultado detectar(Artefato artefato);
}