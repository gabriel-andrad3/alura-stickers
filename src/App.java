import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
                
        // fazer uma conexão HTTP e buscar os top 250 filmes        
        String urlMock = "https://api.mocki.io/v2/549a5d8b";        
        URI uri = URI.create(urlMock);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        
        // extrair só os dados que interessam (título, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        

        // exibir e manipular os dados
        // RatingToStars ratingToStars = new RatingToStars(); 

        var geradora = new GeradoraDeFigurinhas();
        for (Map<String,String> filme : listaDeFilmes) {            
            String urlImagem = filme.get("image");
            String titulo = filme.get("title");
            
            InputStream inputStream = new URL(urlImagem).openStream();            
            String nomeArquivo = titulo + ".png";

            geradora.cria(inputStream, nomeArquivo);
            
            System.out.println(titulo);
            System.out.println();
            // System.out.println("Nota: " + "\u001b[106;1m" + filme.get("imDbRating") + "\u001b[m");
            // System.out.println("Estrelas: " + ratingToStars.transformRatingInStars(Float.parseFloat(filme.get("imDbRating")))); FIXME: não mostra os emojis
        }
    }
}
