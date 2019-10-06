package challenge.jobsity.factory;

import challenge.jobsity.service.FrameService;
import challenge.jobsity.service.implementations.FrameServiceImp;

public class ServiceFactory {
    private static ServiceFactory instance = null;
    private FrameService frameService = null;

    public ServiceFactory() {}

    public static ServiceFactory getInstance(){
        if (instance == null){
            instance = new ServiceFactory();
        }
        return instance;
    }

    public FrameService getFrameService(){
        if (frameService == null){
            frameService = new FrameServiceImp();
        }
        return frameService;
    }
}
