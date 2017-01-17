class Cube{

	String[][][] state;
	String[][] front, right, left, up, down, back;
	Cube prev;
	String move;



	public Cube(String[][][] state) {
		this.state = state;
		this.front = state[0];
		this.right = state[1];
		this.left = state[2];
		this.up = state[3];
		this.down = state[4];
		this.back = state[5];
	}



	public Cube(String[][] front, String[][] right, String[][] left, String[][] up, String[][] down, String[][] back) {
		String[][][] state = {front, right, left, up, down, back};
		
		this.front = front;
		this.right = right;
		this.left = left;
		this.up = up;
		this.down = down;
		this.back = back;
		this.state = state;

	}
}