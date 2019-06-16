package br.com.correcao.sped.registro.editacampo0500;

import java.io.IOException;
import java.util.Properties;

public abstract class ContaContabil {
	protected String[] vetorArquivo;
	protected String resourcesName;
	
	public abstract String DevolveStringCorrigida();
	
	public void InserindoTitulo(){
		try {
			Properties prop = new Properties();
			prop.load(getClass().getResourceAsStream(this.resourcesName));
			this.vetorArquivo[7] = prop.getProperty(this.vetorArquivo[6]);
		} catch (IOException e) {
			System.out.println("erro no metodo abstrato das Contas Contabeis");
			e.printStackTrace();
		}
	}
	
	
	protected String ConcatenaString() {
		StringBuilder builder = new StringBuilder();
		String stringFinal;

		for (int i = 0; i < this.vetorArquivo.length; i++) {
			builder.append(this.vetorArquivo[i]).append("|");
		}

		stringFinal = builder.substring(0, builder.length() - 1);
		return stringFinal;
	}

	
}
