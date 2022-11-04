package core;

import junit.framework.TestCase;

import java.io.IOException;

public class ClientServerTest extends TestCase {

    public void testClientServer () throws IOException, InterruptedException, ClassNotFoundException {

        final GameServer server = new GameServer(8080);

        new Thread(server).start();

        assertEquals(0, server.getPlayerList().size());
    }

    public void testClient () {
        PlayerClient client = new PlayerClient();
        assertEquals(8080, client.getPort());
    }
}
