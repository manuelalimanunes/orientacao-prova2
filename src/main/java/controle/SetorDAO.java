/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import conexao.ConectaFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Setor;


public class SetorDAO {
     private Connection con;
    
    public SetorDAO(){
        this.con = new ConectaFactory().getConection();
    }
    public void cadastrarSetor(Setor obj){
        try{
            String sql = "insert into  setor (idSETOR, texto_do_setor) values(?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, obj.getCodigo());
            stmt.setString(3, obj.getTexto());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "salvo o Setor!");
            
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "erro ao cadastrar Setor" + erro);
        }    
       
    }
    public void excluirSetor(Setor obj){
            try{
            String sql= "delete setor from  where idSETOR=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCodigo());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao efetuar a exclusão"+ erro);
        }
    }
    public List<Setor> listarSetor(){
        try{
            List<Setor> lista = new ArrayList<>();
            String slq = "select * from setor";
            PreparedStatement stmt = con.prepareStatement(slq);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Setor obj = new Setor();
                obj.setCodigo(rs.getInt("idSETOR"));
                obj.setTexto(rs.getString("texto_do_setor"));
                
                lista.add(obj);
                
            }
            return lista;
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao listar os dados" + erro);
            return null;
        }
    }
    
}

