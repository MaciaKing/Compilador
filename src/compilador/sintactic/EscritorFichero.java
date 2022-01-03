/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.sintactic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macia
 */
public class EscritorFichero {
    
    FileWriter f;
    
    public EscritorFichero(String nomFicher){
        try {
            f= new FileWriter(nomFicher, true);            
        } catch (IOException ex) {
            Logger.getLogger(EscritorFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void escrivirFichero(String text){
        try {
            f.write(text + "\n");
        } catch (IOException ex) {
            Logger.getLogger(EscritorFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cierraFichero(){
        try {
            f.close();
        } catch (IOException ex) {
            Logger.getLogger(EscritorFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
