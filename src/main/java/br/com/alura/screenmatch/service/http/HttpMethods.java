package br.com.alura.screenmatch.service.http;

import br.com.alura.screenmatch.enums.Methods;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpMethods {

	public static String request(String url, Methods methods) throws RuntimeException {
		return request(url, methods, null);
	}

	public static String request(String url, Methods method, String body) throws RuntimeException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest.BodyPublisher bodyPublisher = null;

		HttpRequest.Builder builder = HttpRequest.newBuilder();
		builder.uri(URI.create(url));

		if (body != null && !body.isEmpty()) {
			bodyPublisher = HttpRequest.BodyPublishers.ofString(body);
		} else {
			bodyPublisher = HttpRequest.BodyPublishers.noBody();
		}

		builder.method(method.name(), bodyPublisher);

		HttpRequest request = builder.build();

		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			return response.body();
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
