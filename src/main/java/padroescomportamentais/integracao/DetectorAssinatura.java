package padroescomportamentais.integracao;

public class DetectorAssinatura implements Detector {
    private Detector proximo;

    @Override
    public void setProximo(Detector proximo) {
        this.proximo = proximo;
    }

    @Override
    public Resultado detectar(Artefato artefato) {
        System.out.println("  [CHAIN] Verificando assinaturas conhecidas em: " + artefato.getNome());
        Resultado resultado = new Resultado();

        if (artefato.getNome().contains("trojan") || artefato.getConteudo().contains("malware")) {
            System.out.println("    -> Assinatura de ameaça conhecida encontrada!");
            resultado.adicionarRisco(100);
            return resultado; // Interrompe a cadeia se for crítico
        }

        System.out.println("    -> Limpo por assinatura.");
        if (proximo != null) {
            return proximo.detectar(artefato);
        }
        return resultado;
    }
}