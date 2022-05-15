import racingCar.GameService;
import tdd.Car;
import tdd.Cars;
import tdd.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCarApplication {
    /*
    그냥 구현
     */
//    public static void main(String[] args) throws Exception{
//
//        GameService gameService = new GameService();
//
//        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
//        Scanner scanner = new Scanner(System.in);
//        String inputString = scanner.nextLine();
//        /*
//        자동차 생성
//         */
//        ArrayList<Car> cars = gameService.generateCarList(inputString);
//        System.out.println(cars);
//
//        System.out.println("시도할 횟수 몇회인가요?");
//        String inputRound = scanner.nextLine();
//
//        System.out.println("실행 결과");
//        /*
//        실행 결과
//         */
//        gameService.playGame(Integer.parseInt(inputRound), cars);
//    }
    /*
    tdd
     */
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        /*
        자동차 생성
         */
        Game game = new Game();
        List<Car> carList = game.splitInputString(inputString);

        /*
        몇번 반복할건지 결정
         */
        System.out.println("시도할 횟수 몇회인가요?");
        String inputRoundString = scanner.nextLine();
        int inputRound = Integer.parseInt(inputRoundString);

        System.out.println("실행 결과");
        List<Car> winners = game.playGame(carList, inputRound);
        Cars cars = new Cars(winners);
        System.out.println(cars+ "가 최종우승 하였습니다!");
    }
}
