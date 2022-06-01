package Run;

import distributions.Type.Normal;
import distributions.Type.Poisson;
import distributions.Type.Uniform;

import java.util.Arrays;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import output.OutputCSV;

public class Run {
    private static Logger logs = Logger.getLogger("Logs");

        public static void main(String args[]) throws Exception {
                logs.info("Program started...");

                FileHandler fh;
                List<Double> arguments;
                List<Double> list = null;
                String dir;
                int size;
                OutputCSV w;
                String path;
                String type;


                fh = new FileHandler("res.log");
                logs.addHandler(fh);


                if (args.length == 0) {
                        logs.info("No arguments found");
                        logs.info("Program ended");
                        System.exit(-1);
                }

                type = args[0];
                arguments = Arrays.stream(args[1].split(",")).map(Double::parseDouble).collect(Collectors.toList());
                size = Integer.parseInt(args[2]);
                dir = args[3];


                logs.info("Generating...");
                switch (type) {
                        case ("Normal"):
                                list = new Normal(size, arguments.get(0), arguments.get(1)).getNums(size);
                                break;

                        case ("Uniform"):
                                list = new Uniform(size, arguments.get(0), arguments.get(1)).getNums(size);
                                break;

                        case ("Poisson"):
                                list = new Poisson(size, arguments.get(0)).getNums(size);
                                break;

                        default:
                                System.out.println("No type of distribution");
                                break;

                }
                logs.info("Generated!");

                path = dir + "res.csv";
                w = new OutputCSV();
                w.write(path, list);
                logs.info("Distribution has been written to " + path);
                logs.info("Program ended!");
        }
}