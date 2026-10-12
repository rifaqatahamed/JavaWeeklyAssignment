import java.util.Arrays;
class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;
    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }
    private double getCompositeScore() {
        return cgpa * 10 + codingScore;
    }
    @Override
    public int compareTo(Candidate other) {
        return Double.compare(
            other.getCompositeScore(),
            this.getCompositeScore()
        );
    }
    public String getName() {
        return name;
    }
    public double getCompositeScore() {
        return getCompositeScore();
    }
    static String shortlistAndRank(Candidate[] candidates) {
        int count = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (isEligible(candidates[i].cgpa)
                    || isEligible(candidates[i].cgpa,
                                  candidates[i].codingScore)) {
                count++;
            }
        }
        Candidate[] shortlisted = new Candidate[count];
        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (isEligible(candidates[i].cgpa)
                    || isEligible(candidates[i].cgpa,
                                  candidates[i].codingScore)) {
                shortlisted[index] = candidates[i];
                index++;
            }
        }
        Arrays.sort(shortlisted);
        String result = "";
        for (int i = 0; i < shortlisted.length; i++) {
            result = result
                    + (i + 1)
                    + ". "
                    + shortlisted[i].name
                    + " ("+ shortlisted[i].getCompositeScore()+ ")";
            if (i < shortlisted.length - 1) {
                result = result + " | ";
            }
        }
        return result;
    }
}
public class PlacementDriveShortlistingRankingEngine {
    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(
            Candidate.shortlistAndRank(candidates)
        );
    }
}