package io.github.avacadowizard.notanothermultiplayershooter;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.BaseAppState;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;
import com.simsilica.lemur.*;
import com.simsilica.lemur.component.QuadBackgroundComponent;
import com.simsilica.lemur.style.ElementId;

public class MainMenuState extends BaseAppState {

    @Override
    protected void initialize(Application app) {
        GuiGlobals.initialize(app);
        Node guiNode = ((SimpleApplication) app).getGuiNode();

        Container mainContainer = new Container();
        mainContainer.setBackground(new QuadBackgroundComponent(ColorRGBA.Black));

        Label titleLabel = mainContainer.addChild(new Label("Not Another Multiplayer Shooter", new ElementId("title")));
        titleLabel.setFontSize(48);
        titleLabel.setInsets(new Insets3f(20, 20, 20, 20));
        titleLabel.setTextHAlignment(HAlignment.Center);

        Button startButton = mainContainer.addChild(new Button("Start Game"));
        startButton.addClickCommands(source -> {
            // Start the game or switch to the game state
            System.out.println("Starting game..."); // Placeholder action
        });

        Button quitButton = mainContainer.addChild(new Button("Quit Game"));
        quitButton.addClickCommands(source -> {
            app.stop();
        });

        mainContainer.setLocalTranslation(100, app.getCamera().getHeight() - 100, 0);
        mainContainer.updateLogicalState(0);
        mainContainer.updateGeometricState();
        guiNode.attachChild(mainContainer);
    }

    @Override
    protected void cleanup(Application application) {

    }

    @Override
    protected void onEnable() {

    }

    @Override
    protected void onDisable() {

    }
}