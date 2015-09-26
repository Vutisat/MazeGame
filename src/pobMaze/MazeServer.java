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
	private HashMap<String, String> players;
	
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
		players = new HashMap<String, String>();
		
		if(players.containsKey(Username)){
			if(players.get(Username).equals(Password)){
				return Username+"hahaha";
			}else{
				return "Username and password does not match.";
			}
		}
		
		return Password;
		
	}
	
	public String close(String Username, String Password){
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
}
