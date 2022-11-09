package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientServerTest {


    @Test
    public void testClientServer () throws IOException, InterruptedException, ClassNotFoundException {

        final GameServer server = new GameServer(8080);

        new Thread(server).start();

        assertEquals(0, server.getPlayerList().size());
    }

    @Test
    public void testClient () {
        PlayerClient client = new PlayerClient();
        assertEquals(8080, client.getPort());
    }
}
