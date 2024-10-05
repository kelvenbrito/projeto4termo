

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.ManipuladorString;

public class TesteManipuladorString {
    ManipuladorString manipulador = new ManipuladorString();

  @Test
   public void testInverterFrase() {
    String resut = manipulador.invertString("Hello World");
    assertEquals("dlroW olleH", resut);
}

@Test
public void testContarVogais() {
 int resut = manipulador.contarPalavras("Hello World");
 assertEquals(2, resut);
}

}
