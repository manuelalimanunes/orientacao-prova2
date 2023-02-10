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
import modelo.*;


public class NvDificuldadeDAO {
     private Connection con;
    
    public NvDificuldadeDAO(){
        this.con = new ConectaFactory().getConection();
    }
    public void cadastrarNvDificuldade(NvDificuldade obj){
        try{
            String sql = "insert into  nivel_dificuldade (idNIVEL_DIFICULDADE, TEXTO_NIVEL_DIFICULDADE, QUANTIDADE_DIFICULDADE)"
                    + " values(?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, obj.getCodDificuldade());
            stmt.setInt(2, obj.getQdtDificuldade());
            stmt.setString(3, obj.getTextoDifuculdade());
            
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "salvo o Nivel de Difucoldade!");
            
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "erro ao cadastrar o Nivel de dificuldade" + erro);
        }    
       
    }
    public void excluirNvDificuldade(NvDificuldade obj){
            try{
            String sql= "delete  from nivel_dificuldade where idNIVEL_DIFICULDADE=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCodDificuldade());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao efetuar a exclusão"+ erro);
        }
    }
    public List<NvDificuldade> listarNvDificuldades(){
        try{
            List<NvDificuldade> lista = new ArrayList<>();
            String slq = "select * from nivel_dificuldade";
            PreparedStatement stmt = con.prepareStatement(slq);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                NvDificuldade obj = new NvDificuldade();
                obj.setCodDificuldade(rs.getInt("idNIVEL_DIFICULDADE"));
                obj.setQdtDificuldade(rs.getInt("QUANTIDADE_DIFICULDADE"));
                obj.setTextoDifuculdade(rs.getString("TEXTO_NIVEL_DIFICULDADE"));
                
                lista.add(obj);
                
            }
            return lista;
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao listar os dados" + erro);
            return null;
        }
    }
    
}

