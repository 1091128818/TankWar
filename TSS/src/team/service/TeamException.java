package team.service;

public class TeamException extends Exception{
	
	public TeamException(String message) {
		super(message);
	}
	
	public TeamException(Exception cause) {
		super(cause);
	}
}
