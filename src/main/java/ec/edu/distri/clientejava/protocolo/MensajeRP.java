/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.distri.clientejava.protocolo;

import ec.edu.distri.clientejava.protocolo.servicio.AccederServicioRP;
import ec.edu.distri.clientejava.protocolo.servicio.ConsultarFacturaRP;
import ec.edu.distri.clientejava.protocolo.servicio.LoginUsuarioRP;

/**
 *
 * @author LuisAlberto
 */
public class MensajeRP extends Mensaje {

    public MensajeRP() {
    }

    public MensajeRP(String originador, String idMensaje) {
        this.cabecera = new Cabecera(Mensaje.TIPO_MENSAJE_RESPONSE, originador, idMensaje);
    }

    @Override
    public boolean build(String input) {
        boolean result = true;
        if (validate(input)) {
            this.cabecera = new Cabecera();

            if (this.cabecera.build(input.substring(0, Cabecera.HEADER_LENGTH))) {
                String cuerpo = input.substring(Cabecera.HEADER_LENGTH);

                if (this.cabecera.getTipoMensaje().equals(Mensaje.TIPO_MENSAJE_RESPONSE)) {
                    switch (this.cabecera.getIdMensaje()) {
                        case ID_MENSAJE_LOGIN:
                            LoginUsuarioRP loginRP = new LoginUsuarioRP();
                            if (loginRP.build(cuerpo)) 
                            {
                                this.cuerpo = loginRP;
                                if (validateBobyHash()) {
                                } else {
                                    result = false;
                                    System.out.println("Fallo verificacion de hash");
                                }
                                result = true;
                            } else {
                                System.out.println("Fallo al construir login usuarioRP");
                                result = false;
                            }
                            break;
                            
                        case ID_MENSAJE_ACCEDERSERVICIO:
                             AccederServicioRP servicioRP = new AccederServicioRP(); 
                             
                              if (servicioRP.build(cuerpo)) 
                            {
                                this.cuerpo = servicioRP;
                                if (validateBobyHash()) {
                                } else {
                                    result = false;
                                    System.out.println("Fallo verificacion de hash");
                                }
                                result = true;
                            } else {
                                result = false;
                            }
                            break;
                            
                        case ID_MENSAJE_CONSULTAFACTURA:
                            ConsultarFacturaRP facturaRS = new ConsultarFacturaRP();
                            if (facturaRS.validate(cuerpo)) {
                                facturaRS.build(cuerpo);
                                this.cuerpo = facturaRS;
                                 if (validateBobyHash()) {
                                } else {
                                    result = false;
                                    System.out.println("Fallo verificacion de hash");
                                }
                                result = true;
                            } else {
                                result = false;
                            }
                            break;

                        default:
                            result = false;
                    }
                } else {
                    result = false;
                }
            } else {
                result = false;
            }
        } else {
            result = false;
        }
        return result;

    }

}
