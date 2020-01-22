package test.com.infor.filesearch;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import main.com.infor.filesearch.FileFactory;
import main.com.infor.filesearch.FileProcessor;
import main.com.infor.filesearch.TextFileProcessor;
import main.com.infor.filesearch.XmlFileProcessor;
import org.junit.Test;

/**
 * Tests FileFactory
 */
public class FileFactoryTest {

    @Test
    public void getFileProcessor_TxtFile() {
        FileFactory fileFactory = new FileFactory();
        FileProcessor fileProcessor = fileFactory.getFileProcessor("txt");
        assertTrue("Text File", fileProcessor instanceof TextFileProcessor);
    }

    @Test
    public void getFileProcessor_XmlFile() {
        FileFactory fileFactory = new FileFactory();
        FileProcessor fileProcessor = fileFactory.getFileProcessor("xml");
        assertTrue("Xml file", fileProcessor instanceof XmlFileProcessor);
    }

    @Test
    public void getFileProcessor_NewFile() {
        FileFactory fileFactory = new FileFactory();
        FileProcessor fileProcessor = fileFactory.getFileProcessor("jar");
        assertNull("New file type", fileProcessor);
    }

}