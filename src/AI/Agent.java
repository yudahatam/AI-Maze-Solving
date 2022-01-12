package AI;

public class Agent {
	private int xScreen,yScreen;
	private int xPos,yPos;
	private int result;
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Agent() {
		xScreen=yScreen=xPos=yPos=0;
	}
	public int getXScreen() {
		return xScreen;
	}
	public void setXScreen(int x) {
		this.xScreen = x;
	}
	public int getYScreen() {
		return yScreen;
	}
	public void setYScreen(int y) {
		this.yScreen = y;
	}
	
	public void moveR() {
		xScreen+=View.cellSize;
		yPos++;
	}
	public void moveD() {
		yScreen+=View.cellSize;
		xPos++;
	}
	public void moveU() {
		yScreen-=View.cellSize;
		xPos--;
	}
	public void moveL() {
		xScreen-=View.cellSize;
		yPos--;
	}
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
}
