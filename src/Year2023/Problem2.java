package Year2023;

import Year2023.util.ReadFileUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2 {
    List<String> input = ReadFileUtil.fileToStringList("src/Year2023/inputs/Problem2.txt");
    Map<String, Integer> maxCubes = Map.of("red", 12, "green", 13, "blue", 14);

    public void solve_part1() {
        int sum = 0;
        for (int i = 0; i < input.size(); i++) {
            if(gameIsPossible(input.get(i))) {
                sum += i + 1;
            }
        }
        System.out.println(sum);
    }

    public void solve_part2() {
        int sum = 0;
        for(String line : input) {
            sum += powerOfSet(line);
        }
        System.out.println(sum);
    }

    private int powerOfSet(String line) {
        Map<String, Integer> cubeMaxes = new HashMap<>();
        cubeMaxes.put("green", 0);
        cubeMaxes.put("blue", 0);
        cubeMaxes.put("red", 0);
        String gameSets = line.split(":")[1];
        for (String setOfCubes : gameSets.split("[,;]")) {
            Integer number = Integer.valueOf(setOfCubes.trim().split(" ")[0]);
            String color = setOfCubes.trim().split(" ")[1];
            if(number > cubeMaxes.get(color)) {
                cubeMaxes.put(color, number);
            }
        }
        return Math.multiplyExact(cubeMaxes.get("red"), Math.multiplyExact(cubeMaxes.get("green"), cubeMaxes.get("blue")));
    }

    private Boolean gameIsPossible(String input) {
        String gameSets = input.split(":")[1];
        for (String setOfCubes : gameSets.split("[,;]")) {
            Integer number = Integer.valueOf(setOfCubes.trim().split(" ")[0]);
            String color = setOfCubes.trim().split(" ")[1];
            if(number > maxCubes.get(color)) {
                return false;
            }
        }
        return true;
    }
}
