package ex3;

import static ex3.CadastroCliente.CPF;

public class Cliente {
    private String nome, cpf;
    
    public void setNome(String n) throws DadoInvalidoException {
        if (n.length() == 0) throw new DadoInvalidoException("\n---O NOME NAO PODE ESTAR VAZIO---");
        this.nome = n;
    }
            
    public void setCpf(String c) throws DadoInvalidoException {
        if (c.length() != CPF) throw new DadoInvalidoException("\n---INFORME APENAS OS 11 DIGITOS DO CPF---");
        this.cpf = c;
    }
    
    public String getNome() {
        return this.nome;
    }
        
    public String getCpf() {
        return this.cpf;
    }
}
