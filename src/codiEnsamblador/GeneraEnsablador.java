/*
 * 
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
        f.escribirFichero("\tORG    $600");
        //primero generamos las variables
        for (int i = 0; i < TablaVariables.tVar.size(); i++) {
            generaVariableGlobal68k(TablaVariables.tVar.get(i).idVariable);
        }
        f.escribirFichero("\n\tORG    $1000");
        f.escribirFichero("\nSTART:");
        //Ahora cogemos las instrucciones del codigo 3A
        for (int i = 0; i < Codi3A.C3A.size(); i++) {
            generaInstruccion68k(Codi3A.C3A.get(i));
        }

        f.escribirFichero("\tEND START");
        f.cierraFichero();
    }

    public void generaVariableGlobal68k(String nombre) {
        nombre += "\tDS.W 1";
        f.escribirFichero(nombre);
    }

    public void generaInstruccion68k(InstrCodi3A inst) {
        switch (inst.instruccion) {
            case SKIP:
                f.escribirFichero(inst.destino.toString() + ":");
                break;
            case COPY:
                f.escribirFichero("\tMOVE.W #" + inst.param2 + "," + inst.destino);
                break;
            case ADD:
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) {  //x=#*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= #*# //va be
                        f.escribirFichero("\tMOVE.W #" + inst.param1 + ", D0");
                        f.escribirFichero("\tMOVE.W #" + inst.param2 + ", D1");
                        f.escribirFichero("\tADD.W D0, D1");
                        f.escribirFichero("\tMOVE.W D1, " + inst.destino);
                    } else { //x=#*v
                       
                        f.escribirFichero("\tMOVE.W #" + inst.param1 + ", D0");
                        f.escribirFichero("\tMOVE.W (" + inst.param2 + "), D1");
                        f.escribirFichero("\tADD.W D0, D1");
                        f.escribirFichero("\tMOVE.W D1, " + inst.destino);
                    }
                } else { //x = v*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= v*# //va be
                        f.escribirFichero("\tMOVE.W (" + inst.param1 + "), D0");
                        f.escribirFichero("\tMOVE.W #" + inst.param2 + ", D1");
                        f.escribirFichero("\tADD.W D0, D1");
                        f.escribirFichero("\tMOVE.W D1, " + inst.destino);
                    } else { //x=v*v
                       
                        f.escribirFichero("\tMOVE.W (" + inst.param1 + "), D0");
                        f.escribirFichero("\tMOVE.W (" + inst.param2 + "), D1");
                        f.escribirFichero("\tADD.W D0, D1");
                        f.escribirFichero("\tMOVE.W D1, " + inst.destino);
                    }
                }
                break;

            case SUB:
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) {  //x=#*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= #*# //va be
                        f.escribirFichero("\tMOVE.W #" + inst.param1 + ", D0");
                        f.escribirFichero("\tMOVE.W #" + inst.param2 + ", D1");
                        f.escribirFichero("\tSUB.W D0, D1");
                        f.escribirFichero("\tMOVE.W D1, " + inst.destino);
                    } else { //x=#*v
                        f.escribirFichero("\tMOVE.W #" + inst.param1 + ", D0");
                        f.escribirFichero("\tMOVE.W (" + inst.param2 + "), D1");
                        f.escribirFichero("\tSUB.W D0, D1");
                        f.escribirFichero("\tMOVE.W D1, " + inst.destino);
                    }
                } else { //x = v*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= v*# //va be
                        f.escribirFichero("\tMOVE.W (" + inst.param1 + "), D0");
                        f.escribirFichero("\tMOVE.W #" + inst.param2 + ", D1");
                        f.escribirFichero("\tSUB.W D0, D1");
                        f.escribirFichero("\tMOVE.W D1, " + inst.destino);
                    } else { //x=v*v
                        f.escribirFichero("\tMOVE.W (" + inst.param1 + "), D0");
                        f.escribirFichero("\tMOVE.W (" + inst.param2 + "), D1");
                        f.escribirFichero("\tSUB.W D0, D1");
                        f.escribirFichero("\tMOVE.W D1, " + inst.destino);
                    }
                }
                break;

            case MUL:
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) {  //x=#*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= #*# //va be
                        f.escribirFichero("\tMOVE.W #" + inst.param1 + ", D0");
                        f.escribirFichero("\tMOVE.W #" + inst.param2 + ", D1");
                        f.escribirFichero("\tMULU.W D0, D1");
                        f.escribirFichero("\tMOVE.W D1, " + inst.destino);
                    } else { //x=#*v
                        f.escribirFichero("\tMOVE.W #" + inst.param1 + ", D0");
                        f.escribirFichero("\tMOVE.W (" + inst.param2 + "), D1");
                        f.escribirFichero("\tMULU.W D0, D1");
                        f.escribirFichero("\tMOVE.W D1, " + inst.destino);
                    }
                } else { //x = v*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= v*# //va be
                        f.escribirFichero("\tMOVE.W (" + inst.param1 + "), D0");
                        f.escribirFichero("\tMOVE.W #" + inst.param2 + ", D1");
                        f.escribirFichero("\tMULU.W D0, D1");
                        f.escribirFichero("\tMOVE.W D1, " + inst.destino);
                    } else { //x=v*v
                        f.escribirFichero("\tMOVE.W (" + inst.param1 + "), D0");
                        f.escribirFichero("\tMOVE.W (" + inst.param2 + "), D1");
                        f.escribirFichero("\tMULU.W D0, D1");
                        f.escribirFichero("\tMOVE.W D1, " + inst.destino);
                    }
                }
                break;
                
            case DIV:
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) {  //x=#*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= #*# //va be
                        f.escribirFichero("\tMOVE.W #" + inst.param1 + ", D0");
                        f.escribirFichero("\tMOVE.W #" + inst.param2 + ", D1");
                        f.escribirFichero("\tDIVS.W D0, D1");
                        f.escribirFichero("\tMOVE.W D1, " + inst.destino);
                    } else { //x=#*v
                        f.escribirFichero("\tMOVE.W #" + inst.param1 + ", D0");
                        f.escribirFichero("\tMOVE.W (" + inst.param2 + "), D1");
                        f.escribirFichero("\tDIVS.W D0, D1");
                        f.escribirFichero("\tMOVE.W D1, " + inst.destino);
                    }
                } else { //x = v*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= v*# //va be
                        f.escribirFichero("\tMOVE.W (" + inst.param1 + "), D0");
                        f.escribirFichero("\tMOVE.W #" + inst.param2 + ", D1");
                        f.escribirFichero("\tDIVS.W D0, D1");
                        f.escribirFichero("\tMOVE.W D1, " + inst.destino);
                    } else { //x=v*v
                        f.escribirFichero("\tMOVE.W (" + inst.param1 + "), D0");
                        f.escribirFichero("\tMOVE.W (" + inst.param2 + "), D1");
                        f.escribirFichero("\tDIVS.W D0, D1");
                        f.escribirFichero("\tMOVE.W D1, " + inst.destino);
                    }
                }
                break;          
                
            case MOD: // DIVU
               if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) {  //x=#*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= #*# //va be
                        f.escribirFichero("\tMOVE.W #" + inst.param1 + ", D0");
                        f.escribirFichero("\tMOVE.W #" + inst.param2 + ", D1");
                        f.escribirFichero("\tDIVU.W D0, D1");
                        f.escribirFichero("\tMOVE.W D1, " + inst.destino);
                    } else { //x=#*v
                        f.escribirFichero("\tMOVE.W #" + inst.param1 + ", D0");
                        f.escribirFichero("\tMOVE.W (" + inst.param2 + "), D1");
                        f.escribirFichero("\tDIVU.W D0, D1");
                        f.escribirFichero("\tMOVE.W D1, " + inst.destino);
                    }
                } else { //x = v*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= v*# //va be
                        f.escribirFichero("\tMOVE.W (" + inst.param1 + "), D0");
                        f.escribirFichero("\tMOVE.W #" + inst.param2 + ", D1");
                        f.escribirFichero("\tDIVU.W D0, D1");
                        f.escribirFichero("\tMOVE.W D1, " + inst.destino);
                    } else { //x=v*v
                        f.escribirFichero("\tMOVE.W (" + inst.param1 + "), D0");
                        f.escribirFichero("\tMOVE.W (" + inst.param2 + "), D1");
                        f.escribirFichero("\tDIVU.W D0, D1");
                        f.escribirFichero("\tMOVE.W D1, " + inst.destino);
                    }
                }
                break;
                
            case AND:
                
                break;
                
            case OR:
                
                break;                
  
    /*
    LT,--
    LE,--
    EQ,--
    NE,--
    GE,--
    GT,--
    IFGT, --
    ASSIG, --* Es el copy
    GOTO, --
     */
        }
    }
}
