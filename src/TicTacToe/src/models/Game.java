package TicTacToe.src.models;

import java.util.List;

public class Game {
    public Board board;
    public List<Player> players;
    public List<Move> moves;
    public Player winner;
    public GameState status;
    public int nextPlayerMoveIndex = 0;
    public WinStrategy winStrategy;

    public BotDifficultyLevel difficultyLevel;

    private Game(int boardSize, List<Player> playersList, BotDifficultyLevel difficultyLevel, WinStrategy winStrategy) {
        board = new Board(boardSize);
        players = playersList;
        this.difficultyLevel = difficultyLevel;
        this.winStrategy = winStrategy;
    }


    public PlayerMove getMoveObject(PlayerType playerType, BotDifficultyLevel difficultyLevel) {
        if (playerType == PlayerType.HUMAN) {
            return new Human();
        }
        if (difficultyLevel == BotDifficultyLevel.EASY) return new BotEasy();
        if (difficultyLevel == BotDifficultyLevel.MEDIUM) return new BotMedium();
        if (difficultyLevel == BotDifficultyLevel.HARD) return new BotHard();
        return null;
    }

    public WinningStrategy getWSObject() {
        if (winStrategy == WinStrategy.Row) return new RowCheckStrategy();
        if (winStrategy == WinStrategy.Column) return new ColumnCheckStrategy();
        return null;
    }

    public void makeMove() {
        PlayerMove playerMove = getMoveObject(players.get(nextPlayerMoveIndex).type, difficultyLevel);
        nextPlayerMoveIndex++;
        playerMove.makeMove(this);
        WinningStrategy wsObj = getWSObject();
        wsObj.checkAndUpdateWinner();
    }

    public void displayBoard() {
        this.board.printAllCells();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getStatus() {
        return status;
    }

    public void setStatus(GameState status) {
        this.status = status;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }


    static public class GameBuilder {
        public int boardSize;
        public List<Player> playerList;

        public BotDifficultyLevel difficultyLevel;
        private WinStrategy winStrategy;

        public Game build() throws BoardSizeException {
            if (boardSize < 3) {
                throw new BoardSizeException();
            }
            return new Game(boardSize, playerList, difficultyLevel, winStrategy);
        }

        public GameBuilder setBoardSize(int boardSize) {
            this.boardSize = boardSize;
            return this;
        }

        public GameBuilder setDifficultyLevel(BotDifficultyLevel level) {
            this.difficultyLevel = level;
            return this;
        }

        public GameBuilder setPlayersList(List<Player> playerList) {
            this.playerList = playerList;
            return this;
        }

        public GameBuilder setWinningStrategy(WinStrategy winStrategy) {
            this.winStrategy = winStrategy;
            return this;
        }
    }

    public static GameBuilder getGameBuilder() {
        return new GameBuilder();
    }

}