package sample;

import java.io.BufferedReader;
import java.io.FileReader;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {
    //Hello
    //hep
    int x = 75;
    int w = 75;
    int h = 75;
    int y = 75;
    Canvas canvas = new Canvas(500, 500);

    void write(String txt, int x, int y) {
        canvas.getGraphicsContext2D().strokeText(txt, x, y);
    }

    void fill(Color c) {
        canvas.getGraphicsContext2D().setFill(c);
    }

    void stroke(Color c) {
        canvas.getGraphicsContext2D().setStroke(c);
    }

    void line(int x, int y, int w, int h) {
        canvas.getGraphicsContext2D().strokeLine(x, y, w, h);
    }

    void rect(int x, int y, int w, int h) {
        canvas.getGraphicsContext2D().fillRect(x, y, w, h);
    }

    void ellipse(int x, int y, int w, int h) {
        canvas.getGraphicsContext2D().fillOval(x, y, w, h);
    }

    public void start(Stage primaryStage) {

        AnchorPane root = new AnchorPane();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 500, 500);
        draw();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void draw() {
        fill(Color.BLACK);
        line(50, 10, 50, 420);
        line(30, 400, 500, 400);
        write("°C", 5, 250);
        write("Time", 200, 450);
        String tempString = "0";
        String timeString = "0";
        for (int i = 0; i < 14; i++) {

            int foo = Integer.parseInt(tempString);
            foo = foo + 5;
            String mySaved = String.valueOf(foo);
            tempString = mySaved;
            write(tempString, x, 415);
            ellipse(70, 95, 10, 10);

            int ts = Integer.parseInt(timeString);
            ts = ts + 5;
            String timeSaved = String.valueOf(ts);
            timeString = timeSaved;
            write(timeString, 30, 450 - h);
            line(x, 50, w, 400);
            x = x + 25;
            w = w + 25;
            line(50, y, 400, h);
            y = y + 25;
            h = h + 25;

        }

    }


    public static void main(String[] args) throws Exception {
        FileReader file = new FileReader("/Users/rasmuslohse/Documents/Test.txt");
        BufferedReader reader = new BufferedReader(file);
        String text = "";
        String st = reader.readLine();
        while (st != null) {
            text += st;
            st = reader.readLine();
        }
        System.out.println(text);
        launch(args);
    }
}
