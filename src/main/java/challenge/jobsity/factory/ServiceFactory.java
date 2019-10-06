package challenge.jobsity.factory;

import challenge.jobsity.service.FileParserService;
import challenge.jobsity.service.FrameParserService;
import challenge.jobsity.service.GameParserService;
import challenge.jobsity.service.implementations.FileParserServiceImp;
import challenge.jobsity.service.implementations.FrameParserServiceImp;
import challenge.jobsity.service.implementations.GameParserServiceImp;

public class ServiceFactory {
    private static ServiceFactory instance = null;
    private FrameParserService frameParserService = null;
    private FileParserService fileParserService = null;
    private GameParserService gameParserService = null;

    public ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        if (instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
    }

    public FrameParserService getFrameParserService() {
        if (frameParserService == null) {
            frameParserService = new FrameParserServiceImp();
        }
        return frameParserService;
    }

    public FileParserService getFileParserService() {
        if (fileParserService == null) {
            fileParserService = new FileParserServiceImp();
        }
        return fileParserService;
    }

    public GameParserService getGameParserService() {
        if (gameParserService == null) {
            gameParserService = new GameParserServiceImp();
        }
        return gameParserService;
    }
}
