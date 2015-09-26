package server;

public class Player {

	private String username;
	private String password;
	private int xlocation;
	private int ylocation;
	private int numberOfMoves;
	
	public Player(String username, String password, int x, int y){
		this.username = username;
		this.password = password;
		this.xlocation = x;
		this.ylocation = y;
		this.numberOfMoves = 0;
	}
	public String getUsername() {
		return username;
	}

	public int getNumberOfMoves() {
		return numberOfMoves;
	}
	
	public void setNumberOfMoves() {
		this.numberOfMoves++;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getXlocation() {
		return xlocation;
	}

	public void setXlocation(int xlocation) {
		this.xlocation = xlocation;
	}

	public int getYlocation() {
		return ylocation;
	}

	public void setYlocation(int ylocation) {
		this.ylocation = ylocation;
	}


}
