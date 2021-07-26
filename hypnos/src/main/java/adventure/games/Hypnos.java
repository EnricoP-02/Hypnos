package adventure.games;

import adventure.GameDescription;
import adventure.gui.Frame;
import adventure.parser.ParserOutput;
import adventure.type.AdvObject;
import adventure.type.AdvObjectContainer;
import adventure.type.Command;
import adventure.type.CommandType;
import adventure.type.Room;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Questa classe, che eredita dalla classe 'GameDescription.java', offre
 * un'imlementazione dei metodi e una dichiarazione degli attributi di questa al
 * fine di creare il gioco denominato 'Hypnos'.
 */
public class Hypnos extends GameDescription {

    /**
     * Questo metodo, che offre un'imlpementazione tramite Overriding, si occupa
     * del popolamento delle List 'rooms', 'objects', 'commands' e 'inventory';
     * oltre che all'assegnazione della variabile 'currentRoom'.
     */
    @Override
    public void init() {
        // Variables
        String lineRoom;
        String lineObj;
        String[] parameters;
        String pathRoom = "/init/roomDesc";
        String pathObj = "/init/objectDesc";
        BufferedReader brRoom = null;
        BufferedReader brObj = null;

        try {
            brRoom = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(pathRoom), "UTF8"));
        } catch (UnsupportedEncodingException e) {
            System.out.println("ERR: FILE DI CARICAMENTO STANZE NON TROVATO");
            System.exit(0);
        }
        try {
            brObj = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(pathObj), "UTF8"));
        } catch (UnsupportedEncodingException e) {
            System.out.println("ERR: FILE DI CARICAMENTO OGGETTI NON TROVATI");
            System.exit(0);
        }

        // Commands
        Command nord = new Command(CommandType.NORTH, "nord");
        nord.setAlias(new String[]{"Nord", "NORD"});
        getCommands().add(nord);
        Command sud = new Command(CommandType.SOUTH, "sud");
        sud.setAlias(new String[]{"Sud", "SUD"});
        getCommands().add(sud);
        Command est = new Command(CommandType.EAST, "est");
        est.setAlias(new String[]{"Est", "EST"});
        getCommands().add(est);
        Command ovest = new Command(CommandType.WEST, "ovest");
        ovest.setAlias(new String[]{"Ovest", "OVEST"});
        getCommands().add(ovest);
        Command end = new Command(CommandType.END, "end");
        end.setAlias(new String[]{"ammazza", "uccidi", "colpisci", "strozza", "strangola", "attacca", "cozza"});
        getCommands().add(end);
        Command look = new Command(CommandType.LOOK_AT, "osserva");
        look.setAlias(new String[]{"guarda", "vedi", "trova", "cerca", "descrivi", "leggi", "ascolta"});
        getCommands().add(look);
        Command pickup = new Command(CommandType.PICK_UP, "raccogli");
        pickup.setAlias(new String[]{"prendi"});
        getCommands().add(pickup);
        Command open = new Command(CommandType.OPEN, "apri");
        open.setAlias(new String[]{});
        getCommands().add(open);
        Command close = new Command(CommandType.CLOSE, "chiudi");
        close.setAlias(new String[]{});
        getCommands().add(close);
        Command push = new Command(CommandType.PUSH, "premi");
        push.setAlias(new String[]{"spingi", "attiva"});
        getCommands().add(push);
        Command use = new Command(CommandType.USE, "usa");
        use.setAlias(new String[]{"utilizza", "impiega", "rompi", "metti", "inserisci", "accendi", "scrivi", "riempi", "versa"});
        getCommands().add(use);

        try {
            //---Rooms---
            // First floor
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room bedroom = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            bedroom.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room hallway = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            hallway.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room livingRoom = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            livingRoom.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room hall = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            hall.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room study = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            study.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room bathroom = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            bathroom.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room stairs = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            stairs.setLook(parameters[4]);

            // Second floor
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room bedroom2 = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            bedroom2.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room hall2 = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            hall2.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room study2 = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            study2.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room kitchen = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            kitchen.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room diningRoom = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            diningRoom.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room abandonedRoom = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            abandonedRoom.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room emptyRoom = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            emptyRoom.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room stairs2 = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            stairs2.setLook(parameters[4]);

            // Ground floor
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room bedroom3 = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            bedroom3.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room mosaicRoom = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            mosaicRoom.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room kitchen2 = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            kitchen2.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room paintingRoom = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            paintingRoom.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room library = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            library.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room livingRoom2 = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            livingRoom2.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room projectorRoom = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            projectorRoom.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room hall3 = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            hall3.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room stringRoom = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            stringRoom.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room stairs3 = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            stairs3.setLook(parameters[4]);

            // Basement
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room bedroom4 = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            bedroom4.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room study3 = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            study3.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room barrelRoom = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            barrelRoom.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room winterRoom = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            winterRoom.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room clockRoom = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            clockRoom.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room sandRoom = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            sandRoom.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room storage = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            storage.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room kitchen3 = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            kitchen3.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room mannequinRoom = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            mannequinRoom.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room endlessRoom = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            endlessRoom.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room eyeRoom = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            eyeRoom.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room mirrorRoom = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            mirrorRoom.setLook(parameters[4]);
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room stairs4 = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            stairs4.setLook(parameters[4]);

            // The end
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room theEnd = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            theEnd.setLook(parameters[4]);

            // Roof
            lineRoom = brRoom.readLine();
            parameters = lineRoom.split("#");
            Room roof = new Room(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
            roof.setLook(parameters[4]);

            //---Maps---
            // First floor
            bedroom.setSouth(hallway);
            bedroom.setPathMinimap("/img/Rooms/Room_S.png");
            bedroom.setPathView("/img/View/bedroom_1.png");
            hallway.setNorth(bedroom);
            hallway.setEast(livingRoom);
            hallway.setPathMinimap("/img/Hallways/HallwayHor_N_E.png");
            hallway.setPathView("/img/View/hallway_1.png");
            livingRoom.setWest(hallway);
            livingRoom.setSouth(hall);
            livingRoom.setPathMinimap("/img/Rooms/Room_O_S.png");
            livingRoom.setPathView("/img/View/living_room_1.png");
            hall.setNorth(livingRoom);
            hall.setEast(study);
            hall.setPathMinimap("/img/Rooms/Room_N_E.png");
            hall.setPathView("/img/View/hall_1.png");
            study.setEast(stairs);
            study.setWest(hall);
            study.setSouth(bathroom);
            study.setPathMinimap("/img/Rooms/Room_E_O_S.png");
            study.setPathView("/img/View/study_1_locked.png");
            bathroom.setNorth(study);
            bathroom.setPathMinimap("/img/Rooms/Room_N.png");
            bathroom.setPathView("/img/View/bathroom_1.png");
            stairs.setWest(study);
            stairs.setNorth(bedroom2);
            stairs.setEast(bedroom3);
            stairs.setLocked(true);
            stairs.setPathMinimap("/img/Stairs/Stairs_floor_1.png");
            stairs.setPathView("/img/View/stairs_1_locked.png");
            getRooms().add(bedroom);
            getRooms().add(hallway);
            getRooms().add(livingRoom);
            getRooms().add(hall);
            getRooms().add(study);
            getRooms().add(bathroom);
            getRooms().add(stairs);

            // Second floor
            bedroom2.setSouth(stairs);
            bedroom2.setWest(hall2);
            bedroom2.setPathMinimap("/img/Rooms/Room_O_S.png");
            bedroom2.setPathView("/img/View/bedroom_2.png");
            hall2.setNorth(study2);
            hall2.setEast(bedroom2);
            hall2.setSouth(kitchen);
            hall2.setPathMinimap("/img/Rooms/Room_N_E_S.png");
            hall2.setPathView("/img/View/hall_2.png");
            study2.setSouth(hall2);
            study2.setPathMinimap("/img/Hallways/HallwayHor_S.png");
            study2.setPathView("/img/View/study_2.png");
            kitchen.setNorth(hall2);
            kitchen.setSouth(diningRoom);
            kitchen.setPathMinimap("/img/Hallways/HallwayHor_N_S.png");
            kitchen.setPathView("/img/View/kitchen.png");
            diningRoom.setNorth(kitchen);
            diningRoom.setEast(abandonedRoom);
            diningRoom.setPathMinimap("/img/Rooms/Room_N_E.png");
            diningRoom.setPathView("/img/View/dining_room.png");
            abandonedRoom.setEast(emptyRoom);
            abandonedRoom.setWest(diningRoom);
            abandonedRoom.setPathMinimap("/img/Hallways/HallwayHor_E_O.png");
            abandonedRoom.setPathView("/img/View/abandoned_room.png");
            emptyRoom.setNorth(stairs2);
            emptyRoom.setWest(abandonedRoom);
            emptyRoom.setPathMinimap("/img/Hallways/HallwayHor_N_O.png");
            emptyRoom.setPathView("/img/View/empty_room.png");
            stairs2.setWest(roof);
            stairs2.setSouth(emptyRoom);
            stairs2.setPathMinimap("/img/Stairs/Stairs_floor_2.png");
            stairs2.setPathView("/img/View/stairs_2.png");
            getRooms().add(bedroom2);
            getRooms().add(hall2);
            getRooms().add(study2);
            getRooms().add(kitchen);
            getRooms().add(diningRoom);
            getRooms().add(abandonedRoom);
            getRooms().add(emptyRoom);
            getRooms().add(stairs2);

            // Ground floor 
            bedroom3.setWest(stairs);
            bedroom3.setSouth(mosaicRoom);
            bedroom3.setLocked(true);
            bedroom3.setPathMinimap("/img/Rooms/Room_O_S.png");
            bedroom3.setPathView("/img/View/bedroom_3.png");
            mosaicRoom.setNorth(bedroom3);
            mosaicRoom.setEast(livingRoom2);
            mosaicRoom.setWest(kitchen2);
            mosaicRoom.setPathMinimap("/img/Rooms/Room_N_E_O.png");
            mosaicRoom.setPathView("/img/View/mosaic_room_unsolved.png");
            kitchen2.setEast(mosaicRoom);
            kitchen2.setWest(paintingRoom);
            kitchen2.setPathMinimap("/img/Rooms/Room_E_O.png");
            kitchen2.setPathView("/img/View/kitchen_2.png");
            paintingRoom.setNorth(library);
            paintingRoom.setEast(kitchen2);
            paintingRoom.setPathMinimap("/img/Rooms/Room_N_E.png");
            paintingRoom.setPathView("/img/View/painting_room.png");
            library.setSouth(paintingRoom);
            library.setPathMinimap("/img/Hallways/HallwayVer_S.png");
            library.setPathView("/img/View/library.png");
            livingRoom2.setNorth(projectorRoom);
            livingRoom2.setWest(mosaicRoom);
            livingRoom2.setPathMinimap("/img/Rooms/Room_N_O.png");
            livingRoom2.setPathView("/img/View/living_room_2.png");
            projectorRoom.setEast(hall3);
            projectorRoom.setSouth(livingRoom2);
            projectorRoom.setPathMinimap("/img/Rooms/Room_E_S.png");
            projectorRoom.setPathView("/img/View/projector_room.png");
            hall3.setNorth(stringRoom);
            hall3.setWest(projectorRoom);
            hall3.setPathMinimap("/img/Rooms/Room_N_O.png");
            hall3.setPathView("/img/View/hall_3.png");
            stringRoom.setWest(stairs3);
            stringRoom.setSouth(hall3);
            stringRoom.setPathMinimap("/img/Hallways/HallwayHor_O_S.png");
            stringRoom.setPathView("/img/View/string_room_locked.png");
            stairs3.setEast(stringRoom);
            stairs3.setSouth(bedroom4);
            stairs3.setPathMinimap("/img/Stairs/Stairs_floor_3.png");
            stairs3.setPathView("/img/View/stairs_3.png");
            stairs3.setLocked(true);
            getRooms().add(bedroom3);
            getRooms().add(mosaicRoom);
            getRooms().add(kitchen2);
            getRooms().add(paintingRoom);
            getRooms().add(library);
            getRooms().add(livingRoom2);
            getRooms().add(projectorRoom);
            getRooms().add(hall3);
            getRooms().add(stringRoom);
            getRooms().add(stairs3);

            // Basement
            bedroom4.setEast(study3);
            bedroom4.setNorth(stairs3);
            bedroom4.setPathMinimap("/img/Rooms/Room_N_E.png");
            bedroom4.setPathView("/img/View/bedroom_4.png");
            study3.setEast(barrelRoom);
            study3.setWest(bedroom4);
            study3.setPathMinimap("/img/Rooms/Room_E_O.png");
            study3.setPathView("/img/View/study_3.png");
            barrelRoom.setNorth(winterRoom);
            barrelRoom.setWest(study3);
            barrelRoom.setPathMinimap("/img/Rooms/Room_N_O.png");
            barrelRoom.setPathView("/img/View/barrel_room.png");
            winterRoom.setWest(clockRoom);
            winterRoom.setSouth(barrelRoom);
            winterRoom.setPathMinimap("/img/Hallways/HallwayVer_O_S.png");
            winterRoom.setPathView("/img/View/winter_room_bucket.png");
            clockRoom.setEast(winterRoom);
            clockRoom.setWest(sandRoom);
            clockRoom.setPathMinimap("/img/Hallways/HallwayHor_E_O.png");
            clockRoom.setPathView("/img/View/clock_room.png");
            sandRoom.setEast(clockRoom);
            sandRoom.setWest(storage);
            sandRoom.setPathMinimap("/img/Rooms/Room_E_O.png");
            sandRoom.setPathView("/img/View/sand_room.png");
            storage.setEast(sandRoom);
            storage.setSouth(kitchen3);
            storage.setPathMinimap("/img/Rooms/Room_E_S.png");
            storage.setPathView("/img/View/storage.png");
            kitchen3.setNorth(storage);
            kitchen3.setSouth(mannequinRoom);
            kitchen3.setPathMinimap("/img/Hallways/HallwayVer_N_S.png");
            kitchen3.setPathView("/img/View/kitchen_3.png");
            mannequinRoom.setNorth(kitchen3);
            mannequinRoom.setSouth(endlessRoom);
            mannequinRoom.setPathMinimap("/img/Rooms/Room_N_S.png");
            mannequinRoom.setPathView("/img/View/mannequin_room.png");
            endlessRoom.setNorth(mannequinRoom);
            endlessRoom.setEast(endlessRoom);
            endlessRoom.setPathMinimap("/img/Rooms/Room_N_E.png");
            endlessRoom.setPathView("/img/View/endless_room.png");
            eyeRoom.setEast(mirrorRoom);
            eyeRoom.setWest(endlessRoom);
            eyeRoom.setPathMinimap("/img/Hallways/HallwayHor_E_O.png");
            eyeRoom.setPathView("/img/View/eye_room.png");
            mirrorRoom.setNorth(stairs4);
            mirrorRoom.setWest(eyeRoom);
            mirrorRoom.setPathMinimap("/img/Hallways/HallwayHor_N_O.png");
            mirrorRoom.setPathView("/img/View/mirror_room.png");
            stairs4.setSouth(mirrorRoom);
            stairs4.setNorth(theEnd);
            stairs4.setPathMinimap("/img/Stairs/Stairs_floor_4.png");
            stairs4.setPathView("/img/View/stairs_4.png");
            stairs4.setLocked(true);
            getRooms().add(bedroom4);
            getRooms().add(study3);
            getRooms().add(barrelRoom);
            getRooms().add(winterRoom);
            getRooms().add(clockRoom);
            getRooms().add(sandRoom);
            getRooms().add(storage);
            getRooms().add(kitchen3);
            getRooms().add(mannequinRoom);
            getRooms().add(endlessRoom);
            getRooms().add(eyeRoom);
            getRooms().add(mirrorRoom);
            getRooms().add(stairs4);

            // The end
            theEnd.setPathView("/img/View/the_end.png");
            getRooms().add(theEnd);

            // Roof
            roof.setEast(stairs2);
            roof.setPathMinimap("/img/Rooms/Roof.png");
            roof.setPathView("/img/View/roof.png");
            getRooms().add(roof);

            //---Objects---
            // First floor
            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject bed1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //1
            bed1.setAlias(new String[]{});
            bed1.setOpenable(Boolean.parseBoolean(parameters[3]));
            bed1.setPickupable(Boolean.parseBoolean(parameters[4]));
            bed1.setOpen(Boolean.parseBoolean(parameters[5]));
            bed1.setPushable(Boolean.parseBoolean(parameters[6]));
            bed1.setPush(Boolean.parseBoolean(parameters[7]));
            bedroom.getObjects().add(bed1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer bedsideTable = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //2
            bedsideTable.setAlias(new String[]{});
            bedsideTable.setOpenable(Boolean.parseBoolean(parameters[3]));
            bedsideTable.setPickupable(Boolean.parseBoolean(parameters[4]));
            bedsideTable.setOpen(Boolean.parseBoolean(parameters[5]));
            bedsideTable.setPushable(Boolean.parseBoolean(parameters[6]));
            bedsideTable.setPush(Boolean.parseBoolean(parameters[7]));
            bedroom.getObjects().add(bedsideTable);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject lamp1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //3
            lamp1.setAlias(new String[]{"lume"});
            lamp1.setOpenable(Boolean.parseBoolean(parameters[3]));
            lamp1.setPickupable(Boolean.parseBoolean(parameters[4]));
            lamp1.setOpen(Boolean.parseBoolean(parameters[5]));
            lamp1.setPushable(Boolean.parseBoolean(parameters[6]));
            lamp1.setPush(Boolean.parseBoolean(parameters[7]));
            bedroom.getObjects().add(lamp1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject drawer1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //4
            drawer1.setAlias(new String[]{"primo cassetto", "cassetto 1", "primo tiretto", "tiretto 1"});
            drawer1.setOpenable(Boolean.parseBoolean(parameters[3]));
            drawer1.setPickupable(Boolean.parseBoolean(parameters[4]));
            drawer1.setOpen(Boolean.parseBoolean(parameters[5]));
            drawer1.setPushable(Boolean.parseBoolean(parameters[6]));
            drawer1.setPush(Boolean.parseBoolean(parameters[7]));
            drawer1.setContained(bedsideTable.getId());
            bedsideTable.add(drawer1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject drawer2 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //5
            drawer2.setAlias(new String[]{"secondo cassetto", "cassetto 2", "secondo tiretto", "tiretto 2"});
            drawer2.setOpenable(Boolean.parseBoolean(parameters[3]));
            drawer2.setPickupable(Boolean.parseBoolean(parameters[4]));
            drawer2.setOpen(Boolean.parseBoolean(parameters[5]));
            drawer2.setPushable(Boolean.parseBoolean(parameters[6]));
            drawer2.setPush(Boolean.parseBoolean(parameters[7]));
            drawer2.setContained(bedsideTable.getId());
            bedsideTable.add(drawer2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject desk1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //6
            desk1.setAlias(new String[]{"scrittorio", "tavolo", "tavolino"});
            desk1.setOpenable(Boolean.parseBoolean(parameters[3]));
            desk1.setPickupable(Boolean.parseBoolean(parameters[4]));
            desk1.setOpen(Boolean.parseBoolean(parameters[5]));
            desk1.setPushable(Boolean.parseBoolean(parameters[6]));
            desk1.setPush(Boolean.parseBoolean(parameters[7]));
            bedroom.getObjects().add(desk1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject chair = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //7
            chair.setAlias(new String[]{});
            chair.setOpenable(Boolean.parseBoolean(parameters[3]));
            chair.setPickupable(Boolean.parseBoolean(parameters[4]));
            chair.setOpen(Boolean.parseBoolean(parameters[5]));
            chair.setPushable(Boolean.parseBoolean(parameters[6]));
            chair.setPush(Boolean.parseBoolean(parameters[7]));
            bedroom.getObjects().add(chair);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject wardrobe = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //8
            wardrobe.setAlias(new String[]{"guardaroba"});
            wardrobe.setOpenable(Boolean.parseBoolean(parameters[3]));
            wardrobe.setPickupable(Boolean.parseBoolean(parameters[4]));
            wardrobe.setOpen(Boolean.parseBoolean(parameters[5]));
            wardrobe.setPushable(Boolean.parseBoolean(parameters[6]));
            wardrobe.setPush(Boolean.parseBoolean(parameters[7]));
            hallway.getObjects().add(wardrobe);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject picture1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //9
            picture1.setAlias(new String[]{});
            picture1.setOpenable(Boolean.parseBoolean(parameters[3]));
            picture1.setPickupable(Boolean.parseBoolean(parameters[4]));
            picture1.setOpen(Boolean.parseBoolean(parameters[5]));
            picture1.setPushable(Boolean.parseBoolean(parameters[6]));
            picture1.setPush(Boolean.parseBoolean(parameters[7]));
            hallway.getObjects().add(picture1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject picture2 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //10
            picture2.setAlias(new String[]{});
            picture2.setOpenable(Boolean.parseBoolean(parameters[3]));
            picture2.setPickupable(Boolean.parseBoolean(parameters[4]));
            picture2.setOpen(Boolean.parseBoolean(parameters[5]));
            picture2.setPushable(Boolean.parseBoolean(parameters[6]));
            picture2.setPush(Boolean.parseBoolean(parameters[7]));
            hallway.getObjects().add(picture2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject shelf = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //11
            shelf.setAlias(new String[]{"ripiano"});
            shelf.setOpenable(Boolean.parseBoolean(parameters[3]));
            shelf.setPickupable(Boolean.parseBoolean(parameters[4]));
            shelf.setOpen(Boolean.parseBoolean(parameters[5]));
            shelf.setPushable(Boolean.parseBoolean(parameters[6]));
            shelf.setPush(Boolean.parseBoolean(parameters[7]));
            hallway.getObjects().add(shelf);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject telephone1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //12
            telephone1.setAlias(new String[]{"telefono fisso"});
            telephone1.setOpenable(Boolean.parseBoolean(parameters[3]));
            telephone1.setPickupable(Boolean.parseBoolean(parameters[4]));
            telephone1.setOpen(Boolean.parseBoolean(parameters[5]));
            telephone1.setPushable(Boolean.parseBoolean(parameters[6]));
            telephone1.setPush(Boolean.parseBoolean(parameters[7]));
            hallway.getObjects().add(telephone1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject addressBook = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //13
            addressBook.setAlias(new String[]{"agenda", "registro", "elenco"});
            addressBook.setOpenable(Boolean.parseBoolean(parameters[3]));
            addressBook.setPickupable(Boolean.parseBoolean(parameters[4]));
            addressBook.setOpen(Boolean.parseBoolean(parameters[5]));
            addressBook.setPushable(Boolean.parseBoolean(parameters[6]));
            addressBook.setPush(Boolean.parseBoolean(parameters[7]));
            hallway.getObjects().add(addressBook);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject television1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //14
            television1.setAlias(new String[]{"televisore", "tv"});
            television1.setOpenable(Boolean.parseBoolean(parameters[3]));
            television1.setPickupable(Boolean.parseBoolean(parameters[4]));
            television1.setOpen(Boolean.parseBoolean(parameters[5]));
            television1.setPushable(Boolean.parseBoolean(parameters[6]));
            television1.setPush(Boolean.parseBoolean(parameters[7]));
            livingRoom.getObjects().add(television1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject table1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //15
            table1.setAlias(new String[]{"tavola", "tavolino"});
            table1.setOpenable(Boolean.parseBoolean(parameters[3]));
            table1.setPickupable(Boolean.parseBoolean(parameters[4]));
            table1.setOpen(Boolean.parseBoolean(parameters[5]));
            table1.setPushable(Boolean.parseBoolean(parameters[6]));
            table1.setPush(Boolean.parseBoolean(parameters[7]));
            livingRoom.getObjects().add(table1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer mobile1 = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //16
            mobile1.setAlias(new String[]{"immobile", "fisso"});
            mobile1.setOpenable(Boolean.parseBoolean(parameters[3]));
            mobile1.setPickupable(Boolean.parseBoolean(parameters[4]));
            mobile1.setOpen(Boolean.parseBoolean(parameters[5]));
            mobile1.setPushable(Boolean.parseBoolean(parameters[6]));
            mobile1.setPush(Boolean.parseBoolean(parameters[7]));
            livingRoom.getObjects().add(mobile1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject drawer3 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //17
            drawer3.setAlias(new String[]{"primo cassetto", "cassetto 1", "primo tiretto", "tiretto 1"});
            drawer3.setOpenable(Boolean.parseBoolean(parameters[3]));
            drawer3.setPickupable(Boolean.parseBoolean(parameters[4]));
            drawer3.setOpen(Boolean.parseBoolean(parameters[5]));
            drawer3.setPushable(Boolean.parseBoolean(parameters[6]));
            drawer3.setPush(Boolean.parseBoolean(parameters[7]));
            drawer3.setContained(mobile1.getId());
            mobile1.add(drawer3);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject drawer4 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //18
            drawer4.setAlias(new String[]{"secondo cassetto", "cassetto 2", "secondo tiretto", "tiretto 2"});
            drawer4.setOpenable(Boolean.parseBoolean(parameters[3]));
            drawer4.setPickupable(Boolean.parseBoolean(parameters[4]));
            drawer4.setOpen(Boolean.parseBoolean(parameters[5]));
            drawer4.setPushable(Boolean.parseBoolean(parameters[6]));
            drawer4.setPush(Boolean.parseBoolean(parameters[7]));
            drawer4.setContained(mobile1.getId());
            mobile1.add(drawer4);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject drawer5 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //19
            drawer5.setAlias(new String[]{"terzo cassetto", "cassetto 3", "terzo tiretto", "tiretto 3"});
            drawer5.setOpenable(Boolean.parseBoolean(parameters[3]));
            drawer5.setPickupable(Boolean.parseBoolean(parameters[4]));
            drawer5.setOpen(Boolean.parseBoolean(parameters[5]));
            drawer5.setPushable(Boolean.parseBoolean(parameters[6]));
            drawer5.setPush(Boolean.parseBoolean(parameters[7]));
            drawer5.setContained(mobile1.getId());
            mobile1.add(drawer5);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject drawer6 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //20
            drawer6.setAlias(new String[]{"quarto cassetto", "cassetto 4", "quarto tiretto", "tiretto 4"});
            drawer6.setOpenable(Boolean.parseBoolean(parameters[3]));
            drawer6.setPickupable(Boolean.parseBoolean(parameters[4]));
            drawer6.setOpen(Boolean.parseBoolean(parameters[5]));
            drawer6.setPushable(Boolean.parseBoolean(parameters[6]));
            drawer6.setPush(Boolean.parseBoolean(parameters[7]));
            drawer6.setContained(mobile1.getId());
            mobile1.add(drawer6);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject doormat1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //21
            doormat1.setAlias(new String[]{"tappetino"});
            doormat1.setOpenable(Boolean.parseBoolean(parameters[3]));
            doormat1.setPickupable(Boolean.parseBoolean(parameters[4]));
            doormat1.setOpen(Boolean.parseBoolean(parameters[5]));
            doormat1.setPushable(Boolean.parseBoolean(parameters[6]));
            doormat1.setPush(Boolean.parseBoolean(parameters[7]));
            hall.getObjects().add(doormat1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject mirror1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //22
            mirror1.setAlias(new String[]{});
            mirror1.setOpenable(Boolean.parseBoolean(parameters[3]));
            mirror1.setPickupable(Boolean.parseBoolean(parameters[4]));
            mirror1.setOpen(Boolean.parseBoolean(parameters[5]));
            mirror1.setPushable(Boolean.parseBoolean(parameters[6]));
            mirror1.setPush(Boolean.parseBoolean(parameters[7]));
            hall.getObjects().add(mirror1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject wallKeyHolder1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //23
            wallKeyHolder1.setAlias(new String[]{"portachiavi", "portachiavi muro"});
            wallKeyHolder1.setOpenable(Boolean.parseBoolean(parameters[3]));
            wallKeyHolder1.setPickupable(Boolean.parseBoolean(parameters[4]));
            wallKeyHolder1.setOpen(Boolean.parseBoolean(parameters[5]));
            wallKeyHolder1.setPushable(Boolean.parseBoolean(parameters[6]));
            wallKeyHolder1.setPush(Boolean.parseBoolean(parameters[7]));
            hall.getObjects().add(wallKeyHolder1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject key12 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //24
            key12.setAlias(new String[]{"chiave", "chiave pianoterra", "chiave secondo piano"});
            key12.setOpenable(Boolean.parseBoolean(parameters[3]));
            key12.setPickupable(Boolean.parseBoolean(parameters[4]));
            key12.setOpen(Boolean.parseBoolean(parameters[5]));
            key12.setPushable(Boolean.parseBoolean(parameters[6]));
            key12.setPush(Boolean.parseBoolean(parameters[7]));
            hall.getObjects().add(key12);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject shoePair1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //25
            shoePair1.setAlias(new String[]{"paio di scarpe 1", "scarpe 1", "primo paio scarpe"});
            shoePair1.setOpenable(Boolean.parseBoolean(parameters[3]));
            shoePair1.setPickupable(Boolean.parseBoolean(parameters[4]));
            shoePair1.setOpen(Boolean.parseBoolean(parameters[5]));
            shoePair1.setPushable(Boolean.parseBoolean(parameters[6]));
            shoePair1.setPush(Boolean.parseBoolean(parameters[7]));
            hall.getObjects().add(shoePair1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject shoePair2 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //26
            shoePair2.setAlias(new String[]{"paio di scarpe 2", "scarpe 2", "secondo paio scarpe"});
            shoePair2.setOpenable(Boolean.parseBoolean(parameters[3]));
            shoePair2.setPickupable(Boolean.parseBoolean(parameters[4]));
            shoePair2.setOpen(Boolean.parseBoolean(parameters[5]));
            shoePair2.setPushable(Boolean.parseBoolean(parameters[6]));
            shoePair2.setPush(Boolean.parseBoolean(parameters[7]));
            hall.getObjects().add(shoePair2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject desk2 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //27
            desk2.setAlias(new String[]{"scrittorio", "tavolo", "tavolino"});
            desk2.setOpenable(Boolean.parseBoolean(parameters[3]));
            desk2.setPickupable(Boolean.parseBoolean(parameters[4]));
            desk2.setOpen(Boolean.parseBoolean(parameters[5]));
            desk2.setPushable(Boolean.parseBoolean(parameters[6]));
            desk2.setPush(Boolean.parseBoolean(parameters[7]));
            study.getObjects().add(desk2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject computer1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //28
            computer1.setAlias(new String[]{"computer", "PC", "pc", "portatile"});
            computer1.setOpenable(Boolean.parseBoolean(parameters[3]));
            computer1.setPickupable(Boolean.parseBoolean(parameters[4]));
            computer1.setOpen(Boolean.parseBoolean(parameters[5]));
            computer1.setPushable(Boolean.parseBoolean(parameters[6]));
            computer1.setPush(Boolean.parseBoolean(parameters[7]));
            study.getObjects().add(computer1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject chair2 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //29
            chair2.setAlias(new String[]{});
            chair2.setOpenable(Boolean.parseBoolean(parameters[3]));
            chair2.setPickupable(Boolean.parseBoolean(parameters[4]));
            chair2.setOpen(Boolean.parseBoolean(parameters[5]));
            chair2.setPushable(Boolean.parseBoolean(parameters[6]));
            chair2.setPush(Boolean.parseBoolean(parameters[7]));
            study.getObjects().add(chair2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject sofa1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //30
            sofa1.setAlias(new String[]{"sofa", "sofà"});
            sofa1.setOpenable(Boolean.parseBoolean(parameters[3]));
            sofa1.setPickupable(Boolean.parseBoolean(parameters[4]));
            sofa1.setOpen(Boolean.parseBoolean(parameters[5]));
            sofa1.setPushable(Boolean.parseBoolean(parameters[6]));
            sofa1.setPush(Boolean.parseBoolean(parameters[7]));
            study.getObjects().add(sofa1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject wc = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //31
            wc.setAlias(new String[]{"toilette", "water"});
            wc.setOpenable(Boolean.parseBoolean(parameters[3]));
            wc.setPickupable(Boolean.parseBoolean(parameters[4]));
            wc.setOpen(Boolean.parseBoolean(parameters[5]));
            wc.setPushable(Boolean.parseBoolean(parameters[6]));
            wc.setPush(Boolean.parseBoolean(parameters[7]));
            bathroom.getObjects().add(wc);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject sink1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //32
            sink1.setAlias(new String[]{"lavello", "lavamano"});
            sink1.setOpenable(Boolean.parseBoolean(parameters[3]));
            sink1.setPickupable(Boolean.parseBoolean(parameters[4]));
            sink1.setOpen(Boolean.parseBoolean(parameters[5]));
            sink1.setPushable(Boolean.parseBoolean(parameters[6]));
            sink1.setPush(Boolean.parseBoolean(parameters[7]));
            bathroom.getObjects().add(sink1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject bidet1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //33
            bidet1.setAlias(new String[]{});
            bidet1.setOpenable(Boolean.parseBoolean(parameters[3]));
            bidet1.setPickupable(Boolean.parseBoolean(parameters[4]));
            bidet1.setOpen(Boolean.parseBoolean(parameters[5]));
            bidet1.setPushable(Boolean.parseBoolean(parameters[6]));
            bidet1.setPush(Boolean.parseBoolean(parameters[7]));
            bathroom.getObjects().add(bidet1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject bathtub1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //34
            bathtub1.setAlias(new String[]{});
            bathtub1.setOpenable(Boolean.parseBoolean(parameters[3]));
            bathtub1.setPickupable(Boolean.parseBoolean(parameters[4]));
            bathtub1.setOpen(Boolean.parseBoolean(parameters[5]));
            bathtub1.setPushable(Boolean.parseBoolean(parameters[6]));
            bathtub1.setPush(Boolean.parseBoolean(parameters[7]));
            bathroom.getObjects().add(bathtub1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer mirror2 = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //35 
            mirror2.setAlias(new String[]{"specchio scompartimento", "specchio"});
            mirror2.setOpenable(Boolean.parseBoolean(parameters[3]));
            mirror2.setPickupable(Boolean.parseBoolean(parameters[4]));
            mirror2.setOpen(Boolean.parseBoolean(parameters[5]));
            mirror2.setPushable(Boolean.parseBoolean(parameters[6]));
            mirror2.setPush(Boolean.parseBoolean(parameters[7]));
            bathroom.getObjects().add(mirror2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject medsCompartment = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //36
            medsCompartment.setAlias(new String[]{"scompartimento", "medicinali"});
            medsCompartment.setOpenable(Boolean.parseBoolean(parameters[3]));
            medsCompartment.setPickupable(Boolean.parseBoolean(parameters[4]));
            medsCompartment.setOpen(Boolean.parseBoolean(parameters[5]));
            medsCompartment.setPushable(Boolean.parseBoolean(parameters[6]));
            medsCompartment.setPush(Boolean.parseBoolean(parameters[7]));
            medsCompartment.setContained(mirror2.getId());
            mirror2.add(medsCompartment);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject door1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //37
            door1.setAlias(new String[]{"porta"});
            door1.setOpenable(Boolean.parseBoolean(parameters[3]));
            door1.setPickupable(Boolean.parseBoolean(parameters[4]));
            door1.setOpen(Boolean.parseBoolean(parameters[5]));
            door1.setPushable(Boolean.parseBoolean(parameters[6]));
            door1.setPush(Boolean.parseBoolean(parameters[7]));
            study.getObjects().add(door1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject door2 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //38
            door2.setAlias(new String[]{"porta"});
            door2.setOpenable(Boolean.parseBoolean(parameters[3]));
            door2.setPickupable(Boolean.parseBoolean(parameters[4]));
            door2.setOpen(Boolean.parseBoolean(parameters[5]));
            door2.setPushable(Boolean.parseBoolean(parameters[6]));
            door2.setPush(Boolean.parseBoolean(parameters[7]));
            stairs.getObjects().add(door2);

            // Secondo Piano
            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject bed2 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //39
            bed2.setAlias(new String[]{});
            bed2.setOpenable(Boolean.parseBoolean(parameters[3]));
            bed2.setPickupable(Boolean.parseBoolean(parameters[4]));
            bed2.setOpen(Boolean.parseBoolean(parameters[5]));
            bed2.setPushable(Boolean.parseBoolean(parameters[6]));
            bed2.setPush(Boolean.parseBoolean(parameters[7]));
            bedroom2.getObjects().add(bed2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject bedsideTable2 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //40
            bedsideTable2.setAlias(new String[]{});
            bedsideTable2.setOpenable(Boolean.parseBoolean(parameters[3]));
            bedsideTable2.setPickupable(Boolean.parseBoolean(parameters[4]));
            bedsideTable2.setOpen(Boolean.parseBoolean(parameters[5]));
            bedsideTable2.setPushable(Boolean.parseBoolean(parameters[6]));
            bedsideTable2.setPush(Boolean.parseBoolean(parameters[7]));
            bedroom2.getObjects().add(bedsideTable2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject desk3 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //41
            desk3.setAlias(new String[]{"scrittorio", "tavolo", "tavolino"});
            desk3.setOpenable(Boolean.parseBoolean(parameters[3]));
            desk3.setPickupable(Boolean.parseBoolean(parameters[4]));
            desk3.setOpen(Boolean.parseBoolean(parameters[5]));
            desk3.setPushable(Boolean.parseBoolean(parameters[6]));
            desk3.setPush(Boolean.parseBoolean(parameters[7]));
            bedroom2.getObjects().add(desk3);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject chair3 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //42 
            chair3.setAlias(new String[]{});
            chair3.setOpenable(Boolean.parseBoolean(parameters[3]));
            chair3.setPickupable(Boolean.parseBoolean(parameters[4]));
            chair3.setOpen(Boolean.parseBoolean(parameters[5]));
            chair3.setPushable(Boolean.parseBoolean(parameters[6]));
            chair3.setPush(Boolean.parseBoolean(parameters[7]));
            bedroom2.getObjects().add(chair3);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject computer2 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //43
            computer2.setAlias(new String[]{"computer", "PC", "pc", "portatile"});
            computer2.setOpenable(Boolean.parseBoolean(parameters[3]));
            computer2.setPickupable(Boolean.parseBoolean(parameters[4]));
            computer2.setOpen(Boolean.parseBoolean(parameters[5]));
            computer2.setPushable(Boolean.parseBoolean(parameters[6]));
            computer2.setPush(Boolean.parseBoolean(parameters[7]));
            bedroom2.getObjects().add(computer2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject wallKeyHolder2 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //44
            wallKeyHolder2.setAlias(new String[]{"portachiavi", "portachiavi muro"});
            wallKeyHolder2.setOpenable(Boolean.parseBoolean(parameters[3]));
            wallKeyHolder2.setPickupable(Boolean.parseBoolean(parameters[4]));
            wallKeyHolder2.setOpen(Boolean.parseBoolean(parameters[5]));
            wallKeyHolder2.setPushable(Boolean.parseBoolean(parameters[6]));
            wallKeyHolder2.setPush(Boolean.parseBoolean(parameters[7]));
            hall2.getObjects().add(wallKeyHolder2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject engravedKey = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //45
            engravedKey.setAlias(new String[]{"chiave"});
            engravedKey.setOpenable(Boolean.parseBoolean(parameters[3]));
            engravedKey.setPickupable(Boolean.parseBoolean(parameters[4]));
            engravedKey.setOpen(Boolean.parseBoolean(parameters[5]));
            engravedKey.setPushable(Boolean.parseBoolean(parameters[6]));
            engravedKey.setPush(Boolean.parseBoolean(parameters[7]));
            hall2.getObjects().add(engravedKey);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject floormat2 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //46
            floormat2.setAlias(new String[]{"tappetino"});
            floormat2.setOpenable(Boolean.parseBoolean(parameters[3]));
            floormat2.setPickupable(Boolean.parseBoolean(parameters[4]));
            floormat2.setOpen(Boolean.parseBoolean(parameters[5]));
            floormat2.setPushable(Boolean.parseBoolean(parameters[6]));
            floormat2.setPush(Boolean.parseBoolean(parameters[7]));
            hall2.getObjects().add(floormat2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject shoePair3 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //47
            shoePair3.setAlias(new String[]{"scarpe", "paio scarpe"});
            shoePair3.setOpenable(Boolean.parseBoolean(parameters[3]));
            shoePair3.setPickupable(Boolean.parseBoolean(parameters[4]));
            shoePair3.setOpen(Boolean.parseBoolean(parameters[5]));
            shoePair3.setPushable(Boolean.parseBoolean(parameters[6]));
            shoePair3.setPush(Boolean.parseBoolean(parameters[7]));
            hall2.getObjects().add(shoePair3);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject desk4 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //48
            desk4.setAlias(new String[]{"tavolino", "tavolo"});
            desk4.setOpenable(Boolean.parseBoolean(parameters[3]));
            desk4.setPickupable(Boolean.parseBoolean(parameters[4]));
            desk4.setOpen(Boolean.parseBoolean(parameters[5]));
            desk4.setPushable(Boolean.parseBoolean(parameters[6]));
            desk4.setPush(Boolean.parseBoolean(parameters[7]));
            study2.getObjects().add(desk4);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer safe = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //49
            safe.setAlias(new String[]{});
            safe.setOpenable(Boolean.parseBoolean(parameters[3]));
            safe.setPickupable(Boolean.parseBoolean(parameters[4]));
            safe.setOpen(Boolean.parseBoolean(parameters[5]));
            safe.setPushable(Boolean.parseBoolean(parameters[6]));
            safe.setPush(Boolean.parseBoolean(parameters[7]));
            study2.getObjects().add(safe);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject redKey = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //50
            redKey.setAlias(new String[]{"chiave"});
            redKey.setOpenable(Boolean.parseBoolean(parameters[3]));
            redKey.setPickupable(Boolean.parseBoolean(parameters[4]));
            redKey.setOpen(Boolean.parseBoolean(parameters[5]));
            redKey.setPushable(Boolean.parseBoolean(parameters[6]));
            redKey.setPush(Boolean.parseBoolean(parameters[7]));
            redKey.setContained(safe.getId());
            safe.add(redKey);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject chair4 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //51
            chair4.setAlias(new String[]{});
            chair4.setOpenable(Boolean.parseBoolean(parameters[3]));
            chair4.setPickupable(Boolean.parseBoolean(parameters[4]));
            chair4.setOpen(Boolean.parseBoolean(parameters[5]));
            chair4.setPushable(Boolean.parseBoolean(parameters[6]));
            chair4.setPush(Boolean.parseBoolean(parameters[7]));
            study2.getObjects().add(chair4);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject computer3 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //52
            computer3.setAlias(new String[]{"portatile", "computer portatile", "PC", "pc"});
            computer3.setOpenable(Boolean.parseBoolean(parameters[3]));
            computer3.setPickupable(Boolean.parseBoolean(parameters[4]));
            computer3.setOpen(Boolean.parseBoolean(parameters[5]));
            computer3.setPushable(Boolean.parseBoolean(parameters[6]));
            computer3.setPush(Boolean.parseBoolean(parameters[7]));
            study2.getObjects().add(computer3);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject smallLibrary = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //53
            smallLibrary.setAlias(new String[]{"libreria"});
            smallLibrary.setOpenable(Boolean.parseBoolean(parameters[3]));
            smallLibrary.setPickupable(Boolean.parseBoolean(parameters[4]));
            smallLibrary.setOpen(Boolean.parseBoolean(parameters[5]));
            smallLibrary.setPushable(Boolean.parseBoolean(parameters[6]));
            smallLibrary.setPush(Boolean.parseBoolean(parameters[7]));
            study2.getObjects().add(smallLibrary);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject hob1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //54
            hob1.setAlias(new String[]{});
            hob1.setOpenable(Boolean.parseBoolean(parameters[3]));
            hob1.setPickupable(Boolean.parseBoolean(parameters[4]));
            hob1.setOpen(Boolean.parseBoolean(parameters[5]));
            hob1.setPushable(Boolean.parseBoolean(parameters[6]));
            hob1.setPush(Boolean.parseBoolean(parameters[7]));
            kitchen.getObjects().add(hob1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject hammer = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //55
            hammer.setAlias(new String[]{"strumento"});
            hammer.setOpenable(Boolean.parseBoolean(parameters[3]));
            hammer.setPickupable(Boolean.parseBoolean(parameters[4]));
            hammer.setOpen(Boolean.parseBoolean(parameters[5]));
            hammer.setPushable(Boolean.parseBoolean(parameters[6]));
            hammer.setPush(Boolean.parseBoolean(parameters[7]));
            kitchen.getObjects().add(hammer);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject brokenKnife = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //56
            brokenKnife.setAlias(new String[]{"coltello"});
            brokenKnife.setOpenable(Boolean.parseBoolean(parameters[3]));
            brokenKnife.setPickupable(Boolean.parseBoolean(parameters[4]));
            brokenKnife.setOpen(Boolean.parseBoolean(parameters[5]));
            brokenKnife.setPushable(Boolean.parseBoolean(parameters[6]));
            brokenKnife.setPush(Boolean.parseBoolean(parameters[7]));
            kitchen.getObjects().add(brokenKnife);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject fridge1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //57
            fridge1.setAlias(new String[]{});
            fridge1.setOpenable(Boolean.parseBoolean(parameters[3]));
            fridge1.setPickupable(Boolean.parseBoolean(parameters[4]));
            fridge1.setOpen(Boolean.parseBoolean(parameters[5]));
            fridge1.setPushable(Boolean.parseBoolean(parameters[6]));
            fridge1.setPush(Boolean.parseBoolean(parameters[7]));
            kitchen.getObjects().add(fridge1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject freezer = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //58
            freezer.setAlias(new String[]{});
            freezer.setOpenable(Boolean.parseBoolean(parameters[3]));
            freezer.setPickupable(Boolean.parseBoolean(parameters[4]));
            freezer.setOpen(Boolean.parseBoolean(parameters[5]));
            freezer.setPushable(Boolean.parseBoolean(parameters[6]));
            freezer.setPush(Boolean.parseBoolean(parameters[7]));
            kitchen.getObjects().add(freezer);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer mobile2 = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //59
            mobile2.setAlias(new String[]{});
            mobile2.setOpenable(Boolean.parseBoolean(parameters[3]));
            mobile2.setPickupable(Boolean.parseBoolean(parameters[4]));
            mobile2.setOpen(Boolean.parseBoolean(parameters[5]));
            mobile2.setPushable(Boolean.parseBoolean(parameters[6]));
            mobile2.setPush(Boolean.parseBoolean(parameters[7]));
            kitchen.getObjects().add(mobile2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer drawer7 = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //60
            drawer7.setAlias(new String[]{"primo cassetto", "cassetto 1", "primo tiretto", "tiretto 1"});
            drawer7.setOpenable(Boolean.parseBoolean(parameters[3]));
            drawer7.setPickupable(Boolean.parseBoolean(parameters[4]));
            drawer7.setOpen(Boolean.parseBoolean(parameters[5]));
            drawer7.setPushable(Boolean.parseBoolean(parameters[6]));
            drawer7.setPush(Boolean.parseBoolean(parameters[7]));
            drawer7.setContained(mobile2.getId());
            mobile2.add(drawer7);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer drawer8 = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //61
            drawer8.setAlias(new String[]{"secondo cassetto", "cassetto 2", "secondo tiretto", "tiretto 2"});
            drawer8.setOpenable(Boolean.parseBoolean(parameters[3]));
            drawer8.setPickupable(Boolean.parseBoolean(parameters[4]));
            drawer8.setOpen(Boolean.parseBoolean(parameters[5]));
            drawer8.setPushable(Boolean.parseBoolean(parameters[6]));
            drawer8.setPush(Boolean.parseBoolean(parameters[7]));
            drawer8.setContained(mobile2.getId());
            mobile2.add(drawer8);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject note1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //62
            note1.setAlias(new String[]{"foglio", "pezzo di carta"});
            note1.setOpenable(Boolean.parseBoolean(parameters[3]));
            note1.setPickupable(Boolean.parseBoolean(parameters[4]));
            note1.setOpen(Boolean.parseBoolean(parameters[5]));
            note1.setPushable(Boolean.parseBoolean(parameters[6]));
            note1.setPush(Boolean.parseBoolean(parameters[7]));
            note1.setContained(drawer8.getId());
            drawer8.add(note1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject dishwasher1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //63
            dishwasher1.setAlias(new String[]{"lavapiatti"});
            dishwasher1.setOpenable(Boolean.parseBoolean(parameters[3]));
            dishwasher1.setPickupable(Boolean.parseBoolean(parameters[4]));
            dishwasher1.setOpen(Boolean.parseBoolean(parameters[5]));
            dishwasher1.setPushable(Boolean.parseBoolean(parameters[6]));
            dishwasher1.setPush(Boolean.parseBoolean(parameters[7]));
            kitchen.getObjects().add(dishwasher1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject oven1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //64
            oven1.setAlias(new String[]{});
            oven1.setOpenable(Boolean.parseBoolean(parameters[3]));
            oven1.setPickupable(Boolean.parseBoolean(parameters[4]));
            oven1.setOpen(Boolean.parseBoolean(parameters[5]));
            oven1.setPushable(Boolean.parseBoolean(parameters[6]));
            oven1.setPush(Boolean.parseBoolean(parameters[7]));
            kitchen.getObjects().add(oven1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject dinnerTable1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //65
            dinnerTable1.setAlias(new String[]{"tavolo", "tavolo pranzo"});
            dinnerTable1.setOpenable(Boolean.parseBoolean(parameters[3]));
            dinnerTable1.setPickupable(Boolean.parseBoolean(parameters[4]));
            dinnerTable1.setOpen(Boolean.parseBoolean(parameters[5]));
            dinnerTable1.setPushable(Boolean.parseBoolean(parameters[6]));
            dinnerTable1.setPush(Boolean.parseBoolean(parameters[7]));
            diningRoom.getObjects().add(dinnerTable1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject plate1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //66
            plate1.setAlias(new String[]{});
            plate1.setOpenable(Boolean.parseBoolean(parameters[3]));
            plate1.setPickupable(Boolean.parseBoolean(parameters[4]));
            plate1.setOpen(Boolean.parseBoolean(parameters[5]));
            plate1.setPushable(Boolean.parseBoolean(parameters[6]));
            plate1.setPush(Boolean.parseBoolean(parameters[7]));
            diningRoom.getObjects().add(plate1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject shell = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //67
            shell.setAlias(new String[]{"contenitore", "contenitore di resina"});
            shell.setOpenable(Boolean.parseBoolean(parameters[3]));
            shell.setPickupable(Boolean.parseBoolean(parameters[4]));
            shell.setOpen(Boolean.parseBoolean(parameters[5]));
            shell.setPushable(Boolean.parseBoolean(parameters[6]));
            shell.setPush(Boolean.parseBoolean(parameters[7]));
            diningRoom.getObjects().add(shell);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject bluKey = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //68
            bluKey.setAlias(new String[]{"chiave"});
            bluKey.setOpenable(Boolean.parseBoolean(parameters[3]));
            bluKey.setPickupable(Boolean.parseBoolean(parameters[4]));
            bluKey.setOpen(Boolean.parseBoolean(parameters[5]));
            bluKey.setPushable(Boolean.parseBoolean(parameters[6]));
            bluKey.setPush(Boolean.parseBoolean(parameters[7]));
            diningRoom.getObjects().add(bluKey);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject chair5 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //69
            chair5.setAlias(new String[]{});
            chair5.setOpenable(Boolean.parseBoolean(parameters[3]));
            chair5.setPickupable(Boolean.parseBoolean(parameters[4]));
            chair5.setOpen(Boolean.parseBoolean(parameters[5]));
            chair5.setPushable(Boolean.parseBoolean(parameters[6]));
            chair5.setPush(Boolean.parseBoolean(parameters[7]));
            diningRoom.getObjects().add(chair5);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject sofa2 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //70
            sofa2.setAlias(new String[]{"sofa", "sofà"});
            sofa2.setOpenable(Boolean.parseBoolean(parameters[3]));
            sofa2.setPickupable(Boolean.parseBoolean(parameters[4]));
            sofa2.setOpen(Boolean.parseBoolean(parameters[5]));
            sofa2.setPushable(Boolean.parseBoolean(parameters[6]));
            sofa2.setPush(Boolean.parseBoolean(parameters[7]));
            diningRoom.getObjects().add(sofa2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject television2 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //71
            television2.setAlias(new String[]{"televisore", "tv"});
            television2.setOpenable(Boolean.parseBoolean(parameters[3]));
            television2.setPickupable(Boolean.parseBoolean(parameters[4]));
            television2.setOpen(Boolean.parseBoolean(parameters[5]));
            television2.setPushable(Boolean.parseBoolean(parameters[6]));
            television2.setPush(Boolean.parseBoolean(parameters[7]));
            diningRoom.getObjects().add(television2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer agedMobile = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //72
            agedMobile.setAlias(new String[]{"mobile invecchiato", "mobile", "mobile legno"});
            agedMobile.setOpenable(Boolean.parseBoolean(parameters[3]));
            agedMobile.setPickupable(Boolean.parseBoolean(parameters[4]));
            agedMobile.setOpen(Boolean.parseBoolean(parameters[5]));
            agedMobile.setPushable(Boolean.parseBoolean(parameters[6]));
            agedMobile.setPush(Boolean.parseBoolean(parameters[7]));
            abandonedRoom.getObjects().add(agedMobile);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject drawer9 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //73
            drawer9.setAlias(new String[]{"primo cassetto", "cassetto 1", "primo tiretto", "tiretto 1"});
            drawer9.setOpenable(Boolean.parseBoolean(parameters[3]));
            drawer9.setPickupable(Boolean.parseBoolean(parameters[4]));
            drawer9.setOpen(Boolean.parseBoolean(parameters[5]));
            drawer9.setPushable(Boolean.parseBoolean(parameters[6]));
            drawer9.setPush(Boolean.parseBoolean(parameters[7]));
            drawer9.setContained(agedMobile.getId());
            agedMobile.add(drawer9);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject drawer10 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //74
            drawer10.setAlias(new String[]{"secondo cassetto", "cassetto 2", "secondo tiretto", "tiretto 2"});
            drawer10.setOpenable(Boolean.parseBoolean(parameters[3]));
            drawer10.setPickupable(Boolean.parseBoolean(parameters[4]));
            drawer10.setOpen(Boolean.parseBoolean(parameters[5]));
            drawer10.setPushable(Boolean.parseBoolean(parameters[6]));
            drawer10.setPush(Boolean.parseBoolean(parameters[7]));
            drawer10.setContained(agedMobile.getId());
            agedMobile.add(drawer10);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject drawer11 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //75
            drawer11.setAlias(new String[]{"terzo cassetto", "cassetto 3", "terzo tiretto", "tiretto 3"});
            drawer11.setOpenable(Boolean.parseBoolean(parameters[3]));
            drawer11.setPickupable(Boolean.parseBoolean(parameters[4]));
            drawer11.setOpen(Boolean.parseBoolean(parameters[5]));
            drawer11.setPushable(Boolean.parseBoolean(parameters[6]));
            drawer11.setPush(Boolean.parseBoolean(parameters[7]));
            drawer11.setContained(agedMobile.getId());
            agedMobile.add(drawer11);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject drawer12 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //76
            drawer12.setAlias(new String[]{"quarto cassetto", "cassetto 4", "quarto tiretto", "tiretto 4"});
            drawer12.setOpenable(Boolean.parseBoolean(parameters[3]));
            drawer12.setPickupable(Boolean.parseBoolean(parameters[4]));
            drawer12.setOpen(Boolean.parseBoolean(parameters[5]));
            drawer12.setPushable(Boolean.parseBoolean(parameters[6]));
            drawer12.setPush(Boolean.parseBoolean(parameters[7]));
            drawer12.setContained(agedMobile.getId());
            agedMobile.add(drawer12);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer drawer13 = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //77
            drawer13.setAlias(new String[]{"quinto cassetto", "cassetto 5", "quinto tiretto", "tiretto 5"});
            drawer13.setOpenable(Boolean.parseBoolean(parameters[3]));
            drawer13.setPickupable(Boolean.parseBoolean(parameters[4]));
            drawer13.setOpen(Boolean.parseBoolean(parameters[5]));
            drawer13.setPushable(Boolean.parseBoolean(parameters[6]));
            drawer13.setPush(Boolean.parseBoolean(parameters[7]));
            drawer13.setContained(agedMobile.getId());
            agedMobile.add(drawer13);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject drawer14 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //78
            drawer14.setAlias(new String[]{"sesto cassetto", "cassetto 6", "sesto tiretto", "tiretto 6"});
            drawer14.setOpenable(Boolean.parseBoolean(parameters[3]));
            drawer14.setPickupable(Boolean.parseBoolean(parameters[4]));
            drawer14.setOpen(Boolean.parseBoolean(parameters[5]));
            drawer14.setPushable(Boolean.parseBoolean(parameters[6]));
            drawer14.setPush(Boolean.parseBoolean(parameters[7]));
            drawer14.setContained(agedMobile.getId());
            agedMobile.add(drawer14);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject drawerNote = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //81
            drawerNote.setAlias(new String[]{"foglio", "nota nel cassetto", "foglietto"});
            drawerNote.setOpenable(Boolean.parseBoolean(parameters[3]));
            drawerNote.setPickupable(Boolean.parseBoolean(parameters[4]));
            drawerNote.setOpen(Boolean.parseBoolean(parameters[5]));
            drawerNote.setPushable(Boolean.parseBoolean(parameters[6]));
            drawerNote.setPush(Boolean.parseBoolean(parameters[7]));
            drawerNote.setContained(drawer13.getId());
            drawer13.add(drawerNote);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject woodMobileBroken = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //82
            woodMobileBroken.setAlias(new String[]{"mobile anta vetro", "mobile vetro", "mobile legno", "mobile legno anta vetro rotta"});
            woodMobileBroken.setOpenable(Boolean.parseBoolean(parameters[3]));
            woodMobileBroken.setPickupable(Boolean.parseBoolean(parameters[4]));
            woodMobileBroken.setOpen(Boolean.parseBoolean(parameters[5]));
            woodMobileBroken.setPushable(Boolean.parseBoolean(parameters[6]));
            woodMobileBroken.setPush(Boolean.parseBoolean(parameters[7]));
            abandonedRoom.getObjects().add(woodMobileBroken);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject ceilingLamp2 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //83
            ceilingLamp2.setAlias(new String[]{"lampada"});
            ceilingLamp2.setOpenable(Boolean.parseBoolean(parameters[3]));
            ceilingLamp2.setPickupable(Boolean.parseBoolean(parameters[4]));
            ceilingLamp2.setOpen(Boolean.parseBoolean(parameters[5]));
            ceilingLamp2.setPushable(Boolean.parseBoolean(parameters[6]));
            ceilingLamp2.setPush(Boolean.parseBoolean(parameters[7]));
            abandonedRoom.getObjects().add(ceilingLamp2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject dustySheet = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //84
            dustySheet.setAlias(new String[]{"foglio ricoperto di polvere"});
            dustySheet.setOpenable(Boolean.parseBoolean(parameters[3]));
            dustySheet.setPickupable(Boolean.parseBoolean(parameters[4]));
            dustySheet.setOpen(Boolean.parseBoolean(parameters[5]));
            dustySheet.setPushable(Boolean.parseBoolean(parameters[6]));
            dustySheet.setPush(Boolean.parseBoolean(parameters[7]));
            emptyRoom.getObjects().add(dustySheet);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject burntSheet = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //85
            burntSheet.setAlias(new String[]{"foglio bruciato"});
            burntSheet.setOpenable(Boolean.parseBoolean(parameters[3]));
            burntSheet.setPickupable(Boolean.parseBoolean(parameters[4]));
            burntSheet.setOpen(Boolean.parseBoolean(parameters[5]));
            burntSheet.setPushable(Boolean.parseBoolean(parameters[6]));
            burntSheet.setPush(Boolean.parseBoolean(parameters[7]));
            emptyRoom.getObjects().add(burntSheet);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject corrodedSheet = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //86
            corrodedSheet.setAlias(new String[]{"foglio consumato"});
            corrodedSheet.setOpenable(Boolean.parseBoolean(parameters[3]));
            corrodedSheet.setPickupable(Boolean.parseBoolean(parameters[4]));
            corrodedSheet.setOpen(Boolean.parseBoolean(parameters[5]));
            corrodedSheet.setPushable(Boolean.parseBoolean(parameters[6]));
            corrodedSheet.setPush(Boolean.parseBoolean(parameters[7]));
            emptyRoom.getObjects().add(corrodedSheet);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject reassembledSheet = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //87
            reassembledSheet.setAlias(new String[]{"foglio ricostruito"});
            reassembledSheet.setOpenable(Boolean.parseBoolean(parameters[3]));
            reassembledSheet.setPickupable(Boolean.parseBoolean(parameters[4]));
            reassembledSheet.setOpen(Boolean.parseBoolean(parameters[5]));
            reassembledSheet.setPushable(Boolean.parseBoolean(parameters[6]));
            reassembledSheet.setPush(Boolean.parseBoolean(parameters[7]));
            emptyRoom.getObjects().add(reassembledSheet);

            // Ground floor
            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject bed3 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //88
            bed3.setAlias(new String[]{});
            bed3.setOpenable(Boolean.parseBoolean(parameters[3]));
            bed3.setPickupable(Boolean.parseBoolean(parameters[4]));
            bed3.setOpen(Boolean.parseBoolean(parameters[5]));
            bed3.setPushable(Boolean.parseBoolean(parameters[6]));
            bed3.setPush(Boolean.parseBoolean(parameters[7]));
            bedroom3.getObjects().add(bed3);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject bedsideTable3 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //89
            bedsideTable3.setAlias(new String[]{});
            bedsideTable3.setOpenable(Boolean.parseBoolean(parameters[3]));
            bedsideTable3.setPickupable(Boolean.parseBoolean(parameters[4]));
            bedsideTable3.setOpen(Boolean.parseBoolean(parameters[5]));
            bedsideTable3.setPushable(Boolean.parseBoolean(parameters[6]));
            bedsideTable3.setPush(Boolean.parseBoolean(parameters[7]));
            bedroom3.getObjects().add(bedsideTable3);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject desk5 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //90
            desk5.setAlias(new String[]{"scrittorio", "tavolo", "tavolino"});
            desk5.setOpenable(Boolean.parseBoolean(parameters[3]));
            desk5.setPickupable(Boolean.parseBoolean(parameters[4]));
            desk5.setOpen(Boolean.parseBoolean(parameters[5]));
            desk5.setPushable(Boolean.parseBoolean(parameters[6]));
            desk5.setPush(Boolean.parseBoolean(parameters[7]));
            bedroom3.getObjects().add(desk5);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject television3 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //91
            television3.setAlias(new String[]{"televisore", "tv"});
            television3.setOpenable(Boolean.parseBoolean(parameters[3]));
            television3.setPickupable(Boolean.parseBoolean(parameters[4]));
            television3.setOpen(Boolean.parseBoolean(parameters[5]));
            television3.setPushable(Boolean.parseBoolean(parameters[6]));
            television3.setPush(Boolean.parseBoolean(parameters[7]));
            bedroom3.getObjects().add(television3);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject remoteController = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //92
            remoteController.setAlias(new String[]{});
            remoteController.setOpenable(Boolean.parseBoolean(parameters[3]));
            remoteController.setPickupable(Boolean.parseBoolean(parameters[4]));
            remoteController.setOpen(Boolean.parseBoolean(parameters[5]));
            remoteController.setPushable(Boolean.parseBoolean(parameters[6]));
            remoteController.setPush(Boolean.parseBoolean(parameters[7]));
            bedroom3.getObjects().add(remoteController);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject alarmclock1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //93
            alarmclock1.setAlias(new String[]{"sveglia", "orologio Digitale"});
            alarmclock1.setOpenable(Boolean.parseBoolean(parameters[3]));
            alarmclock1.setPickupable(Boolean.parseBoolean(parameters[4]));
            alarmclock1.setOpen(Boolean.parseBoolean(parameters[5]));
            alarmclock1.setPushable(Boolean.parseBoolean(parameters[6]));
            alarmclock1.setPush(Boolean.parseBoolean(parameters[7]));
            bedroom3.getObjects().add(alarmclock1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject mosaic = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //94
            mosaic.setAlias(new String[]{});
            mosaic.setOpenable(Boolean.parseBoolean(parameters[3]));
            mosaic.setPickupable(Boolean.parseBoolean(parameters[4]));
            mosaic.setOpen(Boolean.parseBoolean(parameters[5]));
            mosaic.setPushable(Boolean.parseBoolean(parameters[6]));
            mosaic.setPush(Boolean.parseBoolean(parameters[7]));
            mosaicRoom.getObjects().add(mosaic);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject plate2 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //95
            plate2.setAlias(new String[]{"prima piastra"});
            plate2.setOpenable(Boolean.parseBoolean(parameters[3]));
            plate2.setPickupable(Boolean.parseBoolean(parameters[4]));
            plate2.setOpen(Boolean.parseBoolean(parameters[5]));
            plate2.setPushable(Boolean.parseBoolean(parameters[6]));
            plate2.setPush(Boolean.parseBoolean(parameters[7]));
            mosaicRoom.getObjects().add(plate2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject plate3 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //96
            plate3.setAlias(new String[]{"seconda piastra"});
            plate3.setOpenable(Boolean.parseBoolean(parameters[3]));
            plate3.setPickupable(Boolean.parseBoolean(parameters[4]));
            plate3.setOpen(Boolean.parseBoolean(parameters[5]));
            plate3.setPushable(Boolean.parseBoolean(parameters[6]));
            plate3.setPush(Boolean.parseBoolean(parameters[7]));
            mosaicRoom.getObjects().add(plate3);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject plate4 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //97
            plate4.setAlias(new String[]{"terza piastra"});
            plate4.setOpenable(Boolean.parseBoolean(parameters[3]));
            plate4.setPickupable(Boolean.parseBoolean(parameters[4]));
            plate4.setOpen(Boolean.parseBoolean(parameters[5]));
            plate4.setPushable(Boolean.parseBoolean(parameters[6]));
            plate4.setPush(Boolean.parseBoolean(parameters[7]));
            mosaicRoom.getObjects().add(plate4);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject plate5 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //98
            plate5.setAlias(new String[]{"quarta piastra"});
            plate5.setOpenable(Boolean.parseBoolean(parameters[3]));
            plate5.setPickupable(Boolean.parseBoolean(parameters[4]));
            plate5.setOpen(Boolean.parseBoolean(parameters[5]));
            plate5.setPushable(Boolean.parseBoolean(parameters[6]));
            plate5.setPush(Boolean.parseBoolean(parameters[7]));
            mosaicRoom.getObjects().add(plate5);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject plate6 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //99
            plate6.setAlias(new String[]{"quinta piastra"});
            plate6.setOpenable(Boolean.parseBoolean(parameters[3]));
            plate6.setPickupable(Boolean.parseBoolean(parameters[4]));
            plate6.setOpen(Boolean.parseBoolean(parameters[5]));
            plate6.setPushable(Boolean.parseBoolean(parameters[6]));
            plate6.setPush(Boolean.parseBoolean(parameters[7]));
            mosaicRoom.getObjects().add(plate6);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject plate7 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //100
            plate7.setAlias(new String[]{"sesta piastra"});
            plate7.setOpenable(Boolean.parseBoolean(parameters[3]));
            plate7.setPickupable(Boolean.parseBoolean(parameters[4]));
            plate7.setOpen(Boolean.parseBoolean(parameters[5]));
            plate7.setPushable(Boolean.parseBoolean(parameters[6]));
            plate7.setPush(Boolean.parseBoolean(parameters[7]));
            mosaicRoom.getObjects().add(plate7);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject hob2 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //101
            hob2.setAlias(new String[]{});
            hob2.setOpenable(Boolean.parseBoolean(parameters[3]));
            hob2.setPickupable(Boolean.parseBoolean(parameters[4]));
            hob2.setOpen(Boolean.parseBoolean(parameters[5]));
            hob2.setPushable(Boolean.parseBoolean(parameters[6]));
            hob2.setPush(Boolean.parseBoolean(parameters[7]));
            kitchen2.getObjects().add(hob2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject lighter = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //102
            lighter.setAlias(new String[]{});
            lighter.setOpenable(Boolean.parseBoolean(parameters[3]));
            lighter.setPickupable(Boolean.parseBoolean(parameters[4]));
            lighter.setOpen(Boolean.parseBoolean(parameters[5]));
            lighter.setPushable(Boolean.parseBoolean(parameters[6]));
            lighter.setPush(Boolean.parseBoolean(parameters[7]));
            kitchen2.getObjects().add(lighter);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject oven2 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //103
            oven2.setAlias(new String[]{});
            oven2.setOpenable(Boolean.parseBoolean(parameters[3]));
            oven2.setPickupable(Boolean.parseBoolean(parameters[4]));
            oven2.setOpen(Boolean.parseBoolean(parameters[5]));
            oven2.setPushable(Boolean.parseBoolean(parameters[6]));
            oven2.setPush(Boolean.parseBoolean(parameters[7]));
            kitchen2.getObjects().add(oven2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject dishwasher2 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //104
            dishwasher2.setAlias(new String[]{});
            dishwasher2.setOpenable(Boolean.parseBoolean(parameters[3]));
            dishwasher2.setPickupable(Boolean.parseBoolean(parameters[4]));
            dishwasher2.setOpen(Boolean.parseBoolean(parameters[5]));
            dishwasher2.setPushable(Boolean.parseBoolean(parameters[6]));
            dishwasher2.setPush(Boolean.parseBoolean(parameters[7]));
            kitchen2.getObjects().add(dishwasher2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject handdishwasher = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //105
            handdishwasher.setAlias(new String[]{});
            handdishwasher.setOpenable(Boolean.parseBoolean(parameters[3]));
            handdishwasher.setPickupable(Boolean.parseBoolean(parameters[4]));
            handdishwasher.setOpen(Boolean.parseBoolean(parameters[5]));
            handdishwasher.setPushable(Boolean.parseBoolean(parameters[6]));
            handdishwasher.setPush(Boolean.parseBoolean(parameters[7]));
            kitchen2.getObjects().add(handdishwasher);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject fridge2 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //106
            fridge2.setAlias(new String[]{"frigo"});
            fridge2.setOpenable(Boolean.parseBoolean(parameters[3]));
            fridge2.setPickupable(Boolean.parseBoolean(parameters[4]));
            fridge2.setOpen(Boolean.parseBoolean(parameters[5]));
            fridge2.setPushable(Boolean.parseBoolean(parameters[6]));
            fridge2.setPush(Boolean.parseBoolean(parameters[7]));
            kitchen2.getObjects().add(fridge2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer mobile3 = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //107
            mobile3.setAlias(new String[]{"mobile legno", "mobile"});
            mobile3.setOpenable(Boolean.parseBoolean(parameters[3]));
            mobile3.setPickupable(Boolean.parseBoolean(parameters[4]));
            mobile3.setOpen(Boolean.parseBoolean(parameters[5]));
            mobile3.setPushable(Boolean.parseBoolean(parameters[6]));
            mobile3.setPush(Boolean.parseBoolean(parameters[7]));
            kitchen2.getObjects().add(mobile3);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject drawer15 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //108
            drawer15.setAlias(new String[]{"primo cassetto", "cassetto 1", "tiretto 1"});
            drawer15.setOpenable(Boolean.parseBoolean(parameters[3]));
            drawer15.setPickupable(Boolean.parseBoolean(parameters[4]));
            drawer15.setOpen(Boolean.parseBoolean(parameters[5]));
            drawer15.setPushable(Boolean.parseBoolean(parameters[6]));
            drawer15.setPush(Boolean.parseBoolean(parameters[7]));
            drawer15.setContained(mobile3.getId());
            mobile3.add(drawer15);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject drawer16 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //109
            drawer16.setAlias(new String[]{"secondo cassetto", "cassetto 2", "tiretto 2"});
            drawer16.setOpenable(Boolean.parseBoolean(parameters[3]));
            drawer16.setPickupable(Boolean.parseBoolean(parameters[4]));
            drawer16.setOpen(Boolean.parseBoolean(parameters[5]));
            drawer16.setPushable(Boolean.parseBoolean(parameters[6]));
            drawer16.setPush(Boolean.parseBoolean(parameters[7]));
            drawer16.setContained(mobile3.getId());
            mobile3.add(drawer16);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject picture3 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //110
            picture3.setAlias(new String[]{});
            picture3.setOpenable(Boolean.parseBoolean(parameters[3]));
            picture3.setPickupable(Boolean.parseBoolean(parameters[4]));
            picture3.setOpen(Boolean.parseBoolean(parameters[5]));
            picture3.setPushable(Boolean.parseBoolean(parameters[6]));
            picture3.setPush(Boolean.parseBoolean(parameters[7]));
            paintingRoom.getObjects().add(picture3);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject picture4 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //111
            picture4.setAlias(new String[]{});
            picture4.setOpenable(Boolean.parseBoolean(parameters[3]));
            picture4.setPickupable(Boolean.parseBoolean(parameters[4]));
            picture4.setOpen(Boolean.parseBoolean(parameters[5]));
            picture4.setPushable(Boolean.parseBoolean(parameters[6]));
            picture4.setPush(Boolean.parseBoolean(parameters[7]));
            paintingRoom.getObjects().add(picture4);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject picture5 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //112
            picture5.setAlias(new String[]{});
            picture5.setOpenable(Boolean.parseBoolean(parameters[3]));
            picture5.setPickupable(Boolean.parseBoolean(parameters[4]));
            picture5.setOpen(Boolean.parseBoolean(parameters[5]));
            picture5.setPushable(Boolean.parseBoolean(parameters[6]));
            picture5.setPush(Boolean.parseBoolean(parameters[7]));
            paintingRoom.getObjects().add(picture5);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject picture6 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //113
            picture6.setAlias(new String[]{});
            picture6.setOpenable(Boolean.parseBoolean(parameters[3]));
            picture6.setPickupable(Boolean.parseBoolean(parameters[4]));
            picture6.setOpen(Boolean.parseBoolean(parameters[5]));
            picture6.setPushable(Boolean.parseBoolean(parameters[6]));
            picture6.setPush(Boolean.parseBoolean(parameters[7]));
            paintingRoom.getObjects().add(picture6);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject picture7 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //114
            picture7.setAlias(new String[]{});
            picture7.setOpenable(Boolean.parseBoolean(parameters[3]));
            picture7.setPickupable(Boolean.parseBoolean(parameters[4]));
            picture7.setOpen(Boolean.parseBoolean(parameters[5]));
            picture7.setPushable(Boolean.parseBoolean(parameters[6]));
            picture7.setPush(Boolean.parseBoolean(parameters[7]));
            paintingRoom.getObjects().add(picture7);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject picture8 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //115
            picture8.setAlias(new String[]{});
            picture8.setOpenable(Boolean.parseBoolean(parameters[3]));
            picture8.setPickupable(Boolean.parseBoolean(parameters[4]));
            picture8.setOpen(Boolean.parseBoolean(parameters[5]));
            picture8.setPushable(Boolean.parseBoolean(parameters[6]));
            picture8.setPush(Boolean.parseBoolean(parameters[7]));
            paintingRoom.getObjects().add(picture8);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject picture9 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //116
            picture9.setAlias(new String[]{});
            picture9.setOpenable(Boolean.parseBoolean(parameters[3]));
            picture9.setPickupable(Boolean.parseBoolean(parameters[4]));
            picture9.setOpen(Boolean.parseBoolean(parameters[5]));
            picture9.setPushable(Boolean.parseBoolean(parameters[6]));
            picture9.setPush(Boolean.parseBoolean(parameters[7]));
            paintingRoom.getObjects().add(picture9);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject picture10 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //117
            picture10.setAlias(new String[]{});
            picture10.setOpenable(Boolean.parseBoolean(parameters[3]));
            picture10.setPickupable(Boolean.parseBoolean(parameters[4]));
            picture10.setOpen(Boolean.parseBoolean(parameters[5]));
            picture10.setPushable(Boolean.parseBoolean(parameters[6]));
            picture10.setPush(Boolean.parseBoolean(parameters[7]));
            paintingRoom.getObjects().add(picture10);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject picture11 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //118
            picture11.setAlias(new String[]{});
            picture11.setOpenable(Boolean.parseBoolean(parameters[3]));
            picture11.setPickupable(Boolean.parseBoolean(parameters[4]));
            picture11.setOpen(Boolean.parseBoolean(parameters[5]));
            picture11.setPushable(Boolean.parseBoolean(parameters[6]));
            picture11.setPush(Boolean.parseBoolean(parameters[7]));
            paintingRoom.getObjects().add(picture11);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject picture12 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //119
            picture12.setAlias(new String[]{});
            picture12.setOpenable(Boolean.parseBoolean(parameters[3]));
            picture12.setPickupable(Boolean.parseBoolean(parameters[4]));
            picture12.setOpen(Boolean.parseBoolean(parameters[5]));
            picture12.setPushable(Boolean.parseBoolean(parameters[6]));
            picture12.setPush(Boolean.parseBoolean(parameters[7]));
            paintingRoom.getObjects().add(picture12);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer rightLibrary = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //120
            rightLibrary.setAlias(new String[]{"libreria destra"});
            rightLibrary.setOpenable(Boolean.parseBoolean(parameters[3]));
            rightLibrary.setPickupable(Boolean.parseBoolean(parameters[4]));
            rightLibrary.setOpen(Boolean.parseBoolean(parameters[5]));
            rightLibrary.setPushable(Boolean.parseBoolean(parameters[6]));
            rightLibrary.setPush(Boolean.parseBoolean(parameters[7]));
            library.getObjects().add(rightLibrary);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer drawer17 = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //121
            drawer17.setAlias(new String[]{"cassetto unico destro", "cassetto destro", "cassetto libreria destra", "cassetto destra"});
            drawer17.setOpenable(Boolean.parseBoolean(parameters[3]));
            drawer17.setPickupable(Boolean.parseBoolean(parameters[4]));
            drawer17.setOpen(Boolean.parseBoolean(parameters[5]));
            drawer17.setPushable(Boolean.parseBoolean(parameters[6]));
            drawer17.setPush(Boolean.parseBoolean(parameters[7]));
            drawer17.setContained(rightLibrary.getId());
            rightLibrary.add(drawer17);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject note2 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //122
            note2.setAlias(new String[]{"primo foglio", "primo pezzo di carta", "prima nota"});
            note2.setOpenable(Boolean.parseBoolean(parameters[3]));
            note2.setPickupable(Boolean.parseBoolean(parameters[4]));
            note2.setOpen(Boolean.parseBoolean(parameters[5]));
            note2.setPushable(Boolean.parseBoolean(parameters[6]));
            note2.setPush(Boolean.parseBoolean(parameters[7]));
            note2.setContained(drawer17.getId());
            drawer17.add(note2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer centralLibrary = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //123
            centralLibrary.setAlias(new String[]{"libreria al centro"});
            centralLibrary.setOpenable(Boolean.parseBoolean(parameters[3]));
            centralLibrary.setPickupable(Boolean.parseBoolean(parameters[4]));
            centralLibrary.setOpen(Boolean.parseBoolean(parameters[5]));
            centralLibrary.setPushable(Boolean.parseBoolean(parameters[6]));
            centralLibrary.setPush(Boolean.parseBoolean(parameters[7]));
            library.getObjects().add(centralLibrary);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer drawer18 = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //124
            drawer18.setAlias(new String[]{"cassetto unico centrale", "cassetto libreria centrale", "cassetto centrale", "cassetto centro"});
            drawer18.setOpenable(Boolean.parseBoolean(parameters[3]));
            drawer18.setPickupable(Boolean.parseBoolean(parameters[4]));
            drawer18.setOpen(Boolean.parseBoolean(parameters[5]));
            drawer18.setPushable(Boolean.parseBoolean(parameters[6]));
            drawer18.setPush(Boolean.parseBoolean(parameters[7]));
            drawer18.setContained(centralLibrary.getId());
            centralLibrary.add(drawer18);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject note3 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //125
            note3.setAlias(new String[]{"secondo foglio", "secondo pezzo di carta", "seconda nota"});
            note3.setOpenable(Boolean.parseBoolean(parameters[3]));
            note3.setPickupable(Boolean.parseBoolean(parameters[4]));
            note3.setOpen(Boolean.parseBoolean(parameters[5]));
            note3.setPushable(Boolean.parseBoolean(parameters[6]));
            note3.setPush(Boolean.parseBoolean(parameters[7]));
            note3.setContained(drawer18.getId());
            drawer18.add(note3);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer leftLibrary = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //126
            leftLibrary.setAlias(new String[]{"libreria sinistra"});
            leftLibrary.setOpenable(Boolean.parseBoolean(parameters[3]));
            leftLibrary.setPickupable(Boolean.parseBoolean(parameters[4]));
            leftLibrary.setOpen(Boolean.parseBoolean(parameters[5]));
            leftLibrary.setPushable(Boolean.parseBoolean(parameters[6]));
            leftLibrary.setPush(Boolean.parseBoolean(parameters[7]));
            library.getObjects().add(leftLibrary);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer drawer19 = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //127
            drawer19.setAlias(new String[]{"cassetto unico sinistro", "cassetto sinistra", "cassetto sinistro"});
            drawer19.setOpenable(Boolean.parseBoolean(parameters[3]));
            drawer19.setPickupable(Boolean.parseBoolean(parameters[4]));
            drawer19.setOpen(Boolean.parseBoolean(parameters[5]));
            drawer19.setPushable(Boolean.parseBoolean(parameters[6]));
            drawer19.setPush(Boolean.parseBoolean(parameters[7]));
            drawer19.setContained(leftLibrary.getId());
            leftLibrary.add(drawer19);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject note4 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //128
            note4.setAlias(new String[]{"terzo foglio", "terzo pezzo di carta", "terza nota"});
            note4.setOpenable(Boolean.parseBoolean(parameters[3]));
            note4.setPickupable(Boolean.parseBoolean(parameters[4]));
            note4.setOpen(Boolean.parseBoolean(parameters[5]));
            note4.setPushable(Boolean.parseBoolean(parameters[6]));
            note4.setPush(Boolean.parseBoolean(parameters[7]));
            note4.setContained(drawer19.getId());
            drawer19.add(note4);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject ruinedSheet = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //129
            ruinedSheet.setAlias(new String[]{});
            ruinedSheet.setOpenable(Boolean.parseBoolean(parameters[3]));
            ruinedSheet.setPickupable(Boolean.parseBoolean(parameters[4]));
            ruinedSheet.setOpen(Boolean.parseBoolean(parameters[5]));
            ruinedSheet.setPushable(Boolean.parseBoolean(parameters[6]));
            ruinedSheet.setPush(Boolean.parseBoolean(parameters[7]));
            library.getObjects().add(ruinedSheet);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject torch = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //130
            torch.setAlias(new String[]{"torcia"});
            torch.setOpenable(Boolean.parseBoolean(parameters[3]));
            torch.setPickupable(Boolean.parseBoolean(parameters[4]));
            torch.setOpen(Boolean.parseBoolean(parameters[5]));
            torch.setPushable(Boolean.parseBoolean(parameters[6]));
            torch.setPush(Boolean.parseBoolean(parameters[7]));
            livingRoom2.getObjects().add(torch);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject projector = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //131
            projector.setAlias(new String[]{});
            projector.setOpenable(Boolean.parseBoolean(parameters[3]));
            projector.setPickupable(Boolean.parseBoolean(parameters[4]));
            projector.setOpen(Boolean.parseBoolean(parameters[5]));
            projector.setPushable(Boolean.parseBoolean(parameters[6]));
            projector.setPush(Boolean.parseBoolean(parameters[7]));
            projectorRoom.getObjects().add(projector);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject wallKeyHolder3 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //132
            wallKeyHolder3.setAlias(new String[]{"portachiavi", "portachiavi muro"});
            wallKeyHolder3.setOpenable(Boolean.parseBoolean(parameters[3]));
            wallKeyHolder3.setPickupable(Boolean.parseBoolean(parameters[4]));
            wallKeyHolder3.setOpen(Boolean.parseBoolean(parameters[5]));
            wallKeyHolder3.setPushable(Boolean.parseBoolean(parameters[6]));
            wallKeyHolder3.setPush(Boolean.parseBoolean(parameters[7]));
            hall3.getObjects().add(wallKeyHolder3);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject shoePair4 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //133
            shoePair4.setAlias(new String[]{"scarpe", "impronte", "orme", "paio scarpe"});
            shoePair4.setOpenable(Boolean.parseBoolean(parameters[3]));
            shoePair4.setPickupable(Boolean.parseBoolean(parameters[4]));
            shoePair4.setOpen(Boolean.parseBoolean(parameters[5]));
            shoePair4.setPushable(Boolean.parseBoolean(parameters[6]));
            shoePair4.setPush(Boolean.parseBoolean(parameters[7]));
            hall3.getObjects().add(shoePair4);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject redSheet = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //134
            redSheet.setAlias(new String[]{"foglio di colore rosso"});
            redSheet.setOpenable(Boolean.parseBoolean(parameters[3]));
            redSheet.setPickupable(Boolean.parseBoolean(parameters[4]));
            redSheet.setOpen(Boolean.parseBoolean(parameters[5]));
            redSheet.setPushable(Boolean.parseBoolean(parameters[6]));
            redSheet.setPush(Boolean.parseBoolean(parameters[7]));
            stringRoom.getObjects().add(redSheet);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject bluSheet = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //135
            bluSheet.setAlias(new String[]{"foglio di colore blu"});
            bluSheet.setOpenable(Boolean.parseBoolean(parameters[3]));
            bluSheet.setPickupable(Boolean.parseBoolean(parameters[4]));
            bluSheet.setOpen(Boolean.parseBoolean(parameters[5]));
            bluSheet.setPushable(Boolean.parseBoolean(parameters[6]));
            bluSheet.setPush(Boolean.parseBoolean(parameters[7]));
            stringRoom.getObjects().add(bluSheet);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject blackSheet = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //136
            blackSheet.setAlias(new String[]{"foglio di colore nero"});
            blackSheet.setOpenable(Boolean.parseBoolean(parameters[3]));
            blackSheet.setPickupable(Boolean.parseBoolean(parameters[4]));
            blackSheet.setOpen(Boolean.parseBoolean(parameters[5]));
            blackSheet.setPushable(Boolean.parseBoolean(parameters[6]));
            blackSheet.setPush(Boolean.parseBoolean(parameters[7]));
            stringRoom.getObjects().add(blackSheet);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject whiteSheet = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //137
            whiteSheet.setAlias(new String[]{"foglio di colore bianco"});
            whiteSheet.setOpenable(Boolean.parseBoolean(parameters[3]));
            whiteSheet.setPickupable(Boolean.parseBoolean(parameters[4]));
            whiteSheet.setOpen(Boolean.parseBoolean(parameters[5]));
            whiteSheet.setPushable(Boolean.parseBoolean(parameters[6]));
            whiteSheet.setPush(Boolean.parseBoolean(parameters[7]));
            stringRoom.getObjects().add(whiteSheet);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject orangeSheet = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //138
            orangeSheet.setAlias(new String[]{"foglio di colore arancione"});
            orangeSheet.setOpenable(Boolean.parseBoolean(parameters[3]));
            orangeSheet.setPickupable(Boolean.parseBoolean(parameters[4]));
            orangeSheet.setOpen(Boolean.parseBoolean(parameters[5]));
            orangeSheet.setPushable(Boolean.parseBoolean(parameters[6]));
            orangeSheet.setPush(Boolean.parseBoolean(parameters[7]));
            stringRoom.getObjects().add(orangeSheet);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject yellowSheet = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //139
            yellowSheet.setAlias(new String[]{"foglio di colore giallo"});
            yellowSheet.setOpenable(Boolean.parseBoolean(parameters[3]));
            yellowSheet.setPickupable(Boolean.parseBoolean(parameters[4]));
            yellowSheet.setOpen(Boolean.parseBoolean(parameters[5]));
            yellowSheet.setPushable(Boolean.parseBoolean(parameters[6]));
            yellowSheet.setPush(Boolean.parseBoolean(parameters[7]));
            stringRoom.getObjects().add(yellowSheet);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject door3 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //140
            door3.setAlias(new String[]{"porta"});
            door3.setOpenable(Boolean.parseBoolean(parameters[3]));
            door3.setPickupable(Boolean.parseBoolean(parameters[4]));
            door3.setOpen(Boolean.parseBoolean(parameters[5]));
            door3.setPushable(Boolean.parseBoolean(parameters[6]));
            door3.setPush(Boolean.parseBoolean(parameters[7]));
            stringRoom.getObjects().add(door3);

            // Basement
            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject desk = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //141
            desk.setAlias(new String[]{"scrittoio", "tavolo", "tavolino"});
            desk.setOpenable(Boolean.parseBoolean(parameters[3]));
            desk.setPickupable(Boolean.parseBoolean(parameters[4]));
            desk.setOpen(Boolean.parseBoolean(parameters[5]));
            desk.setPushable(Boolean.parseBoolean(parameters[6]));
            desk.setPush(Boolean.parseBoolean(parameters[7]));
            bedroom4.getObjects().add(desk);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject lamp = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //142
            lamp.setAlias(new String[]{"lampione", "lanterna"});
            lamp.setOpenable(Boolean.parseBoolean(parameters[3]));
            lamp.setPickupable(Boolean.parseBoolean(parameters[4]));
            lamp.setOpen(Boolean.parseBoolean(parameters[5]));
            lamp.setPushable(Boolean.parseBoolean(parameters[6]));
            lamp.setPush(Boolean.parseBoolean(parameters[7]));
            bedroom4.getObjects().add(lamp);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject sheet = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //143
            sheet.setAlias(new String[]{"nota", "pagina", "pezzo di carta", "foglietto", "documento"});
            sheet.setOpenable(Boolean.parseBoolean(parameters[3]));
            sheet.setPickupable(Boolean.parseBoolean(parameters[4]));
            sheet.setOpen(Boolean.parseBoolean(parameters[5]));
            sheet.setPushable(Boolean.parseBoolean(parameters[6]));
            sheet.setPush(Boolean.parseBoolean(parameters[7]));
            bedroom4.getObjects().add(sheet);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject pen = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //144
            pen.setAlias(new String[]{});
            pen.setOpenable(Boolean.parseBoolean(parameters[3]));
            pen.setPickupable(Boolean.parseBoolean(parameters[4]));
            pen.setOpen(Boolean.parseBoolean(parameters[5]));
            pen.setPushable(Boolean.parseBoolean(parameters[6]));
            pen.setPush(Boolean.parseBoolean(parameters[7]));
            bedroom4.getObjects().add(pen);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject television = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //145
            television.setAlias(new String[]{"televisore", "tv"});
            television.setOpenable(Boolean.parseBoolean(parameters[3]));
            television.setPickupable(Boolean.parseBoolean(parameters[4]));
            television.setOpen(Boolean.parseBoolean(parameters[5]));
            television.setPushable(Boolean.parseBoolean(parameters[6]));
            television.setPush(Boolean.parseBoolean(parameters[7]));
            bedroom4.getObjects().add(television);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject alarmClock = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //146
            alarmClock.setAlias(new String[]{"sveglia"});
            alarmClock.setOpenable(Boolean.parseBoolean(parameters[3]));
            alarmClock.setPickupable(Boolean.parseBoolean(parameters[4]));
            alarmClock.setOpen(Boolean.parseBoolean(parameters[5]));
            alarmClock.setPushable(Boolean.parseBoolean(parameters[6]));
            alarmClock.setPush(Boolean.parseBoolean(parameters[7]));
            bedroom4.getObjects().add(alarmClock);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer packaging1 = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //147
            packaging1.setAlias(new String[]{"cartone 2203", "imballaggio 2203", "pacco 2203", "primo imballaggio"});
            packaging1.setOpenable(Boolean.parseBoolean(parameters[3]));
            packaging1.setPickupable(Boolean.parseBoolean(parameters[4]));
            packaging1.setOpen(Boolean.parseBoolean(parameters[5]));
            packaging1.setPushable(Boolean.parseBoolean(parameters[6]));
            packaging1.setPush(Boolean.parseBoolean(parameters[7]));
            study3.getObjects().add(packaging1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject brokenPc = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //148
            brokenPc.setAlias(new String[]{"computer", "computer spento", "PC", "pc", "portatile", "computer portatile"});
            brokenPc.setOpenable(Boolean.parseBoolean(parameters[3]));
            brokenPc.setPickupable(Boolean.parseBoolean(parameters[4]));
            brokenPc.setOpen(Boolean.parseBoolean(parameters[5]));
            brokenPc.setPushable(Boolean.parseBoolean(parameters[6]));
            brokenPc.setPush(Boolean.parseBoolean(parameters[7]));
            brokenPc.setContained(packaging1.getId());
            packaging1.add(brokenPc);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer packaging2 = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //149
            packaging2.setAlias(new String[]{"cartone 1306", "imballaggio 1306", "pacco 1306", "secondo imballaggio"});
            packaging2.setOpenable(Boolean.parseBoolean(parameters[3]));
            packaging2.setPickupable(Boolean.parseBoolean(parameters[4]));
            packaging2.setOpen(Boolean.parseBoolean(parameters[5]));
            packaging2.setPushable(Boolean.parseBoolean(parameters[6]));
            packaging2.setPush(Boolean.parseBoolean(parameters[7]));
            study3.getObjects().add(packaging2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject notice1 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //150
            notice1.setAlias(new String[]{"avviso", "lettera di sfratto", "lettera"});
            notice1.setOpenable(Boolean.parseBoolean(parameters[3]));
            notice1.setPickupable(Boolean.parseBoolean(parameters[4]));
            notice1.setOpen(Boolean.parseBoolean(parameters[5]));
            notice1.setPushable(Boolean.parseBoolean(parameters[6]));
            notice1.setPush(Boolean.parseBoolean(parameters[7]));
            notice1.setContained(packaging2.getId());
            packaging2.add(notice1);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer packaging3 = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //151
            packaging3.setAlias(new String[]{"cartone 1010", "imballaggio 1010", "pacco 1010", "terzo imballaggio"});
            packaging3.setOpenable(Boolean.parseBoolean(parameters[3]));
            packaging3.setPickupable(Boolean.parseBoolean(parameters[4]));
            packaging3.setOpen(Boolean.parseBoolean(parameters[5]));
            packaging3.setPushable(Boolean.parseBoolean(parameters[6]));
            packaging3.setPush(Boolean.parseBoolean(parameters[7]));
            study3.getObjects().add(packaging3);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject notice2 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //152
            notice2.setAlias(new String[]{"avviso", "lettera di sequestro", "lettera"});
            notice2.setOpenable(Boolean.parseBoolean(parameters[3]));
            notice2.setPickupable(Boolean.parseBoolean(parameters[4]));
            notice2.setOpen(Boolean.parseBoolean(parameters[5]));
            notice2.setPushable(Boolean.parseBoolean(parameters[6]));
            notice2.setPush(Boolean.parseBoolean(parameters[7]));
            notice2.setContained(packaging3.getId());
            packaging3.add(notice2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer packaging4 = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //153
            packaging4.setAlias(new String[]{"cartone 3008", "imballaggio 3008", "pacco 3008", "quarto imballaggio"});
            packaging4.setOpenable(Boolean.parseBoolean(parameters[3]));
            packaging4.setPickupable(Boolean.parseBoolean(parameters[4]));
            packaging4.setOpen(Boolean.parseBoolean(parameters[5]));
            packaging4.setPushable(Boolean.parseBoolean(parameters[6]));
            packaging4.setPush(Boolean.parseBoolean(parameters[7]));
            study3.getObjects().add(packaging4);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject notice3 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //154
            notice3.setAlias(new String[]{"avviso", "avviso di licenziamento", "lettera"});
            notice3.setOpenable(Boolean.parseBoolean(parameters[3]));
            notice3.setPickupable(Boolean.parseBoolean(parameters[4]));
            notice3.setOpen(Boolean.parseBoolean(parameters[5]));
            notice3.setPushable(Boolean.parseBoolean(parameters[6]));
            notice3.setPush(Boolean.parseBoolean(parameters[7]));
            notice3.setContained(packaging4.getId());
            packaging4.add(notice3);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer packaging5 = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //155
            packaging5.setAlias(new String[]{"cartone 1906", "imballaggio 1906", "pacco 1906", "quinto imballaggio"});
            packaging5.setOpenable(Boolean.parseBoolean(parameters[3]));
            packaging5.setPickupable(Boolean.parseBoolean(parameters[4]));
            packaging5.setOpen(Boolean.parseBoolean(parameters[5]));
            packaging5.setPushable(Boolean.parseBoolean(parameters[6]));
            packaging5.setPush(Boolean.parseBoolean(parameters[7]));
            study3.getObjects().add(packaging5);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject burntPhoto = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //156
            burntPhoto.setAlias(new String[]{"foto"});
            burntPhoto.setOpenable(Boolean.parseBoolean(parameters[3]));
            burntPhoto.setPickupable(Boolean.parseBoolean(parameters[4]));
            burntPhoto.setOpen(Boolean.parseBoolean(parameters[5]));
            burntPhoto.setPushable(Boolean.parseBoolean(parameters[6]));
            burntPhoto.setPush(Boolean.parseBoolean(parameters[7]));
            burntPhoto.setContained(packaging5.getId());
            packaging5.add(burntPhoto);
            endlessRoom.getObjects().add(burntPhoto);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject barrel = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //157
            barrel.setAlias(new String[]{"barile", "barile in fiamme"});
            barrel.setOpenable(Boolean.parseBoolean(parameters[3]));
            barrel.setPickupable(Boolean.parseBoolean(parameters[4]));
            barrel.setOpen(Boolean.parseBoolean(parameters[5]));
            barrel.setPushable(Boolean.parseBoolean(parameters[6]));
            barrel.setPush(Boolean.parseBoolean(parameters[7]));
            barrelRoom.getObjects().add(barrel);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject bucket = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //158
            bucket.setAlias(new String[]{"secchio coperto da neve", "secchio innevato", "oggetto", "oggetto coperto da neve"});
            bucket.setOpenable(Boolean.parseBoolean(parameters[3]));
            bucket.setPickupable(Boolean.parseBoolean(parameters[4]));
            bucket.setOpen(Boolean.parseBoolean(parameters[5]));
            bucket.setPushable(Boolean.parseBoolean(parameters[6]));
            bucket.setPush(Boolean.parseBoolean(parameters[7]));
            winterRoom.getObjects().add(bucket);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject clockA = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //159
            clockA.setAlias(new String[]{"orologio 'a'", "primo orologio", "orologio 1"});
            clockA.setOpenable(Boolean.parseBoolean(parameters[3]));
            clockA.setPickupable(Boolean.parseBoolean(parameters[4]));
            clockA.setOpen(Boolean.parseBoolean(parameters[5]));
            clockA.setPushable(Boolean.parseBoolean(parameters[6]));
            clockA.setPush(Boolean.parseBoolean(parameters[7]));
            clockRoom.getObjects().add(clockA);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject clockB = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //160
            clockB.setAlias(new String[]{"orologio 'b'", "secondo orologio", "orologio 2"});
            clockB.setOpenable(Boolean.parseBoolean(parameters[3]));
            clockB.setPickupable(Boolean.parseBoolean(parameters[4]));
            clockB.setOpen(Boolean.parseBoolean(parameters[5]));
            clockB.setPushable(Boolean.parseBoolean(parameters[6]));
            clockB.setPush(Boolean.parseBoolean(parameters[7]));
            clockRoom.getObjects().add(clockB);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject clockC = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //161
            clockC.setAlias(new String[]{"orologio 'c'", "terzo orologio", "orologio 3"});
            clockC.setOpenable(Boolean.parseBoolean(parameters[3]));
            clockC.setPickupable(Boolean.parseBoolean(parameters[4]));
            clockC.setOpen(Boolean.parseBoolean(parameters[5]));
            clockC.setPushable(Boolean.parseBoolean(parameters[6]));
            clockC.setPush(Boolean.parseBoolean(parameters[7]));
            clockRoom.getObjects().add(clockC);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject clockD = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //162
            clockD.setAlias(new String[]{"orologio 'd'", "quarto orologio", "orologio 4"});
            clockD.setOpenable(Boolean.parseBoolean(parameters[3]));
            clockD.setPickupable(Boolean.parseBoolean(parameters[4]));
            clockD.setOpen(Boolean.parseBoolean(parameters[5]));
            clockD.setPushable(Boolean.parseBoolean(parameters[6]));
            clockD.setPush(Boolean.parseBoolean(parameters[7]));
            clockRoom.getObjects().add(clockD);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject clockE = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //163
            clockE.setAlias(new String[]{"orologio 'e'", "quinto orologio", "orologio 5"});
            clockE.setOpenable(Boolean.parseBoolean(parameters[3]));
            clockE.setPickupable(Boolean.parseBoolean(parameters[4]));
            clockE.setOpen(Boolean.parseBoolean(parameters[5]));
            clockE.setPushable(Boolean.parseBoolean(parameters[6]));
            clockE.setPush(Boolean.parseBoolean(parameters[7]));
            clockRoom.getObjects().add(clockE);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject clockF = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //164
            clockF.setAlias(new String[]{"orologio 'f'", "sesto orologio", "orologio 6"});
            clockF.setOpenable(Boolean.parseBoolean(parameters[3]));
            clockF.setPickupable(Boolean.parseBoolean(parameters[4]));
            clockF.setOpen(Boolean.parseBoolean(parameters[5]));
            clockF.setPushable(Boolean.parseBoolean(parameters[6]));
            clockF.setPush(Boolean.parseBoolean(parameters[7]));
            clockRoom.getObjects().add(clockF);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject clockG = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //165
            clockG.setAlias(new String[]{"orologio 'g'", "settimo orologio", "orologio 7"});
            clockG.setOpenable(Boolean.parseBoolean(parameters[3]));
            clockG.setPickupable(Boolean.parseBoolean(parameters[4]));
            clockG.setOpen(Boolean.parseBoolean(parameters[5]));
            clockG.setPushable(Boolean.parseBoolean(parameters[6]));
            clockG.setPush(Boolean.parseBoolean(parameters[7]));
            clockRoom.getObjects().add(clockG);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject clockH = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //166
            clockH.setAlias(new String[]{"orologio 'h'", "ottavo orologio", "orologio 8"});
            clockH.setOpenable(Boolean.parseBoolean(parameters[3]));
            clockH.setPickupable(Boolean.parseBoolean(parameters[4]));
            clockH.setOpen(Boolean.parseBoolean(parameters[5]));
            clockH.setPushable(Boolean.parseBoolean(parameters[6]));
            clockH.setPush(Boolean.parseBoolean(parameters[7]));
            clockRoom.getObjects().add(clockH);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject clockI = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //167
            clockI.setAlias(new String[]{"orologio 'i'", "nono orologio", "orologio 9"});
            clockI.setOpenable(Boolean.parseBoolean(parameters[3]));
            clockI.setPickupable(Boolean.parseBoolean(parameters[4]));
            clockI.setOpen(Boolean.parseBoolean(parameters[5]));
            clockI.setPushable(Boolean.parseBoolean(parameters[6]));
            clockI.setPush(Boolean.parseBoolean(parameters[7]));
            clockRoom.getObjects().add(clockI);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject clockL = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //168
            clockL.setAlias(new String[]{"orologio 'l'", "decimo orologio", "orologio 10"});
            clockL.setOpenable(Boolean.parseBoolean(parameters[3]));
            clockL.setPickupable(Boolean.parseBoolean(parameters[4]));
            clockL.setOpen(Boolean.parseBoolean(parameters[5]));
            clockL.setPushable(Boolean.parseBoolean(parameters[6]));
            clockL.setPush(Boolean.parseBoolean(parameters[7]));
            clockRoom.getObjects().add(clockL);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject clockM = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //169
            clockM.setAlias(new String[]{"orologio 'm'", "undicesimo orologio", "orologio 11"});
            clockM.setOpenable(Boolean.parseBoolean(parameters[3]));
            clockM.setPickupable(Boolean.parseBoolean(parameters[4]));
            clockM.setOpen(Boolean.parseBoolean(parameters[5]));
            clockM.setPushable(Boolean.parseBoolean(parameters[6]));
            clockM.setPush(Boolean.parseBoolean(parameters[7]));
            clockRoom.getObjects().add(clockM);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject hourglass = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //170
            hourglass.setAlias(new String[]{"orologio a sabbia"});
            hourglass.setOpenable(Boolean.parseBoolean(parameters[3]));
            hourglass.setPickupable(Boolean.parseBoolean(parameters[4]));
            hourglass.setOpen(Boolean.parseBoolean(parameters[5]));
            hourglass.setPushable(Boolean.parseBoolean(parameters[6]));
            hourglass.setPush(Boolean.parseBoolean(parameters[7]));
            sandRoom.getObjects().add(hourglass);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer sandCache = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //171
            sandCache.setAlias(new String[]{"cassa impolverata", "cassa insabbiata", "cassa coperta di sabbia"});
            sandCache.setOpenable(Boolean.parseBoolean(parameters[3]));
            sandCache.setPickupable(Boolean.parseBoolean(parameters[4]));
            sandCache.setOpen(Boolean.parseBoolean(parameters[5]));
            sandCache.setPushable(Boolean.parseBoolean(parameters[6]));
            sandCache.setPush(Boolean.parseBoolean(parameters[7]));
            sandRoom.getObjects().add(sandCache);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject securityCacheKey = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //172
            securityCacheKey.setAlias(new String[]{"chiave", "chiave cassa sicurezza", "chiave di sicurezza"});
            securityCacheKey.setOpenable(Boolean.parseBoolean(parameters[3]));
            securityCacheKey.setPickupable(Boolean.parseBoolean(parameters[4]));
            securityCacheKey.setOpen(Boolean.parseBoolean(parameters[5]));
            securityCacheKey.setPushable(Boolean.parseBoolean(parameters[6]));
            securityCacheKey.setPush(Boolean.parseBoolean(parameters[7]));
            securityCacheKey.setContained(sandCache.getId());
            sandCache.add(securityCacheKey);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer dustyCache = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //173
            dustyCache.setAlias(new String[]{"cassa coperta di polvere"});
            dustyCache.setOpenable(Boolean.parseBoolean(parameters[3]));
            dustyCache.setPickupable(Boolean.parseBoolean(parameters[4]));
            dustyCache.setOpen(Boolean.parseBoolean(parameters[5]));
            dustyCache.setPushable(Boolean.parseBoolean(parameters[6]));
            dustyCache.setPush(Boolean.parseBoolean(parameters[7]));
            storage.getObjects().add(dustyCache);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer oldToy = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //174
            oldToy.setAlias(new String[]{"giocattolo"});
            oldToy.setOpenable(Boolean.parseBoolean(parameters[3]));
            oldToy.setPickupable(Boolean.parseBoolean(parameters[4]));
            oldToy.setOpen(Boolean.parseBoolean(parameters[5]));
            oldToy.setPushable(Boolean.parseBoolean(parameters[6]));
            oldToy.setPush(Boolean.parseBoolean(parameters[7]));
            oldToy.setContained(dustyCache.getId());
            dustyCache.add(oldToy);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject batteries = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //175
            batteries.setAlias(new String[]{"pile"});
            batteries.setOpenable(Boolean.parseBoolean(parameters[3]));
            batteries.setPickupable(Boolean.parseBoolean(parameters[4]));
            batteries.setOpen(Boolean.parseBoolean(parameters[5]));
            batteries.setPushable(Boolean.parseBoolean(parameters[6]));
            batteries.setPush(Boolean.parseBoolean(parameters[7]));
            batteries.setContained(oldToy.getId());
            oldToy.add(batteries);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer securityCache = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //176
            securityCache.setAlias(new String[]{"cassa", "cassa sicurezza"});
            securityCache.setOpenable(Boolean.parseBoolean(parameters[3]));
            securityCache.setPickupable(Boolean.parseBoolean(parameters[4]));
            securityCache.setOpen(Boolean.parseBoolean(parameters[5]));
            securityCache.setPushable(Boolean.parseBoolean(parameters[6]));
            securityCache.setPush(Boolean.parseBoolean(parameters[7]));
            storage.getObjects().add(securityCache);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject nightVisionGoggles = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //177
            nightVisionGoggles.setAlias(new String[]{"visore"});
            nightVisionGoggles.setOpenable(Boolean.parseBoolean(parameters[3]));
            nightVisionGoggles.setPickupable(Boolean.parseBoolean(parameters[4]));
            nightVisionGoggles.setOpen(Boolean.parseBoolean(parameters[5]));
            nightVisionGoggles.setPushable(Boolean.parseBoolean(parameters[6]));
            nightVisionGoggles.setPush(Boolean.parseBoolean(parameters[7]));
            nightVisionGoggles.setContained(securityCache.getId());
            securityCache.add(nightVisionGoggles);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject alarmClock2 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //178
            alarmClock2.setAlias(new String[]{"sveglia digitale", "sveglia"});
            alarmClock2.setOpenable(Boolean.parseBoolean(parameters[3]));
            alarmClock2.setPickupable(Boolean.parseBoolean(parameters[4]));
            alarmClock2.setOpen(Boolean.parseBoolean(parameters[5]));
            alarmClock2.setPushable(Boolean.parseBoolean(parameters[6]));
            alarmClock2.setPush(Boolean.parseBoolean(parameters[7]));
            storage.getObjects().add(alarmClock2);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject reverseFridge = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //179
            reverseFridge.setAlias(new String[]{"frigo"});
            reverseFridge.setOpenable(Boolean.parseBoolean(parameters[3]));
            reverseFridge.setPickupable(Boolean.parseBoolean(parameters[4]));
            reverseFridge.setOpen(Boolean.parseBoolean(parameters[5]));
            reverseFridge.setPushable(Boolean.parseBoolean(parameters[6]));
            reverseFridge.setPush(Boolean.parseBoolean(parameters[7]));
            kitchen3.getObjects().add(reverseFridge);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer reverseFurniture = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //180
            reverseFurniture.setAlias(new String[]{"mobile", "mobile al contrario",});
            reverseFurniture.setOpenable(Boolean.parseBoolean(parameters[3]));
            reverseFurniture.setPickupable(Boolean.parseBoolean(parameters[4]));
            reverseFurniture.setOpen(Boolean.parseBoolean(parameters[5]));
            reverseFurniture.setPushable(Boolean.parseBoolean(parameters[6]));
            reverseFurniture.setPush(Boolean.parseBoolean(parameters[7]));
            kitchen3.getObjects().add(reverseFurniture);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer firstDrawer = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //181
            firstDrawer.setAlias(new String[]{"cassetto 1"});
            firstDrawer.setOpenable(Boolean.parseBoolean(parameters[3]));
            firstDrawer.setPickupable(Boolean.parseBoolean(parameters[4]));
            firstDrawer.setOpen(Boolean.parseBoolean(parameters[5]));
            firstDrawer.setPushable(Boolean.parseBoolean(parameters[6]));
            firstDrawer.setPush(Boolean.parseBoolean(parameters[7]));
            firstDrawer.setContained(reverseFurniture.getId());
            reverseFurniture.add(firstDrawer);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject lightNote = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //182
            lightNote.setAlias(new String[]{"foglio", "foglietto"});
            lightNote.setOpenable(Boolean.parseBoolean(parameters[3]));
            lightNote.setPickupable(Boolean.parseBoolean(parameters[4]));
            lightNote.setOpen(Boolean.parseBoolean(parameters[5]));
            lightNote.setPushable(Boolean.parseBoolean(parameters[6]));
            lightNote.setPush(Boolean.parseBoolean(parameters[7]));
            lightNote.setContained(firstDrawer.getId());
            firstDrawer.add(lightNote);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer secondDrawer = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //183
            secondDrawer.setAlias(new String[]{"cassetto 2"});
            secondDrawer.setOpenable(Boolean.parseBoolean(parameters[3]));
            secondDrawer.setPickupable(Boolean.parseBoolean(parameters[4]));
            secondDrawer.setOpen(Boolean.parseBoolean(parameters[5]));
            secondDrawer.setPushable(Boolean.parseBoolean(parameters[6]));
            secondDrawer.setPush(Boolean.parseBoolean(parameters[7]));
            secondDrawer.setContained(reverseFurniture.getId());
            reverseFurniture.add(secondDrawer);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject screwdriver = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //184
            screwdriver.setAlias(new String[]{"cacciavite a croce"});
            screwdriver.setOpenable(Boolean.parseBoolean(parameters[3]));
            screwdriver.setPickupable(Boolean.parseBoolean(parameters[4]));
            screwdriver.setOpen(Boolean.parseBoolean(parameters[5]));
            screwdriver.setPushable(Boolean.parseBoolean(parameters[6]));
            screwdriver.setPush(Boolean.parseBoolean(parameters[7]));
            kitchen3.getObjects().add(screwdriver);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObjectContainer ceilingLamp = new AdvObjectContainer(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //185
            ceilingLamp.setAlias(new String[]{"lampada", "lumiera"});
            ceilingLamp.setOpenable(Boolean.parseBoolean(parameters[3]));
            ceilingLamp.setPickupable(Boolean.parseBoolean(parameters[4]));
            ceilingLamp.setOpen(Boolean.parseBoolean(parameters[5]));
            ceilingLamp.setPushable(Boolean.parseBoolean(parameters[6]));
            ceilingLamp.setPush(Boolean.parseBoolean(parameters[7]));
            kitchen3.getObjects().add(ceilingLamp);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject bulb = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //186
            bulb.setAlias(new String[]{});
            bulb.setOpenable(Boolean.parseBoolean(parameters[3]));
            bulb.setPickupable(Boolean.parseBoolean(parameters[4]));
            bulb.setOpen(Boolean.parseBoolean(parameters[5]));
            bulb.setPushable(Boolean.parseBoolean(parameters[6]));
            bulb.setPush(Boolean.parseBoolean(parameters[7]));
            bulb.setContained(ceilingLamp.getId());
            ceilingLamp.add(bulb);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject insertdevice = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //187
            insertdevice.setAlias(new String[]{"dispositivo", "congegno", "macchinario", "manichino", "manichino meccanismo"});
            insertdevice.setOpenable(Boolean.parseBoolean(parameters[3]));
            insertdevice.setPickupable(Boolean.parseBoolean(parameters[4]));
            insertdevice.setOpen(Boolean.parseBoolean(parameters[5]));
            insertdevice.setPushable(Boolean.parseBoolean(parameters[6]));
            insertdevice.setPush(Boolean.parseBoolean(parameters[7]));
            mannequinRoom.getObjects().add(insertdevice);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject radio = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //188
            radio.setAlias(new String[]{});
            radio.setOpenable(Boolean.parseBoolean(parameters[3]));
            radio.setPickupable(Boolean.parseBoolean(parameters[4]));
            radio.setOpen(Boolean.parseBoolean(parameters[5]));
            radio.setPushable(Boolean.parseBoolean(parameters[6]));
            radio.setPush(Boolean.parseBoolean(parameters[7]));
            endlessRoom.getObjects().add(radio);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject telephone = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //189
            telephone.setAlias(new String[]{"telefono fisso"});
            telephone.setOpenable(Boolean.parseBoolean(parameters[3]));
            telephone.setPickupable(Boolean.parseBoolean(parameters[4]));
            telephone.setOpen(Boolean.parseBoolean(parameters[5]));
            telephone.setPushable(Boolean.parseBoolean(parameters[6]));
            telephone.setPush(Boolean.parseBoolean(parameters[7]));
            endlessRoom.getObjects().add(telephone);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject device = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //190
            device.setAlias(new String[]{"dispositivo", "congegno", "macchinario"});
            device.setOpenable(Boolean.parseBoolean(parameters[3]));
            device.setPickupable(Boolean.parseBoolean(parameters[4]));
            device.setOpen(Boolean.parseBoolean(parameters[5]));
            device.setPushable(Boolean.parseBoolean(parameters[6]));
            device.setPush(Boolean.parseBoolean(parameters[7]));
            mirrorRoom.getObjects().add(device);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject door5 = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //191
            door5.setAlias(new String[]{"porta"});
            door5.setOpenable(Boolean.parseBoolean(parameters[3]));
            door5.setPickupable(Boolean.parseBoolean(parameters[4]));
            door5.setOpen(Boolean.parseBoolean(parameters[5]));
            door5.setPushable(Boolean.parseBoolean(parameters[6]));
            door5.setPush(Boolean.parseBoolean(parameters[7]));
            mirrorRoom.getObjects().add(door5);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject telescope = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //192
            telescope.setAlias(new String[]{});
            telescope.setOpenable(Boolean.parseBoolean(parameters[3]));
            telescope.setPickupable(Boolean.parseBoolean(parameters[4]));
            telescope.setOpen(Boolean.parseBoolean(parameters[5]));
            telescope.setPushable(Boolean.parseBoolean(parameters[6]));
            telescope.setPush(Boolean.parseBoolean(parameters[7]));
            roof.getObjects().add(telescope);

            lineObj = brObj.readLine();
            parameters = lineObj.split("#");
            AdvObject entity = new AdvObject(Integer.parseInt(parameters[0]), parameters[1], parameters[2]); //193
            entity.setAlias(new String[]{"creatura", "essere", "cosa", "persona"});
            entity.setOpenable(Boolean.parseBoolean(parameters[3]));
            entity.setPickupable(Boolean.parseBoolean(parameters[4]));
            entity.setOpen(Boolean.parseBoolean(parameters[5]));
            entity.setPushable(Boolean.parseBoolean(parameters[6]));
            entity.setPush(Boolean.parseBoolean(parameters[7]));
            theEnd.getObjects().add(entity);

            // Set starting room
            setCurrentRoom(bedroom);
        } catch (IOException e) {
            System.out.println("ERRORE CARICAMENTO STANZE");
            System.exit(0);
        }
    }

    /**
     * Questo metodo astratto, che offre un'imlpementazione tramite Overriding,
     * si occupa della gestione della mossa effettuata dal giocatore.
     *
     * @param p L'istanza di ParserOutput.java che utilizziamo per la
     * comprensione del comando inserito
     * @param frame L'istanza di Frame.java alla quale andiamo ad apportare le
     * necessarie modifiche
     */
    @Override
    public void nextMove(ParserOutput p, Frame frame) {
        Scanner scanner = new Scanner(System.in);

        if (p.getCommand() == null) {
            frame.jtaDisplaySetText("Non credo di poterlo fare. ");
        } else {
            boolean noRoom = false;
            boolean move = false;
            boolean blocked = false;
            boolean frontDoor = false;
            if (p.getCommand().getType() == CommandType.NORTH) {
                if (getCurrentRoom().getNorth() != null) {
                    if (getCurrentRoom().getNorth().isLocked() == false) {
                        setCurrentRoom(getCurrentRoom().getNorth());
                        move = true;
                    } else {
                        blocked = true;
                    }
                } else {
                    noRoom = true;
                }
            } else if (p.getCommand().getType() == CommandType.SOUTH) {
                if (getCurrentRoom().getId() == 22) {
                    frontDoor = true;
                } else {
                    if (getCurrentRoom().getSouth() != null) {
                        if (getCurrentRoom().getSouth().isLocked() == false) {
                            setCurrentRoom(getCurrentRoom().getSouth());
                            move = true;
                        } else {
                            blocked = true;
                        }
                    } else {
                        noRoom = true;
                    }
                }
            } else if (p.getCommand().getType() == CommandType.EAST) {
                if (getCurrentRoom().getEast() != null) {
                    if (getCurrentRoom().getEast().isLocked() == false) {
                        setCurrentRoom(getCurrentRoom().getEast());
                        move = true;
                    } else {
                        blocked = true;
                    }

                    if (getCurrentRoom().getId() == 34 && getCurrentRoom().getEast().getId() == 34) {
                        frame.jtaDisplaySetText("Sono uscito da questa stanza dalla porta e ci sono ritornato...c'è qualcosa che non va. ");
                        move = false;
                    }

                } else {
                    noRoom = true;
                }
            } else if (p.getCommand().getType() == CommandType.WEST) {
                if (getCurrentRoom().getId() == 3 || getCurrentRoom().getId() == 8) {
                    frontDoor = true;
                } else {
                    if (getCurrentRoom().getWest() != null) {
                        if (getCurrentRoom().getWest().isLocked() == false) {
                            setCurrentRoom(getCurrentRoom().getWest());
                            move = true;
                        } else {
                            blocked = true;
                        }
                    } else {
                        noRoom = true;
                    }
                }
            } else if (p.getCommand().getType() == CommandType.LOOK_AT) {
                if (p.getObject() != null) {
                    if (p.getObject().isOpenable() == true && p.getObject().isOpen() == false && (p.getObject().getName().contains("cassetto") || p.getObject().getName().contains("compartimento"))) {
                        frame.jtaDisplaySetText(p.getObject().getName() + " è chiuso");
                    } else {
                        frame.jtaDisplaySetText(p.getObject().getDescription());
                    }
                } else if (p.getInvObject1() != null) {
                    frame.jtaDisplaySetText(p.getInvObject1().getDescription());
                } else if (getCurrentRoom().getLook() != null) {
                    frame.jtaDisplaySetText(getCurrentRoom().getLook());
                } else {
                    frame.jtaDisplaySetText("Non c'è niente di interessante qui.");
                }
            } else if (p.getCommand().getType() == CommandType.PICK_UP) {
                int id = 0;
                int control = 0;
                boolean flag = false;
                if (p.getObject() != null) {
                    if (p.getObject().isPickupable() && p.getObject().getContained() == 0) {
                        if (p.getObject().getId() == 158) {
                            getCurrentRoom().setPathView("/img/View/winter_room_bucketless.png");
                            frame.jlViewSetIcon(getCurrentRoom().getPathView());
                        }
                        getInventory().add(p.getObject());
                        getCurrentRoom().getObjects().remove(p.getObject());
                        frame.jtaDisplaySetText("Hai raccolto: " + p.getObject().getName() + "\n" + p.getObject().getDescription());
                        frame.jtaInventoryAppendText("- " + p.getObject().getName() + "\n");

                    } else if (p.getObject().isPickupable() && p.getObject().getContained() != 0) {
                        Iterator<AdvObject> objInv = getInventory().iterator();
                        if (objInv.hasNext()) {
                            while (objInv.hasNext() && control == 0) {
                                AdvObject nextObjInv = objInv.next();
                                if (nextObjInv.getId() == p.getObject().getId()) {
                                    frame.jtaDisplaySetText("Hai già raccolto: " + p.getObject().getName());
                                    flag = false;
                                    control++;
                                } else {
                                    flag = true;
                                }
                            }
                        } else {

                            Iterator<AdvObject> objIt = getCurrentRoom().getObjects().iterator();
                            while (objIt.hasNext()) {
                                AdvObject nextObj = objIt.next();

                                if (nextObj instanceof AdvObjectContainer && nextObj.getId() == p.getObject().getContained() && nextObj.isOpen() == true) {
                                    AdvObjectContainer c = (AdvObjectContainer) nextObj;

                                    getInventory().add(p.getObject());
                                    frame.jtaDisplaySetText("Hai raccolto: " + p.getObject().getName() + "\n" + p.getObject().getDescription());
                                    frame.jtaInventoryAppendText("- " + p.getObject().getName() + "\n");

                                    if (!c.getList().isEmpty()) {
                                        Iterator<AdvObject> objContained = c.getList().iterator();

                                        while (objContained.hasNext()) {
                                            AdvObject nextObjContained = objContained.next();

                                            if (nextObjContained.getId() == p.getObject().getId()) {
                                                id = nextObjContained.getId();
                                            }
                                        }

                                        for (int i = 0; i < c.getList().size(); i++) {
                                            if (c.getList().get(i).getId() == id) {
                                                c.getList().remove(i);
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        if (flag == true) {
                            getInventory().add(p.getObject());
                            frame.jtaDisplaySetText("Hai raccolto: " + p.getObject().getName() + "\n" + p.getObject().getDescription());
                            frame.jtaInventoryAppendText("- " + p.getObject().getName() + "\n");

                            Iterator<AdvObject> objIt = getCurrentRoom().getObjects().iterator();
                            while (objIt.hasNext()) {
                                AdvObject nextObj = objIt.next();

                                if (nextObj instanceof AdvObjectContainer && nextObj.getId() == p.getObject().getContained()) {
                                    AdvObjectContainer c = (AdvObjectContainer) nextObj;

                                    if (!c.getList().isEmpty()) {
                                        Iterator<AdvObject> objContained = c.getList().iterator();

                                        while (objContained.hasNext()) {
                                            AdvObject nextObjContained = objContained.next();

                                            if (nextObjContained.getId() == p.getObject().getId()) {
                                                id = nextObjContained.getId();
                                            }
                                        }

                                        for (int i = 0; i < c.getList().size(); i++) {
                                            if (c.getList().get(i).getId() == id) {
                                                c.getList().remove(i);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        frame.jtaDisplaySetText("Non puoi raccogliere questo oggetto.");
                    }
                } else if (p.getInvObject1() != null) {
                    Iterator<AdvObject> objInv = getInventory().iterator();
                    if (objInv.hasNext()) {
                        while (objInv.hasNext() && control == 0) {
                            AdvObject nextObjInv = objInv.next();

                            if (nextObjInv.getId() == p.getInvObject1().getId()) {
                                frame.jtaDisplaySetText("Hai già raccolto: " + p.getInvObject1().getName());
                                flag = false;
                                control++;
                            } else {
                                flag = true;
                            }
                        }
                    } else {
                        getInventory().add(p.getInvObject1());
                        frame.jtaDisplaySetText("Hai raccolto: " + p.getInvObject1().getName() + "\n" + p.getInvObject1().getDescription());
                        frame.jtaInventoryAppendText("- " + p.getInvObject1().getName() + "\n");
                    }

                    if (flag == true) {
                        getInventory().add(p.getInvObject1());
                        frame.jtaDisplaySetText("Hai raccolto: " + p.getInvObject1().getName() + "\n" + p.getInvObject1().getDescription());
                        frame.jtaInventoryAppendText("- " + p.getInvObject1().getName() + "\n");
                    }
                } else {
                    frame.jtaDisplaySetText("Questo oggetto non è presente in questa stanza.");
                }
            } else if (p.getCommand().getType() == CommandType.OPEN) {
                if (p.getObject() == null && p.getInvObject1() == null) {
                    frame.jtaDisplaySetText("Non c'è niente da aprire qui.");

                } else if (p.getObject() != null) {
                    if (p.getObject().isOpenable() && p.getObject().isOpen() == false) {
                        if (p.getObject() instanceof AdvObjectContainer) {
                            p.getObject().setOpen(true);
                            frame.jtaDisplaySetText("Hai aperto: " + p.getObject().getName());
                            AdvObjectContainer c = (AdvObjectContainer) p.getObject();
                            if (!c.getList().isEmpty()) {
                                frame.jtaDisplaySetText(c.getName() + " contiene: ");
                                Iterator<AdvObject> it = c.getList().iterator();
                                String[] contents = new String[9];
                                int i = 0;
                                while (it.hasNext()) {
                                    AdvObject next = it.next();
                                    getCurrentRoom().getObjects().add(next);
                                    contents[i] = " -" + next.getName();
                                    i++;
                                }
                                for (int j = 0; j < i; j++) {
                                    if (j % 3 != 0 || (j == 0)) {
                                        frame.jtaDisplayAppendText(contents[j]);
                                    } else {
                                        frame.jtaDisplayAppendText("\n" + contents[j]);
                                    }
                                }
                            }
                        } else {
                            frame.jtaDisplaySetText("Hai aperto: " + p.getObject().getName());
                            p.getObject().setOpen(true);
                        }
                    } else if (p.getObject().isOpenable() && p.getObject().isOpen() == true) {
                        frame.jtaDisplaySetText("L'oggetto " + p.getObject().getName() + " è già aperto. ");
                    } else if (p.getObject().isOpenable() == false) {
                        if (p.getObject().getId() != 49 && p.getObject().getId() != 140) {
                            frame.jtaDisplaySetText("Non puoi aprire l'oggetto " + p.getObject().getName() + ". ");
                        }
                    }

                    if (p.getObject().getId() == 49) {
                        if (p.getObject().isOpen() == false) {
                            String s;
                            s = (String) JOptionPane.showInputDialog(frame, "Inserire il codice della cassaforte:\n", "PIN Cassaforte", JOptionPane.PLAIN_MESSAGE, null, null, "");

                            if (s != null) {
                                if (s.equalsIgnoreCase("4729")) {
                                    p.getObject().setOpen(true);
                                    frame.jtaDisplaySetText("Hai aperto: " + p.getObject().getName());
                                    AdvObjectContainer c = (AdvObjectContainer) p.getObject();
                                    if (!c.getList().isEmpty()) {
                                        frame.jtaDisplayAppendText("\n" + c.getName() + " contiene: ");
                                        Iterator<AdvObject> it = c.getList().iterator();
                                        String[] contents = new String[9];
                                        int i = 0;
                                        while (it.hasNext()) {
                                            AdvObject next = it.next();
                                            getCurrentRoom().getObjects().add(next);
                                            contents[i] = " -" + next.getName();
                                            i++;
                                        }
                                        for (int j = 0; j < i; j++) {
                                            if (j % 3 != 0 || (j == 0)) {
                                                frame.jtaDisplayAppendText(contents[j]);
                                            } else {
                                                frame.jtaDisplayAppendText("\n" + contents[j]);
                                            }
                                        }
                                    }
                                } else {
                                    frame.jtaDisplaySetText("Codice sbagliato");
                                }
                            }
                        }

                    } else if (p.getObject().getId() == 140) {
                        if (p.getObject().isOpen() == false) {
                            String s1;
                            s1 = (String) JOptionPane.showInputDialog(frame, "Inserire la frase corretta per aprire la porta:\n", "Lucchetto con frase", JOptionPane.PLAIN_MESSAGE, null, null, "");

                            if (s1 != null) {
                                if (s1.equalsIgnoreCase("Sono sveglio da anni trattenendo il respiro aspettando che qualcosa cambi") || s1.equalsIgnoreCase("Sono sveglio da anni, trattenendo il respiro, aspettando che qualcosa cambi")) {
                                    getCurrentRoom().setPathView("/img/View/string_room_unlocked.png");
                                    frame.jlViewSetIcon(getCurrentRoom().getPathView());
                                    p.getObject().setOpen(true);
                                    frame.jtaDisplaySetText("Hai aperto: " + p.getObject().getName());
                                    Iterator<Room> it = getRooms().iterator();
                                    while (it.hasNext()) {
                                        Room next = it.next();
                                        if (next.getId() == 24) {
                                            next.setLocked(false);
                                        }
                                    }
                                } else {
                                    p.getObject().setOpen(false);
                                    frame.jtaDisplaySetText("Frase errata");
                                }
                            }
                        }

                    } else if (p.getObject().getId() == 37) {
                        if (p.getObject().isOpen() == false) {
                            frame.jtaDisplaySetText("La porta è chiusa, non riesco ad aprirla... servirà una chiave");
                        }
                    } else if (p.getObject().getId() == 38) {
                        if (p.getObject().getLock() == 3) {
                            p.getObject().setOpen(true);
                            frame.jtaDisplaySetText("La porta si è aperta.");
                            Iterator<Room> it = getRooms().iterator();
                            while (it.hasNext()) {
                                Room next = it.next();
                                if (next.getId() == 15) {
                                    next.setLocked(false);
                                } else if (next.getId() == 6) {
                                    next.setPathView("/img/View/stairs_1_unlocked.png");
                                    frame.jlViewSetIcon(next.getPathView());
                                }
                            }
                        } else if (p.getObject().isOpen() == false) {
                            frame.jtaDisplaySetText("La porta è chiusa; ci sono 3 lucchetti sulla serratura");
                        }
                    } else if (p.getObject().getId() == 192) {
                        if (p.getObject().isOpen() == false) {
                            frame.jtaDisplaySetText("La porta è chiusa, non c'è neanche una serratura... ");
                        }
                    }

                    if (p.getObject().getId() == 73 || p.getObject().getId() == 74 || p.getObject().getId() == 75 || p.getObject().getId() == 76 || p.getObject().getId() == 77 || p.getObject().getId() == 78) {
                        boolean temp = false;
                        int x = 0;
                        p.getObject().setOpen(true);
                        frame.jtaDisplaySetText("Hai aperto: " + p.getObject().getName());

                        if (p.getObject() instanceof AdvObjectContainer) {
                            AdvObjectContainer c = (AdvObjectContainer) p.getObject();
                            if (!c.getList().isEmpty()) {
                                frame.jtaDisplaySetText(c.getName() + " contiene: ");
                                Iterator<AdvObject> it = c.getList().iterator();
                                String[] contents = new String[9];
                                int i = 0;
                                while (it.hasNext()) {
                                    AdvObject next = it.next();
                                    getCurrentRoom().getObjects().add(next);
                                    contents[i] = " -" + next.getName();
                                    i++;
                                }
                                for (int j = 0; j < i; j++) {
                                    if (j % 3 != 0 || (j == 0)) {
                                        frame.jtaDisplayAppendText(contents[j]);
                                    } else {
                                        frame.jtaDisplayAppendText("\n" + contents[j]);
                                    }
                                }
                                frame.jtaDisplayAppendText("\n");
                            }
                        }
                    } else if (p.getObject().getId() == 121) {
                        String s;
                        s = (String) JOptionPane.showInputDialog(frame, "Inserisci codice lucchetto:\n", "Lucchetto", JOptionPane.PLAIN_MESSAGE, null, null, "");

                        if (s != null) {
                            if (s.equalsIgnoreCase("200")) {
                                p.getObject().setOpen(true);
                                frame.jtaDisplaySetText("Hai aperto: " + p.getObject().getName());
                                AdvObjectContainer c = (AdvObjectContainer) p.getObject();
                                if (!c.getList().isEmpty()) {
                                    frame.jtaDisplaySetText(c.getName() + " contiene: ");
                                    Iterator<AdvObject> it = c.getList().iterator();
                                    String[] contents = new String[9];
                                    int i = 0;
                                    while (it.hasNext()) {
                                        AdvObject next = it.next();
                                        getCurrentRoom().getObjects().add(next);
                                        contents[i] = " -" + next.getName();
                                        i++;
                                    }
                                    for (int j = 0; j < i; j++) {
                                        if (j % 3 != 0 || (j == 0)) {
                                            frame.jtaDisplayAppendText(contents[j]);
                                        } else {
                                            frame.jtaDisplayAppendText("\n" + contents[j]);
                                        }
                                    }
                                }
                            }
                        }
                    } else if (p.getObject().getId() == 124) {
                        String s;
                        s = (String) JOptionPane.showInputDialog(frame, "Inserisci codice lucchetto:\n", "Lucchetto", JOptionPane.PLAIN_MESSAGE, null, null, "");

                        if (s != null) {
                            if (s.equalsIgnoreCase("530")) {
                                p.getObject().setOpen(true);
                                frame.jtaDisplaySetText("Hai aperto: " + p.getObject().getName());
                                AdvObjectContainer c = (AdvObjectContainer) p.getObject();
                                if (!c.getList().isEmpty()) {
                                    frame.jtaDisplaySetText(c.getName() + " contiene: ");
                                    Iterator<AdvObject> it = c.getList().iterator();
                                    String[] contents = new String[9];
                                    int i = 0;
                                    while (it.hasNext()) {
                                        AdvObject next = it.next();
                                        getCurrentRoom().getObjects().add(next);
                                        contents[i] = " -" + next.getName();
                                        i++;
                                    }
                                    for (int j = 0; j < i; j++) {
                                        if (j % 3 != 0 || (j == 0)) {
                                            frame.jtaDisplayAppendText(contents[j]);
                                        } else {
                                            frame.jtaDisplayAppendText("\n" + contents[j]);
                                        }
                                    }
                                }
                            }
                        }
                    } else if (p.getObject().getId() == 127) {
                        String s;
                        s = (String) JOptionPane.showInputDialog(frame, "Inserisci codice lucchetto:\n", "Lucchetto", JOptionPane.PLAIN_MESSAGE, null, null, "");

                        if (s != null) {
                            if (s.equalsIgnoreCase("4910")) {
                                p.getObject().setOpen(true);
                                frame.jtaDisplaySetText("Hai aperto: " + p.getObject().getName());
                                AdvObjectContainer c = (AdvObjectContainer) p.getObject();
                                if (!c.getList().isEmpty()) {
                                    frame.jtaDisplaySetText(c.getName() + " contiene: ");
                                    Iterator<AdvObject> it = c.getList().iterator();
                                    String[] contents = new String[9];
                                    int i = 0;
                                    while (it.hasNext()) {
                                        AdvObject next = it.next();
                                        getCurrentRoom().getObjects().add(next);
                                        contents[i] = " -" + next.getName();
                                        i++;
                                    }
                                    for (int j = 0; j < i; j++) {
                                        if (j % 3 != 0 || (j == 0)) {
                                            frame.jtaDisplayAppendText(contents[j]);
                                        } else {
                                            frame.jtaDisplayAppendText("\n" + contents[j]);
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (p.getInvObject1() != null) {
                        if (p.getInvObject1().getId() == 172 && p.getObject().getId() == 176) {
                            getInventory().remove(p.getInvObject1());
                            p.getObject().setOpenable(true);
                            p.getObject().setOpen(true);
                            frame.jtaDisplaySetText("Hai aperto: " + p.getObject().getName());
                            AdvObjectContainer c = (AdvObjectContainer) p.getObject();
                            if (!c.getList().isEmpty()) {
                                frame.jtaDisplaySetText(c.getName() + " contiene: ");
                                Iterator<AdvObject> it = c.getList().iterator();
                                String[] contents = new String[9];
                                int i = 0;
                                while (it.hasNext()) {
                                    AdvObject next = it.next();
                                    getCurrentRoom().getObjects().add(next);
                                    contents[i] = " -" + next.getName();
                                    i++;
                                }
                                for (int j = 0; j < i; j++) {
                                    if (j % 3 != 0 || (j == 0)) {
                                        frame.jtaDisplayAppendText(contents[j]);
                                    } else {
                                        frame.jtaDisplayAppendText("\n" + contents[j]);
                                    }
                                }
                            }
                        }

                        frame.jtaInventorySetText("\t\tInventario");
                        frame.jtaInventoryAppendText("\n----------------------");
                        Iterator<AdvObject> inventoryIt = getInventory().iterator();
                        while (inventoryIt.hasNext()) {
                            AdvObject nextObjInv = inventoryIt.next();
                            frame.jtaInventoryAppendText("- " + nextObjInv.getName() + "\n");
                        }
                    }

                } else if (p.getInvObject1() != null) {
                    if (p.getInvObject1().isOpenable() && p.getInvObject1().isOpen() == false) {
                        if (p.getInvObject1() instanceof AdvObjectContainer) {
                            p.getInvObject1().setOpen(true);
                            AdvObjectContainer c = (AdvObjectContainer) p.getInvObject1();
                            if (!c.getList().isEmpty()) {
                                frame.jtaDisplaySetText(c.getName() + " contiene:");
                                Iterator<AdvObject> it = c.getList().iterator();
                                String[] contents = new String[9];
                                int i = 0;
                                while (it.hasNext()) {
                                    AdvObject next = it.next();
                                    contents[i] = " -" + next.getName();
                                    i++;
                                }
                                for (int j = 0; j < i; j++) {
                                    if (j % 3 != 0 || (j == 0)) {
                                        frame.jtaDisplayAppendText(contents[j]);
                                    } else {
                                        frame.jtaDisplayAppendText("\n" + contents[j]);
                                    }
                                }
                            }
                        } else {
                            p.getInvObject1().setOpen(true);
                        }
                        frame.jtaDisplaySetText("Hai aperto nel tuo inventario: " + p.getInvObject1().getName());
                    } else if (p.getInvObject1().isOpenable() && p.getInvObject1().isOpen() == true) {
                        frame.jtaDisplaySetText("L'oggetto " + p.getInvObject1().getName() + " è già aperto. ");
                    } else if (p.getInvObject1().isOpenable() == false) {
                        frame.jtaDisplaySetText("Non puoi aprire l'oggetto " + p.getInvObject1().getName() + ". ");
                    }
                }

            } else if (p.getCommand().getType() == CommandType.CLOSE) {
                if (p.getObject() != null) {
                    if (p.getObject().isOpenable() == false) {
                        frame.jtaDisplaySetText("Non puoi chiudere l'oggetto " + p.getObject().getName());
                    } else if (p.getObject().isOpenable() == true) {
                        if (p.getObject().isOpen() == false) {
                            frame.jtaDisplaySetText("L'oggetto " + p.getObject().getName() + " è già chiuso.");
                        } else {
                            p.getObject().setOpen(false);
                            frame.jtaDisplaySetText("Hai chiuso: " + p.getObject().getName());
                        }
                    }

                } else if (p.getInvObject1() != null) {
                    if (p.getInvObject1().isOpenable() == false) {
                        frame.jtaDisplaySetText("Non puoi aprire l'oggetto " + p.getInvObject1().getName());
                    } else if (p.getInvObject1().isOpenable() == true) {
                        if (p.getInvObject1().isOpen() == false) {
                            frame.jtaDisplaySetText("L'oggetto " + p.getInvObject1().getName() + " è già chiuso.");
                        } else {
                            p.getInvObject1().setOpen(false);
                            frame.jtaDisplaySetText("Hai chiuso: " + p.getInvObject1().getName());
                        }
                    }
                } else {
                    frame.jtaDisplaySetText("Non c'è niente da chiudere qui.");
                }

            } else if (p.getCommand().getType() == CommandType.PUSH) {
                if (p.getObject() != null && p.getObject().isPushable()) {
                    boolean error = false;
                    if (p.getObject().isPush() == false) {
                        if (p.getObject().getId() == 95) {
                            p.getObject().setPush(true);
                            p.getObject().setLock(3);
                            frame.jtaDisplaySetText("Hai premuto la " + p.getObject().getName());

                            Iterator<AdvObject> objIt = getCurrentRoom().getObjects().iterator();
                            while (objIt.hasNext()) {
                                AdvObject nextObj = objIt.next();

                                if (nextObj.getId() == 100 && nextObj.getLock() != 2) {
                                    error = true;
                                }

                            }
                        } else if (p.getObject().getId() == 96) {
                            p.getObject().setPush(true);
                            p.getObject().setLock(6);
                            frame.jtaDisplaySetText("Hai premuto la " + p.getObject().getName());

                            Iterator<AdvObject> objIt = getCurrentRoom().getObjects().iterator();
                            while (objIt.hasNext()) {
                                AdvObject nextObj = objIt.next();

                                if (nextObj.getId() == 97 && nextObj.getLock() != 5) {
                                    error = true;
                                }
                                if (nextObj.getId() == 97 && nextObj.getLock() == 5) {
                                    getCurrentRoom().setPathView("/img/View/mosaic_room_solved.png");
                                    frame.jlViewSetIcon(getCurrentRoom().getPathView());
                                    Iterator<AdvObject> objIt2 = getCurrentRoom().getObjects().iterator();
                                    while (objIt2.hasNext()) {
                                        AdvObject nextObj2 = objIt2.next();
                                        if (nextObj2.getId() == 94) {
                                            nextObj.setDescription("Il mosaico ora mostra la costellazione di orione, evidenziando 20 delle 130 stelle che la compongono");
                                            frame.jtaDisplaySetText(nextObj.getDescription());
                                        }
                                    }
                                }
                            }
                        } else if (p.getObject().getId() == 97) {
                            p.getObject().setPush(true);
                            p.getObject().setLock(5);
                            frame.jtaDisplaySetText("Hai premuto la " + p.getObject().getName());

                            Iterator<AdvObject> objIt = getCurrentRoom().getObjects().iterator();
                            while (objIt.hasNext()) {
                                AdvObject nextObj = objIt.next();

                                if (nextObj.getId() == 99 && nextObj.getLock() != 4) {
                                    error = true;
                                }

                            }
                        } else if (p.getObject().getId() == 98) {
                            p.getObject().setPush(true);
                            p.getObject().setLock(1);
                            frame.jtaDisplaySetText("Hai premuto la " + p.getObject().getName());
                        } else if (p.getObject().getId() == 99) {
                            p.getObject().setPush(true);
                            p.getObject().setLock(4);
                            frame.jtaDisplaySetText("Hai premuto la " + p.getObject().getName());

                            Iterator<AdvObject> objIt = getCurrentRoom().getObjects().iterator();
                            while (objIt.hasNext()) {
                                AdvObject nextObj = objIt.next();

                                if (nextObj.getId() == 95 && nextObj.getLock() != 3) {
                                    error = true;
                                }

                            }
                        } else if (p.getObject().getId() == 100) {
                            p.getObject().setPush(true);
                            p.getObject().setLock(2);
                            frame.jtaDisplaySetText("Hai premuto la " + p.getObject().getName());

                            Iterator<AdvObject> objIt = getCurrentRoom().getObjects().iterator();
                            while (objIt.hasNext()) {
                                AdvObject nextObj = objIt.next();

                                if (nextObj.getId() == 98 && nextObj.getLock() != 1) {
                                    error = true;
                                }

                            }
                        } else {
                            frame.jtaDisplaySetText("Non puoi premere l'oggetto " + p.getObject().getName() + ". ");
                        }
                    } else {
                        frame.jtaDisplaySetText("La " + p.getObject().getName() + " è già stata premuta. ");
                    }
                    if (error == true) {
                        frame.jtaDisplayAppendText("\nLe piastre sono tornate al loro posto...avrò sbagliato la combinazione. ");

                        Iterator<AdvObject> objIt = getCurrentRoom().getObjects().iterator();
                        while (objIt.hasNext()) {
                            AdvObject nextObj = objIt.next();

                            if (nextObj.getId() == 95 || nextObj.getId() == 96 || nextObj.getId() == 97 || nextObj.getId() == 98 || nextObj.getId() == 99 || nextObj.getId() == 100) {
                                nextObj.setPush(false);
                                nextObj.setLock(0);
                            }

                        }
                    }

                } else {
                    frame.jtaDisplaySetText("Non ci sono oggetti che puoi premere qui.");
                }
            } else if (p.getCommand().getType() == CommandType.USE) {

                if (p.getInvObject1() != null && p.getInvObject2() != null) {
                    if (p.getInvObject2().getId() == 102 && p.getInvObject1().getId() == 130) {
                        getInventory().remove(p.getInvObject1());
                        getInventory().remove(p.getInvObject2());
                        AdvObject litTorch = new AdvObject(197, "Torcia accesa", "È la torcia impolverata raccolta prima, ora accesa; produce molta luce.");
                        litTorch.setAlias(new String[]{"torcia"});
                        litTorch.setOpenable(false);
                        litTorch.setPickupable(true);
                        litTorch.setOpen(false);
                        litTorch.setPushable(false);
                        litTorch.setPush(false);
                        getInventory().add(litTorch);

                        frame.jtaInventorySetText("\t\tInventario");
                        frame.jtaInventoryAppendText("\n----------------------");
                        Iterator<AdvObject> inventoryIt = getInventory().iterator();
                        while (inventoryIt.hasNext()) {
                            AdvObject nextObjInv = inventoryIt.next();
                            frame.jtaInventoryAppendText("- " + nextObjInv.getName() + "\n");
                        }
                        frame.jtaDisplaySetText("Hai ottenuto: " + litTorch.getName() + "\n" + litTorch.getDescription());

                    } else if (p.getInvObject2().getId() == 130 && p.getInvObject1().getId() == 102) {
                        getInventory().remove(p.getInvObject1());
                        getInventory().remove(p.getInvObject2());
                        AdvObject litTorch = new AdvObject(197, "Torcia accesa", "È la torcia impolverata raccolta prima, ora accesa; produce molta luce.");
                        litTorch.setAlias(new String[]{"torcia"});
                        litTorch.setOpenable(false);
                        litTorch.setPickupable(true);
                        litTorch.setOpen(false);
                        litTorch.setPushable(false);
                        litTorch.setPush(false);
                        getInventory().add(litTorch);

                        frame.jtaInventorySetText("\t\tInventario");
                        frame.jtaInventoryAppendText("\n----------------------");
                        Iterator<AdvObject> inventoryIt = getInventory().iterator();
                        while (inventoryIt.hasNext()) {
                            AdvObject nextObjInv = inventoryIt.next();
                            frame.jtaInventoryAppendText("- " + nextObjInv.getName() + "\n");
                        }
                        frame.jtaDisplaySetText("Hai ottenuto: " + litTorch.getName() + "\n" + litTorch.getDescription());

                    } else if (p.getInvObject2().getId() == 196 && p.getInvObject1().getId() == 55) {

                        getInventory().remove(p.getInvObject2());
                        frame.jtaDisplaySetText("Rompendo il contenitore fragile hai ottenuto la chiave blu.");

                        Iterator<Room> roomIt = getRooms().iterator();
                        while (roomIt.hasNext()) {
                            Room nextRoom = roomIt.next();

                            Iterator<AdvObject> objIt = nextRoom.getObjects().iterator();
                            while (objIt.hasNext()) {
                                AdvObject nextObj = objIt.next();
                                if (nextObj.getId() == 68) {
                                    getInventory().add(nextObj);
                                }
                            }
                        }

                        frame.jtaInventorySetText("\t\tInventario");
                        frame.jtaInventoryAppendText("\n----------------------");
                        Iterator<AdvObject> inventoryIt = getInventory().iterator();
                        while (inventoryIt.hasNext()) {
                            AdvObject nextObjInv = inventoryIt.next();
                            frame.jtaInventoryAppendText("- " + nextObjInv.getName() + "\n");
                        }
                    } else if (p.getInvObject2().getId() == 55 && p.getInvObject1().getId() == 196) {

                        getInventory().remove(p.getInvObject1());
                        frame.jtaDisplaySetText("Rompendo il contenitore fragile hai ottenuto la chiave blu.");

                        Iterator<Room> roomIt = getRooms().iterator();
                        while (roomIt.hasNext()) {
                            Room nextRoom = roomIt.next();

                            Iterator<AdvObject> objIt = nextRoom.getObjects().iterator();
                            while (objIt.hasNext()) {
                                AdvObject nextObj = objIt.next();
                                if (nextObj.getId() == 68) {
                                    getInventory().add(nextObj);
                                }
                            }
                        }

                        frame.jtaInventorySetText("\t\tInventario");
                        frame.jtaInventoryAppendText("\n----------------------");
                        Iterator<AdvObject> inventoryIt = getInventory().iterator();
                        while (inventoryIt.hasNext()) {
                            AdvObject nextObjInv = inventoryIt.next();
                            frame.jtaInventoryAppendText("- " + nextObjInv.getName() + "\n");
                        }

                    }
                } else if (p.getObject() != null && p.getInvObject1() != null) {

                    if (p.getInvObject1().getId() == 172 && p.getObject().getId() == 176) {
                        getInventory().remove(p.getInvObject1());
                        p.getObject().setOpenable(true);
                        p.getObject().setOpen(true);
                        frame.jtaDisplaySetText("Hai aperto: " + p.getObject().getName());
                        AdvObjectContainer c = (AdvObjectContainer) p.getObject();
                        if (!c.getList().isEmpty()) {
                            frame.jtaDisplaySetText(c.getName() + " contiene: ");
                            Iterator<AdvObject> it = c.getList().iterator();
                            String[] contents = new String[9];
                            int i = 0;
                            while (it.hasNext()) {
                                AdvObject next = it.next();
                                getCurrentRoom().getObjects().add(next);
                                contents[i] = " -" + next.getName();
                                i++;
                            }
                            for (int j = 0; j < i; j++) {
                                if (j % 3 != 0 || (j == 0)) {
                                    frame.jtaDisplayAppendText(contents[j]);
                                } else {
                                    frame.jtaDisplayAppendText("\n" + contents[j]);
                                }
                            }
                        }

                        frame.jtaInventorySetText("\t\tInventario");
                        frame.jtaInventoryAppendText("\n----------------------");
                        Iterator<AdvObject> inventoryIt = getInventory().iterator();
                        while (inventoryIt.hasNext()) {
                            AdvObject nextObjInv = inventoryIt.next();
                            frame.jtaInventoryAppendText("- " + nextObjInv.getName() + "\n");
                        }
                    } else if (p.getInvObject1().getId() == 92 && p.getObject().getId() == 91) {
                        String s;
                        s = (String) JOptionPane.showInputDialog(frame, "Inserire il canale:\n", "Selezione canali", JOptionPane.PLAIN_MESSAGE, null, null, "");
                        if (s != null) {
                            if (s.equalsIgnoreCase("5802")) {
                                p.getObject().setDescription("Ora la televisione mostra a intermittenza la frase 'Sono sveglio da anni...'. ");
                                frame.jtaDisplaySetText(p.getObject().getDescription());
                            }
                        }

                    } else if (p.getInvObject1().getId() == 24 && p.getObject().getId() == 37) {
                        p.getObject().setOpen(true);
                        getInventory().remove(p.getInvObject1());
                        frame.jtaDisplaySetText("La porta si è aperta.");
                        getCurrentRoom().setPathView("/img/View/study_1_unlocked.png");
                        frame.jlViewSetIcon(getCurrentRoom().getPathView());
                        Iterator<Room> it = getRooms().iterator();
                        while (it.hasNext()) {
                            Room next = it.next();
                            if (next.getId() == 6) {
                                next.setLocked(false);
                            }
                        }
                        frame.jtaInventorySetText("\t\tInventario");
                        frame.jtaInventoryAppendText("\n----------------------");
                        Iterator<AdvObject> inventoryIt = getInventory().iterator();
                        while (inventoryIt.hasNext()) {
                            AdvObject nextObjInv = inventoryIt.next();
                            frame.jtaInventoryAppendText("- " + nextObjInv.getName() + "\n");
                        }

                    } else if (p.getInvObject1().getId() == 50 && p.getObject().getId() == 38) {
                        frame.jtaDisplaySetText("Hai inserito la chiave rossa!");
                        p.getObject().setLock(p.getObject().getLock() + 1);
                        getInventory().remove(p.getInvObject1());
                        if (p.getObject().getLock() == 3) {
                            p.getObject().setOpen(true);
                            frame.jtaDisplaySetText("La porta si è aperta.");
                            Iterator<Room> it = getRooms().iterator();
                            while (it.hasNext()) {
                                Room next = it.next();
                                if (next.getId() == 15) {
                                    next.setLocked(false);
                                } else if (next.getId() == 6) {
                                    next.setPathView("/img/View/stairs_1_unlocked.png");
                                    frame.jlViewSetIcon(next.getPathView());
                                }
                            }
                        }

                        frame.jtaInventorySetText("\t\tInventario");
                        frame.jtaInventoryAppendText("\n----------------------");
                        Iterator<AdvObject> inventoryIt = getInventory().iterator();
                        while (inventoryIt.hasNext()) {
                            AdvObject nextObjInv = inventoryIt.next();
                            frame.jtaInventoryAppendText("- " + nextObjInv.getName() + "\n");
                        }

                    } else if (p.getInvObject1().getId() == 68 && p.getObject().getId() == 38) {
                        frame.jtaDisplaySetText("Hai inserito la chiave blu!");
                        p.getObject().setLock(p.getObject().getLock() + 1);
                        getInventory().remove(p.getInvObject1());
                        if (p.getObject().getLock() == 3) {
                            p.getObject().setOpen(true);
                            frame.jtaDisplaySetText("La porta si è aperta.");
                            Iterator<Room> it = getRooms().iterator();
                            while (it.hasNext()) {
                                Room next = it.next();
                                if (next.getId() == 15) {
                                    next.setLocked(false);
                                } else if (next.getId() == 6) {
                                    next.setPathView("/img/View/stairs_1_unlocked.png");
                                    frame.jlViewSetIcon(next.getPathView());
                                }
                            }
                        }

                        frame.jtaInventorySetText("\t\tInventario");
                        frame.jtaInventoryAppendText("\n----------------------");
                        Iterator<AdvObject> inventoryIt = getInventory().iterator();
                        while (inventoryIt.hasNext()) {
                            AdvObject nextObjInv = inventoryIt.next();
                            frame.jtaInventoryAppendText("- " + nextObjInv.getName() + "\n");
                        }

                    } else if (p.getInvObject1().getId() == 80 && p.getObject().getId() == 38) {
                        frame.jtaDisplaySetText("Hai inserito la chiave verde!");
                        p.getObject().setLock(p.getObject().getLock() + 1);
                        getInventory().remove(p.getInvObject1());
                        if (p.getObject().getLock() == 3) {
                            p.getObject().setOpen(true);
                            frame.jtaDisplaySetText("La porta si è aperta.");
                            Iterator<Room> it = getRooms().iterator();
                            while (it.hasNext()) {
                                Room next = it.next();
                                if (next.getId() == 15) {
                                    next.setLocked(false);
                                } else if (next.getId() == 6) {
                                    next.setPathView("/img/View/stairs_1_unlocked.png");
                                    frame.jlViewSetIcon(next.getPathView());
                                }
                            }
                        }

                        frame.jtaInventorySetText("\t\tInventario");
                        frame.jtaInventoryAppendText("\n----------------------");
                        Iterator<AdvObject> inventoryIt = getInventory().iterator();
                        while (inventoryIt.hasNext()) {
                            AdvObject nextObjInv = inventoryIt.next();
                            frame.jtaInventoryAppendText("- " + nextObjInv.getName() + "\n");
                        }

                    } else if (p.getInvObject1().getId() == 67 && p.getObject().getId() == 64) {
                        getInventory().remove(p.getInvObject1());
                        AdvObject burntShell = new AdvObject(195, "Contenitore bruciato", "È lo stesso contenitore, ma bruciato.");
                        burntShell.setAlias(new String[]{"contenitore"});
                        burntShell.setOpenable(false);
                        burntShell.setPickupable(true);
                        burntShell.setOpen(false);
                        burntShell.setPushable(false);
                        burntShell.setPush(false);
                        getInventory().add(burntShell);
                        frame.jtaDisplaySetText("Hai ottenuto: " + burntShell.getName() + "\n" + burntShell.getDescription());

                        frame.jtaInventorySetText("\t\tInventario");
                        frame.jtaInventoryAppendText("\n----------------------");
                        Iterator<AdvObject> inventoryIt = getInventory().iterator();
                        while (inventoryIt.hasNext()) {
                            AdvObject nextObjInv = inventoryIt.next();
                            frame.jtaInventoryAppendText("- " + nextObjInv.getName() + "\n");
                        }

                    } else if (p.getInvObject1().getId() == 195 && p.getObject().getId() == 58) {
                        getInventory().remove(p.getInvObject1());
                        AdvObject fragileShell = new AdvObject(196, "Contenitore fragile", "È lo stesso contenitore, ma il materiale di cui è fatto sembra molto più fragile di prima.");
                        fragileShell.setAlias(new String[]{"contenitore"});
                        fragileShell.setOpenable(false);
                        fragileShell.setPickupable(true);
                        fragileShell.setOpen(false);
                        fragileShell.setPushable(false);
                        fragileShell.setPush(false);
                        getInventory().add(fragileShell);
                        frame.jtaDisplaySetText("Hai ottenuto: " + fragileShell.getName() + "\n" + fragileShell.getDescription());

                        frame.jtaInventorySetText("\t\tInventario");
                        frame.jtaInventoryAppendText("\n----------------------");
                        Iterator<AdvObject> inventoryIt = getInventory().iterator();
                        while (inventoryIt.hasNext()) {
                            AdvObject nextObjInv = inventoryIt.next();
                            frame.jtaInventoryAppendText("- " + nextObjInv.getName() + "\n");
                        }
                    } else if (p.getInvObject1().getId() == 144 && p.getObject().getId() == 143) {
                        String s;
                        s = (String) JOptionPane.showInputDialog(frame, p.getObject().getDescription(), p.getObject().getName(), JOptionPane.PLAIN_MESSAGE, null, null, "");
                        if (s != null) {
                            if (s.equalsIgnoreCase("Aiutami")) {
                                frame.jtaDisplaySetText("Sento del parlare misto a rumori strani provenire dalle stanze più avanti");
                                Iterator<Room> it = getRooms().iterator();
                                while (it.hasNext()) {
                                    Room next = it.next();
                                    if (next.getName().equalsIgnoreCase("∞")) {
                                        Iterator<AdvObject> objIt = next.getObjects().iterator();
                                        while (objIt.hasNext()) {
                                            AdvObject nextObj = objIt.next();
                                            if (nextObj.getId() == 188) {
                                                nextObj.setDescription("La radio trasmette a intermittenza i numeri 1, 2, 2, 0, 3, 1, 3, 0, 6, 1, 0");
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    } else if (p.getInvObject1().getId() == 198 && p.getObject().getId() == 157) {
                        getCurrentRoom().setPathView("/img/View/darkness.png");
                        frame.jlViewSetIcon(getCurrentRoom().getPathView());
                        getCurrentRoom().getObjects().remove(p.getObject());
                        AdvObject extinctBarrel = new AdvObject(199, "Barile spento", "Non riesco a vedere più nulla.");
                        extinctBarrel.setAlias(new String[]{"barile"});
                        extinctBarrel.setOpenable(false);
                        extinctBarrel.setPickupable(false);
                        extinctBarrel.setOpen(false);
                        extinctBarrel.setPushable(false);
                        extinctBarrel.setPush(false);
                        getCurrentRoom().getObjects().add(extinctBarrel);
                        frame.jtaDisplayAppendText("\nSi è spento il fuoco...non riesco più a vedere nulla");

                    } else if (p.getInvObject1().getId() == 184 && p.getObject().getId() == 185) {
                        p.getObject().setOpen(true);
                        frame.jtaDisplaySetText("Hai aperto: " + p.getObject().getName());
                        AdvObjectContainer c = (AdvObjectContainer) p.getObject();
                        if (!c.getList().isEmpty()) {
                            frame.jtaDisplaySetText(c.getName() + " contiene: ");
                            Iterator<AdvObject> it = c.getList().iterator();
                            String[] contents = new String[9];
                            int i = 0;
                            while (it.hasNext()) {
                                AdvObject next = it.next();
                                getCurrentRoom().getObjects().add(next);
                                contents[i] = " -" + next.getName();
                                i++;
                            }
                            for (int j = 0; j < i; j++) {
                                if (j % 3 != 0 || (j == 0)) {
                                    frame.jtaDisplayAppendText(contents[j]);
                                } else {
                                    frame.jtaDisplayAppendText("\n" + contents[j]);
                                }
                            }
                        }

                        Iterator<AdvObject> it = getCurrentRoom().getObjects().iterator();
                        while (it.hasNext()) {
                            AdvObject next = it.next();
                            if (next.getId() == 186) {
                                p.getObject().setPickupable(true);
                            }
                        }
                    } else if (p.getInvObject1().getId() == 186 && p.getObject().getId() == 187) {
                        getInventory().remove(p.getInvObject1());
                        getCurrentRoom().setPathView("/img/View/mannequin_room_bulb.png");
                        frame.jlViewSetIcon(getCurrentRoom().getPathView());
                        Iterator<Room> it = getRooms().iterator();
                        while (it.hasNext()) {
                            Room next = it.next();
                            if (next.getId() == 36) {
                                Iterator<AdvObject> objIt = next.getObjects().iterator();

                                while (objIt.hasNext()) {
                                    AdvObject nextObj = objIt.next();
                                    if (nextObj.getId() == 190) {

                                        nextObj.setLock(nextObj.getLock() + 1);
                                        if (nextObj.getLock() == 1) {
                                            nextObj.setDescription("Su questo meccanismo sono visibili 2 luci spente e 1 luce accesa");
                                            next.setPathView("/img/View/mirror_room_1.png");
                                            frame.jtaDisplaySetText("Ho sentito un rumore dalla stanza più avanti...");
                                        }
                                        if (nextObj.getLock() == 2) {
                                            nextObj.setDescription("Su questo meccanismo sono visibili 1 luce spenta e 2 luce accese");
                                            next.setPathView("/img/View/mirror_room_2.png");
                                            frame.jtaDisplaySetText("Ho sentito un rumore dalla stanza più avanti...");
                                        }
                                        if (nextObj.getLock() == 3) {
                                            nextObj.setDescription("Su questo meccanismo sono visibili 3 luci accese");
                                            next.setPathView("/img/View/mirror_room_3.png");
                                            frame.jtaDisplaySetText("Ho sentito un rumore dalla stanza più avanti...");

                                            Iterator<Room> it2 = getRooms().iterator();
                                            while (it2.hasNext()) {
                                                Room next2 = it2.next();
                                                if (next2.getId() == 37) {
                                                    next2.setLocked(false);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        frame.jtaInventorySetText("\t\tInventario");
                        frame.jtaInventoryAppendText("\n----------------------");
                        Iterator<AdvObject> inventoryIt = getInventory().iterator();
                        while (inventoryIt.hasNext()) {
                            AdvObject nextObjInv = inventoryIt.next();
                            frame.jtaInventoryAppendText("- " + nextObjInv.getName() + "\n");
                        }
                    }
                } else if (p.getInvObject1() != null) {
                    if (p.getInvObject1().getId() == 197) {
                        if (getCurrentRoom().getId() == 19) {
                            getCurrentRoom().setName("Biblioteca incenerita");
                            getCurrentRoom().setDescription("Hai incendiato la biblioteca.");
                            getCurrentRoom().setPathView("/img/View/library_burnt.png");
                            frame.jtaDisplaySetText(getCurrentRoom().getDescription());
                            frame.jlViewSetIcon(getCurrentRoom().getPathView());
                            Iterator<Room> itRoom = getRooms().iterator();
                            while (itRoom.hasNext()) {
                                Room next = itRoom.next();
                                if (next.getId() == 29) {
                                    Iterator<AdvObject> itObj = next.getObjects().iterator();
                                    while (itObj.hasNext()) {
                                        AdvObject nextObj = itObj.next();
                                        if (nextObj.getId() == 159) {
                                            nextObj.setDescription("Questo orologio ora indica le 1 a.m.");
                                        } else if (nextObj.getId() == 160) {
                                            nextObj.setDescription("Questo orologio ora indica le 3 p.m.");
                                        } else if (nextObj.getId() == 161) {
                                            nextObj.setDescription("Questo orologio ora indica le 4 a.m.");
                                        } else if (nextObj.getId() == 162) {
                                            nextObj.setDescription("Questo orologio ora indica le 7 a.m.");
                                        } else if (nextObj.getId() == 163) {
                                            nextObj.setDescription("Questo orologio ora indica le 2 a.m.");
                                        } else if (nextObj.getId() == 164) {
                                            nextObj.setDescription("Questo orologio ora indica le 8 p.m.");
                                        } else if (nextObj.getId() == 165) {
                                            nextObj.setDescription("Questo orologio ora indica le 1 p.m.");
                                        } else if (nextObj.getId() == 166) {
                                            nextObj.setDescription("Questo orologio ora indica le 6 a.m.");
                                        } else if (nextObj.getId() == 167) {
                                            nextObj.setDescription("Questo orologio ora indica le 5 a.m.");
                                        } else if (nextObj.getId() == 168) {
                                            nextObj.setDescription("Questo orologio ora indica le 9 p.m.");
                                        } else if (nextObj.getId() == 169) {
                                            nextObj.setDescription("Questo orologio ora indica le 2 p.m.");
                                        }
                                    }
                                }
                            }

                        }
                    } else if (p.getInvObject1().getId() == 177) {
                        if (getCurrentRoom().getId() == 27) {

                            Iterator<AdvObject> objIt = getCurrentRoom().getObjects().iterator();
                            while (objIt.hasNext()) {
                                AdvObject nextObj = objIt.next();
                                if (nextObj.getId() == 199) {
                                    getCurrentRoom().setPathView("/img/View/barrel_room_nvg.png");
                                    getCurrentRoom().setDescription("Sui muri della stanza è visibile, grazie al visore, la frase: 'Per favore...chiama il 1-800-273-8255' .");
                                    frame.jlViewSetIcon(getCurrentRoom().getPathView());
                                    frame.jtaDisplaySetText(getCurrentRoom().getDescription());
                                }
                            }
                        }
                    } else if (p.getInvObject1().getId() == 158) {
                        if (getCurrentRoom().getId() == 28) {
                            getInventory().remove(p.getInvObject1());
                            AdvObject fullBucket = new AdvObject(198, "Secchio pieno", "È il secchio raccolto prima, ora pieno di neve.");
                            fullBucket.setAlias(new String[]{"secchio"});
                            fullBucket.setOpenable(false);
                            fullBucket.setPickupable(true);
                            fullBucket.setOpen(false);
                            fullBucket.setPushable(false);
                            fullBucket.setPush(false);
                            getInventory().add(fullBucket);

                            frame.jtaDisplaySetText("Hai riempito il secchio con della neve. ");
                            frame.jtaInventorySetText("\t\tInventario");
                            frame.jtaInventoryAppendText("\n----------------------");
                            Iterator<AdvObject> inventoryIt = getInventory().iterator();
                            while (inventoryIt.hasNext()) {
                                AdvObject nextObjInv = inventoryIt.next();
                                frame.jtaInventoryAppendText("- " + nextObjInv.getName() + "\n");
                            }
                        }
                    }
                    if (p.getInvObject1().getId() == 197) {
                        if (getCurrentRoom().getId() == 20) {
                            getCurrentRoom().setDescription("Grazie alla luce emanata dalla torcia, ora sono visibili sulle pareti della stanza i numeri: 4, 9, 1, 0.");
                            frame.jtaDisplaySetText(getCurrentRoom().getDescription());
                        }
                    }
                } else if (p.getObject() != null) {
                    if (p.getObject().getId() == 131) {
                        String s;
                        s = (String) JOptionPane.showInputDialog(frame, "Inserisci nome utente:\n", "Login", JOptionPane.PLAIN_MESSAGE, null, null, "");

                        if (s != null) {
                            if (s.equalsIgnoreCase("Orione")) {
                                String s1;
                                s1 = (String) JOptionPane.showInputDialog(frame, "Inserisci password:\n", "Login", JOptionPane.PLAIN_MESSAGE, null, null, "");
                                if (s1 != null) {
                                    if (s1.equalsIgnoreCase("BRNGBA20")) {
                                        p.getObject().setDescription("Sul proiettore ora c'è scritto '...aspettando che qualcosa cambi' ");
                                        frame.jtaDisplaySetText(p.getObject().getDescription());
                                    } else {
                                        frame.jtaDisplaySetText("Password inserita errata. ");
                                    }
                                }
                            } else {
                                frame.jtaDisplaySetText("Nome utente inserito errato. ");
                            }
                        }
                    }

                    if (p.getObject().getId() == 189) {
                        String s;
                        s = (String) JOptionPane.showInputDialog(frame, "Inserire il numero di telefono da chiamare:\n", "Telefono", JOptionPane.PLAIN_MESSAGE, null, null, "");
                        if (s != null) {
                            if (s.equalsIgnoreCase("13472816592")) {
                                Iterator<Room> roomIt = getRooms().iterator();
                                while (roomIt.hasNext()) {
                                    Room next = roomIt.next();
                                    if (next.getId() == 36) {
                                        Iterator<AdvObject> objIt = next.getObjects().iterator();
                                        while (objIt.hasNext()) {
                                            AdvObject nextObj = objIt.next();
                                            if (nextObj.getId() == 190) {
                                                nextObj.setLock(nextObj.getLock() + 1);
                                                if (nextObj.getLock() == 1) {
                                                    nextObj.setDescription("Su questo meccanismo sono visibili 2 luci spente e 1 luce accesa");
                                                    next.setPathView("/img/View/mirror_room_1.png");
                                                    frame.jtaDisplaySetText("Ho sentito un rumore dalla stanza più avanti...");
                                                }
                                                if (nextObj.getLock() == 2) {
                                                    nextObj.setDescription("Su questo meccanismo sono visibili 1 luce spenta e 2 luce accese");
                                                    next.setPathView("/img/View/mirror_room_2.png");
                                                    frame.jtaDisplaySetText("Ho sentito un rumore dalla stanza più avanti...");
                                                }
                                                if (nextObj.getLock() == 3) {
                                                    nextObj.setDescription("Su questo meccanismo sono visibili 3 luci accese");
                                                    next.setPathView("/img/View/mirror_room_3.png");
                                                    frame.jtaDisplaySetText("Ho sentito un rumore dalla stanza più avanti...");

                                                    Iterator<Room> it2 = getRooms().iterator();
                                                    while (it2.hasNext()) {
                                                        Room next2 = it2.next();
                                                        if (next2.getId() == 37) {
                                                            next2.setLocked(false);
                                                        }
                                                    }
                                                }
                                            }

                                        }
                                    }
                                }
                            } else if (s.equalsIgnoreCase("18002738255")) {
                                Iterator<Room> it = getRooms().iterator();
                                while (it.hasNext()) {
                                    Room next = it.next();
                                    if (next.getId() == 36) {
                                        Iterator<AdvObject> objIt = next.getObjects().iterator();
                                        while (objIt.hasNext()) {
                                            AdvObject nextObj = objIt.next();
                                            if (nextObj.getId() == 190) {
                                                nextObj.setLock(nextObj.getLock() + 1);
                                                if (nextObj.getLock() == 1) {
                                                    nextObj.setDescription("Su questo meccanismo sono visibili 2 luci spente e 1 luce accesa");
                                                    next.setPathView("/img/View/mirror_room_1.png");
                                                    frame.jtaDisplaySetText("Ho sentito un rumore dalla stanza più avanti...");
                                                }
                                                if (nextObj.getLock() == 2) {
                                                    nextObj.setDescription("Su questo meccanismo sono visibili 1 luce spenta e 2 luce accese");
                                                    next.setPathView("/img/View/mirror_room_2.png");
                                                    frame.jtaDisplaySetText("Ho sentito un rumore dalla stanza più avanti...");
                                                }
                                                if (nextObj.getLock() == 3) {
                                                    nextObj.setDescription("Su questo meccanismo sono visibili 3 luci accese");
                                                    next.setPathView("/img/View/mirror_room_3.png");
                                                    frame.jtaDisplaySetText("Ho sentito un rumore dalla stanza più avanti...");

                                                    Iterator<Room> it2 = getRooms().iterator();
                                                    while (it2.hasNext()) {
                                                        Room next2 = it2.next();
                                                        if (next2.getId() == 37) {
                                                            next2.setLocked(false);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else if (s.equalsIgnoreCase("12203130610")) {
                                frame.jtaDisplaySetText("Cos'è stato? Qualcosa dev'essere cambiato... ");
                                Iterator<Room> it = getRooms().iterator();
                                while (it.hasNext()) {
                                    Room next = it.next();
                                    if (next.getId() == 35) {
                                        getCurrentRoom().setEast(next);
                                    }
                                }
                            } else {
                                frame.jtaDisplaySetText("'Il numero chiamato è inesistente.' ");
                            }
                        }
                    }
                } else {
                    frame.jtaDisplaySetText("No, non credo che lo farò ");
                }
            } else if (p.getCommand().getType() == CommandType.END) {
                if (p.getObject() != null) {
                    if (p.getObject().getId() == 193) {
                        getCurrentRoom().setPathView("/img/View/the_end_soulless.png");
                        frame.jlViewSetIcon(getCurrentRoom().getPathView());
                        frame.jtaDisplaySetText("Che cosa succede?! ");

                        int delay = 1500;
                        ActionListener taskPerformer = (ActionEvent evt) -> {
                            if (frame.jlViewGetIconToString().contains("/img/View/the_end_soulless.png")) {
                                frame.jlViewSetIcon("/img/View/the_end_level_0.png");
                                frame.jtaDisplaySetText("La stanza si sta allagando con uno strano liquido nero!");
                            } else if (frame.jlViewGetIconToString().contains("/img/View/the_end_level_0.png")) {
                                frame.jlViewSetIcon("/img/View/the_end_level_1.png");
                                frame.jtaDisplaySetText("Devo trovare una via d'uscita!");
                            } else if (frame.jlViewGetIconToString().contains("/img/View/the_end_level_1.png")) {
                                frame.jlViewSetIcon("/img/View/the_end_level_2.png");
                                frame.jtaDisplaySetText("NON SONO PRONTO A...");
                            } else if (frame.jlViewGetIconToString().contains("/img/View/the_end_level_2.png")) {
                                frame.jlViewSetIcon("/img/View/wake_up_samurai.png");
                                frame.jtaDisplaySetText(" ");
                            }
                            int delay1 = 800;
                            ActionListener taskPerformer1 = (ActionEvent evt1) -> {
                                if (frame.jlViewGetIconToString().contains("/img/View/wake_up_samurai.png")) {
                                    System.exit(0);
                                }
                            };
                            new Timer(delay1, taskPerformer1).start();
                        };
                        new Timer(delay, taskPerformer).start();
                    }
                }
            }

            if (p.getObject() != null) {
                if (p.getObject().getId() == 73 || p.getObject().getId() == 74 || p.getObject().getId() == 75 || p.getObject().getId() == 76 || p.getObject().getId() == 77 || p.getObject().getId() == 78) {
                    boolean temp = false;
                    int x = 0;
                    Iterator<AdvObject> obj = getCurrentRoom().getObjects().iterator();
                    while (obj.hasNext()) {
                        AdvObject next = obj.next();
                        if (next.getId() == 73 && next.isOpen() == true) {
                            Iterator<AdvObject> obj1 = getCurrentRoom().getObjects().iterator();
                            while (obj1.hasNext()) {
                                AdvObject next1 = obj1.next();
                                if (next1.getId() == 74 && next1.isOpen() == false) {
                                    Iterator<AdvObject> obj2 = getCurrentRoom().getObjects().iterator();
                                    while (obj2.hasNext()) {
                                        AdvObject next2 = obj2.next();
                                        if (next2.getId() == 75 && next2.isOpen() == true) {
                                            Iterator<AdvObject> obj3 = getCurrentRoom().getObjects().iterator();
                                            while (obj3.hasNext()) {
                                                AdvObject next3 = obj3.next();
                                                if (next3.getId() == 76 && next3.isOpen() == false) {
                                                    Iterator<AdvObject> obj4 = getCurrentRoom().getObjects().iterator();
                                                    while (obj4.hasNext()) {
                                                        AdvObject next4 = obj4.next();
                                                        if (next4.getId() == 77 && next4.isOpen() == true) {
                                                            Iterator<AdvObject> obj5 = getCurrentRoom().getObjects().iterator();
                                                            while (obj5.hasNext()) {
                                                                AdvObject next5 = obj5.next();
                                                                if (next5.getId() == 78 && next5.isOpen() == false) {
                                                                    temp = true;
                                                                    x++;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (x == 1) {
                        frame.jtaDisplayAppendText("\nRiesco a vedere un cassetto segreto sporgere dal lato del mobile, chissà cosa contiene");

                        AdvObjectContainer secretDrawer = new AdvObjectContainer(79, "Contenitore segreto", "Al suo interno c'è una chiave verde.");
                        secretDrawer.setAlias(new String[]{"compartimento segreto", "tiretto segreto", "cassetto segreto"});
                        secretDrawer.setOpenable(true);
                        secretDrawer.setPickupable(false);
                        secretDrawer.setOpen(false);
                        secretDrawer.setPushable(false);
                        secretDrawer.setPush(false);
                        getCurrentRoom().getObjects().add(secretDrawer);

                        AdvObject greenKey = new AdvObject(80, "Chiave verde", "Una delle tre chiavi per sbloccare la porta per il pianoterra");
                        greenKey.setAlias(new String[]{});
                        greenKey.setOpenable(false);
                        greenKey.setPickupable(true);
                        greenKey.setOpen(false);
                        greenKey.setPushable(false);
                        greenKey.setPush(false);
                        secretDrawer.add(greenKey);
                    }
                }
            }
            if (frontDoor) {
                frame.jtaDisplaySetText("Non credo sia il momento di uscire di casa. ");
            } else if (noRoom) {
                frame.jtaDisplaySetText("Da quella parte non c'è nessuna porta. ");
            } else if (blocked) {
                frame.jtaDisplaySetText("La porta per quella stanza è bloccata. ");
            } else if (move) {
                frame.jtaDisplaySetText("Ora ti trovi in: " + getCurrentRoom().getName() + "\n" + getCurrentRoom().getDescription());
                frame.jlMinimapSetIcon(getCurrentRoom().getPathMinimap());
                frame.jlViewSetIcon(getCurrentRoom().getPathView());
            }
        }
    }
}
