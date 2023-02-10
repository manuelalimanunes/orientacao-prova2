/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jeffn
 */
public class Programador {
    private int matricula;
    private String nome;
    private Setor codigo;
    private NvProgramador numero;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Setor getCodigo() {
        return codigo;
    }

    public void setCodigo(Setor codigo) {
        this.codigo = codigo;
    }

    public NvProgramador getNumero() {
        return numero;
    }

    public void setNumero(NvProgramador numero) {
        this.numero = numero;
    }
}
