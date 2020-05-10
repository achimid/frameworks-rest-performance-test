import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class JavaHTTPServer {

   private final static int PORT = 8383;
   private final static int BACKLOG = 10;

   public static void main(String[] args) throws Exception
   {
      new JavaHTTPServer().start();
   }

   private void start() throws Exception
   {
      HttpServer server = HttpServer.create(new InetSocketAddress(PORT), BACKLOG);

      server.createContext("/hello", new TestHandler());
      server.setExecutor(Executors.newCachedThreadPool());
      server.start();

      System.out.println("Server Started on " + PORT);
   }

   class TestHandler implements HttpHandler
   {
      @Override
      public void handle(HttpExchange httpExchange) throws IOException
      {
         String body = "hello";

         httpExchange.sendResponseHeaders(200, body.length());
         OutputStream outputStream = httpExchange.getResponseBody();

         outputStream.write(body.getBytes("UTF-8"));
         outputStream.close();
      }
   }
}