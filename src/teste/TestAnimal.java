package teste;

import DAO.AnimalDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Animal;
import model.Cliente;

public class TestAnimal {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        
        List<Animal>lista= new ArrayList<>();
        AnimalDAO animalDAO=new AnimalDAO();
        lista=animalDAO.listarAnimal();
        
        for (Animal animal : lista) {
            System.out.println("Animal: ");
            System.out.println("id: "+animal.getId());
            System.out.println("Tipo: "+animal.getTipo());
            System.out.println("Nome: "+animal.getNome());
            System.out.println("Raça: "+animal.getRaca());
            System.out.println("Cliente Cpf: "+animal.getCliente().getCpf());
            
        }
        
        Cliente cliente=new Cliente();
        Animal animal= new Animal();
        
        /*
        System.out.println("Cadastrar Animal");
        System.out.print("idAnimal: ");
        animal.setId(sc.nextInt());
        System.out.print("Tipo: ");
        sc.nextLine();
        animal.setTipo(sc.nextLine());
        System.out.print("Nome: ");
        animal.setNome(sc.nextLine());
        System.out.print("Raça: ");
        animal.setRaca(sc.nextLine());
        System.out.print("cliente cpf: ");
        cliente.setCpf(sc.nextInt());
        animal.setCliente(cliente);
        
        animalDAO.cadastrarAnimal(animal);
        
        
        System.out.println("Alterar Animal");
        System.out.print("idanimal de quem vai alterar: ");
        animal.setId(sc.nextInt());
        System.out.print("Tipo: ");
        sc.nextLine();
        animal.setTipo(sc.nextLine());
        System.out.print("Nome: ");
        animal.setNome(sc.nextLine());
        System.out.print("Raça: ");
        animal.setRaca(sc.nextLine());
        System.out.print("cliente cpf: ");
        cliente.setCpf(sc.nextInt());
        animal.setCliente(cliente);
        animalDAO.alterarAnimal(animal);
        
        
        System.out.print("id do Animal a ser escluido:");
        animal.setId(sc.nextInt());
        animalDAO.excluirAnimal(animal);
*/

    }
}
