package ce.yildiz.sand;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AppActivityUnitTest {
    @Test
    public void testGetMusic() {
        AppActivity activity = new AppActivity();
        String actual = activity.handleCategory(0);
        String expected = "music";
        assertEquals("handleCategory Failed", expected, actual);
    }

    @Test
    public void testGetSocial() {
        AppActivity activity = new AppActivity();
        String actual = activity.handleCategory(1);
        String expected = "social";
        assertEquals("handleCategory Failed", expected, actual);
    }

    @Test
    public void testGetGaming() {
        AppActivity activity = new AppActivity();
        String actual = activity.handleCategory(2);
        String expected = "gaming";
        assertEquals("handleCategory Failed", expected, actual);
    }

    @Test
    public void testGetNews() {
        AppActivity activity = new AppActivity();
        String actual = activity.handleCategory(3);
        String expected = "news";
        assertEquals("handleCategory Failed", expected, actual);
    }

    @Test
    public void testGetTools() {
        AppActivity activity = new AppActivity();
        String actual = activity.handleCategory(4);
        String expected = "tools";
        assertEquals("handleCategory Failed", expected, actual);
    }

    @Test
    public void testGetFalse() {
        AppActivity activity = new AppActivity();
        String actual = activity.handleCategory(1);
        String expected = "Category";
        assertNotEquals("handleCategory Failed", expected, actual);
    }
}
