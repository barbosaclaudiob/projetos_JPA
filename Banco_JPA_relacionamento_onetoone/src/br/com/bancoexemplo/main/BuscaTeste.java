package br.com.bancoexemplo.main;

import br.com.bancoexemplo.modelo.Pessoa;
import br.com.bancoexemplo.service.PessoaService;

public class BuscaTeste {

	public static void main(String[] args) {
		PessoaService service = new PessoaService();
		
		for (Pessoa p : service.listPessoaPorDDD("19")) {
			System.out.println(p);
		}
	}
}
