package ex3;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroCliente {
    static final int TAM = 10; //tamanho do vetor de clientes
    static final int CPF = 11; //números do CPF
    
    public static void menu() {
        System.out.println("\n---MENU---");
        System.out.println("1 -> INSERIR CLIENTE");
        System.out.println("2 -> BUSCAR CLIENTE");
        System.out.println("3 -> FECHAR PROGRAMA");
        System.out.print("SELECIONE UMA OPERACAO: ");
    }
    
    public static Cliente criarCliente(Scanner teclado) {
        Cliente cliente = new Cliente();
        boolean verificaNome = true;
        boolean verificaCpf = true;
        teclado.nextLine(); //evitar erro
        while(verificaNome) {
            try {
                System.out.print("\nInsira o nome do cliente: "); //Deixar em branco para ativar exceção
                cliente.setNome(teclado.nextLine());
                verificaNome = false; //Sai do loop quando estiver tudo certo
            } catch (DadoInvalidoException ex) {
                System.out.println(ex.getMessage());
            }
        }
        while(verificaCpf) {
            try {
                System.out.print("\nInsira o CPF do cliente: "); //Colocar uma sequência com mais ou menos digitos para ativar a exceção
                cliente.setCpf(teclado.next());
                verificaCpf = false; //Sai do loop quando estiver tudo certo
            } catch (DadoInvalidoException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return cliente;
    }
    
    public static boolean verificarCPF(ArrayList<Cliente> clientes, String cpf) {
        for (Cliente cliente: clientes) {
                if (cliente.getCpf().equals(cpf)) return true;
        }
        return false;
    }
    
    public static ArrayList inserir(ArrayList clientes, Scanner teclado) {
        try {
            if (clientes.size() == TAM) throw new RepositorioException("\n---NAO EH POSSIVEL ADICIONAR NOVOS CLIENTES---");
            Cliente cli = criarCliente(teclado);
            if (verificarCPF(clientes, cli.getCpf())) throw new ClienteJaExistenteException("\n---CPF JA CADASTRADO---");
            clientes.add(cli);
        } catch (RepositorioException | ClienteJaExistenteException ex) {
            System.out.println(ex.getMessage());
        }
        return clientes;
    }
    
    public static String buscar(ArrayList<Cliente> clientes, Scanner teclado) {
        String cpf = null;
        boolean verificaCpf = true;
        while(verificaCpf) {
            try {
                System.out.print("\nInsira o CPF do cliente: "); //Colocar uma sequência com mais ou menos digitos para ativar a exceção
                cpf = teclado.next();
                if (cpf.length() != CPF) throw new DadoInvalidoException("\n---INFORME APENAS OS 11 DIGITOS DO CPF---");
                verificaCpf = false; //Sai do loop quando estiver tudo certo
            } catch (DadoInvalidoException ex) {
                System.out.println(ex.getMessage());
            }
        }
        try {
            for (Cliente cliente: clientes) {
                if (cliente.getCpf().equals(cpf)) return ("\nNOME: "+cliente.getNome());
            }
            throw new ClienteInexistenteException("\n---CPF NAO ENCONTRADO---");
        } catch (ClienteInexistenteException ex) {
            System.out.print(ex.getMessage());
            return ("");
        }
    }
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>(TAM);
        Cliente cli;
        int op;
        do {
            menu();
            op = teclado.nextInt();
            switch(op) {
                case 1 -> clientes = inserir(clientes, teclado);
                case 2 -> System.out.println(buscar(clientes, teclado));
                case 3 -> System.out.println("\n---FIM DO PROGRAMA---");
                default -> System.out.println("\n---COMANDO INVALIDO---");
            }
        } while(op != 3);
    }
}
