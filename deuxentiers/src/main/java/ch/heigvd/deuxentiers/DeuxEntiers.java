package ch.heigvd.deuxentiers;

public class DeuxEntiers {
    private int entier1;
    private int entier2;

    public DeuxEntiers(int i, int j) {
        entier1 = i;
        entier2 = j;
    }

    public int divise() {
        return (entier1 / entier2);
    }

    public int modulo() {
        return (entier1 % entier2);
    }
}
