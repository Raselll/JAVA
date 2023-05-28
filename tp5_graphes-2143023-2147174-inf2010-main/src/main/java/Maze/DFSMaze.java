package Maze;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/** TODO
 ** Implement DFS algorithm to solve the maze.
 */
public class DFSMaze {

    private static Counter counter = new Counter();

    private static ArrayList<Coord> stack;

    private static class Wrapper {
        private int val;

        Wrapper(int x){
            this.val = x;
        }
    }

    private static void dfs(ArrayList<ArrayList<Tile>> maze, Node currentNode, boolean[][] visited, int ROWS, int COLS, Wrapper wrapper, Counter counter) {
        visited[currentNode.coord.x][currentNode.coord.y] = true;
        counter.totalNodesTraversed++;

        if (counter.maxStackSize < counter.stackedNodes) {
            counter.maxStackSize = counter.stackedNodes;
        }

        for (int i = 0; i < 4; i++) {
            Coord neighbourCoord = currentNode.coord.direction(i);
            int neighbourRow = neighbourCoord.x;
            int neighbourCol = neighbourCoord.y;
            if (neighbourRow >= 0 && neighbourRow < ROWS && neighbourCol >= 0 && neighbourCol < COLS && maze.get(neighbourRow).get(neighbourCol) != Tile.Wall && !visited[neighbourRow][neighbourCol]) {
                if (maze.get(neighbourRow).get(neighbourCol) == Tile.Exit) {
                    wrapper.val = currentNode.distance + 1;
                    return;
                } else {
                    counter.stackedNodes++;
                    dfs(maze, new Node(neighbourCoord, currentNode.distance + 1), visited, ROWS, COLS, wrapper, counter);
                    counter.stackedNodes--;
                }
            }
        }
    }

    /** TODO
     * Returns the distance of the path within the maze
     * @param maze 2D table representing the maze
     * @return Distance of the path within the maze, null if not solvable
     */
    public static Integer findPath(ArrayList<ArrayList<Tile>> maze) {
        if (maze.isEmpty()){
            return null;
        }

        Counter counter = new Counter();
        Wrapper wrapper = new Wrapper(0);

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

        dfs(maze, new Node(startPos, 0), visited, ROWS, COLS, wrapper, counter);

        System.out.println("totalNodesTraversed : " + counter.totalNodesTraversed);
        System.out.println("maxStackSize : " + counter.maxStackSize);
        return wrapper.val;
    }

    public static void printMaze(ArrayList<ArrayList<Tile>> maze) {
        for (ArrayList<Tile> row : maze) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining("")));
        }
    }
}

