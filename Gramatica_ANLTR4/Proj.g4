grammar Proj;

prog: 'Program' segvar segfunct 'BEGIN' body_program 'END' EOF;

segvar: 'VARIABLE' ':' (defvar (';' defvar)* ';')?;

defvar: 'int' ID '=' Digitos 
      | 'float' ID '=' Digitos '.' Digitos 
      | 'string' ID '=' Cadena 
      | 'bool' ID '=' ('true'|'false')
      ;
      
segfunct: 'FUNCTION' ':' (deffunct)? ;

deffunct: 'function' ID '(' ID ')' '{' bodyfunct '}' deffunct?;

bodyfunct: defarith ';' 'RETURN' ID ';' ;

//Aritmetica
defarith: bodysegE ;

bodysegE: bodysegT bodysegE2 ;


bodysegE2: ('+' bodysegT bodysegE2
          | '-' bodysegT bodysegE2
          )?
          ;

bodysegT: itemarith bodysegT2;


bodysegT2: ('*' itemarith bodysegT2
          | '/' itemarith bodysegT2
          )?
          ;

itemarith: ID
         | Digitos
         | '(' bodysegE ')'
         ;
		 
body_program: (def_cond 
		      | def_while 
			  | def_w 
			  | call_funct)* 
			  ;

//Seccion IF
def_cond: 'cond' 'if' '(' def_exp  ')' '{' def_w   '}' else_cond? ;

def_exp: ID COMP Digitos
	   | ID EQUAL Digitos
	   | ID EQUAL ('true'|'false')
	   ;	

else_cond: 'else' '{' def_w   '}'  ; 	



//Seccion While
def_while: 'loop' 'while' '(' ID COMP Digitos ')' '{' def_w (ID '+' | ID '-') ';' '}';


//Seccion Write/Read
def_w: 'output' 'write' '(' (Cadena|ID) ')' ';'
	  | 'input' ID '=' 'read' '(' ')' ';'
	  ;  

//Seccion CallFunction

call_funct: ID '=' ID '(' ID ')' ';' ;
		 


// Tokens léxicos	
ID: [a-zA-Z][a-zA-Z0-9]*;
Digitos: [0-9]+;
Cadena: '"' ( '\\"' | ~["\r\n] )* '"';
NEWLINE: [\r\n]+ -> skip;
BLANKSPACE: [ \t]+ -> skip;
COMP:('>'|'<'| '>=' |'<=');
EQUAL: ('=='|'!=');
