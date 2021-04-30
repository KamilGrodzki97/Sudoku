package sudoku_c;

import javafx.application.Application;
import javafx.stage.Stage;
import sudoku_c.build.SudokuBuildLogic;
import sudoku_c.ui.IUserInterfaceContract;
import sudoku_c.ui.UserInterfaceImpl;

import java.io.IOException;

public class App extends Application {

    private IUserInterfaceContract.View uiImpl;

    @Override
    public void start(Stage primaryStage) throws IOException {
        uiImpl = new UserInterfaceImpl(primaryStage);

        try {
            SudokuBuildLogic.build(uiImpl);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
