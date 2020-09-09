package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ \t\r\n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}

/* Parentesis de apertura */
( "(" ) {return new Symbol(sym.ParentecisA, yychar, yyline, yytext());}

/* Parentesis de cierre */
( ")" ) {return new Symbol(sym.ParentecisC, yychar, yyline, yytext());}

/* Punto y coma */
( ";" ) {return new Symbol(sym.FinalLinea, yychar, yyline, yytext());}

/* Llave de apertura */
( "{" ) {return new Symbol(sym.LlaveA, yychar, yyline, yytext());}

/* Llave de cierre */
( "}" ) {return new Symbol(sym.LlaveC, yychar, yyline, yytext());}

/* Corchete de apertura */
( "[" ) {return new Symbol(sym.CorcheteA, yychar, yyline, yytext());}

/* Corchete de cierre */
( "]" ) {return new Symbol(sym.CorcheteC, yychar, yyline, yytext());}

/* Comillas */
( "\"" ) {return new Symbol(sym.Comillas, yychar, yyline, yytext());}

/* coma */
( "," ) {return new Symbol(sym.Coma, yychar, yyline, yytext());}

/* punto */
( "." ) {return new Symbol(sym.Punto, yychar, yyline, yytext());}

/* tipos de datos */
( "int" ) {return new Symbol(sym.TipoDato, yychar, yyline, yytext());}
( "char" ) {return new Symbol(sym.TipoDato, yychar, yyline, yytext());}
( "String" ) {return new Symbol(sym.string, yychar, yyline, yytext());}
( "float" ) {return new Symbol(sym.TipoDato, yychar, yyline, yytext());}
( "long" ) {return new Symbol(sym.TipoDato, yychar, yyline, yytext());}
( "byte" ) {return new Symbol(sym.TipoDato, yychar, yyline, yytext());}
( "double" ) {return new Symbol(sym.TipoDato, yychar, yyline, yytext());}

/* Palabra reservadas */
( "if" ) {return new Symbol(sym.If, yychar, yyline, yytext());}
( "else" ) {return new Symbol(sym.Else, yychar, yyline, yytext());}
( "package" ) {return new Symbol(sym.Package, yychar, yyline, yytext());}
( "public" ) {return new Symbol(sym.Public, yychar, yyline, yytext());}
( "class" ) {return new Symbol(sym.Class, yychar, yyline, yytext());}
( "return" ) {return new Symbol(sym.Return, yychar, yyline, yytext());}
( "do" ) {return new Symbol(sym.Do, yychar, yyline, yytext());}
( "while" ) {return new Symbol(sym.While, yychar, yyline, yytext());}
( "for" ) {return new Symbol(sym.For, yychar, yyline, yytext());}
( "main" ) {return new Symbol(sym.Main, yychar, yyline, yytext());}
( "static" ) {return new Symbol(sym.Static, yychar, yyline, yytext());}
( "void" ) {return new Symbol(sym.Void, yychar, yyline, yytext());}
( "private" ) {return new Symbol(sym.Private, yychar, yyline, yytext());}
( "try" ) {return new Symbol(sym.Try, yychar, yyline, yytext());}
( "catch" ) {return new Symbol(sym.Catch, yychar, yyline, yytext());}
( "Exception" ) {return new Symbol(sym.exception, yychar, yyline, yytext());}
( "import" ) {return new Symbol(sym.Import, yychar, yyline, yytext());}

/* operadores aritmeticos */
/* Operador Suma */
( "+" ) {return new Symbol(sym.OperadorAritmetico, yychar, yyline, yytext());}

/* Operador Resta */
( "-" ) {return new Symbol(sym.OperadorAritmetico, yychar, yyline, yytext());}

/* Operador Multiplicacion */
( "*" ) {return new Symbol(sym.OperadorAritmetico, yychar, yyline, yytext());}

/* Operador Division */
( "/" ) {return new Symbol(sym.OperadorAritmetico, yychar, yyline, yytext());}

/* Operador Modulo */
( "%" ) {return new Symbol(sym.OperadorAritmetico, yychar, yyline, yytext());}

/* Operadores Incremento y decremento */
( "++" ) {return new Symbol(sym.Incremento, yychar, yyline, yytext());}
( "--" ) {return new Symbol(sym.Incremento, yychar, yyline, yytext());}


/* Operador Asignacion */
( "=" ) {return new Symbol(sym.Asignacion, yychar, yyline, yytext());}

/*Operadores Relacionales */
( "==" ) {return new Symbol(sym.Relacionales, yychar, yyline, yytext());}
( "!=" ) {return new Symbol(sym.Relacionales, yychar, yyline, yytext());}
( "<" ) {return new Symbol(sym.Relacionales, yychar, yyline, yytext());}
( ">" ) {return new Symbol(sym.Relacionales, yychar, yyline, yytext());}
( "<=" ) {return new Symbol(sym.Relacionales, yychar, yyline, yytext());}
( ">=" ) {return new Symbol(sym.Relacionales, yychar, yyline, yytext());}

/* Operadores logicos */
( "!" ) {return new Symbol(sym.OperadorLogico, yychar, yyline, yytext());}
( "&" ) {return new Symbol(sym.OperadorLogico, yychar, yyline, yytext());}
( "||" ) {return new Symbol(sym.OperadorLogico, yychar, yyline, yytext());}

/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" | "=" ) {return new Symbol(sym.Atribucion, yychar, yyline, yytext());}

/*Operadores Booleanos*/
( true | false ) {return new Symbol(sym.Booleano, yychar, yyline, yytext());}

/* Identificador */
{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}

/* Numero */
("(-"{D}+")")|{D}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}

/* Error de analisis */
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}
