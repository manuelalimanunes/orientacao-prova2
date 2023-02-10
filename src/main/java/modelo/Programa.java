/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jeffn
 */
public class Programa {
 private int codPrograma;
 private int qdtTempo;
 private String textoPrograma;
 private NvDificuldade CodDificuldade;

    public NvDificuldade getCodDificuldade() {
        return CodDificuldade;
    }

    public void setCodDificuldade(NvDificuldade CodDificuldade) {
        this.CodDificuldade = CodDificuldade;
    }

    public int getCodPrograma() {
        return codPrograma;
    }

    public void setCodPrograma(int codPrograma) {
        this.codPrograma = codPrograma;
    }

    public int getQdtTempo() {
        return qdtTempo;
    }

    public void setQdtTempo(int qdtTempo) {
        this.qdtTempo = qdtTempo;
    }

    public String getTextoPrograma() {
        return textoPrograma;
    }

    public void setTextoPrograma(String textoPrograma) {
        this.textoPrograma = textoPrograma;
    }

    
}
