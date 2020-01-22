package main.com.infor.filesearch;

/**
 * File Processor provide signature
 */
public interface FileProcessor {

    /**
     * replaceContent
     *
     * @param input content
     * @param oldStr old String
     * @param newStr new String
     * @throws Exception
     */
    void replaceContent(String input, String oldStr, String newStr) throws Exception;
}