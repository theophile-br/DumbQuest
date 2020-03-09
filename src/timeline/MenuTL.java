package timeline;

import controllers.ControllerMenu;
import javafx.animation.*;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import utils.Config;



public class MenuTL  extends AnimationTimer {
    private ControllerMenu controllerMenu;
    private Timeline backgroundTimeLineAxisX, backgroundTimeLineAxisY, clignotementTimeline ;
    private long lu150ms;
    private ImageView backgroundMenu;
    private VBox vBoxTop, vBoxBottom;
    private Label lblStart;


    public MenuTL(ControllerMenu controllerMenu) {
        this.controllerMenu = controllerMenu;
        this.backgroundMenu = controllerMenu.getViewHandler().getViewMenu().getBackgroundMoving();
        this.vBoxTop = controllerMenu.getViewHandler().getViewMenu().getTopBox();
        this.vBoxBottom = controllerMenu.getViewHandler().getViewMenu().getBottomBox();
        this.lblStart = controllerMenu.getViewHandler().getViewMenu().getLblStartMsg();
        initBackgroundTimelineAxisX();
        initBackgroundTimelineAxisY();
        initClignotementTimeline();
    }

    @Override
    public void handle(long now) {
        if( now - lu150ms >= 150_000_000 ) {
            lu150ms = now;
        }
    }

    public void initBackgroundTimelineAxisX(){
        backgroundTimeLineAxisX = new Timeline();
        backgroundTimeLineAxisX.getKeyFrames().addAll(
                new KeyFrame(new Duration(50000), new KeyValue(backgroundMenu.layoutXProperty(), -Config.gameWindowWidth)));
        backgroundTimeLineAxisX.setCycleCount(Animation.INDEFINITE);
        backgroundTimeLineAxisX.setAutoReverse(true);
        backgroundTimeLineAxisX.play();
    }

    public void initBackgroundTimelineAxisY(){
        backgroundTimeLineAxisY = new Timeline();
        backgroundTimeLineAxisY.getKeyFrames().addAll(
                new KeyFrame(new Duration(20000), new KeyValue(backgroundMenu.layoutYProperty(), backgroundMenu.getFitHeight()-vBoxTop.getPrefHeight()*2)));
        backgroundTimeLineAxisY.setCycleCount(Animation.INDEFINITE);
        backgroundTimeLineAxisY.setAutoReverse(true);
        backgroundTimeLineAxisY.play();
    }

    public void initClignotementTimeline(){
        clignotementTimeline = new Timeline();
        clignotementTimeline.getKeyFrames().addAll(
                new KeyFrame(new Duration(20000), new KeyValue(lblStart.opacityProperty(), 0)));
        clignotementTimeline.setCycleCount(Animation.INDEFINITE);
        clignotementTimeline.setAutoReverse(true);
        clignotementTimeline.play();
    }

    public void stopAll(){
        backgroundTimeLineAxisX.stop();
        backgroundTimeLineAxisY.stop();
        clignotementTimeline.stop();

    }
}
