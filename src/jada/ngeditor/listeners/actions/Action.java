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
package jada.ngeditor.listeners.actions;

import jada.ngeditor.model.elements.GElement;

/**
 * Events generated by the editor
 * @author cris
 */
public class Action {
    
    public static final int ADD = 0;
    public static final int SEL = 1;
    public static final int DEL = 2;
    public static final int MOV = 3;
    public static final int UPDATE = 4;
    public static final int NEW = 5;
    
    private int type;
    private GElement gele;
    
    public Action(int type,GElement throwed){
        this.type=type;
        this.gele=throwed;
    }
    
    public int getType(){
        return this.type;
    }
    
    public GElement getGUIElement(){
        return this.gele;
    }
    
    public Action getReverseAction(){
        return new Action(this.type,this.gele);
    }
}
