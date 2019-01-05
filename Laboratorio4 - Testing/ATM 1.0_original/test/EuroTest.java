import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EuroTest {
    private Euro e1;
    private final double _e1 = 0.0;

    private Euro e2;
    private final double _e2 = 12345.21;

    private Euro e3;
    private final double _e3 = 42.0;

    private Euro e;
    private final double _e = 50000.50;

    @BeforeEach
    void init(){
        e = new Euro(_e);
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

    @ParameterizedTest
    @ValueSource(doubles = {0.0, 0.50, 500.0, 120.23})
    void somme(double valToAdd){
        double initVal        = centToEuro(e.getValore());
        long  expectedResult = euroToCent(initVal + valToAdd);

        e.somma(new Euro(valToAdd));

        assertEquals(e.getValore(), expectedResult);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, 0.50, 500.0, 120.23})
    void sottrai(double valToAdd){
        double initVal        = centToEuro(e.getValore());
        long   expectedResult = euroToCent(initVal - valToAdd);

        e.sottrai(new Euro(valToAdd));

        assertEquals(e.getValore(), expectedResult);
    }

    @Test
    void ugualeA() {
        assertTrue(e1.ugualeA(new Euro(_e1)));
        assertTrue(e2.ugualeA(new Euro(_e2)));
        assertTrue(e3.ugualeA(new Euro(_e3)));

        assertFalse(e1.ugualeA(e2));
        assertFalse(e1.ugualeA(e3));
        assertFalse(e3.ugualeA(e1));
    }

    @Test
    void minoreDi() {
        assertTrue(e1.minoreDi(e2));

        assertTrue(e3.minoreDi(e2));

    }

    @Test
    void stampa() {
        assertEquals(e1.stampa(),"0.0 euro");
        assertEquals(e2.stampa(),"12345.21 euro");
        assertEquals(e3.stampa(),"42.0 euro");
    }


    private double centToEuro(long cent){
        return (double) cent/100;
    }

    private long euroToCent(double euro){
        return (long) (euro*100);
    }
}