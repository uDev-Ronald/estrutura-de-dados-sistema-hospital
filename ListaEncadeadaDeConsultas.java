public class ListaEncadeadaDeConsultas {
    private NoDaListaDeConsultas primeiroNo;
    private NoDaListaDeConsultas ultimoNo;

    public boolean estaVazia() {
        return primeiroNo == null;
    }

    public void adicionarConsultaNoFinal(Consulta novaConsulta) {
        NoDaListaDeConsultas novoNo = new NoDaListaDeConsultas(novaConsulta);

        if (estaVazia()) {
            primeiroNo = novoNo;
            ultimoNo = novoNo;
            return;
        }

        ultimoNo.setProximoNo(novoNo);
        ultimoNo = novoNo;
    }

    public Consulta buscarConsultaPelaData(String dataProcurada) {
        NoDaListaDeConsultas noAtual = primeiroNo;
        while (noAtual != null) {
            if (noAtual.getConsulta().getDataDaConsulta().equals(dataProcurada)) {
                return noAtual.getConsulta();
            }
            noAtual = noAtual.getProximoNo();
        }
        return null;
    }

    public boolean removerConsultaPelaData(String dataProcurada) {
        if (estaVazia()) {
            return false;
        }

        if (primeiroNo.getConsulta().getDataDaConsulta().equals(dataProcurada)) {
            primeiroNo = primeiroNo.getProximoNo();
            if (primeiroNo == null) {
                ultimoNo = null;
            }
            return true;
        }

        NoDaListaDeConsultas noAtual = primeiroNo;
        while (noAtual.getProximoNo() != null) {
            NoDaListaDeConsultas noSeguinte = noAtual.getProximoNo();
            if (noSeguinte.getConsulta().getDataDaConsulta().equals(dataProcurada)) {
                noAtual.setProximoNo(noSeguinte.getProximoNo());
                if (noSeguinte == ultimoNo) {
                    ultimoNo = noAtual;
                }
                return true;
            }
            noAtual = noSeguinte;
        }
        return false;
    }

    public void listarConsultas() {
        if (estaVazia()) {
            System.out.println("   (nenhuma consulta registrada)");
            return;
        }
        NoDaListaDeConsultas noAtual = primeiroNo;
        while (noAtual != null) {
            System.out.println("   - " + noAtual.getConsulta());
            noAtual = noAtual.getProximoNo();
        }
    }
}
