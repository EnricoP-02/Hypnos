package adventure.type;

/**
 * Questa classe definisce il tipo enumerativo che contiene i comandi che il parser deve 'tradurre'. 
 */ 
public enum CommandType {

    /**
     * Questo comando viene utilizzato dall'utente per terminare il programma. 
     */
    END,

    /**
     * Questo comando viene utilizzato dall'utente per andare verso nord. 
     */
    NORTH,

    /**
     * Questo comando viene utilizzato dall'utente per  andare verso sud. 
     */
    SOUTH,

    /**
     * Questo comando viene utilizzato dall'utente per  andare verso est. 
     */
    EAST,

    /**
     * Questo comando viene utilizzato dall'utente per  andare verso ovest. 
     */
    WEST,

    /**
     * Questo comando viene utilizzato dall'utente per aprire oggetti. 
     */
    OPEN,

    /**
     * Questo comando viene utilizzato dall'utente per chiudere oggetti. 
     */
    CLOSE,

    /**
     * Questo comando viene utilizzato dall'utente per spingere oggetti. 
     */
    PUSH,

    /**
     * Questo comando viene utilizzato dall'utente per raccogliere oggetti. 
     */
    PICK_UP,

    /**
     * Questo comando viene utilizzato dall'utente per usare oggetti. 
     */
    USE,

    /**
     * Questo comando viene utilizzato dall'utente per guardare oggetti 
     * e guardarsi intorno. 
     */
    LOOK_AT
}
