
package pda_et;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/*  Programa: PDA
    Equipo: 
        - Guzmán Cruz José Antonio
        - Bautista Sanchéz Georgina Elena
    Carrera: Ing. en Sistemas Computacionales
    Curso: Lenguajes y Automatas II
    Catedratico: Roberto Hernandez Peréz
    Fecha: 27 de febrero de 2022 
*/

public class PDA {
    
    static int pda = 0;     //-- variable de inicio esta Q0

    private ArrayList<Object> pila = new ArrayList();     //-- Se crea el objeto pila 
    
    

    public void palindromo(String cad) { // -- Valida si la cadena es un palindromo
        String cad1, rev = "";
        cad1 = cad.replaceAll("\\s+", "").toLowerCase();

        int length = cad1.length();

        for (int i = length - 1; i >= 0; i--)
            rev = rev + cad1.charAt(i);

        if (cad1.equals(rev))
            System.out.println("\nLa cadena <<" + cad + ">> es un palindromo");
        else
            System.out.println("\nLa cadena <<" + cad + ">> no es un palindromo");
    }

 
    public void push(Object o) { //-- agrega valor a lapila
        pila.add(o); 
    }

    public Object pop() { //-- muestra el ultimo valor y lo elimina
        if (!(pila.isEmpty())) {
            Object o = pila.get(pila.size() - 1);
            pila.remove(pila.size() - 1);
            return o;
        } else {
            return null;
        }
    }

    public Object peek() { //-- muestra el ultimo valor
        if (!(pila.isEmpty())) {
            return pila.get(pila.size() - 1);
        } else {
            return null;
        }
    }

    public Boolean empty() { //-- la pila esta llena o vacia
        return pila.isEmpty();
    }

    static PDA stc = new PDA();  //-- Llamada a metodos 
    
    static void Q0(char c) {   //-- Entrada estado Q0
        stc.push("#");
        if (c == 'a' && stc.peek() == "#"){
            stc.push("E");
            pda = 1;
        } else if (c == 'b' && stc.peek() == "#") {
            stc.push("T");
            pda = 2;
        }
    }

    static void Q1(char c) {   //-- Entrada estado Q1
        
        if (c == 'a'&& stc.peek() == "E") {
            stc.push("E");
            pda = 2;
        } else if (c == 'b' && stc.peek() == "E") {
            stc.pop();
            pda = 3;
        }
    }

    static void Q2(char c) {   //-- Entrada estado Q2
        if (c == 'a' && stc.peek() == "T") {
            stc.pop();
            pda = 3;
        } else if (c == 'b' && stc.peek() == "T") {
            stc.push("T");
            pda = 2;
        }
    }

    static void Q3(char c) {    //-- Entrada estado Q3
        if (c == 'a' && stc.peek() == "T") {
            stc.pop();
            pda = 3;
        } else if (c == 'b' && stc.peek() =="E") {
            stc.pop();
            pda = 3;
        }else if (c == ' ' && stc.peek() =="#") {
            stc.pop();
            pda = 3;
        }else {
            pda = -1; //-- en los otros estados es para rectificar si no hay malos datos en la cadena
        }
    }


    static int isAccepted(char str[]) {     //-- Valida si la cadena es aceptada
        
        for (int i = 0; i < str.length; i++) {
            if (pda == 0)
                Q0(str[i]);

            else if (pda == 1)
                Q1(str[i]);

            else if (pda == 2)
                Q2(str[i]);

            else if (pda == 3)
                Q3(str[i]);

            else
                return 0;
        }
        if (pda == 3)      //-- Señala estado final
            return 1;
        else
            return 0;
    }

    // Clase principal
    public static void main(String[] args) {

        System.out.println("\nPROGRAMA PDA\n");
        
        System.out.println("L = { w | w is a palindrome of a's and b's}\n");
        
        System.out.println("P = (Q,Σ,Γ,Sigma,q0,Z0,F)");
        System.out.println("Q = {Q0,Q1,Q2,Q3}\nΣ = {a,b}\nΓ = {E,T}\nSigma\nq0\nZ0 = {#}\nF = {Q3}");
        System.out.println("P = ({Q0,Q1,Q2,Q3},{a,b},{E,T},Sigma,{q0},Z0 = #,{Q3})\n");
        
        String cadena = JOptionPane.showInputDialog(null, "Dame la cadena");
        PDA pila = new PDA();
        pila.palindromo(cadena);
        
            char str[] = cadena.toCharArray();
            if (isAccepted(str) == 0)
                System.out.printf("La cadena <<" + cadena + ">> es válida\n");
            else
                System.out.printf("La cadena <<" + cadena + ">> no es válida | Intenta nuevamente\n");
            
        System.out.print("\nPila:"); 
            
        while (pila.empty() == false) {
            System.out.print("["+pila.pop()+"]\n");
        }
    }
}
