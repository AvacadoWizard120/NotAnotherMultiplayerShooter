package io.github.avacadowizard.notanothermultiplayershooter;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Quad;
import com.jme3.system.AppSettings;
import com.jme3.texture.Texture;

public class SplashScreenState extends AbstractAppState {

    private SimpleApplication app;
    private final AssetManager assetManager;
    private final AppSettings settings;
    private Geometry splashScreen;
    private long startTime;
    private int screenWidth;
    private int screenHeight;

    public SplashScreenState(AssetManager assetManager, AppSettings settings) {
        this.assetManager = assetManager;
        this.settings = settings;
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication) app;

        screenWidth = settings.getWidth();
        screenHeight = settings.getHeight();

        Texture splashTexture = assetManager.loadTexture("Textures/SplashScreen.png");

        Quad quad = new Quad(screenWidth, screenHeight);
        splashScreen = new Geometry("SplashScreen", quad);

        Material splashMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        splashMaterial.setTexture("ColorMap", splashTexture);
        splashScreen.setMaterial(splashMaterial);

        ((SimpleApplication) app).getGuiNode().attachChild(splashScreen);

        splashScreen.setLocalTranslation(screenWidth / 2f, screenHeight / 2f, 0);

        startTime = System.currentTimeMillis();
    }

    @Override
    public void update(float tpf) {
        // 3 seconds
        long duration = 3000;
        float t = (System.currentTimeMillis() - startTime) / (float) duration;
        if (t >= 1.0f) {
            t = 1.0f;
            // Once the animation is done, remove the splash screen
            if (app.getStateManager() != null) {
                app.getStateManager().detach(this);
                app.getStateManager().attach(new MainMenuState());
            }
        }

        // Interpolate size from 0.5 to 1.5 times the screen width and height
        float startScale = 0.5f;
        float endScale = 1.5f;
        float scale = startScale + t * (endScale - startScale);
        splashScreen.setLocalScale(scale, scale, 1);

        // Center the image on the screen
        float width = screenWidth * scale;
        float height = screenHeight * scale;
        splashScreen.setLocalTranslation((screenWidth - width) / 2,
                (screenHeight - height) / 2, 0);
    }

    @Override
    public void cleanup() {
        if (splashScreen != null && app.getGuiNode() != null) {
            app.getGuiNode().detachChild(splashScreen);
        }
    }
}