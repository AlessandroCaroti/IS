package videostore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    public void test1(){
        Cliente c = new Cliente("nome");
        assertNotNull(c);
    }

}