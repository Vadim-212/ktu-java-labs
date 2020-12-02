package kz.ktu.lab3;

public class Word extends Byte {
    private int word;

    public Word() {
        this.setWord(0);
    }

    public int getWord() {
        return word;
    }

    public void setWord(int word) {
        this.word = word;
    }

    @Override
    public String dataToString() {
        return java.lang.Integer.toString(word);
    }
}
