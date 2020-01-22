package main.com.infor.filesearch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Text file processor replace word from given file
 */
public class TextFileProcessor implements FileProcessor {

    @Override
    public void replaceContent(String input, String oldStr, String newStr) throws Exception {
        System.out.println(findAndReplace(input, oldStr, newStr));
    }

    public String findAndReplace(String content, String oldStr, String newStr) {
        Pattern p = Pattern.compile("\\b" + oldStr + "\\b");
        Matcher m = p.matcher(content);
        return m.replaceAll(newStr);
    }
}