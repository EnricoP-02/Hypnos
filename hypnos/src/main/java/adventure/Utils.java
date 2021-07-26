package adventure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Questa classe si occupa di operazioni utili allo svolgimento del programma. 
 */
public class Utils {

    /**
     * Questo metodo si occupa del caricamento dei dati presenti su di un File in un Set. 
     *
     * @param file  Il file da caricare in un Set
     * @return set
     */
    public static Set<String> loadFileListInSet(File file) {
        Set<String> set = new HashSet<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("FILE NON TROVATO");
            System.exit(0);
        }

        try {
            while (reader.ready()) {
                set.add(reader.readLine().trim().toLowerCase());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("ERRORE NEL RECUPERO DAL FILE");
            System.exit(0);
        }

        return set;
    }

    /**
     * Questo metodo restituisce una List contenente le singole parole presenti 
     * nella String 'string', escluse quelle presenti nel Set 'stopwords'
     *
     * @param string  La String sulla quale è necessario effettuare il controllo
     * @param stopwords  Il Set di caratteri da eliminare in 'string'
     * @return tokens
     */
    public static List<String> parseString(String string, Set<String> stopwords) {
        List<String> tokens = new ArrayList<>();
        String[] split = string.toLowerCase().split("\\s+");
        for (String t : split) {
            if (!stopwords.contains(t)) {
                tokens.add(t);
            }
        }
        return tokens;
    }
    
}
