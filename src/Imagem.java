import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Imagem {
	private String caminho;
	private int matriz[][];
	private String tipo;
	private int altura;
	private int largura;
	private int qtdTons;
	
	private Imagem (){		
	}
	
	public Imagem(String caminho){
		this.caminho = caminho;
		lerImagem();
	}
		
	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public String getTipo() {
		return tipo;
	}

	protected void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getAltura() {
		return altura;
	}

	protected void setAltura(int altura) {
		this.altura = altura;
	}

	public int getLargura() {
		return largura;
	}

	protected void setLargura(int largura) {
		this.largura = largura;
	}

	public int getQtdTons() {
		return qtdTons;
	}

	protected void setQtdTons(int qtdTons) {
		this.qtdTons = qtdTons;
	}

	public void setPixel(int i, int j, int pixel){
		this.matriz[i][j] = pixel;
	}
	
	public int getPixel(int i, int j){
		return this.matriz[i][j];
	}
	
	public Object clone(){
		Imagem img = new Imagem();
		img.setAltura(this.getAltura());
		img.setLargura(this.getLargura());
		img.setTipo(this.getTipo());
		img.setQtdTons(this.getQtdTons());
		img.matriz = new int[img.getAltura()][img.getLargura()];
		for(int i = 0; i< this.getAltura(); i++){
			for(int j = 0; j < this.getLargura(); j++){
				img.setPixel(i, j, this.getPixel(i, j));
			}
		}
		return img;
	}
	
	public int lerImagem(){		
		FileReader file;
		int retorno = 0;
		try {
			file = new FileReader(this.getCaminho());
			BufferedReader br = new BufferedReader(file);
			String s;
			String arr[];
			int i = 0, j = 0;
			try {
				this.setTipo(br.readLine());
				s = br.readLine();
				arr = s.split(" ");
				
	
				this.setLargura(Integer.parseInt(arr[0]));
				
				this.setAltura(Integer.parseInt(arr[1]));
				s = br.readLine();
				this.setQtdTons(Integer.parseInt(s));
				this.matriz = new int[this.getAltura()][this.getLargura()];
								
				while((s = br.readLine()) != null) {
					if(s.length()>0){
						arr = s.split(" ");					
						for(int a=0; a < arr.length; a++){
							this.matriz[i][j] = Integer.parseInt(arr[a]);
							j++;
							if(j == this.getLargura()){
								j = 0;
								i++;
							}
						}
					}
				}
			
				file.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				retorno = -1;
			}
			 
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			retorno = -1;
		}
		return retorno;
		
	}
	
	public int escreverImagem(String caminho){
		int retorno = 0;
		FileWriter file;
		String temp = new String();
		int i, j;
		
		try {
			file = new FileWriter(caminho);
			BufferedWriter bw= new BufferedWriter(file);
			bw.write(this.getTipo(),0,this.getTipo().length());
			bw.newLine();
			temp = Integer.toString(this.getLargura()) + " "+ Integer.toString(this.getAltura());
			bw.write(temp,0, temp.length());
			bw.newLine();
			temp = Integer.toString(this.getQtdTons());
			bw.write(temp,0, temp.length());
			bw.newLine();			
			for(i = 0; i < this.getAltura(); i++){
				for(j = 0; j< this.getLargura(); j++){
					temp = Integer.toString(this.matriz[i][j]) + " "; 
					bw.write(temp,0, temp.length());
				}
				bw.newLine();
			}
			
			file.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			retorno = -1;
		}
		
		return retorno;
	} 
	
	
	
	

}
