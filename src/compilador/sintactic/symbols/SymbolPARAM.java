/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.sintactic.symbols;

/**
 *
 * @author jfher
 */
public class SymbolPARAM extends SymbolBase {

    public int nParamInt;
    public int nParamBool;

    public SymbolPARAM(String name, Integer id) {
        super(name, id);
    }

    public SymbolPARAM() {
        super("PARAM", 0);
    }

    public SymbolPARAM(boolean b) {
        super("PARAM", 0);
        if (b) {
            nParamInt = nParamInt + 1;
        } else {
            nParamBool = nParamBool + 1;
        }
    }
    
        public SymbolPARAM(boolean b, int i) {
        super("PARAM", 0);
        if (b) {
            nParamInt = i + 1;
        } else {
            nParamBool = i + 1;
        }
    }
}
