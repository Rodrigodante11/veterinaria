package model;

import java.util.List;

public class Medicacao {
    private int id;
    private String nome;
    private int quantidade;
    private double valor;
    
    
    Funcionario funcionario;
    Animal Animal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Animal getAnimal() {
        return Animal;
    }

    public void setAnimal(Animal Animal) {
        this.Animal = Animal;
    }
    
    
    
}
