package pedr0ni.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;

import pedr0ni.models.Musica;

public class Servidor {

    Socket client;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public Servidor(String host, int port) throws IOException {
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

    public Protocol request(Protocol model) throws IOException, ClassNotFoundException {
        System.out.println("Sent");
        this.send(model);
        Protocol received = (Protocol) new ObjectInputStream(this.client.getInputStream()).readObject();
        return received;
    }

    public void close() throws IOException {
        this.outputStream.close();
        this.inputStream.close();
        this.client.close();
    }

    public Socket getSocket() {
        return this.client;
    }

    public Musica[] getAll() throws IOException, ClassNotFoundException {
        Protocol res = request(new Protocol("con", new Object[] {""}));
        return Arrays.copyOf(res.getArgs(), res.getArgs().length, Musica[].class);
    }

}