package rocks_and_diamonds;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainWindow extends Application {

	private Stage appWindow;
	private List<GameState> gameStates;
	private GameState currentState;

	@Override
	public void start(Stage window) throws Exception {

		this.appWindow = window;

		gameStates = new ArrayList<GameState>();
		gameStates.add(new GameState(this, GameStates.ENTER_PLAYER_NAME,
				this.getClass().getResource("/FXML/ENTER_PLAYER_NAME.fxml")));
		gameStates.add(new GameState(this, GameStates.LOADING, this.getClass().getResource("/FXML/LOADING.fxml")));
		gameStates.add(new GameState(this, GameStates.MENU, this.getClass().getResource("/FXML/MENU.fxml")));
		gameStates.add(new GameState(this, GameStates.GAME, this.getClass().getResource("/FXML/GAME.fxml")));
		gameStates.add(new GameState(this, GameStates.QUIT, this.getClass().getResource("/FXML/QUIT.fxml")));

		changeState(GameStates.ENTER_PLAYER_NAME);
		appWindow.getIcons().add(new Image("/Pictures/MainIcon.jpeg"));
		appWindow.setTitle("Rocks & Diamonds by �ukasz & Krzysztof");
		appWindow.setResizable(false);
		appWindow.initStyle(StageStyle.DECORATED);
		appWindow.setX(614);
		appWindow.setY(225);
		appWindow.setOpacity(1);
		appWindow.show();

	}

	public void changeState(GameStates state) {
		for (GameState gameState : gameStates)
			if (gameState.getState() == state)
				currentState = gameState;
		appWindow.setScene(currentState.getScene());
	}

	public void check() {
		System.out.println("MainWindow!");
	}

	public void close() {
		appWindow.close();
	}

	public GameState getGameState(GameStates state) {
		for (GameState gameState : gameStates)
			if (gameState.getState() == state)
				return gameState;
		return null;
	}

	public static void main(String[] args) {
		launch(args);
	}

}// class MainWindow