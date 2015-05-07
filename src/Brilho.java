
public class Brilho extends AlgoritmoImagem {

	int brilho;
	
	public Brilho(int brilho){
		this.brilho = brilho;
	}
	
	protected int updatePixel(int i, int j, Imagem img) {		
		return img.getPixel(i, j) + brilho;
	}	

}
