package sample;

import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Bullet extends Pane {
    private char table[][];
    private Image tmg;
    int dur;
    protected int lastX;
    protected int lastY;

    protected int health = 1;
    private static final String MISSILE_UP = "missile-up.gif";
    private static final String MISSILE_DOWN = "missile-down.gif";
    private static final String MISSILE_LEFT = "missile-left.gif";
    private static final String MISSILE_RIGHT = "missile-right.gif";
    ImageView images;


    Bullet(int posTanx, int posTany, String pos, Map map){


        PathTransition pathTransition = new PathTransition();
        //pathTransition.setRate(0.5);


        switch (pos){
            case "UP":
                images = new ImageView("images/" + MISSILE_UP);
                for(int i=posTany/40; i>0; i--){
                    if(map.table[i][posTanx/40] == 's' || map.table[i][posTanx/40] == 'k' ){
                        lastY = (i*40-5);
                        break;
                    }
                    else{
                        lastY=-45;
                    }
                }
                dur = Math.abs((lastY-posTany)*5);
                pathTransition.setDuration(Duration.millis(dur));
                pathTransition.setNode(images);
                pathTransition.setPath(new Line(posTanx+20, posTany+20, posTanx+20,lastY+40));;
                break;
            case "DOWN":
                images = new ImageView("images/" + MISSILE_DOWN);
                for(int i=posTany/40; i<map.table.length; i++){
                    if(map.table[i][posTanx/40] == 's' || map.table[i][posTanx/40] == 'k'){
                        lastY = (i*40+5);
                        break;
                    }
                    else{
                        lastY=530;

                    }
                }
                dur = Math.abs((lastY-posTany)*5);
                pathTransition.setDuration(Duration.millis(dur));
                pathTransition.setNode(images);
                pathTransition.setPath(new Line(posTanx+20, posTany+20, posTanx+20,lastY));
                break;
            case "LEFT":
                images = new ImageView("images/" + MISSILE_LEFT);
                for(int i=posTanx/40; i>=0; i--){
                    if(map.table[posTany/40][i] == 's' || map.table[posTany/40][i] == 'k' ){
                        lastX = (i*40+15);
                        break;
                    }
                    else{
                        lastX=-5;
                    }
                }
                dur = Math.abs((lastX-posTanx)*5);
                pathTransition.setDuration(Duration.millis(dur));
                pathTransition.setNode(images);
                pathTransition.setPath(new Line(posTanx+20, posTany+20, lastX,posTany+20));
                break;
            case "RIGHT":
                images = new ImageView("images/" + MISSILE_RIGHT);
                pathTransition.setNode(images);
                for(int i=posTanx/40; i<map.table.length; i++){
                    if(map.table[posTany/40][i] == 's' || map.table[posTany/40][i] == 'k'){
                        lastX = (i*40+20);
                        break;
                    }
                    else{
                        lastX=525;
                    }
                }
                dur = Math.abs((lastX-posTanx)*5);
                pathTransition.setDuration(Duration.millis(dur));


                pathTransition.setPath(new Line(posTanx+20, posTany+20, lastX,posTany+20));
                break;


        }
        pathTransition.play();
        getChildren().add(images);

    }
}
