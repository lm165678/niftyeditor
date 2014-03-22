/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jada.ngeditor.model.elements;

import de.lessvoid.nifty.controls.treebox.builder.TreeBoxBuilder;
import jada.ngeditor.model.GUIFactory;
import jada.ngeditor.model.Types;
import jada.ngeditor.model.exception.IllegalDropException;
import jada.ngeditor.model.visitor.Visitor;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cris
 */
@XmlRootElement(name="control")
public class GTree extends GElement{
static{
         GUIFactory.registerProduct(new GTree());
    }

    public GTree(String id) throws IllegalArgumentException {
        super(id);
        this.builder = new TreeBoxBuilder(id);
        this.name="nifty-tree-box";
    }

    public GTree() {
        super();
    }
    @Override
    public Types getType() {
        return Types.NIFTYTREEBOX;
    }

    @Override
    public GElement create(String id) {
        return new GTree(id);
    }

    @Override
    public void initDefault() {
      
      attributes.put("width", "30%");
      attributes.put("height", "50%");
      attributes.put("childLayout", "vertical");
    }
    
     @Override
    protected de.lessvoid.nifty.elements.Element getDropContext() {
        throw new IllegalDropException("You can not add elements to a tree,only from your code");
    }
     @Override
    public void accept(Visitor visitor) {
        super.accept(visitor);
        visitor.visit(this);
    }
}
