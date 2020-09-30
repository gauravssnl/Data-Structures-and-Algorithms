package fds;

public class ComparableGameEntry extends GameEntry implements Comparable<ComparableGameEntry> {
    public ComparableGameEntry(String name, int score) {
        super(name, score);
    }

    @Override
    public int compareTo(ComparableGameEntry e) {
        if (super.getScore() > e.getScore())
            return 1;
        else if (super.getScore() == e.getScore())
            return 0;
        else
            return -1;
    }

}
