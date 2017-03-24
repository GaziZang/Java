import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.JoranConfiguratorBase;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by gazizang on 17/3/8.
 */
public class LogbackTest {
    @Test
    public void main() throws IOException, JoranException{
//        loadConfig("../../main/resources/logback.xml ");
        loadConfig("/Users/gazizang/Dev/Myself/workspace/mavenWebDemo/src/main/resources/logback.xml");
        print("test1");
        print("gz.test");
    }

    private void print(String name){
        Logger logger = LoggerFactory.getLogger(name);
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }

    private void loadConfig(String configPath) throws IOException, JoranException{
        LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory();
        File configFile = new File(configPath);
        if(!configFile.exists()){
            throw new IOException("Logback External Config File Parameter exists, but does not reference a file");
        }else if(!configFile.isFile()){
            throw new IOException("Logback External Config File Parameter exists, but does not reference a file");
        }else if(!configFile.canRead()){
            throw new IOException("Logback External Config File Parameter exists, but does not reference a file");
        }else {
            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(lc);
            lc.reset();
            configurator.doConfigure(configFile);
            StatusPrinter.printInCaseOfErrorsOrWarnings(lc);
        }
    }
}
