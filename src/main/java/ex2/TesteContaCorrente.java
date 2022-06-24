package ex2;

public class TesteContaCorrente {
    public static void imprimirConta(ContaCorrente cc) {
        System.out.println("\nDADOS DA CONTA CORRENTE:");
        System.out.println("SALDO: "+cc.getSaldo());
        System.out.println("LIMITE: "+cc.getLimite());
        System.out.println("VALOR LIMITE: "+cc.getValorLimite());
    }
    
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente(2000, 3000, 10000);
        imprimirConta(cc);
        
        try {
            System.out.println("\nCOMANDO: SACAR -50");
            cc.sacar(-50);
            imprimirConta(cc);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        
        try {
            System.out.println("\nCOMANDO: DEPOISTAR 400");
            cc.depositar(400);
            imprimirConta(cc);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
                
        try {
            System.out.println("\nCOMANDO: ALTERAR LIMITE PARA 10500");
            cc.setValorLimite(10500);
            imprimirConta(cc);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        
        try {
            System.out.println("\nCOMANDO: ALTERAR LIMITE PARA 8000");
            cc.setValorLimite(8000);
            imprimirConta(cc);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        
        try {
            System.out.println("\nCOMANDO: DEPOISTAR -20");
            cc.depositar(-20);
            imprimirConta(cc);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
