package br.ueg.openodonto.dominio.constante;

import br.com.simple.jdbc.Entity;

public interface PessoaJuridica<T extends Entity> {
	String getCnpj();
}
