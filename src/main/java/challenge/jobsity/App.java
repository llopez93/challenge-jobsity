package challenge.jobsity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        App app = new App();
        app.readFile();
    }

    private Stream<String> readFile() {
        boolean validInput = false;

        while ( !validInput ){
            System.out.println("Ingrese la ruta del archivo: ");
            Scanner in = new Scanner(System.in);
            String filePath = in.nextLine();
            try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
                return lines;
            } catch (IOException e) {
                System.out.println("La ruta ingresada no es correcta, por favot vuelva a ingresarla");
                validInput = false;
            }
        }

        return null;

    }
}
