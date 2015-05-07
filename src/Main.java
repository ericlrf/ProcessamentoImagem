
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Imagem img = new Imagem("C:/Users/rfpn/Dropbox/Public/CodigoPPOO/TemplateMethod/src/lena.pgm");
		
		Brilho b= new Brilho(50);
		Imagem resultado = b.executar(img); 
		resultado.escreverImagem("brilho.pgm");
		Contraste c= new Contraste(1.5f);
		resultado = c.executar(img); 
		resultado.escreverImagem("contraste.pgm");
		
		
	}

}
