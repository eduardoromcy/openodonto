package br.ueg.openodonto.util.bean;
import java.io.Serializable;

import br.ueg.openodonto.dominio.QuestaoAnamnese;
import br.ueg.openodonto.dominio.QuestaoQuestionarioAnamnese;
import br.ueg.openodonto.util.WordFormatter;

public class QuestionarioQuestaoAdapter implements Serializable{

	private static final long serialVersionUID = -2704691912645827351L;
	
	private QuestaoQuestionarioAnamnese 						qqa;
	private QuestaoAnamnese             						qa;
	
	public QuestionarioQuestaoAdapter(QuestaoQuestionarioAnamnese qqa,	QuestaoAnamnese qa) {
		this.qqa = qqa;
		this.qa = qa;
	}
	public QuestaoQuestionarioAnamnese getQqa() {
		return qqa;
	}
	public void setQqa(QuestaoQuestionarioAnamnese qqa) {
		this.qqa = qqa;
	}
	public QuestaoAnamnese getQa() {
		return qa;
	}
	public void setQa(QuestaoAnamnese qa) {
		this.qa = qa;
	}
	
	public String getAbstractPergunta(){
		return WordFormatter.abstractStr(getQa().getPergunta(), 100);
	}	
	
	public void setIndex(String index){
		getQqa().setIndex(Integer.parseInt(index));
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((qa == null) ? 0 : qa.hashCode());
		result = prime * result + ((qqa == null) ? 0 : qqa.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuestionarioQuestaoAdapter other = (QuestionarioQuestaoAdapter) obj;
		if (qa == null) {
			if (other.qa != null)
				return false;
		} else if (!qa.equals(other.qa))
			return false;
		if (qqa == null) {
			if (other.qqa != null)
				return false;
		} else if (!qqa.equals(other.qqa))
			return false;
		return true;
	}	
}
