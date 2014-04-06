/* Copyright 2012 Aguzzi Cristiano

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package jada.ngeditor.guiviews;

import jada.ngeditor.controller.GUIEditor;
import jada.ngeditor.listeners.ProprietiesListener;
import jada.ngeditor.listeners.actions.Action;
import jada.ngeditor.model.elements.GElement;
import java.awt.Color;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.CellRendererPane;
import javax.swing.table.DefaultTableModel;




/**
 *
 * @author cris
 */
public class ProprietesView extends javax.swing.JPanel implements Observer{
    private ProprietiesListener listener;
    private PropTable jTable1;
    /**
     * Creates new form ProprietesView
     */
    public ProprietesView() {
        initComponents();
        jTable1 = new PropTable();
        jScrollPane1.setViewportView(jTable1);
        listener=new ProprietiesListener();
        jTable1.getModel().addTableModelListener(listener);
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
        jButton1 = new javax.swing.JButton();

        jButton1.setText("Remove");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
       
        Action act = (Action) arg; 
         // create a safe zone where to edit the table without changing the element
        this.jTable1.getModel().removeTableModelListener(listener);
        //Clear previous editing
        jTable1.clearSelection();
        jTable1.editCellAt(-1, -1);
        jTable1.setColumnSelectionInterval(0, 0);
        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        this.clearTable(model);
       
        if(act.getType() == Action.DEL){
             this.clearTable(model);
        }else{
            GUIEditor editor = (GUIEditor) o;
            GElement ele = act.getGUIElement();
            this.jTable1.setEditor(editor);
            Map<String,String> attribut = ele.getAttributes();
            model.setNumRows(attribut.keySet().size());
            int line =0;
            for(String sel : attribut.keySet()){
               
                model.setValueAt(sel, line, 0);
                model.setValueAt(attribut.get(sel), line, 1);
                line++;
            
            }
           listener.setEditor(editor.getElementEditor(ele));
           //end safe zone
           jTable1.getModel().addTableModelListener(listener);
         
       }
        
        
     
    }
    
    protected void clearTable(DefaultTableModel model){
        for(int i = 0;i<model.getRowCount();i++){
            model.setValueAt("", i, 0);
            model.setValueAt("", i, 1);
        }
        
    }
    
   
}
