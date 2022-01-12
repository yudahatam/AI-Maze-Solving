package AI;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

/**
 * @author Chen Hess
 * @author Yuda Hatam
 */
public class View extends JFrame {
	public final static int cellSize=50; //Size of a cell in the maze
	public static ArrayList<Cell> CorrectPath=new ArrayList<Cell>();	//The final shortest path to the goal
	public static ArrayList<Cell> WrongPath=new ArrayList<Cell>();
	private static Cell lastLocation=new Cell(false, false, false, false);	//The cell that will help to decide if it is part of the shortest path
	private boolean done=false;	//Condition for end of search
    private static Cell[][] myMaze=new Maze().getMaze();	//The maze to hold all the cells
    private static Agent agent1=new Agent();	//The agent to go in the maze
    
    /*
     * Set the details for Jframe of screen
     */
    public View(){
        setTitle("Maze solution");
        setSize(12*cellSize,12*cellSize);	//Size of screen
        //setLocationRelativeTo(null);	//Set screen to center of monitor
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    /**
     * Here we draw the maze.
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.translate(50,50);	//Set the maze a little away from end of screen
        drawMaze(g);
        while(!done) {	//Continue to paint the maze until the agent has reached the goal
        	g.setColor(Color.BLUE);	//Set color to blue
        	//Paint position of agent with little blue square
        	g.fillRect(agent1.getXScreen()+20, agent1.getYScreen()+20, cellSize-40, cellSize-40);
        	
        	//Sleep between actions of agent
	        try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        //Agent movement
	        agentAction(agent1);
        }
        //When finished paint the path of the agent and the shortest path
        if(done) {
        	g.setColor(Color.BLUE);
        	drawPath(g, WrongPath);
        	g.setColor(Color.GREEN);
        	drawPath(g, CorrectPath);
        }
      //  System.out.println(agent1.getResult());
    }
    /*
     * Function to draw the maze
     */
    public void drawMaze(Graphics g) {
    	g.setColor(Color.BLACK); //Set color to black
    	//Draw the Maze
        for(int i=0;i<10;i++) {
        	for(int j=0;j<10;j++) {
        		if(myMaze[i][j].isU()) {
        			g.drawLine(j*cellSize, i*cellSize, (j+1)*cellSize, i*cellSize);
        		}
    			if(myMaze[i][j].isD()) {
    				g.drawLine(j*cellSize, (i+1)*cellSize, (j+1)*cellSize, (i+1)*cellSize);
    			}
				if(myMaze[i][j].isR()) {
					g.drawLine((j+1)*cellSize, i*cellSize, (j+1)*cellSize, (i+1)*cellSize);
				}
				if(myMaze[i][j].isL()) {
					g.drawLine(j*cellSize, i*cellSize, j*cellSize, (i+1)*cellSize);
				}
//        		if(myMaze[i][j].isU()) {
//        			g.drawLine(i*cellSize, j*cellSize, i*cellSize, (j+1)*cellSize);
//        		}
//    			if(myMaze[i][j].isD()) {
//    				g.drawLine((i+1)*cellSize, j*cellSize, (i+1)*cellSize, (j+1)*cellSize);
//    			}
//				if(myMaze[i][j].isR()) {
//					g.drawLine(i*cellSize, (j+1)*cellSize, (i+1)*cellSize, (j+1)*cellSize);
//				}
//				if(myMaze[i][j].isL()) {
//					g.drawLine(i*cellSize, j*cellSize, (i+1)*cellSize, j*cellSize);
//				}
        	}
        }
    	
    }
    /*
     * Function to draw a given path
     */
    public void drawPath(Graphics g,ArrayList<Cell>path) {
    	for(Cell temp:path) {
    		g.fillRect(temp.getY()*cellSize+20,temp.getX()*cellSize+20,cellSize-40,cellSize-40);
    	}
    } 
    public void agentAction(Agent agent) {
		int yPos,xPos;
		xPos=agent.getxPos();
		yPos=agent.getyPos();
		Cell cureentLocation=myMaze[xPos][yPos];
		cureentLocation.setX(xPos);
		cureentLocation.setY(yPos);
		if(CorrectPath.indexOf(cureentLocation)==-1)
			CorrectPath.add(cureentLocation);
		WrongPath.add(cureentLocation);
		//agent.setResult(agent.getResult()+cureentLocation.getValue());
		Cell upCell,downCell,rightCell,leftCell;
		ArrayList<Float> listOfValues=new ArrayList<>();
		float upCellValue,downCellValue,leftCellValue,rightCellValue;
		upCellValue=downCellValue=leftCellValue=rightCellValue=1000;
		cureentLocation.incValue();
		
		if(xPos==9&&yPos==9)
			done=true;
		else {
			if(xPos!=0&&!cureentLocation.isU()) {
				upCell=myMaze[xPos-1][yPos];
				upCellValue=upCell.getValue();
			}
			if(yPos!=9&&!cureentLocation.isR()) {
				rightCell=myMaze[xPos][yPos+1];
				rightCellValue=rightCell.getValue();
			}
			if(xPos!=9&&!cureentLocation.isD()) {
				downCell=myMaze[xPos+1][yPos];
				downCellValue=downCell.getValue();
			}
			if(yPos!=0&&!cureentLocation.isL()) {
				leftCell=myMaze[xPos][yPos-1];
				leftCellValue=leftCell.getValue();
			}
			
			upCellValue+=Math.sqrt(Math.pow(9-(xPos-1), 2)+Math.pow(9-yPos, 2));
			downCellValue+=Math.sqrt(Math.pow(9-(xPos+1), 2)+Math.pow(9-yPos, 2));
			leftCellValue+=Math.sqrt(Math.pow(9-xPos, 2)+Math.pow(9-(yPos-1), 2));
			rightCellValue+=Math.sqrt(Math.pow(9-xPos, 2)+Math.pow(9-(yPos+1), 2));
			listOfValues.add(upCellValue);
			listOfValues.add(downCellValue);
			listOfValues.add(leftCellValue);
			listOfValues.add(rightCellValue);
			float minNum=Math.min(Math.min(leftCellValue, rightCellValue),Math.min(upCellValue, downCellValue));
			int indexOfMin=listOfValues.indexOf(minNum);
			switch (indexOfMin) {
			case 0:
				agent.moveU();
				break;
			case 1:
				agent.moveD();
				break;
			case 2:
				agent.moveL();
				break;
			case 3:
				agent.moveR();
				break;
			}
			lastLocation=myMaze[agent.getxPos()][agent.getyPos()];
			if(lastLocation.getValue()!=0)
				CorrectPath.remove(cureentLocation);
		}
    }  
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                View view=new View();
                view.setVisible(true);
                
            }
        });
        
    }
    
}
