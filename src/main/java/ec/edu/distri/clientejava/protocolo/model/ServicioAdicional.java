/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.distri.clientejava.protocolo.model;

import ec.edu.distri.clientejava.protocolo.Cuerpo;
import ec.edu.distri.clientejava.util.MyStringUtil;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author User
 */
public class ServicioAdicional implements Cuerpo
{
    private String nombre;
    private String descripcion;
    private BigDecimal costo;

    public ServicioAdicional(String nombre, String descripcion, BigDecimal costo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public ServicioAdicional() {
        costo=new BigDecimal(BigInteger.ZERO);
        
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
        this.descripcion = StringUtils.rightPad(descripcion,100," ");
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String asTexto() {
       return nombre+descripcion+ StringUtils.leftPad(costo.toPlainString(),5,"0"); 
    }

    @Override
    public boolean validate(String input) {
        if(input.length()==130)
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
                String values[] = MyStringUtil.splitByFixedLengths(input, new int[]{25,100,5});
                this.nombre = values[0];
                this.descripcion = values[1];
                costo = new BigDecimal(values[2]).setScale(2, RoundingMode.HALF_UP);
                
                return true;
            } catch (Exception e) {

                // e.printStackTrace();
                System.out.println("" + e);
            }
       }
       return false;
    }   
    }
    
    

