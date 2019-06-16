package br.com.correcao.sped.nfe;

import java.io.IOException;
import java.util.Properties;

public abstract class CFOP {
	protected String[] arquivo;
	protected String resourcesName;
	
	
	public abstract String DevolverStringCorrigida();
	
	
	protected void InserirContaContabil(){
		try {
			Properties props = new Properties();
			props.load(getClass().getResourceAsStream(this.resourcesName));
			this.arquivo[37] = props.getProperty(this.arquivo[11]);
		} catch (IOException e) {
			System.out.println("Deu merda no metodo abstrato CFOP");
			e.printStackTrace();
		}		
	}
	
	
	protected String ConcatenaString() {
		StringBuilder builder = new StringBuilder();
		String stringFinal;

		for (int i = 0; i < this.arquivo.length; i++) {
			builder.append(this.arquivo[i]).append("|");
		}

		stringFinal = builder.substring(0, builder.length() - 1);
		return stringFinal;
	}

	
	
}
