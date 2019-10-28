package rule;
import entidade.Pessoa;

public class IMC {

	@Deprecated
	public static double calcular(double p, double a){
		
		return calcularGeral(p, a);
		
	}
	

	public static double calcular(Pessoa pessoa){
		
		return calcularGeral(pessoa.getPeso() , pessoa.getAltura());
	}
	
	
	private static double calcularGeral(double peso, double altura){
		
		return peso / (altura * altura);
		
	}
	
	
	
	
	
	public static String situacao(double indice){
		String situacao;
		
		if (indice <= 20) 
			situacao = "MAGRO";
		else if (indice > 28)
			situacao = "ACIMA DO PESO";
		else 
			situacao = "NORMAL";

		return situacao;
		
	}
	
	
	
	
	
	
}
