 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marchingsquare;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class MarchingSquares extends Application {
    @Override
    public void start(Stage stage){
        
        // Calculando el número de celdas
        int[][] celdas;
        final int separacion = 20;
        int colums = 600 / separacion + 1;
        int rows = 400 / separacion + 1;
        celdas = new int[colums][rows];
        
        // Asignando valores de 0 o 1 a cada celda
        for (int i = 0; i < colums; i++) {
            for (int j = 0; j < rows; j++) {
                celdas[i][j] = new Random().nextInt(2);
            }  
        }
        
        Group group = new Group();
        
        for (int i = 0; i < colums; i++) {
            for (int j = 0; j < rows; j++) {
                if(celdas[i][j] == 1){
                   group.getChildren().add(new Circle(i*separacion, j*separacion, separacion*0.2, Color.BLACK));
                }else{
                   group.getChildren().add(new Circle(i*separacion, j*separacion, separacion*0.2, Color.WHITE)); 
                }
            }
        }
        
        for (int i = 0; i < colums; i++) {
            for (int j = 0; j < rows; j++) {
                if(celdas[i][j] == 1){
                   group.getChildren().add(new Circle(i*separacion, j*separacion, separacion*0.2, Color.BLACK));
                }else{
                   group.getChildren().add(new Circle(i*separacion, j*separacion, separacion*0.2, Color.WHITE)); 
                }
            }
        }
        
        for (int i = 0; i < colums - 1; i++) {
            for (int j = 0; j < rows - 1; j++) {
                Line line;
                float x = i * separacion;
                float y = j * separacion;
                Vector a = new Vector((float)(x + separacion*0.5) , y);
                Vector b = new Vector(x + separacion              , (float) (y + separacion*0.5));
                Vector c = new Vector((float) (x + separacion*0.5), y + separacion);
                Vector d = new Vector(x                           , (float) (y + separacion*0.5));
                
                int state = getState(celdas[i][j], celdas[i+1][j], celdas[i+1][j+1], celdas[i][j+1]);
                switch (state) {
                    case 1:
                        line = new Line(c.x,c.y,d.x,d.y);
                        line.setStroke(Color.WHITE);
                        group.getChildren().add(line);
                        break;
                    case 2:
                        line = new Line(b.x,b.y,c.x,c.y);
                        line.setStroke(Color.WHITE);
                        group.getChildren().add(line);
                        break;
                    case 3:
                        line = new Line(d.x,d.y,b.x,b.y);
                        line.setStroke(Color.WHITE);
                        group.getChildren().add(line);
                        break;
                    case 4:
                        line = new Line(a.x,a.y,b.x,b.y);
                        line.setStroke(Color.WHITE);
                        group.getChildren().add(line);
                        break;
                    case 5:
                        line = new Line(a.x,a.y,d.x,d.y);
                        line.setStroke(Color.WHITE);
                        group.getChildren().add(line);
                        line = new Line(b.x,b.y,c.x,c.y);
                        line.setStroke(Color.WHITE);
                        group.getChildren().add(line);
                        break;
                    case 6:
                        line = new Line(a.x,a.y,c.x,c.y);
                        line.setStroke(Color.WHITE);
                        group.getChildren().add(line);
                        break;
                    case 7:
                        line = new Line(a.x,a.y,d.x,d.y);
                        line.setStroke(Color.WHITE);
                        group.getChildren().add(line);
                        break;
                    case 8:
                        line = new Line(a.x,a.y,d.x,d.y);
                        line.setStroke(Color.WHITE);
                        group.getChildren().add(line);
                        break;
                    case 9:
                        line = new Line(a.x,a.y,c.x,c.y);
                        line.setStroke(Color.WHITE);
                        group.getChildren().add(line);
                        break;
                    case 10:
                        line = new Line(a.x,a.y,b.x,b.y);
                        line.setStroke(Color.WHITE);
                        group.getChildren().add(line);
                        line = new Line(c.x,c.y,d.x,d.y);
                        line.setStroke(Color.WHITE);
                        group.getChildren().add(line);
                        break;
                    case 11:
                        line = new Line(a.x,a.y,b.x,b.y);
                        line.setStroke(Color.WHITE);
                        group.getChildren().add(line);
                        break;
                    case 12:
                        line = new Line(b.x,b.y,d.x,d.y);
                        line.setStroke(Color.WHITE);
                        group.getChildren().add(line);
                        break;
                    case 13:
                        line = new Line(b.x,b.y,c.x,c.y);
                        line.setStroke(Color.WHITE);
                        group.getChildren().add(line);
                        break;
                    case 14:
                        line = new Line(c.x,c.y,d.x,d.y);
                        line.setStroke(Color.WHITE);
                        group.getChildren().add(line);
                        break;
                }
            }
        }
        
        // Ajustes de la ventana
        Scene scene = new Scene(group,600,400);
        scene.setFill(Color.GRAY); 
        stage.setTitle("Marching Squares");
        stage.setScene(scene);  
        stage.show();
    }
    
    private int getState(int a, int b, int c, int d){
        return a * 8 + b * 4 + c * 2 + d * 1;
    }
    public static void main(String args[]){
        // launch the application
        launch();
    }
}

