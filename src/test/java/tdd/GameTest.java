package tdd;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    Game game = new Game();

    @Test
    public void 쉼표를_기준으로_차_이름을_분리합니다() {
        String inputString = "benz, audi,jeep";
        List<Car> carsList = game.splitInputString(inputString);

        assertThat(carsList).contains(new Car("benz"));
        assertThat(carsList).contains(new Car("audi"));
        assertThat(carsList).contains(new Car("jeep"));
    }

}