

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.ManipuladorString;

public class TesteManipuladorString {
    ManipuladorString manipulador = new ManipuladorString();

  @Test
   public void testContarVogais() {

   
    String resut = manipulador.invertString("Hello World");
    assertEquals("dlroW olleH", resut);
}

}
