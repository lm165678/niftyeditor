/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jada.ngeditor.model.elements;

import de.lessvoid.nifty.controls.scrollbar.builder.ScrollbarBuilder;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cris
 */

public abstract class GScrollbar extends GElement{
    
    protected GScrollbar(){
        super();
    }
    protected GScrollbar(String id,boolean vertical) throws IllegalArgumentException{
      super(id);
      builder = new ScrollbarBuilder(id, vertical);
    }
    
}
