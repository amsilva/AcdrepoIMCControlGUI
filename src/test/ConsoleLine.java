package test;
import entidade.Avaliacao;
import entidade.Pessoa;
import rule.IMC;

public class ConsoleLine {

	
	
	public void executar(){
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Piedade Limas");
		pessoa.setAltura(1.70);
		pessoa.setPeso(72.0);
					
		
		//double novoIndice = IMC.calcular(p.peso, p.altura);
		double novoIndice = IMC.calcular(pessoa);
		String novaSituacao = IMC.situacao(novoIndice);
		Avaliacao aval = new Avaliacao(novoIndice, novaSituacao);
		pessoa.adicionaAvaliacao(aval);

		//avaliacao 2;
		pessoa.setAltura(1.70);
		pessoa.setPeso(65.0);
		novoIndice = IMC.calcular(pessoa);
		novaSituacao = IMC.situacao(novoIndice);
		Avaliacao aval2 = new Avaliacao(novoIndice, novaSituacao);
		pessoa.adicionaAvaliacao(aval2);

		//avaliacao 2;
		pessoa.setAltura(1.70);
		pessoa.setPeso(60.0);
		novoIndice = IMC.calcular(pessoa);
		novaSituacao = IMC.situacao(novoIndice);
		Avaliacao aval3 = new Avaliacao(novoIndice, novaSituacao);
		pessoa.adicionaAvaliacao(aval3);
		
		Relatorio report = new Relatorio();
		report.mostrar(pessoa);
		
		System.out.println("fim");
	}
	
	
	
}





