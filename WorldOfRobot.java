import java.util.ArrayList;

/**
 * The WorldOfRobot class is a class that will create the world in which the robots will be displayed.
 */
public class WorldOfRobot {
    // Define an ArrayList called worldList which stores the robot's positions
    private ArrayList<RobotG> worldList;
    // Define the number of robots in the world
    private int numberOfRobots;
  
    /**
     * Constructor for objects of class WorldOfRobot
     */
    public WorldOfRobot() {
        this.worldList = new ArrayList<RobotG>();        
    }
    
    /**
     * Returns the list of robots in the world     
     */
    public ArrayList<RobotG> getList() {
        return this.worldList;
    }

    /**
     * Get the number of robot objects in the list
     * @return number of robots
     */
    public int getNumberOfRobots() {
        return this.worldList.size();
    }
    
    /**
     * Checks if the position a robot tries to move to is already occupied
     * @param x, horizontal robot position
     * @param y, vertical robot position
     * @return true if the position is free, false if occupied
     */
    public boolean canItMove(int x, int y) {
        for (RobotG r : this.worldList) {
            if (r.getXPosition() == x && r.getYPosition() == y) {
                return false;
            }
        }
        return true;
    }

    /**
     * Moves all robots present in the world at the same time in a loop
     */
    public void moveAll() {
        while (true) {
            for (RobotG rob : worldList) {
                rob.move();
            }
            try {
                Thread.sleep(1000); // Delay for one second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Moves all robots one by one, w times, according to their specifications
     * @param w, number of moves of each robot
     */
    public void moveAutomatic(int w) {
        for (int cpt = 0; cpt < w; cpt++) {
            for (RobotG rob : worldList) {
                rob.move();
            }
            try {
                Thread.sleep(1000); // Delay for one second between moves
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }   
    }    
        
    /**
     * Adds a robot to the list of robots present in the world
     * @param r, robot to be added
     */
    public void addRobot(RobotG r) {
        this.worldList.add(r);
    }
}