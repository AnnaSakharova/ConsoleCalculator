import java.util.*;

public class Calculator implements Operationable {

    private Converter converter = new Converter();
    private final Parser parser;
    private final String dataWithoutWhitespaces = deleteWhitespaces();
    private final ArrayList<String> inputArrayList = Converter.transformInputData(dataWithoutWhitespaces);

    int[] arabicForCalculate = new int[2];
    int[] romanForCalculate = new int[2];

    public Calculator(Converter converter, Parser parser) {
        this.converter = converter;
        this.parser = parser;
    }


    public static String readUsersData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическую операцию");
        String usersData = scanner.nextLine();
        return usersData;
    }

    public static String deleteWhitespaces() {
        String withoutWhitespaces = readUsersData().replaceAll("\\s+", "");
        return withoutWhitespaces;
    }

    int calculate() throws NumberFormatException {
        String[] array = Converter.getNumbersArray();
        boolean isSame = Converter.areTheNumbersTheSame(array[0], array[1]);

        try {
            if (isSame) {
                if (Converter.isArabic) {
                    arabicForCalculate = parser.parseArabicNumbers(array);
                    int arabicResult = action(arabicForCalculate[0], arabicForCalculate[1]);
                    System.out.println(arabicResult);
                } else if (Converter.isRoman) {
                    romanForCalculate[0] = parser.parseArabicToRoman(array[0]);
                    romanForCalculate[1] = parser.parseArabicToRoman(array[1]);
                    int romanResult = action(romanForCalculate[0], romanForCalculate[1]);
                    String romanComputation = parser.arabicToRoman(romanResult);
                    System.out.println(romanComputation);
                }
            } else {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public int action(int firstDigit, int secondDigit) {
        switch (converter.getMathOperationSign()) {
            case "+":
                return firstDigit + secondDigit;
            case "-":
                return firstDigit - secondDigit;
            case "*":
                return firstDigit * secondDigit;
            case "/":
                return firstDigit / secondDigit;
        }
        return 0;
    }


    public static void main(String[] args) {
        Converter converter = new Converter();
        Parser parser = new Parser();
        Calculator calculator = new Calculator(converter, parser);
        ArrayList<String> inputArrayList = Converter.transformInputData(calculator.dataWithoutWhitespaces);
        converter.writeDigitsIntoArray(inputArrayList);
        calculator.calculate();
    }
}



