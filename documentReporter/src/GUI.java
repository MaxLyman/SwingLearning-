import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.*;
import java.io.File;
import java.io.FileReader;
import java.util.List;


public class GUI extends javax.swing.JFrame {
    JScrollPane scrollPane;
    JTextArea textArea;
    private JTabbedPane tabbedPane;
    private File droppedFile;

    public GUI() {
        textArea =  new JTextArea();
        scrollPane = new JScrollPane(textArea);
        //tab formatting
        tabbedPane = new JTabbedPane();

        this.add(tabbedPane); //tab created
        this.setSize(300,300);
        enableDragAndDrop();
    }

    private void enableStats(){

    }

    private void enableDragAndDrop() {
        DropTarget target = new DropTarget(this, new DropTargetListener() { //listener waits until file is dropped
            public void dragEnter(DropTargetDragEvent dropTargetDragEvent) {

            }

            public void dragOver(DropTargetDragEvent dropTargetDragEvent) {

            }

            public void dropActionChanged(DropTargetDragEvent dropTargetDragEvent) {

            }

            public void dragExit(DropTargetEvent dropTargetEvent) {

            }

            public void drop(DropTargetDropEvent evt) {
                System.out.println("DROP");
                try{
                    evt.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                    List list = (List) evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                    File file = (File) list.get(0);

                    //dropping and adding the txt to the tab
                    JTextArea newTabTextArea = new JTextArea(); //text area that txt file is held in
                    DropTarget target = new DropTarget(newTabTextArea, this);
                    newTabTextArea.read(new FileReader(file), null);
                    newTabTextArea.setCaretPosition(0);
                    tabbedPane.add(newTabTextArea); //adding the text area to the new tab
                    int tabIndex = tabbedPane.indexOfComponent(newTabTextArea);
                    tabbedPane.setSelectedIndex(tabIndex);
                    tabbedPane.setTitleAt(tabIndex,file.getName());


                } catch (Exception ex){}
            }
        });
    }
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :  javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    private javax.swing.JMenu file;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem newFile;
    private javax.swing.JTabbedPane tabbedPane2;

}
