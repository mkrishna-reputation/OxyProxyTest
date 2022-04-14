import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.ListenableFuture;
import com.ning.http.client.ProxyServer;
import com.ning.http.client.Request;
import com.ning.http.client.RequestBuilder;
import com.ning.http.client.Response;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Created by mohan on 12/04/22
 */
public class AhcWebhawkTest {

    public static void main(String[] args) {
        String userName="";
        String password="";

        AsyncHttpClient client = new AsyncHttpClient();
        RequestBuilder builder = new RequestBuilder("GET", false);
        builder.setUrl("https://www.judysbook.com/Ferry-Farm-Animal-Clinic-Ltd-BtoB~Veterinary-Services-fredericksburg-va-r28298533.htm");
        ProxyServer proxyServer = new ProxyServer(ProxyServer.Protocol.HTTP, "dc.pr.oxylabs.io", 10000, userName, password);
        builder.setProxyServer(proxyServer);
        Request ahcRequest = builder.build();
        ListenableFuture<Response> future = client.executeRequest(ahcRequest);
        try {
            System.out.println(future.get().getResponseBody());
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
