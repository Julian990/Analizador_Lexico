package codigo;           
import static codigo.Tokens.*;         
%%                       
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r]+
%{
    public String lexeme;
%}
%%

{espacio} {/*Ignore*/}

"//".* {/*Ignore*/}

"\n" {lexeme=yytext(); return Linea;}

"(" {lexeme=yytext(); return ParentecisA;}
")" {lexeme=yytext(); return ParentecisC;}
";" {lexeme=yytext(); return FinalLinea;}
"{" {lexeme=yytext(); return LlaveA;}
"}" {lexeme=yytext(); return LlaveC;}

"int" {lexeme=yytext(); return Int;}
"char" {lexeme=yytext(); return Chart;}
"String" {lexeme=yytext(); return string;}
"float" {lexeme=yytext(); return Float;}
"long" {lexeme=yytext(); return Long;}

"if" {lexeme=yytext(); return If;}
"else" {lexeme=yytext(); return Else;}
"package" {lexeme=yytext(); return Package;}
"public" {lexeme=yytext(); return Public;}
"class" {lexeme=yytext(); return Class;}
"return" {lexeme=yytext(); return Return;}

"+" {lexeme=yytext(); return Suma;}
"-" {lexeme=yytext(); return Resta;}
"*" {lexeme=yytext(); return Multiplicaion;}
"/" {lexeme=yytext(); return Division;}
"%" {lexeme=yytext(); return Modulo;}

"++" {lexeme=yytext(); return Incremento;}
"--" {lexeme=yytext(); return Decremento;}

"=" {lexeme=yytext(); return Asignacion;}

"==" {lexeme=yytext(); return IgualQue;}
"!=" {lexeme=yytext(); return DistintoDe;}
"<" {lexeme=yytext(); return MenorQue;}
">" {lexeme=yytext(); return MayorQue;}
"<=" {lexeme=yytext(); return MenorIgualQue;}
">=" {lexeme=yytext(); return MayorIgualQue;}

"!" {lexeme=yytext(); return Negacion;}
"&" {lexeme=yytext(); return And;}
"||" {lexeme=yytext(); return Or;}

{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {lexeme=yytext(); return ERROR;}

