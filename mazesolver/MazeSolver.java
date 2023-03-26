/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mazesolver;

import arrayqueue.ArrayQueue;
import java.util.Scanner;

/**
 *
 * @author micahvranyes
 * Date: 3/22/2023
 * Description: The MazeSolver class parses the input
 * of map dimensions and a map, finds the shortest path
 * between the start and target, and prints the path.
 * 
 */
public class MazeSolver {
    private static int numRows;
    private static int numCols;
    private static LNode temp;
    private static LNode[][] map;
    private static ArrayQueue queue;
    /**
     * 
     * Description: The main method accomplishes the purpose of
     * the class (parse, solve, print) through the utilization of 
     * its private methods and the use of LNode data structure.
     * @param args
     * 
     */
    public static void main(String[] args) {
        //Parse Data
        MazeSolver.parseData();
        
        //Solve maze
        int y;
        int x;
        while(!queue.isEmpty() && !temp.isTarget()) {
            temp = (LNode) queue.dequeue();
            x = temp.getXLoc();
            y = temp.getYLoc();
            
            MazeSolver.addEdge(y, x-1);
            MazeSolver.addEdge(y, x+1);
            MazeSolver.addEdge(y-1, x);
            MazeSolver.addEdge(y+1, x);
        }
        if(!temp.isTarget()) {
            System.out.println("Maze not solvable.");
            return;
        }
        
        //Print results
        temp.printPath();
    }
    /**
     * Description: addEdge intakes a potential positions for
     * an LNode and checks if it's position is valid, if it hasn't
     * been visited, and if it isn't a wall. If it passes these tests
     * it adds the LNode to the queue and visits it.
     * @param y
     * @param x 
     */
    private static void addEdge(int y, int x){
        if(x >= 0 && x < numCols && y >= 0 && y < numRows && !map[y][x].visited()) {
            if(!map[y][x].isWall()) {
                queue.enqueue(map[y][x]);
                map[y][x].vist(temp);
            }
        }   
    }
    
    /**
     * Description: In takes map dimensions then the
     * map and stores it in a 2D array. It also 
     * stores the location of the starting position
     * in the temp variable. 
     */
    private static void parseData() {
        Scanner s = new Scanner(System.in);
        String[] dimensions = s.nextLine().split(" ");
        numRows = Integer.parseInt(dimensions[0]);
        numCols = Integer.parseInt(dimensions[1]);
        
        temp = new LNode("Invalid Node", new int[]{0,0});
        queue = new ArrayQueue(numRows * 2);
        String[] row;
        map = new LNode[numRows] [numCols];
        for(int i = 0; i  < numRows; i++) {//Building 2D array
            row = s.nextLine().split("");
            for(int z = 0; z < numCols; z++) {
                map[i][z] = new LNode(row[z],new int[]{i,z});//Adds an LNode to the 2D array
                if(map[i][z].isStart()) {
                    queue.enqueue(new LNode("S",new int[]{i,z}));//Add start to the queue
                }
            }
        }
    }
}

