import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum RomanDigits {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7),
    VIII(8), IX(9), X(10), XL(40), L(50), XC(90), C(100);

    private int value;

    RomanDigits(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    // Roman.valueOf("X").toInt();

    public static List<RomanDigits> sortAndReversDigits() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanDigits r) -> r.value).reversed())
                .collect(Collectors.toList());
    }

}
