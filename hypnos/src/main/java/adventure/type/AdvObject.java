package adventure.type;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Questa classe descrive il tipo di oggetti che verranno utilizzati nel gioco. 
 */
public class AdvObject {

    private final int id;

    private String name;

    private String description;

    private Set<String> alias;

    private boolean openable = false;

    private boolean pickupable = true;

    private boolean pushable = false;

    private boolean open = false;

    private boolean push = false;

    private int contained = 0;

    private int lock = 0;

    /**
     * Questo metodo, un costruttore della classe, 
     * è utilizzato quando serve istanziare solo la variabile 'id'. 
     *
     * @param id  Il valore da inserire in 'id'
     */
    public AdvObject(int id) {
        this.id = id;
    }

    /**
     * Questo metodo, un costruttore della classe, 
     * è utilizzato quando serve istanziare le variabili 'id' e 'name'. 
     * 
     * @param id  Il valore da inserire in 'id'
     * @param name  La String da inserire in 'name'
     */
    public AdvObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Questo metodo, un costruttore della classe, 
     * è utilizzato quando serve istanziare le variabili 'id', 'name' e 'description'. 
     * 
     * @param id  Il valore da inserire in 'id'
     * @param name  La String da inserire in 'name'
     * @param description  La String da inserire in 'description'
     */
    public AdvObject(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * Questo metodo, un costruttore della classe, 
     * è utilizzato quando serve istanziare le variabili 'id', 'name', 'description' e 'alias'. 
     * 
     * @param id  Il valore da inserire in 'id'
     * @param name  La String da inserire in 'name'
     * @param description  La String da inserire in 'description'
     * @param alias  Il Set da inserire in 'alias'
     */
    public AdvObject(int id, String name, String description, Set<String> alias) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.alias = alias;
    }

    /**
     * Questo metodo restituisce il valore della variabile 'name'.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Questo metodo permette di modificare il valore della variabile 'name'.
     *
     * @param name  La String da inserire in 'name'
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Questo metodo restituisce il valore della variabile 'description'.
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Questo metodo permette di modificare il valore della variabile
     * 'description'.
     *
     * @param description  La String da inserire in 'description'
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Questo metodo restituisce il valore della variabile 'openable'.
     *
     * @return openable
     */
    public boolean isOpenable() {
        return openable;
    }

    /**
     * Questo metodo permette di modificare il valore della variabile
     * 'openable'.
     *
     * @param openable  Il valore da inserire in openable
     */
    public void setOpenable(boolean openable) {
        this.openable = openable;
    }

    /**
     * Questo metodo restituisce il valore della variabile 'pickupable'.
     *
     * @return pickupable
     */
    public boolean isPickupable() {
        return pickupable;
    }

    /**
     * Questo metodo permette di modificare il valore della variabile
     * 'pickupable'.
     *
     * @param pickupable  Il valore da inserire in pickupable
     */
    public void setPickupable(boolean pickupable) {
        this.pickupable = pickupable;
    }

    /**
     * Questo metodo restituisce il valore della variabile 'pushable'.
     *
     * @return pushable
     */
    public boolean isPushable() {
        return pushable;
    }

    /**
     * Questo metodo permette di modificare il valore della variabile
     * 'pushable'.
     *
     * @param pushable  Il valore da inserire in pushable
     */
    public void setPushable(boolean pushable) {
        this.pushable = pushable;
    }

    /**
     * Questo metodo restituisce il valore della variabile 'open'.
     *
     * @return open
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * Questo metodo permette di modificare il valore della variabile 'open'.
     *
     * @param open  Il valore da inserire in open
     */
    public void setOpen(boolean open) {
        this.open = open;
    }

    /**
     * Questo metodo restituisce il valore della variabile 'push'.
     *
     * @return push
     */
    public boolean isPush() {
        return push;
    }

    /**
     * Questo metodo permette di modificare il valore della variabile 'push'.
     *
     * @param push  Il valore da inserire in push
     */
    public void setPush(boolean push) {
        this.push = push;
    }

    /**
     * Questo metodo restituisce il valore della variabile 'alias'.
     *
     * @return alias
     */
    public Set<String> getAlias() {
        return alias;
    }

    /**
     * Questo metodo permette di modificare il valore della variabile 'alias'.
     *
     * @param alias  Il set da inserire in alias
     */
    public void setAlias(Set<String> alias) {
        this.alias = alias;
    }

    /**
     * Questo metodo permette di modificare il valore della variabile 'alias'.
     *
     * @param alias  La String da inserire in alias
     */
    public void setAlias(String[] alias) {
        this.alias = new HashSet<>(Arrays.asList(alias));
    }

    /**
     * Questo metodo restituisce il valore della variabile 'id'.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Questo metodo restituisce il valore della variabile 'contained'.
     *
     * @return contained
     */
    public int getContained() {
        return contained;
    }

    /**
     * Questo metodo permette di modificare il valore della variabile
     * 'contained'.
     *
     * @param contained  Il valore da inserire in contained
     */
    public void setContained(int contained) {
        this.contained = contained;
    }

    /**
     * Questo metodo restituisce il valore della variabile 'lock'.
     *
     * @return lock
     */
    public int getLock() {
        return lock;
    }

    /**
     * Questo metodo permette di modificare il valore della variabile 'lock'.
     *
     * @param lock  Il valore da inserire in lock
     */
    public void setLock(int lock) {
        this.lock = lock;
    }

    /**
     * Questo metodo fornisce, tramite Overriding, 
     * un'implementazione del metodo hashCode per questa classe.
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    /**
     * Questo metodo fornisce, tramite Overriding, 
     * un'implementazione del metodo equals per questa classe.
     *
     * @param obj  L'oggetto da comparare a questo
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AdvObject other = (AdvObject) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
