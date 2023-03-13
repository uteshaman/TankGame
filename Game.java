package sample;

import javafx.application.Application;

import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Game extends Application {
    Map map;
    StackPane stack;
    Canvas canvas;
    Tank tank;
    Bullet bullet;


    public static void main(String[] args) {
        launch(args);
    }
    private void handleKeyInput (KeyCode code)  {

        switch (code) {
            case SPACE:
                System.out.println("Fire!");
                //tank.fire();

                bullet = new Bullet(tank.bulX, tank.bulY, tank.posTank,map);
                stack.getChildren().add(0,bullet);

                break;
            case RIGHT:
                if(tank.posTank=="RIGHT")
                    tank.moveRight();
                tank.setPosition("RIGHT");
                tank.img = new Image("images/green-tank-right.gif");
                tank.bulImg = new Image("images/missile-right.gif");

                break;
            case LEFT:
                if(tank.posTank=="LEFT")
                    tank.moveLeft();
                tank.setPosition("LEFT");
                tank.img = new Image("images/green-tank-left.gif");
                tank.bulImg = new Image("images/missile-left.gif");

                break;
            case UP:
                if(tank.posTank=="UP")
                    tank.moveUp();

                tank.setPosition("UP");
                tank.img = new Image("images/green-tank-up.gif");
                tank.bulImg = new Image("images/missile-up.gif");
                break;
            case DOWN:
                if(tank.posTank=="DOWN")
                    tank.moveDown();
                tank.setPosition("DOWN");
                tank.img = new Image("images/green-tank-down.gif");
                tank.bulImg = new Image("images/missile-down.gif");
                break;
            default:
                break;

        }
    }

    @Override
    public void start(Stage stage) {
        map = new Map();
        tank = new Tank(map);
        stack = new StackPane();
        stack.setStyle("-fx-background-color: black");
        canvas = map.canvas;
        tank.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
        stack.getChildren().addAll(tank,canvas);
        Scene scene = new Scene(stack,520,520);
        stage.setTitle("tank");
        stage.setScene(scene);
        stage.show();

        tank.requestFocus();

    }

}
