package AI;

public class Maze {
	private Cell [][] myMaze;
	public Maze() {
		myMaze=new Cell[10][10];
		myMaze[0][0]=new Cell(false, false, true, true);
		myMaze[0][1]=new Cell(true, false, true, true);
		myMaze[0][2]=new Cell(true, false, false, true);
		myMaze[0][3]=new Cell(true, true, false, false);
		myMaze[0][4]=new Cell(true, false, false, false);
		myMaze[0][5]=new Cell(true, true, false, false);
		myMaze[0][6]=new Cell(true, false, true, false);
		myMaze[0][7]=new Cell(true, false, false, true);
		myMaze[0][8]=new Cell(true, true, false, false);
		myMaze[0][9]=new Cell(true, false, true, false);

		myMaze[1][0]=new Cell(false, false, false, true);
		myMaze[1][1]=new Cell(false, true, true, false);
		myMaze[1][2]=new Cell(false, true, false, true);
		myMaze[1][3]=new Cell(true, false, true, false);
		myMaze[1][4]=new Cell(false, false, true, true);
		myMaze[1][5]=new Cell(true, false, true, true);
		myMaze[1][6]=new Cell(false, false, true, true);
		myMaze[1][7]=new Cell(false, false, true, true);
		myMaze[1][8]=new Cell(true, false, true, true);
		myMaze[1][9]=new Cell(false, false, true, true);

		myMaze[2][0]= new Cell(false, false, true, true);
		myMaze[2][1]= new Cell(true, false, false, true);
		myMaze[2][2]= new Cell(true, false, false, false);
		myMaze[2][3]= new Cell(false, true, true, false);
		myMaze[2][4]= new Cell(false, true, false, true);
		myMaze[2][5]= new Cell(false, true, true, false);
		myMaze[2][6]= new Cell(false, false, true, true);
		myMaze[2][7]= new Cell(false, true, false, true);
		myMaze[2][8]= new Cell(false, false, true, false);
		myMaze[2][9]= new Cell(false, false, true, true);

		myMaze[3][0]= new Cell(false, false, true, true);
		myMaze[3][1]= new Cell(false, false, true, true);
		myMaze[3][2]= new Cell(false, true, true, true);
		myMaze[3][3]= new Cell(true, true, false, true);
		myMaze[3][4]= new Cell(true, true, false, false);
		myMaze[3][5]= new Cell(true, true, false, false);
		myMaze[3][6]= new Cell(false, false, true, false);
		myMaze[3][7]= new Cell(true, false, true, true);
		myMaze[3][8]= new Cell(false, false, true, true);
		myMaze[3][9]= new Cell(false, false, true, true);

		myMaze[4][0]= new Cell(false, false, false, true);
		myMaze[4][1]= new Cell(false, false, true, false);
		myMaze[4][2]= new Cell(true, false, false, true);
		myMaze[4][3]= new Cell(true, true, true, false);
		myMaze[4][4]= new Cell(true, false, false, true);
		myMaze[4][5]= new Cell(true, true, false, false);
		myMaze[4][6]= new Cell(false, true, true, false);
		myMaze[4][7]= new Cell(false, false, false, true);
		myMaze[4][8]= new Cell(false, false, true, false);
		myMaze[4][9]= new Cell(false, false, true, true);

		myMaze[5][0]= new Cell(false, false, true, true);
		myMaze[5][1]= new Cell(false, true, false, true);
		myMaze[5][2]= new Cell(false, true, true, false);
		myMaze[5][3]= new Cell(true, false, false, true);
		myMaze[5][4]= new Cell(false, true, true, false);
		myMaze[5][5]= new Cell(true, false, false, true);
		myMaze[5][6]= new Cell(true, true, false, false);
		myMaze[5][7]= new Cell(false, true, true, false);
		myMaze[5][8]= new Cell(false, true, true, true);
		myMaze[5][9]= new Cell(false, false, true, true);

		myMaze[6][0]= new Cell(false, true, true, true);
		myMaze[6][1]= new Cell(true, true, false, true);
		myMaze[6][2]= new Cell(true, false, true, false);
		myMaze[6][3]= new Cell(false, false, true, true);
		myMaze[6][4]= new Cell(true, false, true, true);
		myMaze[6][5]= new Cell(false, true, false, true);
		myMaze[6][6]= new Cell(true, true, false, false);
		myMaze[6][7]= new Cell(true, false, true, false);
		myMaze[6][8]= new Cell(true, false, false, true);
		myMaze[6][9]= new Cell(false, true, true, false);

		myMaze[7][0]= new Cell(true, false, false, true);
		myMaze[7][1]= new Cell(true, true, false, false);
		myMaze[7][2]= new Cell(false, true, false, false);
		myMaze[7][3]= new Cell(false, true, false, false);
		myMaze[7][4]= new Cell(false, true, false, false);
		myMaze[7][5]= new Cell(true, false, true, false);
		myMaze[7][6]= new Cell(true, true, false, true);
		myMaze[7][7]= new Cell(false, false, true, false);
		myMaze[7][8]= new Cell(false, false, true, true);
		myMaze[7][9]= new Cell(true, false, true, true);

		myMaze[8][0]= new Cell(false, false, true, true);
		myMaze[8][1]= new Cell(true, false, true, true);
		myMaze[8][2]= new Cell(true, true, false, true);
		myMaze[8][3]= new Cell(true, true, false, false);
		myMaze[8][4]= new Cell(true, false, true, false);
		myMaze[8][5]= new Cell(false, true, false, true);
		myMaze[8][6]= new Cell(true, true, false, false);
		myMaze[8][7]= new Cell(false, true, true, false);
		myMaze[8][8]= new Cell(false, true, false, true);
		myMaze[8][9]= new Cell(false, false, true, false);

		myMaze[9][0]= new Cell(false, true, false, true);
		myMaze[9][1]= new Cell(false, true, false, false);
		myMaze[9][2]= new Cell(true, true, false, false);
		myMaze[9][3]= new Cell(true, true, true, false);
		myMaze[9][4]= new Cell(false, true, false, true);
		myMaze[9][5]= new Cell(true, true, false, false);
		myMaze[9][6]= new Cell(true, true, false, false);
		myMaze[9][7]= new Cell(true, true, false, false);
		myMaze[9][8]= new Cell(true, true, false, false);
		myMaze[9][9]= new Cell(false, false, true, false);
	}
	public Cell[][] getMaze(){
		return myMaze;
	}

}
