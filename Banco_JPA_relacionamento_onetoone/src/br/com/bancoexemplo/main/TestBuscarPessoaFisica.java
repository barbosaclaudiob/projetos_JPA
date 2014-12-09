package br.com.bancoexemplo.main;

import java.util.List;

import br.com.bancoexemplo.modelo.Contato;
import br.com.bancoexemplo.modelo.Pessoa;
import br.com.bancoexemplo.modelo.PessoaFisica;
import br.com.bancoexemplo.modelo.UF;
import br.com.bancoexemplo.service.PessoaService;
import br.com.bancoexemplo.util.UtilEntityManager;


public class TestBuscarPessoaFisica {

	public static void main(String[] args) {
		try {
//			//busca pessoas por estados
//			PessoaService Ps = new PessoaService();
//			
//			List<Pessoa> list = Ps.buscarPor(UF.MG);
//			
//			for (Pessoa pessoa : list) {
//				System.out.println(pessoa.getNome());
//			}
			
			//buscar pessoas pelo DDD do telefone de contato
//			PessoaService Ps = new PessoaService();
//			
//			List<Pessoa> list = Ps.listPessoaPorDDD("011");
//			
//			for (Pessoa p : list) {
//				System.out.println(p.getNome());
//			}
			
			PessoaService Ps = new PessoaService();
			
			List<Contato> list = Ps.listContatoPorEstado(UF.MG);
			
			for (Contato c : list) {
				System.out.println(c.getDescricao());
			}
		} finally {
			UtilEntityManager.close();
		}
	}
}
