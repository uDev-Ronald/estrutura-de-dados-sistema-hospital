import java.util.Scanner;

public class Main {
    private static Scanner leitor = new Scanner(System.in);
    private static SistemaHospitalar sistema = new SistemaHospitalar();

    public static void main(String[] args) {
        int opcaoEscolhida = -1;

        while (opcaoEscolhida != 0) {
            exibirMenu();
            opcaoEscolhida = lerNumeroInteiro("Escolha: ");
            executarOpcao(opcaoEscolhida);
        }
        System.out.println("Sistema encerrado.");
    }

    private static void exibirMenu() {
        System.out.println();
        System.out.println("=== GESTAO HOSPITALAR E TRIAGEM ===");
        System.out.println("1  - Cadastrar paciente");
        System.out.println("2  - Buscar paciente");
        System.out.println("3  - Remover paciente do cadastro");
        System.out.println("4  - Listar pacientes (em-ordem)");
        System.out.println("5  - Listar pacientes (pre-ordem)");
        System.out.println("6  - Listar pacientes (pos-ordem)");
        System.out.println("7  - Colocar paciente na fila da emergencia");
        System.out.println("8  - Atender proximo da fila");
        System.out.println("9  - Remover paciente da fila");
        System.out.println("10 - Listar fila de espera");
        System.out.println("11 - Ver historico de consultas");
        System.out.println("12 - Remover consulta do historico");
        System.out.println("0  - Sair");
    }

    private static void executarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarPaciente();
                break;
            case 2:
                buscarPaciente();
                break;
            case 3:
                removerPacienteDoCadastro();
                break;
            case 4:
                sistema.listarPacientesEmOrdem();
                break;
            case 5:
                sistema.listarPacientesEmPreOrdem();
                break;
            case 6:
                sistema.listarPacientesEmPosOrdem();
                break;
            case 7:
                colocarPacienteNaFila();
                break;
            case 8:
                atenderProximoDaFila();
                break;
            case 9:
                removerPacienteDaFila();
                break;
            case 10:
                sistema.listarFilaDeEmergencia();
                break;
            case 11:
                sistema.exibirHistoricoDeConsultas(lerNumeroInteiro("Prontuario: "));
                break;
            case 12:
                removerConsultaDoHistorico();
                break;
            case 0:
                break;
            default:
                System.out.println("Opcao invalida.");
        }
    }

    private static void cadastrarPaciente() {
        int numeroDoProntuario = lerNumeroInteiro("Prontuario: ");
        String nome = lerTexto("Nome: ");
        int idade = lerNumeroInteiro("Idade: ");

        if (sistema.cadastrarPaciente(numeroDoProntuario, nome, idade)) {
            System.out.println("Paciente cadastrado.");
        } else {
            System.out.println("Ja existe paciente com esse prontuario.");
        }
    }

    private static void buscarPaciente() {
        Paciente paciente = sistema.buscarPaciente(lerNumeroInteiro("Prontuario: "));
        if (paciente == null) {
            System.out.println("Paciente nao encontrado.");
        } else {
            System.out.println(paciente);
        }
    }

    private static void removerPacienteDoCadastro() {
        if (sistema.descadastrarPaciente(lerNumeroInteiro("Prontuario: "))) {
            System.out.println("Paciente removido.");
        } else {
            System.out.println("Paciente nao encontrado.");
        }
    }

    private static void colocarPacienteNaFila() {
        System.out.println(sistema.colocarPacienteNaFilaDeEmergencia(lerNumeroInteiro("Prontuario: ")));
    }

    private static void atenderProximoDaFila() {
        String dataDaConsulta = lerTexto("Data da consulta (ex: 15/11/2026): ");
        String descricaoDoAtendimento = lerTexto("Descricao do atendimento: ");

        Paciente pacienteAtendido = sistema.atenderProximoPacienteDaFila(dataDaConsulta, descricaoDoAtendimento);
        if (pacienteAtendido == null) {
            System.out.println("Fila vazia.");
        } else {
            System.out.println("Atendido: " + pacienteAtendido);
        }
    }

    private static void removerPacienteDaFila() {
        if (sistema.removerPacienteDaFilaDeEmergencia(lerNumeroInteiro("Prontuario: "))) {
            System.out.println("Paciente removido da fila.");
        } else {
            System.out.println("Paciente nao esta na fila.");
        }
    }

    private static void removerConsultaDoHistorico() {
        int numeroDoProntuario = lerNumeroInteiro("Prontuario: ");
        String dataDaConsulta = lerTexto("Data da consulta: ");

        if (sistema.removerConsultaDoHistorico(numeroDoProntuario, dataDaConsulta)) {
            System.out.println("Consulta removida.");
        } else {
            System.out.println("Consulta nao encontrada.");
        }
    }

    private static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return leitor.nextLine();
    }

    private static int lerNumeroInteiro(String mensagem) {
        while (true) {
            try {
                return Integer.parseInt(lerTexto(mensagem).trim());
            } catch (NumberFormatException erro) {
                System.out.println("Digite apenas numeros.");
            }
        }
    }
}
