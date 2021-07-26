# Hypnos

Avventura testuale sviluppata per l'esame di Metodi Avanzati di Programmazione dal gruppo Moirai

## Componenti del gruppo:

-	Andrea Mastrolonardo
-	Michele Cosimo Maggi
-	Enrico Pappalardo

## Introduzione:

Il gioco realizzato (denominato “Hypnos”) si basa sull’idea di una avventura testuale con elementi aggiuntivi inseriti in una interfaccia grafica per aiutare l’utente a orientarsi e immaginare i luoghi descritti.
Il gioco ha come ambientazione una casa con una struttura piuttosto intricata; l’obiettivo dell’utente è esplorare tutta la casa e cercare di capire cosa sta succedendo.

L’intenzione alla base della realizzazione del gioco è stata di creare una avventura testuale con una ambientazione non spiccatamente horror, poiché l’obiettivo non è mai stato quello di spaventare, ma con sfumature di thriller.
Attraverso le immagini e la struttura della casa volevamo comunicare all’utente un senso di curiosità, ma anche un po’ di disagio, soprattutto verso le stanze finali.

Il gioco è ambientato in una casa con 4 piani. Il giocatore ha come obiettivo l’esplorazione di tutta la casa e, per fare ciò, ha bisogno di sbloccare alcune sezioni della casa  inizialmente inaccessibili.
Nella casa sono sparsi fogli contenenti indizi su come proseguire con l’esplorazione e alcuni fogli contengono anche altre informazioni che forniscono indizi su cosa esattamente sta succedendo.

Il gameplay del gioco è molto semplice; le azioni principali che l’utente può effettuare sono elencate nella sezione “help” del menu.
Oltre a muoversi tra le stanze della casa specificando le direzioni cardinali, l’utente può guardare stanze e oggetti, prendere oggetti, interagire con oggetti, premere alcuni oggetti e aprire o chiudere porte o oggetti.
Queste interazioni con gli oggetti presenti nella casa sono essenziali per la risoluzione degli indovinelli. 

![Interfaccia](https://raw.githubusercontent.com/EnricoP-02/Hypnos/main/img/Interfaccia.png)

## Architettura del sistema

Di seguito riportiamo una descrizione formale del sistema e dei suoi componenti.
Partendo dalla base “adventure”, il progetto “Hypnos” è diviso in 5 package: adventure, adventure.games, advenutre.gui, adventure.parser e adventure.type.
adventure contiene la classe Utils.java, che ha un metodo per caricare i dati di un file in un set e un metodo per rimuovere da una data stringa gli elementi contenuti in un set e la classe GameDescription.java, una classe astratta che indica i vari attributi e metodi di un “gioco”, che vanno necessariamente definiti e implementati in una classe differente.
adventure.games contiene il “gioco”, ovvero l’implementazione della classe GameDescription.java. Questa implementazione è fornita nella classe Hypnos.java.
adventure.gui contiene la classe Frame.java, ovvero l’insieme degli attributi e dei metodi necessari al funzionamento dell’interfaccia grafica.
adventure.parser contiene le classi Parser.java e ParserOutput.java; il loro compito è interpretare i comandi di input inseriti dall’utente.
adventure.type contiene le classi AdvObject.java, AdvObjectContainer.java che eredita da AdvObject.java, Command.java, CommandType.java, Inventory.java e Room.java; esse servono a definire i tipi aggiuntivi necessari per il funzionamento del programma.
Inoltre abbiamo utilizzato ulteriori package contenenti immagini poi inserite nell’interfaccia grafica del sistema.

## Dettagli implementativi 

Abbiamo utilizzato i file per l’inizializzazione delle stanze, degli oggetti e dei rispettivi parametri; questa decisione è stata presa per facilitare la futura manutenzione in caso di errori o inconsistenze. 
Abbiamo utilizzato il database H2 principalmente per la funzione di salvataggio e caricamento della partita. Abbiamo considerato una funzione di rete per il gioco, infine non sviluppata perchè non era adatta all’esperienza alla base del gioco da noi prevista, ovvero un’esperienza singleplayer.
Abbiamo utilizzato le GUI per costruire l’interfaccia grafica dell’applicazione. L’intenzione è stata quella di fornire all’utente una minimappa che mostra la struttura base della stanza e le direzioni in cui è possibile muoversi, una vista in prima persona della stanza attuale che ha come funzione associare alla descrizione una parte visiva utile per un minimo di interesse e immersione da parte dell’utente.
Abbiamo utilizzato alcune Collection come Arraylist per organizzare i dati delle stanze e oggetti in maniera più ordinata, iterator per rendere le ricerche negli arraylist più veloci e semplici, il tipo enumerativo per il tipo dei comandi inseribili dell’utente, i set per creare gli alias, rendendo molto più semplice il riferimento ad oggetti, stanze e azioni da svolgere.

## Informazioni aggiuntive

-	Se avviato il progetto il testo nella sezione dell’inventario sembra troppo grande o troppo piccolo, è necessario ridimensionare il font nella sezione del frame associata all’inventario. Questo problema si è presentato solo ad uno dei tre membri del gruppo eseguendo la stessa versione del progetto, quindi non dovrebbero essere necessari cambiamenti.
-	Per la realizzazione della JavaDoc abbiamo seguito i “javadoc coding standards”, link: https://blog.joda.org/2012/11/javadoc-coding-standards.html; tra queste era sconsigliato l’utilizzo del tag @author, quindi li abbiamo rimossi.
-	Era prevista la creazione di un jar-with-dependencies tramite maven-assembly-plugin, ma dopo averlo eseguito ci siamo accorti che non riusciva a trovare il file stopwords e il file save.mv; la motivazione sembra essere il path dei file quando è il jar a richiamarli e non l’ambiente di sviluppo. Nonostante i numerosi tentativi di risoluzione non siamo riusciti a correggere il problema, quindi abbiamo pensato di notificare l’assenza di una versione funzionante del jar-with-dependencies.
