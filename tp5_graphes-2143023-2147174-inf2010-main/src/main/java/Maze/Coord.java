package Maze;

public class Coord {
    public int x;
    public int y;

    public Coord(int row, int col){
        this.x = row;
        this.y = col;
    }

    Coord direction(int i) {
        return switch (i) {
            case 0 -> new Coord(x + 1, y);
            case 1 -> new Coord(x - 1, y);
            case 2 -> new Coord(x, y + 1);
            case 3 -> new Coord(x, y - 1);
            default -> this;
        };
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
