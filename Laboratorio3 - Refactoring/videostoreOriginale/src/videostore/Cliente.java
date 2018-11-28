package videostore;
import java.util.*;

// 1.0
public class Cliente {
    
	private String _nome;
    private List<Noleggio> _noleggi = new ArrayList<Noleggio>();

    public Cliente (String nome) {
        _nome = nome;
    }

    public void addNoleggio(Noleggio arg) {
        _noleggi.add(arg);
    }
    
    public String getNome(){
        return _nome;
    }

    private double getAmmontare(Noleggio noleggio) {
        return noleggio.getAmmontare();
    }

    private double getAmmontareTotale(){
        double ammontareTotale = 0;
        Iterator<Noleggio> noleggi = _noleggi.iterator();

        while (noleggi.hasNext()) {
            Noleggio ognuno = (Noleggio) noleggi.next();
            ammontareTotale += getAmmontare(ognuno);
        }
        return ammontareTotale;
    }


    public String rendiconto() {
        String r = "Rendiconto noleggi per " + getNome() + " ";
        Iterator<Noleggio> noleggi = _noleggi.iterator();

        while (noleggi.hasNext()) {
            Noleggio ognuno = (Noleggio) noleggi.next();
            r += ognuno.getFilm().getTitolo() + " " +
                    String.valueOf(getAmmontare(ognuno)) + " ";
        }

        // aggiungi totale
        r += "L'ammontare dovuto e' " + String.valueOf(getAmmontareTotale());
        return r;
    }

}
