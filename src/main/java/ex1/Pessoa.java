package ex1;

public class Pessoa {
    private String name;
    private Integer age;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) throws IllegalArgumentException{
        //Exceção para quando o método recebe um parâmetro inválido
        if(age < 0) throw new IllegalArgumentException();
        this.age = age;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getAge() {
        return this.age;
    }
}
