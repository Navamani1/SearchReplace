package main.com.infor.filesearch;

/**
 * Provides instantiation based on file type.
 */
public class FileFactory {

    /**
     * Retrieves FileProcessor instance
     *
     * @param type file type
     * @return FileProcessor
     */
    public FileProcessor getFileProcessor(String type) {
        FileProcessor fileProcessor = null;
        if (type.equalsIgnoreCase("txt")) {
            fileProcessor = new TextFileProcessor();
        } else if (type.equalsIgnoreCase("xml")) {
            fileProcessor = new XmlFileProcessor();
        }
        return fileProcessor;
    }
}