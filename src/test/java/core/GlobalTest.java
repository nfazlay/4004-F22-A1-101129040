package core;

import junit.framework.TestCase;

public class GlobalTest extends TestCase {

    public void testRandomEnum() {
        Global.DiceSide side = Global.randomEnum(Global.DiceSide.class);
        assertTrue(side instanceof Global.DiceSide);
    }
}
