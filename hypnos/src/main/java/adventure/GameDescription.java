package adventure;

import adventure.gui.Frame;
import adventure.parser.ParserOutput;
import adventure.type.AdvObject;
import adventure.type.Command;
import adventure.type.Room;
import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe generalizza le caratteristiche di un gioco. 
 * <p>
 * I giochi realizzati implementando questa classe astratta saranno compatibili 
 * con la classe 'Frame.java'. 
 */
public abstract class GameDescription {

    private final List<Room> rooms = new ArrayList<>();

    private final List<Command> commands = new ArrayList<>();

    private final List<AdvObject> inventory = new ArrayList<>();

    private Room currentRoom;

    /**
     * Questo metodo restituisce la List 'rooms'.
     *
     * @return rooms
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * Questo metodo restituisce la List 'commands'. 
     *
     * @return commands
     */
    public List<Command> getCommands() {
        return commands;
    }

    /**
     * Questo metodo restituisce il valore della variabile 'currentRoom'. 
     *
     * @return currentRoom
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Questo metodo permette di modificare il valore di 'currentRoom'. 
     *
     * @param currentRoom  L'oggetto, di classe Room, da inserire in 'currentRoom'
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * Questo metodo restituisce la List 'inventory'. 
     *
     * @return inventory
     */
    public List<AdvObject> getInventory() {
        return inventory;
    }

    /**
     * Questo metodo astratto, nel momento in cui riceve implementazione, 
     * si occupa del popolamento delle List 'rooms', 'objects', 'commands' e 'inventory'. 
     */
    public abstract void init();

    /**
     * Questo metodo astratto, nel momento in cui riceve implementazione, 
     * si occupa della gestione della mossa effettuata dal giocatore. 
     *
     * @param p  L'istanza di ParserOutput.java che utilizziamo per la comprensione del comando inserito
     * @param frame  L'istanza di Frame.java alla quale andiamo ad apportare le necessarie modifiche
     */
    public abstract void nextMove(ParserOutput p, Frame frame);

}
