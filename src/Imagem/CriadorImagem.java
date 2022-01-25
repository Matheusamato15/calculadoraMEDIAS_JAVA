package Imagem;

import javax.swing.ImageIcon;

public class CriadorImagem {
	public ImageIcon imagemFundo(String path, String description) {
        java.net.URL URLImagem = getClass().getClassLoader().getResource(path);
        if (URLImagem != null) {
            return new ImageIcon(URLImagem, description);
        } else {
            System.err.println("N�o encontrei o arquivo: " + path);
            return null;
        }
    }
	
}
