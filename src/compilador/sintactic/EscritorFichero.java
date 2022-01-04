/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.sintactic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macia
 */
public class EscritorFichero {
    
    //FileWriter f;
    BufferedWriter bw;
    public EscritorFichero(String nomFicher){
        try {
            bw=new BufferedWriter(new FileWriter(nomFicher));        
        } catch (IOException ex) {
            Logger.getLogger(EscritorFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void escribirFichero(String text){
        try {
            bw.write(text);
            bw.newLine();
        } catch (IOException ex) {
            Logger.getLogger(EscritorFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cierraFichero(){
        try {
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(EscritorFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
