package SupplyPower.documentSystems;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * Created by redolyr on 2014/11/17.
 */
public class DocumentTagDouble extends DocumentBasePrimitive {

    private double data;

    protected DocumentTagDouble() {
    }

    public DocumentTagDouble(double data) {
        this.data = data;
    }

    void write(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        par2.setTextContent(this.data + "");
    }

    void read(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        this.data = Double.parseDouble(par2.getTextContent());
    }

    public byte getId() {
        return 9;
    }

    public DocumentTagDouble copy() {
        return new DocumentTagDouble(this.data);
    }

    public int toInteger() {
        return this.data < (double) ((int) this.data) ? (int) this.data - 1 : (int) this.data;
    }

    public short toShort() {
        return (short) (this.toInteger() & 65535);
    }

    public long toLong() {
        return (long) this.data;
    }

    public byte toByte() {
        return (byte) (this.toInteger() & 255);
    }

    public double toDouble() {
        return this.data;
    }

    public float toFloat() {
        return (float) this.data;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof DocumentTagFloat)) return false;

        return this.data == ((DocumentTagDouble) o).data;
    }

    public String toString() {
        return String.valueOf(this.toDouble());
    }
}