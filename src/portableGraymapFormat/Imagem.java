import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Imagem {
	private String caminho;
	private int matriz[][];
	private String tipo;
	private int altura;
	private int largura;
	private int qtdTons;

	public int LerImagem(){		
		FileReader file;
		int retorno = 0;
		try {
			file = new FileReader(caminho);
			BufferedReader br = new BufferedReader(file);
			String s;
			String arr[];
			int i = 0, j = 0;
			try {
				this.tipo = br.readLine();
				s = br.readLine();
				arr = s.split(" ");
				
				this.largura = Integer.parseInt(arr[0]);
				
				this.altura = Integer.parseInt(arr[1]);
				s = br.readLine();
				this.qtdTons = Integer.parseInt(s);
				this.matriz = new int[this.altura][this.largura];
								
				while((s = br.readLine()) != null) {
					if(s.length()>0){
						arr = s.split(" ");					
						for(int a=0; a < arr.length; a++){
							this.matriz[i][j] = Integer.parseInt(arr[a]);
							j++;
							if(j == largura){
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
	
	public int EscreverImagem(String caminho){
		int retorno = 0;
		FileWriter file;
		String temp = new String();
		int i, j;
		
		try {
			file = new FileWriter(caminho);
			
			BufferedWriter bw= new BufferedWriter(file);
			bw.write(this.tipo,0,this.tipo.length());
			bw.newLine();
			temp = String.format("%d %d",this.altura, this.largura);
			bw.write(temp,0, temp.length());
			bw.newLine();
			temp = String.format("%d\n", this.qtdTons);
			bw.write(temp,0, temp.length());
			
			for(i = 0; i < altura; i++){
				for(j = 0; j< largura; j++){
					temp = String.format("%d ",(this.matriz[i][j]));
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
	
	public Imagem(String caminho){
		this.caminho = caminho;
	}
	
	
	

}
