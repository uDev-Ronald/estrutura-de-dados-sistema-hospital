public class FilaDeEsperaDaEmergencia {
    private NoDaFila inicioDaFila;
    private NoDaFila fimDaFila;

    public boolean estaVazia() {
        return inicioDaFila == null;
    }

    public void enfileirarPaciente(Paciente paciente) {
        NoDaFila novoNo = new NoDaFila(paciente);

        if (estaVazia()) {
            inicioDaFila = novoNo;
            fimDaFila = novoNo;
            return;
        }

        fimDaFila.setProximoNo(novoNo);
        fimDaFila = novoNo;
    }

    public Paciente desenfileirarProximoPaciente() {
        if (estaVazia()) {
            return null;
        }

        Paciente pacienteQueSai = inicioDaFila.getPaciente();
        inicioDaFila = inicioDaFila.getProximoNo();

        if (inicioDaFila == null) {
            fimDaFila = null;
        }
        return pacienteQueSai;
    }

    public Paciente buscarPacientePeloProntuario(int prontuarioProcurado) {
        NoDaFila noAtual = inicioDaFila;
        while (noAtual != null) {
            if (noAtual.getPaciente().getNumeroDoProntuario() == prontuarioProcurado) {
                return noAtual.getPaciente();
            }
            noAtual = noAtual.getProximoNo();
        }
        return null;
    }

    public boolean removerPacientePeloProntuario(int prontuarioParaRemover) {
        if (estaVazia()) {
            return false;
        }

        if (inicioDaFila.getPaciente().getNumeroDoProntuario() == prontuarioParaRemover) {
            desenfileirarProximoPaciente();
            return true;
        }

        NoDaFila noAtual = inicioDaFila;
        while (noAtual.getProximoNo() != null) {
            NoDaFila noSeguinte = noAtual.getProximoNo();
            if (noSeguinte.getPaciente().getNumeroDoProntuario() == prontuarioParaRemover) {
                noAtual.setProximoNo(noSeguinte.getProximoNo());
                if (noSeguinte == fimDaFila) {
                    fimDaFila = noAtual;
                }
                return true;
            }
            noAtual = noSeguinte;
        }
        return false;
    }

    public void listarPacientesEmEspera() {
        if (estaVazia()) {
            System.out.println("Fila de espera vazia.");
            return;
        }
        int posicaoNaFila = 1;
        NoDaFila noAtual = inicioDaFila;
        while (noAtual != null) {
            System.out.println(posicaoNaFila + "o - " + noAtual.getPaciente());
            posicaoNaFila++;
            noAtual = noAtual.getProximoNo();
        }
    }
}
