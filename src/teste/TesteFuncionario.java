package teste;

import java.util.ArrayList;
import java.util.List;
import model.Funcionario;
import DAO.FuncionarioDAO;
import java.util.Scanner;

public class TesteFuncionario {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        List<Funcionario>lista= new ArrayList<>();
        FuncionarioDAO funcionarioDAO=new FuncionarioDAO();
        lista=funcionarioDAO.listarFuncionario();
        
        for (Funcionario funcionario : lista) {
            System.out.println("Funcionario: ");
            System.out.println("CRMV: "+funcionario.getCrmv());
            System.out.println("Nome: "+funcionario.getNome());
            System.out.println("Cargo: "+funcionario.getCargo());
            System.out.println("Idade: "+funcionario.getIdade());
            System.out.println("Salario: "+funcionario.getSalario());
            
        }
        
        Funcionario funcionario=new Funcionario();
        /*
        System.out.println("Alterar Funcionario");
        System.out.print("CRMV: ");
        funcionario.setCrmv(sc.nextInt());
        System.out.print("Nome: ");
        sc.nextLine();
        funcionario.setNome(sc.nextLine());
        System.out.print("Cargo: ");
        funcionario.setCargo(sc.nextLine());
        System.out.print("Idade: ");
        funcionario.setIdade(sc.nextInt());
        System.out.print("Salario: ");
        funcionario.setSalario(sc.nextDouble());
        
        funcionarioDAO.cadastrarFuncionario(funcionario);
        
        
        System.out.println("Alterar Funcionario");
        System.out.print("CRMV: ");
        funcionario.setCrmv(sc.nextInt());
        System.out.print("Nome: ");
        sc.nextLine();
        funcionario.setNome(sc.nextLine());
        System.out.print("Cargo: ");
        funcionario.setCargo(sc.nextLine());
        System.out.print("Idade: ");
        funcionario.setIdade(sc.nextInt());
        System.out.print("Salario: ");
        funcionario.setSalario(sc.nextDouble());
        
        funcionarioDAO.alterarFuncionario(funcionario);
        */
        
        System.out.print("CRMV do funcionario a ser escluido:");
        funcionario.setCrmv(sc.nextInt());
        funcionarioDAO.excluirFuncionario(funcionario);
        
        
                
    }
}
