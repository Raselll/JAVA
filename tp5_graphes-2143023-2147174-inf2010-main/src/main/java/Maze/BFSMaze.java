package Maze;
import java.util.*;
import java.util.stream.Collectors;

/** TODO
 ** Implement BFS algorithm to solve the maze.
 */

public class BFSMaze
{
    /**
     * TODO
     * Returns the distance of the shortest path within the maze
     * @param maze 2D table representing the maze
     * @return Distance of the shortest path within the maze, null if not solvable
     */

    public static Integer findPath(ArrayList<ArrayList<Tile>> maze)
    {
        if (maze.isEmpty()){
            return null;
        }

        Counter counter = new Counter();

        int ROWS = maze.size();
        int COLS = maze.get(0).size();

        ArrayList<Coord> startExitPos = new ArrayList<>();
        for (int i = 0; i < ROWS; i++){
            for (int j = 0; j < COLS; j++){
                if (maze.get(i).get(j) == Tile.Exit){
                    startExitPos.add(new Coord(i,j));
                }
            }
        }

        Coord startPos = startExitPos.get(0);
        boolean[][] visited = new boolean[ROWS][COLS];
        visited[startPos.x][startPos.y] = true;

        counter.totalNodesTraversed++;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(startPos, 0));

        counter.stackedNodes++;

        while (queue.size() != 0){
            if (counter.maxStackSize < counter.stackedNodes) {
                counter.maxStackSize = counter.stackedNodes;
            }

            Node currentNode = queue.poll();

            counter.stackedNodes--;

            Coord currentNodeCoord = currentNode.coord;

            System.out.println("(" + currentNodeCoord.getX() + "," + currentNodeCoord.getY() + ")");

            for (int i = 0; i < 4; i++){
                Coord neighbourCoord = currentNodeCoord.direction(i);
                int neighbourRow = neighbourCoord.x;
                int neighbourCol = neighbourCoord.y;

                if (neighbourRow >= 0 && neighbourRow < ROWS && neighbourCol >= 0 && neighbourCol < COLS && maze.get(neighbourRow).get(neighbourCol) != Tile.Wall && !visited[neighbourRow][neighbourCol]) {
                    if (maze.get(neighbourRow).get(neighbourCol) == Tile.Exit) {
                        counter.totalNodesTraversed++;
                        System.out.println("totalNodesTraversed : " + counter.totalNodesTraversed);
                        System.out.println("maxStackSize : " + counter.maxStackSize);
                        return currentNode.distance + 1;
                    }
                    else {
                      visited[neighbourRow][neighbourCol] = true;
                      counter.totalNodesTraversed++;
                      queue.add(new Node(neighbourCoord, currentNode.distance + 1));
                      counter.stackedNodes++;
                    }
                }
            }
        }
        return null;
    }

    public static void printMaze(ArrayList<ArrayList<Tile>> maze)
    {
        for (ArrayList<Tile> row : maze) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining("")));
        }
    }
}


