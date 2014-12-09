package br.com.bancoexemplo.main;

import br.com.bancoexemplo.modelo.ContaCorrente;
import br.com.bancoexemplo.modelo.Contato;
import br.com.bancoexemplo.modelo.PessoaFisica;
import br.com.bancoexemplo.modelo.TipoContato;
import br.com.bancoexemplo.modelo.UF;
import br.com.bancoexemplo.service.GenericService;
import br.com.bancoexemplo.service.PessoaService;
import br.com.bancoexemplo.util.UtilEntityManager;

public class TestInserirPessoaFisica {

	public static void main(String[] args) {
		try {
			PessoaFisica p = new PessoaFisica();
			
			p.setNome("pessoa7");
			p.setCpf("555.555.555-57");
			p.getEndereco().setCidade("Belo Horizonte");
			p.getEndereco().setEstado(UF.MG);
			p.getEndereco().setLogradouro("Rua 20");
			p.getContato().add(new Contato(TipoContato.TELEFONE, "055 5555-5557", "Telefone Residencial"));
			p.getContato().add(new Contato(TipoContato.TELEFONE, "055 95555-5557", "Telefone Celular"));
			p.getContato().add(new Contato(TipoContato.EMAIL, "pessoa7@pessoa7.com.br", "Email Particular"));
			
			PessoaService pService = new PessoaService();
			
			pService.inserir(p);
			
					
			System.out.println(p.toString());
		} finally {
			UtilEntityManager.close();
		}		
	}
}
