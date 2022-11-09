package core;

import java.io.IOException;

import static core.Data.fromByteArray;
import static core.Data.toByteArray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DataTest {

    @Test
    public void testToByteArray () throws IOException {
        byte[] byteArr;
        String message = new String("Response from server");
        byteArr = toByteArray(message);
        assertEquals(27, byteArr.length);
    }


    @Test
    public void testFromByteArray () throws IOException, ClassNotFoundException {
        byte[] byteArr;
        String message = new String("Response from server");
        byteArr = toByteArray(message);
        String result = (String) fromByteArray(byteArr);
        assertEquals(message, result);
    }
}
