package pedr0ni.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

    Socket client;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public Cliente(String host, int port) throws IOException {
        this.client = new Socket(host, port);
    }

    public boolean isConnected() {
        return this.client != null && !this.client.isClosed();
    }

    public void send(Object obj) throws IOException {
        if (this.outputStream == null)
            this.outputStream = new ObjectOutputStream(this.client.getOutputStream());
        this.outputStream.writeObject(obj);
        this.outputStream.flush();
    }

    public void close() throws IOException {
        this.outputStream.close();
        this.inputStream.close();
        this.client.close();
    }

}