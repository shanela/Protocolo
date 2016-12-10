/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.distri.clientejava.protocolo;

import ec.edu.distri.clientejava.util.MyStringUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author LuisAlberto
 */
public class Cabecera {
    //Cuando se armen las cadenas asTexto y cuando se las desmonte se debe hacer en el mismo orden de los
    //atributos de esta clase
    
    private String tipoMensaje; //Longitud fija: 2      Ejemplo: RS o RQ
    private String originador; //Longitud fija:4       Ejemplo: appServer/ip
    private String fecha;//Longitud fija:14             Ejemplo: yyyyMMddHHmmss 20151109213615
    private String idMensaje;//Longitud fija:10         Ejemplo: CONSULTACL
    private String longitudCuerpo;//Longitud fija:4     Ejemplo: 0098
    private String verificacion;//Longitud fija:32      Ejemplo: 6fb6aaba394b3b6759160add3b53b070
    public static final int HEADER_LENGTH = 66;

    /**
     * @param tipoMensaje
     * @param originador
     * @param idMensaje
     */
    public Cabecera(String tipoMensaje, String originador, String idMensaje) {
        super();
        this.tipoMensaje = tipoMensaje;
        this.setOriginador(originador);
        this.idMensaje = idMensaje;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        this.fecha = sdf.format(Calendar.getInstance().getTime());
    }

    public Cabecera() {
    }

    public String getFecha() {
        return fecha;
    }

    public String getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public String getOriginador() {
        return originador;
    }

    public void setOriginador(String originador) {
        this.originador = StringUtils.leftPad(originador, 4, "0");
    }

    public String getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(String idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getLongitudCuerpo() {
        return longitudCuerpo;
    }

    public void setLongitudCuerpo(String longitudCuerpo) {
        this.longitudCuerpo = StringUtils.leftPad(longitudCuerpo, 4, "0");
    }

    public String getVerificacion() {
        return verificacion;
    }

    public void setVerificacion(String verificacion) {
        this.verificacion = verificacion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Cabecera [tipoMensaje=" + tipoMensaje + ", originador=" + originador + ", fecha=" + fecha
                + ", idMensaje=" + idMensaje + ", longitudCuerpo=" + longitudCuerpo + ", verificacion=" + verificacion
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((verificacion == null) ? 0 : verificacion.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Cabecera other = (Cabecera) obj;
        if (verificacion == null) {
            if (other.verificacion != null) {
                return false;
            }
        } else if (!verificacion.equals(other.verificacion)) {
            return false;
        }
        return true;
    }

    public String asTexto() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.tipoMensaje);
        sb.append(this.originador);
        sb.append(this.fecha);
        sb.append(this.idMensaje);
        sb.append(this.getLongitudCuerpo());
        sb.append(this.getVerificacion());
        return sb.toString();
    }

    public boolean validate(String input) {
        return input.length() == HEADER_LENGTH;
    }

    public boolean build(String input) {
        if (validate(input)) {
            try {
                String values[] = MyStringUtil.splitByFixedLengths(input, new int[]{2, 4, 14, 10, 4, 32});
                this.tipoMensaje = values[0];
                this.originador = values[1];
                this.fecha = values[2];
                this.idMensaje = values[3];
                this.longitudCuerpo = values[4];
                this.verificacion = values[5];
                return true;
            } catch (Exception e) {

                // e.printStackTrace();
                System.out.println("" + e);
            }
        }
        return false;
    }
}
