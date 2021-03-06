package rocks_and_diamonds;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import rocks_and_diamonds.controllers.Controller;

public class GameState implements Comparable<GameState> {
	private MainWindow parent;
	private GameStates stateName;
	private StackPane stackPane;
	private Scene scene;

	public GameState(MainWindow parent, GameStates state, URL fxmlPathForScene ) throws IOException {
		this.parent = parent;
		this.stateName = state;
		FXMLLoader loader = new FXMLLoader(fxmlPathForScene);
		stackPane = loader.load();
		Controller controller = loader.getController();
		controller.setParent(this);
		scene = new Scene(stackPane);
	}

	public Scene getScene() {
		return scene;
	}

	public GameStates getState() {
		return stateName;
	}
	
	public MainWindow mainWindow() {
		return parent;
	}

	@Override
	public int compareTo(GameState o) {
		if (stateName == o.getState())
			return 0;
		else
			return 1;
	}

}// class GameState
