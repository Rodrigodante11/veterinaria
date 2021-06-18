package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.Cliente;
import model.Funcionario;

public class ClienteDAO {
    private Connection con;
    public ClienteDAO(){
        this.con =new ConnectionFactory().getConnection();
    }
    //metodo Cadastrar Cliente
    public void cadastrarCliente(Cliente cliente){
        
        try {
            
            String sql="INSERT INTO cliente(cpf,nome,telefone,endereco,funcionario_crmv) "
                    +"VALUES(?,?,?,?,?)";
            
            //tratar e executar os comandos sql
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setInt(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEndereco());
            stmt.setInt(5, cliente.getFuncionario().getCrmv());
            
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            
        } catch ( SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro as cadastrar " +e);
        }
    }
    
    //metodo Alterar Cliente
    public void alterarCliente(Cliente cliente){
        try {
            
            String sql="UPDATE cliente  set nome=?,telefone=?,endereco=?,funcionario_crmv=? WHERE cpf=?";
                   
            //tratar e executar os comandos sql
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEndereco());
            stmt.setInt(4, cliente.getFuncionario().getCrmv());
            stmt.setInt(5, cliente.getCpf());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
            
        } catch ( SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro as alterar " +e);
        }
    }
    
    //metodo Excluir Cliente
    public void excluirCliente(Cliente cliente){
        try {
            
            String sql="DELETE FROM cliente WHERE cpf =? ";
            
            //tratar e executar os comandos sql
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setInt(1, cliente.getCpf());
                       
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
            
        } catch ( SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro ao Excluir " +e);
        }
    }
    
     //metodo Listar Cliente
    public List<Cliente>  listarCliente(){
        try {
            List<Cliente>lista= new ArrayList<>();
            
            String sql= "SELECT * FROM cliente";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                Funcionario funcionario= new Funcionario();
                Cliente cliente = new Cliente();
                cliente.setCpf(rs.getInt("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEndereco(rs.getString("endereco"));
                funcionario.setCrmv(rs.getInt("funcionario_crmv"));
                cliente.setFuncionario(funcionario);
                                               
                lista.add(cliente);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro " +e);
            return null;
        }
    }
    public List<Cliente>  listarClientePorNome(String nome){
        try {
            List<Cliente>lista= new ArrayList<>();
            
            String sql= "SELECT * FROM cliente WHERE nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                Funcionario funcionario= new Funcionario();
                Cliente cliente = new Cliente();
                cliente.setCpf(rs.getInt("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEndereco(rs.getString("endereco"));
                funcionario.setCrmv(rs.getInt("funcionario_crmv"));
                cliente.setFuncionario(funcionario);
                                               
                lista.add(cliente);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro " +e);
            return null;
        }
    }
    
    
    
    
}
