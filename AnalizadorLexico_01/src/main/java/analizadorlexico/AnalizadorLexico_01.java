

package analizadorlexico;

//01-Importamos las librerias
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

/**
 *
 * @author Hernan Araya
 */
public class AnalizadorLexico_01 {

    public static void main(String[] args) {
        // estructura de codigo
        String sourceCode = "x = 10 + y * 5;";
        
        //lista de tokens 
        List<Token> tokens = analyze(sourceCode);

        for (Token token : tokens) {
            System.out.println(token);
        }
    }
    
    
    // 04-metodo que analizara nuestro codigo, metodo que retorna una lista de tokens
     public static List<Token> analyze(String sourceCode) {
        //crear una lista de valor tokens, e igual arraylist
         List<Token> tokens = new ArrayList<>();
         
         // Dividir la línea en palabras
        String[] sourceCodeLines = sourceCode.split("\\s+");

        // Definir patrones para identificadores, números y operadores
        Pattern identifierPattern = Pattern.compile("[a-zA-Z][a-zA-Z0-9]*");
        Pattern integerPattern = Pattern.compile("\\d+");
        Pattern operatorPattern = Pattern.compile("[+\\-*/=]");

        //for each para iterar el arreglo de string sourceCodeLines
      
           
          
            
            //itera las palabras y usa el modulo matcher 
            for (String word : sourceCodeLines) {
                Matcher identifierMatcher = identifierPattern.matcher(word);
                Matcher integerMatcher = integerPattern.matcher(word);
                Matcher operatorMatcher = operatorPattern.matcher(word);

                //Verifica los match con las palabras
                if (identifierMatcher.matches()) {
                    
                    // si coinciden, entonces se agregan a la lista
                    tokens.add(new Token(TokenType.IDENTIFIER, word));
                } else if (integerMatcher.matches()) {
                    tokens.add(new Token(TokenType.INTEGER, word));
                } else if (operatorMatcher.matches()) {
                    tokens.add(new Token(TokenType.OPERATOR, word));
                }
            }
        

        //se retorna una lista con los tokens 
        return tokens;
    }
    
    
    
}



// 02- enum nombre y agregamos los tokens que luego se van a evaluar
enum TokenType {
    IDENTIFIER,
    INTEGER,
    OPERATOR 
}

//03-Clase donde el tipo de token y el valor de ese token
class Token {
    private TokenType type;
    private String value;

    //constructor token
    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override // sobre escribirpara mostrar los tokens y su valor
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}