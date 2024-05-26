import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {
    @Test
    public void test1() {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>(List.of("cat","cats","and","sand","dog"));
        List<String> expected = new ArrayList<>(List.of("cats and dog","cat sand dog"));
        List<String> actual = new Solution().wordBreak(s, wordDict);

        Assert.assertEquals(expected, actual);

    }
}
