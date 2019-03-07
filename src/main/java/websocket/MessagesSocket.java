package websocket;


import org.eclipse.jetty.websocket.api.RemoteEndpoint;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class MessagesSocket extends WebSocketAdapter {

    private static Set<UserSocketConnection> connectedUsers = Collections.synchronizedSet(new CopyOnWriteArraySet<>());

    @Override
    public boolean isConnected() {
        return super.isConnected();
    }

    @Override
    public boolean isNotConnected() {
        return super.isNotConnected();
    }

    @Override
    public void onWebSocketClose(int statusCode, String reason) {
        super.onWebSocketClose(statusCode, reason);
        System.out.println("closed");
    }

    @Override
    public void onWebSocketConnect(Session sess) {
        super.onWebSocketConnect(sess);
        Map<String, List<String>> parameterMap = sess.getUpgradeRequest().getParameterMap();
        String senderIdStr = sess.getUpgradeRequest().getCookies().get(0).getValue();
        String receiverIdStr = parameterMap.get("to").get(0);
        int senderId = Integer.parseInt(senderIdStr);
        int receiverId = Integer.parseInt(receiverIdStr);
        UserSocketConnection userSocketConnection = new UserSocketConnection(this, senderId, receiverId);
        connectedUsers.add(userSocketConnection);
        System.out.println(connectedUsers);
    }

    @Override
    public void onWebSocketError(Throwable cause) {
        super.onWebSocketError(cause);
    }

    @Override
    public void onWebSocketText(String message) {
        super.onWebSocketText(message);
        System.out.println(super.getRemote());
        System.out.println(this.getSession().getUpgradeRequest().getParameterMap().get("from").get(0));
        System.out.println(message);
    }

    @Override
    public RemoteEndpoint getRemote() {
        System.out.println(super.getRemote());
        return super.getRemote();
    }

    @Override
    public Session getSession() {
        return super.getSession();
    }
}
