public class NoDaFila {
    private Paciente paciente;
    private NoDaFila proximoNo;

    public NoDaFila(Paciente paciente) {
        this.paciente = paciente;
        this.proximoNo = null;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public NoDaFila getProximoNo() {
        return proximoNo;
    }

    public void setProximoNo(NoDaFila proximoNo) {
        this.proximoNo = proximoNo;
    }
}
