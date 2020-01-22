package test.com.infor.filesearch;

import main.com.infor.filesearch.XmlFileProcessor;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;

/**
 * XmlFileProcessor Test
 */
public class XmlFileProcessorTest {

    @Test
    public void buildDocument() throws Exception {
        XmlFileProcessor xmlFileProcessor = new XmlFileProcessor();
        Document doc = xmlFileProcessor.buildDocument("<configuration><log level=\"trace\"><file name=\"trace-20180101.log\"/></log></configuration>");
        Assert.assertEquals(1, doc.getChildNodes().getLength());
    }

    @Test
    public void buildDocument_node() throws Exception {
        XmlFileProcessor xmlFileProcessor = new XmlFileProcessor();
        Document doc = xmlFileProcessor.buildDocument("<configuration><log level=\"trace\"><file name=\"trace-20180101.log\"/></log></configuration>");
        Assert.assertEquals(1, doc.getChildNodes().item(0).getNodeType());
    }

    @Test
    public void replaceAttributeValue() throws Exception {
        XmlFileProcessor xmlFileProcessor = new XmlFileProcessor();
        Document doc = xmlFileProcessor.buildDocument("<configuration><log level=\"trace\"><file name=\"trace-20180101.log\"/></log></configuration>");
        xmlFileProcessor.replaceAttributeValue(doc.getChildNodes(), "trace", "error");
        Assert.assertEquals("error", doc.getChildNodes().item(0).getChildNodes().item(0).getAttributes().item(0).getNodeValue());
    }
}