import java.util.*;

public class CubeSolver{

	public static String[][][] copyState(String[][][] state) {
		String[][][] newState = new String[6][3][3];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					newState[i][j][k] = state[i][j][k];
				}
			}
		}
		return newState;
	}

	public static String[][] print(String[][] grid) {

		for(int i = 0; i < 3; i ++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
		return grid;
	}

	public static String[][] rotate(String[][] grid) {

		String[][] rotateArr = new String[grid[0].length][grid.length];
		
		for(int i = 0; i < grid[0].length; i++){
			for(int j = grid.length - 1; j >= 0; j--){
				rotateArr[i][grid.length - 1 - j] = grid[j][i];
			}
		}
		return rotateArr;
	}

	public static void testRotate(){
		String[][] array = {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}};
		String[][] goal = {{"g", "d", "a"}, {"h", "e", "b"}, {"i", "f", "c"}};

		String[][] rotated = rotate(array);

		if (!Arrays.deepEquals(rotated, goal)) {
			System.out.println("testRotate failed: ");
			print(rotated);
			System.out.println();
			print(goal);
		}
		else {
			System.out.println("testRotate Passed");
		}
	}


	public static String[][] rotateI(String[][] grid) {
		String[][] rotateArr = new String[grid[0].length][grid.length];

		for(int i = 0; i < grid[0].length; i++) {
			for(int j = grid.length - 1; j >= 0; j--) {
				rotateArr[grid.length - 1 - i][j] = grid[j][i];
			}	
		}
		return rotateArr;
	}
  


  public static String[][][] up(String[][][] state) {
    String[][][] newState = copyState(state);


    newState[0][0][0] = state[1][0][0];
    newState[0][0][1] = state[1][0][1];
    newState[0][0][2] = state[1][0][2];

    newState[2][0][0] = state[0][0][0];
    newState[2][0][1] = state[0][0][1];
    newState[2][0][2] = state[0][0][2];
            
  	newState[5][2][2] = state[2][0][0];
  	newState[5][2][1] = state[2][0][1];
  	newState[5][2][0] = state[2][0][2];
  
  	newState[1][0][0] = state[5][2][2];
  	newState[1][0][1] = state[5][2][1];
  	newState[1][0][2] = state[5][2][0];


    /*
    int[] fromFaces = {0, 2, 5, 1};
    int[] toFaces = {2, 5, 1, 0};
    
    for(int i = 0; i < 4; i++) {
      for(int j = 0; j < 3; j++) {
        newState[toFaces[i]][0][j] = state[fromFaces[i]][0][j];
      }
    }
	*/

    newState[3] = rotate(state[3]);
    return newState;
  }
  

  public static String[][][] upI(String[][][] state) {
    String[][][] newState = copyState(state);
    

	newState[0][0][0] = state[2][0][0];
    newState[0][0][1] = state[2][0][1];
    newState[0][0][2] = state[2][0][2];

    newState[2][0][0] = state[5][2][2];
    newState[2][0][1] = state[5][2][1];
    newState[2][0][2] = state[5][2][0];
            
  	newState[5][2][2] = state[1][0][0];
  	newState[5][2][1] = state[1][0][1];
  	newState[5][2][0] = state[1][0][2];
  
  	newState[1][0][0] = state[0][0][0];
  	newState[1][0][1] = state[0][0][1];
  	newState[1][0][2] = state[0][0][2];


  	/*
    int[] fromFaces = {2, 5, 1, 0};
    int[] toFaces = {0, 2, 5, 1};
    
    for(int i = 0; i < 4; i++) {
      for(int j = 0; j < 3; j++) {
        newState[toFaces[i]][0][j] = state[fromFaces[i]][0][j];
      }
    }
    */

    newState[3] = rotateI(state[3]);
    return newState;
  }


	public static String[][][] right(String[][][] state){
		String[][][] newState = copyState(state);
		
		int[] fromFaces = {0, 3, 5, 4};
		int[] toFaces = {3, 5, 4, 0};
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				newState[toFaces[i]][j][2] = state[fromFaces[i]][j][2];
			}
		}
		newState[1] = rotate(state[1]);
		return newState;
	}


	public static String[][][] left(String[][][] state) {
		String[][][] newState = copyState(state);
		
		int[] fromFaces = {0, 4, 5, 3};
		int[] toFaces = {4, 5, 3, 0};
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				newState[toFaces[i]][j][0] = state[fromFaces[i]][j][0];
			}
		}

		newState[2] = rotate(state[2]);
		return newState;
	}


	public static String[][][] front(String[][][] state) {
		String[][][] newState = copyState(state);
      	
        newState[1][0][0] = state[3][2][0];
        newState[1][1][0] = state[3][2][1];
        newState[1][2][0] = state[3][2][2];

        newState[4][0][0] = state[1][2][0];
        newState[4][0][1] = state[1][1][0];
        newState[4][0][2] = state[1][0][0];
                
      	newState[2][0][2] = state[4][0][0];
      	newState[2][1][2] = state[4][0][1];
      	newState[2][2][2] = state[4][0][2];
      
      	newState[3][2][2] = state[2][0][2];
      	newState[3][2][1] = state[2][1][2];
      	newState[3][2][0] = state[2][2][2];
      
		newState[0] = rotate(state[0]);
		return newState;
	}


	public static String[][][] down(String[][][] state) {
		String[][][] newState = copyState(state);
		
		newState[0][2][0] = state[2][2][0];
	    newState[0][2][1] = state[2][2][1];
	    newState[0][2][2] = state[2][2][2];

	    newState[2][2][0] = state[5][0][2];
	    newState[2][2][1] = state[5][0][1];
	    newState[2][2][2] = state[5][0][0];
	            
	  	newState[5][0][2] = state[1][2][0];
	  	newState[5][0][1] = state[1][2][1];
	  	newState[5][0][0] = state[1][2][2];
	  
	  	newState[1][2][0] = state[0][2][0];
	  	newState[1][2][1] = state[0][2][1];
	  	newState[1][2][2] = state[0][2][2];


		/*
		int[] fromFaces = {0, 1, 5, 2};
		int[] toFaces = {1, 5, 2, 0};
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				newState[toFaces[i]][2][j] = state[fromFaces[i]][2][j];
			}
		}
		*/

		newState[4] = rotate(state[4]);
		return newState;
	}


	public static String[][][] back(String[][][] state) {
		String[][][] newState = copyState(state);
      	
        newState[1][0][2] = state[4][2][0];
        newState[1][1][2] = state[4][2][1];
        newState[1][2][2] = state[4][2][2];

        newState[4][2][0] = state[2][0][0];
        newState[4][2][1] = state[2][1][0];
        newState[4][2][2] = state[2][2][0];
                
      	newState[2][0][0] = state[3][0][2];
      	newState[2][1][0] = state[3][0][1];
      	newState[2][2][0] = state[3][0][0];
      
      	newState[3][0][2] = state[1][2][2];
      	newState[3][0][1] = state[1][1][2];
      	newState[3][0][0] = state[1][0][2];
      
		newState[5] = rotate(state[5]);
		return newState;
	}


	public static String[][][] rightI(String[][][] state) {
		String[][][] newState = copyState(state);

		int[] fromFaces = {0, 4, 5, 3};
		int[] toFaces = {4, 5, 3, 0};

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				newState[toFaces[i]][j][2] = state[fromFaces[i]][j][2];
			}
		}
		newState[1] = rotateI(state[1]);
		return newState;
	}


	public static String[][][] leftI(String[][][] state) {
		String[][][] newState = copyState(state);
		
		int[] fromFaces = {0, 3, 5, 4};
		int[] toFaces = {3, 5, 4, 0};
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				newState[toFaces[i]][j][0] = state[fromFaces[i]][j][0];
			}
		}
		newState[2] = rotateI(state[2]);
		return newState;
	}
    
    
    public static String[][][] backI(String[][][] state) {
		String[][][] newState = copyState(state);
      	
        newState[1][0][2] = state[3][0][2];
        newState[1][1][2] = state[3][0][1];
        newState[1][2][2] = state[3][0][0];

        newState[4][2][0] = state[1][0][2];
        newState[4][2][1] = state[1][1][2];
        newState[4][2][2] = state[1][2][2];
                
      	newState[2][0][0] = state[4][2][0];
      	newState[2][1][0] = state[4][2][1];
      	newState[2][2][0] = state[4][2][2];
      
      	newState[3][0][2] = state[2][0][0];
      	newState[3][0][1] = state[2][1][0];
      	newState[3][0][0] = state[2][2][0];
      
		newState[5] = rotateI(state[5]);
		return newState;
	}
    

	public static String[][][] frontI(String[][][] state) {
		String[][][] newState = copyState(state);
      	
        newState[3][2][0] = state[1][0][0];
        newState[3][2][1] = state[1][1][0];
        newState[3][2][2] = state[1][2][0];

        newState[1][2][0] = state[4][0][0];
        newState[1][1][0] = state[4][0][1];
        newState[1][0][0] = state[4][0][2];
                
      	newState[4][0][0] = state[2][0][2];
      	newState[4][0][1] = state[2][1][2];
      	newState[4][0][2] = state[2][2][2];
      
      	newState[2][0][2] = state[3][2][2];
      	newState[2][1][2] = state[3][2][1];
      	newState[2][2][2] = state[3][2][0];
      
		newState[0] = rotateI(state[0]);
		return newState;
	}
  
	public static String[][][] downI(String[][][] state) {
		String[][][] newState = copyState(state);
		
		newState[0][2][0] = state[1][2][0];
	    newState[0][2][1] = state[1][2][1];
	    newState[0][2][2] = state[1][2][2];

	    newState[2][2][0] = state[0][2][0];
	    newState[2][2][1] = state[0][2][1];
	    newState[2][2][2] = state[0][2][2];
	            
	  	newState[5][0][2] = state[2][2][0];
	  	newState[5][0][1] = state[2][2][1];
	  	newState[5][0][0] = state[2][2][2];
	  
	  	newState[1][2][0] = state[5][0][2];
	  	newState[1][2][1] = state[5][0][1];
	  	newState[1][2][2] = state[5][0][0];


		/*
		int[] fromFaces = {0, 2, 5, 1};
		int[] toFaces = {2, 5, 1, 0};
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				newState[toFaces[i]][2][j] = state[fromFaces[i]][2][j];
			}
		}
		*/

		newState[4] = rotateI(state[4]);
		return newState;
	}


	public static Cube[] getAdjacents(String[][][] state) {
		String[][][][] stateList = {front(state), 		
				right(state),
				left(state),
				up(state),
				down(state), 
				back(state),
				frontI(state),
				rightI(state),
				leftI(state),
				upI(state),
				downI(state),
				backI(state)
				};
      	Cube[] cubeList = new Cube[12];
      
        String[] moves = {"F", "R", "L", "U", "D", "B", "F'", "R'", "L'", "U'", "D'", "B'"};
      	
      	for (int i = 0; i < 12; i++) {
              Cube newCube = new Cube(stateList[i]);
              newCube.move = moves[i];
        	  cubeList[i] = newCube;
      	}
		return cubeList;
	}
  
    
    public static boolean BFS(Cube s, Cube t){

        Queue<Cube> Q = new LinkedList<Cube>();
        HashSet<String> H = new HashSet<String>();

        Q.add(s);	
        H.add(Arrays.deepToString(s.state));

        while(!Q.isEmpty()){
            
            Cube v = Q.remove();

            if (Arrays.deepEquals(v.state, t.state)){

                Stack<Cube> C = new Stack<Cube>();
                while(!Arrays.deepEquals(v.state, s.state)){
                    C.push(v);
                    v = v.prev;
                }
                while(!C.empty()){
                    Cube temp = C.pop();
                    System.out.println(temp.move);
                    System.out.println();
                }

                return true;
            }
            Cube[] adjacents = getAdjacents(v.state);
            for (int i = 0; i < adjacents.length; i++){
                Cube w = adjacents[i];
                if(!H.contains(Arrays.deepToString(w.state))){
                    H.add(Arrays.deepToString(w.state));
                    w.prev = v;
                    Q.add(w);
                }
            }
        }
        return false;
    }

  
  public static void main(String[] args) {
    
    String[][] left = {{"W", "O", "O"}, {"B", "O", "O"}, {"O", "B", "W"}};
    String[][] right = {{"Y", "Y", "Y"}, {"R", "R", "W"}, {"G", "G", "Y"}};
    String[][] up = {{"R", "Y", "R"}, {"B", "Y", "R"}, {"B", "B", "R"}};
    String[][] down = {{"G", "G", "O"}, {"W", "W", "O"}, {"G", "G", "O"}};
    String[][] front = {{"W", "R", "G"}, {"W", "B", "W"}, {"R", "R", "W"}};
    String[][] back = {{"Y", "Y", "B"}, {"Y", "G", "G"}, {"B", "O", "B"}};
    

	String[][] rightS = {{"R", "R", "R"}, {"R", "R", "R"}, {"R", "R", "R"}};
    String[][] leftS = {{"O", "O", "O"}, {"O", "O", "O"}, {"O", "O", "O"}};
    String[][] upS = {{"Y", "Y", "Y"}, {"Y", "Y", "Y"}, {"Y", "Y", "Y"}};
    String[][] downS = {{"W", "W", "W"}, {"W", "W", "W"}, {"W", "W", "W"}};
    String[][] frontS = {{"B", "B", "B"}, {"B", "B", "B"}, {"B", "B", "B"}};
    String[][] backS = {{"G", "G", "G"}, {"G", "G", "G"}, {"G", "G", "G"}};

    /*
    String[][] leftS = {{"R", "R", "R"}, {"R", "R", "R"}, {"R", "R", "R"}};
    String[][] rightS = {{"O", "O", "O"}, {"O", "O", "O"}, {"O", "O", "O"}};
    String[][] upS = {{"Y", "Y", "Y"}, {"Y", "Y", "Y"}, {"Y", "Y", "Y"}};
    String[][] downS = {{"W", "W", "W"}, {"W", "W", "W"}, {"W", "W", "W"}};
    String[][] frontS = {{"B", "B", "B"}, {"B", "B", "B"}, {"B", "B", "B"}};
    String[][] backS = {{"G", "G", "G"}, {"G", "G", "G"}, {"G", "G", "G"}};
    */
    
    
    Cube cube = new Cube(front, right, left, up, down, back);
    Cube cubeS = new Cube(frontS, rightS, leftS, upS, downS, backS);
    
    BFS(cube, cubeS);
	
  }
  

}



