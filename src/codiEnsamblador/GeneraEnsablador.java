/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codiEnsamblador;

import compilador.sintactic.Codi3A;
import compilador.sintactic.EscritorFichero;
import compilador.sintactic.TablaVariables;

/**
 *
 * @author macia
 */
public class GeneraEnsablador {
   
   //Codi3A c;
    EscritorFichero f;
  public GeneraEnsablador(){
     f= new EscritorFichero("XXXXXXXX.X68");
  }
  
  public void generaCodi68k(){
     f.escrivirFichero("\tORG    $600");
     //primero generamos las variables
     for(int i=0; i< TablaVariables.tVar.size();i++){
         generaVariableGlobal68k(TablaVariables.tVar.get(i).idVariable);
     }
     f.escrivirFichero("\n\tORG    $1000");
     f.escrivirFichero("\nSTART:");
     
     f.cierraFichero();
  }
  
  public void generaVariableGlobal68k(String nombre){
      nombre+="\tDS.W 1";
      f.escrivirFichero(nombre);
      //f.cierraFichero();
  }
}
