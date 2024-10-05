import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;




import org.junit.jupiter.api.Test;



import com.example.Calculadora;

public class TesteCalculadora {
    Calculadora calc = new Calculadora();

    //Criar os teste 
    @Test
    public void testeSoma(){
        double resultado = calc.soma(3, 8);
        assertEquals(11, resultado, 0);
    }

    @Test
    public void testeSubtrai(){
        double resultado = calc.subtrai(6, 12);
        assertEquals(-6, resultado, 0);
    }

    @Test
    public void testeMultiplica(){
        double resultado = calc.multiplica(6, 7);
        assertEquals(42, resultado, 0);
    }

    @Test
    public void testeDivisao(){
        double resultado = calc.divide(12, 6);
        assertEquals(2, resultado, 0);
    }

    @Test
    public void testeDivisaoZero(){
        assertThrows(IllegalArgumentException.class, ()-> calc.divide(10, 0));
    }
    
    }

