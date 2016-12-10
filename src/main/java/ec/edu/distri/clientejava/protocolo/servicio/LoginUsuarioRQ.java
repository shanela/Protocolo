/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.distri.clientejava.protocolo.servicio;

import ec.edu.distri.clientejava.protocolo.Cuerpo;
import ec.edu.distri.clientejava.protocolo.model.Usuario;
import ec.edu.distri.clientejava.util.MyStringUtil;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author User
 */
public class LoginUsuarioRQ implements Cuerpo
{
    private Usuario us;

    public LoginUsuarioRQ() {
        us=new Usuario();
    }
        
    public LoginUsuarioRQ(Usuario us) {
        this.us = us;
    }
    
        public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }

//    public String getUsuario() {
//        return usuario.trim();
//    }

//    public void setUsuario(String usuario) {
//        this.usuario = StringUtils.rightPad(usuario, 16, " ");
//    }

//    public String getContrasena() 
//    {
//        return contrasena.trim();
//    }

//    public void setContrasena(String contrasena) {
//        this.contrasena = StringUtils.rightPad(contrasena,16," ");
//    }

    @Override
    public String asTexto() 
    {
        return us.asTexto();
    }

    //validar q la longitud sea 32 entre usuario y contrasena (true,false)
    @Override
    public boolean validate(String input) 
    {
        return us.validate(input);
    }
    
    @Override
    public boolean build(String input) 
    {
       return us.build(input);
    }  
}
