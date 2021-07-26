package adventure.type;

import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe descrive le caratteristiche delle stanze presenti nel gioco. 
 */
public class Room {

    private final int id;

    private int floor;

    private String name;

    private String description;

    private String look;
    
    private boolean locked = false;

    private Room south = null;

    private Room north = null;

    private Room east = null;

    private Room west = null;
    
    private String pathMinimap = "/img/Minimap_err.png";
    
    private String pathView = "/img/View_err.png";

    private final List<AdvObject> objects = new ArrayList<>();

    /**
     * Questo metodo, un costruttore della classe, 
     * è utilizzato quando serve istanziare solo la variabile 'id'. 
     *
     * @param id  La String da inserire in 'id'
     */
    public Room(int id) {
        this.id = id;
    }

    /**
     * Questo metodo, un costruttore della classe, 
     * è utilizzato quando serve istanziare le variabili 'id', 'floor', 'name' e 'description'. 
     * 
     * @param id  Il valore da inserire in 'id'
     * @param floor  Il valore da inserire nella variabile 'floor'
     * @param name  La String da inserire in 'name'
     * @param description  La String da inserire in 'description'
     */
    public Room(int id, int floor, String name, String description) {
        this.id = id;
        this.floor = floor;
        this.name = name;
        this.description = description;
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
     * Questo metodo restituisce il valore della variabile 'floor'. 
     *
     * @return floor
     */
    public int getFloor() {
        return floor;
    }

    /**
     * Questo metodo permette di modificare il valore della variabile 'floor'.
     *
     * @param floor  Il valore da inserire in 'floor'
     */
    public void setFloor(int floor) {
        this.floor = floor;
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
     * Questo metodo restituisce il valore della variabile 'look'.
     *
     * @return look
     */
    public String getLook() {
        return look;
    }

    /**
     * Questo metodo permette di modificare il valore della variabile 'look'.
     *
     * @param look  Il valore da inserire in look
     */
    public void setLook(String look) {
        this.look = look;
    }

    /**
     * Questo metodo restituisce il valore della variabile 'locked'.
     *
     * @return locked
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * Questo metodo permette di modificare il valore della variabile 'locked'.
     *
     * @param locked  Il valore da inserire in locked
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    /**
     * Questo metodo restituisce il valore della variabile 'south'
     *
     * @return south
     */
    public Room getSouth() {
        return south;
    }

    /**
     * Questo metodo permette di modificare il valore della variabile 'south'
     *
     * @param south  La String da inserire nella variabile 'south'
     */
    public void setSouth(Room south) {
        this.south = south;
    }

    /**
     * Questo metodo restituisce il valore della variabile 'north'
     *
     * @return north
     */
    public Room getNorth() {
        return north;
    }

    /**
     * Questo metodo permette di modificare il valore della variabile 'north'
     *
     * @param north  La String da inserire nella variabile 'north'
     */
    public void setNorth(Room north) {
        this.north = north;
    }

    /**
     * Questo metodo restituisce il valore della variabile 'east'
     *
     * @return east
     */
    public Room getEast() {
        return east;
    }

    /**
     * Questo metodo permette di modificare il valore della variabile 'east'
     *
     * @param east  La String da inserire nella variabile 'east'
     */
    public void setEast(Room east) {
        this.east = east;
    }

    /**
     * Questo metodo restituisce il valore della variabile 'west'
     *
     * @return west
     */
    public Room getWest() {
        return west;
    }

    /**
     * Questo metodo permette di modificare il valore della variabile 'west'
     *
     * @param west  La String da inserire nella variabile 'west'
     */
    public void setWest(Room west) {
        this.west = west;
    }

    /**
     * Questo metodo restituisce il valore della variabile 'pathMinimap'
     *
     * @return pathMinimap
     */
    public String getPathMinimap() {
        return pathMinimap;
    }

    /**
     * Questo metodo permette di modificare il valore della variabile 'pathMinimap'
     *
     * @param pathMinimap  La String da inserire nella variabile 'pathMinimap'
     */
    public void setPathMinimap(String pathMinimap) {
        this.pathMinimap = pathMinimap;
    }

    /**
     * Questo metodo restituisce il valore della variabile 'pathView'
     *
     * @return pathView
     */
    public String getPathView() {
        return pathView;
    }

    /**
     * Questo metodo permette di modificare il valore della variabile 'pathView'
     *
     * @param pathView  La String da inserire nella variabile 'pathView'
     */
    public void setPathView(String pathView) {
        this.pathView = pathView;
    }

    /**
     * Questo metodo restituisce il valore della variabile 'objects'
     *
     * @return objects
     */
    public List<AdvObject> getObjects() {
        return objects;
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
        hash = 83 * hash + this.id;
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
        final Room other = (Room) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
