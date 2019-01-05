import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Random;

@RunWith(Parameterized.class)
class AccountTest2 {

    private Account account;
    private int accountNumber; // account number
    private int pin;
    private Euro availableBalance; // funds available for withdrawal
    private Euro totalBalance; // funds available + pending deposits
    private final int RANDBOUND=30000;

    //@Parameterized.Parameters
    //public static

    private void init(){
        Random rand=new Random();
        this.accountNumber=rand.nextInt(RANDBOUND);
        this.pin=rand.nextInt(RANDBOUND);
        this.availableBalance=,new Euro(rand.nextInt(RANDBOUND));
        this.totalBalance=,new Euro(rand.nextInt(RANDBOUND));
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

    void credit() {
        //assertEquals(totalBalance.somma());

    }

    @Test
    void debit() {
    }

    @Test
    void getAccountNumber() {
        assertEquals(accountNumber,account.getAccountNumber());
    }




}