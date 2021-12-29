/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorprueba;

import compilador.sintactic.symbols.SymbolI;
import java.io.CharArrayReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;
import java_cup.runtime.SymbolFactory;
import compilador.lexic.Scanner;
import compilador.sintactic.Parser;
import compilador.sintactic.*;

/**
 *
 * @author jfher
 */
public class CompiladorPrueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Reader input;
//        while (true) {
            try {
//                if (args.length > 0) {
//                    input = new FileReader(args[0]);
                    input = new FileReader("prueba.txt");
//                } else {
//                    System.out.println("Escriu l'expressió que vols compilar:");
//                    System.out.print(">>> ");
//                    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//                    input = new CharArrayReader(in.readLine().toCharArray());
//                }

                SymbolFactory sf = new ComplexSymbolFactory();
                Scanner scanner = new Scanner(input);
                Parser parser = new Parser(scanner, sf);
                Symbol simbolResultat = parser.parse();
                SymbolI resultat = (SymbolI) simbolResultat.value;
            } catch (Exception e) {
                System.err.println("error: " + e);
                e.printStackTrace(System.err);
            } 
//        }
    }

}
