import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        List<Product> list = new ArrayList<>();

        String sourceFileStr = sc.nextLine();


        File sourceFile = new File(sourceFileStr);

        String sourceFolderStr = sourceFile.getParent();

        boolean success = new File(sourceFolderStr + "\\out").mkdir();

        String targetFileStr = sourceFolderStr + "\\out\\summary.csv";


        try(BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))){
            String itemCSV = br.readLine();
            while(itemCSV != null){
                String[] fields = itemCSV.split(",");
                String name = fields[0];
                Double price = Double.parseDouble(fields[1]);
                int quantidade = Integer.parseInt(fields[2]);

                list.add(new Product(name, price, quantidade));
                itemCSV = br.readLine();
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))){
                for(Product item : list){
                    bw.write(item.getName() + "," + String.format("%.2f", item.total()));
                    bw.newLine();
                }

            }catch(IOException e){
                System.out.println("Error: " + e.getMessage());
            }

        }catch (IOException e) {
            System.out.println("Error witing file: " + e.getMessage());
        }
        sc.close();

    }
}