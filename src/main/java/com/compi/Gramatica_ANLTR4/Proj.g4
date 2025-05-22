grammar Proj;

@header{
    package com.compi.Gramatica_ANLTR4;
}

// Main program structure
prog: 'Program' header segvar segfunct 'BEGIN' body_program body_end 'END' EOF;

header: 'NAME' ID ';';

body_end: 'FINITO' ';';

// Variable section
segvar: 'VARIABLE' ':' (defvar (';' defvar)* ';')?;

defvar: 'int' ID '=' Digitos 
      | 'float' ID '=' Digitos '.' Digitos 
      | 'string' ID '=' Cadena 
      | 'bool' ID '=' ('true'|'false')
      ;

// Function section
segfunct: 'FUNCTION' ':' (deffunct)*;

deffunct: 'function' ID '(' ID ')' '{' bodyfunct '}';

bodyfunct: (defarith ';')* 'RETURN' ID ';';

// Arithmetic expressions
defarith: bodysegE;

bodysegE: bodysegT bodysegE2;

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

// Main program body
body_program: (def_cond 
              | def_while 
              | def_w 
              | call_funct
              | assignment)*;

// Assignment statement
assignment: ID '=' (bodysegE | Cadena | 'true' | 'false') ';';

// Conditional section
def_cond: 'cond' 'if' '(' def_exp ')' '{' def_w '}' else_cond?;

def_exp: ID COMP Digitos
       | ID EQUAL Digitos
       | ID EQUAL ('true'|'false')
       ;

else_cond: 'else' '{' def_w '}';

// While loop section - FIXED to properly capture increment/decrement
def_while: 'loop' 'while' '(' def_exp ')' '{' (def_w)* increment_decrement '}';

increment_decrement: ID ('+' | '-') ';';

// Write/Read section
def_w: 'output' 'write' '(' (Cadena | ID) ')' ';'
     | 'input' ID '=' 'read' '(' ')' ';'
     ;

// Function call
call_funct: ID '=' ID '(' ID ')' ';';

// Lexical tokens
ID: [a-zA-Z][a-zA-Z0-9]*;
Digitos: [0-9]+;
Cadena: '"' ( '\\"' | ~["\r\n] )* '"';
NEWLINE: [\r\n]+ -> skip;
BLANKSPACE: [ \t]+ -> skip;
COMP: ('>' | '<' | '>=' | '<=');
EQUAL: ('==' | '!=');

// Comments (optional)
COMMENT: '//' ~[\r\n]* -> skip;
BLOCK_COMMENT: '/*' .*? '*/' -> skip;