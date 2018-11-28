package videostore;

// 1.0
public class Film {

	public static final int BAMBINI = 2;
    public static final int REGOLARE = 0;
    public static final int NOVITA = 1;
    
    private String _titolo;
    private Prezzo _prezzo;



    public Film(String titolo, int codicePrezzo) {
        _titolo = titolo;
        setCodicePrezzo(codicePrezzo);
    }

    public int getCodicePrezzo() {
        return _prezzo.getCodice();
    }

    public void setCodicePrezzo(int arg) {
        switch (arg){
            case BAMBINI:
                _prezzo = new PrezzoBambini();
                break;
            case REGOLARE:
                _prezzo = new PrezzoRegolare();
                break;
            case NOVITA:
                _prezzo = new PrezzoNovità();
                break;
        }
    }

    public String getTitolo() {
        return _titolo;
    }

    public double getAmmontare(int giorniNoleggio)
    {
        return  _prezzo.getAmmontare(giorniNoleggio);
    }
}
