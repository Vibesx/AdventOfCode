package Year2023;

import Year2023.util.ReadFileUtil;

import java.util.List;

public class Problem1 {
    List<String> input = ReadFileUtil.fileToStringList("src/Year2023/inputs/Problem1.txt");

    public void solve() {
        int sum = 0;
        for(String value : input) {
            sum += getCalibrationValue(value);
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


}
