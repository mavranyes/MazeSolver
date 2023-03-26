/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package arrayqueue;

/**
 *
 * @author micahvranyes
 * Created: Feb 24, 2023
 * Description: This class implements a queue
 * using an array, providing all the standard methods
 * for reading and manipulation of the queue.
 * @param <E>
 * 
 */
public class ArrayQueue <E> implements Queue {
    
    private int queueSize = 0;
    private int fntIndex = 0;
    private E[] queue;
    
    /**
     * 
     * Description: Instantiates an array with size 10
     * 
     */
    public ArrayQueue() {
        this(10);  
    }
    
    /**
     * 
     * @param length
     * Description: Instantiates an array with size length
     * 
     */
    public ArrayQueue(int length) {
        queue = (E[]) new Object[length];   
    }
    
    /**
     * 
     * @return Object
     * Description: This method return the item at
     * the front of the queue but DOESN't remove it.
     * 
     */
    @Override
    public Object front() throws QueueEmptyException {
        if(!this.isEmpty()) {
            return (E) queue[fntIndex];
        }
        else {
            throw new QueueEmptyException("Error: queue is empty!");
        }
    }
    
    /***
     * 
     * @return queueSize
     * Description: This method return the
     * size of the queue
     * 
     */
    @Override
    public int size() {
        return queueSize;
    }
    
    /**
     * 
     * @return boolean
     * Description: This method returns true
     * if the array queue is empty but returns
     * false if it contains anything.
     * 
     */
    @Override
    public boolean isEmpty() {
        return queueSize == 0;
    }
    
    /**
     * 
     * @param obj
     * @throws InvalidDataException 
     * Description: This method intakes a user object
     * and adds it to the queue, updating the queue size.
     */
    @Override
    public void enqueue(Object obj) throws InvalidDataException {
        if(!(obj == null)) {
            if(queueSize == queue.length) {
                resizeArray(queue.length * 2);
            }
            queue[(queueSize + fntIndex) % queue.length] = (E) obj;
            queueSize++;
        }
        else {
            throw new InvalidDataException("Invalid Data: You can't input null.");
        }
    }
    
    /**
     * 
     * @return obj
     * Description: This method returns the first item
     * in the queue and removes it.
     * 
     */
    @Override
    public Object dequeue() throws QueueEmptyException {
        Object obj = null;
        if(!this.isEmpty()) {
            obj = queue[fntIndex];
            queue[fntIndex] = null;
            queueSize--;
            fntIndex = (fntIndex + 1) % queue.length;
        }
        else {
            throw new QueueEmptyException("Error: queue is empty!");
        }
        return (E) obj;
    }
    
    /**
     * 
     * Description: Expands the array, reformatting it
     * as needed to suit the other class methods
     * 
     */
    private void resizeArray(int nSize) {
        E[] nQueue = (E[]) new Object[nSize];
        int index = fntIndex;
        
        for(int i = 0; i < queue.length; i++) {
            nQueue[i] = queue[index % queue.length];
            index++;
        }
        fntIndex = 0;
        queue = nQueue;
    }
    
}
