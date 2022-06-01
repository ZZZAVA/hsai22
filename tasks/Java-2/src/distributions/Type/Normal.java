package distributions.Type;

import distributions.Distribution;

import java.util.ArrayList;
import java.util.List;

public class Normal extends Distribution {
    double variance;
    double mean;

    public Normal(int size, double variance, double average) throws Exception {
        super(size);
        if (variance > 0 ) {
            this.variance = variance;
            this.mean = average;
        } else {
            logs.info("Incorrect form");
            System.exit(-333);
        };
    }

    public List<Double> getNums(int size) {
        List<Double> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) list.add(rand.nextGaussian() * variance + mean);

        return list;
    }
}