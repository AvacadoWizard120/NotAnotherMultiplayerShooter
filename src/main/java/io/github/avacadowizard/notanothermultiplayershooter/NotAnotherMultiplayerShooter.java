package io.github.avacadowizard.notanothermultiplayershooter;

import com.jme3.app.SimpleApplication;
import com.jme3.renderer.RenderManager;
import com.jme3.system.AppSettings;

public class NotAnotherMultiplayerShooter extends SimpleApplication {

    public static void main(String[] args) {
        NotAnotherMultiplayerShooter app = new NotAnotherMultiplayerShooter();
        AppSettings settings = new AppSettings(true);
        settings.setFullscreen(false);
        settings.setResolution(1920, 1080);
        app.setSettings(settings);
        app.setShowSettings(false); //Settings dialog not supported on Mac
        app.start();
    }


    @Override
    public void simpleInitApp() {
        setDisplayStatView(false);
        setDisplayFps(false);

        stateManager.attach(new SplashScreenState(assetManager, settings));
    }

    @Override
    public void simpleUpdate(float tpf) {
        //add update code here (if any)
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //add render code here (if any)
    }
}