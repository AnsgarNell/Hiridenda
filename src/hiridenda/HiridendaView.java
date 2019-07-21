/*
 * HiridendaView.java
 */

package hiridenda;

import hiridenda.RMI.ServerHiridendaRMIStarter;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

/**
 * The application's main frame.
 */
public class HiridendaView extends FrameView implements InformationPanel{

    public HiridendaView(SingleFrameApplication app) {
        super(app);

        initComponents();
        model = (DefaultTreeModel) ontologyTree.getModel();
        ontologyManager = new OntologyManager(this);
        databaseManager = new DatabaseManager(this, ontologyManager); 
        ontologyManager.start();
        

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = HiridendaApp.getApplication().getMainFrame();
            aboutBox = new HiridendaAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        HiridendaApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ontologyTree = new javax.swing.JTree();
        panelButtons = new javax.swing.JPanel();
        btnLoad = new javax.swing.JButton();
        btnPopulate = new javax.swing.JButton();
        btnServer = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        mainPanel.setName("mainPanel"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Thing");
        ontologyTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        ontologyTree.setName("ontologyTree"); // NOI18N
        jScrollPane3.setViewportView(ontologyTree);

        panelButtons.setName("panelButtons"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(hiridenda.HiridendaApp.class).getContext().getActionMap(HiridendaView.class, this);
        btnLoad.setAction(actionMap.get("cargarOntologia")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hiridenda.HiridendaApp.class).getContext().getResourceMap(HiridendaView.class);
        btnLoad.setText(resourceMap.getString("btnLoad.text")); // NOI18N
        btnLoad.setName("btnLoad"); // NOI18N

        btnPopulate.setAction(actionMap.get("poblarOntologia")); // NOI18N
        btnPopulate.setText(resourceMap.getString("btnPopulate.text")); // NOI18N
        btnPopulate.setName("btnPopulate"); // NOI18N

        btnServer.setAction(actionMap.get("arrancarServidor")); // NOI18N
        btnServer.setText(resourceMap.getString("btnServer.text")); // NOI18N
        btnServer.setName("btnServer"); // NOI18N

        javax.swing.GroupLayout panelButtonsLayout = new javax.swing.GroupLayout(panelButtons);
        panelButtons.setLayout(panelButtonsLayout);
        panelButtonsLayout.setHorizontalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPopulate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnServer)
                .addContainerGap(168, Short.MAX_VALUE))
        );
        panelButtonsLayout.setVerticalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoad)
                    .addComponent(btnPopulate)
                    .addComponent(btnServer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                    .addComponent(panelButtons, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setText(resourceMap.getString("exitMenuItem.text")); // NOI18N
        exitMenuItem.setToolTipText(resourceMap.getString("exitMenuItem.toolTipText")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 437, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void cargarOntologia() 
    {
        JFileChooser c = new JFileChooser();
        String strFileName;
        // Demonstrate "Open" dialog:
        int rVal = c.showOpenDialog(this.getComponent());
        if (rVal == JFileChooser.APPROVE_OPTION)
        {
            statusAnimationLabel.setIcon(busyIcons[0]);
            busyIconTimer.start();
            strFileName = c.getSelectedFile().getPath();
            ontologyManager.readModel(strFileName);
            busyIconTimer.stop();
            statusAnimationLabel.setIcon(idleIcon);
            btnPopulate.setEnabled(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnPopulate;
    private javax.swing.JButton btnServer;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTree ontologyTree;
    private javax.swing.JPanel panelButtons;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;

    private OntologyManager ontologyManager;
    private DatabaseManager databaseManager;
    private ServerHiridendaRMIStarter serverHiriDendaRMIStarter;
    private MutableTreeNode lastClass;
    private MutableTreeNode lastIndividual;
    private DefaultTreeModel model;

    public void writeError(String text) 
    {
        statusMessageLabel.setText("ERROR: " + text);
    }
    
    public void writeControl(String text) 
    {
        statusMessageLabel.setText(text);
    }

    public void eraseTree() 
    {
        MutableTreeNode root = (MutableTreeNode) model.getRoot();
        for(int i = root.getChildCount() - 1; i >= 0; i--)
        {
            MutableTreeNode child = (MutableTreeNode) root.getChildAt(i);
            root.remove(child);
        }
        model.reload();
    }
    
    private int getNodePosition(String strClass)
    {
        MutableTreeNode root = (MutableTreeNode) model.getRoot();
        
        for(int i=0; i < root.getChildCount(); i++)
        {
            if(root.getChildAt(i).toString().equals(strClass))
            {
                return i;
            }
        }
        return -1;
    }

    @Action
    public void poblarOntologia() 
    {
        statusAnimationLabel.setIcon(busyIcons[0]);
        busyIconTimer.start();
        databaseManager.populateOntology();
        btnPopulate.setEnabled(false);
        busyIconTimer.stop();
        statusAnimationLabel.setIcon(idleIcon);
    }

    @Action
    public void arrancarServidor() 
    {
        serverHiriDendaRMIStarter = new ServerHiridendaRMIStarter(ontologyManager, this);
    }

    public void writeClass(String text) 
    {
        int position = getNodePosition(text);
        if(position == -1)
        {
            MutableTreeNode root = (MutableTreeNode) model.getRoot();
            lastClass = new DefaultMutableTreeNode(text);
            model.insertNodeInto(lastClass, root, 0);
        }
    }
    
    public void writeIndividual(String strClass, String text) 
    {
        int position = getNodePosition(strClass);
        MutableTreeNode root = (MutableTreeNode) model.getRoot();
        DefaultMutableTreeNode classNode = (DefaultMutableTreeNode) root.getChildAt(position);       
        lastIndividual = new DefaultMutableTreeNode(text);
        model.insertNodeInto(lastIndividual, classNode, 0);
    }

    public void writeProperty(String text) 
    {
        MutableTreeNode propertyNode = new DefaultMutableTreeNode(text);
        model.insertNodeInto(propertyNode, lastIndividual, lastIndividual.getChildCount());
    }
    
}