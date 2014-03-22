/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jada.ngeditor.model.elements;

import de.lessvoid.nifty.controls.dragndrop.builder.DroppableBuilder;
import jada.ngeditor.model.GUIFactory;
import jada.ngeditor.model.Types;
import jada.ngeditor.model.visitor.Visitor;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cris
 */
@XmlRootElement(name="control")
public class GDroppable extends GElement {
static{
        GUIFactory.registerProduct(new GDroppable());
    }
    

    public GDroppable(String id) throws IllegalArgumentException {
        super(id);
        this.builder = new DroppableBuilder(id);
        this.name = "droppable";
    }

    private GDroppable() {
        super();
    }
    @Override
    public Types getType() {
        return Types.DROPPABLE;
    }

    @Override
    public GElement create(String id) {
        return new GDroppable(id);
    }

    @Override
    public void initDefault() {
       
       attributes.put("width", "100px");
       attributes.put("height", "100px");
       attributes.put("childLayout", "center");
       attributes.put("backgroundImage", "jada/ngeditor/resources/drop.png");
    }
    
     @Override
    public void accept(Visitor visitor) {
        super.accept(visitor);
        visitor.visit(this);
    }
}
