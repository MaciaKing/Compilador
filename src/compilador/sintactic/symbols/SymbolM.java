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
public class SymbolM extends ComplexSymbolFactory.ComplexSymbol{
    
    public SymbolM(String name, int id) {
        super(name, id);
    }
    
    public SymbolM(){
     super("M",0);   
    }
}