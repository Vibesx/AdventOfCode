package Year2023.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileUtil {
    public static List<String> fileToStringList(String filePath) {
        List<String> result = new ArrayList<>();
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void test() {
//        File currentDir = new File(ReadFileUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath());
//
//        // Ensure it's a directory
//        if (currentDir.isDirectory()) {
//            // List the contents of the directory
//            File[] files = currentDir.listFiles();
//
//            if (files != null) {
//                System.out.println("File structure of the directory:");
//                for (File file : files) {
//                    System.out.println(file.getName());
//                }
//            } else {
//                System.out.println("No files in the directory.");
//            }
//        } else {
//            System.out.println("Not a directory.");
//        }
        System.out.println(new File("").getAbsolutePath());
    }
}
