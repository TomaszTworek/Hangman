public class Judge {
    private GameState gameState;

    public Judge(GameState gameState) {
        this.gameState = gameState;
    }

    boolean isPlayerWin() {
        for (char x: gameState.getGuessWord().toCharArray()) {
            if (!gameState.isCharAlreadyUsed(x)){
                return false;
            }
        }
        return true;
    }




}