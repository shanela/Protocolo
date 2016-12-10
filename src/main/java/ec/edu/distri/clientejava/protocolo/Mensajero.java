/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.distri.clientejava.protocolo;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shane
 */
public class Mensajero {

    private Socket socket;
    private PrintWriter output;
    private BufferedReader input;
    public String ip = "127.0.0.1";
    public int puerto = 4001;

    public Mensajero(int puerto,String ip) 
    {
        this.ip=ip;
        this.puerto=puerto;
//        socket = new Socket(IPADDRESS, PORT);
//        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        output = new PrintWriter(socket.getOutputStream(), true);
    }

    public MensajeRP enviarSolicitud(Mensaje mensajeRQ) {

        String response = null;
        int attemps = 0;
        try {
            socket = new Socket(ip, puerto);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            do {

                output.write(mensajeRQ.asTexto()+"\n");
                output.flush();
                response = input.readLine();
                if (response != null) {
                    break;
                }
            } while (attemps <= 5);

            output.write("FIN");
            output.flush();
            socket.close();
            if (response != null) {
                if(response.equals(Mensaje.ID_MENSAJE_FALLOBUILD))
                {
                    System.out.println("El mensaje no se pudo construir");
                    return null;
                }
                MensajeRP mensajeRS = new MensajeRP();
                if (mensajeRS.build(response)) {
                    return mensajeRS;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Mensajero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
