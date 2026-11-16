public class NoDaListaDeConsultas {
    private Consulta consulta;
    private NoDaListaDeConsultas proximoNo;

    public NoDaListaDeConsultas(Consulta consulta) {
        this.consulta = consulta;
        this.proximoNo = null;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public NoDaListaDeConsultas getProximoNo() {
        return proximoNo;
    }

    public void setProximoNo(NoDaListaDeConsultas proximoNo) {
        this.proximoNo = proximoNo;
    }
}
