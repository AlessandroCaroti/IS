import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class BankDatabaseTest {

    BankDatabase dbBank;

    @BeforeEach
    void init(){
        dbBank = new BankDatabase();
    }

    @Test
    void getAvailableBalance(){
        assertEquals(dbBank.getAvailableBalance(12345).getValore(),100000);
        assertEquals(dbBank.getAvailableBalance(98765).getValore(), 20000);
    }

    @Test
    void getTotalBalance(){
        assertEquals(dbBank.getTotalBalance(12345).getValore(),120000);
        assertEquals(dbBank.getTotalBalance(98765).getValore(), 20000);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, 0.50, 500.0, 120.23,-100.5})
    void credit(double toCredit){
        Euro eur=new Euro(toCredit);
        Euro initVal = dbBank.getAvailableBalance(12345);
        dbBank.credit(12345,eur);
        assertEquals(dbBank.getAvailableBalance(12345), initVal.somma(eur));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, 0.50, 500.0, 120.23,-100.5})
    void debit(double toDebit){
        Euro eur=new Euro(toDebit);
        Euro initVal = dbBank.getAvailableBalance(12345);
        dbBank.debit(12345,eur);
        assertEquals(dbBank.getAvailableBalance(12345), initVal.sottrai(eur));
    }


}
