package cub.letscodequiz;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class LetsCodeQuiz20220221 {
    @Test
    public void letsCodeQuiz() {
        Matcher singleA = Pattern.compile("a").matcher("aa");
        Matcher bStar = Pattern.compile("b*").matcher("aa");
        assertAll(
            () -> assertFalse("aa".matches("a"), "aa =~ /a/"),       // 1 -
            () -> assertTrue("aa".matches("a*"), "aa =~ /a*/"),     // 2
            () -> assertTrue("aa".matches("a+"), "aa =~ /a+/"),     // 3
            () -> assertFalse("aa".matches("b*"), "aa =~ /b*/"),     // 4 -
            () -> assertTrue("aa".matches("b*.*"), "aa =~ /b*.*/"), // 5
            () -> assertFalse(singleA.matches(), "matches a"),             // 6 -
            () -> assertTrue(singleA.find(), "find a"),                   // 7
            () -> assertFalse(bStar.matches(), "matches b"),               // 8 -
            () -> assertTrue(bStar.find(), "find b")                      // 9

            // next test will actually never end due to too complex regexp
            // () -> assertFalse("a".repeat(100).                                    // 10 -
            //     matches("(((a*)*a*)*a*)*x"), "aa =~ /a****/")

            // Какие тесты пройдут проверку?
            // 1) 1, 2, 3, 5, 7, 9, 10
            // 2) 2, 3, 5, 8, 9
            // 3) 2, 3, 5, 5, 8, 10
            // >4 2, 3, 5, 7, 9
            // 5) 2, 3, 6, 7, 10
        );
    }
}
