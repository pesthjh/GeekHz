import mixHttpClient.netty.NettyHttpServer;

public class NettyTest {
    public static void main(String[] args) throws InterruptedException{
        int port = 8089;
        String httpServer  = "http://127.0.0.1:8801";
        NettyHttpServer.start(port,httpServer);
    }
}
