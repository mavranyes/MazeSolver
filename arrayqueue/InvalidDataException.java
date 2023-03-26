/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arrayqueue;

/**
 *
 * @author micahvranyes
 * Created: Feb 24, 2023
 * Description: An class for throwing exceptions involving
 * incorrect invalid data.
 * 
 */
public class InvalidDataException extends RuntimeException {
    public InvalidDataException (String error) {
        super(error);
    }
}
