package adventure.gui;

import adventure.GameDescription;
import adventure.Utils;
import adventure.games.Hypnos;
import adventure.parser.Parser;
import adventure.parser.ParserOutput;
import adventure.type.AdvObject;
import adventure.type.AdvObjectContainer;
import adventure.type.Room;
import java.io.File;
import java.util.Set;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_OPTION;

import java.sql.SQLException;
import javax.swing.ImageIcon;

/**
 * Questa classe si occupa della generazione della interfaccia grafica e 
 * della gestione dell'interazione con l'utente. 
 * <p>
 * Questa classe rappresenta il punto di partenza dell'intero programma, 
 * dato che contiene il metodo 'main' che dà inizio a tutte le operazioni. 
 */
public class Frame extends javax.swing.JFrame {

    /**
     * Questa costante descrive il codice per la creazione della tabella 'hypnosDb' nel caso non esista già. 
     */
    public static final String HYPNOS_TABLE = "CREATE TABLE IF NOT EXISTS hypnosDb (artId INT PRIMARY KEY, currentRoom INT, inventoryId VARCHAR(100), riddlesState VARCHAR(30))";

    private final GameDescription game;

    private Parser parser;

    private final ImageIcon logo = new ImageIcon(getClass().getResource("/img/Icons/hypnos.png"));

    /**
     * Questo metodo, che è il costruttore di questa classe, 
     * si occupa della creazione di un nuovo form chiamato 'Frame'. 
     */
    public Frame() {
        initComponents();

        this.game = new Hypnos();
        this.game.init();
        Set<String> stopwords = Utils.loadFileListInSet(new File("./src/main/resources/init/stopwords"));
        parser = new Parser(stopwords);

        this.setIconImage(logo.getImage());
        // Visualizzazione messaggi iniziali
        jtaDisplay.append("Non riesco a dormire... sono già le 23:59, chissà se sono l'unico ancora sveglio. ");
        jtaDisplay.append("\n=========================================================\n");
        jtaDisplay.append("Ti trovi in: ");
        jtaDisplay.append(game.getCurrentRoom().getName());
        jtaDisplay.append("\n");
        jtaDisplay.append(game.getCurrentRoom().getDescription());
        // Visualizzazione della minimappa e visuale corrette
        jlMinimap.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathMinimap())));
        jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
        // Inizializzazione della visualizzazione dell'inventario
        jtaInventory.setText("\t\tInventario");
        jtaInventory.append("\n----------------------");
    }

    /**
     * Questo metodo viene chiamato dal costruttore per l'inizializzazione del form. 
     * ATTENZIONE: NON modificare questo codice. I contenuti di questo metodo 
     * sono sempre rigenerati dal Form Editor. 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdSave = new javax.swing.JDialog();
        jpSave = new javax.swing.JPanel();
        jlSave = new javax.swing.JLabel();
        jlSaveSlot1 = new javax.swing.JLabel();
        jlSaveSlot2 = new javax.swing.JLabel();
        jlSaveSlot3 = new javax.swing.JLabel();
        jlSaveSlot6 = new javax.swing.JLabel();
        jlSaveSlot5 = new javax.swing.JLabel();
        jlSaveSlot4 = new javax.swing.JLabel();
        jlMinimap = new javax.swing.JLabel();
        jspInventory = new javax.swing.JScrollPane();
        jtaInventory = new javax.swing.JTextArea();
        jtfInput = new javax.swing.JTextField();
        jlView = new javax.swing.JLabel();
        jspDisplay = new javax.swing.JScrollPane();
        jtaDisplay = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmGame = new javax.swing.JMenu();
        jmiSave = new javax.swing.JMenuItem();
        jmiLoad = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiReset = new javax.swing.JMenuItem();
        jmHelp = new javax.swing.JMenu();

        jdSave.setTitle("Salva");
        jdSave.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        jdSave.setResizable(false);
        jdSave.setSize(new java.awt.Dimension(390, 320));

        jpSave.setBackground(new java.awt.Color(0, 0, 0));
        jpSave.setPreferredSize(new java.awt.Dimension(390, 320));

        jlSave.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jlSave.setForeground(new java.awt.Color(255, 255, 255));
        jlSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSave.setText("Scegliere uno slot di salvataggio");

        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:./src/main/resources/db/save");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM hypnosDb WHERE artId = 1");

            if (rs.next() && (!(rs.getString(2).equalsIgnoreCase("-1")))) {

                jlSaveSlot1.setBackground(new java.awt.Color(255, 255, 255));

                jlSaveSlot1.setForeground(new java.awt.Color(0, 0, 0));

                jlSaveSlot1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

                jlSaveSlot1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/Save_file_on_1.png"))); // NOI18N

                jlSaveSlot1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

                jlSaveSlot1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

                jlSaveSlot1.setName("full");

            } else {
                jlSaveSlot1.setBackground(new java.awt.Color(255, 255, 255));
                jlSaveSlot1.setForeground(new java.awt.Color(255, 255, 255));
                jlSaveSlot1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jlSaveSlot1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/Save_file_off_1.png"))); // NOI18N
                jlSaveSlot1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jlSaveSlot1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                jlSaveSlot1.setName("empty"); // NOI18N
            }
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        jlSaveSlot1.setOpaque(true);
        jlSaveSlot1.setPreferredSize(new java.awt.Dimension(92, 92));
        jlSaveSlot1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlSaveSlot1MouseClicked(evt);
            }
        });

        jlSaveSlot2.setBackground(new java.awt.Color(255, 255, 255));
        jlSaveSlot2.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jlSaveSlot2.setForeground(new java.awt.Color(255, 255, 255));
        jlSaveSlot2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:./src/main/resources/db/save");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM hypnosDb WHERE artId = 2");

            if (rs.next() && (!(rs.getString(2).equalsIgnoreCase("-1")))) {
                jlSaveSlot2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/Save_file_on_2.png"))); // NOI18N

                jlSaveSlot2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

                jlSaveSlot2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

                jlSaveSlot2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

                jlSaveSlot2.setMaximumSize(new java.awt.Dimension(90, 90));

                jlSaveSlot2.setMinimumSize(new java.awt.Dimension(90, 90));

                jlSaveSlot2.setBackground(new java.awt.Color(255, 255, 255));

                jlSaveSlot2.setName("full");
            } else {
                jlSaveSlot2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/Save_file_off_2.png"))); // NOI18N
                jlSaveSlot2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jlSaveSlot2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                jlSaveSlot2.setName("empty"); // NOI18N
            }
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        jlSaveSlot2.setOpaque(true);
        jlSaveSlot2.setPreferredSize(new java.awt.Dimension(92, 92));
        jlSaveSlot2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlSaveSlot2MouseClicked(evt);
            }
        });

        jlSaveSlot3.setBackground(new java.awt.Color(255, 255, 255));
        jlSaveSlot3.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jlSaveSlot3.setForeground(new java.awt.Color(255, 255, 255));
        jlSaveSlot3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:./src/main/resources/db/save");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM hypnosDb WHERE artId = 3");

            if (rs.next() && (!(rs.getString(2).equalsIgnoreCase("-1")))) {
                jlSaveSlot3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/Save_file_on_3.png"))); // NOI18N

                jlSaveSlot3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

                jlSaveSlot3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

                jlSaveSlot3.setMaximumSize(new java.awt.Dimension(90, 90));

                jlSaveSlot3.setMinimumSize(new java.awt.Dimension(90, 90));

                jlSaveSlot3.setName("full");
            } else {
                jlSaveSlot3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/Save_file_off_3.png"))); // NOI18N
                jlSaveSlot3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jlSaveSlot3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                jlSaveSlot3.setName("empty"); // NOI18N
            }
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        jlSaveSlot3.setOpaque(true);
        jlSaveSlot3.setPreferredSize(new java.awt.Dimension(92, 92));
        jlSaveSlot3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlSaveSlot3MouseClicked(evt);
            }
        });

        jlSaveSlot6.setBackground(new java.awt.Color(255, 255, 255));
        jlSaveSlot6.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jlSaveSlot6.setForeground(new java.awt.Color(255, 255, 255));
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:./src/main/resources/db/save");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM hypnosDb WHERE artId = 6");

            if (rs.next() && (!(rs.getString(2).equalsIgnoreCase("-1")))) {
                jlSaveSlot6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/Save_file_on_6.png"))); // NOI18N

                jlSaveSlot6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

                jlSaveSlot6.setMaximumSize(new java.awt.Dimension(90, 90));

                jlSaveSlot6.setMinimumSize(new java.awt.Dimension(90, 90));

                jlSaveSlot6.setName("full");
            } else {
                jlSaveSlot6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/Save_file_off_6.png"))); // NOI18N
                jlSaveSlot6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jlSaveSlot6.setName("empty"); // NOI18N
            }
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        jlSaveSlot6.setOpaque(true);
        jlSaveSlot6.setPreferredSize(new java.awt.Dimension(92, 92));
        jlSaveSlot6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlSaveSlot6MouseClicked(evt);
            }
        });

        jlSaveSlot5.setBackground(new java.awt.Color(255, 255, 255));
        jlSaveSlot5.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jlSaveSlot5.setForeground(new java.awt.Color(255, 255, 255));
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:./src/main/resources/db/save");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM hypnosDb WHERE artId = 5");

            if (rs.next() && (!(rs.getString(2).equalsIgnoreCase("-1")))) {
                jlSaveSlot5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/Save_file_on_5.png"))); // NOI18N

                jlSaveSlot5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

                jlSaveSlot5.setMaximumSize(new java.awt.Dimension(90, 90));

                jlSaveSlot5.setMinimumSize(new java.awt.Dimension(90, 90));

                jlSaveSlot5.setName("full");
            } else {
                jlSaveSlot5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/Save_file_off_5.png"))); // NOI18N
                jlSaveSlot5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jlSaveSlot5.setName("empty"); // NOI18N
            }
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        jlSaveSlot5.setOpaque(true);
        jlSaveSlot5.setPreferredSize(new java.awt.Dimension(92, 92));
        jlSaveSlot5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlSaveSlot5MouseClicked(evt);
            }
        });

        jlSaveSlot4.setBackground(new java.awt.Color(255, 255, 255));
        jlSaveSlot4.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jlSaveSlot4.setForeground(new java.awt.Color(255, 255, 255));
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:./src/main/resources/db/save");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM hypnosDb WHERE artId = 4");

            if (rs.next() && (!(rs.getString(2).equalsIgnoreCase("-1")))) {
                jlSaveSlot4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/Save_file_on_4.png"))); // NOI18N

                jlSaveSlot4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

                jlSaveSlot4.setMaximumSize(new java.awt.Dimension(90, 90));

                jlSaveSlot4.setMinimumSize(new java.awt.Dimension(90, 90));

                jlSaveSlot4.setName("full");
            } else {
                jlSaveSlot4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/Save_file_off_4.png"))); // NOI18N
                jlSaveSlot4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jlSaveSlot4.setName("empty"); // NOI18N
            }
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        jlSaveSlot4.setOpaque(true);
        jlSaveSlot4.setPreferredSize(new java.awt.Dimension(92, 92));
        jlSaveSlot4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlSaveSlot4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpSaveLayout = new javax.swing.GroupLayout(jpSave);
        jpSave.setLayout(jpSaveLayout);
        jpSaveLayout.setHorizontalGroup(
            jpSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSaveLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSaveLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jpSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlSaveSlot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlSaveSlot4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(jpSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlSaveSlot5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlSaveSlot2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jpSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlSaveSlot6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlSaveSlot3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        jpSaveLayout.setVerticalGroup(
            jpSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSaveLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jlSave, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jpSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlSaveSlot2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlSaveSlot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlSaveSlot3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlSaveSlot6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlSaveSlot4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlSaveSlot5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jlSaveSlot1.getAccessibleContext().setAccessibleDescription("");
        jlSaveSlot2.getAccessibleContext().setAccessibleDescription("");
        jlSaveSlot3.getAccessibleContext().setAccessibleDescription("");
        jlSaveSlot6.getAccessibleContext().setAccessibleDescription("");
        jlSaveSlot5.getAccessibleContext().setAccessibleDescription("");
        jlSaveSlot4.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jdSaveLayout = new javax.swing.GroupLayout(jdSave.getContentPane());
        jdSave.getContentPane().setLayout(jdSaveLayout);
        jdSaveLayout.setHorizontalGroup(
            jdSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdSaveLayout.setVerticalGroup(
            jdSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hypnos v. 1.0.0");
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(810, 605));
        setName("frame"); // NOI18N
        setResizable(false);

        jlMinimap.setBackground(new java.awt.Color(0, 0, 0));
        jlMinimap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Minimap_err.png"))); // NOI18N
        jlMinimap.setName("jlMinimap"); // NOI18N
        jlMinimap.setOpaque(true);

        jtaInventory.setEditable(false);
        jtaInventory.setBackground(new java.awt.Color(0, 0, 0));
        jtaInventory.setColumns(1);
        jtaInventory.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jtaInventory.setForeground(new java.awt.Color(255, 255, 255));
        jtaInventory.setLineWrap(true);
        jtaInventory.setRows(10);
        jtaInventory.setTabSize(3);
        jtaInventory.setWrapStyleWord(true);
        jtaInventory.setAutoscrolls(false);
        jtaInventory.setBorder(null);
        jtaInventory.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jtaInventory.setMaximumSize(new java.awt.Dimension(175, 300));
        jtaInventory.setMinimumSize(new java.awt.Dimension(175, 300));
        jtaInventory.setName("jtaInventory"); // NOI18N
        jtaInventory.setPreferredSize(new java.awt.Dimension(175, 300));
        jtaInventory.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jtaInventory.setSelectionColor(new java.awt.Color(255, 255, 255));
        jspInventory.setViewportView(jtaInventory);

        jtfInput.setBackground(new java.awt.Color(0, 0, 0));
        jtfInput.setFont(new java.awt.Font("Monospaced", 0, 17)); // NOI18N
        jtfInput.setForeground(new java.awt.Color(255, 255, 255));
        jtfInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtfInput.setCaretColor(new java.awt.Color(255, 255, 255));
        jtfInput.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jtfInput.setMaximumSize(new java.awt.Dimension(600, 35));
        jtfInput.setMinimumSize(new java.awt.Dimension(600, 35));
        jtfInput.setName("jtfInput"); // NOI18N
        jtfInput.setPreferredSize(new java.awt.Dimension(600, 55));
        jtfInput.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jtfInput.setSelectionColor(new java.awt.Color(255, 255, 255));
        jtfInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfInputActionPerformed(evt);
            }
        });

        jlView.setBackground(new java.awt.Color(0, 0, 0));
        jlView.setForeground(new java.awt.Color(255, 255, 255));
        jlView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/View_err.png"))); // NOI18N
        jlView.setName("jlView"); // NOI18N
        jlView.setOpaque(true);

        jspDisplay.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jspDisplay.setAutoscrolls(true);
        jspDisplay.setPreferredSize(new java.awt.Dimension(600, 128));

        jtaDisplay.setEditable(false);
        jtaDisplay.setBackground(new java.awt.Color(0, 0, 0));
        jtaDisplay.setColumns(20);
        jtaDisplay.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jtaDisplay.setForeground(new java.awt.Color(255, 255, 255));
        jtaDisplay.setLineWrap(true);
        jtaDisplay.setRows(5);
        jtaDisplay.setWrapStyleWord(true);
        jtaDisplay.setCaretColor(new java.awt.Color(255, 255, 255));
        jtaDisplay.setMargin(new java.awt.Insets(10, 15, 10, 10));
        jtaDisplay.setName("jtaDisplay"); // NOI18N
        jtaDisplay.setPreferredSize(new java.awt.Dimension(595, 125));
        jtaDisplay.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jtaDisplay.setSelectionColor(new java.awt.Color(255, 255, 255));
        jspDisplay.setViewportView(jtaDisplay);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        jmGame.setText("Partita");
        jmGame.setName("jmGame"); // NOI18N

        jmiSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/Save.png"))); // NOI18N
        jmiSave.setText("Salva partita");
        jmiSave.setName("jmiSave"); // NOI18N
        jmiSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSaveActionPerformed(evt);
            }
        });
        jmGame.add(jmiSave);

        jmiLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/Load.png"))); // NOI18N
        jmiLoad.setText("Carica partita");
        jmiLoad.setName("jmiLoad"); // NOI18N
        jmiLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiLoadActionPerformed(evt);
            }
        });
        jmGame.add(jmiLoad);
        jmGame.add(jSeparator1);

        jmiReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/Reset.png"))); // NOI18N
        jmiReset.setText("Ricomincia");
        jmiReset.setName("jmiReset"); // NOI18N
        jmiReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiResetActionPerformed(evt);
            }
        });
        jmGame.add(jmiReset);

        jMenuBar1.add(jmGame);

        jmHelp.setText("?");
        jmHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmHelpMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jlView))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jspDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlMinimap)
                    .addComponent(jspInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5)
                        .addComponent(jspDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jtfInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlMinimap)
                        .addGap(5, 5, 5)
                        .addComponent(jspInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfInputActionPerformed
        jtfInput.setText("");
        String command = evt.getActionCommand();
        ParserOutput p = parser.parse(command, game.getCommands(), game.getCurrentRoom().getObjects(), game.getInventory());

        game.nextMove(p, this);
    }//GEN-LAST:event_jtfInputActionPerformed

    private void jmiResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiResetActionPerformed
        this.setVisible(false);
        java.awt.EventQueue.invokeLater(() -> {
            new Frame().setVisible(true);
        });
    }//GEN-LAST:event_jmiResetActionPerformed

    private void jmiSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSaveActionPerformed
        jdSave.pack();
        jdSave.setLocationRelativeTo(this);
        jdSave.setTitle("Salva");

        jlSaveSlot1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlSaveSlot2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlSaveSlot3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlSaveSlot4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlSaveSlot5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlSaveSlot6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jdSave.setVisible(true);
    }//GEN-LAST:event_jmiSaveActionPerformed

    private void jmiLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiLoadActionPerformed
        jdSave.pack();
        jdSave.setLocationRelativeTo(this);
        jdSave.setTitle("Carica");

        if (jlSaveSlot1.getName().equalsIgnoreCase("empty")) {
            jlSaveSlot1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }
        if (jlSaveSlot2.getName().equalsIgnoreCase("empty")) {
            jlSaveSlot2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }
        if (jlSaveSlot3.getName().equalsIgnoreCase("empty")) {
            jlSaveSlot3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }
        if (jlSaveSlot4.getName().equalsIgnoreCase("empty")) {
            jlSaveSlot4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }
        if (jlSaveSlot5.getName().equalsIgnoreCase("empty")) {
            jlSaveSlot5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }
        if (jlSaveSlot6.getName().equalsIgnoreCase("empty")) {
            jlSaveSlot6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }

        jdSave.setVisible(true);
    }//GEN-LAST:event_jmiLoadActionPerformed

    private void jlSaveSlot1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSaveSlot1MouseClicked
        int n = YES_OPTION;

        if (jdSave.getTitle().equalsIgnoreCase("Salva")) {
            if (jlSaveSlot1.getName().equalsIgnoreCase("full")) {
                Object[] options = {"Si", "No"};
                n = JOptionPane.showOptionDialog(this, "Sovrascivere i dati salvati?", "Sovrascrittura", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            }

            if (n == YES_OPTION) {
                jdSave.setVisible(false);

                jtaDisplay.setText("\nSalvataggio in corso...");

                try {
                    boolean flag = false;
                    Connection conn = DriverManager.getConnection("jdbc:h2:./src/main/resources/db/save");
                    Statement stm = conn.createStatement();
                    stm.executeUpdate(HYPNOS_TABLE);

                    ResultSet rs = stm.executeQuery("SELECT * FROM hypnosDb WHERE artId = 1");
                    if (rs.next()) {
                        PreparedStatement pstm = conn.prepareStatement("UPDATE hypnosDb SET currentRoom = ?, inventoryId = ?, riddlesState = ? WHERE artId = 1");
                        pstm.setInt(1, this.game.getCurrentRoom().getId());

                        Iterator<AdvObject> objIt = this.game.getInventory().iterator();
                        String tempObj = "";
                        while (objIt.hasNext()) {
                            flag = true;
                            AdvObject next = objIt.next();
                            tempObj = tempObj + next.getId() + "#";
                        }
                        if (flag) {
                            pstm.setString(2, tempObj);
                        } else {
                            tempObj = null;
                            pstm.setString(2, tempObj);
                        }

                        Iterator<Room> roomIt = this.game.getRooms().iterator();
                        String tempRoom = "";
                        while (roomIt.hasNext()) {
                            Room nextRoom = roomIt.next();

                            if (nextRoom.getId() == 6 || nextRoom.getId() == 15 || nextRoom.getId() == 24 || nextRoom.getId() == 37) {
                                tempRoom = tempRoom + nextRoom.isLocked() + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() == 34) {
                                tempRoom = tempRoom + "true" + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() != 34) {
                                tempRoom = tempRoom + "false" + "#";
                            }
                        }
                        pstm.setString(3, tempRoom + " ");

                        pstm.executeUpdate();
                        pstm.close();

                    } else {
                        PreparedStatement pstm = conn.prepareStatement("INSERT INTO hypnosDb VALUES (?,?,?,?)");
                        pstm.setInt(1, 1);
                        pstm.setInt(2, this.game.getCurrentRoom().getId());

                        Iterator<AdvObject> it = this.game.getInventory().iterator();
                        String tempObj = "";
                        while (it.hasNext()) {
                            flag = true;
                            AdvObject next = it.next();
                            tempObj = tempObj + next.getId() + "#";
                        }

                        if (flag) {
                            pstm.setString(3, tempObj);
                        } else {
                            tempObj = null;
                            pstm.setString(3, tempObj);
                        }

                        Iterator<Room> roomIt = this.game.getRooms().iterator();
                        String tempRoom = "";
                        while (roomIt.hasNext()) {
                            Room nextRoom = roomIt.next();

                            if (nextRoom.getId() == 6 || nextRoom.getId() == 15 || nextRoom.getId() == 24 || nextRoom.getId() == 37) {
                                tempRoom = tempRoom + nextRoom.isLocked() + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() == 34) {
                                tempRoom = tempRoom + "true" + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() != 34) {
                                tempRoom = tempRoom + "false" + "#";
                            }
                        }
                        pstm.setString(4, tempRoom + " ");

                        pstm.executeUpdate();
                        pstm.close();
                    }

                    stm.close();
                    jtaDisplay.append("\nSalvataggio effettuato correttamente!");
                    jlSaveSlot1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/Save_file_on_1.png")));
                    jlSaveSlot1.setName("full");
                } catch (SQLException ex) {
                    System.err.println(ex.getSQLState() + ": " + ex.getMessage());
                    jtaDisplay.append("\nSalvataggio non riuscito");
                }
            }
        } else if (jdSave.getTitle().equalsIgnoreCase("Carica")) {
            if (jlSaveSlot1.getName().equalsIgnoreCase("empty")) {
                JOptionPane.showMessageDialog(this, "In questo slot non sono presenti dati salvati", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                jdSave.setVisible(false);

                jtaDisplay.setText("Caricamento in corso...");
                jtaDisplay.append("\n=========================================================\n");
                String[] objInventory;
                String[] riddleState;
                int i;
                boolean flag = false;

                try {
                    Connection conn = DriverManager.getConnection("jdbc:h2:./src/main/resources/db/save");
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery("SELECT * FROM hypnosDb WHERE artId = 1");

                    if (rs.next()) {
                        Iterator<Room> rm = this.game.getRooms().iterator();
                        while (rm.hasNext()) {
                            Room next = rm.next();

                            if (next.getId() == rs.getInt(2)) {
                                this.game.setCurrentRoom(next);
                                jlMinimap.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathMinimap())));
                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                jtaDisplay.append("Ti trovi in: ");
                                jtaDisplay.append(game.getCurrentRoom().getName());
                                jtaDisplay.append("\n");
                                jtaDisplay.append(game.getCurrentRoom().getDescription());

                            }
                        }

                        if (rs.getString(3) != null) {
                            objInventory = rs.getString(3).split("#");
                            Iterator<Room> roomIt = this.game.getRooms().iterator();
                            while (roomIt.hasNext()) {
                                Room nextRoom = roomIt.next();
                                Iterator<AdvObject> objectIt = nextRoom.getObjects().iterator();
                                while (objectIt.hasNext()) {
                                    AdvObject nextObject = objectIt.next();
                                    for (i = 0; objInventory.length - 1 >= i; i++) {
                                        if (Integer.parseInt(objInventory[i]) == nextObject.getId()) {
                                            this.game.getInventory().add(nextObject);
                                            objectIt.remove();
                                        }

                                    }

                                    if (nextObject instanceof AdvObjectContainer) {
                                        AdvObjectContainer nextObjectContainer = (AdvObjectContainer) nextObject;

                                        if (!nextObjectContainer.getList().isEmpty()) {
                                            Iterator<AdvObject> containerIt = nextObjectContainer.getList().iterator();
                                            while (containerIt.hasNext()) {
                                                AdvObject nextObjContained = containerIt.next();

                                                for (i = 0; objInventory.length - 1 >= i; i++) {

                                                    if (nextObjContained.getId() == Integer.parseInt(objInventory[i])) {
                                                        this.game.getInventory().add(nextObjContained);
                                                        containerIt.remove();
                                                    }

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        if (rs.getString(4) != null) {
                            riddleState = rs.getString(4).split("#");
                            Iterator<Room> roomIt = this.game.getRooms().iterator();
                            while (roomIt.hasNext()) {
                                Room nextRoom = roomIt.next();
                                if (nextRoom.getId() == 6) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[0]));

                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                    while (roomIt2.hasNext()) {
                                        Room nextRoom2 = roomIt2.next();
                                        if (nextRoom2.getId() == 4 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/study_1_unlocked.png");
                                            if (this.game.getCurrentRoom().getId() == 4) {
                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }
                                        }

                                        Iterator<AdvObject> objIt = nextRoom2.getObjects().iterator();
                                        while (objIt.hasNext()) {
                                            AdvObject nextObj = objIt.next();
                                            if (nextObj.getId() == 24) {
                                                objIt.remove();
                                            }
                                        }
                                    }

                                } else if (nextRoom.getId() == 15) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[1]));

                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();

                                    while (roomIt2.hasNext()) {

                                        Room nextRoom2 = roomIt2.next();

                                        if (nextRoom2.getId() == 6 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/stairs_1_unlocked.png");
                                            if (this.game.getCurrentRoom().getId() == 6) {

                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }

                                            Iterator<Room> roomIt3 = this.game.getRooms().iterator();
                                            while (roomIt3.hasNext()) {
                                                Room nextRoom3 = roomIt3.next();
                                                Iterator<AdvObject> objIt = nextRoom3.getObjects().iterator();
                                                while (objIt.hasNext()) {
                                                    AdvObject nextObj = objIt.next();
                                                    if (nextObj.getId() == 67) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 49) {
                                                        nextObj.setOpen(true);
                                                        if (nextObj instanceof AdvObjectContainer) {
                                                            AdvObjectContainer c = (AdvObjectContainer) nextObj;
                                                            if (!c.getList().isEmpty()) {
                                                                Iterator<AdvObject> objContained = c.getList().iterator();
                                                                while (objContained.hasNext()) {
                                                                    AdvObject nextObjContained = objContained.next();
                                                                    if (nextObjContained.getId() == 50) {
                                                                        objContained.remove();
                                                                    }
                                                                }
                                                            }

                                                        }

                                                    }
                                                }
                                            }
                                        }
                                    }

                                } else if (nextRoom.getId() == 24) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[2]));
                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                    while (roomIt2.hasNext()) {
                                        Room nextRoom2 = roomIt2.next();
                                        if (nextRoom2.getId() == 23 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/string_room_unlocked.png"); //CAMBIARE IL PATH DELLA STRING ROOM

                                            Iterator<Room> roomIt3 = this.game.getRooms().iterator();
                                            while (roomIt3.hasNext()) {
                                                Room nextRoom3 = roomIt3.next();
                                                Iterator<AdvObject> objIt = nextRoom3.getObjects().iterator();
                                                while (objIt.hasNext()) {
                                                    AdvObject nextObj = objIt.next();
                                                    if (nextObj.getId() == 130) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 95 || nextObj.getId() == 96 || nextObj.getId() == 97 || nextObj.getId() == 98 || nextObj.getId() == 99 || nextObj.getId() == 100) {
                                                        nextObj.setPush(true);
                                                    } else if (nextObj.getId() == 159) {
                                                        nextObj.setDescription("Questo orologio ora indica le 1 a.m.");
                                                    } else if (nextObj.getId() == 160) {
                                                        nextObj.setDescription("Questo orologio ora indica le 3 a.m.");
                                                    } else if (nextObj.getId() == 161) {
                                                        nextObj.setDescription("Questo orologio ora indica le 4 a.m.");
                                                    } else if (nextObj.getId() == 162) {
                                                        nextObj.setDescription("Questo orologio ora indica le 7 a.m.");
                                                    } else if (nextObj.getId() == 163) {
                                                        nextObj.setDescription("Questo orologio ora indica le 2 a.m.");
                                                    } else if (nextObj.getId() == 164) {
                                                        nextObj.setDescription("Questo orologio ora indica le 8 a.m.");
                                                    } else if (nextObj.getId() == 165) {
                                                        nextObj.setDescription("Questo orologio ora indica le 1 a.m.");
                                                    } else if (nextObj.getId() == 166) {
                                                        nextObj.setDescription("Questo orologio ora indica le 6 a.m.");
                                                    } else if (nextObj.getId() == 167) {
                                                        nextObj.setDescription("Questo orologio ora indica le 5 a.m.");
                                                    } else if (nextObj.getId() == 168) {
                                                        nextObj.setDescription("Questo orologio ora indica le 9 a.m.");
                                                    } else if (nextObj.getId() == 169) {
                                                        nextObj.setDescription("Questo orologio ora indica le 2 a.m.");
                                                    }
                                                }

                                                if (nextRoom3.getId() == 19) {
                                                    nextRoom3.setPathView("/img/View/library_burnt.png");
                                                } else if (nextRoom3.getId() == 16) {
                                                    nextRoom3.setPathView("/img/View/mosaic_room_solved.png");
                                                }
                                            }

                                            if (this.game.getCurrentRoom().getId() == 16 || this.game.getCurrentRoom().getId() == 19 || this.game.getCurrentRoom().getId() == 23) {
                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }

                                        }
                                    }

                                } else if (nextRoom.getId() == 34) {
                                    if (Boolean.parseBoolean(riddleState[3]) == false) {
                                        Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                        while (roomIt2.hasNext()) {
                                            Room nextRoom2 = roomIt2.next();
                                            if (nextRoom2.getId() == 35) {
                                                nextRoom.setEast(nextRoom2);
                                            }

                                            Iterator<AdvObject> objIt = nextRoom2.getObjects().iterator();
                                            while (objIt.hasNext()) {
                                                AdvObject nextObj = objIt.next();

                                                if (nextObj.getId() == 188) {
                                                    nextObj.setDescription("La radio trasmette a intermittenza i numeri 1, 2, 2, 0, 3, 1, 3, 0, 6, 1, 0");
                                                } else if (nextObj.getId() == 144) {
                                                    objIt.remove();
                                                }
                                            }
                                        }
                                    }

                                } else if (nextRoom.getId() == 37) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[4]));
                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                    while (roomIt2.hasNext()) {
                                        Room nextRoom2 = roomIt2.next();

                                        if (nextRoom2.getId() == 36 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/mirror_room_3.png");

                                            Iterator<Room> roomIt3 = this.game.getRooms().iterator();
                                            while (roomIt3.hasNext()) {
                                                Room nextRoom3 = roomIt3.next();
                                                Iterator<AdvObject> objIt = nextRoom3.getObjects().iterator();
                                                while (objIt.hasNext()) {
                                                    AdvObject nextObj = objIt.next();
                                                    if (nextObj.getId() == 158) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 184) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 171) {

                                                        if (nextObj instanceof AdvObjectContainer) {
                                                            AdvObjectContainer c = (AdvObjectContainer) nextObj;
                                                            if (!c.getList().isEmpty()) {
                                                                Iterator<AdvObject> objContained = c.getList().iterator();
                                                                while (objContained.hasNext()) {
                                                                    AdvObject nextObjContained = objContained.next();
                                                                    if (nextObjContained.getId() == 172) {
                                                                        objContained.remove();
                                                                    }
                                                                }
                                                            }

                                                        }

                                                    }
                                                }

                                                if (nextRoom3.getId() == 27) {
                                                    nextRoom3.setPathView("/img/View/barrel_room_nvg.png");
                                                } else if (nextRoom3.getId() == 28) {
                                                    nextRoom3.setPathView("/img/View/winter_room_bucketless.png");
                                                } else if (nextRoom3.getId() == 33) {
                                                    nextRoom3.setPathView("/img/View/mannequin_room_bulb.png");
                                                }
                                            }

                                            if (this.game.getCurrentRoom().getId() == 27 || this.game.getCurrentRoom().getId() == 28 || this.game.getCurrentRoom().getId() == 33 || this.game.getCurrentRoom().getId() == 36) {
                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        jtaInventory.setText("\t\tInventario");
                        jtaInventory.append("\n----------------------");
                        Iterator<AdvObject> it = this.game.getInventory().iterator();
                        while (it.hasNext()) {
                            AdvObject nextObj = it.next();
                            jtaInventory.append("\n- " + nextObj.getName());
                        }
                        jtaInventory.append("\n");
                    }
                    rs.close();
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jlSaveSlot1MouseClicked

    private void jlSaveSlot2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSaveSlot2MouseClicked
        int n = YES_OPTION;
        if (jdSave.getTitle().equalsIgnoreCase("Salva")) {
            if (jlSaveSlot2.getName().equalsIgnoreCase("full")) {
                Object[] options = {"Si", "No"};
                n = JOptionPane.showOptionDialog(this, "Sovrascivere i dati salvati?", "Sovrascrittura", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            }

            if (n == YES_OPTION) {
                jdSave.setVisible(false);

                jtaDisplay.setText("\nSalvataggio in corso...");

                try {
                    boolean flag = false;
                    Connection conn = DriverManager.getConnection("jdbc:h2:./src/main/resources/db/save");
                    Statement stm = conn.createStatement();
                    stm.executeUpdate(HYPNOS_TABLE);

                    ResultSet rs = stm.executeQuery("SELECT * FROM hypnosDb WHERE artId = 2");
                    if (rs.next()) {
                        PreparedStatement pstm = conn.prepareStatement("UPDATE hypnosDb SET currentRoom = ?, inventoryId = ?, riddlesState = ? WHERE artId = 2");
                        pstm.setInt(1, this.game.getCurrentRoom().getId());

                        Iterator<AdvObject> objIt = this.game.getInventory().iterator();
                        String tempObj = "";
                        while (objIt.hasNext()) {
                            flag = true;
                            AdvObject next = objIt.next();
                            tempObj = tempObj + next.getId() + "#";
                        }
                        if (flag) {
                            pstm.setString(2, tempObj);
                        } else {
                            tempObj = null;
                            pstm.setString(2, tempObj);
                        }

                        Iterator<Room> roomIt = this.game.getRooms().iterator();
                        String tempRoom = "";
                        while (roomIt.hasNext()) {
                            Room nextRoom = roomIt.next();

                            if (nextRoom.getId() == 6 || nextRoom.getId() == 15 || nextRoom.getId() == 24 || nextRoom.getId() == 37) {
                                tempRoom = tempRoom + nextRoom.isLocked() + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() == 34) {
                                tempRoom = tempRoom + "true" + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() != 34) {
                                tempRoom = tempRoom + "false" + "#";
                            }
                        }
                        pstm.setString(3, tempRoom + " ");

                        pstm.executeUpdate();
                        pstm.close();

                    } else {

                        PreparedStatement pstm = conn.prepareStatement("INSERT INTO hypnosDb VALUES (?,?,?,?)");
                        pstm.setInt(1, 2);
                        pstm.setInt(2, this.game.getCurrentRoom().getId());

                        Iterator<AdvObject> it = this.game.getInventory().iterator();
                        String tempObj = "";
                        while (it.hasNext()) {
                            flag = true;
                            AdvObject next = it.next();
                            tempObj = tempObj + next.getId() + "#";
                        }

                        if (flag) {
                            pstm.setString(3, tempObj);
                        } else {
                            tempObj = null;
                            pstm.setString(3, tempObj);
                        }

                        Iterator<Room> roomIt = this.game.getRooms().iterator();
                        String tempRoom = "";
                        while (roomIt.hasNext()) {
                            Room nextRoom = roomIt.next();

                            if (nextRoom.getId() == 6 || nextRoom.getId() == 15 || nextRoom.getId() == 24 || nextRoom.getId() == 37) {
                                tempRoom = tempRoom + nextRoom.isLocked() + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() == 34) {
                                tempRoom = tempRoom + "true" + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() != 34) {
                                tempRoom = tempRoom + "false" + "#";
                            }
                        }
                        pstm.setString(4, tempRoom + " ");

                        pstm.executeUpdate();
                        pstm.close();
                    }

                    stm.close();
                    jtaDisplay.append("\nSalvataggio effettuato correttamente!");
                    jlSaveSlot2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/Save_file_on_2.png")));
                    jlSaveSlot2.setName("full");
                } catch (SQLException ex) {
                    System.err.println(ex.getSQLState() + ": " + ex.getMessage());
                    jtaDisplay.append("\nSalvataggio non riuscito");
                }
            }
        } else if (jdSave.getTitle().equalsIgnoreCase("Carica")) {
            if (jlSaveSlot2.getName().equalsIgnoreCase("empty")) {
                JOptionPane.showMessageDialog(this, "In questo slot non sono presenti dati salvati", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                jdSave.setVisible(false);

                jtaDisplay.setText("Caricamento in corso...");
                jtaDisplay.append("\n=========================================================\n");
                String[] objInventory;
                String[] riddleState;
                int i;
                boolean flag = false;

                try {
                    Connection conn = DriverManager.getConnection("jdbc:h2:./src/main/resources/db/save");
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery("SELECT * FROM hypnosDb WHERE artId = 2");

                    if (rs.next()) {
                        Iterator<Room> rm = this.game.getRooms().iterator();
                        while (rm.hasNext()) {
                            Room next = rm.next();

                            if (next.getId() == rs.getInt(2)) {
                                this.game.setCurrentRoom(next);
                                jlMinimap.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathMinimap())));
                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                jtaDisplay.append("Ti trovi in: ");
                                jtaDisplay.append(game.getCurrentRoom().getName());
                                jtaDisplay.append("\n");
                                jtaDisplay.append(game.getCurrentRoom().getDescription());

                            }
                        }

                        if (rs.getString(3) != null) {
                            objInventory = rs.getString(3).split("#");
                            Iterator<Room> roomIt = this.game.getRooms().iterator();
                            while (roomIt.hasNext()) {
                                Room nextRoom = roomIt.next();
                                Iterator<AdvObject> objectIt = nextRoom.getObjects().iterator();
                                while (objectIt.hasNext()) {
                                    AdvObject nextObject = objectIt.next();

                                    for (i = 0; objInventory.length - 1 >= i; i++) {

                                        if (Integer.parseInt(objInventory[i]) == nextObject.getId()) {
                                            this.game.getInventory().add(nextObject);
                                            objectIt.remove();
                                        }

                                    }

                                    if (nextObject instanceof AdvObjectContainer) {
                                        AdvObjectContainer nextObjectContainer = (AdvObjectContainer) nextObject;

                                        if (!nextObjectContainer.getList().isEmpty()) {
                                            Iterator<AdvObject> containerIt = nextObjectContainer.getList().iterator();
                                            while (containerIt.hasNext()) {
                                                AdvObject nextObjContained = containerIt.next();

                                                for (i = 0; objInventory.length - 1 >= i; i++) {

                                                    if (nextObjContained.getId() == Integer.parseInt(objInventory[i])) {
                                                        this.game.getInventory().add(nextObjContained);
                                                        containerIt.remove();
                                                    }

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        if (rs.getString(4) != null) {
                            riddleState = rs.getString(4).split("#");
                            Iterator<Room> roomIt = this.game.getRooms().iterator();
                            while (roomIt.hasNext()) {
                                Room nextRoom = roomIt.next();
                                if (nextRoom.getId() == 6) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[0]));

                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                    while (roomIt2.hasNext()) {
                                        Room nextRoom2 = roomIt2.next();
                                        if (nextRoom2.getId() == 4 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/study_1_unlocked.png");
                                            if (this.game.getCurrentRoom().getId() == 4) {
                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }
                                        }

                                        Iterator<AdvObject> objIt = nextRoom2.getObjects().iterator();
                                        while (objIt.hasNext()) {
                                            AdvObject nextObj = objIt.next();
                                            if (nextObj.getId() == 24) {
                                                objIt.remove();
                                            }
                                        }
                                    }

                                } else if (nextRoom.getId() == 15) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[1]));

                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();

                                    while (roomIt2.hasNext()) {

                                        Room nextRoom2 = roomIt2.next();

                                        if (nextRoom2.getId() == 6 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/stairs_1_unlocked.png");
                                            if (this.game.getCurrentRoom().getId() == 6) {

                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }

                                            Iterator<Room> roomIt3 = this.game.getRooms().iterator();
                                            while (roomIt3.hasNext()) {
                                                Room nextRoom3 = roomIt3.next();
                                                Iterator<AdvObject> objIt = nextRoom3.getObjects().iterator();
                                                while (objIt.hasNext()) {
                                                    AdvObject nextObj = objIt.next();
                                                    if (nextObj.getId() == 67) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 49) {
                                                        nextObj.setOpen(true);
                                                        if (nextObj instanceof AdvObjectContainer) {
                                                            AdvObjectContainer c = (AdvObjectContainer) nextObj;
                                                            if (!c.getList().isEmpty()) {
                                                                Iterator<AdvObject> objContained = c.getList().iterator();
                                                                while (objContained.hasNext()) {
                                                                    AdvObject nextObjContained = objContained.next();
                                                                    if (nextObjContained.getId() == 50) {
                                                                        objContained.remove();
                                                                    }
                                                                }
                                                            }

                                                        }

                                                    }
                                                }
                                            }
                                        }
                                    }

                                } else if (nextRoom.getId() == 24) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[2]));
                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                    while (roomIt2.hasNext()) {
                                        Room nextRoom2 = roomIt2.next();
                                        if (nextRoom2.getId() == 23 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/string_room_unlocked.png");

                                            Iterator<Room> roomIt3 = this.game.getRooms().iterator();
                                            while (roomIt3.hasNext()) {
                                                Room nextRoom3 = roomIt3.next();
                                                Iterator<AdvObject> objIt = nextRoom3.getObjects().iterator();
                                                while (objIt.hasNext()) {
                                                    AdvObject nextObj = objIt.next();
                                                    if (nextObj.getId() == 130) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 95 || nextObj.getId() == 96 || nextObj.getId() == 97 || nextObj.getId() == 98 || nextObj.getId() == 99 || nextObj.getId() == 100) {
                                                        nextObj.setPush(true);
                                                    } else if (nextObj.getId() == 159) {
                                                        nextObj.setDescription("Questo orologio ora indica le 1 a.m.");
                                                    } else if (nextObj.getId() == 160) {
                                                        nextObj.setDescription("Questo orologio ora indica le 3 a.m.");
                                                    } else if (nextObj.getId() == 161) {
                                                        nextObj.setDescription("Questo orologio ora indica le 4 a.m.");
                                                    } else if (nextObj.getId() == 162) {
                                                        nextObj.setDescription("Questo orologio ora indica le 7 a.m.");
                                                    } else if (nextObj.getId() == 163) {
                                                        nextObj.setDescription("Questo orologio ora indica le 2 a.m.");
                                                    } else if (nextObj.getId() == 164) {
                                                        nextObj.setDescription("Questo orologio ora indica le 8 a.m.");
                                                    } else if (nextObj.getId() == 165) {
                                                        nextObj.setDescription("Questo orologio ora indica le 1 a.m.");
                                                    } else if (nextObj.getId() == 166) {
                                                        nextObj.setDescription("Questo orologio ora indica le 6 a.m.");
                                                    } else if (nextObj.getId() == 167) {
                                                        nextObj.setDescription("Questo orologio ora indica le 5 a.m.");
                                                    } else if (nextObj.getId() == 168) {
                                                        nextObj.setDescription("Questo orologio ora indica le 9 a.m.");
                                                    } else if (nextObj.getId() == 169) {
                                                        nextObj.setDescription("Questo orologio ora indica le 2 a.m.");
                                                    }
                                                }

                                                if (nextRoom3.getId() == 19) {
                                                    nextRoom3.setPathView("/img/View/library_burnt.png");
                                                } else if (nextRoom3.getId() == 16) {
                                                    nextRoom3.setPathView("/img/View/mosaic_room_solved.png");
                                                }
                                            }

                                            if (this.game.getCurrentRoom().getId() == 16 || this.game.getCurrentRoom().getId() == 19 || this.game.getCurrentRoom().getId() == 23) {
                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }

                                        }
                                    }

                                } else if (nextRoom.getId() == 34) {
                                    if (Boolean.parseBoolean(riddleState[3]) == false) {
                                        Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                        while (roomIt2.hasNext()) {
                                            Room nextRoom2 = roomIt2.next();
                                            if (nextRoom2.getId() == 35) {
                                                nextRoom.setEast(nextRoom2);
                                            }

                                            Iterator<AdvObject> objIt = nextRoom2.getObjects().iterator();
                                            while (objIt.hasNext()) {
                                                AdvObject nextObj = objIt.next();

                                                if (nextObj.getId() == 188) {
                                                    nextObj.setDescription("La radio trasmette a intermittenza i numeri 1, 2, 2, 0, 3, 1, 3, 0, 6, 1, 0");
                                                } else if (nextObj.getId() == 144) {
                                                    objIt.remove();
                                                }
                                            }
                                        }
                                    }

                                } else if (nextRoom.getId() == 37) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[4]));
                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                    while (roomIt2.hasNext()) {
                                        Room nextRoom2 = roomIt2.next();

                                        if (nextRoom2.getId() == 36 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/mirror_room_3.png");

                                            Iterator<Room> roomIt3 = this.game.getRooms().iterator();
                                            while (roomIt3.hasNext()) {
                                                Room nextRoom3 = roomIt3.next();
                                                Iterator<AdvObject> objIt = nextRoom3.getObjects().iterator();
                                                while (objIt.hasNext()) {
                                                    AdvObject nextObj = objIt.next();
                                                    if (nextObj.getId() == 158) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 184) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 171) {

                                                        if (nextObj instanceof AdvObjectContainer) {
                                                            AdvObjectContainer c = (AdvObjectContainer) nextObj;
                                                            if (!c.getList().isEmpty()) {
                                                                Iterator<AdvObject> objContained = c.getList().iterator();
                                                                while (objContained.hasNext()) {
                                                                    AdvObject nextObjContained = objContained.next();
                                                                    if (nextObjContained.getId() == 172) {
                                                                        objContained.remove();
                                                                    }
                                                                }
                                                            }

                                                        }

                                                    }
                                                }

                                                if (nextRoom3.getId() == 27) {
                                                    nextRoom3.setPathView("/img/View/barrel_room_nvg.png");
                                                } else if (nextRoom3.getId() == 28) {
                                                    nextRoom3.setPathView("/img/View/winter_room_bucketless.png");
                                                } else if (nextRoom3.getId() == 33) {
                                                    nextRoom3.setPathView("/img/View/mannequin_room_bulb.png");
                                                }
                                            }

                                            if (this.game.getCurrentRoom().getId() == 27 || this.game.getCurrentRoom().getId() == 28 || this.game.getCurrentRoom().getId() == 33 || this.game.getCurrentRoom().getId() == 36) {
                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        jtaInventory.setText("\t\tInventario");
                        jtaInventory.append("\n----------------------");
                        Iterator<AdvObject> it = this.game.getInventory().iterator();
                        while (it.hasNext()) {
                            AdvObject nextObj = it.next();
                            jtaInventory.append("\n- " + nextObj.getName());
                        }
                        jtaInventory.append("\n");
                    }
                    rs.close();
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jlSaveSlot2MouseClicked

    private void jlSaveSlot3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSaveSlot3MouseClicked
        int n = YES_OPTION;
        if (jdSave.getTitle().equalsIgnoreCase("Salva")) {
            if (jlSaveSlot3.getName().equalsIgnoreCase("full")) {
                Object[] options = {"Si", "No"};
                n = JOptionPane.showOptionDialog(this, "Sovrascivere i dati salvati?", "Sovrascrittura", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            }

            if (n == YES_OPTION) {
                jdSave.setVisible(false);

                jtaDisplay.setText("\nSalvataggio in corso...");

                try {
                    boolean flag = false;
                    Connection conn = DriverManager.getConnection("jdbc:h2:./src/main/resources/db/save");
                    Statement stm = conn.createStatement();
                    stm.executeUpdate(HYPNOS_TABLE);

                    ResultSet rs = stm.executeQuery("SELECT * FROM hypnosDb WHERE artId = 3");
                    if (rs.next()) {
                        PreparedStatement pstm = conn.prepareStatement("UPDATE hypnosDb SET currentRoom = ?, inventoryId = ?, riddlesState = ? WHERE artId = 3");
                        pstm.setInt(1, this.game.getCurrentRoom().getId());

                        Iterator<AdvObject> objIt = this.game.getInventory().iterator();
                        String tempObj = "";
                        while (objIt.hasNext()) {
                            flag = true;
                            AdvObject next = objIt.next();
                            tempObj = tempObj + next.getId() + "#";
                        }
                        if (flag) {
                            pstm.setString(2, tempObj);
                        } else {
                            tempObj = null;
                            pstm.setString(2, tempObj);
                        }

                        Iterator<Room> roomIt = this.game.getRooms().iterator();
                        String tempRoom = "";
                        while (roomIt.hasNext()) {
                            Room nextRoom = roomIt.next();

                            if (nextRoom.getId() == 6 || nextRoom.getId() == 15 || nextRoom.getId() == 24 || nextRoom.getId() == 37) {
                                tempRoom = tempRoom + nextRoom.isLocked() + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() == 34) {
                                tempRoom = tempRoom + "true" + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() != 34) {
                                tempRoom = tempRoom + "false" + "#";
                            }
                        }
                        pstm.setString(3, tempRoom + " ");

                        pstm.executeUpdate();
                        pstm.close();

                    } else {

                        PreparedStatement pstm = conn.prepareStatement("INSERT INTO hypnosDb VALUES (?,?,?,?)");
                        pstm.setInt(1, 3);
                        pstm.setInt(2, this.game.getCurrentRoom().getId());

                        Iterator<AdvObject> it = this.game.getInventory().iterator();
                        String tempObj = "";
                        while (it.hasNext()) {
                            flag = true;
                            AdvObject next = it.next();
                            tempObj = tempObj + next.getId() + "#";
                        }

                        if (flag) {
                            pstm.setString(3, tempObj);
                        } else {
                            tempObj = null;
                            pstm.setString(3, tempObj);
                        }

                        Iterator<Room> roomIt = this.game.getRooms().iterator();
                        String tempRoom = "";
                        while (roomIt.hasNext()) {
                            Room nextRoom = roomIt.next();

                            if (nextRoom.getId() == 6 || nextRoom.getId() == 15 || nextRoom.getId() == 24 || nextRoom.getId() == 37) {
                                tempRoom = tempRoom + nextRoom.isLocked() + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() == 34) {
                                tempRoom = tempRoom + "true" + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() != 34) {
                                tempRoom = tempRoom + "false" + "#";
                            }
                        }
                        pstm.setString(4, tempRoom + " ");

                        pstm.executeUpdate();
                        pstm.close();
                    }

                    stm.close();
                    jtaDisplay.append("\nSalvataggio effettuato correttamente!");
                    jlSaveSlot3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/Save_file_on_3.png")));
                    jlSaveSlot3.setName("full");
                } catch (SQLException ex) {
                    System.err.println(ex.getSQLState() + ": " + ex.getMessage());
                    jtaDisplay.append("\nSalvataggio non riuscito");
                }
            }
        } else if (jdSave.getTitle().equalsIgnoreCase("Carica")) {
            if (jlSaveSlot3.getName().equalsIgnoreCase("empty")) {
                JOptionPane.showMessageDialog(this, "In questo slot non sono presenti dati salvati", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                jdSave.setVisible(false);

                jtaDisplay.setText("Caricamento in corso...");
                jtaDisplay.append("\n=========================================================\n");
                String[] objInventory;
                String[] riddleState;
                int i;
                boolean flag = false;

                try {
                    Connection conn = DriverManager.getConnection("jdbc:h2:./src/main/resources/db/save");
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery("SELECT * FROM hypnosDb WHERE artId = 3");

                    if (rs.next()) {
                        Iterator<Room> rm = this.game.getRooms().iterator();
                        while (rm.hasNext()) {
                            Room next = rm.next();

                            if (next.getId() == rs.getInt(2)) {
                                this.game.setCurrentRoom(next);
                                jlMinimap.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathMinimap())));
                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                jtaDisplay.append("Ti trovi in: ");
                                jtaDisplay.append(game.getCurrentRoom().getName());
                                jtaDisplay.append("\n");
                                jtaDisplay.append(game.getCurrentRoom().getDescription());

                            }
                        }

                        if (rs.getString(3) != null) {
                            objInventory = rs.getString(3).split("#");
                            Iterator<Room> roomIt = this.game.getRooms().iterator();
                            while (roomIt.hasNext()) {
                                Room nextRoom = roomIt.next();
                                Iterator<AdvObject> objectIt = nextRoom.getObjects().iterator();
                                while (objectIt.hasNext()) {
                                    AdvObject nextObject = objectIt.next();

                                    for (i = 0; objInventory.length - 1 >= i; i++) {

                                        if (Integer.parseInt(objInventory[i]) == nextObject.getId()) {
                                            this.game.getInventory().add(nextObject);
                                            objectIt.remove();
                                        }

                                    }

                                    if (nextObject instanceof AdvObjectContainer) {
                                        AdvObjectContainer nextObjectContainer = (AdvObjectContainer) nextObject;

                                        if (!nextObjectContainer.getList().isEmpty()) {
                                            Iterator<AdvObject> containerIt = nextObjectContainer.getList().iterator();
                                            while (containerIt.hasNext()) {
                                                AdvObject nextObjContained = containerIt.next();

                                                for (i = 0; objInventory.length - 1 >= i; i++) {

                                                    if (nextObjContained.getId() == Integer.parseInt(objInventory[i])) {
                                                        this.game.getInventory().add(nextObjContained);
                                                        containerIt.remove();
                                                    }

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        if (rs.getString(4) != null) {
                            riddleState = rs.getString(4).split("#");
                            Iterator<Room> roomIt = this.game.getRooms().iterator();
                            while (roomIt.hasNext()) {
                                Room nextRoom = roomIt.next();
                                if (nextRoom.getId() == 6) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[0]));

                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                    while (roomIt2.hasNext()) {
                                        Room nextRoom2 = roomIt2.next();
                                        if (nextRoom2.getId() == 4 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/study_1_unlocked.png");
                                            if (this.game.getCurrentRoom().getId() == 4) {
                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }
                                        }

                                        Iterator<AdvObject> objIt = nextRoom2.getObjects().iterator();
                                        while (objIt.hasNext()) {
                                            AdvObject nextObj = objIt.next();
                                            if (nextObj.getId() == 24) {
                                                objIt.remove();
                                            }
                                        }
                                    }

                                } else if (nextRoom.getId() == 15) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[1]));

                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();

                                    while (roomIt2.hasNext()) {

                                        Room nextRoom2 = roomIt2.next();

                                        if (nextRoom2.getId() == 6 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/stairs_1_unlocked.png");
                                            if (this.game.getCurrentRoom().getId() == 6) {

                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }

                                            Iterator<Room> roomIt3 = this.game.getRooms().iterator();
                                            while (roomIt3.hasNext()) {
                                                Room nextRoom3 = roomIt3.next();
                                                Iterator<AdvObject> objIt = nextRoom3.getObjects().iterator();
                                                while (objIt.hasNext()) {
                                                    AdvObject nextObj = objIt.next();
                                                    if (nextObj.getId() == 67) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 49) {
                                                        nextObj.setOpen(true);
                                                        if (nextObj instanceof AdvObjectContainer) {
                                                            AdvObjectContainer c = (AdvObjectContainer) nextObj;
                                                            if (!c.getList().isEmpty()) {
                                                                Iterator<AdvObject> objContained = c.getList().iterator();
                                                                while (objContained.hasNext()) {
                                                                    AdvObject nextObjContained = objContained.next();
                                                                    if (nextObjContained.getId() == 50) {
                                                                        objContained.remove();
                                                                    }
                                                                }
                                                            }

                                                        }

                                                    }
                                                }
                                            }
                                        }
                                    }

                                } else if (nextRoom.getId() == 24) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[2]));
                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                    while (roomIt2.hasNext()) {
                                        Room nextRoom2 = roomIt2.next();
                                        if (nextRoom2.getId() == 23 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/string_room_unlocked.png");

                                            Iterator<Room> roomIt3 = this.game.getRooms().iterator();
                                            while (roomIt3.hasNext()) {
                                                Room nextRoom3 = roomIt3.next();
                                                Iterator<AdvObject> objIt = nextRoom3.getObjects().iterator();
                                                while (objIt.hasNext()) {
                                                    AdvObject nextObj = objIt.next();
                                                    if (nextObj.getId() == 130) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 95 || nextObj.getId() == 96 || nextObj.getId() == 97 || nextObj.getId() == 98 || nextObj.getId() == 99 || nextObj.getId() == 100) {
                                                        nextObj.setPush(true);
                                                    } else if (nextObj.getId() == 159) {
                                                        nextObj.setDescription("Questo orologio ora indica le 1 a.m.");
                                                    } else if (nextObj.getId() == 160) {
                                                        nextObj.setDescription("Questo orologio ora indica le 3 a.m.");
                                                    } else if (nextObj.getId() == 161) {
                                                        nextObj.setDescription("Questo orologio ora indica le 4 a.m.");
                                                    } else if (nextObj.getId() == 162) {
                                                        nextObj.setDescription("Questo orologio ora indica le 7 a.m.");
                                                    } else if (nextObj.getId() == 163) {
                                                        nextObj.setDescription("Questo orologio ora indica le 2 a.m.");
                                                    } else if (nextObj.getId() == 164) {
                                                        nextObj.setDescription("Questo orologio ora indica le 8 a.m.");
                                                    } else if (nextObj.getId() == 165) {
                                                        nextObj.setDescription("Questo orologio ora indica le 1 a.m.");
                                                    } else if (nextObj.getId() == 166) {
                                                        nextObj.setDescription("Questo orologio ora indica le 6 a.m.");
                                                    } else if (nextObj.getId() == 167) {
                                                        nextObj.setDescription("Questo orologio ora indica le 5 a.m.");
                                                    } else if (nextObj.getId() == 168) {
                                                        nextObj.setDescription("Questo orologio ora indica le 9 a.m.");
                                                    } else if (nextObj.getId() == 169) {
                                                        nextObj.setDescription("Questo orologio ora indica le 2 a.m.");
                                                    }
                                                }

                                                if (nextRoom3.getId() == 19) {
                                                    nextRoom3.setPathView("/img/View/library_burnt.png");
                                                } else if (nextRoom3.getId() == 16) {
                                                    nextRoom3.setPathView("/img/View/mosaic_room_solved.png");
                                                }
                                            }

                                            if (this.game.getCurrentRoom().getId() == 16 || this.game.getCurrentRoom().getId() == 19 || this.game.getCurrentRoom().getId() == 23) {
                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }

                                        }
                                    }

                                } else if (nextRoom.getId() == 34) {
                                    if (Boolean.parseBoolean(riddleState[3]) == false) {
                                        Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                        while (roomIt2.hasNext()) {
                                            Room nextRoom2 = roomIt2.next();
                                            if (nextRoom2.getId() == 35) {
                                                nextRoom.setEast(nextRoom2);
                                            }

                                            Iterator<AdvObject> objIt = nextRoom2.getObjects().iterator();
                                            while (objIt.hasNext()) {
                                                AdvObject nextObj = objIt.next();

                                                if (nextObj.getId() == 188) {
                                                    nextObj.setDescription("La radio trasmette a intermittenza i numeri 1, 2, 2, 0, 3, 1, 3, 0, 6, 1, 0");
                                                } else if (nextObj.getId() == 144) {
                                                    objIt.remove();
                                                }
                                            }
                                        }
                                    }

                                } else if (nextRoom.getId() == 37) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[4]));
                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                    while (roomIt2.hasNext()) {
                                        Room nextRoom2 = roomIt2.next();

                                        if (nextRoom2.getId() == 36 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/mirror_room_3.png");

                                            Iterator<Room> roomIt3 = this.game.getRooms().iterator();
                                            while (roomIt3.hasNext()) {
                                                Room nextRoom3 = roomIt3.next();
                                                Iterator<AdvObject> objIt = nextRoom3.getObjects().iterator();
                                                while (objIt.hasNext()) {
                                                    AdvObject nextObj = objIt.next();
                                                    if (nextObj.getId() == 158) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 184) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 171) {

                                                        if (nextObj instanceof AdvObjectContainer) {
                                                            AdvObjectContainer c = (AdvObjectContainer) nextObj;
                                                            if (!c.getList().isEmpty()) {
                                                                Iterator<AdvObject> objContained = c.getList().iterator();
                                                                while (objContained.hasNext()) {
                                                                    AdvObject nextObjContained = objContained.next();
                                                                    if (nextObjContained.getId() == 172) {
                                                                        objContained.remove();
                                                                    }
                                                                }
                                                            }

                                                        }

                                                    }
                                                }

                                                if (nextRoom3.getId() == 27) {
                                                    nextRoom3.setPathView("/img/View/barrel_room_nvg.png");
                                                } else if (nextRoom3.getId() == 28) {
                                                    nextRoom3.setPathView("/img/View/winter_room_bucketless.png");
                                                } else if (nextRoom3.getId() == 33) {
                                                    nextRoom3.setPathView("/img/View/mannequin_room_bulb.png");
                                                }
                                            }

                                            if (this.game.getCurrentRoom().getId() == 27 || this.game.getCurrentRoom().getId() == 28 || this.game.getCurrentRoom().getId() == 33 || this.game.getCurrentRoom().getId() == 36) {
                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        jtaInventory.setText("\t\tInventario");
                        jtaInventory.append("\n----------------------");
                        Iterator<AdvObject> it = this.game.getInventory().iterator();
                        while (it.hasNext()) {
                            AdvObject nextObj = it.next();
                            jtaInventory.append("\n- " + nextObj.getName());
                        }
                        jtaInventory.append("\n");
                    }
                    rs.close();
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jlSaveSlot3MouseClicked

    private void jlSaveSlot4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSaveSlot4MouseClicked
        int n = YES_OPTION;
        if (jdSave.getTitle().equalsIgnoreCase("Salva")) {
            if (jlSaveSlot4.getName().equalsIgnoreCase("full")) {
                Object[] options = {"Si", "No"};
                n = JOptionPane.showOptionDialog(this, "Sovrascivere i dati salvati?", "Sovrascrittura", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            }

            if (n == YES_OPTION) {
                jdSave.setVisible(false);

                jtaDisplay.setText("\nSalvataggio in corso...");

                try {
                    boolean flag = false;
                    Connection conn = DriverManager.getConnection("jdbc:h2:./src/main/resources/db/save");
                    Statement stm = conn.createStatement();
                    stm.executeUpdate(HYPNOS_TABLE);

                    ResultSet rs = stm.executeQuery("SELECT * FROM hypnosDb WHERE artId = 4");
                    if (rs.next()) {
                        PreparedStatement pstm = conn.prepareStatement("UPDATE hypnosDb SET currentRoom = ?, inventoryId = ?, riddlesState = ? WHERE artId = 4");
                        pstm.setInt(1, this.game.getCurrentRoom().getId());

                        Iterator<AdvObject> objIt = this.game.getInventory().iterator();
                        String tempObj = "";
                        while (objIt.hasNext()) {
                            flag = true;
                            AdvObject next = objIt.next();
                            tempObj = tempObj + next.getId() + "#";
                        }
                        if (flag) {
                            pstm.setString(2, tempObj);
                        } else {
                            tempObj = null;
                            pstm.setString(2, tempObj);
                        }

                        Iterator<Room> roomIt = this.game.getRooms().iterator();
                        String tempRoom = "";
                        while (roomIt.hasNext()) {
                            Room nextRoom = roomIt.next();

                            if (nextRoom.getId() == 6 || nextRoom.getId() == 15 || nextRoom.getId() == 24 || nextRoom.getId() == 37) {
                                tempRoom = tempRoom + nextRoom.isLocked() + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() == 34) {
                                tempRoom = tempRoom + "true" + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() != 34) {
                                tempRoom = tempRoom + "false" + "#";
                            }
                        }
                        pstm.setString(3, tempRoom + " ");

                        pstm.executeUpdate();
                        pstm.close();

                    } else {

                        PreparedStatement pstm = conn.prepareStatement("INSERT INTO hypnosDb VALUES (?,?,?,?)");
                        pstm.setInt(1, 4);
                        pstm.setInt(2, this.game.getCurrentRoom().getId());

                        Iterator<AdvObject> it = this.game.getInventory().iterator();
                        String tempObj = "";
                        while (it.hasNext()) {
                            flag = true;
                            AdvObject next = it.next();
                            tempObj = tempObj + next.getId() + "#";
                        }

                        if (flag) {
                            pstm.setString(3, tempObj);
                        } else {
                            tempObj = null;
                            pstm.setString(3, tempObj);
                        }

                        Iterator<Room> roomIt = this.game.getRooms().iterator();
                        String tempRoom = "";
                        while (roomIt.hasNext()) {
                            Room nextRoom = roomIt.next();

                            if (nextRoom.getId() == 6 || nextRoom.getId() == 15 || nextRoom.getId() == 24 || nextRoom.getId() == 37) {
                                tempRoom = tempRoom + nextRoom.isLocked() + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() == 34) {
                                tempRoom = tempRoom + "true" + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() != 34) {
                                tempRoom = tempRoom + "false" + "#";
                            }
                        }
                        pstm.setString(4, tempRoom + " ");

                        pstm.executeUpdate();
                        pstm.close();
                    }

                    stm.close();
                    jtaDisplay.append("\nSalvataggio effettuato correttamente!");
                    jlSaveSlot4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/Save_file_on_4.png")));
                    jlSaveSlot4.setName("full");
                } catch (SQLException ex) {
                    System.err.println(ex.getSQLState() + ": " + ex.getMessage());
                    jtaDisplay.append("\nSalvataggio non riuscito");
                }
            }
        } else if (jdSave.getTitle().equalsIgnoreCase("Carica")) {
            if (jlSaveSlot4.getName().equalsIgnoreCase("empty")) {
                JOptionPane.showMessageDialog(this, "In questo slot non sono presenti dati salvati", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                jdSave.setVisible(false);

                jtaDisplay.setText("Caricamento in corso...");
                jtaDisplay.append("\n=========================================================\n");
                String[] objInventory;
                String[] riddleState;
                int i;
                boolean flag = false;

                try {
                    Connection conn = DriverManager.getConnection("jdbc:h2:./src/main/resources/db/save");
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery("SELECT * FROM hypnosDb WHERE artId = 4");

                    if (rs.next()) {
                        Iterator<Room> rm = this.game.getRooms().iterator();
                        while (rm.hasNext()) {
                            Room next = rm.next();

                            if (next.getId() == rs.getInt(2)) {
                                this.game.setCurrentRoom(next);
                                jlMinimap.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathMinimap())));
                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                jtaDisplay.append("Ti trovi in: ");
                                jtaDisplay.append(game.getCurrentRoom().getName());
                                jtaDisplay.append("\n");
                                jtaDisplay.append(game.getCurrentRoom().getDescription());

                            }
                        }

                        if (rs.getString(3) != null) {
                            objInventory = rs.getString(3).split("#");
                            Iterator<Room> roomIt = this.game.getRooms().iterator();
                            while (roomIt.hasNext()) {
                                Room nextRoom = roomIt.next();
                                Iterator<AdvObject> objectIt = nextRoom.getObjects().iterator();
                                while (objectIt.hasNext()) {
                                    AdvObject nextObject = objectIt.next();

                                    for (i = 0; objInventory.length - 1 >= i; i++) {

                                        if (Integer.parseInt(objInventory[i]) == nextObject.getId()) {
                                            this.game.getInventory().add(nextObject);
                                            objectIt.remove();
                                        }

                                    }

                                    if (nextObject instanceof AdvObjectContainer) {
                                        AdvObjectContainer nextObjectContainer = (AdvObjectContainer) nextObject;

                                        if (!nextObjectContainer.getList().isEmpty()) {
                                            Iterator<AdvObject> containerIt = nextObjectContainer.getList().iterator();
                                            while (containerIt.hasNext()) {
                                                AdvObject nextObjContained = containerIt.next();

                                                for (i = 0; objInventory.length - 1 >= i; i++) {

                                                    if (nextObjContained.getId() == Integer.parseInt(objInventory[i])) {
                                                        this.game.getInventory().add(nextObjContained);
                                                        containerIt.remove();
                                                    }

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        if (rs.getString(4) != null) {
                            riddleState = rs.getString(4).split("#");
                            Iterator<Room> roomIt = this.game.getRooms().iterator();
                            while (roomIt.hasNext()) {
                                Room nextRoom = roomIt.next();
                                if (nextRoom.getId() == 6) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[0]));

                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                    while (roomIt2.hasNext()) {
                                        Room nextRoom2 = roomIt2.next();
                                        if (nextRoom2.getId() == 4 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/study_1_unlocked.png");
                                            if (this.game.getCurrentRoom().getId() == 4) {
                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }
                                        }

                                        Iterator<AdvObject> objIt = nextRoom2.getObjects().iterator();
                                        while (objIt.hasNext()) {
                                            AdvObject nextObj = objIt.next();
                                            if (nextObj.getId() == 24) {
                                                objIt.remove();
                                            }
                                        }
                                    }

                                } else if (nextRoom.getId() == 15) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[1]));

                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();

                                    while (roomIt2.hasNext()) {

                                        Room nextRoom2 = roomIt2.next();

                                        if (nextRoom2.getId() == 6 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/stairs_1_unlocked.png");
                                            if (this.game.getCurrentRoom().getId() == 6) {

                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }

                                            Iterator<Room> roomIt3 = this.game.getRooms().iterator();
                                            while (roomIt3.hasNext()) {
                                                Room nextRoom3 = roomIt3.next();
                                                Iterator<AdvObject> objIt = nextRoom3.getObjects().iterator();
                                                while (objIt.hasNext()) {
                                                    AdvObject nextObj = objIt.next();
                                                    if (nextObj.getId() == 67) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 49) {
                                                        nextObj.setOpen(true);
                                                        if (nextObj instanceof AdvObjectContainer) {
                                                            AdvObjectContainer c = (AdvObjectContainer) nextObj;
                                                            if (!c.getList().isEmpty()) {
                                                                Iterator<AdvObject> objContained = c.getList().iterator();
                                                                while (objContained.hasNext()) {
                                                                    AdvObject nextObjContained = objContained.next();
                                                                    if (nextObjContained.getId() == 50) {
                                                                        objContained.remove();
                                                                    }
                                                                }
                                                            }

                                                        }

                                                    }
                                                }
                                            }
                                        }
                                    }

                                } else if (nextRoom.getId() == 24) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[2]));
                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                    while (roomIt2.hasNext()) {
                                        Room nextRoom2 = roomIt2.next();
                                        if (nextRoom2.getId() == 23 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/string_room_unlocked.png"); //CAMBIARE IL PATH DELLA STRING ROOM

                                            Iterator<Room> roomIt3 = this.game.getRooms().iterator();
                                            while (roomIt3.hasNext()) {
                                                Room nextRoom3 = roomIt3.next();
                                                Iterator<AdvObject> objIt = nextRoom3.getObjects().iterator();
                                                while (objIt.hasNext()) {
                                                    AdvObject nextObj = objIt.next();
                                                    if (nextObj.getId() == 130) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 95 || nextObj.getId() == 96 || nextObj.getId() == 97 || nextObj.getId() == 98 || nextObj.getId() == 99 || nextObj.getId() == 100) {
                                                        nextObj.setPush(true);
                                                    } else if (nextObj.getId() == 159) {
                                                        nextObj.setDescription("Questo orologio ora indica le 1 a.m.");
                                                    } else if (nextObj.getId() == 160) {
                                                        nextObj.setDescription("Questo orologio ora indica le 3 a.m.");
                                                    } else if (nextObj.getId() == 161) {
                                                        nextObj.setDescription("Questo orologio ora indica le 4 a.m.");
                                                    } else if (nextObj.getId() == 162) {
                                                        nextObj.setDescription("Questo orologio ora indica le 7 a.m.");
                                                    } else if (nextObj.getId() == 163) {
                                                        nextObj.setDescription("Questo orologio ora indica le 2 a.m.");
                                                    } else if (nextObj.getId() == 164) {
                                                        nextObj.setDescription("Questo orologio ora indica le 8 a.m.");
                                                    } else if (nextObj.getId() == 165) {
                                                        nextObj.setDescription("Questo orologio ora indica le 1 a.m.");
                                                    } else if (nextObj.getId() == 166) {
                                                        nextObj.setDescription("Questo orologio ora indica le 6 a.m.");
                                                    } else if (nextObj.getId() == 167) {
                                                        nextObj.setDescription("Questo orologio ora indica le 5 a.m.");
                                                    } else if (nextObj.getId() == 168) {
                                                        nextObj.setDescription("Questo orologio ora indica le 9 a.m.");
                                                    } else if (nextObj.getId() == 169) {
                                                        nextObj.setDescription("Questo orologio ora indica le 2 a.m.");
                                                    }
                                                }

                                                if (nextRoom3.getId() == 19) {
                                                    nextRoom3.setPathView("/img/View/library_burnt.png");
                                                } else if (nextRoom3.getId() == 16) {
                                                    nextRoom3.setPathView("/img/View/mosaic_room_solved.png");
                                                }
                                            }

                                            if (this.game.getCurrentRoom().getId() == 16 || this.game.getCurrentRoom().getId() == 19 || this.game.getCurrentRoom().getId() == 23) {
                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }

                                        }
                                    }

                                } else if (nextRoom.getId() == 34) {
                                    if (Boolean.parseBoolean(riddleState[3]) == false) {
                                        Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                        while (roomIt2.hasNext()) {
                                            Room nextRoom2 = roomIt2.next();
                                            if (nextRoom2.getId() == 35) {
                                                nextRoom.setEast(nextRoom2);
                                            }

                                            Iterator<AdvObject> objIt = nextRoom2.getObjects().iterator();
                                            while (objIt.hasNext()) {
                                                AdvObject nextObj = objIt.next();

                                                if (nextObj.getId() == 188) {
                                                    nextObj.setDescription("La radio trasmette a intermittenza i numeri 1, 2, 2, 0, 3, 1, 3, 0, 6, 1, 0");
                                                } else if (nextObj.getId() == 144) {
                                                    objIt.remove();
                                                }
                                            }
                                        }
                                    }

                                } else if (nextRoom.getId() == 37) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[4]));
                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                    while (roomIt2.hasNext()) {
                                        Room nextRoom2 = roomIt2.next();

                                        if (nextRoom2.getId() == 36 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/mirror_room_3.png");

                                            Iterator<Room> roomIt3 = this.game.getRooms().iterator();
                                            while (roomIt3.hasNext()) {
                                                Room nextRoom3 = roomIt3.next();
                                                Iterator<AdvObject> objIt = nextRoom3.getObjects().iterator();
                                                while (objIt.hasNext()) {
                                                    AdvObject nextObj = objIt.next();
                                                    if (nextObj.getId() == 158) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 184) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 171) {

                                                        if (nextObj instanceof AdvObjectContainer) {
                                                            AdvObjectContainer c = (AdvObjectContainer) nextObj;
                                                            if (!c.getList().isEmpty()) {
                                                                Iterator<AdvObject> objContained = c.getList().iterator();
                                                                while (objContained.hasNext()) {
                                                                    AdvObject nextObjContained = objContained.next();
                                                                    if (nextObjContained.getId() == 172) {
                                                                        objContained.remove();
                                                                    }
                                                                }
                                                            }

                                                        }

                                                    }
                                                }

                                                if (nextRoom3.getId() == 27) {
                                                    nextRoom3.setPathView("/img/View/barrel_room_nvg.png");
                                                } else if (nextRoom3.getId() == 28) {
                                                    nextRoom3.setPathView("/img/View/winter_room_bucketless.png");
                                                } else if (nextRoom3.getId() == 33) {
                                                    nextRoom3.setPathView("/img/View/mannequin_room_bulb.png");
                                                }
                                            }

                                            if (this.game.getCurrentRoom().getId() == 27 || this.game.getCurrentRoom().getId() == 28 || this.game.getCurrentRoom().getId() == 33 || this.game.getCurrentRoom().getId() == 36) {
                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        jtaInventory.setText("\t\tInventario");
                        jtaInventory.append("\n----------------------");
                        Iterator<AdvObject> it = this.game.getInventory().iterator();
                        while (it.hasNext()) {
                            AdvObject nextObj = it.next();
                            jtaInventory.append("\n- " + nextObj.getName());
                        }
                        jtaInventory.append("\n");
                    }
                    rs.close();
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jlSaveSlot4MouseClicked

    private void jlSaveSlot5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSaveSlot5MouseClicked
        int n = YES_OPTION;
        if (jdSave.getTitle().equalsIgnoreCase("Salva")) {
            if (jlSaveSlot5.getName().equalsIgnoreCase("full")) {
                Object[] options = {"Si", "No"};
                n = JOptionPane.showOptionDialog(this, "Sovrascivere i dati salvati?", "Sovrascrittura", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            }

            if (n == YES_OPTION) {
                jdSave.setVisible(false);

                jtaDisplay.setText("\nSalvataggio in corso...");

                try {
                    boolean flag = false;
                    Connection conn = DriverManager.getConnection("jdbc:h2:./src/main/resources/db/save");
                    Statement stm = conn.createStatement();
                    stm.executeUpdate(HYPNOS_TABLE);

                    ResultSet rs = stm.executeQuery("SELECT * FROM hypnosDb WHERE artId = 5");
                    if (rs.next()) {
                        PreparedStatement pstm = conn.prepareStatement("UPDATE hypnosDb SET currentRoom = ?, inventoryId = ?, riddlesState = ? WHERE artId = 5");
                        pstm.setInt(1, this.game.getCurrentRoom().getId());

                        Iterator<AdvObject> objIt = this.game.getInventory().iterator();
                        String tempObj = "";
                        while (objIt.hasNext()) {
                            flag = true;
                            AdvObject next = objIt.next();
                            tempObj = tempObj + next.getId() + "#";
                        }
                        if (flag) {
                            pstm.setString(2, tempObj);
                        } else {
                            tempObj = null;
                            pstm.setString(2, tempObj);
                        }

                        Iterator<Room> roomIt = this.game.getRooms().iterator();
                        String tempRoom = "";
                        while (roomIt.hasNext()) {
                            Room nextRoom = roomIt.next();

                            if (nextRoom.getId() == 6 || nextRoom.getId() == 15 || nextRoom.getId() == 24 || nextRoom.getId() == 37) {
                                tempRoom = tempRoom + nextRoom.isLocked() + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() == 34) {
                                tempRoom = tempRoom + "true" + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() != 34) {
                                tempRoom = tempRoom + "false" + "#";
                            }
                        }
                        pstm.setString(3, tempRoom + " ");

                        pstm.executeUpdate();
                        pstm.close();

                    } else {

                        PreparedStatement pstm = conn.prepareStatement("INSERT INTO hypnosDb VALUES (?,?,?,?)");
                        pstm.setInt(1, 5);
                        pstm.setInt(2, this.game.getCurrentRoom().getId());

                        Iterator<AdvObject> it = this.game.getInventory().iterator();
                        String tempObj = "";
                        while (it.hasNext()) {
                            flag = true;
                            AdvObject next = it.next();
                            tempObj = tempObj + next.getId() + "#";
                        }

                        if (flag) {
                            pstm.setString(3, tempObj);
                        } else {
                            tempObj = null;
                            pstm.setString(3, tempObj);
                        }

                        Iterator<Room> roomIt = this.game.getRooms().iterator();
                        String tempRoom = "";
                        while (roomIt.hasNext()) {
                            Room nextRoom = roomIt.next();

                            if (nextRoom.getId() == 6 || nextRoom.getId() == 15 || nextRoom.getId() == 24 || nextRoom.getId() == 37) {
                                tempRoom = tempRoom + nextRoom.isLocked() + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() == 34) {
                                tempRoom = tempRoom + "true" + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() != 34) {
                                tempRoom = tempRoom + "false" + "#";
                            }
                        }
                        pstm.setString(4, tempRoom + " ");

                        pstm.executeUpdate();
                        pstm.close();
                    }

                    stm.close();
                    jtaDisplay.append("\nSalvataggio effettuato correttamente!");
                    jlSaveSlot5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/Save_file_on_5.png")));
                    jlSaveSlot5.setName("full");
                } catch (SQLException ex) {
                    System.err.println(ex.getSQLState() + ": " + ex.getMessage());
                    jtaDisplay.append("\nSalvataggio non riuscito");
                }
            }
        } else if (jdSave.getTitle().equalsIgnoreCase("Carica")) {
            if (jlSaveSlot5.getName().equalsIgnoreCase("empty")) {
                JOptionPane.showMessageDialog(this, "In questo slot non sono presenti dati salvati", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                jdSave.setVisible(false);

                jtaDisplay.setText("Caricamento in corso...");
                jtaDisplay.append("\n=========================================================\n");
                String[] objInventory;
                String[] riddleState;
                int i;
                boolean flag = false;

                try {
                    Connection conn = DriverManager.getConnection("jdbc:h2:./src/main/resources/db/save");
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery("SELECT * FROM hypnosDb WHERE artId = 5");

                    if (rs.next()) {
                        Iterator<Room> rm = this.game.getRooms().iterator();
                        while (rm.hasNext()) {
                            Room next = rm.next();

                            if (next.getId() == rs.getInt(2)) {
                                this.game.setCurrentRoom(next);
                                jlMinimap.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathMinimap())));
                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                jtaDisplay.append("Ti trovi in: ");
                                jtaDisplay.append(game.getCurrentRoom().getName());
                                jtaDisplay.append("\n");
                                jtaDisplay.append(game.getCurrentRoom().getDescription());

                            }
                        }

                        if (rs.getString(3) != null) {
                            objInventory = rs.getString(3).split("#");
                            Iterator<Room> roomIt = this.game.getRooms().iterator();
                            while (roomIt.hasNext()) {
                                Room nextRoom = roomIt.next();
                                Iterator<AdvObject> objectIt = nextRoom.getObjects().iterator();
                                while (objectIt.hasNext()) {
                                    AdvObject nextObject = objectIt.next();

                                    for (i = 0; objInventory.length - 1 >= i; i++) {

                                        if (Integer.parseInt(objInventory[i]) == nextObject.getId()) {
                                            this.game.getInventory().add(nextObject);
                                            objectIt.remove();
                                        }

                                    }

                                    if (nextObject instanceof AdvObjectContainer) {
                                        AdvObjectContainer nextObjectContainer = (AdvObjectContainer) nextObject;

                                        if (!nextObjectContainer.getList().isEmpty()) {
                                            Iterator<AdvObject> containerIt = nextObjectContainer.getList().iterator();
                                            while (containerIt.hasNext()) {
                                                AdvObject nextObjContained = containerIt.next();

                                                for (i = 0; objInventory.length - 1 >= i; i++) {

                                                    if (nextObjContained.getId() == Integer.parseInt(objInventory[i])) {
                                                        this.game.getInventory().add(nextObjContained);
                                                        containerIt.remove();
                                                    }

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        if (rs.getString(4) != null) {
                            riddleState = rs.getString(4).split("#");
                            Iterator<Room> roomIt = this.game.getRooms().iterator();
                            while (roomIt.hasNext()) {
                                Room nextRoom = roomIt.next();
                                if (nextRoom.getId() == 6) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[0]));

                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                    while (roomIt2.hasNext()) {
                                        Room nextRoom2 = roomIt2.next();
                                        if (nextRoom2.getId() == 4 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/study_1_unlocked.png");
                                            if (this.game.getCurrentRoom().getId() == 4) {
                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }
                                        }

                                        Iterator<AdvObject> objIt = nextRoom2.getObjects().iterator();
                                        while (objIt.hasNext()) {
                                            AdvObject nextObj = objIt.next();
                                            if (nextObj.getId() == 24) {
                                                objIt.remove();
                                            }
                                        }
                                    }

                                } else if (nextRoom.getId() == 15) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[1]));

                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();

                                    while (roomIt2.hasNext()) {

                                        Room nextRoom2 = roomIt2.next();

                                        if (nextRoom2.getId() == 6 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/stairs_1_unlocked.png");
                                            if (this.game.getCurrentRoom().getId() == 6) {

                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }

                                            Iterator<Room> roomIt3 = this.game.getRooms().iterator();
                                            while (roomIt3.hasNext()) {
                                                Room nextRoom3 = roomIt3.next();
                                                Iterator<AdvObject> objIt = nextRoom3.getObjects().iterator();
                                                while (objIt.hasNext()) {
                                                    AdvObject nextObj = objIt.next();
                                                    if (nextObj.getId() == 67) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 49) {
                                                        nextObj.setOpen(true);
                                                        if (nextObj instanceof AdvObjectContainer) {
                                                            AdvObjectContainer c = (AdvObjectContainer) nextObj;
                                                            if (!c.getList().isEmpty()) {
                                                                Iterator<AdvObject> objContained = c.getList().iterator();
                                                                while (objContained.hasNext()) {
                                                                    AdvObject nextObjContained = objContained.next();
                                                                    if (nextObjContained.getId() == 50) {
                                                                        objContained.remove();
                                                                    }
                                                                }
                                                            }

                                                        }

                                                    }
                                                }
                                            }
                                        }
                                    }

                                } else if (nextRoom.getId() == 24) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[2]));
                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                    while (roomIt2.hasNext()) {
                                        Room nextRoom2 = roomIt2.next();
                                        if (nextRoom2.getId() == 23 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/string_room_unlocked.png"); //CAMBIARE IL PATH DELLA STRING ROOM

                                            Iterator<Room> roomIt3 = this.game.getRooms().iterator();
                                            while (roomIt3.hasNext()) {
                                                Room nextRoom3 = roomIt3.next();
                                                Iterator<AdvObject> objIt = nextRoom3.getObjects().iterator();
                                                while (objIt.hasNext()) {
                                                    AdvObject nextObj = objIt.next();
                                                    if (nextObj.getId() == 130) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 95 || nextObj.getId() == 96 || nextObj.getId() == 97 || nextObj.getId() == 98 || nextObj.getId() == 99 || nextObj.getId() == 100) {
                                                        nextObj.setPush(true);
                                                    } else if (nextObj.getId() == 159) {
                                                        nextObj.setDescription("Questo orologio ora indica le 1 a.m.");
                                                    } else if (nextObj.getId() == 160) {
                                                        nextObj.setDescription("Questo orologio ora indica le 3 a.m.");
                                                    } else if (nextObj.getId() == 161) {
                                                        nextObj.setDescription("Questo orologio ora indica le 4 a.m.");
                                                    } else if (nextObj.getId() == 162) {
                                                        nextObj.setDescription("Questo orologio ora indica le 7 a.m.");
                                                    } else if (nextObj.getId() == 163) {
                                                        nextObj.setDescription("Questo orologio ora indica le 2 a.m.");
                                                    } else if (nextObj.getId() == 164) {
                                                        nextObj.setDescription("Questo orologio ora indica le 8 a.m.");
                                                    } else if (nextObj.getId() == 165) {
                                                        nextObj.setDescription("Questo orologio ora indica le 1 a.m.");
                                                    } else if (nextObj.getId() == 166) {
                                                        nextObj.setDescription("Questo orologio ora indica le 6 a.m.");
                                                    } else if (nextObj.getId() == 167) {
                                                        nextObj.setDescription("Questo orologio ora indica le 5 a.m.");
                                                    } else if (nextObj.getId() == 168) {
                                                        nextObj.setDescription("Questo orologio ora indica le 9 a.m.");
                                                    } else if (nextObj.getId() == 169) {
                                                        nextObj.setDescription("Questo orologio ora indica le 2 a.m.");
                                                    }
                                                }

                                                if (nextRoom3.getId() == 19) {
                                                    nextRoom3.setPathView("/img/View/library_burnt.png");
                                                } else if (nextRoom3.getId() == 16) {
                                                    nextRoom3.setPathView("/img/View/mosaic_room_solved.png");
                                                }
                                            }

                                            if (this.game.getCurrentRoom().getId() == 16 || this.game.getCurrentRoom().getId() == 19 || this.game.getCurrentRoom().getId() == 23) {
                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }

                                        }
                                    }

                                } else if (nextRoom.getId() == 34) {
                                    if (Boolean.parseBoolean(riddleState[3]) == false) {
                                        Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                        while (roomIt2.hasNext()) {
                                            Room nextRoom2 = roomIt2.next();
                                            if (nextRoom2.getId() == 35) {
                                                nextRoom.setEast(nextRoom2);
                                            }

                                            Iterator<AdvObject> objIt = nextRoom2.getObjects().iterator();
                                            while (objIt.hasNext()) {
                                                AdvObject nextObj = objIt.next();

                                                if (nextObj.getId() == 188) {
                                                    nextObj.setDescription("La radio trasmette a intermittenza i numeri 1, 2, 2, 0, 3, 1, 3, 0, 6, 1, 0");
                                                } else if (nextObj.getId() == 144) {
                                                    objIt.remove();
                                                }
                                            }
                                        }
                                    }

                                } else if (nextRoom.getId() == 37) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[4]));
                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                    while (roomIt2.hasNext()) {
                                        Room nextRoom2 = roomIt2.next();

                                        if (nextRoom2.getId() == 36 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/mirror_room_3.png");

                                            Iterator<Room> roomIt3 = this.game.getRooms().iterator();
                                            while (roomIt3.hasNext()) {
                                                Room nextRoom3 = roomIt3.next();
                                                Iterator<AdvObject> objIt = nextRoom3.getObjects().iterator();
                                                while (objIt.hasNext()) {
                                                    AdvObject nextObj = objIt.next();
                                                    if (nextObj.getId() == 158) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 184) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 171) {

                                                        if (nextObj instanceof AdvObjectContainer) {
                                                            AdvObjectContainer c = (AdvObjectContainer) nextObj;
                                                            if (!c.getList().isEmpty()) {
                                                                Iterator<AdvObject> objContained = c.getList().iterator();
                                                                while (objContained.hasNext()) {
                                                                    AdvObject nextObjContained = objContained.next();
                                                                    if (nextObjContained.getId() == 172) {
                                                                        objContained.remove();
                                                                    }
                                                                }
                                                            }

                                                        }

                                                    }
                                                }

                                                if (nextRoom3.getId() == 27) {
                                                    nextRoom3.setPathView("/img/View/barrel_room_nvg.png");
                                                } else if (nextRoom3.getId() == 28) {
                                                    nextRoom3.setPathView("/img/View/winter_room_bucketless.png");
                                                } else if (nextRoom3.getId() == 33) {
                                                    nextRoom3.setPathView("/img/View/mannequin_room_bulb.png");
                                                }
                                            }

                                            if (this.game.getCurrentRoom().getId() == 27 || this.game.getCurrentRoom().getId() == 28 || this.game.getCurrentRoom().getId() == 33 || this.game.getCurrentRoom().getId() == 36) {
                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        jtaInventory.setText("\t\tInventario");
                        jtaInventory.append("\n----------------------");
                        Iterator<AdvObject> it = this.game.getInventory().iterator();
                        while (it.hasNext()) {
                            AdvObject nextObj = it.next();
                            jtaInventory.append("\n- " + nextObj.getName());
                        }
                        jtaInventory.append("\n");
                    }
                    rs.close();
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jlSaveSlot5MouseClicked

    private void jlSaveSlot6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSaveSlot6MouseClicked
        int n = YES_OPTION;
        if (jdSave.getTitle().equalsIgnoreCase("Salva")) {
            if (jlSaveSlot6.getName().equalsIgnoreCase("full")) {
                Object[] options = {"Si", "No"};
                n = JOptionPane.showOptionDialog(this, "Sovrascivere i dati salvati?", "Sovrascrittura", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            }

            if (n == YES_OPTION) {
                jdSave.setVisible(false);

                jtaDisplay.setText("\nSalvataggio in corso...");

                try {
                    boolean flag = false;
                    Connection conn = DriverManager.getConnection("jdbc:h2:./src/main/resources/db/save");
                    Statement stm = conn.createStatement();
                    stm.executeUpdate(HYPNOS_TABLE);

                    ResultSet rs = stm.executeQuery("SELECT * FROM hypnosDb WHERE artId = 6");
                    if (rs.next()) {
                        PreparedStatement pstm = conn.prepareStatement("UPDATE hypnosDb SET currentRoom = ?, inventoryId = ?, riddlesState = ? WHERE artId = 6");
                        pstm.setInt(1, this.game.getCurrentRoom().getId());

                        Iterator<AdvObject> objIt = this.game.getInventory().iterator();
                        String tempObj = "";
                        while (objIt.hasNext()) {
                            flag = true;
                            AdvObject next = objIt.next();
                            tempObj = tempObj + next.getId() + "#";
                        }
                        if (flag) {
                            pstm.setString(2, tempObj);
                        } else {
                            tempObj = null;
                            pstm.setString(2, tempObj);
                        }

                        Iterator<Room> roomIt = this.game.getRooms().iterator();
                        String tempRoom = "";
                        while (roomIt.hasNext()) {
                            Room nextRoom = roomIt.next();

                            if (nextRoom.getId() == 6 || nextRoom.getId() == 15 || nextRoom.getId() == 24 || nextRoom.getId() == 37) {
                                tempRoom = tempRoom + nextRoom.isLocked() + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() == 34) {
                                tempRoom = tempRoom + "true" + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() != 34) {
                                tempRoom = tempRoom + "false" + "#";
                            }
                        }
                        pstm.setString(3, tempRoom + " ");

                        pstm.executeUpdate();
                        pstm.close();

                    } else {

                        PreparedStatement pstm = conn.prepareStatement("INSERT INTO hypnosDb VALUES (?,?,?,?)");
                        pstm.setInt(1, 6);
                        pstm.setInt(2, this.game.getCurrentRoom().getId());

                        Iterator<AdvObject> it = this.game.getInventory().iterator();
                        String tempObj = "";
                        while (it.hasNext()) {
                            flag = true;
                            AdvObject next = it.next();
                            tempObj = tempObj + next.getId() + "#";
                        }

                        if (flag) {
                            pstm.setString(3, tempObj);
                        } else {
                            tempObj = null;
                            pstm.setString(3, tempObj);
                        }

                        Iterator<Room> roomIt = this.game.getRooms().iterator();
                        String tempRoom = "";
                        while (roomIt.hasNext()) {
                            Room nextRoom = roomIt.next();

                            if (nextRoom.getId() == 6 || nextRoom.getId() == 15 || nextRoom.getId() == 24 || nextRoom.getId() == 37) {
                                tempRoom = tempRoom + nextRoom.isLocked() + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() == 34) {
                                tempRoom = tempRoom + "true" + "#";
                            } else if (nextRoom.getId() == 34 && nextRoom.getEast().getId() != 34) {
                                tempRoom = tempRoom + "false" + "#";
                            }
                        }
                        pstm.setString(4, tempRoom + " ");

                        pstm.executeUpdate();
                        pstm.close();
                    }

                    stm.close();
                    jtaDisplay.append("\nSalvataggio effettuato correttamente!");
                    jlSaveSlot6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/Save_file_on_6.png")));
                    jlSaveSlot6.setName("full");
                } catch (SQLException ex) {
                    System.err.println(ex.getSQLState() + ": " + ex.getMessage());
                    jtaDisplay.append("\nSalvataggio non riuscito");
                }
            }
        } else if (jdSave.getTitle().equalsIgnoreCase("Carica")) {
            if (jlSaveSlot6.getName().equalsIgnoreCase("empty")) {
                JOptionPane.showMessageDialog(this, "In questo slot non sono presenti dati salvati", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                jdSave.setVisible(false);

                jtaDisplay.setText("Caricamento in corso...");
                jtaDisplay.append("\n=========================================================\n");
                String[] objInventory;
                String[] riddleState;
                int i;
                boolean flag = false;

                try {
                    Connection conn = DriverManager.getConnection("jdbc:h2:./src/main/resources/db/save");
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery("SELECT * FROM hypnosDb WHERE artId = 6");

                    if (rs.next()) {
                        Iterator<Room> rm = this.game.getRooms().iterator();
                        while (rm.hasNext()) {
                            Room next = rm.next();

                            if (next.getId() == rs.getInt(2)) {
                                this.game.setCurrentRoom(next);
                                jlMinimap.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathMinimap())));
                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                jtaDisplay.append("Ti trovi in: ");
                                jtaDisplay.append(game.getCurrentRoom().getName());
                                jtaDisplay.append("\n");
                                jtaDisplay.append(game.getCurrentRoom().getDescription());

                            }
                        }

                        if (rs.getString(3) != null) {
                            objInventory = rs.getString(3).split("#");
                            Iterator<Room> roomIt = this.game.getRooms().iterator();
                            while (roomIt.hasNext()) {
                                Room nextRoom = roomIt.next();
                                Iterator<AdvObject> objectIt = nextRoom.getObjects().iterator();
                                while (objectIt.hasNext()) {
                                    AdvObject nextObject = objectIt.next();

                                    for (i = 0; objInventory.length - 1 >= i; i++) {

                                        if (Integer.parseInt(objInventory[i]) == nextObject.getId()) {
                                            this.game.getInventory().add(nextObject);
                                            objectIt.remove();
                                        }

                                    }

                                    if (nextObject instanceof AdvObjectContainer) {
                                        AdvObjectContainer nextObjectContainer = (AdvObjectContainer) nextObject;

                                        if (!nextObjectContainer.getList().isEmpty()) {
                                            Iterator<AdvObject> containerIt = nextObjectContainer.getList().iterator();
                                            while (containerIt.hasNext()) {
                                                AdvObject nextObjContained = containerIt.next();

                                                for (i = 0; objInventory.length - 1 >= i; i++) {

                                                    if (nextObjContained.getId() == Integer.parseInt(objInventory[i])) {
                                                        this.game.getInventory().add(nextObjContained);
                                                        containerIt.remove();
                                                    }

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        if (rs.getString(4) != null) {
                            riddleState = rs.getString(4).split("#");
                            Iterator<Room> roomIt = this.game.getRooms().iterator();
                            while (roomIt.hasNext()) {
                                Room nextRoom = roomIt.next();
                                if (nextRoom.getId() == 6) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[0]));

                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                    while (roomIt2.hasNext()) {
                                        Room nextRoom2 = roomIt2.next();
                                        if (nextRoom2.getId() == 4 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/study_1_unlocked.png");
                                            if (this.game.getCurrentRoom().getId() == 4) {
                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }
                                        }

                                        Iterator<AdvObject> objIt = nextRoom2.getObjects().iterator();
                                        while (objIt.hasNext()) {
                                            AdvObject nextObj = objIt.next();
                                            if (nextObj.getId() == 24) {
                                                objIt.remove();
                                            }
                                        }
                                    }

                                } else if (nextRoom.getId() == 15) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[1]));

                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();

                                    while (roomIt2.hasNext()) {

                                        Room nextRoom2 = roomIt2.next();

                                        if (nextRoom2.getId() == 6 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/stairs_1_unlocked.png");
                                            if (this.game.getCurrentRoom().getId() == 6) {

                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }

                                            Iterator<Room> roomIt3 = this.game.getRooms().iterator();
                                            while (roomIt3.hasNext()) {
                                                Room nextRoom3 = roomIt3.next();
                                                Iterator<AdvObject> objIt = nextRoom3.getObjects().iterator();
                                                while (objIt.hasNext()) {
                                                    AdvObject nextObj = objIt.next();
                                                    if (nextObj.getId() == 67) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 49) {
                                                        nextObj.setOpen(true);
                                                        if (nextObj instanceof AdvObjectContainer) {
                                                            AdvObjectContainer c = (AdvObjectContainer) nextObj;
                                                            if (!c.getList().isEmpty()) {
                                                                Iterator<AdvObject> objContained = c.getList().iterator();
                                                                while (objContained.hasNext()) {
                                                                    AdvObject nextObjContained = objContained.next();
                                                                    if (nextObjContained.getId() == 50) {
                                                                        objContained.remove();
                                                                    }
                                                                }
                                                            }

                                                        }

                                                    }
                                                }
                                            }
                                        }
                                    }

                                } else if (nextRoom.getId() == 24) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[2]));
                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                    while (roomIt2.hasNext()) {
                                        Room nextRoom2 = roomIt2.next();
                                        if (nextRoom2.getId() == 23 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/string_room_unlocked.png"); //CAMBIARE IL PATH DELLA STRING ROOM

                                            Iterator<Room> roomIt3 = this.game.getRooms().iterator();
                                            while (roomIt3.hasNext()) {
                                                Room nextRoom3 = roomIt3.next();
                                                Iterator<AdvObject> objIt = nextRoom3.getObjects().iterator();
                                                while (objIt.hasNext()) {
                                                    AdvObject nextObj = objIt.next();
                                                    if (nextObj.getId() == 130) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 95 || nextObj.getId() == 96 || nextObj.getId() == 97 || nextObj.getId() == 98 || nextObj.getId() == 99 || nextObj.getId() == 100) {
                                                        nextObj.setPush(true);
                                                    } else if (nextObj.getId() == 159) {
                                                        nextObj.setDescription("Questo orologio ora indica le 1 a.m.");
                                                    } else if (nextObj.getId() == 160) {
                                                        nextObj.setDescription("Questo orologio ora indica le 3 a.m.");
                                                    } else if (nextObj.getId() == 161) {
                                                        nextObj.setDescription("Questo orologio ora indica le 4 a.m.");
                                                    } else if (nextObj.getId() == 162) {
                                                        nextObj.setDescription("Questo orologio ora indica le 7 a.m.");
                                                    } else if (nextObj.getId() == 163) {
                                                        nextObj.setDescription("Questo orologio ora indica le 2 a.m.");
                                                    } else if (nextObj.getId() == 164) {
                                                        nextObj.setDescription("Questo orologio ora indica le 8 a.m.");
                                                    } else if (nextObj.getId() == 165) {
                                                        nextObj.setDescription("Questo orologio ora indica le 1 a.m.");
                                                    } else if (nextObj.getId() == 166) {
                                                        nextObj.setDescription("Questo orologio ora indica le 6 a.m.");
                                                    } else if (nextObj.getId() == 167) {
                                                        nextObj.setDescription("Questo orologio ora indica le 5 a.m.");
                                                    } else if (nextObj.getId() == 168) {
                                                        nextObj.setDescription("Questo orologio ora indica le 9 a.m.");
                                                    } else if (nextObj.getId() == 169) {
                                                        nextObj.setDescription("Questo orologio ora indica le 2 a.m.");
                                                    }
                                                }

                                                if (nextRoom3.getId() == 19) {
                                                    nextRoom3.setPathView("/img/View/library_burnt.png");
                                                } else if (nextRoom3.getId() == 16) {
                                                    nextRoom3.setPathView("/img/View/mosaic_room_solved.png");
                                                }
                                            }

                                            if (this.game.getCurrentRoom().getId() == 16 || this.game.getCurrentRoom().getId() == 19 || this.game.getCurrentRoom().getId() == 23) {
                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }

                                        }
                                    }

                                } else if (nextRoom.getId() == 34) {
                                    if (Boolean.parseBoolean(riddleState[3]) == false) {
                                        Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                        while (roomIt2.hasNext()) {
                                            Room nextRoom2 = roomIt2.next();
                                            if (nextRoom2.getId() == 35) {
                                                nextRoom.setEast(nextRoom2);
                                            }

                                            Iterator<AdvObject> objIt = nextRoom2.getObjects().iterator();
                                            while (objIt.hasNext()) {
                                                AdvObject nextObj = objIt.next();

                                                if (nextObj.getId() == 188) {
                                                    nextObj.setDescription("La radio trasmette a intermittenza i numeri 1, 2, 2, 0, 3, 1, 3, 0, 6, 1, 0");
                                                } else if (nextObj.getId() == 144) {
                                                    objIt.remove();
                                                }
                                            }
                                        }
                                    }

                                } else if (nextRoom.getId() == 37) {
                                    nextRoom.setLocked(Boolean.parseBoolean(riddleState[4]));
                                    Iterator<Room> roomIt2 = this.game.getRooms().iterator();
                                    while (roomIt2.hasNext()) {
                                        Room nextRoom2 = roomIt2.next();

                                        if (nextRoom2.getId() == 36 && nextRoom.isLocked() == false) {
                                            nextRoom2.setPathView("/img/View/mirror_room_3.png");

                                            Iterator<Room> roomIt3 = this.game.getRooms().iterator();
                                            while (roomIt3.hasNext()) {
                                                Room nextRoom3 = roomIt3.next();
                                                Iterator<AdvObject> objIt = nextRoom3.getObjects().iterator();
                                                while (objIt.hasNext()) {
                                                    AdvObject nextObj = objIt.next();
                                                    if (nextObj.getId() == 158) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 184) {
                                                        objIt.remove();
                                                    } else if (nextObj.getId() == 171) {

                                                        if (nextObj instanceof AdvObjectContainer) {
                                                            AdvObjectContainer c = (AdvObjectContainer) nextObj;
                                                            if (!c.getList().isEmpty()) {
                                                                Iterator<AdvObject> objContained = c.getList().iterator();
                                                                while (objContained.hasNext()) {
                                                                    AdvObject nextObjContained = objContained.next();
                                                                    if (nextObjContained.getId() == 172) {
                                                                        objContained.remove();
                                                                    }
                                                                }
                                                            }

                                                        }

                                                    }
                                                }

                                                if (nextRoom3.getId() == 27) {
                                                    nextRoom3.setPathView("/img/View/barrel_room_nvg.png");
                                                } else if (nextRoom3.getId() == 28) {
                                                    nextRoom3.setPathView("/img/View/winter_room_bucketless.png");
                                                } else if (nextRoom3.getId() == 33) {
                                                    nextRoom3.setPathView("/img/View/mannequin_room_bulb.png");
                                                }
                                            }

                                            if (this.game.getCurrentRoom().getId() == 27 || this.game.getCurrentRoom().getId() == 28 || this.game.getCurrentRoom().getId() == 33 || this.game.getCurrentRoom().getId() == 36) {
                                                jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        jtaInventory.setText("\t\tInventario");
                        jtaInventory.append("\n----------------------");
                        Iterator<AdvObject> it = this.game.getInventory().iterator();
                        while (it.hasNext()) {
                            AdvObject nextObj = it.next();
                            jtaInventory.append("\n- " + nextObj.getName());
                        }
                        jtaInventory.append("\n");
                    }
                    rs.close();
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jlSaveSlot6MouseClicked

    private void jmHelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmHelpMouseClicked
        String help = "Il tuo obiettivo è esplorare la casa e cercare di capire cosa sta succedendo.\n"
                + "\nPer interagire con ciò che ti circonda puoi sfruttare questi comandi: "
                + "\n -nord                    = ti muovi nella stanza a nord della stanza corrente"
                + "\n -sud                      = ti muovi nella stanza a sud della stanza corrente"
                + "\n -est                       = ti muovi nella stanza ad est della stanza corrente"
                + "\n -ovest                   = ti muovi nella stanza ad ovest della stanza corrente"
                + "\n -usa (ogg)            = utilizzi un oggetto"
                + "\n -usa (ogg) (ogg) = utilizzi un oggetto insieme ad un altro"
                + "\n -premi (ogg)        = premi un oggetto"
                + "\n -apri (ogg)            = apri un oggetto"
                + "\n -chiudi (ogg)        = chiudi un oggetto"
                + "\n -guarda                 = guardi con attenzione la stanza in cui ti trovi "
                + "\n -guarda (ogg)       = guardi un oggetto"
                + "\n -raccogli (ogg)      = raccogli un oggetto";

        JOptionPane.showMessageDialog(this, help, "Info", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jmHelpMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JDialog jdSave;
    private javax.swing.JLabel jlMinimap;
    private javax.swing.JLabel jlSave;
    private javax.swing.JLabel jlSaveSlot1;
    private javax.swing.JLabel jlSaveSlot2;
    private javax.swing.JLabel jlSaveSlot3;
    private javax.swing.JLabel jlSaveSlot4;
    private javax.swing.JLabel jlSaveSlot5;
    private javax.swing.JLabel jlSaveSlot6;
    private javax.swing.JLabel jlView;
    private javax.swing.JMenu jmGame;
    private javax.swing.JMenu jmHelp;
    private javax.swing.JMenuItem jmiLoad;
    private javax.swing.JMenuItem jmiReset;
    private javax.swing.JMenuItem jmiSave;
    private javax.swing.JPanel jpSave;
    private javax.swing.JScrollPane jspDisplay;
    private javax.swing.JScrollPane jspInventory;
    private javax.swing.JTextArea jtaDisplay;
    private javax.swing.JTextArea jtaInventory;
    private javax.swing.JTextField jtfInput;
    // End of variables declaration//GEN-END:variables

    /**
     * Questo metodo sostituisce il valore di 's' al testo della variabile 'jtaDisplay'. 
     *
     * @param s  La String da sostituire al testo presente nella variabile 'jtaDisplay'
     */
    public void jtaDisplaySetText(String s) {
        jtaDisplay.setText(s);
    }

    /**
     * Questo metodo aggiunge il valore di 's' al testo della variabile 'jtaDisplay'. 
     *
     * @param s  La String da aggiungere al testo presente nella variabile 'jtaDisplay'
     */
    public void jtaDisplayAppendText(String s) {
        jtaDisplay.append(s);
    }

    /**
     * Questo metodo sostituisce il valore di 's' al testo della variabile 'jtaInventory'. 
     *
     * @param s  La String da sostituire al testo presente nella variabile 'jtaInventory'
     */
    public void jtaInventorySetText(String s) {
        jtaInventory.setText(s);
    }

    /**
     * Questo metodo aggiunge il valore di 's' al testo della variabile 'jtaInventory'. 
     *
     * @param s  La String da aggiungere al testo presente nella variabile 'jtaInventory'
     */
    public void jtaInventoryAppendText(String s) {
        jtaInventory.append(s);
    }

    /**
     * Questo metodo restituisce il testo contenuto nella variabile 'jtfInput'. 
     *
     * @return jtfInput.getText()
     */
    public String jtfInputGetText() {
        return jtfInput.getText();
    }

    /**
     * Questo metodo sostituisce la ImageIcon della variabile 'jlMinimap'. 
     *
     * @param s  Il path dell'immagine con la quale creare l'ImageIcon
     */
    public void jlMinimapSetIcon(String s) {
        jlMinimap.setIcon(new javax.swing.ImageIcon(getClass().getResource(s)));
    }

    /**
     * Questo metodo sostituisce la ImageIcon della variabile 'jlView'. 
     *
     * @param s  Il path dell'immagine con la quale creare l'ImageIcon
     */
    public void jlViewSetIcon(String s) {
        jlView.setIcon(new javax.swing.ImageIcon(getClass().getResource(s)));
    }

    /**
     * Questo metodo restituisce una rappresentazione sotto forma di String della 
     * ImageIcon assegnata alla variabile 'jlView'. 
     *
     * @return jlView.getIcon().toString()
     */
    public String jlViewGetIconToString() {
        return jlView.getIcon().toString();
    }

    /**
     * Questo metodo si occupa dell'avvio del programma. 
     *
     * @param args  Gli arguments ricevuti da linea di comando
     */
    public static void main(String[] args) {
        // Imposta il look and feel 
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new Frame().setVisible(true);
        });
    }
}
