package edu.pasadena.cs.cs03b;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

public class TestTaxTableTools {

   @Test
   public void testGetValue()
   {
     // create an instance of the class
      TaxTableTools ttt = new TaxTableTools();

     // action
     double iResult = ttt.getTaxRate(10000);
     // assertion
     assertEquals(0.1, iResult);

    ttt.setTaxTable(new int[]{0, 12, 123, 1234, 12345, 123456, 1234567}, new double[]{0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7});

    double iResult1 = ttt.getTaxRate(12);
    assertEquals(0.1, iResult1);

    double iResult2 = ttt.getTaxRate(13);
    assertEquals(0.2, iResult2);

    double iResult3 = ttt.getTaxRate(123);
    assertEquals(0.2, iResult3);

    double iResult4 = ttt.getTaxRate(124);
    assertEquals(0.3, iResult4);

    double iResult5 = ttt.getTaxRate(1234567);
    assertEquals(0.7, iResult5);
     // TODO: add more test cases for all public instance methods

   }
}
