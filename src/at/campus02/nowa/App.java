package at.campus02.nowa;

import at.campus02.nowa.figures.*;

import java.io.PrintStream;
import java.util.Scanner;

public class App {
    private final Scanner input;
    private final PrintStream output;
    private boolean exit = false;
    private int figureNr;
    private Figure figure;
     private int scaleSize;

    // Konstruktor
    // input wird verwendet um Daten vom Benutzer einzulesen (verwendet scanner)
    // output wird verwendet um Text auf der Konsole auszugeben (verwendet sysout)
    public App(Scanner input, PrintStream output){
        this.input = input;
        this.output = output;
    }

    //die Gameloop
    public void Run() {
        initialize();
        printState();

        while(!exit) {
            readUserInput();
            updateState();
            printState();
        }
    }

    private void initialize() {
        //TODO: Initialisierungen hier durchführen
    }

    private void readUserInput() {
        //TODO: Alle Eingaben der Benutzer einlesen
        inputFigure();
    }

    private void updateState() {
        //TODO: Benutzereingaben verarbeiten

        switch (figureNr){
            case 0:
                exit= true;
                break;
            case 1:
                figure = new FigureH(scaleSize);
                break;
            case 2:
                figure= new FigureL(scaleSize);
                break;
            case 3:
                figure=new FigureO(scaleSize);
                break;
            case 4:
                figure=new FigureO2(scaleSize);
                break;
            case 5:
                figure= new FigureI(scaleSize);
                break;
            case 6:
                figure= new FigureMinus(scaleSize);
            default: break;
        }

    }

    private void printState() {
        //TODO: Ausgabe des aktuellen Zustands
        if (exit== true) {
            System.out.println("Goodbye!");}
           else if (figure != null){
            output.println(figure);
        }
        }


    private void inputFigure() {
        // Hier sehen Sie ein Pattern für Benutzereingaben
        // Solange kein gültiger Wert eingegeben wurde, wird die Eingabe wiederholt
        do {
            output.println("Welche Grafik möchten Sie anzeigen (1-6),");
            figureNr = input.nextInt();
            System.out.println("Welche Größe möchten Sie wählen?");
            scaleSize=input.nextInt();
            if (figureNr < 0 || figureNr > 6) {
                output.println("Dies ist keine gültige Grafik!");
            } else {
                break;
            }
        } while (true);

        }

    }



