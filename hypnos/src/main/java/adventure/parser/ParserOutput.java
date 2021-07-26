package adventure.parser;

import adventure.type.AdvObject;
import adventure.type.Command;

/**
 * Questa classe si occupa della creazione dei comandi 'tradotti' da 'Parser.java', 
 * in un formato comprensibile alle altre componenti del programma.
 */
public class ParserOutput {

    private Command command;

    private AdvObject object;

    private AdvObject invObject1;

    private AdvObject invObject2;

    /**
     * Questo metodo, costruttore della classe, 
     * viene richiamato quando è coinvolto un solo oggetto, presente nell'ambiente. 
     *
     * @param command  Il Command che descrive il comando utilizzato dall'utente
     * @param object  L'oggetto con il quale l'utente ha interagito
     */
    public ParserOutput(Command command, AdvObject object) {
        this.command = command;
        this.object = object;
    }

    /**
     * Questo metodo, costruttore della classe, 
     * viene richiamato quando sono coinvolti un oggetto presente nell'ambiente 
     * ed un oggetto presente nell'inventario. 
     * 
     * @param command  Il Command che descrive il comando utilizzato dall'utente
     * @param object  L'oggetto nell'ambiente con il quale l'utente ha interagito
     * @param invObject  L'oggetto nell'inventario con il quale l'utente ha interagito
     */
    public ParserOutput(Command command, AdvObject object, AdvObject invObject) {
        this.command = command;
        this.object = object;
        this.invObject1 = invObject;
    }

    /**
     * Questo metodo, costruttore della classe, 
     * viene richiamato quando sono coinvolti due oggetti presenti nell'inventario. 
     * 
     * @param invObject1  Il primo oggetto nell'inventario con il quale l'utente ha interagito 
     * @param invObject2  Il secondo oggetto nell'inventario con il quale l'utente ha interagito 
     * @param command  Il Command che descrive il comando utilizzato dall'utente
     */
    public ParserOutput(AdvObject invObject1, AdvObject invObject2, Command command) {
        this.command = command;
        this.invObject1 = invObject1;
        this.invObject2 = invObject2;
    }
    
    /**
     * Questo metodo restituisce il valore della variabile 'command'. 
     *
     * @return command
     */
    public Command getCommand() {
        return command;
    }

    /**
     * Questo metodo permette di modificare il valore di 'command'. 
     *
     * @param command  L'oggetto, di classe Command, da inserire in 'command'
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * Questo metodo restituisce il valore della variabile 'object'. 
     *
     * @return object
     */
    public AdvObject getObject() {
        return object;
    }

    /**
     * Questo metodo permette di modificare il valore di 'object'. 
     *
     * @param object  L'oggetto, di classe AdvObject, da inserire in 'object'
     */
    public void setObject(AdvObject object) {
        this.object = object;
    }

    /**
     * Questo metodo restituisce il valore della variabile 'invObject1'. 
     *
     * @return invObject1
     */
    public AdvObject getInvObject1() {
        return invObject1;
    }

    /**
     * Questo metodo permette di modificare il valore di 'invObject1'. 
     *
     * @param invObject  L'oggetto, di classe AdvObject, da inserire in 'invObject1'
     */
    public void setInvObject1(AdvObject invObject) {
        this.invObject1 = invObject;
    }

    /**
     * Questo metodo restituisce il valore della variabile 'invObject2'. 
     *
     * @return invObject2
     */
    public AdvObject getInvObject2() {
        return invObject2;
    }

    /**
     * Questo metodo permette di modificare il valore di 'invObject2'. 
     *
     * @param invObject  L'oggetto, di classe AdvObject, da inserire in 'invObject2'
     */
    public void setInvObject2(AdvObject invObject) {
        this.invObject2 = invObject;
    }

}
