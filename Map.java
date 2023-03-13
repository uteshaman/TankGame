package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

public class Map {
    int size;
    int x;
    int y;
    public int bulY=250;
    public int bulX=250;
    StackPane stack;
    Canvas canvas;
    GraphicsContext gc;
    char[][] table =   {{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                        {'0', '0', '0', '0', 's', '0', 'k', '0', 'w', '0', '0', '0', '0'},
                        {'0', '0', 'w', 'w', '0', 's', '0', 'k', 'k', '0', '0', '0', '0'},
                        {'s', '0', 'w', '0', 'w', 's', 'k', '0', '0', 's', '0', 's', 's'},
                        {'0', '0', '0', '0', '0', '0', 'v', 'v', '0', '0', '0', '0', '0'},
                        {'w', 's', '0', '0', '0', '0', '0', 's', 's', 'v', 'v', '0', 's'},
                        {'0', '0', '0', 'w', 's', '0', '0', '0', 'w', '0', '0', 'v', 'v'},
                        {'0', 'w', '0', '0', 'v', 'w', 'k', '0', 'w', 's', '0', '0', '0'},
                        {'0', '0', '0', '0', '0', 'w', '0', 's', 'v', 'v', '0', 'v', '0'},
                        {'k', 's', '0', 's', '0', 'k', '0', '0', '0', 's', '0', 'w', 'w'},
                        {'0', '0', '0', '0', '0', '0', '0', 'k', '0', '0', 'v', '0', 's'},
                        {'w', '0', 'w', '0', '0', 'k', 'k', 'k', 'k', '0', '0', '0', 'v'},
                        {'0', '0', '0', '0', '0', 'k', 'h', 'k', '0', '0', '0', '0', '0'}};
    Map(){
        print();

    }
    void print(){
        canvas = new Canvas(520,520);
        gc = canvas.getGraphicsContext2D();
        stack = new StackPane();
        stack.setStyle("-fx-background-color: black");
        for(int i=0; i<13; i++){
            for(int j=0; j<13; j++){
                if(table[i][j] == 's'){
                    Image img = new Image("images/stone.gif");
                    gc.drawImage(img,j*40+20,i*40+20);
                    gc.drawImage(img, j*40+20,i*40);
                    gc.drawImage(img, j*40,i*40+20);
                    gc.drawImage(img, j*40,i*40);

                }
                else if(table[i][j] == 'w'){
                    Image img = new Image("images/grass.gif");
                    gc.drawImage(img,j*40+20,i*40+20);
                    gc.drawImage(img, j*40+20,i*40);
                    gc.drawImage(img, j*40,i*40+20);
                    gc.drawImage(img, j*40,i*40);

                }
                else if(table[i][j] == 'k'){
                    Image img = new Image("images/brick.gif");
                    gc.drawImage(img,j*40+20,i*40+20);
                    gc.drawImage(img, j*40+20,i*40);
                    gc.drawImage(img, j*40,i*40+20);
                    gc.drawImage(img, j*40,i*40);

                }
                else if(table[i][j] == 'v'){
                    Image img = new Image("images/water.gif");
                    gc.drawImage(img,j*40+20,i*40+20);
                    gc.drawImage(img, j*40+20,i*40);
                    gc.drawImage(img, j*40,i*40+20);
                    gc.drawImage(img, j*40,i*40);

                }
                else if(table[i][j] == 'h'){
                    Image img = new Image("images/home.gif");
                    gc.drawImage(img,j*40+20,i*40+20);
                    gc.drawImage(img, j*40+20,i*40);
                    gc.drawImage(img, j*40,i*40+20);
                    gc.drawImage(img, j*40,i*40);

                }

            }


        }
        stack.getChildren().add(canvas);
    }

}
