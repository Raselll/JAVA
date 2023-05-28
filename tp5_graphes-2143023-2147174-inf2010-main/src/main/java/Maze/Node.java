package Maze;

public class Node {
    public Coord coord;
    public int distance;

    Node(Coord coord, int distance){
        this.coord = coord;
        this.distance = distance;
    }
}
