/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.sintactic.symbols;

import java_cup.runtime.ComplexSymbolFactory;

/**
 *
 * @author macia
 */
public class SymbolCASn extends ComplexSymbolFactory.ComplexSymbol{
    int v1;

    public SymbolCASn(String name, int id) {
        super(name, id);
    }
    
    public SymbolCASn(SymbolELp v1) {
        super("CASn", 0);
        this.v1=v1.r;
        System.out.println("He detectat case valor= "+v1);
    }
}