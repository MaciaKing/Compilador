/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.sintactic;

/**
 *
 * @author jfher
 */
public class InstrCodi3A {
    TiposInstruccionC3A instruccion;
    OperandoC3A param1;
    OperandoC3A param2;
    OperandoC3A destino;

    public InstrCodi3A(TiposInstruccionC3A instruccion, OperandoC3A param1, OperandoC3A param2, OperandoC3A destino) {
        this.instruccion = instruccion;
        this.param1 = param1;
        this.param2 = param2;
        this.destino = destino;
    }

    @Override
    public String toString() {
//        String devolver = instruccion + " ";
//        
//        if(param1 != null){
//            devolver += param1 + " ";
//        }else{
//            devolver += "OP{_____} ";
//        }
//        if(param2 != null){
//            devolver += param2 + " ";
//        }else{
//            devolver += "OP{_____} ";
//        }
//        if(destino != null){
//            devolver += destino + " ";
//        }else{
//            devolver += "OP{_____} ";
//        }
        String devolver = instruccion + " ";
        
        if(param1 != null){
            devolver += param1 + " ";
        }
        if(param2 != null){
            devolver += param2 + " ";
        }
        if(destino != null){
            devolver += destino + " ";
        }
        return devolver;
    }
    
    
}
