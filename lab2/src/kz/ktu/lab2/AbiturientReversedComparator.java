package kz.ktu.lab2;

import java.util.Comparator;

class AbiturientReversedComparator implements Comparator<Abiturient>
{
    public int compare(Abiturient a1, Abiturient a2)
    {
        return a2.getMarksSum().compareTo(a1.getMarksSum());
    }
}