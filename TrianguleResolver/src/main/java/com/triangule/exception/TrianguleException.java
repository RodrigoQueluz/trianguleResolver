package com.triangule.exception;

public class TrianguleException extends Exception{

	 /**
	 * 
	 */
	private static final long serialVersionUID = -6915263932944238411L;

	//Parameterless Constructor
    public TrianguleException() {}

    //Constructor that accepts a message
    public TrianguleException(String message)
    {
       super(message);
    }

}
