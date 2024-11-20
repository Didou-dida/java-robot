import java.util.Random;

public class RobotG {
    private String name;
    private int xPosition;
    private int yPosition;
    private String direction;
    private static final Random random = new Random();

    // Constructeur avec un nom fourni
    public RobotG(String name) {
        setName(name);
        setRandomPosition();
        setRandomDirection();
    }

    // Constructeur sans paramètre (nom par défaut)
    public RobotG() {
        this("Robot" + random.nextInt(1000));  // Nom par défaut si non fourni
    }

    // Méthode pour définir un nom valide
    public void setName(String name) {
        if (isValidName(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Le nom du robot n'est pas valide.");
        }
    }

    // Méthode pour récupérer le nom du robot
    public String getName() {
        return name;
    }

    // Validation du nom selon les règles données
    private boolean isValidName(String name) {
        return name.length() >= 3 && !name.contains(" -") && !name.contains("- ") && name.indexOf(' ') != 0;
    }

    // Position aléatoire lors de la création
    private void setRandomPosition() {
        this.xPosition = random.nextInt(10);
        this.yPosition = random.nextInt(10);
    }

    // Getter pour la position en X
    public int getXPosition() {
        return xPosition;
    }

    // Setter pour la position en X
    public void setXPosition(int x) {
        this.xPosition = x;
    }

    // Getter pour la position en Y
    public int getYPosition() {
        return yPosition;
    }

    // Setter pour la position en Y
    public void setYPosition(int y) {
        this.yPosition = y;
    }

    // Méthode pour obtenir la direction actuelle
    public String getDirection() {
        return direction;
    }

    // Méthode pour changer la direction
    public void setDirection(String direction) {
        this.direction = direction;
    }

    // Définir une direction aléatoire
    private void setRandomDirection() {
        String[] directions = {"haut", "bas", "gauche", "droite"};
        this.direction = directions[random.nextInt(directions.length)];
    }

    // Méthode pour déplacer le robot dans la direction actuelle
    public void move() {
        switch (direction) {
            case "haut":
                yPosition = Math.max(0, yPosition - 10);  // Déplacement vers le haut (par exemple 10 pixels)
                break;
            case "bas":
                yPosition = Math.min(600, yPosition + 10);  // Déplacement vers le bas
                break;
            case "gauche":
                xPosition = Math.max(0, xPosition - 10);  // Déplacement vers la gauche
                break;
            case "droite":
                xPosition = Math.min(600, xPosition + 10);  // Déplacement vers la droite
                break;
        }
    }
}