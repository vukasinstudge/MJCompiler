
package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

%{

	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}

%}

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}

%%

" " 	{ }
"\b" 	{ }
"\t" 	{ }
"\r\n" 	{ }
"\f" 	{ }

program     { return new_symbol(sym.PROG, yytext());}
break       { return new_symbol(sym.BREAK, yytext());}
class       { return new_symbol(sym.CLASS, yytext());}
enum        { return new_symbol(sym.ENUM, yytext());}
else        { return new_symbol(sym.ELSE, yytext());}
const       { return new_symbol(sym.CONST, yytext());}
if          { return new_symbol(sym.IF, yytext());}
switch      { return new_symbol(sym.SWITCH, yytext());}
do          { return new_symbol(sym.DO, yytext());}
while       { return new_symbol(sym.WHILE, yytext());}
new         { return new_symbol(sym.NEW, yytext());}
print       { return new_symbol(sym.PRINT, yytext());}
read        { return new_symbol(sym.READ, yytext());}
return      { return new_symbol(sym.RETURN, yytext());}
void        { return new_symbol(sym.VOID, yytext());}
extends     { return new_symbol(sym.EXTENDS, yytext());}
continue    { return new_symbol(sym.CONTINUE, yytext());}
case        { return new_symbol(sym.CASE, yytext());}

"<="        { return new_symbol(sym.LOWEREQUAL, yytext()); }
">="        { return new_symbol(sym.HIGHEREQUAL, yytext()); }
"!="        { return new_symbol(sym.NOTEQUAL, yytext()); }
"=="        { return new_symbol(sym.EQUALEQUAL, yytext()); }
"++"        { return new_symbol(sym.PLUSPLUS, yytext()); }
"--"        { return new_symbol(sym.MINUSMINUS, yytext()); }
"+" 		{ return new_symbol(sym.PLUS, yytext()); }
"-"         { return new_symbol(sym.MINUS, yytext()); } 
"=" 		{ return new_symbol(sym.EQUAL, yytext()); }
";" 		{ return new_symbol(sym.SEMI, yytext()); }
"," 		{ return new_symbol(sym.COMMA, yytext()); }
"(" 		{ return new_symbol(sym.LPAREN, yytext()); }
")" 		{ return new_symbol(sym.RPAREN, yytext()); }
"{" 		{ return new_symbol(sym.LBRACE, yytext()); }
"}"			{ return new_symbol(sym.RBRACE, yytext()); }
"*"         { return new_symbol(sym.TIMES, yytext()); }
"/"         { return new_symbol(sym.SLASH, yytext()); }
"%"         { return new_symbol(sym.PERCENT, yytext()); } 
">"         { return new_symbol(sym.HIGHER, yytext()); }
"<"         { return new_symbol(sym.LOWER, yytext()); }   
"&&"        { return new_symbol(sym.ANDAND, yytext()); }
"||"        { return new_symbol(sym.OROR, yytext()); }
"."         { return new_symbol(sym.DOT, yytext()); }
"["         { return new_symbol(sym.LBRACKET, yytext()); }
"]"         { return new_symbol(sym.RBRACKET, yytext()); }
"?"         { return new_symbol(sym.QUESTION, yytext()); }
":"         { return new_symbol(sym.COLON, yytext()); }

"//"             { yybegin(COMMENT);}
<COMMENT> .      { yybegin(COMMENT);}
<COMMENT> "\r\n" { yybegin(YYINITIAL); }

"true" | "false"                    { return new_symbol(sym.BOOL, yytext()); }
([a-z]|[A-Z])[a-z|A-Z|0-9|_]* 		{ return new_symbol(sym.IDENT, yytext()); }
[0-9]+                          	{ return new_symbol(sym.NUMBER, new Integer(yytext())); }
"'"[\040-\176]"'" 					{ return new_symbol(sym.CHAR, new Character(yytext().charAt(1)));}

. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1)+ " u koloni "+(yycolumn+1)); }










