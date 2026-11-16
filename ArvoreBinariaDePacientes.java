public class ArvoreBinariaDePacientes {
    private NoDaArvore raiz;

    public void inserirPaciente(Paciente novoPaciente) {
        raiz = inserirNaSubarvore(raiz, novoPaciente);
    }

    private NoDaArvore inserirNaSubarvore(NoDaArvore noAtual, Paciente novoPaciente) {
        if (noAtual == null) {
            return new NoDaArvore(novoPaciente);
        }

        if (novoPaciente.getNumeroDoProntuario() < noAtual.getPaciente().getNumeroDoProntuario()) {
            noAtual.setFilhoEsquerdo(inserirNaSubarvore(noAtual.getFilhoEsquerdo(), novoPaciente));
        } else if (novoPaciente.getNumeroDoProntuario() > noAtual.getPaciente().getNumeroDoProntuario()) {
            noAtual.setFilhoDireito(inserirNaSubarvore(noAtual.getFilhoDireito(), novoPaciente));
        }
        return noAtual;
    }

    public Paciente buscarPacientePeloProntuario(int prontuarioProcurado) {
        NoDaArvore noAtual = raiz;

        while (noAtual != null) {
            int prontuarioDoNoAtual = noAtual.getPaciente().getNumeroDoProntuario();

            if (prontuarioProcurado == prontuarioDoNoAtual) {
                return noAtual.getPaciente();
            }
            if (prontuarioProcurado < prontuarioDoNoAtual) {
                noAtual = noAtual.getFilhoEsquerdo();
            } else {
                noAtual = noAtual.getFilhoDireito();
            }
        }
        return null;
    }

    public void removerPacientePeloProntuario(int prontuarioParaRemover) {
        raiz = removerDaSubarvore(raiz, prontuarioParaRemover);
    }

    private NoDaArvore removerDaSubarvore(NoDaArvore noAtual, int prontuarioParaRemover) {
        if (noAtual == null) {
            return null;
        }

        int prontuarioDoNoAtual = noAtual.getPaciente().getNumeroDoProntuario();

        if (prontuarioParaRemover < prontuarioDoNoAtual) {
            noAtual.setFilhoEsquerdo(removerDaSubarvore(noAtual.getFilhoEsquerdo(), prontuarioParaRemover));
            return noAtual;
        }
        if (prontuarioParaRemover > prontuarioDoNoAtual) {
            noAtual.setFilhoDireito(removerDaSubarvore(noAtual.getFilhoDireito(), prontuarioParaRemover));
            return noAtual;
        }


        if (noAtual.getFilhoEsquerdo() == null && noAtual.getFilhoDireito() == null) {
            return null;
        }

        if (noAtual.getFilhoEsquerdo() == null) {
            return noAtual.getFilhoDireito();
        }
        if (noAtual.getFilhoDireito() == null) {
            return noAtual.getFilhoEsquerdo();
        }

        NoDaArvore noComMaiorProntuario = encontrarNoComMaiorProntuario(noAtual.getFilhoEsquerdo());
        noAtual.setPaciente(noComMaiorProntuario.getPaciente());
        noAtual.setFilhoEsquerdo(
            removerDaSubarvore(noAtual.getFilhoEsquerdo(), noComMaiorProntuario.getPaciente().getNumeroDoProntuario())
        );
        return noAtual;
    }

    private NoDaArvore encontrarNoComMaiorProntuario(NoDaArvore noInicial) {
        NoDaArvore noAtual = noInicial;
        while (noAtual.getFilhoDireito() != null) {
            noAtual = noAtual.getFilhoDireito();
        }
        return noAtual;
    }

    public void exibirPacientesEmOrdem() {
        exibirEmOrdem(raiz);
    }

    private void exibirEmOrdem(NoDaArvore noAtual) {
        if (noAtual == null) {
            return;
        }
        exibirEmOrdem(noAtual.getFilhoEsquerdo());
        System.out.println(noAtual.getPaciente());
        exibirEmOrdem(noAtual.getFilhoDireito());
    }

    public void exibirPacientesEmPreOrdem() {
        exibirEmPreOrdem(raiz);
    }

    private void exibirEmPreOrdem(NoDaArvore noAtual) {
        if (noAtual == null) {
            return;
        }
        System.out.println(noAtual.getPaciente());
        exibirEmPreOrdem(noAtual.getFilhoEsquerdo());
        exibirEmPreOrdem(noAtual.getFilhoDireito());
    }

    public void exibirPacientesEmPosOrdem() {
        exibirEmPosOrdem(raiz);
    }

    private void exibirEmPosOrdem(NoDaArvore noAtual) {
        if (noAtual == null) {
            return;
        }
        exibirEmPosOrdem(noAtual.getFilhoEsquerdo());
        exibirEmPosOrdem(noAtual.getFilhoDireito());
        System.out.println(noAtual.getPaciente());
    }

    public boolean estaVazia() {
        return raiz == null;
    }
}
