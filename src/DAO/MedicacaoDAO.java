package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.Animal;
import model.Funcionario;
import model.Medicacao;

public class MedicacaoDAO {
    private final Connection con;
    
    public MedicacaoDAO(){
        this.con =new ConnectionFactory().getConnection();
    }
    //metodo Cadastrar Medicação
    public void cadastrarMedicacao(Medicacao medicacao){
        
        try {
            
            String sql="INSERT INTO medicacao(idmedicacao,nome,qtd,valor,funcionario_crmv,animal_idanimal) "
                    +"VALUES(?,?,?,?,?,?)";
            
            //tratar e executar os comandos sql
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setInt(1, medicacao.getId());
            stmt.setString(2, medicacao.getNome());
            stmt.setDouble(3, medicacao.getQuantidade());
            stmt.setDouble(4, medicacao.getValor());
            stmt.setInt(5, medicacao.getFuncionario().getCrmv());
            stmt.setInt(6, medicacao.getAnimal().getId());
            
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            
        } catch ( SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro as cadastrar " +e);
        }
    }
    
    //metodo Alterar Mecicacao
    public void alterarMedicacao(Medicacao medicacao){
        try {
            
            String sql="UPDATE medicacao  set nome=?,qtd=?,valor=?,funcionario_crmv=?,animal_idanimal=? WHERE idmedicacao=?";
                   
            //tratar e executar os comandos sql
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, medicacao.getNome());
            stmt.setInt(2, medicacao.getQuantidade() );
            stmt.setDouble(3, medicacao.getValor());
            stmt.setInt(4, medicacao.getFuncionario().getCrmv());
            stmt.setInt(5, medicacao.getAnimal().getId());
            stmt.setInt(6, medicacao.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
            
        } catch ( SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro as alterar " +e);
        }
    }
    
    //metodo Excluir Medicacao
    public void excluirMedicacao(Medicacao medicacao){
        try {
            
            String sql="DELETE FROM medicacao WHERE idmedicacao =? ";
            
            //tratar e executar os comandos sql
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setInt(1, medicacao.getId());
                       
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
            
        } catch ( SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro ao Excluir " +e);
        }
    }
    
     //metodo Listar Medicacao
    public List<Medicacao>  listarMedicacao(){
        try {
            List<Medicacao>lista= new ArrayList<>();
            
            String sql= "SELECT * FROM Medicacao";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                Medicacao medicacao = new Medicacao();
                
                medicacao.setId(rs.getInt("idmedicacao"));
                
                medicacao.setNome(rs.getString("nome"));
                medicacao.setQuantidade(rs.getInt("qtd"));
                medicacao.setValor(rs.getInt("valor"));
                
                Funcionario funcionario = new Funcionario();
                funcionario.setCrmv(rs.getInt("funcionario_crmv"));
                medicacao.setFuncionario(funcionario);
                
                Animal animal= new Animal();
                animal.setId(rs.getInt("animal_idanimal"));
                medicacao.setAnimal(animal);
                lista.add(medicacao);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro " +e);
            return null;
        }
    }
}
