public class Score implements  Comparable{
    private String name;
    private double score;

    public Score(String n, double s) {
        name = n;
        score = s;
    }

    public double getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + " " + ((int)(score * 10) / 10.0);
    }

    public int compareTo(Object o) {
        if (o instanceof Score) {
            double score = (((Score) o).getScore() - this.score);
            if (score < 0) {
                return -1;
            } else if (score == 0) {
                return 0;
            } else {
                return 1;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
