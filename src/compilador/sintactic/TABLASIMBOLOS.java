/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.sintactic;

import java.util.ArrayList;

/**
 *
 * @author jfher
 */
public class TABLASIMBOLOS {

    public int n; //ambit actual 
    public ArrayList ta = new ArrayList(); //indices de el ambito actual
    public ArrayList te = new ArrayList(); //tabla auxiliar para los id repetidos 
    public ArrayList td = new ArrayList(); //tabla descripcion actual

    public TABLASIMBOLOS() {
        n = 0;
        ta.add(n, 0);
        //Inicializamos tambien te para evitar errores de rango
        //Inicializacion especail para la te
        declaracion t = new declaracion();
        t.d = null;
        t.id = "null";
        t.np = 0;
        te.add(t);
    }

    //Devuelve el tipo de identificador, si es null error
    public descripcion consultarD(String id) {
        //Recorre toda la tabla de descripcion
        for (int i = 0; i < td.size(); i++) {
            //Si encuentra una declaración, cuyo id sea igual al recibido por parametro
            if (((declaracion) td.get(i)).id.equals(id)) {
                //Nos devuelve la descripcion de la declaracion encontrada
                return ((declaracion) td.get(i)).d;
            }
        }
        //Si llegamos aqui, no se ha encontrado
        return null;
    }

    public void entrabloc() {
        //Se incrementa el nivel de ambito
        n++;
        //Definimos los rangos del ambito
        ta.add(n, ta.get(n - 1));
    }

    //Añadir identificador, si es diferente de null error
    public Integer afegir(String id, descripcion d) {
        declaracion dec = new declaracion();
        dec.d = d;
        dec.id = id;
        dec.np = n;
        boolean idRepetido = false;
        for (int i = 0; i < td.size(); i++) {
            declaracion decAux = (declaracion) td.get(i);
            if (decAux.id.equals(id)) {
                if (decAux.np == n) {
                    System.out.println("ERROR POR DECLARAR EN EL MISMO NIVEL");
                    idRepetido = true;
                    break;
                } else {
                    System.out.println("La variable " + id
                            + " puede declararse por que en otro ambito ");
                }
                idRepetido = true;
                //Si esta repetido pero no en el mismo ámbito, lo añadimos a la tabla de expansion
                //Incrementamos en uno el indice de la tabla de ambitos
                ta.set(n, ((int) ta.get(n)) + 1);
                //Ahi donde indique el puntero, añadiremos la antigua declaración en la tabla de expancion
                te.add((int) ta.get(n), decAux);
                //Añadimos el nuevo id en la posicion del anterior
                td.set(i, dec);
                break; //Paramos la busqueda
            }
        }
        if (!idRepetido) {
            td.add(dec); //Añadimos el id al final la lista
        }
        return null;
    }

    //Salimos del bloque, si es diferente de null hi ha un error
    public Integer surtbloc() {
        if (n == 0) {
            //DARIA ERROR
        }
        int lfi = (int) ta.get(n);
        n--; //Salimos del nivel
        int lini = (int) ta.get(n);
        //Colocamos los identificadores en la tabla de descripcion
        for (int j = lini; j <= lfi; j++) {
            declaracion dec = (declaracion) te.get(j); //Cogido de te
            for (int i = 0; i < td.size(); i++) {
                //Si encontramos en la tabla de expansion una variable con id igual a uno en la tabla de descripcion
                if (((declaracion) td.get(i)).id.equals(dec.id)) {
                    //lo añadimos a la tabla de descripcion
                    td.set(i, dec);
                    break;
                }
            }
        }
        
        for (int i = 0; i < td.size(); i++) {
            if (((declaracion) td.get(i)).np > n) {
                td.remove(((declaracion) td.get(i)));
            }
        }
        return null;
    }

//    //Salimos del bloque, si es diferente de null hi ha un error
//    public Integer surtbloc2() {
//        if (n == 0) {
//            //DARIA ERROR
//        }
//        int lfi = (int) ta.get(n);
//        n--; //Salimos del nivel
//        int lini = (int) ta.get(n);
//        //Colocamos los identificadores en la tabla de descripcion
//        for (int j = lini; j <= lfi; j++) {
//            declaracion dec = (declaracion) te.get(j); //Cogido de te
//            for (int i = 0; i < td.size(); i++) {
//                //Si encontramos en la tabla de expansion una variable con id igual a uno en la tabla de descripcion
//                if (((declaracion) td.get(i)).id.equals(dec.id)) {
//                    //lo añadimos a la tabla de descripcion
//                    td.set(i, dec);
//                    break;
//                }
//            }
//        }
//        //Borramos los identificadores que estan en un nivel superior al actual
//        ArrayList ids = new ArrayList();
//        for (int i = 0; i < td.size(); i++) {
//            if (((declaracion) td.get(i)).np > n) {
//                ids.add(((declaracion) td.get(i)));
//            }
//        }
//        //Eliminamos los guardados
//        for (int i = 0; i < ids.size(); i++) {
//            td.remove(((declaracion) ids.get(i)));
//        }
//
//        return null;
//    }

}
