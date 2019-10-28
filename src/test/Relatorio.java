package test;

import entidade.Avaliacao;
import entidade.Pessoa;

public class Relatorio {

	public void mostrar(Pessoa pessoa){
		System.out.println("\n*****");
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("Altura: " + pessoa.getAltura());
		System.out.println("Peso: " + pessoa.getPeso());
		for (Avaliacao a : pessoa.getAvaliacoes()) {
			System.out.println("-----");
			System.out.println("Avaliacao: " + a.getData());
			System.out.println("Indice IMC: " + a.getIndice());
			System.out.println("Situacao IMC: " + a.getSituacao());
		}		
		System.out.println("\n");
		
	}
	
	
}
