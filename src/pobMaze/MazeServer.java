package pobMaze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class MazeServer {

	private static ArrayList<String> x;
	public int width;
	public int height;
	public int StartX;
	public int StartY;
	public static char[][] maze;
	private HashMap<String, Player> players;
	
	/**
	 * @param args
	 */
	
	public static void main(String[] args){
		MazeServer yo = new MazeServer();
		yo.connect("hi","hello");
	}
	
	public String connect(String Username, String Password){
		if(maze == null){
			readMaze();
		}
		System.out.println(Arrays.toString(getArea(2, 2)));
		players = new HashMap<String, Player>();
		
		if(players.containsKey(Username)){
			if(players.get(Username).getPassword().equals(Password)){
				return Username+"hahaha";
			}else{
				return "Username and password does not match.";
			}
		}
		
		players.put(Username, new Player(Username, Password, StartX, StartY));
		return "user has been created";
		
	}
	
	public String close(String Username, String Password){
		if(!players.containsKey(Username)) {
			return "Player cannot be found";
		}
		
		if(!players.get(Username).getPassword().equals(Password)) {
			return "Password is incorrect";
		}
		
		players.remove(Username);
		return "OK";
	}
	
	
	public void look(String sessionID){
		
	}
	
	public void move(String Username, char direction){
		
	}
	
	public void readMaze(){
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(new File("maze1.in"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String eachLine;

		x = new ArrayList<String>();

		// Following method simply scan each part of the file into an array of
		// strings
		while (fileScanner.hasNext()) {
			eachLine = fileScanner.nextLine();
			x.addAll(Arrays.asList((eachLine.split("\n"))));
		}
		
		width = x.get(0).length();
		height = x.size();
		
		//System.out.println(height);
		maze = new char[height][width];
		
		for(int i = 0; i < x.size(); i++){
			for(int j = 0; j < x.get(i).length(); j++){
				maze[i][j] =  x.get(i).charAt(j);
				System.out.print(maze[i][j]);
				if(maze[i][j] == 'S'){
					this.StartY = j;
				}
				if(maze[i][j] == 'E'){
					this.StartX = i;
				}
			}
			System.out.println("");
		}
	}
	
	public String getMaze(){
		return null;
	}
	
	public char[] getArea(int x, int y){
		char[] temp = new char[4];
		
		//north
		if(y - 1 < 0)
			temp[0] = 'X';
		else
			temp[0] = maze[y - 1][x];
		
		//east
		if(x + 1 > width - 1)
			temp[1] = 'X';
		else 
			temp[1] = maze[y][x + 1];
		
		//south
		if(y + 1  > height - 1)
			temp[2] = 'X';
		else
			temp[2] = maze[y + 1][x];
		
		//west
		if(x - 1 < 0)
			temp[3] = 'X';
		else 
			temp[3] = maze[y][x - 1];
		
		return temp;
	}
}
