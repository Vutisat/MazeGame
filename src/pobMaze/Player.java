package pobMaze;

public class Player {

	private String username;
	private String password;
	private int xlocation;
	private int ylocation;
	
	public Player(String username, String password, int x, int y){
		this.username = username;
		this.password = password;
		this.xlocation = x;
		this.ylocation = y;
	}
	public String getUsername() {
		return username;
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
