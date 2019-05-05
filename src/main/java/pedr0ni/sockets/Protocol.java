package pedr0ni.sockets;

import java.io.Serializable;
import java.util.Objects;

public class Protocol implements Serializable {

    private static final long serialVersionUID = -4157295999428047778L;
    private String command;
    private Object[] args;

    public Protocol(String command, Object[] args) {
        this.command = command;
        this.args = args;
    }

    public String getCommand() {
        return this.command;
    }

    public Object[] getArgs() {
        return this.args;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Protocol))
            return false;

            Protocol protocol = (Protocol) o;
        return Objects.equals(command, protocol.command) && Objects.equals(args, protocol.args);
    }

    @Override
    public int hashCode() {
        return Objects.hash(command, args);
    }


    @Override
    public String toString() {
        return "{" +
            " command='" + getCommand() + "'" +
            ", args='" + getArgs() + "'" +
            "}";
    }

}