package kz.ktu.lab3;

import java.util.ArrayList;

public class FixedLengthBuffer {
    private int bufferLength;
    private ArrayList<Data> data;

    public FixedLengthBuffer(int bufferLength) {
        if(bufferLength < 0 || bufferLength == 0)
            this.bufferLength = 1;
        else
            this.bufferLength = bufferLength;
        data = new ArrayList<>(bufferLength);
    }

    public void addData(Data data) {
        if(this.data.size() < bufferLength) {
            this.data.add(data);
            bufferLength++;
        }
    }

    public Data popData() {
        if(data.size() > 0) {
            Data first = data.get(0);
            data.remove(first);
            bufferLength--;
            return first;
        }
        return null;
    }

    public String dataBufferToString() {
        StringBuilder stringToPrint = new StringBuilder("data=[" + data.get(0).dataToString());
        for (int i = 1; i < data.size(); i++) {
            stringToPrint.append(", ").append(data.get(i).dataToString());
        }
        stringToPrint.append("]}");
        return stringToPrint.toString();
    }

    @Override
    public String toString() {
        return "FixedLengthBuffer{" + this.dataBufferToString() + "}";
    }
}
