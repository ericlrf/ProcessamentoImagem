
public class Contraste extends AlgoritmoImagem {

	float contraste;
	
	public Contraste(float d){
		this.contraste = d;
	}
	
	protected int updatePixel(int i, int j, Imagem img) {		
		return Math.round(img.getPixel(i, j)* contraste);
	}	

	

}
