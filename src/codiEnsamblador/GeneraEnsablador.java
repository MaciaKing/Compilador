/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codiEnsamblador;

import compilador.sintactic.Codi3A;
import compilador.sintactic.EscritorFichero;
import compilador.sintactic.InstrCodi3A;
import compilador.sintactic.TablaVariables;
import compilador.sintactic.TiposOperandoC3A;

/**
 *
 * @author macia
 */
public class GeneraEnsablador {

    //Codi3A c;
    EscritorFichero f;

    public GeneraEnsablador() {
        f = new EscritorFichero("XXXXXXXX.X68");
    }

    public void generaCodi68k() {
        f.escrivirFichero("\tORG    $600");
        //primero generamos las variables
        for (int i = 0; i < TablaVariables.tVar.size(); i++) {
            generaVariableGlobal68k(TablaVariables.tVar.get(i).idVariable);
        }
        f.escrivirFichero("\n\tORG    $1000");
        f.escrivirFichero("\nSTART:");
        //Ahora cogemos las instrucciones del codigo 3A
        for (int i = 0; i < Codi3A.C3A.size(); i++) {
            generaInstruccion68k(Codi3A.C3A.get(i));
        }

        f.escrivirFichero("\tEND START");
        f.cierraFichero();
    }

    public void generaVariableGlobal68k(String nombre) {
        nombre += "\tDS.W 1";
        f.escrivirFichero(nombre);
    }

    public void generaInstruccion68k(InstrCodi3A inst) {
        switch (inst.instruccion) {
            case SKIP:
                f.escrivirFichero(inst.destino.toString() + ":");
                break;
            case COPY:
                f.escrivirFichero("\tMOVE.W #" + inst.param2 + "," + inst.destino);
                break;
            case ADD:
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) {  //x=#*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= #*# //va be
                        f.escrivirFichero("\tMOVE.W #" + inst.param1 + ", D0");
                        f.escrivirFichero("\tMOVE.W #" + inst.param2 + ", D1");
                        f.escrivirFichero("\tADD.W D0, D1");
                        f.escrivirFichero("\tMOVE.W D1, " + inst.destino);
                    } else { //x=#*v
                        f.escrivirFichero("\tMOVE.W #" + inst.param1 + ", D0");
                        f.escrivirFichero("\tMOVE.W (" + inst.param2 + "), D1");
                        f.escrivirFichero("\tADD.W D0, D1");
                        f.escrivirFichero("\tMOVE.W D1, " + inst.destino);
                    }
                } else { //x = v*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= v*# //va be
                        f.escrivirFichero("\tMOVE.W (" + inst.param1 + "), D0");
                        f.escrivirFichero("\tMOVE.W #" + inst.param2 + ", D1");
                        f.escrivirFichero("\tADD.W D0, D1");
                        f.escrivirFichero("\tMOVE.W D1, " + inst.destino);
                    } else { //x=v*v
                        f.escrivirFichero("\tMOVE.W (" + inst.param1 + "), D0");
                        f.escrivirFichero("\tMOVE.W (" + inst.param2 + "), D1");
                        f.escrivirFichero("\tADD.W D0, D1");
                        f.escrivirFichero("\tMOVE.W D1, " + inst.destino);
                    }
                }
                break;

            case SUB:
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) {  //x=#*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= #*# //va be
                        f.escrivirFichero("\tMOVE.W #" + inst.param1 + ", D0");
                        f.escrivirFichero("\tMOVE.W #" + inst.param2 + ", D1");
                        f.escrivirFichero("\tSUB.W D0, D1");
                        f.escrivirFichero("\tMOVE.W D1, " + inst.destino);
                    } else { //x=#*v
                        f.escrivirFichero("\tMOVE.W #" + inst.param1 + ", D0");
                        f.escrivirFichero("\tMOVE.W (" + inst.param2 + "), D1");
                        f.escrivirFichero("\tSUB.W D0, D1");
                        f.escrivirFichero("\tMOVE.W D1, " + inst.destino);
                    }
                } else { //x = v*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= v*# //va be
                        f.escrivirFichero("\tMOVE.W (" + inst.param1 + "), D0");
                        f.escrivirFichero("\tMOVE.W #" + inst.param2 + ", D1");
                        f.escrivirFichero("\tSUB.W D0, D1");
                        f.escrivirFichero("\tMOVE.W D1, " + inst.destino);
                    } else { //x=v*v
                        f.escrivirFichero("\tMOVE.W (" + inst.param1 + "), D0");
                        f.escrivirFichero("\tMOVE.W (" + inst.param2 + "), D1");
                        f.escrivirFichero("\tSUB.W D0, D1");
                        f.escrivirFichero("\tMOVE.W D1, " + inst.destino);
                    }
                }
                break;

            case MUL:
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) {  //x=#*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= #*# //va be
                        f.escrivirFichero("\tMOVE.W #" + inst.param1 + ", D0");
                        f.escrivirFichero("\tMOVE.W #" + inst.param2 + ", D1");
                        f.escrivirFichero("\tMULU.W D0, D1");
                        f.escrivirFichero("\tMOVE.W D1, " + inst.destino);
                    } else { //x=#*v
                        f.escrivirFichero("\tMOVE.W #" + inst.param1 + ", D0");
                        f.escrivirFichero("\tMOVE.W (" + inst.param2 + "), D1");
                        f.escrivirFichero("\tMULU.W D0, D1");
                        f.escrivirFichero("\tMOVE.W D1, " + inst.destino);
                    }
                } else { //x = v*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= v*# //va be
                        f.escrivirFichero("\tMOVE.W (" + inst.param1 + "), D0");
                        f.escrivirFichero("\tMOVE.W #" + inst.param2 + ", D1");
                        f.escrivirFichero("\tMULU.W D0, D1");
                        f.escrivirFichero("\tMOVE.W D1, " + inst.destino);
                    } else { //x=v*v
                        f.escrivirFichero("\tMOVE.W (" + inst.param1 + "), D0");
                        f.escrivirFichero("\tMOVE.W (" + inst.param2 + "), D1");
                        f.escrivirFichero("\tMULU.W D0, D1");
                        f.escrivirFichero("\tMOVE.W D1, " + inst.destino);
                    }
                }
                break;
                
            case DIV:
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) {  //x=#*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= #*# //va be
                        f.escrivirFichero("\tMOVE.W #" + inst.param1 + ", D0");
                        f.escrivirFichero("\tMOVE.W #" + inst.param2 + ", D1");
                        f.escrivirFichero("\tDIVS.W D0, D1");
                        f.escrivirFichero("\tMOVE.W D1, " + inst.destino);
                    } else { //x=#*v
                        f.escrivirFichero("\tMOVE.W #" + inst.param1 + ", D0");
                        f.escrivirFichero("\tMOVE.W (" + inst.param2 + "), D1");
                        f.escrivirFichero("\tDIVS.W D0, D1");
                        f.escrivirFichero("\tMOVE.W D1, " + inst.destino);
                    }
                } else { //x = v*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= v*# //va be
                        f.escrivirFichero("\tMOVE.W (" + inst.param1 + "), D0");
                        f.escrivirFichero("\tMOVE.W #" + inst.param2 + ", D1");
                        f.escrivirFichero("\tDIVS.W D0, D1");
                        f.escrivirFichero("\tMOVE.W D1, " + inst.destino);
                    } else { //x=v*v
                        f.escrivirFichero("\tMOVE.W (" + inst.param1 + "), D0");
                        f.escrivirFichero("\tMOVE.W (" + inst.param2 + "), D1");
                        f.escrivirFichero("\tDIVS.W D0, D1");
                        f.escrivirFichero("\tMOVE.W D1, " + inst.destino);
                    }
                }
                break;                
            /*
    
    DIV,
    MOD,
    AND,
    OR,
    LT,
    LE,
    EQ,
    NE,
    GE,
    GT,
    IFGT,
    ASSIG,
    GOTO,
    
             */
        }
    }
}
