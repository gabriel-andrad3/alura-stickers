import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoImbd implements ExtratorDeConteudo {

    public List<Conteudo> extraiConteudos(String json) {
      
      // extrair só os dados que interessam (título, poster, classificação)
      var parser = new JsonParser();
      List<Map<String, String>> listaDeAtributos = parser.parse(json);

      List<Conteudo> conteudos = new ArrayList<>();

      for (Map<String, String> atributo : listaDeAtributos) {
        String titulo = atributo.get("title");
        String urlImagem = atributo.get("image").
          replaceAll("(@+)(.*).jpg$", "$1.jpg");;
        var conteudo = new Conteudo(titulo, urlImagem);

        conteudos.add(conteudo);
      }

      return conteudos;
    }
}
