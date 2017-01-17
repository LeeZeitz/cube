import java.util.*;


public class Tester {

	public static void main (String[] args) {

		CubeSolver solver = new CubeSolver();

	    testRotate(solver);
	    testRotateI(solver);
	    testUp(solver);
	    testUpI(solver);
	    testRight(solver);
	    testRightI(solver);
	    testBack(solver);
	    testBackI(solver);
	    testDown(solver);
	    testDownI(solver);

	}


	public static void testRotate(CubeSolver solver){
		String[][] array = {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}};
		String[][] goal = {{"g", "d", "a"}, {"h", "e", "b"}, {"i", "f", "c"}};

		String[][] rotated = solver.rotate(array);

		if (!Arrays.deepEquals(rotated, goal)) {
			System.out.println("testRotate failed: ");
			solver.print(rotated);
			System.out.println();
			solver.print(goal);
		}
		else {
			System.out.println("testRotate Passed");
		}
	}

	public static void testRotateI(CubeSolver solver){
		String[][] array = {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}};
		String[][] goal = {{"c", "f", "i"}, {"b", "e", "h"}, {"a", "d", "g"}};

		String[][] rotated = solver.rotateI(array);

		if (!Arrays.deepEquals(rotated, goal)) {
			System.out.println("testRotateI failed: ");
			solver.print(rotated);
			System.out.println();
			solver.print(goal);
		}
		else {
			System.out.println("testRotateI Passed");
		}
	}

	public static void testUp(CubeSolver solver){

		String[][] left = {{"O", "O", "O"}, {"O", "O", "O"}, {"O", "O", "O"}};
	    String[][] right = {{"R", "R", "R"}, {"R", "R", "R"}, {"R", "R", "R"}};
	    String[][] up = {{"Y", "Y", "B"}, {"Y", "Y", "B"}, {"Y", "Y", "B"}};
	    String[][] down = {{"W", "W", "G"}, {"W", "W", "G"}, {"W", "W", "G"}};
	    String[][] front = {{"B", "B", "W"}, {"B", "B", "W"}, {"B", "B", "W"}};
	    String[][] back = {{"G", "G", "Y"}, {"G", "G", "Y"}, {"G", "G", "Y"}};

		String[][] rightS = {{"Y", "G", "G"}, {"R", "R", "R"}, {"R", "R", "R"}};
	    String[][] leftS = {{"B", "B", "W"}, {"O", "O", "O"}, {"O", "O", "O"}};
	    String[][] upS = {{"Y", "Y", "Y"}, {"Y", "Y", "Y"}, {"B", "B", "B"}};
	    String[][] downS = {{"W", "W", "G"}, {"W", "W", "G"}, {"W", "W", "G"}};
	    String[][] frontS = {{"R", "R", "R"}, {"B", "B", "W"}, {"B", "B", "W"}};
	    String[][] backS = {{"G", "G", "Y"}, {"G", "G", "Y"}, {"O", "O", "O"}};


	    String[][][] cube = {front, right, left, up, down, back};
	    String[][][] goal = {frontS, rightS, leftS, upS, downS, backS};

		String[][][] tested = solver.up(cube);

		if (!Arrays.deepEquals(tested, goal)) {
			System.out.println("testUp2 failed: ");
			for (int i = 0; i < 6; i++) {
				solver.print(tested[i]);
			}
			System.out.println();
			for (int i = 0; i < 6; i++) {
				solver.print(goal[i]);
			}
		}
		else {
			System.out.println("testUp2 Passed");
		}
	}


	public static void testUpI(CubeSolver solver){

		String[][] left = {{"G", "G", "G"}, {"O", "O", "O"}, {"O", "O", "O"}};
	    String[][] right = {{"B", "B", "B"}, {"R", "R", "R"}, {"R", "R", "R"}};
	    String[][] up = {{"Y", "Y", "Y"}, {"Y", "Y", "Y"}, {"Y", "Y", "Y"}};
	    String[][] down = {{"W", "W", "W"}, {"W", "W", "W"}, {"W", "W", "W"}};
	    String[][] front = {{"O", "O", "O"}, {"B", "B", "B"}, {"B", "B", "B"}};
	    String[][] back = {{"G", "G", "G"}, {"G", "G", "G"}, {"R", "R", "R"}};

		String[][] rightS = {{"R", "R", "R"}, {"R", "R", "R"}, {"R", "R", "R"}};
	    String[][] leftS = {{"O", "O", "O"}, {"O", "O", "O"}, {"O", "O", "O"}};
	    String[][] upS = {{"Y", "Y", "Y"}, {"Y", "Y", "Y"}, {"Y", "Y", "Y"}};
	    String[][] downS = {{"W", "W", "W"}, {"W", "W", "W"}, {"W", "W", "W"}};
	    String[][] frontS = {{"B", "B", "B"}, {"B", "B", "B"}, {"B", "B", "B"}};
	    String[][] backS = {{"G", "G", "G"}, {"G", "G", "G"}, {"G", "G", "G"}};


	    String[][][] cube = {front, right, left, up, down, back};
	    String[][][] goal = {frontS, rightS, leftS, upS, downS, backS};

		String[][][] tested = solver.upI(solver.upI(solver.upI(cube)));

		if (!Arrays.deepEquals(tested, goal)) {
			System.out.println("testUpI failed: ");
			for (int i = 0; i < 6; i++) {
				solver.print(tested[i]);
			}
			System.out.println();
			for (int i = 0; i < 6; i++) {
				solver.print(goal[i]);
			}
		}
		else {
			System.out.println("testUpI Passed");
		}
	}

	
	public static void testRight(CubeSolver solver){

		String[][] right = {{"Y", "G", "G"}, {"R", "R", "R"}, {"R", "R", "R"}};
	    String[][] left = {{"B", "B", "W"}, {"O", "O", "O"}, {"O", "O", "O"}};
	    String[][] up = {{"Y", "Y", "Y"}, {"Y", "Y", "Y"}, {"B", "B", "B"}};
	    String[][] down = {{"W", "W", "G"}, {"W", "W", "G"}, {"W", "W", "G"}};
	    String[][] front = {{"R", "R", "R"}, {"B", "B", "W"}, {"B", "B", "W"}};
	    String[][] back = {{"G", "G", "Y"}, {"G", "G", "Y"}, {"O", "O", "O"}};

		String[][] rightS = {{"R", "R", "Y"}, {"R", "R", "G"}, {"R", "R", "G"}};
	    String[][] leftS = {{"B", "B", "W"}, {"O", "O", "O"}, {"O", "O", "O"}};
	    String[][] upS = {{"Y", "Y", "R"}, {"Y", "Y", "W"}, {"B", "B", "W"}};
	    String[][] downS = {{"W", "W", "Y"}, {"W", "W", "Y"}, {"W", "W", "O"}};
	    String[][] frontS = {{"R", "R", "G"}, {"B", "B", "G"}, {"B", "B", "G"}};
	    String[][] backS = {{"G", "G", "Y"}, {"G", "G", "Y"}, {"O", "O", "B"}};


	    String[][][] cube = {front, right, left, up, down, back};
	    String[][][] goal = {frontS, rightS, leftS, upS, downS, backS};

		String[][][] tested = solver.right(cube);

		if (!Arrays.deepEquals(tested, goal)) {
			System.out.println("testRight failed: ");
			for (int i = 0; i < 6; i++) {
				solver.print(tested[i]);
			}
			System.out.println();
			for (int i = 0; i < 6; i++) {
				solver.print(goal[i]);
			}
		}
		else {
			System.out.println("testRight Passed");
		}
	}




	public static void testRightI(CubeSolver solver){

		String[][] rightS = {{"Y", "G", "G"}, {"R", "R", "R"}, {"R", "R", "R"}};
	    String[][] leftS = {{"B", "B", "W"}, {"O", "O", "O"}, {"O", "O", "O"}};
	    String[][] upS = {{"Y", "Y", "Y"}, {"Y", "Y", "Y"}, {"B", "B", "B"}};
	    String[][] downS = {{"W", "W", "G"}, {"W", "W", "G"}, {"W", "W", "G"}};
	    String[][] frontS = {{"R", "R", "R"}, {"B", "B", "W"}, {"B", "B", "W"}};
	    String[][] backS = {{"G", "G", "Y"}, {"G", "G", "Y"}, {"O", "O", "O"}};

		String[][] right = {{"R", "R", "Y"}, {"R", "R", "G"}, {"R", "R", "G"}};
	    String[][] left = {{"B", "B", "W"}, {"O", "O", "O"}, {"O", "O", "O"}};
	    String[][] up = {{"Y", "Y", "R"}, {"Y", "Y", "W"}, {"B", "B", "W"}};
	    String[][] down = {{"W", "W", "Y"}, {"W", "W", "Y"}, {"W", "W", "O"}};
	    String[][] front = {{"R", "R", "G"}, {"B", "B", "G"}, {"B", "B", "G"}};
	    String[][] back = {{"G", "G", "Y"}, {"G", "G", "Y"}, {"O", "O", "B"}};


	    String[][][] cube = {front, right, left, up, down, back};
	    String[][][] goal = {frontS, rightS, leftS, upS, downS, backS};

		String[][][] tested = solver.rightI(cube);

		if (!Arrays.deepEquals(tested, goal)) {
			System.out.println("testRightI failed: ");
			for (int i = 0; i < 6; i++) {
				solver.print(tested[i]);
			}
			System.out.println();
			for (int i = 0; i < 6; i++) {
				solver.print(goal[i]);
			}
		}
		else {
			System.out.println("testRightI Passed");
		}
	}


	public static void testBack(CubeSolver solver){

		String[][] right = {{"R", "W", "W"}, {"R", "R", "G"}, {"Y", "Y", "O"}};
	    String[][] left = {{"B", "W", "W"}, {"O", "O", "B"}, {"O", "Y", "Y"}};
	    String[][] up = {{"W", "O", "R"}, {"G", "Y", "R"}, {"G", "R", "G"}};
	    String[][] down = {{"B", "W", "O"}, {"B", "W", "O"}, {"Y", "R", "W"}};
	    String[][] front = {{"O", "B", "Y"}, {"O", "B", "Y"}, {"R", "B", "G"}};
	    String[][] back = {{"B", "G", "B"}, {"W", "G", "Y"}, {"R", "G", "G"}};

		String[][] rightS = {{"R", "W", "W"}, {"R", "R", "R"}, {"Y", "Y", "Y"}};
	    String[][] leftS = {{"R", "W", "W"}, {"O", "O", "B"}, {"W", "Y", "Y"}};
	    String[][] upS = {{"W", "G", "O"}, {"G", "Y", "R"}, {"G", "R", "G"}};
	    String[][] downS = {{"B", "W", "O"}, {"B", "W", "O"}, {"B", "O", "O"}};
	    String[][] frontS = {{"O", "B", "Y"}, {"O", "B", "Y"}, {"R", "B", "G"}};
	    String[][] backS = {{"R", "W", "B"}, {"G", "G", "G"}, {"G", "Y", "B"}};


	    String[][][] cube = {front, right, left, up, down, back};
	    String[][][] goal = {frontS, rightS, leftS, upS, downS, backS};

		String[][][] tested = solver.back(cube);

		if (!Arrays.deepEquals(tested, goal)) {
			System.out.println("testBack failed: ");
			for (int i = 0; i < 6; i++) {
				solver.print(tested[i]);
			}
			System.out.println();
			for (int i = 0; i < 6; i++) {
				solver.print(goal[i]);
			}
		}
		else {
			System.out.println("testBack Passed");
		}
	}



	public static void testBackI(CubeSolver solver){

		String[][] right = {{"R", "W", "W"}, {"R", "R", "G"}, {"Y", "Y", "O"}};
	    String[][] left = {{"B", "W", "W"}, {"O", "O", "B"}, {"O", "Y", "Y"}};
	    String[][] up = {{"W", "O", "R"}, {"G", "Y", "R"}, {"G", "R", "G"}};
	    String[][] down = {{"B", "W", "O"}, {"B", "W", "O"}, {"Y", "R", "W"}};
	    String[][] front = {{"O", "B", "Y"}, {"O", "B", "Y"}, {"R", "B", "G"}};
	    String[][] back = {{"B", "G", "B"}, {"W", "G", "Y"}, {"R", "G", "G"}};

		String[][] rightS = {{"R", "W", "W"}, {"R", "R", "R"}, {"Y", "Y", "Y"}};
	    String[][] leftS = {{"R", "W", "W"}, {"O", "O", "B"}, {"W", "Y", "Y"}};
	    String[][] upS = {{"W", "G", "O"}, {"G", "Y", "R"}, {"G", "R", "G"}};
	    String[][] downS = {{"B", "W", "O"}, {"B", "W", "O"}, {"B", "O", "O"}};
	    String[][] frontS = {{"O", "B", "Y"}, {"O", "B", "Y"}, {"R", "B", "G"}};
	    String[][] backS = {{"R", "W", "B"}, {"G", "G", "G"}, {"G", "Y", "B"}};


	    String[][][] cube = {front, right, left, up, down, back};
	    String[][][] goal = {frontS, rightS, leftS, upS, downS, backS};

		String[][][] tested = solver.backI(solver.backI(solver.backI(cube)));

		if (!Arrays.deepEquals(tested, goal)) {
			System.out.println("testBackI failed: ");
			for (int i = 0; i < 6; i++) {
				solver.print(tested[i]);
			}
			System.out.println();
			for (int i = 0; i < 6; i++) {
				solver.print(goal[i]);
			}
		}
		else {
			System.out.println("testBackI Passed");
		}
	}


	public static void testDown(CubeSolver solver){

		String[][] right = {{"G", "R", "B"}, {"G", "R", "W"}, {"W", "B", "Y"}};
	    String[][] left = {{"G", "O", "O"}, {"Y", "O", "O"}, {"Y", "Y", "Y"}};
	    String[][] up = {{"R", "R", "R"}, {"B", "Y", "G"}, {"B", "Y", "O"}};
	    String[][] down = {{"B", "G", "G"}, {"B", "W", "W"}, {"B", "B", "R"}};
	    String[][] front = {{"W", "R", "Y"}, {"W", "B", "Y"}, {"R", "O", "O"}};
	    String[][] back = {{"O", "R", "G"}, {"O", "G", "G"}, {"W", "W", "W"}};


		String[][] rightS = {{"G", "R", "B"}, {"G", "R", "W"}, {"R", "O", "O"}};
	    String[][] leftS = {{"G", "O", "O"}, {"Y", "O", "O"}, {"G", "R", "O"}};
	    String[][] upS = {{"R", "R", "R"}, {"B", "Y", "G"}, {"B", "Y", "O"}};
	    String[][] downS = {{"B", "B", "B"}, {"B", "W", "G"}, {"R", "W", "G"}};
	    String[][] frontS = {{"W", "R", "Y"}, {"W", "B", "Y"}, {"Y", "Y", "Y"}};
	    String[][] backS = {{"Y", "B", "W"}, {"O", "G", "G"}, {"W", "W", "W"}};


	    String[][][] cube = {front, right, left, up, down, back};
	    String[][][] goal = {frontS, rightS, leftS, upS, downS, backS};

		String[][][] tested = solver.down(cube);

		if (!Arrays.deepEquals(tested, goal)) {
			System.out.println("testDown failed: ");
			for (int i = 0; i < 6; i++) {
				solver.print(tested[i]);
			}
			System.out.println();
			for (int i = 0; i < 6; i++) {
				solver.print(goal[i]);
			}
		}
		else {
			System.out.println("testDown Passed");
		}
	}




	public static void testDownI(CubeSolver solver){

		String[][] rightS = {{"G", "R", "B"}, {"G", "R", "W"}, {"W", "B", "Y"}};
	    String[][] leftS = {{"G", "O", "O"}, {"Y", "O", "O"}, {"Y", "Y", "Y"}};
	    String[][] upS = {{"R", "R", "R"}, {"B", "Y", "G"}, {"B", "Y", "O"}};
	    String[][] downS = {{"B", "G", "G"}, {"B", "W", "W"}, {"B", "B", "R"}};
	    String[][] frontS = {{"W", "R", "Y"}, {"W", "B", "Y"}, {"R", "O", "O"}};
	    String[][] backS = {{"O", "R", "G"}, {"O", "G", "G"}, {"W", "W", "W"}};


		String[][] right = {{"G", "R", "B"}, {"G", "R", "W"}, {"R", "O", "O"}};
	    String[][] left = {{"G", "O", "O"}, {"Y", "O", "O"}, {"G", "R", "O"}};
	    String[][] up = {{"R", "R", "R"}, {"B", "Y", "G"}, {"B", "Y", "O"}};
	    String[][] down = {{"B", "B", "B"}, {"B", "W", "G"}, {"R", "W", "G"}};
	    String[][] front = {{"W", "R", "Y"}, {"W", "B", "Y"}, {"Y", "Y", "Y"}};
	    String[][] back = {{"Y", "B", "W"}, {"O", "G", "G"}, {"W", "W", "W"}};


	    String[][][] cube = {front, right, left, up, down, back};
	    String[][][] goal = {frontS, rightS, leftS, upS, downS, backS};

		String[][][] tested = solver.downI(cube);

		if (!Arrays.deepEquals(tested, goal)) {
			System.out.println("testDownI failed: ");
			for (int i = 0; i < 6; i++) {
				solver.print(tested[i]);
			}
			System.out.println();
			for (int i = 0; i < 6; i++) {
				solver.print(goal[i]);
			}
		}
		else {
			System.out.println("testDownI Passed");
		}
	}










}