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
import modelo.NvProgramador;

/**
 *
 * @author jeffn
 */
public class NvProgramadorDAO {
    private Connection con;
    
    public NvProgramadorDAO(){
        this.con = new ConectaFactory().getConection();
    }
    public void cadastrarNvProgramador(NvProgramador obj){
        try{
            String sql = "insert into nivel_do_programador (idNIVEL_DO_PROGRAMADOR, texto_do_nivel_programador) values(?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, obj.getNumero());
            stmt.setString(3, obj.getTexto());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "salvo o Nivel do programador!");
            
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "erro ao cadastrar Nivel do programador" + erro);
        }    
       
    }
    public void excluirNvProgramador(NvProgramador obj){
            try{
            String sql= "delete nivel_do_programador from  where idNIVEL_DO_PROGRAMADOR=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getNumero());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao efetuar a exclusão"+ erro);
        }
    }
    public List<NvProgramador> listarNvProgramador(){
        try{
            List<NvProgramador> lista = new ArrayList<>();
            String slq = "select * from nivel_do_programador";
            PreparedStatement stmt = con.prepareStatement(slq);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                NvProgramador obj = new NvProgramador();
                obj.setNumero(rs.getInt("idNIVEL_DO_PROGRAMADOR"));
                obj.setTexto(rs.getString("texto_do_nivel_programador"));
                
                lista.add(obj);
                
            }
            return lista;
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao listar os dados" + erro);
            return null;
        }
    }
}
