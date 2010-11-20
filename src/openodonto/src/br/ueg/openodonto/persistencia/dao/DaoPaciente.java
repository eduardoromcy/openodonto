package br.ueg.openodonto.persistencia.dao;

import java.util.List;
import java.util.Map;

import br.ueg.openodonto.dominio.Odontograma;
import br.ueg.openodonto.dominio.Paciente;
import br.ueg.openodonto.dominio.Telefone;
import br.ueg.openodonto.persistencia.EntityManager;
import br.ueg.openodonto.persistencia.orm.Dao;

@Dao(classe=Paciente.class)
public class DaoPaciente extends DaoAbstractPessoa<Paciente>{

    private static final long serialVersionUID = -4278752127118870714L;

	public DaoPaciente() {
		super(Paciente.class);
	}

	@Override
	public Paciente getNewEntity() {
		return new Paciente();
	}
	
	@Override
	protected void afterUpdate(Paciente o) throws Exception {
		super.afterUpdate(o);
		updateRelationshipOdontograma(o);
		updateRelationshipAnaminese(o);
		updateRelationshipPlanejamento(o);
	}
	
	private void updateRelationshipOdontograma(Paciente o) throws Exception{
		EntityManager<Odontograma> entityManagerOdontograma = DaoFactory.getInstance().getDao(Odontograma.class);
		DaoOdontograma daoOdontograma = (DaoOdontograma)entityManagerOdontograma;
		daoOdontograma.updateRelationshipPaciente(o.getOdontogramas(), o.getCodigo());
	}
	
	private void updateRelationshipAnaminese(Paciente o){
		
	}
	
	private void updateRelationshipPlanejamento(Paciente o){
		
	}
	
	@Override
	protected void afterInsert(Paciente o) throws Exception {
		super.afterInsert(o);
		updateRelationshipOdontograma(o);
		updateRelationshipAnaminese(o);
		updateRelationshipPlanejamento(o);
	}	
	
	@Override
	public List<Paciente> listar(boolean lazy, String... fields) {
		EntityManager<Telefone> entityManagerTelefone = DaoFactory.getInstance().getDao(Telefone.class);
		EntityManager<Odontograma> entityManagerOdontograma = DaoFactory.getInstance().getDao(Odontograma.class);
		DaoTelefone daoTelefone = (DaoTelefone) entityManagerTelefone;
		DaoOdontograma daoOdontograma = (DaoOdontograma) entityManagerOdontograma;
		List<Paciente> lista = super.listar(lazy, fields);
		if (lista != null && !lazy) {
			for (Paciente paciente : lista) {
				try {
					paciente.setTelefone(daoTelefone.getTelefonesRelationshipPessoa(paciente.getCodigo()));
					paciente.setOdontogramas(daoOdontograma.getOdontogramasRelationshipPaciente(paciente.getCodigo()));
				} catch (Exception ex) {
				}
			}
		}
		return lista;
	}
	
	@Override
	public void afterLoad(Paciente o) throws Exception {
		super.afterLoad(o);
		loadOdontograma(o);
		loadAnaminese(o);
		loadPlanejamento(o);
	}

	private void loadOdontograma(Paciente o) throws Exception{
		EntityManager<Odontograma> entityManagerOdontograma = DaoFactory.getInstance().getDao(Odontograma.class);
		DaoOdontograma daoOdontograma = (DaoOdontograma)entityManagerOdontograma;
		List<Odontograma> odontogramas = daoOdontograma.getOdontogramasRelationshipPaciente(o.getCodigo());
		o.setOdontogramas(odontogramas);
	}
	
	private void loadAnaminese(Paciente o){		
	}
	
	private void loadPlanejamento(Paciente o){		
	}
	
	@Override
	protected boolean beforeRemove(Paciente o, Map<String, Object> params)throws Exception {
		boolean referenced = super.beforeRemove(o, params);
		removeOdontograma(o);
		removeAnamise(o);
		removePlanejamento(o);
		return referenced;
	}
	
	private void removeOdontograma(Paciente o) throws Exception{
		EntityManager<Odontograma> entityManagerOdontograma = DaoFactory.getInstance().getDao(Odontograma.class);
		for (Odontograma odontograma : o.getOdontogramas()) {
			entityManagerOdontograma.remover(odontograma);			
		}
	}
	
	private void removeAnamise(Paciente o){
	}
	
	private void removePlanejamento(Paciente o){		
	}
	
}