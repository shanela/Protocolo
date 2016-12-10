/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.distri.clientejava.protocolo;

/**
 *
 * @author shane
 */
public interface Cuerpo {
    public static final char FIELD_SEPARATOR_CHAR = '|';

    public String asTexto();

    public boolean validate(String input);

    public boolean build(String input);
}
