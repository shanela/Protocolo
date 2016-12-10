/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.distri.clientejava.protocolo.servicio;

import ec.edu.distri.clientejava.protocolo.Cuerpo;
import ec.edu.distri.clientejava.protocolo.model.Plan;
import ec.edu.distri.clientejava.protocolo.model.ServicioAdicional;
import ec.edu.distri.clientejava.util.MyStringUtil;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author User
 */
public class AccederServicioRP implements Cuerpo
{
     private Plan plan;
     private ServicioAdicional servicioAdicional;

    public AccederServicioRP() {
        plan=new Plan();
        servicioAdicional=new ServicioAdicional();
    }

    public AccederServicioRP(Plan plan, ServicioAdicional servicioAdicional) {
        this.plan = plan;
        this.servicioAdicional = servicioAdicional;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public ServicioAdicional getServicioAdicional() {
        return servicioAdicional;
    }

    public void setServicioAdicional(ServicioAdicional servicioAdicional) {
        this.servicioAdicional = servicioAdicional;
    }

    @Override
    public String asTexto() {
        return plan.asTexto()+servicioAdicional.asTexto(); 
    }

    @Override
    public boolean validate(String input) 
    {
        return plan.validate(input)&& servicioAdicional.validate(input);
    }

    @Override
    public boolean build(String input) 
    {
        return plan.build(input) && servicioAdicional.build(input);
    }
    

    
}
     
     
      
      

