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
        assertEquals(dbBank.getAvailableBalance(1), new Euro(1000.0));
        assertEquals(dbBank.getAvailableBalance(2), new Euro(200.0));

    }

    @Test
    void getTotalBalance(){
        assertEquals(dbBank.getTotalBalance(1), new Euro(1200.0));
        assertEquals(dbBank.getTotalBalance(2), new Euro(200.0));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, 0.50, 500.0, 120.23})
    void credit(double toCredit){
        Euro eur=new Euro(toCredit);
        Euro initVal = dbBank.getAvailableBalance(12345);
        dbBank.credit(12345,eur);
        assertEquals(dbBank.getAvailableBalance(12345), initVal.somma(eur));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, 0.50, 500.0, 120.23})
    void debit(double toDebit){
        Euro eur=new Euro(toDebit);
        Euro initVal = dbBank.getAvailableBalance(12345);
        dbBank.debit(12345,eur);
        assertEquals(dbBank.getAvailableBalance(12345), initVal.sottrai(eur));
    }


}
