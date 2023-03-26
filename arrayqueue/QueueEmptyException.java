/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arrayqueue;

/**
 *
 * @author micahvranyes
 * Created: Feb 27, 2023
 * Description:
 */
public class QueueEmptyException extends RuntimeException {
    public QueueEmptyException (String error) {
        super(error);
    }
}

