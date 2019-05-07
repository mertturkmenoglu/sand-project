package ce.yildiz.sand;

import static org.junit.Assert.*;
import org.junit.Test;
import ce.yildiz.sand.databaseUtils.Item;

public class ItemClassUnitTest {

    @Test
    public void testGetVersion() {
        Item item = new Item(0, "name", 1, 1, "4.2", 0, "");
        String actual = item.getVersion();
        String expected = "4.2";
        assertEquals("getVersion Failed", expected, actual);
    }

    @Test
    public void testGetId() {
        Item item = new Item(0, "name", 1, 1, "4.2", 0, "");
        int actual = item.getId();
        int expected = 0;
        assertEquals("getId Failed", expected, actual);
    }

    @Test
    public void testGetName() {
        Item item = new Item(0, "name", 1, 1, "4.2", 0, "");
        String actual = item.getName();
        String expected = "name";
        assertEquals("getName Failed", expected, actual);
    }

    @Test
    public void testGetCategory() {
        Item item = new Item(0, "name", 1, 1, "4.2", 0, "");
        int actual = item.getCategory();
        int expected = 1;
        assertEquals("getCategory Failed", expected, actual);
    }

    @Test
    public void testGetLoaded() {
        Item item = new Item(0, "name", 1, 1, "4.2", 0, "");
        int actual = item.getLoaded();
        int expected = 0;
        assertEquals("getLoaded Failed", expected, actual);
    }

    @Test
    public void testGetTimestamp() {
        Item item = new Item(0, "name", 1, 1, "4.2", 0, "13.9");
        String actual = item.getTimestamp();
        String expected = "13.9";
        assertEquals("getTimestamp Failed", expected, actual);
    }

}
