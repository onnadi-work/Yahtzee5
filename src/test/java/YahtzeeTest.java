import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YahtzeeTest {
    @Test
    public void given11244AndFoursReturn8() {
        assertEquals(8, new Yahtzee(1, 1, 2, 4, 4).score("fours"));
    }

    @Test
    public void given11255AndFoursReturn0() {
        assertEquals(0, new Yahtzee(1, 1, 2, 5, 5).score("fours"));
    }

    @Test
    public void given11255AndOnesReturn2() {
        assertEquals(2, new Yahtzee(1, 1, 2, 5, 5).score("ones"));
    }

    @Test
    public void given22255AndOnesReturn0() {
        assertEquals(0, new Yahtzee(2, 2, 2, 5, 5).score("ones"));
    }

    @Test
    public void given22255AndTwosReturn6() {
        assertEquals(6, new Yahtzee(2, 2, 2, 5, 5).score("twos"));
    }

    @Test
    public void given22253AndThreesReturn3() {
        assertEquals(3, new Yahtzee(2, 2, 2, 5, 3).score("threes"));
    }

    @Test
    public void given24453AndFivesReturn5() {
        assertEquals(5, new Yahtzee(2, 4, 4, 5, 3).score("fives"));
    }

    @Test
    public void given33344AndPairReturn8() {
        assertEquals(8, new Yahtzee(3, 3, 3, 4, 4).score("pair"));
    }

    @Test
    public void given12345AndPairReturn0() {
        assertEquals(0, new Yahtzee(1, 2, 3, 4, 5).score("pair"));
    }

    @Test
    public void given11233AndTwoPairReturn8() {
        assertEquals(8, new Yahtzee(1, 1, 2, 3, 3).score("two pair"));
    }

    @Test
    public void given12533AndTwoPairReturn0() {
        assertEquals(0, new Yahtzee(1, 2, 5, 3, 3).score("two pair"));
    }

    @Test
    public void given33345AndThreeOfAKindReturn9() {
        assertEquals(9, new Yahtzee(3, 3, 3, 4, 5).score("three of a kind"));
    }

    @Test
    public void given33335AndThreeOfAKindReturn12() {
        assertEquals(12, new Yahtzee(3, 3, 3, 3, 5).score("four of a kind"));
    }
    @Test
    public void given12345AndSmallStraightReturn15() {
        assertEquals(15, new Yahtzee(1, 2, 3, 4, 5).score("small straight"));
    }
    @Test
    public void given23456AndLargeStraightReturn20() {
        assertEquals(20, new Yahtzee(6, 2, 3, 4, 5).score("large straight"));
    }
    @Test
    public void given11222AndFullHouseReturn8() {
        assertEquals(8, new Yahtzee(1, 1, 2, 2, 2).score("full house"));
    }
    @Test
    public void given22222AndFullHouseReturn0() {
        assertEquals(0, new Yahtzee(2, 2, 2, 2, 2).score("full house"));
    }
    @Test
    public void given22222AndYahtzeeReturn50() {
        assertEquals(50, new Yahtzee(2, 2, 2, 2, 2).score("yahtzee"));
    }
    @Test
    public void given22222AndChanceReturn10() {
        assertEquals(10, new Yahtzee(2, 2, 2, 2, 2).score("chance"));
    }
    @Test
    public void given22225AndChanceReturn10() {
        assertEquals(13, new Yahtzee(2, 2, 2, 2, 5).score("chance"));
    }
}
