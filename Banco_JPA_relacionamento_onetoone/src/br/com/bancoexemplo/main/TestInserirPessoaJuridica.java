package br.com.bancoexemplo.main;

import br.com.bancoexemplo.modelo.PessoaJuridica;
import br.com.bancoexemplo.modelo.UF;
import br.com.bancoexemplo.service.GenericService;
import br.com.bancoexemplo.util.UtilEntityManager;

public class TestInserirPessoaJuridica {

	public static void main(String[] args) {
		PessoaJuridica p = new PessoaJuridica();

		p.setNome("pessoaJuridica1");
		p.setCnpj("111.111.111-11");
		p.setRazaoSocial("razao1");
		p.getEndereco().setCidade("Sao Paulo");
		p.getEndereco().setEstado(UF.SP);
		p.getEndereco().setLogradouro("13 de maio");

		GenericService<PessoaJuridica> service = new GenericService<PessoaJuridica>(
				PessoaJuridica.class);

		PessoaJuridica pessoaJuridica = service.inserir(p);

		System.out.println(pessoaJuridica.getId());
		UtilEntityManager.close();
	}
}
