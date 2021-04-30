package sudoku_c.build;

import sudoku_c.computationLogic.GameLogic;
import sudoku_c.domain.IStorage;
import sudoku_c.domain.SudokuGame;
import sudoku_c.persistance.LocalStorageImpl;
import sudoku_c.ui.IUserInterfaceContract;
import sudoku_c.ui.logic.ControlLogic;

import java.io.IOException;

public class SudokuBuildLogic {

    public static void build(IUserInterfaceContract.View userInterface) throws IOException {
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl();

        try {
            initialState = storage.getGameData();
        } catch (IOException e) {

            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);
        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}
