/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.distri.clientejava.protocolo.servicio;

import ec.edu.distri.clientejava.protocolo.Cuerpo;
import ec.edu.distri.clientejava.util.MyStringUtil;

/**
 *
 * @author User
 */
public class LoginUsuarioRP implements Cuerpo
{
    private String resultado;

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    // astexto = trama
    @Override
    public String asTexto() 
    {
        return resultado;
    }

    @Override
    public boolean validate(String input) 
    {
       if(input.length()==1)
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
                this.resultado = input;
                         
                return true;
            } catch (Exception e) {

                // e.printStackTrace();
                System.out.println("" + e);
            }
       }
       return false;
    }
  
    
}
