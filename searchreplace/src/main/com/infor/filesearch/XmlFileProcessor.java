package main.com.infor.filesearch;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;

/**
 * Process XML and replace attribute values
 */
public class XmlFileProcessor implements FileProcessor {

    @Override
    public void replaceContent(String input, String oldStr, String newStr) throws Exception {
        Document doc = buildDocument(input);

        XPath xpath = XPathFactory.newInstance().newXPath();
        NodeList nodes = (NodeList) xpath.evaluate("//*[contains(@*, '" + oldStr + "')]", doc, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node value = nodes.item(i).getAttributes().item(0);
            String val = value.getNodeValue();
            value.setNodeValue(val.replaceAll(oldStr, newStr));
        }

//        replaceAttributeValue(doc.getChildNodes(), oldStr, newStr);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformerFactory.newTransformer().transform(new DOMSource(doc), new StreamResult(System.out));
    }

    public Document buildDocument(String content) {
        Document doc = null;
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = builder.parse(new InputSource(new StringReader(content)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }

    @Deprecated
    public void replaceAttributeValue(NodeList nodeList, String oldStr, String newStr) throws Exception {
        for (int count = 0; count < nodeList.getLength(); count++) {
            Node tempNode = nodeList.item(count);
            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                if (tempNode.hasAttributes()) {
                    NamedNodeMap nodeMap = tempNode.getAttributes();
                    for (int i = 0; i < nodeMap.getLength(); i++) {
                        Node node = nodeMap.item(i);
                        if (node.getNodeValue().contains(oldStr)) {
                            node.setNodeValue(node.getNodeValue().replace(oldStr, newStr));
                        }
                    }
                }
                if (tempNode.hasChildNodes()) {
                    replaceAttributeValue(tempNode.getChildNodes(), oldStr, newStr);
                }
            }
        }
    }
}