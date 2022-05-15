package tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    public void 특정값_이상이면_자동차가_움직입니다() {
        Car car = new Car("benz");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 특정값_미만이면_자동차가_움직이지_않습니다() {
        Car car = new Car("benz");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);

    }

    @Test
    public void 자동차_이름은_5자를_이하이어야_없습니다() {
        assertThatThrownBy(() -> new Car("toyota"))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void 자동차_이름은_1자_이상이어야_합니다() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalStateException.class);
    }
}
