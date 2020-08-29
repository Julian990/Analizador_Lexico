package codigo;           
import static codigo.Tokens.*;         
%%                       
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
S=[(,),;,{,},:]
T=[int,char,String,float,long]
R=[if,else,package,public,class, return]
OA=[+,-,*,/,%]
OAI=[++,--]
OAC=[+=,-=,*=,/=,%=]
OR=[==,!=,<,>,<=,>=]
OL=[!,|,&,||,&&]
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%

{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
{R} {lexeme=yytext(); return Reservadas;}
{T} {lexeme=yytext(); return TipoDato;}
{S} {lexeme=yytext(); return Separador;}
"=" {lexeme=yytext(); return Asignacion;}
{OA} {lexeme=yytext(); return OperadorAritmetico;}
{OAI} {lexeme=yytext(); return OperadorAritmeticoIncremental;}
{OAC} {lexeme=yytext(); return OperadorAritmeticoCombinado;}
{OR} {lexeme=yytext(); return OperadorRelacion;}
{OL} {lexeme=yytext(); return OperadorLogico;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {lexeme=yytext(); return ERROR;}

