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
import modelo.Programador;
import visao.frmLogin;
import visao.frmMenu;

/**
 *
 * @author jeffn
 */
public class ProgramadorDAO {
    private Connection con;
    
    public ProgramadorDAO(){
        this.con = new ConectaFactory().getConection();
    }
    public void cadastrarProgramador(Programador obj){
        try{
            String sql = "insert into programador (idPROGRAMADOR_MATRICULA, idSETOR, idNIVEL_DO_PROGRAMADOR, NOME+PROGRAMADOR) "
                    + "values(?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, obj.getMatricula());
            stmt.setString(2, obj.getNome());
            stmt.setInt(3, obj.getNvProgramador().getNumero());
            stmt.setInt(4, obj.getSetor().getCodigo());
            
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "salvo o programador!");
            
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "erro ao cadastrar programador" + erro);
        }    
       
    }
    public void excluirProgramador(Programador obj){
            try{
            String sql= "delete programador from  where idPROGRAMADOR_MATRICULA=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getMatricula());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao efetuar a exclusão"+ erro);
        }
    }
    public void efetuarLogin(int Codigo){
        try{
            String sql = "select * from programador where idPROGRAMADOR=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, Codigo);
            
            ResultSet rs= stmt.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema!");
                frmMenu tela = new frmMenu();
                tela.setVisible(true);
                
            }else{
                JOptionPane.showMessageDialog(null, "Dados incorretos!");
                new frmLogin().setVisible(true);
                
            }
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            
        }
    }
    public List<Programador> listarProgramador(){
        try{
            List<Programador> lista = new ArrayList<>();
            String slq = "select * from programador";
            PreparedStatement stmt = con.prepareStatement(slq);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Programador obj = new Programador();
                obj.setMatricula(rs.getInt("idPROGRAMADOR_MATRICULA"));
                obj.setNome(rs.getString("NOME_PROGRAMADOR"));
                obj.setNumero(rs.getInt("idSETOR"));
                obj.setNumero(rs.getInt("idNIVEL_DO_PROGRAMADOR"));
                
                
                
                lista.add(obj);
                
            }
            return lista;
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao listar os dados" + erro);
            return null;
        }
    }
}
