import java.util.TreeMap;

public class Parser {
    private final static TreeMap<Integer, String> ARABIC_ROMAN_FOR_CALCULATE = new TreeMap<>();

    Parser() {
    }

    static {

        ARABIC_ROMAN_FOR_CALCULATE.put(1000, "M");
        ARABIC_ROMAN_FOR_CALCULATE.put(900, "CM");
        ARABIC_ROMAN_FOR_CALCULATE.put(500, "D");
        ARABIC_ROMAN_FOR_CALCULATE.put(400, "CD");
        ARABIC_ROMAN_FOR_CALCULATE.put(100, "C");
        ARABIC_ROMAN_FOR_CALCULATE.put(90, "XC");
        ARABIC_ROMAN_FOR_CALCULATE.put(50, "L");
        ARABIC_ROMAN_FOR_CALCULATE.put(40, "XL");
        ARABIC_ROMAN_FOR_CALCULATE.put(10, "X");
        ARABIC_ROMAN_FOR_CALCULATE.put(9, "IX");
        ARABIC_ROMAN_FOR_CALCULATE.put(5, "V");
        ARABIC_ROMAN_FOR_CALCULATE.put(4, "IV");
        ARABIC_ROMAN_FOR_CALCULATE.put(1, "I");

    }

    public String arabicToRoman(int arabicInput) {
        int arabic = ARABIC_ROMAN_FOR_CALCULATE.floorKey(arabicInput);
        if (arabicInput == arabic) {
            return ARABIC_ROMAN_FOR_CALCULATE.get(arabicInput);
        }
        return ARABIC_ROMAN_FOR_CALCULATE.get(arabic) + arabicToRoman(arabicInput - arabic);
    }

    int parseArabicToRoman(String arabicDigit) {
        int result = 0;
        for (int i = 1; i < Converter.ARABIC_NUMBERS.length; i++) {
            if (arabicDigit.equals(Converter.ROMAN_NUMBERS[i])) {
                result = Integer.parseInt(Converter.ARABIC_NUMBERS[i]);
                break;
            }
        }
        return result;
    }

    int[] parseArabicNumbers(String[] array) {
        int[] arabicDigitsArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arabicDigitsArray[i] = Integer.parseInt(array[i]);
        }
        return arabicDigitsArray;
    }
}
