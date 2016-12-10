/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.distri.clientejava.protocolo.model;

import ec.edu.distri.clientejava.protocolo.Cuerpo;
import ec.edu.distri.clientejava.util.MyStringUtil;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author User
 */
public class Plan implements Cuerpo
{
    private String nombre;
    private String descripcion;

    public Plan() {
    }
    
   public Plan(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
   
    public String getNombre() {
        return nombre.trim();
    }

    public void setNombre(String nombre) {
        this.nombre = StringUtils.rightPad(nombre, 25, " ");
    }

    public String getDescripcion() {
        return descripcion.trim();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = StringUtils.rightPad(descripcion, 100, " ");
    }

    @Override
    public String asTexto() {
       return nombre+descripcion; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validate(String input) {
        if(input.length()==125)
        {
            return true;
        }
        else
        {
             return false;
        }
    }

   @Override
    public boolean build(String input) 
    {
     if(validate(input)==true)
       {        
            try {
                String values[] = MyStringUtil.splitByFixedLengths(input, new int[]{25,100});
                this.nombre = values[0];
                this.descripcion = values[1];
                         
                return true;
            } catch (Exception e) {

                // e.printStackTrace();
                System.out.println("" + e);
            }
       }
       return false;
    }   

   
    
    
}
