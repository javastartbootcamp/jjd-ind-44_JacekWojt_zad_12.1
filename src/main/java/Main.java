import java.io.IOException;

class Main {
    public static void main(String[] args) {
        String fileName = "src/main/operations.txt";
        Calculator[] calculations = new Calculator[0];
        try {
            calculations = Calculations.read(fileName);
            double[] results = Calculations.calculateResults(calculations);
            Calculations.save(calculations, results);
        } catch (IOException e) {
            System.out.println("Nie udało sie zapisać danych w pliku");
            ;
        }
    }
}