// ======================================================================
// Klasa:
// Autor: Milovan Tomašević, e11988
// Datum:
// Opis:
// ======================================================================

package biblioteka;


public class Main {

    public static void main(String[] args) {
        Biblioteka.getInstanca().clanovi.put(1, new Clan(1,"Tomas","Cicak"));
        Biblioteka.getInstanca().clanovi.put(4, new Clan(4,"Milica","Rasuo"));
        Biblioteka.getInstanca().clanovi.put(3, new Clan(3,"Ahmed","Nurudin"));
        Biblioteka.getInstanca().clanovi.put(2, new Clan(2,"Bojan","Antic"));

        Biblioteka.getInstanca().knjige.put(3, new Knjiga(3, "Knjiga3","Autor3"));
        Biblioteka.getInstanca().knjige.put(4, new Knjiga(4, "Knjiga4","Autor4"));
        Biblioteka.getInstanca().knjige.put(2, new Knjiga(2, "Knjiga2","Autor2"));
        Biblioteka.getInstanca().knjige.put(1, new Knjiga(1, "Knjiga1","Autor1"));

        Zaduzenje z1 = new Zaduzenje(1, Biblioteka.getInstanca().clanovi.get(3), Biblioteka.getInstanca().knjige.get(2));
        Biblioteka.getInstanca().unesiZaduzenje(z1);

        Zaduzenje z2 = new Zaduzenje(2, Biblioteka.getInstanca().clanovi.get(2), Biblioteka.getInstanca().knjige.get(1));
        Biblioteka.getInstanca().unesiZaduzenje(z2);

        //Biblioteka.getInstanca().zaduzenja.put(1, new Zaduzenje(1, Biblioteka.getInstanca().clanovi.get(3), Biblioteka.getInstanca().knjige.get(2)));
        //Biblioteka.getInstanca().zaduzenja.put(2, new Zaduzenje(1, Biblioteka.getInstanca().clanovi.get(2), Biblioteka.getInstanca().knjige.get(1)));
        //Biblioteka.getInstanca().zaduzenja.put(3, new Zaduzenje(1, Biblioteka.getInstanca().clanovi.get(1), Biblioteka.getInstanca().knjige.get(4)));

        Biblioteka.getInstanca().saveToFile();
        //Biblioteka.getInstanca().loadFromFile();
    }
}
