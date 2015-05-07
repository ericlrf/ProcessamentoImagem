
public class Negativa extends AlgoritmoImagem {

	protected int updatePixel(int i, int j, Imagem img) {
		return 255 - img.getPixel(i, j);
	}

	
}
