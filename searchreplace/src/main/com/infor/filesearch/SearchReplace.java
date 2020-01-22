package main.com.infor.filesearch;

import java.io.ByteArrayOutputStream;

/**
 * SearchReplace provide facility to receive file and replace given content
 */
public class SearchReplace {

    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.out.println("Expected arguments are \"FileType\", \"Old Str\", \"New Str\"");
            throw new Exception("Expected arguments are \"FileType\", \"Old Str\", \"New Str\"");
        }
        String fileType = args[0];
        String oldStr = args[1];
        String newStr = args[2];

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = (System.in).read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        FileFactory fileFactory = new FileFactory();
        FileProcessor fileProcessor = fileFactory.getFileProcessor(fileType);
        fileProcessor.replaceContent(result.toString("UTF-8"), oldStr, newStr);
    }

}