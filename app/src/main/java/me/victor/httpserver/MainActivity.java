package me.victor.httpserver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.koushikdutta.async.http.server.AsyncHttpServer;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import com.koushikdutta.async.http.server.AsyncHttpServerResponse;
import com.koushikdutta.async.http.server.HttpServerRequestCallback;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AsyncHttpServer server = new AsyncHttpServer();
        server.get("/", new HttpServerRequestCallback() {
            @Override
            public void onRequest(AsyncHttpServerRequest request, AsyncHttpServerResponse response) {
                String result = "Hello!!!" + System.currentTimeMillis();
                response.send(result);
                System.out.println(result);
            }
        });
        server.listen(5000);
    }
}
