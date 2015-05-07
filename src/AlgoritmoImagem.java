
public abstract class AlgoritmoImagem {

	protected int validar(int pixel){
		int p = pixel;
		if (pixel > 255)
			p = 255;
		else if(pixel < 0)
			p = 0;
		return p;
	}
	
	protected abstract int updatePixel(int i, int j, Imagem img);
	
	public Imagem executar(Imagem img){
		Imagem processada =  (Imagem)img.clone();
		int pixel;
		for(int i = 0; i< processada.getAltura(); i++){
			for(int j = 0; j < processada.getLargura(); j++){
				pixel = this.updatePixel(i, j, img);
				pixel = validar(pixel);
				processada.setPixel(i, j, pixel);
			}
		}
		return processada;
		
	}
	

}
