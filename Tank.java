package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Tank extends Pane {
    private int x = 0;
    private int y = 0;
    private Timeline animation;
    private GraphicsContext gc;
    private Canvas canvas;
    private ImageView imgV;
    Image img;
    private Map m;
    private char table[][];

    //Position pos;
    String posTank = "RIGHT";
    Image bulImg;
    int bulX;
    int bulY;
    Bullet bull;

    Tank(){

    }


    Tank(Map map) {
        canvas = new Canvas(520,520);
        gc = canvas.getGraphicsContext2D();
        img = new Image("images/green-tank-right.gif");
        m = map;
        table = m.table;
        drawTank();

        animation = new Timeline(
                new KeyFrame(Duration.millis(64),
                        e -> drawTank()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

    }

    private void drawTank() {
        getChildren().clear();

        imgV = new ImageView(img);
        imgV.setX(x*40);
        imgV.setY(y*40);
        bulX = x*40;
        bulY = y*40;


        getChildren().addAll(imgV);
    }


    public void moveRight() {
        if(x+1<13 && (table[y][x+1]=='0' || table[y][x+1]=='w') && x+1>=0 ){

            x++;
        }
    }

    public void moveLeft() {
        if(x-1<13 && (table[y][x-1]=='0' || table[y][x-1]=='w') && x-1>=0){

            x--;
        }
    }

    public void moveUp() {
        if(y-1<13 && (table[y-1][x]=='0' || table[y-1][x]=='w') && y-1>=0 ){

            y--;

        }
    }

    public void moveDown() {
        if(y+1<13 && (table[y+1][x]=='0' || table[y+1][x]=='w') && y+1>=0 ){

            y++;
        }
    }

    void setMap(){

    }
    int getY(){
        return this.y;
    }
    int getX(){
        return this.x;
    }

    void setPosition(String pos){
        this.posTank = pos;
    }
    public void fire()  {
        m.bulX =x + 10;
        m.bulY =y + 10;



        while(bulX>0 && bulX < 520 && bulY> 0 && bulY<520){
            switch (posTank){
                case "UP":
                    m.bulX--;

                case "DOWN":
                    m.bulX++;

                case "LEFT":
                    m.bulY--;

                case "RIGHT":
                    m.bulY++;

            }
            getChildren().add(bull);


        }

    }
    void destoyBullet(){
        m.bulX =-100;
        m.bulY =-100;
    }

}
