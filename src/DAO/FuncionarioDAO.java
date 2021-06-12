package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.Funcionario;


public class FuncionarioDAO {
    private Connection con;
    public FuncionarioDAO(){
        this.con =new ConnectionFactory().getConnection();
    }
    //metodo Cadastrar Funcionario
    public void cadastrarFuncionario(Funcionario funcionario){
        
        try {
            
            String sql="INSERT INTO funcionario(crmv,nome,cargo,salario,idade) "
                    +"VALUES(?,?,?,?,?)";
            
            //tratar e executar os comandos sql
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setInt(1, funcionario.getCrmv());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getCargo() );
            stmt.setDouble(4, funcionario.getSalario());
            stmt.setInt(5, funcionario.getIdade());
            
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            
        } catch ( SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro as cadastrar " +e);
        }
    }
    
    //metodo Alterar Funcionario
    public void alterarFuncionario(Funcionario funcionario){
        try {
            
            String sql="UPDATE funcionario  set nome=?,cargo=?,salario=?,idade=? WHERE crmv=?";
                   
            //tratar e executar os comandos sql
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo() );
            stmt.setDouble(3, funcionario.getSalario());
            stmt.setInt(4, funcionario.getIdade());
            stmt.setInt(5, funcionario.getCrmv());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
            
        } catch ( SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro as alterar " +e);
        }
    }
    
    //metodo Excluir funcionario
    public void excluirFuncionario(Funcionario funcionario){
        try {
            
            String sql="DELETE FROM funcionario WHERE crmv =? ";
            
            //tratar e executar os comandos sql
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setInt(1, funcionario.getCrmv());
                       
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
            
        } catch ( SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro ao Excluir " +e);
        }
    }
    
     //metodo Listar Funcionario
    public List<Funcionario>  listarFuncionario(){
        try {
            List<Funcionario>lista= new ArrayList<>();
            
            String sql= "SELECT * FROM funcionario";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                Funcionario funcionario = new Funcionario();
                
                funcionario.setCrmv(rs.getInt("crmv"));
                funcionario.setIdade(rs.getInt("idade"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargo(rs.getString("cargo"));
                                
                lista.add(funcionario);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro " +e);
            return null;
        }
    }
}
