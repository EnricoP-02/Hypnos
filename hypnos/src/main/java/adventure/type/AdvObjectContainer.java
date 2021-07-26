package adventure.type;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Questo metodo, che eredita da AdvObject, descrive un particolare tipo di oggetto per il gioco, 
 * ovvero oggetti che possono contenere altri oggetti. 
 */
public class AdvObjectContainer extends AdvObject {
    
    private List<AdvObject> list = new ArrayList<>();

    /**
     * Questo metodo, un costruttore della classe, 
     * è utilizzato quando serve istanziare solo la variabile 'id'. 
     *
     * @param id  La String da inserire in 'id'
     */
    public AdvObjectContainer(int id) {
        super(id);
    }

    /**
     * Questo metodo, un costruttore della classe, 
     * è utilizzato quando serve istanziare le variabili 'id' e 'name'. 
     * 
     * @param id  La String da inserire in 'id'
     * @param name  La String da inserire in 'name'
     */
    public AdvObjectContainer(int id, String name) {
        super(id, name);
    }

    /**
     * Questo metodo, un costruttore della classe, 
     * è utilizzato quando serve istanziare le variabili 'id', 'name' e 'description'. 
     * 
     * @param id  La String da inserire in 'id'
     * @param name  La String da inserire in 'name'
     * @param description  La String da inserire in 'description'
     */
    public AdvObjectContainer(int id, String name, String description) {
        super(id, name, description);
    }

    /**
     * Questo metodo, un costruttore della classe, 
     * è utilizzato quando serve istanziare le variabili 'id', 'name', 'description' e 'alias'. 
     * 
     * @param id  La String da inserire in 'id'
     * @param name  La String da inserire in 'name'
     * @param description  La String da inserire in 'description'
     * @param alias  Il Set da inserire in 'alias'
     */
    public AdvObjectContainer(int id, String name, String description, Set<String> alias) {
        super(id, name, description, alias);
    }

    /**
     * Questo metodo restituisce la List 'list'.
     *
     * @return list
     */
    public List<AdvObject> getList() {
        return list;
    }

    /**
     * Questo metodo permette di modificare il valore della List 'list'.
     *
     * @param list  La List da inserire in 'list'
     */
    public void setList(List<AdvObject> list) {
        this.list = list;
    }

    /**
     * Questo metodo permette di aggiungere un elemento di classe AdvObject alla List 'list'. 
     *
     * @param o  L'oggetto di classe AdvObject da aggiungere alla List 'list'
     */
    public void add(AdvObject o) {
        list.add(o);
    }

    /**
     * Questo metodo permette di rimuovere un elemento di classe AdvObject alla List 'list'. 
     *
     * @param o  L'oggetto di classe AdvObject da rimuovere alla List 'list'
     */
    public void remove(AdvObject o) {
        list.remove(o);
    }

}
