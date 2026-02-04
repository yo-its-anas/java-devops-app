import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Main {

    private static final int PORT = 8080;
    private static final String TIPS_FILE = "tips.txt";

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

        server.createContext("/", new TipHandler());
        server.setExecutor(null);

        System.out.println("DevOps Tip app running on port " + PORT);
        server.start();
    }

    static class TipHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            List<String> tips = Files.readAllLines(Paths.get(TIPS_FILE));
            String tip = tips.get(new Random().nextInt(tips.size()));

            String response = """
                <html>
                  <head>
                    <title>DevOps Tip of the Day</title>
                    <style>
                      body {
                        font-family: Arial, sans-serif;
                        background-color: #f4f4f4;
                        padding: 40px;
                      }
                      .card {
                        background: white;
                        padding: 20px;
                        border-radius: 8px;
                        box-shadow: 0 2px 6px rgba(0,0,0,0.1);
                      }
                    </style>
                  </head>
                  <body>
                    <div class="card">
                      <h1>DevOps Tip of the Day</h1>
                      <p>%s</p>
                    </div>
                  </body>
                </html>
                """.formatted(tip);

            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
