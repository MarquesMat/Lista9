package ex2;

public class ContaCorrente {
    private float limite, saldo, valorLimite;
    
    public ContaCorrente(float limite, float saldo, float valorLimite) {
        this.limite = limite;
        this.saldo = saldo;
        this.valorLimite = valorLimite;
    }
    
    public void sacar(float valor) {
        if(valor < 0) throw new IllegalArgumentException("\nNAO EH POSSIVEL INSERIR UM VALOR NEGATIVO");
        if(valor > this.saldo+this.limite) throw new IllegalArgumentException("\nSALDO INSUFICIENTE");
        this.saldo -= valor;
        if(this.saldo < 0) {
            this.limite += this.saldo;
            this.saldo = 0;
        }
    }
    
    public void depositar(float valor) {
        if(valor < 0) throw new IllegalArgumentException("\nNAO EH POSSIVEL INSERIR UM VALOR NEGATIVO");
        this.saldo += valor;
    }
    
    public void setValorLimite(float valor) {
        if(valor < 0) throw new IllegalArgumentException("\nNAO EH POSSIVEL INSERIR UM VALOR NEGATIVO");
        if(valor > this.valorLimite) throw new IllegalArgumentException("\nLIMITE NAO PERMITIDO");
        this.limite = valor;
    }
    
    public float getLimite() {
        return this.limite;
    }
    
    public float getSaldo() {
        return this.saldo;
    }
    
    public float getValorLimite() {
        return this.valorLimite;
    }
}
