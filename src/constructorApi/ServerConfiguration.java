package constructorApi;

import java.net.InetSocketAddress;

public class ServerConfiguration {

    private static ServerConfiguration serverConfiguration;

    private final InetSocketAddress serverAddress;
    private final String greetingMessage;

    public ServerConfiguration(int port, String greetingMessage) {
        this.serverAddress = new InetSocketAddress("localhost", port);
        this.greetingMessage = greetingMessage;
    }

    public static ServerConfiguration getInstance(){
        return serverConfiguration;
    }

    public InetSocketAddress getServerAddress() {
        return serverAddress;
    }

    public String getGreetingMessage() {
        return greetingMessage;
    }
}
