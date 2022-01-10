package ru.geekbrains;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class Game {

    private JFrame window;
    private GameCanvas gameCanvas;
    public Set<GameObject> gameObjects = new HashSet<>();
    public Set<GameObject> newGameObjects = new HashSet<>();
    public Set<Integer> pressedKeys = new HashSet<>();


    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    private void start() {
        createWindow();
        initKeyListeners();
        createInitialGameObjects();
        startTimer();
    }
    private void initKeyListeners(){
        window.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                pressedKeys.add(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                pressedKeys.remove(e.getKeyCode());
            }
        });
}
    private void createInitialGameObjects() {
        Ship ship = new Ship(this);
        ship.position = new Vector2(250, 450);
        gameObjects.add(ship);
    }


    private void startTimer() {
        Timer timer = new Timer(50, new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });
        timer.start();
    }

    private void tick(){
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
        for(GameObject gameObject: gameObjects){
            gameObject.update();
        }
        gameCanvas.repaint();

    }

    public void createWindow(){
        gameCanvas = new GameCanvas(this);

        window = new JFrame("Game");
        window.setSize(500, 500);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setContentPane(gameCanvas);
        window.setVisible(true);
    }
    
}