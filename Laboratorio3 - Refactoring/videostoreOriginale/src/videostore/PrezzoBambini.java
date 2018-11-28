package videostore;

public class PrezzoBambini extends Prezzo {

    @Override
    public int getCodice() {
        return Film.BAMBINI;
    }

    @Override
    public double getAmmontare(int giorniNoleggio) {
        double risultato = 0;
        risultato += 1.5;
        if (giorniNoleggio > 3)
            risultato += (giorniNoleggio - 3) * 1.5;
        return risultato;
    }
}
