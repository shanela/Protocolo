/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.distri.clientejava.protocolo.model;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author User
 */
public class Cliente 
{
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String direccion;

    public Cliente(String nombre, String apellido, String cedula, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre.trim();
    }

    public void setNombre(String nombre) {
        this.nombre = StringUtils.rightPad(nombre, 25, " ");
    }

    public String getApellido() {
        return apellido.trim();
    }

    public void setApellido(String apellido) {
        this.apellido = StringUtils.rightPad(apellido, 25, " ");
    }

    public String getCedula() {
        return cedula.trim();
    }

    public void setCedula(String cedula) {
        this.cedula = StringUtils.rightPad(cedula, 10, " ");
    }

    public String getTelefono() {
        return telefono.trim();
    }

    public void setTelefono(String telefono) {
        this.telefono = StringUtils.rightPad(telefono, 10, " ");
    }

    public String getDireccion() {
        return direccion.trim();
    }

    public void setDireccion(String direccion) {
        this.direccion = StringUtils.rightPad(direccion, 50, " ");
    }





}
