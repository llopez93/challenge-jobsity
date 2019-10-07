package challenge.jobsity;

import challenge.jobsity.exception.InvalidEntryFormatException;
import challenge.jobsity.factory.ServiceFactory;
import challenge.jobsity.model.Game;
import challenge.jobsity.model.parser.DataEntry;
import challenge.jobsity.service.FileParserService;
import challenge.jobsity.service.GameParserService;
import challenge.jobsity.service.ScoreService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private FileParserService fileParserService;
    private GameParserService gameParserService;
    private ScoreService scoreService;

    public App() {
        this.fileParserService = ServiceFactory.getInstance().getFileParserService();
        this.gameParserService = ServiceFactory.getInstance().getGameParserService();
        this.scoreService = ServiceFactory.getInstance().getScoreService();
    }

    public static void main(String[] args) {
        App app = new App();
        File scoreFile = app.readFile();
        ArrayList<DataEntry> entries;
        try {
            entries = new ArrayList(app.getFileParserService().parseFile(scoreFile));
            Game game = app.getGameParserService().parseGame(entries);
            System.out.println();
            app.getScoreService().printGameScore(game);
        } catch (InvalidEntryFormatException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File readFile() {
        while (true) {
            System.out.println("Enter file path: ");
            Scanner in = new Scanner(System.in);
            String filePath = in.nextLine();

            File file = new File(filePath);
            if (file.exists() && !file.isDirectory() && filePath.endsWith(".txt"))
                return file;
            else
                System.out.println("The path entered is invalid, please retry.");
        }
    }

    public FileParserService getFileParserService() {
        return fileParserService;
    }

    public GameParserService getGameParserService() {
        return gameParserService;
    }

    public ScoreService getScoreService() {
        return scoreService;
    }
}
