import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {

        File inputFile, outputFile;
        Scanner sc = new Scanner(System.in);
        String special;
        FileAnalyzer analyzer = new FileAnalyzer();

        System.out.print("Path of input file:");

        inputFile = new File(sc.nextLine());
        while(!inputFile.exists()||inputFile.canRead()){
            System.out.print("\nFile not found\nPath of input file:");
            inputFile = new File(sc.nextLine());
        };

        analyzer.Sort(inputFile);

        System.out.println("\n----OPTIONAL----");
        System.out.print("\nPath of output file:");
        outputFile = new File(sc.nextLine());
        if(outputFile.exists() || outputFile.canWrite()){
            System.out.println("Special characters: ");
            special = sc.nextLine();

            analyzer.PrintResult(outputFile, special);
        }else{
            System.out.println("Special characters: ");
            special = sc.nextLine();

            System.out.println("File not found\nResult:");
            analyzer.PrintResult(new File(""), special);
        }


    }
}
