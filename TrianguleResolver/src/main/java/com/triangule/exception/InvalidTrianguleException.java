package com.triangule.exception;

public class InvalidTrianguleException extends Exception{

	 /**
	 * 
	 */
	private static final long serialVersionUID = -6915263932944238411L;

	//Parameterless Constructor
    public InvalidTrianguleException() {}

    //Constructor that accepts a message
    public InvalidTrianguleException(String message)
    {
       super(message);
    }

}
