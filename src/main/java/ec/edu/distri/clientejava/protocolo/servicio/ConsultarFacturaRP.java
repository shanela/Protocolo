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
public class ConsultarFacturaRP implements Cuerpo
{
     private String cliente;
     private String detalleFactura;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(String detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

   

    @Override
    public String asTexto() {
        return cliente+detalleFactura;
    }

    @Override
    public boolean validate(String input) {
       return true;
    }

    @Override
    public boolean build(String input) {
        if(validate(input)==true)
       {
            try 
            {              
                String values[] = MyStringUtil.splitByFixedLengths(input, new int[]{16,16});
                this.cliente = values[0];
                this.detalleFactura = values[1];
                         
                return true;
            } catch (Exception e) {

                // e.printStackTrace();
                System.out.println("" + e);
            }
       }
       return false;
    }
}
