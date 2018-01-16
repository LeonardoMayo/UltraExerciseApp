package Desktop;

import Desktop.controller.*;

/**
 * Created by Jan on 17.01.2018.
 */
public class DB {

    public DB() {
    }

    /*
    Start of different instances of stuff
     */
    private RootController rootController;
    private FrameController frameController;
    private PlanController planController;
    /*
    End of different instances of stuff
     */

    /*
    Start of getters and setters
     */

    public RootController getRootController() {
        return rootController;
    }

    public void setRootController(RootController rootController) {
        this.rootController = rootController;
    }

    public FrameController getFrameController() {
        return frameController;
    }

    public void setFrameController(FrameController frameController) {
        this.frameController = frameController;
    }

    public PlanController getPlanController() {
        return planController;
    }

    public void setPlanController(PlanController planController) {
        this.planController = planController;
    }
}
