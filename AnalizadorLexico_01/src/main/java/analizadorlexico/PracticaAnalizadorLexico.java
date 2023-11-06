

package analizadorlexico;

import java.util.regex.*;
import java.util.*;

/**
 * @author Hernan Araya
 */
public class PracticaAnalizadorLexico {
    public static void main(String[] args) {
        
       String codigo = "int edad = 25;";
        
       List<clsToken> tokens = analizar(codigo);
        
        for(clsToken e : tokens)
        {
            System.out.println(e);
        }
        
       /* String[] saltoLinea = codigo.split("\n");
        System.out.println(saltoLinea[0]);
        String[] palabra = null;
        for(String sl: saltoLinea)
        {
            palabra = sl.split("\\s+");

        }
        
        
         for(String pa: palabra)
        {
            System.out.println(pa);

        }*/
       
    }
    
    
    public static List<clsToken> analizar(String codigo)
    {
        List<clsToken>tokens = new ArrayList<>();
        
        
         // Definir patrones para identificadores, números, operadores y el símbolo ';'
        Pattern identifierPattern = Pattern.compile("[a-zA-Z][a-zA-Z0-9_]*");
        Pattern integerPattern = Pattern.compile("\\d+");
        Pattern operatorPattern = Pattern.compile("[+\\-*/=]");
        Pattern semicolonPattern = Pattern.compile(";");
        
        String[] codigolineas = codigo.split("\n");
        
        for (String line : codigolineas) {
            String[] words = line.split("\\s+"); // Dividir la línea en palabras

            for (String word : words) {
                Matcher identifierMatcher = identifierPattern.matcher(word);
                Matcher integerMatcher = integerPattern.matcher(word);
                Matcher operatorMatcher = operatorPattern.matcher(word);
                Matcher semicolonMatcher = semicolonPattern.matcher(word);

                if (identifierMatcher.matches()) {
                    tokens.add(new clsToken(Token_type.IDENTIFIER, word));
                } else if (integerMatcher.matches()) {
                    tokens.add(new clsToken(Token_type.INTEGER, word));
                } else if (operatorMatcher.matches()) {
                    tokens.add(new clsToken(Token_type.OPERATOR, word));
                } else if (semicolonMatcher.matches()) {
                    tokens.add(new clsToken(Token_type.DELIMITER, word));
                }
            }
        }
        
        
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
        return "Token{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
    
    
    
}
