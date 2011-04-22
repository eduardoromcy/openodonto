package br.ueg.openodonto.controle.busca;

import java.lang.reflect.Field;
import java.util.ArrayList;

import br.com.simple.jdbc.orm.OrmResolver;
import br.com.simple.jdbc.orm.OrmTranslator;
import br.ueg.openodonto.controle.servico.ExampleRequest;
import br.ueg.openodonto.dominio.Usuario;
import br.ueg.openodonto.persistencia.dao.sql.SqlWhereOperatorType;
import br.ueg.openodonto.servico.busca.FieldFacade;
import br.ueg.openodonto.servico.busca.MessageDisplayer;
import br.ueg.openodonto.validator.EmptyValidator;
import br.ueg.openodonto.validator.NullValidator;
import br.ueg.openodonto.validator.Validator;
import br.ueg.openodonto.validator.ValidatorFactory;

public class SearchableUsuario extends AbstractSearchable<Usuario>{

	public SearchableUsuario(MessageDisplayer displayer) {
		super(Usuario.class, displayer);
	}

	private static final long serialVersionUID = -3337119630038867463L;

	@Override
	protected void buildFacade() {
		super.buildFacade();
		OrmTranslator translator = new OrmTranslator(OrmResolver.getAllFields(new ArrayList<Field>(), Usuario.class, true));
		getFacade().add(new FieldFacade("C�digo",translator.getColumn("codigo")));
		getFacade().add(new FieldFacade("Nome",translator.getColumn("nome")));
		getFacade().add(new FieldFacade("Usu�rio",translator.getColumn("user")));
	}
	
	@Override
	protected void buildFilter() {
		super.buildFilter();
		buildCodigoFilter();
		buildUserFilter();
		buildNameFilter();
	}
	
	private void buildCodigoFilter(){
		Validator validator = ValidatorFactory.newNumMax(Integer.MAX_VALUE);
		getFiltersMap().put("idFilter",buildBasicFilter("idFilter","C�digo",validator));
	}
	
	private void buildUserFilter(){
		Validator validator = ValidatorFactory.newStrRangeLen(45,3, true);
		getFiltersMap().put("userFilter", buildBasicFilter("userFilter","Usu�rio",validator));
	}
	
	private void buildNameFilter(){
		Validator validator = ValidatorFactory.newStrRangeLen(100,3, true);
		getFiltersMap().put("nomeFilter", buildBasicFilter("nomeFilter","Nome",validator));
	}
	
	@Override
	public Usuario buildExample() {
		ExampleRequest<Usuario> request  = new ExampleRequest<Usuario>(this);		
		request.getFilterRelation().add(request.new TypedFilter("nomeFilter", "nome",SqlWhereOperatorType.LIKE));
		request.getFilterRelation().add(request.new TypedFilter("idFilter","codigo",SqlWhereOperatorType.EQUAL));
		request.getFilterRelation().add(request.new TypedFilter("userFilter", "user",SqlWhereOperatorType.EQUAL));
		request.getInvalidPermiteds().add(NullValidator.class);
		request.getInvalidPermiteds().add(EmptyValidator.class);
		Usuario target = getManageExample().processExampleRequest(request);
		return target;
	}

}
