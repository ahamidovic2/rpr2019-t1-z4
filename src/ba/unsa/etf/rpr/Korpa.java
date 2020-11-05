package ba.unsa.etf.rpr;

public class Korpa {
    private Artikl[] artikli = new Artikl[50];
    private int brojArtikla = 0;

    public boolean dodajArtikl(Artikl artikl) {
        if (brojArtikla < 50) {
            artikli[brojArtikla++] = new Artikl(artikl.getNaziv(), artikl.getCijena(), artikl.getKod());
            return true;
        }
        return false;
    }

    public Artikl[] getArtikli() {
        return artikli;
    }

    public Artikl izbaciArtiklSaKodom(String kod) {
        for (int i = 0; i < brojArtikla; i++) {
            if (artikli[i].getKod() == kod) {
                Artikl noviArtikl = new Artikl(artikli[i].getNaziv(), artikli[i].getCijena(), artikli[i].getKod());
                artikli[i] = null;
                if (brojArtikla - i >= 0) System.arraycopy(artikli, i + 1, artikli, i, brojArtikla - i);
                artikli[brojArtikla] = null;
                brojArtikla--;

                return noviArtikl;
            }
        }
        return null;
    }

    public int dajUkupnuCijenuArtikala() {
        int cijena = 0;
        for (int i = 0; i < brojArtikla; i++) {
            cijena += artikli[i].getCijena();
        }
        return cijena;
    }

}