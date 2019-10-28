package entidade;
import java.util.Date;

public class Avaliacao {

	private double indice;
	private String situacao;
	private Date data;
	
	public Avaliacao(double i, String s) {
		this.indice = i;
		this.situacao = s;
		this.data = new Date();
	}
	
	public double getIndice() {
		return this.indice;
	}

	public String getSituacao() {
		return situacao;
	}

	public Date getData() {
		return data;
	}
	
	
	
	
	
}
