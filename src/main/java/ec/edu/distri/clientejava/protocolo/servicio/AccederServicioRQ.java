/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.distri.clientejava.protocolo.servicio;

import ec.edu.distri.clientejava.protocolo.Cuerpo;
import ec.edu.distri.clientejava.util.MyStringUtil;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author User
 */
public class AccederServicioRQ implements Cuerpo
{
      private String usuario;

    public String getUsuario() {
        return usuario.trim();
    }

    public void setUsuario(String usuario) {
        this.usuario = StringUtils.rightPad(usuario, 16, " ");
    }
      
    @Override
    public String asTexto() {
       return usuario;
    }

    @Override
    public boolean validate(String input) {
         if(input.length()==16)
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
            try 
            {              
                this.usuario = input;
                         
                return true;
            } catch (Exception e) {

                // e.printStackTrace();
                System.out.println("" + e);
            }
       }
       return false;
    }  
          
}


