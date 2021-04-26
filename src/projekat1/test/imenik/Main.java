public class Main {

    public static void main(String[] args) {
        Imenik imenik = new Imenik();

        // imenik.dodaj(new Osoba("1","Tomas","Cicak"));
        // imenik.dodaj(new Osoba("5","Milica","Rasuo"));
        // imenik.dodaj(new Osoba("2","Stevan","Djakovic"));
        // imenik.dodaj(new Osoba("4","Tomas","Lazic"));
        // imenik.dodaj(new Osoba("3","Ahmed","Nurudin"));

        imenik.loadFromFile("imenik.dat");

        imenik.list();

        //imenik.nadjiPoImenu("Tomas");

        imenik.saveToFile("imenik.dat");
    }

}
