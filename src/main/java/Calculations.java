import java.io.*;
import java.util.Scanner;

public class Calculations {

    public static void save(Calculator[] calculations, double[] results) throws IOException {
        String fileName = "src/main/results.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < results.length; i++) {
            writer.write(calculations[i].getFirstNo() + " " + calculations[i].getArithmeticSign() + " "
                    + calculations[i].getSecondNo() + " = " + String.format("%.2f", results[i]) + "\n");
        }
        writer.close();
    }

    public static double[] calculateResults(Calculator[] calculations) {
        double[] results = new double[calculations.length];
        for (int i = 0; i < calculations.length; i++) {
            if (calculations[i].getArithmeticSign() == '+') {
                results[i] = calculations[i].getFirstNo() + calculations[i].getSecondNo();
            } else if (calculations[i].getArithmeticSign() == '-') {
                results[i] = calculations[i].getFirstNo() - calculations[i].getSecondNo();
            } else if (calculations[i].getArithmeticSign() == '*') {
                results[i] = calculations[i].getFirstNo() * calculations[i].getSecondNo();
            } else if (calculations[i].getArithmeticSign() == '/') {
                results[i] = calculations[i].getFirstNo() / calculations[i].getSecondNo();
            }
        }
        return results;
    }

    public static Calculator[] read(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        int lines = countLines(fileName);
        Calculator[] results = new Calculator[lines];
        for (int i = 0; i < lines; i++) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            double firstNo = Double.parseDouble(split[0]);
            double secondNo = Double.parseDouble(split[2]);
            char sign = split[1].charAt(0);
            results[i] = new Calculator(firstNo, secondNo, sign);
        }
        return results;
    }

    private static int countLines(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        int lines = 0;
        while (scanner.hasNextLine()) {
            lines++;
            scanner.nextLine();
        }
        return lines;
    }
}
