package com.javagda25.tasks;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Manager {
   private final HttpClient client = HttpClient.newBuilder().build();
   private final Gson gson = new Gson();
   private HttpRequest request;
   private StringBuilder stringBuilder;
   private ScannerLoader scannerLoader = new ScannerLoader();

   public List get (String uri) {
       request = HttpRequest
                .newBuilder(URI.create(uri))
                .GET()
                .build();

       HttpResponse<String> response = null;
       try {
           response = client.send(request, HttpResponse.BodyHandlers.ofString());
       } catch (IOException | InterruptedException e) {
           e.printStackTrace();
       }
       return gson.fromJson(response.body(), List.class);
   }

   public boolean delete (String uri) {
//       stringBuilder.append(uri).append("/").append(String.valueOf(id));
       Integer id = scannerLoader.returnId();
       request = HttpRequest
               .newBuilder(URI.create(uri + "/" + String.valueOf(id)))
               .DELETE()
               .build();

       HttpResponse<String> response = null;
       try {
           response = client.send(request, HttpResponse.BodyHandlers.ofString());
       } catch (IOException e) {
           e.printStackTrace();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       return gson.fromJson(response.body(), Boolean.class);
   }

   public void post (String uri) {
       String jsonTask = gson.toJson(scannerLoader.editTask());

       request = HttpRequest
                .newBuilder(URI.create(uri))
                .POST(HttpRequest.BodyPublishers.ofString(jsonTask))
                .header("Content-Type", "application/json")
                .build();

       try {
           client.send(request, HttpResponse.BodyHandlers.ofString());
       } catch (IOException e) {
           e.printStackTrace();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }

   public void put (String uri) {
       String jsonTask = gson.toJson(scannerLoader.newTask());

       request = HttpRequest.newBuilder(URI.create(uri))
               .PUT(HttpRequest.BodyPublishers.ofString(jsonTask))
               .header("Content-Type", "application/json")
               .build();

       try {
           client.send(request, HttpResponse.BodyHandlers.ofString());
       } catch (IOException e) {
           e.printStackTrace();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
}
