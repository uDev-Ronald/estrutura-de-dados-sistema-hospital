public class Consulta {
    private String dataDaConsulta;
    private String descricaoDoAtendimento;

    public Consulta(String dataDaConsulta, String descricaoDoAtendimento) {
        this.dataDaConsulta = dataDaConsulta;
        this.descricaoDoAtendimento = descricaoDoAtendimento;
    }

    public String getDataDaConsulta() {
        return dataDaConsulta;
    }

    public String getDescricaoDoAtendimento() {
        return descricaoDoAtendimento;
    }

    @Override
    public String toString() {
        return dataDaConsulta + " - " + descricaoDoAtendimento;
    }
}
