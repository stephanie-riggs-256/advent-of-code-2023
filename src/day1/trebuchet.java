package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class trebuchet {

    public static void main(String[] args) {
        System.out.println(getSumOfCalibrationValues());
    }

    private static int getSumOfCalibrationValues() {
        List<String> fileContents = readFromFile();
        int sumOfCalibrationValues = 0;
        assert fileContents != null;
        for (String line : fileContents) {
            sumOfCalibrationValues += getCalibrationValue(line);
        }
        return sumOfCalibrationValues;
    }

    private static int getCalibrationValue(String line) {
        char[] lineAsCharArray = line.toCharArray();
        StringBuilder calibrationValueString = new StringBuilder();
        calibrationValueString.append(getFirstDigit(lineAsCharArray));
        char[] reversedLineAsCharArray = reverseLineAsCharArray(lineAsCharArray);
        calibrationValueString.append(getFirstDigit(reversedLineAsCharArray));
        return Integer.parseInt(String.valueOf(calibrationValueString));
    }

    private static char[] reverseLineAsCharArray(char[] lineAsCharArray) {
        char[] reversedLineAsCharArray = new char[lineAsCharArray.length];
        int counter=0;
        for (int i=lineAsCharArray.length-1; i>=0; i--) {
            reversedLineAsCharArray[counter]=lineAsCharArray[i];
            counter+=1;
        }
        return reversedLineAsCharArray;
    }

    private static char getFirstDigit(char[] lineAsCharArray) {
        List<Character> intArray = List.of('1', '2', '3', '4', '5', '6', '7', '8', '9', '0');
        for (char character : lineAsCharArray) {
            if (intArray.contains(character)) {
                return character;
            }
        }
        return '0';
    }

    private static List<String> readFromFile() {
        try {
            File myObj = new File("src/day1/input.txt");
            Scanner myReader = new Scanner(myObj);
            List<String> fileContents = new ArrayList<>();
            while (myReader.hasNextLine()) {
                fileContents.add(myReader.nextLine());
            }
            myReader.close();
            return fileContents;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
}
