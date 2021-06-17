package teste;


import DAO.MedicacaoDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Animal;
import model.Funcionario;
import model.Medicacao;



public class TestMedicacao {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        
        List<Medicacao>lista= new ArrayList<>();
        MedicacaoDAO medicacaoDAO=new MedicacaoDAO();
        lista=medicacaoDAO.listarMedicacao();
        
        for (Medicacao medicacao : lista) {
            System.out.println("Medicacao: ");
            System.out.println("id: "+medicacao.getId());
            System.out.println("Nome: "+medicacao.getNome());
            System.out.println("QTD: "+medicacao.getQuantidade());
            System.out.println("Valor: "+medicacao.getValor());
            System.out.println("Funcionario cmrv: "+medicacao.getFuncionario().getCrmv());
            System.out.println("Animal id: "+medicacao.getAnimal().getId());
            
        }
        
        Funcionario funcionario= new Funcionario();
        Animal animal= new Animal();
        Medicacao medicacao= new Medicacao();
        /*
        
        System.out.println("Cadastrar Medicacao");
        System.out.print("idMedicacao: ");
        medicacao.setId(sc.nextInt());
        System.out.print("Nome: ");
        sc.nextLine();
        medicacao.setNome(sc.nextLine());
        System.out.print("Qtd: ");
        medicacao.setQuantidade(sc.nextInt());
        System.out.print("Valor: ");
        medicacao.setValor(sc.nextDouble());
        
        System.out.print("Funcionario crmv ");
        funcionario.setCrmv(sc.nextInt());
        medicacao.setFuncionario(funcionario);
        
        System.out.print("Animal id: ");
        animal.setId(sc.nextInt());
        medicacao.setAnimal(animal);
        
        
        medicacaoDAO.cadastrarMedicacao(medicacao);
           
        System.out.println("Alterar Medicacao");
        System.out.print("idMedicação de quem vai alterar: ");
        medicacao.setId(sc.nextInt());
        System.out.print("Nome: ");
        sc.nextLine();
        medicacao.setNome(sc.nextLine());
        System.out.print("Qtd: ");
        medicacao.setQuantidade(sc.nextInt());
        System.out.print("Valor: ");
        medicacao.setValor(sc.nextDouble());
        
        System.out.print("Funcionario crmv ");
        funcionario.setCrmv(sc.nextInt());
        medicacao.setFuncionario(funcionario);
        
        System.out.print("Animal id: ");
        animal.setId(sc.nextInt());
        medicacao.setAnimal(animal);
        medicacaoDAO.alterarMedicacao(medicacao);
        */   
        
        System.out.print("id do Medicamento a ser escluido:");
        medicacao.setId(sc.nextInt());
        medicacaoDAO.excluirMedicacao(medicacao);

    }
}
