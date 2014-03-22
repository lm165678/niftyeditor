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
package jada.ngeditor.model.elements;


import de.lessvoid.nifty.controls.button.builder.ButtonBuilder;
import jada.ngeditor.model.GUIFactory;
import jada.ngeditor.model.Types;
import jada.ngeditor.model.visitor.Visitor;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author cris
 */
@XmlRootElement(name="control")
public class GButton extends GElement{
    static{
        GUIFactory.registerProduct(new GButton());
    }
   
    
    private GButton(){
        super();
    }
    public GButton(String id ){
        super(id);
         this.builder = new ButtonBuilder(this.getID());
         this.name="button";
        
    }
    @Override
    public Types getType() {
        return Types.BUTTON;
    }
    
    @Override
    public void initDefault() {
       // attributes.put("name", Types.BUTTON.toString());
        attributes.put("childLayout", "center");
        attributes.put("label", this.getID());
        
    }

    @Override
    public GElement create(String id) {
        return new GButton(id);
    }
    
     @Override
    public void accept(Visitor visitor) {
        super.accept(visitor);
        visitor.visit(this);
    }
    

    
 
    
}
