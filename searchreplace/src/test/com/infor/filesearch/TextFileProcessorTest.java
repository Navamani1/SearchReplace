package test.com.infor.filesearch;

import main.com.infor.filesearch.TextFileProcessor;
import org.junit.Assert;
import org.junit.Test;

/**
 * TextFileProcessor Test
 */
public class TextFileProcessorTest {

    @Test
    public void replaceContent() throws Exception {
        TextFileProcessor textFileProcessor = new TextFileProcessor();

        String res = textFileProcessor.findAndReplace("Our highest priority is to satisfy the customer", "customer", "client");
        Assert.assertEquals("Our highest priority is to satisfy the client", res);
    }
}