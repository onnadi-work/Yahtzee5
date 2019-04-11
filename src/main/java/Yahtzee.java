import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Yahtzee {
    ArrayList<Integer> dice;

    public Yahtzee(Integer... ints) {
        dice = new ArrayList<>();
        Collections.addAll(dice, ints);
    }

    public int score(String category) {
        switch (category) {
            case "ones":
                return scoreSingles(1);
            case "twos":
                return scoreSingles(2);
            case "threes":
                return scoreSingles(3);
            case "fours":
                return scoreSingles(4);
            case "fives":
                return scoreSingles(5);
            case "pair":
                return scoreHighestPair();
            case "two pair":
                return scoreTwoPair();
            case "three of a kind":
                return scoreNOfAKind(3);
            case "four of a kind":
                return scoreNOfAKind(4);
            case "small straight":
                return scoreStraight(1, 2, 3, 4, 5);
            case "large straight":
                return scoreStraight(2, 3, 4, 5, 6);
            case "full house":
                return scoreFullHouse();
            case "yahtzee":
                return dice.stream().allMatch(i->i == dice.get(0))? 50 : 0;
            case "chance":
                return getSum();
        }

        return 0;
    }

    private int getSum() {
        return dice.stream().mapToInt(i->i).sum();
    }

    private int scoreFullHouse() {
        return containsPair() && containsThreeOfAKind() ? getSum() : 0;
    }

    private boolean containsThreeOfAKind() {
        return containsNOfAKind(3);
    }

    private boolean containsNOfAKind(int i2) {
        return dice.stream().filter(i -> Collections.frequency(dice, i) == i2).count() == i2;
    }

    private boolean containsPair() {
        return containsNOfAKind(2);
    }

    private int scoreStraight(int i2, int i3, int i4, int i5, int i6) {
        return dice.containsAll(list(i2, i3, i4, i5, i6)) ? getSum() : 0;
    }

    private Collection<?> list(Integer...ints) {
        Collection<Integer> returnValue = new ArrayList<>();
        Collections.addAll(returnValue, ints);
        return returnValue;
    }

    private int scoreNOfAKind(int i2) {
        return dice.stream().filter(d -> frequency(d) == i2).mapToInt(i -> i).sum();
    }

    private int frequency(Integer d) {
        return Collections.frequency(dice, d);
    }

    private int scoreTwoPair() {
        HashSet<Integer> pairs = new HashSet<>();

        for(int d: dice){
            if(frequency(d) >= 2){
                pairs.add(d);
            }
        }

        if(pairs.size() == 2){
            return pairs.stream().mapToInt(i->i).sum() * 2;
        }else {
            return 0;
        }
    }

    private int scoreHighestPair() {
        return 2 * dice.stream().
                filter(i-> frequency(i) >= 2).
                mapToInt(i->i).max().
                orElse(0);
    }

    private int scoreSingles(int i) {
        return frequency(i) * i;
    }
}
