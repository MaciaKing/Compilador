/*
 * 
 */
package codiEnsamblador;

import compilador.sintactic.Codi3A;
import compilador.sintactic.EscritorFichero;
import compilador.sintactic.InstrCodi3A;
import compilador.sintactic.OperandoC3A;
import compilador.sintactic.TablaVariables;
import compilador.sintactic.TiposInstruccionC3A;
import compilador.sintactic.TiposOperandoC3A;
import compilador.sintactic.variable;
import compilador.sintactic.Error;
import java.util.ArrayList;

/**
 *
 * @author macia
 */
public class GeneraEnsablador {

    //Codi3A c;
    EscritorFichero f;
    ArrayList<String> parametros;

    public GeneraEnsablador() {
        f = new EscritorFichero("XXXXXXXX.X68");
        parametros = new ArrayList<>();
    }

    public void veurePilaCridades() {
        System.out.println("-------------------------------------------");

    }

    public void generaError68k() {
       // f.escribirFichero(inst.destino.toString());
       f.escribirFichero("\tORG    $600");
       f.escribirFichero("true DC.B '"+Error.causaError+"',0");
       f.escribirFichero("SL\tDS.W 1 *Variable auxiliar para los saltos de linea de la consola");
       f.escribirFichero("\tORG    $1000");
       f.escribirFichero("\nSTART:");
        f.escribirFichero("\tMOVEM.L D0-D1/A1,-(A7)");
        f.escribirFichero("\tMOVE.W (SL),D1\n\tMOVE.B #11,D0\n\tTRAP #15");
        f.escribirFichero("\tMOVE.W 16(A7),D1");
        //f.escribirFichero("\tTST.W D1");
        //f.escribirFichero("\tBEQ fals");
        f.escribirFichero("\tLEA true,A1");
       // f.escribirFichero("\tJMP finb");
       // f.escribirFichero("fals");
       // f.escribirFichero("\tLEA false,A1");
        //f.escribirFichero("finb");
        f.escribirFichero("\tMOVE.B #14,D0");
        f.escribirFichero("\tTRAP #15");
        f.escribirFichero("\tMOVEM.L (A7)+,D0-D1/A1");
        f.escribirFichero("\tEND START");
        f.cierraFichero();
    }

    public void generaCodi68k() {
        f.escribirFichero("\tORG    $600");
        //primero generamos las variables
        for (int i = 0; i < TablaVariables.tVar.size(); i++) {
            generaVariableGlobal68k(TablaVariables.tVar.get(i).idVariable);
        }
        f.escribirFichero("SL\tDS.W 1 *Variable auxiliar para los saltos de linea de la consola");
        f.escribirFichero("\n\tORG    $1000");
        f.escribirFichero("\nSTART:");
        f.escribirFichero("\tMOVE.W #0,SL");
        //Ahora cogemos las instrucciones del codigo 3A
        for (int i = 0; i < Codi3A.C3A.size(); i++) {
            generaInstruccion68k(Codi3A.C3A.get(i));
        }
        f.escribirFichero("\tJMP FIN");
        generaInstruccion68k(new InstrCodi3A(TiposInstruccionC3A.PMB, null, null, new OperandoC3A("imprimeix", TiposOperandoC3A.procedure)));
        generaInstruccion68k(new InstrCodi3A(TiposInstruccionC3A.PMB, null, null, new OperandoC3A("imprimeixBooleano", TiposOperandoC3A.procedure)));
        generaInstruccion68k(new InstrCodi3A(TiposInstruccionC3A.PMB, null, null, new OperandoC3A("escriure", TiposOperandoC3A.procedure)));
        f.escribirFichero("FIN");
        f.escribirFichero("\tEND START");
        f.cierraFichero();
    }

    public void generaVariableGlobal68k(String nombre) {
        nombre += "\tDS.L 1";
        f.escribirFichero(nombre);
    }

    public void generaInstruccion68k(InstrCodi3A inst) {
        switch (inst.instruccion) {
            case SKIP:
                f.escribirFichero(inst.destino.toString() + ":");
                break;
            case COPY:

                f.escribirFichero("\tMOVE.L #" + inst.param2 + "," + inst.destino);
                break;
            case ADD:
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) {  //x=#*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= #*# //va be
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tADD.L D0,D1");
                        f.escribirFichero("\tMOVE.L D1," + inst.destino);
                    } else { //x=#*v

                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tADD.L D0,D1");
                        f.escribirFichero("\tMOVE.L D1," + inst.destino);
                    }
                } else { //x = v*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= v*# //va be
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tADD.L D0,D1");
                        f.escribirFichero("\tMOVE.L D1," + inst.destino);
                    } else { //x=v*v

                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tADD.L D0, D1");
                        f.escribirFichero("\tMOVE.L D1, " + inst.destino);
                    }
                }
                break;

            case SUB:
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) {  //x=#*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= #*# //va be
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        //f.escribirFichero("\tSUB.L D0, D1");
                        //f.escribirFichero("\tMOVE.L D1, " + inst.destino);
                        f.escribirFichero("\tSUB.L D1, D0");
                        f.escribirFichero("\tMOVE.L D0, " + inst.destino);
                    } else { //x=#*v
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
//                        f.escribirFichero("\tSUB.L D0,D1");
//                        f.escribirFichero("\tMOVE.L D1," + inst.destino);
                        f.escribirFichero("\tSUB.L D1, D0");
                        f.escribirFichero("\tMOVE.L D0, " + inst.destino);
                    }
                } else { //x = v*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= v*# //va be
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
//                        f.escribirFichero("\tSUB.L D0,D1");
//                        f.escribirFichero("\tMOVE.L D1," + inst.destino);
                        f.escribirFichero("\tSUB.L D1, D0");
                        f.escribirFichero("\tMOVE.L D0, " + inst.destino);
                    } else { //x=v*v
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
//                        f.escribirFichero("\tSUB.L D0,D1");
//                        f.escribirFichero("\tMOVE.L D1," + inst.destino);
                        f.escribirFichero("\tSUB.L D1, D0");
                        f.escribirFichero("\tMOVE.L D0, " + inst.destino);
                    }
                }
                break;

            case MUL:
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) {  //x=#*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= #*# //va be
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tMULU.W D0,D1");
                        f.escribirFichero("\tMOVE.L D1," + inst.destino);
                    } else { //x=#*v
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tMULU.W D0,D1");
                        f.escribirFichero("\tMOVE.W D1," + inst.destino);
                    }
                } else { //x = v*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= v*# //va be
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tMULU.W D0,D1");
                        f.escribirFichero("\tMOVE.W D1," + inst.destino);
                    } else { //x=v*v
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tMULU.W D0,D1");
                        f.escribirFichero("\tMOVE.W D1," + inst.destino);
                    }
                }
                break;

            case DIV:
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) {  //x=#*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= #*# //va be
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tDIVS.W D0,D1");
                        f.escribirFichero("\tMOVE.L D1," + inst.destino);
                    } else { //x=#*v
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tDIVS.W D0,D1");
                        f.escribirFichero("\tMOVE.W D1," + inst.destino);
                    }
                } else { //x = v*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= v*# //va be
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tDIVS.W D0,D1");
                        f.escribirFichero("\tMOVE.L D1," + inst.destino);
                    } else { //x=v*v
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tDIVS.W D0,D1");
                        f.escribirFichero("\tMOVE.L D1," + inst.destino);
                    }
                }
                break;

            case MOD: // DIVU
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) {  //x=#*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= #*# //va be
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tDIVU.L D0,D1");
                        f.escribirFichero("\tMOVE.L D1," + inst.destino);
                    } else { //x=#*v
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tDIVU.L D0,D1");
                        f.escribirFichero("\tMOVE.L D1," + inst.destino);
                    }
                } else { //x = v*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= v*# //va be
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tDIVU.L D0,D1");
                        f.escribirFichero("\tMOVE.L D1," + inst.destino);
                    } else { //x=v*v
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tDIVU.L D0,D1");
                        f.escribirFichero("\tMOVE.L D1," + inst.destino);
                    }
                }
                break;

            case AND:
//                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) { // (# > ?)
//                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { // (# > #)
//                        f.escribirFichero("\tMOVE.W #" + inst.param1 + ", D0");
//                        f.escribirFichero("\tMOVE.W #" + inst.param2 + ", D1");
//                        f.escribirFichero("\tCMP.W  D1, D0");
//                        f.escribirFichero("\tBGT " + inst.destino);
//                    }else{ // (# > v)
//                        f.escribirFichero("\tMOVE.W #" + inst.param1 + ", D0");
//                        f.escribirFichero("\tMOVE.W (" + inst.param2 + "), D1");
//                        f.escribirFichero("\tCMP.W  D1, D0");
//                        f.escribirFichero("\tBGT " + inst.destino);                        
//                    }
//
//                } else { // (v > ?)
//                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { // (v > #)
//                        f.escribirFichero("\tMOVE.W (" + inst.param1 + "), D0");
//                        f.escribirFichero("\tMOVE.W #" + inst.param2 + ", D1");
//                        f.escribirFichero("\tCMP.W  D1, D0");
//                        f.escribirFichero("\tBGT " + inst.destino);
//                    } else { // (v > v)
//                        f.escribirFichero("\tMOVE.W (" + inst.param1 + "), D0");
//                        f.escribirFichero("\tMOVE.W (" + inst.param2 + "), D1");
//                        f.escribirFichero("\tCMP.W  D1, D0");
//                        f.escribirFichero("\tBGT " + inst.destino);
//                    }
//                }
                break;

            case OR:

                break;

            case IFGT: //A>B. A > B tras CMP B, A
                // f.escribirFichero("\t ---------- " + inst.param1 + "," + inst.param2 + "," + inst.destino);
                f.escribirFichero("\t ;IFGT " + inst.param1 + "," + inst.param2 + "," + inst.destino);
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) { // (# > ?)
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { // (# > #)
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tCMP.L  D1,D0");
                        f.escribirFichero("\tBGT " + inst.destino);
                    } else { // (# > v)
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tCMP.L  D1,D0");
                        f.escribirFichero("\tBGT " + inst.destino);
                    }

                } else { // (v > ?)
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { // (v > #)
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tCMP.L  D1, D0");
                        f.escribirFichero("\tBGT " + inst.destino);
                    } else { // (v > v)
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tCMP.L  D1,D0");
                        f.escribirFichero("\tBGT " + inst.destino);
                    }
                }
                break;

            case GE:
                f.escribirFichero("\t ;GE " + inst.param1 + "," + inst.param2 + "," + inst.destino);
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) { // (# > ?)
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { // (# > #)
                        f.escribirFichero("\tMOVE.W #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.W #" + inst.param2 + ",D1");
                        f.escribirFichero("\tCMP.W  D1, D0");
                        f.escribirFichero("\tBGE " + inst.destino);
                    } else { // (# > v)
                        f.escribirFichero("\tMOVE.W #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.W (" + inst.param2 + "),D1");
                        f.escribirFichero("\tCMP.W  D1,D0");
                        f.escribirFichero("\tBGE " + inst.destino);
                    }

                } else { // (v > ?)
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { // (v > #)
                        f.escribirFichero("\tMOVE.W (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.W #" + inst.param2 + ",D1");
                        f.escribirFichero("\tCMP.W  D1, D0");
                        f.escribirFichero("\tBGE " + inst.destino);
                    } else { // (v > v)
                        f.escribirFichero("\tMOVE.W (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.W (" + inst.param2 + "),D1");
                        f.escribirFichero("\tCMP.W  D1,D0");
                        f.escribirFichero("\tBGE " + inst.destino);
                    }
                }
                break;

            case LE:
                f.escribirFichero("\t ;LE " + inst.param1 + "," + inst.param2 + "," + inst.destino);
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) { // (# > ?)
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { // (# > #)
                        f.escribirFichero("\tMOVE.W #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.W #" + inst.param2 + ",D1");
                        f.escribirFichero("\tCMP.W  D1,D0");
                        f.escribirFichero("\tBLE " + inst.destino);
                    } else { // (# > v)
                        f.escribirFichero("\tMOVE.W #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.W (" + inst.param2 + "),D1");
                        f.escribirFichero("\tCMP.W  D1,D0");
                        f.escribirFichero("\tBLE " + inst.destino);
                    }

                } else { // (v > ?)
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { // (v > #)
                        f.escribirFichero("\tMOVE.W (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.W #" + inst.param2 + ",D1");
                        f.escribirFichero("\tCMP.W  D1, D0");
                        f.escribirFichero("\tBLE " + inst.destino);
                    } else { // (v > v)
                        f.escribirFichero("\tMOVE.W (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.W (" + inst.param2 + "),D1");
                        f.escribirFichero("\tCMP.W  D1,D0");
                        f.escribirFichero("\tBLE " + inst.destino);
                    }
                }
                break;

            case LT:
                f.escribirFichero("\t ;LT " + inst.param1 + "," + inst.param2 + "," + inst.destino);
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) { // (# > ?)
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { // (# > #)
                        f.escribirFichero("\tMOVE.W #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.W #" + inst.param2 + ",D1");
                        f.escribirFichero("\tCMP.W  D1,D0");
                        f.escribirFichero("\tBLT " + inst.destino);
                    } else { // (# > v)
                        f.escribirFichero("\tMOVE.W #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.W (" + inst.param2 + "),D1");
                        f.escribirFichero("\tCMP.W  D1,D0");
                        f.escribirFichero("\tBLT " + inst.destino);
                    }

                } else { // (v > ?)
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { // (v > #)
                        f.escribirFichero("\tMOVE.W (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.W #" + inst.param2 + ",D1");
                        f.escribirFichero("\tCMP.W  D1,D0");
                        f.escribirFichero("\tBLT " + inst.destino);
                    } else { // (v > v)
                        f.escribirFichero("\tMOVE.W (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.W (" + inst.param2 + "),D1");
                        f.escribirFichero("\tCMP.W  D1,D0");
                        f.escribirFichero("\tBLT " + inst.destino);
                    }
                }
                break;

            case EQ:
                if (inst.temporal) {
                    f.escribirFichero("\t ;EQUAAAAAL----TEMPORAL " + TablaVariables.tVar.get(Integer.parseInt(inst.param1.operando)).idVariable + ", " + inst.param2.operando + "," + inst.destino);
                    f.escribirFichero("\tMOVE.L (" + TablaVariables.tVar.get(Integer.parseInt(inst.param1.operando)).idVariable + "), D0");
                    f.escribirFichero("\tMOVE.L #" + inst.param2.operando + ", D1");
                    f.escribirFichero("\tCMP.L  D0,D1");
                    //f.escribirFichero("\tCMP.W  D0, D1");
                    f.escribirFichero("\tBEQ " + inst.destino);
                } else {

                    f.escribirFichero("\t ;EQ " + inst.param1 + "," + inst.param2 + "," + inst.destino);
                    if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) { // (# > ?)
                        if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { // (# > #)
                            f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                            f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                            f.escribirFichero("\tCMP.L  D1,D0");
                            f.escribirFichero("\tBEQ " + inst.destino);
                        } else { // (# > v)
                            f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                            f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                            f.escribirFichero("\tCMP.L  D1,D0");
                            f.escribirFichero("\tBEQ " + inst.destino);
                        }

                    } else { // (v > ?)
                        if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { // (v > #)
                            //if(inst.param1.operando.equals("cert")){
                            if (inst.param1.operando.equals("cert")) {
                                // f.escribirFichero("encontradooo !!!!!!!!!!!!!!!!!! cert");
                                f.escribirFichero("\tMOVE.L #-1, D0");
                                f.escribirFichero("\tMOVE.L #" + inst.param2 + ", D1");
                                f.escribirFichero("\tCMP.L  D1, D0");
                                f.escribirFichero("\tBEQ " + inst.destino);
                            } else if (inst.param1.operando.equals("fals")) {
                                // f.escribirFichero("encontradooo !!!!!!!!!!!!!!!!!! fals");
                                f.escribirFichero("\tMOVE.L #0, D0");
                                f.escribirFichero("\tMOVE.L #" + inst.param2 + ", D1");
                                f.escribirFichero("\tCMP.L  D1, D0");
                                f.escribirFichero("\tBEQ " + inst.destino);
                            } else {
                                f.escribirFichero("\tMOVE.L (" + inst.param1 + "), D0");
                            }
                            f.escribirFichero("\tMOVE.L #" + inst.param2 + ", D1");
                            f.escribirFichero("\tCMP.L  D1, D0");
                            f.escribirFichero("\tBEQ " + inst.destino);
                        } else { // (v > v)
                            f.escribirFichero("\tMOVE.L (" + inst.param1 + "), D0");
                            f.escribirFichero("\tMOVE.L (" + inst.param2 + "), D1");
                            f.escribirFichero("\tCMP.L  D1, D0");
                            f.escribirFichero("\tBEQ " + inst.destino);
                        }
                    }
                }
                break;

            case GOTO:
                f.escribirFichero("\tJMP " + inst.destino);
                break;

            case PARAM_S:
                parametros.add(inst.destino.toString());
                break;
            case CALL:
                if (inst.destino.toString().contains("imprimeix")) {
                    f.escribirFichero("\tMOVE.L (" + parametros.get(0) + "),-(A7)");
                    f.escribirFichero("\tJSR " + inst.destino);
                    f.escribirFichero("\tMOVE.L (A7)+,(" + parametros.get(0) + ")");
                    f.escribirFichero("\tADD.L #1,SL");
                } else {
                    if (inst.destino.toString() == "escriure") {
                        f.escribirFichero("\tMOVE.L D2,-(A7)");
                        f.escribirFichero("\tJSR " + inst.destino);
                        f.escribirFichero("\tMOVE.L D2," + parametros.get(0));
                        f.escribirFichero("\tMOVE.L (A7)+,D2");
                        f.escribirFichero("\tADD.L #1,SL");
                    }
                }

                parametros.clear();
                break;
            case PMB:
                if (inst.destino.toString() == "imprimeix") {
                    f.escribirFichero(inst.destino.toString());
                    f.escribirFichero("\tMOVEM.L D0-D1,-(A7)");
                    f.escribirFichero("\tMOVE.L (SL),D1\n\tMOVE.B #11,D0\n\tTRAP #15");
                    f.escribirFichero("\tMOVE.L 12(A7),D1");
                    f.escribirFichero("\tMOVE.B #3,D0");
                    f.escribirFichero("\tTRAP #15");
                    f.escribirFichero("\tMOVEM.L (A7)+,D0-D1");
                    f.escribirFichero("\tRTS");

                } else {
                    if (inst.destino.toString() == "imprimeixBooleano") {
                        f.escribirFichero(inst.destino.toString());
                        f.escribirFichero("\tMOVEM.L D0-D1/A1,-(A7)");
                        f.escribirFichero("\tMOVE.W (SL),D1\n\tMOVE.B #11,D0\n\tTRAP #15");
                        f.escribirFichero("\tMOVE.W 16(A7),D1");
                        f.escribirFichero("\tTST.W D1");
                        f.escribirFichero("\tBEQ fals");
                        f.escribirFichero("\tLEA true,A1");
                        f.escribirFichero("\tJMP finb");
                        f.escribirFichero("fals");
                        f.escribirFichero("\tLEA false,A1");
                        f.escribirFichero("finb");
                        f.escribirFichero("\tMOVE.B #14,D0");
                        f.escribirFichero("\tTRAP #15");
                        f.escribirFichero("\tMOVEM.L (A7)+,D0-D1/A1");
                        f.escribirFichero("\tRTS");
                        f.escribirFichero("true DC.B 'cert',0");
                        f.escribirFichero("false DC.B 'fals',0\n\tDS.W 0");

                    }
                    if (inst.destino.toString() == "escriure") {
                        f.escribirFichero(inst.destino.toString());
                        f.escribirFichero("\tMOVEM.L D0-D1/A1,-(A7)");
                        f.escribirFichero("\tMOVE.W (SL),D1\n\tMOVE.B #11,D0\n\tTRAP #15");
                        f.escribirFichero("\tLEA write,A1\n\tMOVE.B #14,D0\n\tTRAP #15");
                        f.escribirFichero("\tMOVE.W  #(13)<<8,D1\n\tOR.W (SL),D1\n\tMOVE.B #11,D0\n\tTRAP #15");
                        f.escribirFichero("\tMOVE.B #4,D0");
                        f.escribirFichero("\tTRAP #15");
                        f.escribirFichero("\tMOVE.W D1,D2");
                        f.escribirFichero("\tMOVEM.L (A7)+,D0-D1/A1");
                        f.escribirFichero("\tRTS");
                        f.escribirFichero("write DC.B 'escriu aqui: ',0\n\tDS.W 0");

                    }
                }
                break;

            /*
                
    LT,--
    LE,--
    EQ,--
    NE,--
    GE,--

    IFGT, --
    ASSIG, --* Es el copy
    GOTO, --
             */
        }
    }
}
