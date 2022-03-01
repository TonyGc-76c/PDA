# PROGRAMA PDA 

// --  Un PDA o Autómata de Pila es en su forma base un e-NFA con un stack (pila).
 
/*
 
 * Definición formal del lenguaje:
 *
 *   L = { w | w is a palindrome of a's and b's
 *
 * Definición formal del PDA:
 * 
 *   P = (Q,Σ,Γ,Sigma,q0,Z0,F) 
 *   Q = {Q0,Q1,Q2,Q3} 
 *   Σ = {a,b} Γ = {E,T} 
 *   δ = Función de transición 
 *   q0 = Estado inicial
 *   Z0 = {#} 
 *   F = {Q3}
 * 
 *   P = ({Q0,Q1,Q2,Q3},{a,b},{E,T},Sigma,{q0},Z0 = #,{Q3})
 * 
 * Descripción:
 * 
 *   El programa reconoce una cadena que se ingresa por medio del teclado, mostrando si tal cadena es un palindromo o no lo es, 
 *   valida si la cadena es aceptada o no lo es al entrar al PDA. 
 
*/
