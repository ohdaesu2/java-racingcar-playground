package racingCar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarServiceTest {

    private static Integer MINIMUM_NUMBER_TO_MOVE = 4;

    CarService carService = new CarService();

    @Test
    public void 자동차_이름은_1자에서_5자로_설정합니다(){
        Car car_0 = new Car("");
        Car car_6 = new Car("ohdaes");
        assertThatThrownBy(() -> carService.validateCarName(car_0))
                .isInstanceOf(CarNameException.class);
        assertThatThrownBy(() -> carService.validateCarName(car_6))
                .isInstanceOf(CarNameException.class);
    }

    @Test
    public void 최소숫자_이상이면_MOVE_STATUS를_받습니다() {
        StatusEnum status = carService.getStatus(MINIMUM_NUMBER_TO_MOVE);
        assertThat(status).isEqualTo(StatusEnum.MOVE);
    }

    @Test
    public void 최소숫자_미만이면_MOVE_STATUS를_받습니다() {
        StatusEnum status = carService.getStatus(MINIMUM_NUMBER_TO_MOVE-1);
        assertThat(status).isEqualTo(StatusEnum.STOP);
    }

}
