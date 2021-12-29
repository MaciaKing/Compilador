/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.sintactic.symbols;

import compilador.sintactic.Etiqueta;
import java_cup.runtime.ComplexSymbolFactory;

/**
 *
 * @author macia
 */
public class SymbolCM extends ComplexSymbolFactory.ComplexSymbol {

    public Etiqueta efi;
    public Etiqueta ei;

    public SymbolCM(String name, int id) {
        super(name, id);
    }

    public SymbolCM() {
        super("CM", 0);
    }

    public SymbolCM(Etiqueta efi, Etiqueta ei) {
        super("SymbolCM", 0);
            this.efi = efi;
            this.ei = ei;
    }

    public Etiqueta getEtiqueta(boolean esEfi) {
        if (esEfi) {
            return efi;
        } else {
            return ei;
        }
    }
}
