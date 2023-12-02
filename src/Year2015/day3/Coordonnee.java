package Year2015.day3;

public class Coordonnee {

    private final int x;
    private final int y;

    public Coordonnee(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        return x == ((Coordonnee)obj).x && y == ((Coordonnee)obj).y;
    }
}
