package ex1;

import java.util.Scanner;

public class Ex1 {
    public static int excecao(Scanner teclado, int age, Pessoa pessoa) {
        try {
            pessoa.setAge(age);
        } catch (IllegalArgumentException e) {
        //O método setAge em Pessoa possui um if que verifica se age não é negativo, se for será considerado um argumento inválido, chamando a exceção
            System.out.print("Insira um numero inteiro positivo: ");
            age = teclado.nextInt();
            age = excecao(teclado, age, pessoa); //Ignorar esse aviso
            pessoa.setAge(age);
        }
        return age;
    }
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();
        String name;
        int age = 0;
        boolean verifica = true;
        name = "Larissa";
        pessoa.setName(name);
        while (verifica) {
            try {
                System.out.printf("Insira a idade de %s: ", pessoa.getName()); //Inserir um número negativo irá ativar a exceção
                age = Integer.parseInt(teclado.next()); //Inserir uma palavra para ativar a exceção
                verifica = false;
            } catch (NumberFormatException ex) {
                //Exceção para quando uma String não pode ser convertida em um número
                System.out.println("ARGUMENTO INVALIDO!");
            }
        }
        age = excecao(teclado, age, pessoa);
        System.out.printf("\nNome: %s", pessoa.getName());
        System.out.printf("\nIdade: %d", pessoa.getAge());
    }
}
