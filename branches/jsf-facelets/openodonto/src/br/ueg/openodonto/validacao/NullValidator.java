package br.ueg.openodonto.validacao;

import br.ueg.openodonto.validacao.tipo.ObjectValidatorType;

public class NullValidator extends AbstractValidator implements ObjectValidatorType{

	public NullValidator(Object value) {
		super(null , value);
	}
	
	public NullValidator(Validator next) {
		super(next , next.getValue());
	}
	
	@Override
	protected boolean validate() {
		if(getValue() == null){
			setErrorMsg("O valor esta nulo.");
			return false;
		}
		return true;
	}

}
