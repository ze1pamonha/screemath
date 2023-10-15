package br.com.alura.screemath;

import br.com.alura.screemath.model.DadosSerie;
import br.com.alura.screemath.service.ConsumoApi;
import br.com.alura.screemath.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreemathApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreemathApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("primeiro prjeto SPring sem web");
		var consumoApi=new ConsumoApi();
		var json=consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=e0509044");
		//System.out.println(json);
		//json=consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);

		ConverteDados conversor=new ConverteDados();
		DadosSerie dados=conversor.obterDados(json,DadosSerie.class);
		System.out.println(dados);

	}
}
