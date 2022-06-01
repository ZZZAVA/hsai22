package distributions;

import java.util.Random;
import java.util.logging.Logger;

public class Distribution {
        int size;
        protected static Logger logs = Logger.getLogger("Logs");
        protected static final Random rand = new Random();

        public Distribution(int size) throws Exception {
                if (size < 10000){
                        logs.info("Size too small, rounded up to 10000");
                        this.size = 10000;
                }else this.size = size;
        }
}