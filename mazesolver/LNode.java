/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

/**
 *
 * @author micahvranyes
 * Date: 3/22/23
 * Description: The LNode or Location Node class
 * serves to navigate data structures.
 * 
 */
public class LNode {
    private int location[];
    private char type;
    private int distance;
    private boolean visited;
    private LNode previous;
    
    public LNode(String t, int[] loc) {
        type = t.charAt(0);
        location = loc;
        distance = 0;
        visited = false;
    }
    
    /**
     * Description: Returns if the LNode has been visited.
     * @return ifVisited
     */
    public boolean visited() {
        return visited;
    }
    
    /**
     * Description: performs all the operations for
     * visiting a LNode (updated visited status,
     * link previous LNode, set distance).
     * @param prev 
     */
    public void vist(LNode prev) {
        visited = true;
        previous = prev;
        distance = prev.distance + 1;
    }
    
    /**
     * Description: returns if the type is a open space.
     * @return type
     */
    public boolean isOpen() {
        return type == '.';
    }
    
    /**
     * Description: returns if the type is a wall.
     * @return type
     */
    public boolean isWall() {
        return type == 'X';
    }
    
    /**
     * Description: returns if the type is target.
     * @return type
     */
    public boolean isTarget() {
        return type == 'T';
    }
    
    /**
     * Description: returns if the type is start.
     * @return type
     */
    public boolean isStart() {
        return type == 'S';
    }
    
    /**
     * Description: returns the y coordinate part of the location.
     * @return y 
     */
    public int getYLoc() {
        return location[0];
    }
    
    /**
     * Description: returns the x coordinate part of the location.
     * @return x 
     */
    public int getXLoc() {
        return location[1];
    }
    /**
     * Description: printPath recursively prints the
     * LNode locations starting from the start position. 
     */
    public void printPath() {
        if(previous != null) {
            previous.printPath();
        }
        System.out.println("<" + location[0] + " " + location[1] + ">");
        if(type == 'T') {
            System.out.println("Total distance = " + distance);
        }
    }
}
