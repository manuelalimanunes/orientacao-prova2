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


public class ProgramaDAO {
     private Connection con;
    
    public ProgramaDAO(){
        this.con = new ConectaFactory().getConection();
    }
    public void cadastrarPrograma(Programa obj){
        try{
            String sql = "insert into  programa (idPROGRAMA, TEXTO_DO_PROGRAMA, TEMPO_ESTIMADO, idNIVEL_DE_DIFICULDADE)"
                    + " values(?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, obj.getCodPrograma());
            stmt.setInt(2, obj.getQdtTempo());
            stmt.setString(3, obj.getTextoPrograma());
            stmt.setInt(4, obj.getCodDificuldade());
            
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "salvo o Programa!");
            
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "erro ao cadastrar o Programa" + erro);
        }    
       
    }
    public void excluirPrograma(Programa obj){
            try{
            String sql= "delete  from programa where idPROGRAMA=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCodPrograma());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao efetuar a exclusão"+ erro);
        }
    }
    public List<Programa> listarPrograma(){
        try{
            List<Programa> lista = new ArrayList<>();
            String slq = "select * from programa";
            PreparedStatement stmt = con.prepareStatement(slq);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Programa obj = new Programa();
                obj.setCodPrograma(rs.getInt("idPROGRAMA"));
                obj.setQdtTempo(rs.getInt("TEMPO_ESTIMADO"));
                obj.setTextoPrograma(rs.getString("TEXTO_DO_PROGRAMA"));
                obj.setCodDificuldade(rs.getInt("idNIVEL_DE_DIFICULDADE"));
                
                lista.add(obj);
                
            }
            return lista;
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao listar os dados" + erro);
            return null;
        }
    }
    
}

