import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
// import java.io.FileInputStream;
// import java.net.URL;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

  public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

    // leitura da imagem
    // InputStream inputStream = new FileInputStream(new File("entrada/filme-maior.jpg"));
    // InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
    BufferedImage imagemOriginal = ImageIO.read(inputStream);

    // cria nova imagem em memória com transparência e com tamanho novo
    int largura = imagemOriginal.getWidth();
    int altura = imagemOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    // copiar a imagem original pra nova imagem (em memória)
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imagemOriginal, 0, 0, null);

    // configurar a fonte
    Font fonte = new Font("Impact", Font.BOLD, 64);
    graphics.setFont(fonte);

    // escrever uma frase na nova imagem
    graphics.setColor(Color.YELLOW);
    graphics.drawString("TOPZERA", 100, novaAltura - 100);

    // escrever a nova imagem em um arquivo
    File arquivoComPasta = new File("../saida/" + nomeArquivo);
    arquivoComPasta.getParentFile().mkdirs();
    ImageIO.write(novaImagem, "png", arquivoComPasta);
  }

  public static void main(String[] args) throws Exception {
    // InputStream inputStream = new FileInputStream(new File("entrada/filme-maior.jpg"));
    // // var url = "https://m.media-amazon.com/images/M/MV5BMWMwMGQzZTItY2JlNC00OWZiLWIyMDctNDk2ZDQ2YjRjMWQ0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX128_CR0,1,128,176_AL_.jpg";    
    // // InputStream inputStream = new URL(url).openStream();
    // var geradora = new GeradoraDeFigurinhas();
    // geradora.cria(inputStream, "figurinha-impact.png");
  }
}