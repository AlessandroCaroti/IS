import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;


class EuroTest {

    private Euro e1;
    private final double _e1 = 0.0;

    private Euro e2;
    private final double _e2 = 12345.21;

    private Euro e3;
    private final double _e3 = 42.0;

    @BeforeEach
    void init(){
        e1 = new Euro(_e1);
        e2 = new Euro(_e2);
        e3 = new Euro(_e3);
    }

    @Test
    void getValore() {
        assertEquals(e1.getValore(), 0L);
        assertEquals(e2.getValore(), 1234521L);
        assertEquals(e3.getValore(), 4200L);
    }

    @Test
    void somma() {
        e1.somma(e2);
        assertEquals(e1.getValore(),e2.getValore());

        e1.somma(e3);
        assertEquals(e1.getValore(), e2.getValore()+e3.getValore());

    }

    @Test
    void sottrai() {

    }

    @Test
    void ugualeA() {

    }

    @Test
    void minoreDi() {

    }

    @Test
    void stampa() {
        assertEquals(e1.stampa(),"0.0 euro");
        assertEquals(e2.stampa(),"12345.21 euro");
        assertEquals(e3.stampa(),"42.0 euro");
    }
}