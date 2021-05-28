import main.OlaMundo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class OlaMundoTeste
{
    private OlaMundo ola;

    @BeforeEach
    public void setup()
    {
        ola = new OlaMundo();
    }

    @Test
    public void testeOlaMundo()
    {
        Assertions.assertEquals(3, ola.metodo(2));
        //Assertions.assertEquals(4, ola.metodo(4));
    }
}
