/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.sintactic.symbols;

import compilador.sintactic.symbols.SymbolBase;
import compilador.sintactic.symbols.SymbolEL;

/**
 *
 * @author jfher
 */
public class SymbolCND extends SymbolBase {

    public boolean booleano;
    int resultado;
    String identificador;

    public SymbolCND(String name, Integer id) {
        super(name, id);
    }

    public SymbolCND() {
        super("instrCS", 0);
    }

    public SymbolCND(SymbolCND e3) {
        super("instrCS", 0);
    }

    public SymbolCND(SymbolEL e1, SymbolP p) {
        super("instrCS", 0);
    }

    public SymbolCND(SymbolEL e1, SymbolSENTS e2) {
        super("instrCS", 0);
        if (e1.booleano) {
            this.identificador = e2.identificador;
            this.booleano = e1.booleano;
            this.resultado = e2.resultado;
            System.out.println("Ha entrado en el condicional y el resultado es: "
                    + e2.identificador + " = " + e2.resultado);
        } else {
//            System.out.println("No ha entrado en el condicional");
        }
    }

    public SymbolCND(SymbolEL e1, SymbolSENTS e2, SymbolSENTS e3) {
        super("instrCS", 0);
        if (e1.booleano) {
            System.out.println("Se cumple el SI el resultado es: "
                    + e2.identificador + " = " + e2.resultado);
        } else {
            System.out.println("No cumple el SI el resultado es: "
                    + e3.identificador + " = " + e3.resultado);
        }
    }

}
