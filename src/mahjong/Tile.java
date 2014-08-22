package mahjong;

import java.util.Objects;

/**
 * Tile in Mahjong Game. If it has suit(s,m,p), it will also has number.
 * Otherwise it will only has type.
 *
 * @author jeky
 */
public class Tile implements Comparable<Tile> {

    public Tile(int num, Type suit) {
        this.num = num;
        this.type = suit;
    }

    public Tile(Type suit) {
        this(0, suit);
    }

    public int getNum() {
        return num;
    }

    public Type getType() {
        return type;
    }

    public static enum Type {

        Bamboo("s"), Char("m"), Dot("p"), East("E"), South("S"), West("W"), North("N"), Red("C"), Green("F"), White("P");

        private Type(String shorten) {
            this.shorten = shorten;
        }

        @Override
        public String toString() {
            return this.shorten;
        }

        private final String shorten;
    }

    @Override
    public int compareTo(Tile t) {
        if (this.type == t.type) {
            return this.num - t.num;
        } else {
            return Helper.indexOf(Type.values(), this.type) - Helper.indexOf(Type.values(), t.type);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.num;
        hash = 59 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tile other = (Tile) obj;
        if (this.num != other.num) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (num == 0) {
            return "" + type;
        } else {
            return "" + num + type;
        }
    }
    private final int num;
    private final Type type;
}
