package codigo;           
import static codigo.Tokens.*;         
%%                       
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ \t\r]+

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
"[" {lexeme=yytext(); return CorcheteA;}
"]" {lexeme=yytext(); return CorcheteC;}
"\"" {lexeme=yytext(); return Comillas;}
"," {lexeme=yytext(); return Coma;}
"." {lexeme=yytext(); return Punto;}

"int" {lexeme=yytext(); return TipoDato;}
"char" {lexeme=yytext(); return Char;}
"String" {lexeme=yytext(); return TipoDato;}
"float" {lexeme=yytext(); return TipoDato;}
"long" {lexeme=yytext(); return TipoDato;}
"byte" {lexeme=yytext(); return TipoDato;}
"double" {lexeme=yytext(); return TipoDato;}

"if" {lexeme=yytext(); return If;}
"else" {lexeme=yytext(); return Else;}
"package" {lexeme=yytext(); return Package;}
"public" {lexeme=yytext(); return Public;}
"class" {lexeme=yytext(); return Class;}
"return" {lexeme=yytext(); return Return;}
"do" {lexeme=yytext(); return Do;}
"while" {lexeme=yytext(); return While;}
"for" {lexeme=yytext(); return For;}
"main" {lexeme=yytext(); return Main;}
"static" {lexeme=yytext(); return Static;}
"void" {lexeme=yytext(); return Void;}
"private" {lexeme=yytext(); return Private;}
"try" {lexeme=yytext(); return Try;}
"catch" {lexeme=yytext(); return Catch;}
"new" {lexeme=yytext(); return New;}

"Exception" {lexeme=yytext(); return exception;}
"import" {lexeme=yytext(); return Import;}

"+" {lexeme=yytext(); return OperadorAritmetico;}
"-" {lexeme=yytext(); return OperadorAritmetico;}
"*" {lexeme=yytext(); return OperadorAritmetico;}
"/" {lexeme=yytext(); return OperadorAritmetico;}
"%" {lexeme=yytext(); return OperadorAritmetico;}

"++" {lexeme=yytext(); return Incremento;}
"--" {lexeme=yytext(); return Incremento;}

"=" {lexeme=yytext(); return Asignacion;}

"==" {lexeme=yytext(); return Relacionales;}
"!=" {lexeme=yytext(); return Relacionales;}
"<" {lexeme=yytext(); return Relacionales;}
">" {lexeme=yytext(); return Relacionales;}
"<=" {lexeme=yytext(); return Relacionales;}
">=" {lexeme=yytext(); return Relacionales;}

"!" {lexeme=yytext(); return OperadorLogico;}
"&" {lexeme=yytext(); return OperadorLogico;}
"||" {lexeme=yytext(); return OperadorLogico;}

"+=" {lexeme=yytext(); return Atribucion;}
"-="  {lexeme=yytext(); return Atribucion;}
"*=" {lexeme=yytext(); return Atribucion;}
"/=" {lexeme=yytext(); return Atribucion;}
"%=" {lexeme=yytext(); return Atribucion;}
"=" {lexeme=yytext(); return Atribucion;}

"true" {lexeme=yytext(); return Booleano;}
"false" {lexeme=yytext(); return Booleano;}

{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
/* . {lexeme=yytext(); return ERROR;}*/

