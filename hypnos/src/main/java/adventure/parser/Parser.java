package adventure.parser;

import adventure.Utils;
import adventure.type.AdvObject;
import adventure.type.AdvObjectContainer;
import adventure.type.Command;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Questa classe si occupa della traduzione dei comandi inseriti dall'utente 
 * in sequenze comprensibili dal resto del programma. 
 */
public class Parser {

    private final Set<String> stopwords;

    /**
     * Questo metodo, il costruttore di questa classe, 
     * si occupa dell'iniziazione delle variabili di classe. 
     *
     * @param stopwords  Il Set di caratteri che vanno esclusi dalle String ottenute in input
     */
    public Parser(Set<String> stopwords) {
        this.stopwords = stopwords;
    }

    private int checkForCommand(String token, List<Command> commands) {
        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).getName().equalsIgnoreCase(token) || commands.get(i).getAlias().contains(token)) {
                return i;
            }
        }
        return -1;
    }

    private int checkForObject(String token, List<AdvObject> objects) throws NullPointerException {
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getName().equalsIgnoreCase(token) || objects.get(i).getAlias().contains(token)) {
                return objects.get(i).getId();
            } else if (objects.get(i) instanceof AdvObjectContainer && objects.get(i).isOpen() == true) {
                AdvObjectContainer container = new AdvObjectContainer(objects.get(i).getId());
                container = (AdvObjectContainer) objects.get(i);
                Iterator<AdvObject> objIt = container.getList().iterator();
                while (objIt.hasNext()) {
                    AdvObject next = objIt.next();
                    if (next.getName().equalsIgnoreCase(token) || next.getAlias().contains(token)) {
                        return next.getId();
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Questo metodo si occupa della 'traduzione' dei comandi inseriti dall'utente 
     * in String comprensibili ed utilizzabili dalle altre componenti del programma. 
     *
     * @param command  La String di comando inserita dall'utente
     * @param commands  La List dei comandi presenti nel gioco
     * @param objects  La List degli oggetti presenti nel gioco
     * @param inventory  La List che rappresenta l'inventario corrente dell'utente
     * @return ParserOutput()
     */
    public ParserOutput parse(String command, List<Command> commands, List<AdvObject> objects, List<AdvObject> inventory) {
        AdvObject hitObj = null;
        AdvObject hitObjInv1 = null;
        AdvObject hitObjInv2 = null;

        List<String> tokens = Utils.parseString(command, stopwords);
        if (!tokens.isEmpty()) {
            int ic = checkForCommand(tokens.get(0), commands);
            if (ic > -1) {
                if (tokens.size() > 1) {
                    int io = -1;
                    int ioinv1 = -1;
                    int ioinv2 = -1;
                    int temp1;
                    int temp2;
                    int temp3;
                    int temp4;
                    int temp5;
                    int temp6;
                    int temp7;
                    int temp8;

                    if (tokens.size() == 9) { // 4|4 4|4
                        temp1 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3) + " " + tokens.get(4), objects);
                        temp2 = checkForObject(tokens.get(5) + " " + tokens.get(6) + " " + tokens.get(7) + " " + tokens.get(8), objects);

                        if (temp2 >= 0) {
                            io = temp2;
                            ioinv1 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3) + " " + tokens.get(4), inventory);
                        } else if (temp1 >= 0) {
                            io = temp1;
                            ioinv1 = checkForObject(tokens.get(5) + " " + tokens.get(6) + " " + tokens.get(7) + " " + tokens.get(8), inventory);
                        } else {
                            // Two inventory objects
                            ioinv1 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3) + " " + tokens.get(4), inventory);
                            ioinv2 = checkForObject(tokens.get(5) + " " + tokens.get(6) + " " + tokens.get(7) + " " + tokens.get(8), inventory);
                        }
                    } else if (tokens.size() == 8) { // 4|3 3|4
                        temp1 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3), objects);
                        temp2 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3) + " " + tokens.get(4), objects);
                        temp3 = checkForObject(tokens.get(5) + " " + tokens.get(6) + " " + tokens.get(7), objects);
                        temp4 = checkForObject(tokens.get(4) + " " + tokens.get(5) + " " + tokens.get(6) + " " + tokens.get(7), objects);

                        if (temp4 >= 0) {
                            io = temp4;
                            ioinv1 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3), inventory);
                        } else if (temp3 >= 0) {
                            io = temp3;
                            ioinv1 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3) + " " + tokens.get(4), inventory);
                        } else if (temp2 >= 0) {
                            io = temp2;
                            ioinv1 = checkForObject(tokens.get(5) + " " + tokens.get(6) + " " + tokens.get(7), inventory);
                        } else if (temp1 >= 0) {
                            io = temp1;
                            ioinv1 = checkForObject(tokens.get(4) + " " + tokens.get(5) + " " + tokens.get(6) + " " + tokens.get(7), inventory);
                        } else {
                            // Two inventory objects
                            ioinv1 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3) + " " + tokens.get(4), inventory);
                            if (ioinv1 >= 0) {
                                ioinv2 = checkForObject(tokens.get(5) + " " + tokens.get(6) + " " + tokens.get(7), inventory);
                            } else {
                                ioinv1 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3), inventory);
                                ioinv2 = checkForObject(tokens.get(4) + " " + tokens.get(5) + " " + tokens.get(6) + " " + tokens.get(7), inventory);
                            }
                        }
                    } else if (tokens.size() == 7) { // 4|2 3|3 3|3 2|4
                        temp1 = checkForObject(tokens.get(1) + " " + tokens.get(2), objects);                                             // 1 2
                        temp2 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3), objects);                       // 1 2 3
                        temp3 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3) + " " + tokens.get(4), objects); // 1 2 3 4
                        temp4 = checkForObject(tokens.get(3) + " " + tokens.get(4) + " " + tokens.get(5) + " " + tokens.get(6), objects); // 3 4 5 6
                        temp5 = checkForObject(tokens.get(4) + " " + tokens.get(5) + " " + tokens.get(6), objects);                       // 4 5 6
                        temp6 = checkForObject(tokens.get(5) + " " + tokens.get(6), objects);                                             // 5 6

                        if (temp6 >= 0) {
                            io = temp6;
                            ioinv1 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3) + " " + tokens.get(4), inventory);
                        } else if (temp5 >= 0) {
                            io = temp5;
                            ioinv1 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3), inventory);
                        } else if (temp4 >= 0) {
                            io = temp4;
                            ioinv1 = checkForObject(tokens.get(1) + " " + tokens.get(2), inventory);
                        } else if (temp3 >= 0) {
                            io = temp3;
                            ioinv1 = checkForObject(tokens.get(5) + " " + tokens.get(6), inventory);
                        } else if (temp2 >= 0) {
                            io = temp2;
                            ioinv1 = checkForObject(tokens.get(4) + " " + tokens.get(5) + " " + tokens.get(6), inventory);
                        } else if (temp1 >= 0) {
                            io = temp1;
                            ioinv1 = checkForObject(tokens.get(3) + " " + tokens.get(4) + " " + tokens.get(5) + " " + tokens.get(6), inventory);
                        } else {
                            // Two inventory objects
                            temp1 = checkForObject(tokens.get(1) + " " + tokens.get(2), inventory);
                            temp2 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3), inventory);
                            temp3 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3) + " " + tokens.get(4), inventory);

                            if (temp3 >= 0) {
                                ioinv1 = temp3;
                                ioinv2 = checkForObject(tokens.get(5) + " " + tokens.get(6), inventory);
                            } else if (temp2 >= 0) {
                                ioinv1 = temp2;
                                ioinv2 = checkForObject(tokens.get(4) + " " + tokens.get(5) + " " + tokens.get(6), inventory);
                            } else if (temp1 >= 0) {
                                ioinv1 = temp1;
                                ioinv2 = checkForObject(tokens.get(3) + " " + tokens.get(4) + " " + tokens.get(5) + " " + tokens.get(6), inventory);
                            }
                        }
                    } else if (tokens.size() == 6) {  // 4|1 3|2 2|3 1|4
                        temp1 = checkForObject(tokens.get(1), objects);                                                                   // 1
                        temp2 = checkForObject(tokens.get(1) + " " + tokens.get(2), objects);                                             // 1 2
                        temp3 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3), objects);                       // 1 2 3
                        temp4 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3) + " " + tokens.get(4), objects); // 1 2 3 4
                        temp5 = checkForObject(tokens.get(2) + " " + tokens.get(3) + " " + tokens.get(4) + " " + tokens.get(5), objects); // 2 3 4 5
                        temp6 = checkForObject(tokens.get(3) + " " + tokens.get(4) + " " + tokens.get(5), objects);                       // 3 4 5
                        temp7 = checkForObject(tokens.get(4) + " " + tokens.get(5), objects);                                             // 4 5
                        temp8 = checkForObject(tokens.get(5), objects);                                                                   // 5

                        if (temp8 >= 0) {
                            io = temp8;
                            ioinv1 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3) + " " + tokens.get(4), inventory);
                        } else if (temp7 >= 0) {
                            io = temp7;
                            ioinv1 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3), inventory);
                        } else if (temp6 >= 0) {
                            io = temp6;
                            ioinv1 = checkForObject(tokens.get(1) + " " + tokens.get(2), inventory);
                        } else if (temp5 >= 0) {
                            io = temp5;
                            ioinv1 = checkForObject(tokens.get(1), inventory);
                        } else if (temp4 >= 0) {
                            io = temp4;
                            ioinv1 = checkForObject(tokens.get(5), inventory);
                        } else if (temp3 >= 0) {
                            io = temp3;
                            ioinv1 = checkForObject(tokens.get(4) + " " + tokens.get(5), inventory);
                        } else if (temp2 >= 0) {
                            io = temp2;
                            ioinv1 = checkForObject(tokens.get(3) + " " + tokens.get(4) + " " + tokens.get(5), inventory);
                        } else if (temp1 >= 0) {
                            io = temp1;
                            ioinv1 = checkForObject(tokens.get(2) + " " + tokens.get(3) + " " + tokens.get(4) + " " + tokens.get(5), inventory);
                        } else {
                            // Two inventory objects
                            temp1 = checkForObject(tokens.get(1), inventory);
                            temp2 = checkForObject(tokens.get(1) + " " + tokens.get(2), inventory);
                            temp3 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3), inventory);
                            temp4 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3) + " " + tokens.get(4), inventory);

                            if (temp4 >= 0) {
                                ioinv1 = temp4;
                                ioinv2 = checkForObject(tokens.get(5), inventory);
                            } else if (temp3 >= 0) {
                                ioinv1 = temp3;
                                ioinv2 = checkForObject(tokens.get(4) + " " + tokens.get(5), inventory);
                            } else if (temp2 >= 0) {
                                ioinv1 = temp2;
                                ioinv2 = checkForObject(tokens.get(3) + " " + tokens.get(4) + " " + tokens.get(5), inventory);
                            } else if (temp1 >= 0) {
                                ioinv1 = temp1;
                                ioinv2 = checkForObject(tokens.get(2) + " " + tokens.get(3) + " " + tokens.get(4) + " " + tokens.get(5), inventory);
                            }
                        }
                    } else if (tokens.size() == 5) { // 4|0 3|1 2|2 2|2 1|3 0|4
                        temp1 = checkForObject(tokens.get(1), objects);                                                                   // 1
                        temp2 = checkForObject(tokens.get(1) + " " + tokens.get(2), objects);                                             // 1 2
                        temp3 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3), objects);                       // 1 2 3
                        temp4 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3) + " " + tokens.get(4), objects); // 1 2 3 4
                        temp5 = checkForObject(tokens.get(2) + " " + tokens.get(3) + " " + tokens.get(4), objects);                       // 2 3 4
                        temp6 = checkForObject(tokens.get(3) + " " + tokens.get(4), objects);                                             // 3 4
                        temp7 = checkForObject(tokens.get(4), objects);                                                                   // 4

                        if (temp7 >= 0) {
                            io = temp7;
                            ioinv1 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3), inventory);
                        } else if (temp6 >= 0) {
                            io = temp6;
                            ioinv1 = checkForObject(tokens.get(1) + " " + tokens.get(2), inventory);
                        } else if (temp5 >= 0) {
                            io = temp5;
                            ioinv1 = checkForObject(tokens.get(1), inventory);
                        } else if (temp4 >= 0) {
                            io = temp4;
                        } else if (temp3 >= 0) {
                            io = temp3;
                            ioinv1 = checkForObject(tokens.get(4), inventory);
                        } else if (temp2 >= 0) {
                            io = temp2;
                            ioinv1 = checkForObject(tokens.get(3) + " " + tokens.get(4), inventory);
                        } else if (temp1 >= 0) {
                            io = temp1;
                            ioinv1 = checkForObject(tokens.get(2) + " " + tokens.get(3) + " " + tokens.get(4), inventory);
                        } else {
                            ioinv1 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3) + " " + tokens.get(4), inventory);

                            if (ioinv1 < 0) {
                                temp1 = checkForObject(tokens.get(1), inventory);
                                temp2 = checkForObject(tokens.get(1) + " " + tokens.get(2), inventory);
                                temp3 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3), inventory);

                                if (temp3 >= 0) {
                                    ioinv1 = temp3;
                                    ioinv2 = checkForObject(tokens.get(4), inventory);
                                } else if (temp2 >= 0) {
                                    ioinv1 = temp2;
                                    ioinv2 = checkForObject(tokens.get(3) + " " + tokens.get(4), inventory);
                                } else if (temp1 >= 0) {
                                    ioinv1 = temp1;
                                    ioinv2 = checkForObject(tokens.get(2) + " " + tokens.get(3) + " " + tokens.get(4), inventory);
                                }
                            }
                        }
                    } else if (tokens.size() == 4) { // 3|0 2|1 1|2 0|3
                        temp1 = checkForObject(tokens.get(1), objects);                                                                   // 1
                        temp2 = checkForObject(tokens.get(1) + " " + tokens.get(2), objects);                                             // 1 2
                        temp3 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3), objects);                       // 1 2 3
                        temp4 = checkForObject(tokens.get(2) + " " + tokens.get(3), objects);                                             // 2 3
                        temp5 = checkForObject(tokens.get(3), objects);                                                                   // 3

                        if (temp5 >= 0) {
                            io = temp5;
                            ioinv1 = checkForObject(tokens.get(1) + " " + tokens.get(2), inventory);
                        } else if (temp4 >= 0) {
                            io = temp4;
                            ioinv1 = checkForObject(tokens.get(1), inventory);
                        } else if (temp3 >= 0) {
                            io = temp3;
                        } else if (temp2 >= 0) {
                            io = temp2;
                            ioinv1 = checkForObject(tokens.get(3), inventory);
                        } else if (temp1 >= 0) {
                            io = temp1;
                            ioinv1 = checkForObject(tokens.get(2) + " " + tokens.get(3), inventory);
                        } else {
                            ioinv1 = checkForObject(tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3), inventory);

                            if (ioinv1 < 0) {
                                temp1 = checkForObject(tokens.get(1), inventory);
                                temp2 = checkForObject(tokens.get(1) + " " + tokens.get(2), inventory);

                                if (temp2 >= 0) {
                                    ioinv1 = temp2;
                                    ioinv2 = checkForObject(tokens.get(3), inventory);
                                } else if (temp1 >= 0) {
                                    ioinv1 = temp1;
                                    ioinv2 = checkForObject(tokens.get(2) + " " + tokens.get(3), inventory);
                                }
                            }
                        }
                    } else if (tokens.size() == 3) { // 2|0 1|1 1|1 0|2
                        temp1 = checkForObject(tokens.get(1), objects);                                                                   // 1
                        temp2 = checkForObject(tokens.get(1) + " " + tokens.get(2), objects);                                             // 1 2
                        temp3 = checkForObject(tokens.get(2), objects);                                                                   // 2

                        if (temp3 >= 0) {
                            io = temp3;
                            ioinv1 = checkForObject(tokens.get(1), inventory);
                        } else if (temp2 >= 0) {
                            io = temp2;
                        } else if (temp1 >= 0) {
                            io = temp1;
                            ioinv1 = checkForObject(tokens.get(2), inventory);
                        } else {
                            ioinv1 = checkForObject(tokens.get(1) + " " + tokens.get(2), inventory);

                            if (ioinv1 < 0) {
                                ioinv1 = checkForObject(tokens.get(1), inventory);
                                ioinv2 = checkForObject(tokens.get(2), inventory);
                            }
                        }
                    } else if (tokens.size() == 2) {
                        io = checkForObject(tokens.get(1), objects); // 1

                        if (io < 0) {
                            ioinv1 = checkForObject(tokens.get(1), inventory);
                        }
                    }
                    if (io > -1 && ioinv1 > -1) {
                        Iterator<AdvObject> objectIt = objects.iterator();
                        while (objectIt.hasNext()) {
                            AdvObject nextObj = objectIt.next();

                            if (nextObj.getId() == io) {
                                hitObj = nextObj;
                            } else if (nextObj instanceof AdvObjectContainer) {
                                AdvObjectContainer nextObjectContainer = (AdvObjectContainer) nextObj;

                                if (!nextObjectContainer.getList().isEmpty()) {
                                    Iterator<AdvObject> containerIt = nextObjectContainer.getList().iterator();
                                    while (containerIt.hasNext()) {
                                        AdvObject nextObjContained = containerIt.next();

                                        if (nextObjContained.getContained() == nextObj.getId() && io == nextObjContained.getId()) {
                                            hitObj = nextObjContained;
                                        }
                                    }
                                }
                            }

                        }

                        Iterator<AdvObject> inventoryIt = inventory.iterator();
                        while (inventoryIt.hasNext()) {
                            AdvObject nextObj = inventoryIt.next();

                            if (nextObj.getId() == ioinv1) {
                                hitObjInv1 = nextObj;
                            } else if (nextObj instanceof AdvObjectContainer) {
                                AdvObjectContainer nextObjectContainer = (AdvObjectContainer) nextObj;

                                if (!nextObjectContainer.getList().isEmpty()) {
                                    Iterator<AdvObject> containerIt = nextObjectContainer.getList().iterator();
                                    while (containerIt.hasNext()) {
                                        AdvObject nextObjContained = containerIt.next();

                                        if (nextObjContained.getContained() == nextObj.getId() && ioinv1 == nextObjContained.getId()) {
                                            hitObjInv1 = nextObjContained;
                                        }
                                    }
                                }
                            }
                        }

                        return new ParserOutput(commands.get(ic), hitObj, hitObjInv1);
                    } else if (ioinv1 > -1 && ioinv2 > -1) {
                        Iterator<AdvObject> inventoryIt = inventory.iterator();
                        while (inventoryIt.hasNext()) {
                            AdvObject nextObj = inventoryIt.next();

                            if (nextObj.getId() == ioinv1) {
                                hitObjInv1 = nextObj;
                            } else if (nextObj instanceof AdvObjectContainer) {
                                AdvObjectContainer nextObjectContainer = (AdvObjectContainer) nextObj;

                                if (!nextObjectContainer.getList().isEmpty()) {
                                    Iterator<AdvObject> containerIt = nextObjectContainer.getList().iterator();
                                    while (containerIt.hasNext()) {
                                        AdvObject nextObjContained = containerIt.next();

                                        if (nextObjContained.getContained() == nextObj.getId() && ioinv1 == nextObjContained.getId()) {
                                            hitObjInv1 = nextObjContained;
                                        }
                                    }
                                }
                            }
                        }

                        Iterator<AdvObject> inventoryIt2 = inventory.iterator();
                        while (inventoryIt2.hasNext()) {
                            AdvObject nextObj = inventoryIt2.next();

                            if (nextObj.getId() == ioinv2) {
                                hitObjInv2 = nextObj;
                            } else if (nextObj instanceof AdvObjectContainer) {
                                AdvObjectContainer nextObjectContainer = (AdvObjectContainer) nextObj;

                                if (!nextObjectContainer.getList().isEmpty()) {
                                    Iterator<AdvObject> containerIt = nextObjectContainer.getList().iterator();
                                    while (containerIt.hasNext()) {
                                        AdvObject nextObjContained = containerIt.next();

                                        if (nextObjContained.getContained() == nextObj.getId() && ioinv2 == nextObjContained.getId()) {
                                            hitObjInv2 = nextObjContained;
                                        }
                                    }
                                }
                            }
                        }

                        return new ParserOutput(hitObjInv1, hitObjInv2, commands.get(ic));
                    } else if (io > -1) {
                        Iterator<AdvObject> objectIt = objects.iterator();
                        while (objectIt.hasNext()) {
                            AdvObject nextObj = objectIt.next();

                            if (nextObj.getId() == io) {
                                hitObj = nextObj;
                            } else if (nextObj instanceof AdvObjectContainer) {
                                AdvObjectContainer nextObjectContainer = (AdvObjectContainer) nextObj;

                                if (!nextObjectContainer.getList().isEmpty()) {
                                    Iterator<AdvObject> containerIt = nextObjectContainer.getList().iterator();
                                    while (containerIt.hasNext()) {
                                        AdvObject nextObjContained = containerIt.next();

                                        if (nextObjContained.getContained() == nextObj.getId() && io == nextObjContained.getId()) {
                                            hitObj = nextObjContained;
                                        }
                                    }
                                }
                            }
                        }

                        return new ParserOutput(commands.get(ic), hitObj, null);
                    } else if (ioinv1 > -1) {
                        Iterator<AdvObject> inventoryIt = inventory.iterator();
                        while (inventoryIt.hasNext()) {
                            AdvObject nextObj = inventoryIt.next();

                            if (nextObj.getId() == ioinv1) {
                                hitObj = nextObj;
                            } else if (nextObj instanceof AdvObjectContainer) {
                                AdvObjectContainer nextObjectContainer = (AdvObjectContainer) nextObj;

                                if (!nextObjectContainer.getList().isEmpty()) {
                                    Iterator<AdvObject> containerIt = nextObjectContainer.getList().iterator();
                                    while (containerIt.hasNext()) {
                                        AdvObject nextObjContained = containerIt.next();

                                        if (nextObjContained.getContained() == nextObj.getId() && ioinv1 == nextObjContained.getId()) {
                                            hitObj = nextObjContained;
                                        }
                                    }
                                }
                            }
                        }

                        return new ParserOutput(commands.get(ic), null, hitObj);
                    } else {
                        return new ParserOutput(commands.get(ic), null, null);
                    }
                } else {
                    return new ParserOutput(commands.get(ic), null);
                }
            } else {
                return new ParserOutput(null, null);
            }
        } else {
            return null;
        }
    }
}
