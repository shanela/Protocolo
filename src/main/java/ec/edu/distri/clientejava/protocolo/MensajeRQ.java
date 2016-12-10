/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.distri.clientejava.protocolo;

import ec.edu.distri.clientejava.protocolo.model.Usuario;
import ec.edu.distri.clientejava.protocolo.servicio.AccederServicioRQ;
import ec.edu.distri.clientejava.protocolo.servicio.ConsultarFacturaRQ;
import ec.edu.distri.clientejava.protocolo.servicio.LoginUsuarioRQ;

/**
 *
 * @author user
 */
public class MensajeRQ extends Mensaje {

    public MensajeRQ() {
    }

    public MensajeRQ(String originador, String idMensaje) {
        this.cabecera = new Cabecera(Mensaje.TIPO_MENSAJE_REQUEST, originador, idMensaje);
    }

    @Override
    public boolean build(String input) {
        boolean result = true;
        if (validate(input)) {
            this.cabecera = new Cabecera();
            // Prueba repositorio GIT
            if (this.cabecera.build(input.substring(0, Cabecera.HEADER_LENGTH))) {
                // se obtiene el resto del mensaje que seria el cuerpo

                String cuerpo = input.substring(Cabecera.HEADER_LENGTH);
                if (this.cabecera.getTipoMensaje().equals(Mensaje.TIPO_MENSAJE_REQUEST)) {
                    switch (this.cabecera.getIdMensaje()) {

                        case ID_MENSAJE_LOGIN:
                            LoginUsuarioRQ LoginRQ = new LoginUsuarioRQ();
                            
                            if (!LoginRQ.build(cuerpo)) {
                                System.out.println("No se pudo construir cuerpo");
                                result = false;
                            } else {
                                this.cuerpo = LoginRQ;
                            }
                            break;
                        case ID_MENSAJE_ACCEDERSERVICIO:
                            AccederServicioRQ servicioRQ = new AccederServicioRQ();
                              if (!servicioRQ.build(cuerpo)) {
                                System.out.println("No se pudo construir cuerpo");
                                result = false;
                            } else {
                                this.cuerpo = servicioRQ;
                            }
                            break;
                        case ID_MENSAJE_CONSULTAFACTURA:
                            ConsultarFacturaRQ facturaRQ = new ConsultarFacturaRQ();
                            facturaRQ.build(cuerpo);
                            this.cuerpo = facturaRQ;
                            if (validateBobyHash()) {
                            } else {
                                result = false;
                                System.out.println("Fallo verificacion de hash");
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
