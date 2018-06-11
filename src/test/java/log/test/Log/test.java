package log.test.Log;


import org.apache.log4j.Logger;

/**
 * Created by Mr.K on 2018/6/9.
 */
public class test {
    static Logger log = Logger.getLogger(test.class);
    public static void main(String[] args) {
        long start  =System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            log.info("");
            log.debug("");
        }
        long time = System.currentTimeMillis() - start;
        log.info("所用时间" + time);
    }
}

