public class SistemaHospitalar {
    private ArvoreBinariaDePacientes cadastroDePacientes = new ArvoreBinariaDePacientes();
    private FilaDeEsperaDaEmergencia filaDeEsperaDaEmergencia = new FilaDeEsperaDaEmergencia();

    public boolean cadastrarPaciente(int numeroDoProntuario, String nome, int idade) {
        if (cadastroDePacientes.buscarPacientePeloProntuario(numeroDoProntuario) != null) {
            return false;
        }
        cadastroDePacientes.inserirPaciente(new Paciente(numeroDoProntuario, nome, idade));
        return true;
    }

    public Paciente buscarPaciente(int numeroDoProntuario) {
        return cadastroDePacientes.buscarPacientePeloProntuario(numeroDoProntuario);
    }

    public boolean descadastrarPaciente(int numeroDoProntuario) {
        if (cadastroDePacientes.buscarPacientePeloProntuario(numeroDoProntuario) == null) {
            return false;
        }
        filaDeEsperaDaEmergencia.removerPacientePeloProntuario(numeroDoProntuario);
        cadastroDePacientes.removerPacientePeloProntuario(numeroDoProntuario);
        return true;
    }

    public String colocarPacienteNaFilaDeEmergencia(int numeroDoProntuario) {
        Paciente paciente = cadastroDePacientes.buscarPacientePeloProntuario(numeroDoProntuario);

        if (paciente == null) {
            return "Paciente nao cadastrado.";
        }
        if (filaDeEsperaDaEmergencia.buscarPacientePeloProntuario(numeroDoProntuario) != null) {
            return "Paciente ja esta na fila.";
        }
        filaDeEsperaDaEmergencia.enfileirarPaciente(paciente);
        return "Paciente colocado na fila de espera.";
    }

    public Paciente atenderProximoPacienteDaFila(String dataDaConsulta, String descricaoDoAtendimento) {
        Paciente pacienteAtendido = filaDeEsperaDaEmergencia.desenfileirarProximoPaciente();

        if (pacienteAtendido != null) {
            Consulta novaConsulta = new Consulta(dataDaConsulta, descricaoDoAtendimento);
            pacienteAtendido.getHistoricoDeConsultas().adicionarConsultaNoFinal(novaConsulta);
        }
        return pacienteAtendido;
    }

    public boolean removerPacienteDaFilaDeEmergencia(int numeroDoProntuario) {
        return filaDeEsperaDaEmergencia.removerPacientePeloProntuario(numeroDoProntuario);
    }

    public void listarFilaDeEmergencia() {
        filaDeEsperaDaEmergencia.listarPacientesEmEspera();
    }

    public void exibirHistoricoDeConsultas(int numeroDoProntuario) {
        Paciente paciente = cadastroDePacientes.buscarPacientePeloProntuario(numeroDoProntuario);
        if (paciente == null) {
            System.out.println("Paciente nao cadastrado.");
            return;
        }
        System.out.println("Historico de " + paciente);
        paciente.getHistoricoDeConsultas().listarConsultas();
    }

    public boolean removerConsultaDoHistorico(int numeroDoProntuario, String dataDaConsulta) {
        Paciente paciente = cadastroDePacientes.buscarPacientePeloProntuario(numeroDoProntuario);
        if (paciente == null) {
            return false;
        }
        return paciente.getHistoricoDeConsultas().removerConsultaPelaData(dataDaConsulta);
    }

    public void listarPacientesEmOrdem() {
        cadastroDePacientes.exibirPacientesEmOrdem();
    }

    public void listarPacientesEmPreOrdem() {
        cadastroDePacientes.exibirPacientesEmPreOrdem();
    }

    public void listarPacientesEmPosOrdem() {
        cadastroDePacientes.exibirPacientesEmPosOrdem();
    }
}
