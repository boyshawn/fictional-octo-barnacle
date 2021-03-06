package crackingthecodinginterview.hard;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountOf2sTest {
  private static CountOf2s countOf2s;

  @BeforeAll
  static void setUpOnce() {
    countOf2s = new CountOf2s();
  }

  @Test
  void countTwosFromZeroTo_Zero() {
    assertEquals(0, countOf2s.countTwosFromZeroTo(0));
  }

  @Test
  void countTwosFromZeroTo_Negative() {
    assertEquals(0, countOf2s.countTwosFromZeroTo(-5));
  }

  @Test
  void countTwosFromZeroTo_One() {
    assertEquals(countOf2s.count2sInRange(1), countOf2s.countTwosFromZeroTo(1));
  }

  @Test
  void countTwosFromZeroTo_Two() {
    assertEquals(countOf2s.count2sInRange(2), countOf2s.countTwosFromZeroTo(2));
  }

  @Test
  void countTwosFromZeroTo_Three() {
    assertEquals(countOf2s.count2sInRange(3), countOf2s.countTwosFromZeroTo(3));
  }

  @Test
  void countTwosFromZeroTo_32() {
    assertEquals(countOf2s.count2sInRange(32), countOf2s.countTwosFromZeroTo(32));
  }

  @Test
  void countTwosFromZeroTo_132() {
    assertEquals(countOf2s.count2sInRange(132), countOf2s.countTwosFromZeroTo(132));
  }

  @Test
  void countTwosFromZeroTo_22() {
    assertEquals(countOf2s.count2sInRange(22), countOf2s.countTwosFromZeroTo(22));
  }

  @Test
  void countTwosFromZeroTo_222() {
    assertEquals(countOf2s.count2sInRange(222), countOf2s.countTwosFromZeroTo(222));
  }

  @Test
  void countTwosFromZeroTo_2222() {
    assertEquals(countOf2s.count2sInRange(2222), countOf2s.countTwosFromZeroTo(2222));
  }

  @Test
  void countTwosFromZeroTo_1577() {
    assertEquals(countOf2s.count2sInRange(1577), countOf2s.countTwosFromZeroTo(1577));
  }

  @Test
  void countTwosFromZeroTo_3958() {
    assertEquals(countOf2s.count2sInRange(3958), countOf2s.countTwosFromZeroTo(3958));
  }

  @Test
  void countTwosFromZeroTo_15() {
    assertEquals(countOf2s.count2sInRange(15), countOf2s.countTwosFromZeroTo(15));
  }

  @Test
  void countTwosFromZeroTo_171() {
    assertEquals(countOf2s.count2sInRange(171), countOf2s.countTwosFromZeroTo(171));
  }

  @Test
  void countTwosFromZeroTo_122() {
    assertEquals(countOf2s.count2sInRange(122), countOf2s.countTwosFromZeroTo(122));
  }
}