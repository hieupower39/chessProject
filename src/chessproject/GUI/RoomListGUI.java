/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessproject.GUI;

import chessproject.Class.FullRoomException;
import chessproject.Class.NotFoundRoomException;
import chessproject.Class.Room;
import chessproject.Class.ClientRoomHandling;
import chessproject.ServerInformation;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
    * @author hieup
 */
public class RoomListGUI extends javax.swing.JFrame implements WindowListener{
    private final ClientRoomHandling roomHandling; //This property handles the room actions.
    
    /**
        * Creates new form RoomListGUI
     */
    public RoomListGUI() throws IOException {
        initComponents();
        roomHandling = new ClientRoomHandling(ServerInformation.getServerHost(), ServerInformation.getServerPort());
        this.addWindowListener(this);
    }
  

    /**
        * This method is called from within the constructor to initialize the form.
        * WARNING: Do NOT modify this code. The content of this method is always
        * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        roomTable = new javax.swing.JTable();
        refreshButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        hostButton = new javax.swing.JButton();
        joinButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nickNametxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        roomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S??? ph??ng", "Ch??? ph??ng", "Ghi ch??", "Tr???ng th??i"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(roomTable);

        refreshButton.setText("L??m m???i");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        backButton.setText("Quay l???i");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        hostButton.setText("T???o ph??ng");
        hostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostButtonActionPerformed(evt);
            }
        });

        joinButton.setText("V??o ph??ng");
        joinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("T??n:");

        nickNametxt.setText("Player");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(joinButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nickNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hostButton)
                    .addComponent(jLabel1)
                    .addComponent(nickNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(refreshButton)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(joinButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backButton)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Action event handling
    private void hostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hostButtonActionPerformed
        //When user click on Host button.
        try {
            /*
                First take the name on the name text field.
                Then, find the open port for host room.
                The roomHandling will handle the room hosting on the server.
                Finally, open new room window to wait for another player to join and disble this window.
            */
            String name = nickNametxt.getText();
            int port = ServerInformation.getClientPort();
            roomHandling.roomHost(name, port);
            WaitRoomGUI waitRoom = new WaitRoomGUI(this, name, port);
            waitRoom.setName1(nickNametxt.getText());
            waitRoom.setVisible(true);
            this.setVisible(false);
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_hostButtonActionPerformed

    private void joinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinButtonActionPerformed
        //When user click on Join button.
        try {
            /*
                First take the name and the room index that player choose.
                Then, the roomHandling will handle joining that room:
                    Return the room if you can join it.
                    Else it will throw an exception.
                Finally, open the wait room which you just joined, wait the host start the game and disable this window.
            */
            String name = nickNametxt.getText();
            int index = roomTable.getSelectedRow();
            int roomIndex = (int) roomTable.getModel().getValueAt(index, 0);
            Room room = roomHandling.roomJoin(name, roomIndex);
            WaitRoomGUI waitRoom = new WaitRoomGUI(this, room.getHost().getAddress(), name, room.getPort());
            waitRoom.setName1(room.getHost().getName());
            waitRoom.setName2(nickNametxt.getText());
            waitRoom.setVisible(true);
            this.setVisible(false);
        } catch (FullRoomException ex) {
            //If the FullRoomException is caught that mean the room you want to join is full now.
            JOptionPane.showMessageDialog(rootPane, "Ph??ng ?????y");
        } catch (NotFoundRoomException ex) {
            //If the NotfoundRoomException is caught that mean the room you want to join is closed or not available.
            JOptionPane.showMessageDialog(rootPane, "Ph??ng kh??ng t???n t???i");
        } catch (Exception ex) {   
        }
    }//GEN-LAST:event_joinButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        //When user click on Refresh button.
        try {
            refreshData();
        } catch (IOException | ClassNotFoundException ex) {   
        }
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        //When user click on Back button
        try {
            roomHandling.close(); //roomHandling will handle the disconnect of client with the server.
            new MenuGUI().setVisible(true); //Open a new MenuGUI
            this.dispose(); //Close this window.  
        } catch (IOException ex) {    
        }
    }//GEN-LAST:event_backButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RoomListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new RoomListGUI().setVisible(true);
                } catch (IOException ex) {    
                }
            }
        });
    }
    
    //Private method
    private void refreshData() throws IOException, ClassNotFoundException {
        //This method will be called when the refresh button is clicked.
        try{
            ArrayList <Room> listRoom = roomHandling.roomRefresh();//roomHandling will handle getting the room list from the server
            updateRoomTable(listRoom);//Call this method to display the room list on the room table.
        } catch(IOException | ClassNotFoundException ex){
        }
    }

    private void updateRoomTable(ArrayList<Room> listRoom){
        DefaultTableModel modelRoomTable = (DefaultTableModel) roomTable.getModel();
        modelRoomTable.setRowCount(0); 
        if(listRoom.size()>0){
            for (Room room : listRoom){
                Object[] row = {room.getRoomIndex(), room.getHost().getName(), "Nothing", room.isStatus()};
                modelRoomTable.addRow(row);
            }
        }
       
        this.setVisible(true);
    }
     
    //Public method
    public void closeRoom() throws IOException{
        //This method handle closing room you have hosted.
        roomHandling.roomClose();
    }
    
    public void outRoom() throws IOException{
        //This method handle exiting room you have joined.
        roomHandling.roomOut();
    }
    
    public void outRoom(String message) throws IOException{
        //This method handle exiting room you have joined and just be kicked.
        roomHandling.roomOut();
        JOptionPane.showMessageDialog(rootPane, message);
    }
    
    //Override method of the WindowListener
    @Override
    public void windowClosing(WindowEvent e) {
        //When the window is closing:
        try {
            roomHandling.close(); //roomHandling will handle the disconnect of client with the server.
        } catch (IOException ex) {   
        }
    }
  
    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton hostButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton joinButton;
    private javax.swing.JTextField nickNametxt;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTable roomTable;
    // End of variables declaration//GEN-END:variables
}
