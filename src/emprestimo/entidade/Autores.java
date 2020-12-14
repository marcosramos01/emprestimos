/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emprestimo.entidade;

import java.io.Serializable;

/**
 *
 * @author Win10
 */
public class Autores implements Serializable{
    
    private Integer cdAutores;
    private String nmAutor;
    private Integer cdlivro_FK;
    

    public Autores() {
    }

    public Autores(Integer cdAutores, String nmAutor, Integer cdlivro_FK) {
        this.cdAutores = cdAutores;
        this.nmAutor = nmAutor;
        this.cdlivro_FK = cdlivro_FK;
    }

    public Integer getCdAutores() {
        return cdAutores;
    }

    public void setCdAutores(Integer cdAutores) {
        this.cdAutores = cdAutores;
    }

    public String getNmAutor() {
        return nmAutor;
    }

    public void setNmAutor(String nmAutor) {
        this.nmAutor = nmAutor;
    }

    public Integer getCdlivro_FK() {
        return cdlivro_FK;
    }

    public void setCdlivro_FK(Integer cdlivro_FK) {
        this.cdlivro_FK = cdlivro_FK;
    }
    
    
    
}
