package adventure.type;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Questa classe descrive i comandi che sono 'comprensibili' dalle varie componenti del programma. 
 */
public class Command {

    private final CommandType type;

    private final String name;

    private Set<String> alias;

    /**
     * Questo metodo, un costruttore della classe, 
     * è utilizzato quando serve istanziare le variabili 'type' e 'name'. 
     * 
     * @param type  Il valore, di classe CommandType, da inserire in 'type'
     * @param name  La String da inserire in 'name'
     */
    public Command(CommandType type, String name) {
        this.type = type;
        this.name = name;
    }

    /**
     * Questo metodo, un costruttore della classe, 
     * è utilizzato quando serve istanziare le variabili 'type', 'name' e 'alias'. 
     * 
     * @param type  Il valore, di classe CommandType, da inserire in 'type'
     * @param name  La String da inserire in 'name'
     * @param alias  Il Set di String da inserire in 'alias'
     */
    public Command(CommandType type, String name, Set<String> alias) {
        this.type = type;
        this.name = name;
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
     * Questo metodo restituisce il valore della variabile 'type'.
     *
     * @return type
     */
    public CommandType getType() {
        return type;
    }

    /**
     * Questo metodo fornisce, tramite Overriding, 
     * un'implementazione del metodo hashCode per questa classe.
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.type);
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
        final Command other = (Command) obj;
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

}
