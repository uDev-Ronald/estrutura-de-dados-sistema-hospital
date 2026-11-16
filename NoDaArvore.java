public class NoDaArvore {
    private Paciente paciente;
    private NoDaArvore filhoEsquerdo;
    private NoDaArvore filhoDireito;

    public NoDaArvore(Paciente paciente) {
        this.paciente = paciente;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public NoDaArvore getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setFilhoEsquerdo(NoDaArvore filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public NoDaArvore getFilhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(NoDaArvore filhoDireito) {
        this.filhoDireito = filhoDireito;
    }
}
