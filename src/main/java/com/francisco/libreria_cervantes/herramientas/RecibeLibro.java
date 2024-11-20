package com.francisco.libreria_cervantes.herramientas;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RecibeLibro {
    private final String URL_BASE =  "https://gutendex.com/books/?search=";
    private final String ESP = "&languages=es";
    private final String ORDEN = "/books/?languages=es&sort";
    private final String LISTA ="/books/?ids=";


    public String reciveLibro(String busqueda) throws IOException, InterruptedException {
        String url = URL_BASE+busqueda.replace(" ", "%20");
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }

//    public String populares() throws IOException, InterruptedException {
//        String url = URL_BASE.replace("/books/?search=", "")+ORDEN;
//        HttpClient client = HttpClient.newHttpClient();
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .build();
//
//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println)
//                .join();
//
//        HttpResponse<String> response = client
//                .send(request, HttpResponse.BodyHandlers.ofString());
//        return response.body();
//
//
//    }
//    public String popularesLista(String ids) throws IOException, InterruptedException {
//        String url = URL_BASE.replace("/books/?search=", "")+LISTA+ids;
//        HttpClient client = HttpClient.newHttpClient();
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .build();
//
//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println)
//                .join();
//
//        HttpResponse<String> response = client
//                .send(request, HttpResponse.BodyHandlers.ofString());
//        return response.body();



}
