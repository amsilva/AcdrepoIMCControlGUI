package view;

import java.util.ArrayList;

import rule.IMC;
import entidade.Avaliacao;
import entidade.Pessoa;

public class Controle {

	ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();

	public void cadastraPessoa(String nome) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		listaPessoas.add(pessoa);
	}

	public void incluiAvaliacaoPessoaSelecionada(int sel, double na, double np) {

		Pessoa p = listaPessoas.get(sel);
		p.setAltura(na);
		p.setPeso(np);

		double novoImc = IMC.calcular(p);
		String novaSituacao = IMC.situacao(novoImc);

		Avaliacao novaAvaliacao = new Avaliacao(novoImc, novaSituacao);

		p.adicionaAvaliacao(novaAvaliacao);

	}

	@Deprecated
	public Pessoa recuperaPessoaSelecionada(int sel) {
		Pessoa p = listaPessoas.get(sel);
		return p;
	}

	@Deprecated
	public ArrayList<Avaliacao> recuperaAvaliacoesPessoaSelecionada(int sel) {
		Pessoa p = listaPessoas.get(sel);
		return p.getAvaliacoes();
	}

}
