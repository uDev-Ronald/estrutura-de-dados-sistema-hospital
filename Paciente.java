public class Paciente {
    private int numeroDoProntuario;
    private String nome;
    private int idade;
    private ListaEncadeadaDeConsultas historicoDeConsultas;

    public Paciente(int numeroDoProntuario, String nome, int idade) {
        this.numeroDoProntuario = numeroDoProntuario;
        this.nome = nome;
        this.idade = idade;
        this.historicoDeConsultas = new ListaEncadeadaDeConsultas();
    }

    public int getNumeroDoProntuario() {
        return numeroDoProntuario;
    }

    public ListaEncadeadaDeConsultas getHistoricoDeConsultas() {
        return historicoDeConsultas;
    }

    @Override
    public String toString() {
        return "Prontuario " + numeroDoProntuario + " | " + nome + " | " + idade + " anos";
    }
}
