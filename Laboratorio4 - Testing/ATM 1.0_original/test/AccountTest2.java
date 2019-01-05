import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

class AccountTest2 {

    private Account account;
    private int accountNumber; // account number
    private int pin;
    private Euro availableBalance; // funds available for withdrawal
    private Euro totalBalance; // funds available + pending deposits
    private final int RANDBOUND=30000;

    @BeforeEach
    private void init(){
        Random rand=new Random();
        this.accountNumber=rand.nextInt(RANDBOUND);
        this.pin=rand.nextInt(RANDBOUND);
        this.availableBalance=new Euro(rand.nextInt(RANDBOUND));
        this.totalBalance=new Euro(rand.nextInt(RANDBOUND));
        this.account=new Account(accountNumber,pin,availableBalance,totalBalance);
    }

    @Test
    void validatePIN() {
        assertTrue(account.validatePIN(pin));

    }

    @Test
    void getAvailableBalance(){
        assertEquals(account.getAvailableBalance().getValore(),availableBalance.getValore());

    }

    @Test
    void getTotalBalance() {
        assertEquals(totalBalance.getValore(),account.getTotalBalance().getValore());

    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, 0.50, 500.0, 120.23,-100.0})
    void credit(double toAdd) {
        Euro eurToAdd=new Euro(toAdd);
        account.credit(eurToAdd);
        assertEquals(totalBalance.somma(eurToAdd).getValore(),account.getTotalBalance().getValore());

    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, 0.50, 500.0, 120.23,-100.0})
    void debit(double toDebit) {
        Euro eur=new Euro(toDebit);
        account.debit(eur);
        totalBalance.sottrai(eur);
        availableBalance.sottrai(eur);
        assertEquals(account.getAvailableBalance().getValore(),availableBalance.getValore());
        assertEquals(account.getTotalBalance().getValore(),totalBalance.getValore());

    }

    @Test
    void getAccountNumber() {
        assertEquals(accountNumber,account.getAccountNumber());
    }




}