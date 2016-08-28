package SupplyPower.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by redolyr on 2016/08/10.
 */
public class DataTagStringArray extends DataBaseArray {

    private String[] data;

    protected DataTagStringArray() {
    }

    public DataTagStringArray(String[] par1) {
        this.data = par1;
    }

    void write(DataOutput par1) throws IOException {
        par1.writeInt(this.data.length);
        for (int len = 0; len < this.data.length; len++) par1.writeUTF(this.data[len]);
    }

    void read(DataInput par1) throws IOException {
        this.data = new String[par1.readInt()];
        for (int len = 0; len < this.data.length; len++)
            this.data[len] = par1.readUTF();
    }

    public byte getId() {
        return 12;
    }

    public DataTagStringArray copy() {
        String[] data = new String[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
        return new DataTagStringArray(data);
    }

    public int length() {
        return this.data.length;
    }

    public String[] getStringArray() {
        return this.data;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof DataTagStringArray)) return false;
        return Arrays.equals(this.data, ((DataTagStringArray) o).data);
    }

    public String toString() {
        StringBuilder tsb = new StringBuilder();
        for (int len = 0; len < getStringArray().length; len++)
            tsb.append(getStringArray()[len]).append(len != getStringArray().length - 1 ? ", " : "");
        return "[" + tsb + "]";
    }
}

