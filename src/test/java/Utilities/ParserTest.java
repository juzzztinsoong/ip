package Utilities;

import org.junit.jupiter.api.Test;

import Commands.DeadlineCommand;
import Exceptions.DukeException;
import Exceptions.IncorrectFormatException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.time.LocalTime;


public class ParserTest {
  
  @Test
  public void test1() {
    try {
      assertEquals(Parser.deadlineParser("blah /by 12/12/2012 16:00", false), new DeadlineCommand(null, false, LocalDate.of(2012,12,12), LocalTime.of(16,0)));
    } catch (IncorrectFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  public void test2() {
    try {
      assertEquals(Parser.map("delete"), DukeEnum.DELETE);
    } catch (DukeException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
