package br.com.alura.screenmatch;

import br.com.alura.screenmatch.configurations.MoovieAPIConfig;
import br.com.alura.screenmatch.enums.Methods;
import br.com.alura.screenmatch.model.DataSeries;
import br.com.alura.screenmatch.service.converter.DataConverter;
import br.com.alura.screenmatch.service.http.HttpMethods;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String url = MoovieAPIConfig.URL + "&t=gilmore+girls&Season=1";
		var json = HttpMethods.request(url, Methods.GET);
		DataConverter converter = new DataConverter();

		DataSeries dataSeries = converter.obtainData(json, DataSeries.class);
		System.out.println(dataSeries);
	}
}
