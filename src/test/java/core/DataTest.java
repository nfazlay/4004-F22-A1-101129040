package core;

import junit.framework.TestCase;

import java.io.IOException;

import static core.Data.fromByteArray;
import static core.Data.toByteArray;

public class DataTest extends TestCase {
    public void testToByteArray () throws IOException {
        byte[] byteArr;
        String message = new String("Response from server");
        byteArr = toByteArray(message);
        assertEquals(27, byteArr.length);
    }

    public void testFromByteArray () throws IOException, ClassNotFoundException {
        byte[] byteArr;
        String message = new String("Response from server");
        byteArr = toByteArray(message);
        String result = (String) fromByteArray(byteArr);
        assertEquals(message, result);
    }
}
