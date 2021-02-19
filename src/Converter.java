import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Converter implements IMathSignIdentifier {

    static final String[] ROMAN_NUMBERS = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    static final String[] ARABIC_NUMBERS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    private int indexOfOperator = 1;
    private String mathOperationSign = "";
    private static String[] numbersArray = new String[2];
    static boolean isRoman = false;
    static boolean isArabic = false;

    Converter() {
    }

    public String getMathOperationSign() {
        return mathOperationSign;
    }

    public static String[] getNumbersArray() {
        return numbersArray;
    }

    static ArrayList<String> transformInputData(String data) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i = 0; i < data.length(); i++) {
            if (stringArrayList.size() != data.length()) {
                stringArrayList.add(Character.toString(data.charAt(i)));
            } else {
                break;
            }
        }
        return stringArrayList;
    }

    void writeDigitsIntoArray(ArrayList<String> inputData) {

        findMathOperationSigh(inputData);

        searchFirstArabIndexOperator1(inputData);
        searchSecondArabNumberIndexOperator1(inputData);
        searchFirstArabDigitIndexOperator2(inputData);
        searchSecondArabNumberIndexOperator2(inputData);
        searchFirstRomanIndexOperator1(inputData);
        searchSecondRomanDigitIndexOperator1(inputData);
        searchFirstRomanDigitIndexOperator2(inputData);
        searchSecondRomanDigitIndexOperator2(inputData);
        searchFirstRomanDigitIndexOperator3(inputData);
        searchSecondRomanDigitIndexOperator3(inputData);
        searchFirstRomanDigitIndexOperator4(inputData);
        searchSecondRomanDigitIndexOperator4(inputData);
    }

    private void combineArabicData(int valueToCompareIndexOper, int indexOfNumbersArray, int valueForCycle, int cycleCondition, ArrayList<String> data) {

        if (indexOfOperator == valueToCompareIndexOper) {
            StringBuilder temp = new StringBuilder();
            for (int i = valueForCycle; i < cycleCondition; i++) {
                temp.append(data.get(i));
            }
            if (isArabicDigit(temp.toString())) {
                numbersArray[indexOfNumbersArray] = temp.toString();
            }
        }
    }

    private void combineRomanData(int valueToCompareIndexOper, int indexOfNumbersArray, int valueForCycle, int cycleCondition, ArrayList<String> data) {

        if (indexOfOperator == valueToCompareIndexOper) {
            StringBuilder temp = new StringBuilder();
            for (int i = valueForCycle; i < cycleCondition; i++) {
                temp.append(data.get(i).toUpperCase());
            }
            if (isRomanDigit(temp.toString())) {
                numbersArray[indexOfNumbersArray] = temp.toString();
            }
        }
    }


    public static boolean isArabicDigit(String input) {
        if (input != null) {
            for (int i = 0; i < 10; i++) {
                if (input.equals(ARABIC_NUMBERS[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isRomanDigit(String input) {
        String upperInput = input.toUpperCase();
        for (int i = 0; i < 10; i++) {
            if (upperInput.equals(ROMAN_NUMBERS[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void findMathOperationSigh(ArrayList<String> inputData) {
        for (int i = 1; i < 5; i++) {
            ArrayList<String> mathSignIndex = (ArrayList<String>) inputData.
                    stream().skip(i).limit(1).collect(Collectors.toList());
            boolean isOperator = isMathOperator(mathSignIndex);
            if (isOperator) {
                indexOfOperator = i;
            }
        }
    }

    @Override
    public boolean isMathOperator(ArrayList<String> inputData) {
        ArrayList<String> operatorsList = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
        boolean anyMatch = inputData.stream().anyMatch(operatorsList::contains);
        if (anyMatch) {
            mathOperationSign = inputData.stream().map(Object::toString).collect(Collectors.joining());
            return true;
        } else return false;
    }


    public static boolean areTheNumbersTheSame(String first, String second) {
        if (isArabicDigit(first) & isArabicDigit(second)) {
            isArabic = true;
            return true;
        } else if (isRomanDigit(first) & isRomanDigit(second)) {
            isRoman = true;
            return true;
        }
        return false;
    }


    private void searchFirstArabIndexOperator1(ArrayList<String> inputData) {
        combineArabicData(1, 0, 0, 1, inputData);
    }

    private void searchSecondArabNumberIndexOperator1(ArrayList<String> inputData) {
        combineArabicData(1, 1, 2, inputData.size(), inputData);
    }

    private void searchFirstArabDigitIndexOperator2(ArrayList<String> inputData) {
        combineArabicData(2, 0, 0, 2, inputData);
    }

    private void searchSecondArabNumberIndexOperator2(ArrayList<String> inputData) {
        combineArabicData(2, 1, 3, inputData.size(), inputData);
    }

    private void searchFirstRomanIndexOperator1(ArrayList<String> inputData) {
        combineRomanData(1, 0, 0, 1, inputData);
    }

    private void searchSecondRomanDigitIndexOperator1(ArrayList<String> inputData) {
        combineRomanData(1, 1, 2, inputData.size(), inputData);
    }

    private void searchFirstRomanDigitIndexOperator2(ArrayList<String> inputData) {
        combineRomanData(2, 0, 0, 2, inputData);
    }

    private void searchSecondRomanDigitIndexOperator2(ArrayList<String> inputData) {
        combineRomanData(2, 1, 3, inputData.size(), inputData);
    }

    private void searchFirstRomanDigitIndexOperator3(ArrayList<String> inputData) {
        combineRomanData(3, 0, 0, 3, inputData);
    }

    private void searchSecondRomanDigitIndexOperator3(ArrayList<String> inputData) {
        combineRomanData(3, 1, 4, inputData.size(), inputData);
    }

    private void searchFirstRomanDigitIndexOperator4(ArrayList<String> inputData) {
        combineRomanData(4, 0, 0, 4, inputData);
    }

    private void searchSecondRomanDigitIndexOperator4(ArrayList<String> inputData) {
        combineRomanData(4, 1, 5, inputData.size(), inputData);
    }
}
