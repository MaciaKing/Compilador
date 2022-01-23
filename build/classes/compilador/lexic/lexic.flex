package compilador.lexic;

import java.io.*;
import java_cup.runtime.*;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;
import compilador.sintactic.ParserSym;
import java_cup.runtime.ComplexSymbolFactory.Location;

%%
%cup
%public              // Per indicar que la classe és pública
%class Scanner       // El nom de la classe

%char
%line
%column

%eofval{
  return symbol(ParserSym.EOF);
%eofval}

// Declaracions
id	     = [A-Za-z_][A-Za-z0-9_]*
digit        = [0-9]
digits       = {digit}+
vbooleano    = "cert"|"fals"
WS        = [ \t]+
ENDLINE   = [\r\n]+

// El següent codi es copiarà també, dins de la classe. És a dir, si es posa res
// ha de ser en el format adient: mètodes, atributs, etc. 
%{
    private ComplexSymbol symbol(int type) {
        Location left = new Location(yyline + 1,
                yycolumn + 1, (int) yychar);
        Location right = new Location(yyline + 1,
                yycolumn + yylength(), (int) (yychar + yylength()));
        return new ComplexSymbol(ParserSym.terminalNames[type], type, left, right);
    }

    
    private ComplexSymbol symbol(int type, Object value) {
        Location left = new Location(yyline + 1,
                yycolumn + 1, (int) yychar);
        Location right = new Location(yyline + 1,
                yycolumn + yylength(), (int) (yychar + yylength()));
        return new ComplexSymbol(ParserSym.terminalNames[type], type, left, right, value);
    }
%}

%%

// Regles/accions
{digits}          { return symbol(ParserSym.numero, this.yytext()); }
"si"              { return symbol(ParserSym.COND);                  }
"sino"            { return symbol(ParserSym.ECOND);                 }
"principal"       { return symbol(ParserSym.MAIN);                  }
"enter"           { return symbol(ParserSym.ENTER);                 }
"mentres"         { return symbol(ParserSym.MENTRES);               }
"eligeix"         { return symbol(ParserSym.ELIGEIX);               }
"cas"             { return symbol(ParserSym.CAS);                   }
"talla"           { return symbol(ParserSym.TALLA);                 }
"boolea"          { return symbol(ParserSym.BOOL);                  }
"nul"             { return symbol(ParserSym.NULL);                  }
"no!"             { return symbol(ParserSym.NO);                    }
"void"            { return symbol(ParserSym.VOID);                  }
"retorna"         { return symbol(ParserSym.RETORNA);               }
"and"             { return symbol(ParserSym.AND);                   }
"or"              { return symbol(ParserSym.OR);                    }
"llegirTeclat"    { return symbol(ParserSym.LECT);                  }
"sortidaPantalla" { return symbol(ParserSym.SORT);                  }
{vbooleano}       { return symbol(ParserSym.VBOOL,this.yytext());   }
"constant"        { return symbol(ParserSym.CONST);                 }
"func"            { return symbol(ParserSym.FUNC);                  }
{id}              { return symbol(ParserSym.ID, this.yytext());     }
"+"               { return symbol(ParserSym.ADD);                   }
":"               { return symbol(ParserSym.DOSPUNTS);              }
","               { return symbol(ParserSym.COMA);                  }
"-"               { return symbol(ParserSym.SUB);                   }
"*"               { return symbol(ParserSym.MUL);                   } 
"/"               { return symbol(ParserSym.DIV);                   }
"%"               { return symbol(ParserSym.MOD);                   }
"("               { return symbol(ParserSym.LPAREN);                }
")"               { return symbol(ParserSym.RPAREN);                }
"{"               { return symbol(ParserSym.LCLAVE);                }
"}"               { return symbol(ParserSym.RCLAVE);                }
"<"               { return symbol(ParserSym.MENOR);                 }
">"               { return symbol(ParserSym.MAYOR);                 }
"="               { return symbol(ParserSym.IGUAL);                 }
">o="             { return symbol(ParserSym.MAYIG);                 }
"<o="             { return symbol(ParserSym.MENIG);                 }
";"               { return symbol(ParserSym.PNTCM);                 }
{WS}              { /* no fer tres */                               }
{ENDLINE}         { return symbol(ParserSym.NEWLINE);               }
[^]               { return symbol(ParserSym.error);                 }
