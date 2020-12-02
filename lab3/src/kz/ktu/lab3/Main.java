package kz.ktu.lab3;

public class Main {

    public static void main(String[] args) {
        FixedLengthBuffer buffer = new FixedLengthBuffer(3);
        Byte byteData = new Byte();
        Word wordData = new Word();
        Number numberData = new Number();

        byteData.setData((byte) 1);
        wordData.setWord(12);
        numberData.setNumber(144.44);

        buffer.addData(byteData);
        buffer.addData(wordData);
        buffer.addData(numberData);

        System.out.println("Буфер: " + buffer.toString());
        Data deletedElement = buffer.popData();
        System.out.println("Удаление элемента типа " + deletedElement.getClass().getSimpleName() + " со значением " + deletedElement.dataToString());
        System.out.println("Буфер: " + buffer.toString());
    }
}
