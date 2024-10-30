import graphics.Canvas;

import java.awt.Color;
import java.util.Scanner;

public class Program {
    // Canvas GUI instance providing the drawing area on which to plot the functions
    private static Canvas canvas;

    public static void main(String[] args) {
        
        // Create the canvas instance, set its range to x:[-360, 360] and y:[-240, 240] then 
        // open it on the screen. Use canvas.plot(pX, pY) to plot a point at the (pX, pY) coords
        canvas = new Canvas();
        canvas.setRange(-360, -240, 360, 240);
        canvas.open();
        Function sine = new Function() {
            public double calc(double x) {
                return (200 * Math.sin(Math.PI * x / 360));
            }
            public Color getColor() {
                return Color.RED;
            }
        };
    	Function quadratic = new Function() {
            public double calc(double x) {
                return (x - 200) * (x + 200) / 250;
            }
            public Color getColor() {
                return Color.ORANGE;
            }
        };
        Function log = new Function() {
            public double calc(double x) {
                return (20 * Math.log10(x));
            }
            public Color getColor() {
                return Color.YELLOW;
            }
        };
        Function cubic = new Function() {
            public double calc(double x) {
                return x * x * x / 200000;
            }
            public Color getColor() {
                return Color.GREEN;
            }
        };
        Function step = new Function() {
            public double calc(double x) {
                return (x < -100 ? -100 : (x > 100 ? 100 : x));
            }
            public Color getColor() {
                return Color.BLUE;
            }
        };
        Scanner console = new Scanner(System.in);
        // Pause and close the canvas then terminate the program.
        boolean running = true;
        while(running) {
            String input = console.next().substring(0, 1);
            switch(input) {
                case "S":
                    plotFunctions(sine);
                    break;
                case "Q":
                    plotFunctions(quadratic);
                    break;
                case "L":
                    plotFunctions(log);
                    break;
                case "C":
                    plotFunctions(cubic);
                    break;
                case "T":
                    plotFunctions(step);
                    break;
                default:
                    running = false;
                    break;
            }
        }
        canvas.close();
        console.close();
    }
    public static void plotFunctions(Function... functions) {
    	for(Function function : functions) {
            canvas.setColor(function.getColor());
    		for(int i = canvas.getXMin(); i <= canvas.getXMax(); i++) {
    			canvas.plot(i, (int) function.calc(i));
    		}
            canvas.pause();
    	}
    }
}
