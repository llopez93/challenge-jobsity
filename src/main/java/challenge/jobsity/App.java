package challenge.jobsity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class App 
{
    public static void main( String[] args ) {
        App app = new App();
        app.readFile();
    }

    private Stream<String> readFile() {

        while ( true ){
            System.out.println("Enter file path: ");
            Scanner in = new Scanner(System.in);
            String filePath = in.nextLine();
            try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
                return lines;
            } catch (IOException e) {
                System.out.println("The path entered is invalid, please retry.");
            }
        }
    }
}
