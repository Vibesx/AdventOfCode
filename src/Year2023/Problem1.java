package Year2023;

import Year2023.util.ReadFileUtil;

import java.util.List;
import java.util.Map;

public class Problem1 {

    public static final Map<String, Integer> numbers = Map.of("one", 1,
            "two", 2,
            "three", 3,
            "four", 4,
            "five", 5,
            "six", 6,
            "seven" ,7,
            "eight", 8,
            "nine", 9);

    List<String> input = ReadFileUtil.fileToStringList("src/Year2023/inputs/Problem1.txt");

    public void solve() {
        int sum = 0;
        for(String value : input) {
            sum += getCalibrationValue(value);
        }
        System.out.println(sum);
    }

    public void solve_part2() {
        int sum = 0;
        for(String value : input) {
            sum += getCalibrationValue_part2(value);
        }
        System.out.println(sum);
    }

    private int getCalibrationValue(String value) {
        int result = 0;
        boolean firstDigitFound = false;
        boolean lastDigitFound = false;
        for (int i = 0; i < value.length(); i++) {
            if(Character.isDigit(value.charAt(i)) && !firstDigitFound) {
                result += 10 * Character.digit(value.charAt(i), 10);
                firstDigitFound = true;
            }
            char ch = value.charAt(value.length() - 1 - i);
            if(Character.isDigit(ch) && !lastDigitFound) {
                result += Character.digit(ch, 10);
                lastDigitFound = true;
            }
        }
        return result;
    }

    private int getCalibrationValue_part2(String value) {
        int minIndex = Integer.MAX_VALUE;
        int maxIndex = -1;
        int leftDigit = 0;
        int rightDigit = 0;
        for(String number : numbers.keySet()) {
            int firstIndexOfNumber = value.indexOf(number);
            int lastIndexOfNumber = value.lastIndexOf(number);
            if(firstIndexOfNumber >= 0) {
                if(firstIndexOfNumber < minIndex) {
                    minIndex = firstIndexOfNumber;
                    leftDigit = numbers.get(number);
                }
                if(lastIndexOfNumber > maxIndex) {
                    maxIndex = lastIndexOfNumber;
                    rightDigit = numbers.get(number);
                }
            }
        }
        for(Integer number : numbers.values()) {
            int indexOfNumber = value.indexOf(String.valueOf(number));
            int lastIndexOfNumber = value.lastIndexOf(String.valueOf(number));
            if(indexOfNumber >= 0) {
                if(indexOfNumber < minIndex) {
                    minIndex = indexOfNumber;
                    leftDigit = number;
                }
                if(lastIndexOfNumber > maxIndex) {
                    maxIndex = lastIndexOfNumber;
                    rightDigit = number;
                }
            }
        }
        return 10 * leftDigit + rightDigit;
    }


}
