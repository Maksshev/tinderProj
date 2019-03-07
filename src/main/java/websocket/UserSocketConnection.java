package websocket;

public class UserSocketConnection {
    private MessagesSocket messagesSocket;
    private int senderId;
    private int receiverId;

    public UserSocketConnection(MessagesSocket messagesSocket, int senderId, int receiverId) {
        this.messagesSocket = messagesSocket;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public MessagesSocket getMessagesSocket() {
        return messagesSocket;
    }

    public void setMessagesSocket(MessagesSocket messagesSocket) {
        this.messagesSocket = messagesSocket;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSocketConnection that = (UserSocketConnection) o;

        if (senderId != that.senderId) return false;
        if (receiverId != that.receiverId) return false;
        return messagesSocket.equals(that.messagesSocket);
    }

    @Override
    public int hashCode() {
        int result = messagesSocket.hashCode();
        result = 31 * result + senderId;
        result = 31 * result + receiverId;
        return result;
    }

    @Override
    public String toString() {
        return "UserSocketConnection{" +
                "messagesSocket=" + messagesSocket +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                '}';
    }
}
