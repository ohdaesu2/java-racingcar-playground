package stringCalculate;

import org.junit.jupiter.api.Test;
import stringCalculate.StringAddCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculateTest {

    StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @Test
    public void 빈문자나_null값일때_0을반환합니다() {
        int empty_result = stringAddCalculator.splitAndSum(null);
        int null_result = stringAddCalculator.splitAndSum("");
        assertThat(empty_result).isEqualTo(0);
        assertThat(null_result).isEqualTo(0);
    }

    @Test
    public void 숫자가_하나일때_값을반환합니다() {
        int result = stringAddCalculator.splitAndSum("10");
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void 쉼표가_있으면_숫자를_구분합니다() {
        int result = stringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 쉼표또는_콜론이_있으면_숫자를_구분합니다() {
        int result = stringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void custom() {
        int result = stringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void negative() {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

}
