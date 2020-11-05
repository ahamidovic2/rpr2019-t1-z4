package ba.unsa.etf.rpr;

public class Supermarket {
    private Artikl[] artikli = new Artikl[1000];
    private int brojArtikla = 0;

    public boolean dodajArtikl(Artikl a) {
        if (brojArtikla < 50) {
            artikli[brojArtikla++] = new Artikl(a.getNaziv(), a.getCijena(), a.getKod());
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


}
