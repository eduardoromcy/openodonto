package br.ueg.openodonto.visao;

import java.io.Serializable;
import java.util.Properties;

public interface ApplicationView extends Serializable{

    void showOut();

    Properties getParams();

    void showAction();

    void showPopUp(String msg);

    String getPopUpMsg();

    boolean getDisplayMessages();

    boolean getDisplayPopUp();

    void addResourceMessage(String key, String target);

    void addResourceDynamicMenssage(String msg, String target);

    void addLocalMessage(String key, String target, boolean targetParam);

    void addLocalDynamicMenssage(String msg, String target, boolean targetParam);
    
    String getMessageFromResource(String name);

    void refresh();

}
