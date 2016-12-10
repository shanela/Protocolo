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
public class Usuario implements Cuerpo
{
    private String nombre;
    private String contrasena;

    public Usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contrasena = contraseña;
    }

    public Usuario() {
    }
    

    public String getNombre() {
        return nombre.trim();
    }
    
     public void setNombre(String usuario) {
        this.nombre = StringUtils.rightPad(usuario, 16, " ");
    }

        public String getContraseña() {
        return contrasena.trim();
    }

   public void setContrasena(String contrasena) {
        this.contrasena = StringUtils.rightPad(contrasena,16," ");
    }

    @Override
    public String asTexto() 
    {
        return nombre+contrasena;
    }

    @Override
    public boolean validate(String input) 
    {
        if(input.length()==32)
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
                String values[] = MyStringUtil.splitByFixedLengths(input, new int[]{16,16});
                this.nombre = values[0];
                this.contrasena = values[1];
               
                return true;
            } catch (Exception e) {

                // e.printStackTrace();
                System.out.println("" + e);
            }
       }
       return false;
    }
    
    
}
