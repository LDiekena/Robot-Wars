import Controller.*;
import Model.*;
import View.*;

public class startGame {

    public static void main(String[] args) {
        //View
        GameView gameView = new GameView();
        RobotView robotView = new RobotView();
        KIView kiView = new KIView();
        PlayerView playerView = new PlayerView();
        GameboardView gameboardView = new GameboardView();

        //Controller
        GameController gameController = new GameController();
        GameboardController gameboardController = new GameboardController();
        RobotController robotController = new RobotController();
        PlayerController playerController = new PlayerController();
        KIController kiController = new KIController();
        BarrierController barrierController = new BarrierController();

        //Model
        GameboardModel gameboard = new GameboardModel(10,15);
        GameModel game = new GameModel(' ',' ', true, false);
        RobotModel bot1 = new RobotModel("Bot 1", gameView.red + "¥" + gameView.farbReset,
                0, 7, 2, 2, 3, 1, 1, 3, 1, 35);
        RobotModel robot = new RobotModel(" ", " ", 10, 1, 1, 1, 1, 1, 1, 1, 1, 5);
        KIModel enemy = new KIModel("Bot 1",gameboardController.randomNumberRow(), gameboardController.randomNumberColumn() , "easy", bot1);
        PlayerModel player = new PlayerModel("", gameboardController.randomNumberRow(), gameboardController.randomNumberColumn(),0,0, robot);

        //Start Intro
        gameView.displayIntroScreen();

        //Namensgebung
        String name = gameView.askPlayerName();
        player.setName(name);

        //Avatarauswahl
        int avatarChoice = gameView.askAvatarChoice(name);

        while (!gameController.isAvatarChoiceValid(avatarChoice)) {
            gameView.incorrectInputAvatar();
        }

        if(avatarChoice == 1) {
                robot.setName("Cyannator");
                robot.setSymbol(gameView.cyan + "§" + gameView.farbReset);
        } else if(avatarChoice == 2) {
            robot.setName("Purplenator");
            robot.setSymbol(gameView.purple + "∆" + gameView.farbReset);
        } else {
            gameView.printErrorSetAvater();
        }

        gameView.confirmAvatarChoice(player, enemy);
        //Ende Intro


        //Start Verteilung von Skillpunkten
        robotView.printStartSkillpointDistributionMessage(player);
        robotView.printStats(player.getRobotModel());

        while (player.getRobotModel().getSkillpoints() > 0) {
            robotController.changeStats(player.getRobotModel(), robotView, robotController);
        }

        player.getRobotModel().setHealth(player.getRobotModel().getHealth() * player.getRobotModel().getLife());
        //Ende Verteilung Skillpunkte


        //Start Spielfeldinitialisierung
        gameboardView.printPrepareMessage();
        gameboardController.fillStartboard(gameboard.getGameboard());
        gameboardController.placeBarrier(gameboard, barrierController, gameView);
        gameboardController.placeRobots(player, enemy, gameboard.getGameboard());
        gameboardView.printGameboard(gameboard.getGameboard());

        playerView.printPlayerStartpositionText(player);
        kiView.displayEnemyPositionText(enemy);
        //Ende Spielfeldinitialisierung


        //Start Game
        gameController.gameRound(player, enemy, gameboard, game, gameboardView, gameView, playerView, kiView, kiController, playerController);
        //Ende Game
    }
}

