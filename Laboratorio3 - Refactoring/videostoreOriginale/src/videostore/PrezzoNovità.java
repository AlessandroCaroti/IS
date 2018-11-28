package videostore;

public class PrezzoNovità extends Prezzo {

    @Override
    public int getCodice() {
        return Film.NOVITA;
    }

    @Override
    public double getAmmontare(int giorniNoleggio) {
        return giorniNoleggio * 3;
    }
}
