import java.util.Random;

/**
 * RainbowRobot représente un robot qui change de couleur à chaque déplacement
 * et peut se déplacer dans les quatre directions (haut, bas, gauche, droite).
 */
public class RainbowRobot extends RobotG {
    // Attributs du robot
    private String name;
    private int x, y;
    private Colour colour;
    private CanvasRobot canvasRobot;
    private static final Random random = new Random();

    /**
     * Constructeur pour créer un robot avec un nom, une position initiale.
     * @param name Le nom du robot
     * @param x Position X initiale du robot
     * @param y Position Y initiale du robot
     */
    public RainbowRobot(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.colour = getRandomColour();
        this.canvasRobot = new CanvasRobot(colour.toString());
        this.drawRobot();
    }

    /**
     * Méthode pour obtenir une couleur aléatoire.
     * @return Une couleur aléatoire du type Colour.
     */
    private Colour getRandomColour() {
        Colour[] colours = Colour.values();
        return colours[random.nextInt(colours.length)];
    }

    /**
     * Dessine le robot sur le canevas à la position actuelle.
     */
    private void drawRobot() {
        canvasRobot.setColourBody(colour.toString());
        canvasRobot.drawRobot(x, y);
    }

    /**
     * Déplace le robot vers le haut.
     */
    public void moveUp() {
        y -= 1;
        colour = getRandomColour();
        drawRobot();
    }

    /**
     * Déplace le robot vers le bas.
     */
    public void moveDown() {
        y += 1;
        colour = getRandomColour();
        drawRobot();
    }

    /**
     * Déplace le robot vers la gauche.
     */
    public void moveLeft() {
        x -= 1;
        colour = getRandomColour();
        drawRobot();
    }

    /**
     * Déplace le robot vers la droite.
     */
    public void moveRight() {
        x += 1;
        colour = getRandomColour();
        drawRobot();
    }

    /**
     * Retourne le nom du robot.
     * @return Le nom du robot.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Supprime le robot du canevas.
     */
    public void removeRobot() {
        // Efface le robot du canvas
        canvasRobot = null;
    }
}