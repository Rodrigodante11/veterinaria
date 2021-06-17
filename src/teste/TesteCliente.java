package teste;

import java.util.ArrayList;
import java.util.List;
import model.Funcionario;
import DAO.ClienteDAO;
import java.util.Scanner;
import model.Cliente;

public class TesteCliente {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        List<Cliente>lista= new ArrayList<>();
        ClienteDAO clienteDAO=new ClienteDAO();
        lista=clienteDAO.listarCliente();
        
        for (Cliente cliente : lista) {
            System.out.println("Cliente: ");
            System.out.println("CPF: "+cliente.getCpf());
            System.out.println("Nome: "+cliente.getNome());
            System.out.println("Telefone: "+cliente.getTelefone());
            System.out.println("endereco: "+cliente.getEndereco());
            System.out.println("funcionario crmv: "+cliente.getFuncionario().getCrmv());
            
        }
        
        Cliente cliente=new Cliente();
        Funcionario funcionario= new Funcionario();
        /*
        System.out.println("Cadastrar Cliente");
        System.out.print("cpf: ");
        cliente.setCpf(sc.nextInt());
        System.out.print("Nome: ");
        sc.nextLine();
        cliente.setNome(sc.nextLine());
        System.out.print("telefone: ");
        cliente.setTelefone(sc.nextLine());
        System.out.print("Endereço: ");
        cliente.setEndereco(sc.nextLine());
        System.out.print("Funcionario_crmv: ");
        funcionario.setCrmv(sc.nextInt());
        cliente.setFuncionario(funcionario);
        
        clienteDAO.cadastrarCliente(cliente);
        
        
        System.out.println("Alterar Cliente");
        System.out.print("cpf de quem vai alterar: ");
        cliente.setCpf(sc.nextInt());
        System.out.print("Nome: ");
        sc.nextLine();
        cliente.setNome(sc.nextLine());
        System.out.print("Telefone: ");
        cliente.setTelefone(sc.nextLine());
        System.out.print("Endereço: ");
        cliente.setEndereco(sc.nextLine());
        System.out.print("funcionario_crmv: ");
        funcionario.setCrmv(sc.nextInt());
        cliente.setFuncionario(funcionario);
        clienteDAO.alterarCliente(cliente);
        
        
        System.out.print("cpf do cliente a ser escluido:");
        cliente.setCpf(sc.nextInt());
        clienteDAO.excluirCliente(cliente);
*/

        
        
                
    }
}
