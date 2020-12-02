package kz.ktu.lab3;

public class Byte extends Data {
    private byte data;

    public Byte() {
        this.setData((byte) 0);
    }

    public byte getData() {
        return data;
    }

    public void setData(byte data) {
        this.data = data;
    }

    @Override
    public String dataToString() {
        return java.lang.Byte.toString(data);
    }
}
