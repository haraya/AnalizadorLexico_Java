

package analizadorlexico;

import java.util.regex.*;
import java.util.*;

/**
 * @author Hernan Araya
 */
public class PracticaAnalizadorLexico {
    public static void main(String[] args) {
        
        String codigo = "String nombre = 'Hernan';";
        
       String[] sourceCodeLines = codigo.split("\\s+");
       
       /*for(String s:sourceCodeLines)
       {
        System.out.println(s);
       }*/
        
     
    }
    
    
    //Metodo para analizar el codigo 
    public static List<clsToken> analizar(String codigo)
    {
        List<clsToken> tokens = new ArrayList<>();
        
        
        
        
        
        
        //retornamos la lista de los tokens
        return tokens;
    }
    
    
    
    
    
    
    
}


//enum token donde pondremos las palabras claves o tokens
enum Token_type
{
    IDENTIFIER,
    INTEGER, 
    STRING,
    OPERATOR,
    DELIMITER 
}

class clsToken
{   //variables para el tipo y el valor de los tokens
    private Token_type type;
    private String value;
    
    //constructor donde paso los tokens
    public clsToken(Token_type type, String value)
    {
        this.type = type;
        this.value = value;
    }
    
    @Override
    public String toString()
    {
        return "Type = "+type+", "
             + "Value = "+value;
    }
    
    
    
}
