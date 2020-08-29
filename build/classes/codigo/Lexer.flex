package codigo;               
import static codigo.Tokens.*;         
%%                       
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
S=[(,),;,{,},:]+
T=[int,char,String,float,long]+

espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%

if |
else |
package |
public |
class |
while {lexeme=yytext(); return Reservadas;}
{espacio} {/*Ignore*/}

{T} {lexeme=yytext(); return Tipo_de_Dato;}
{S} {lexeme=yytext(); return Separador;}
"//".* {/*Ignore*/}
"=" {lexeme=yytext(); return Igual;}
"+" {lexeme=yytext(); return Suma;}
"-" {lexeme=yytext(); return Resta;}
"*" {lexeme=yytext(); return Multiplicacion;}
"/" {lexeme=yytext(); return Division;}

{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {lexeme=yytext(); return ERROR;}

