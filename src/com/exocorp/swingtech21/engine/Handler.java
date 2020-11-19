package com.exocorp.swingtech21.engine;

import com.exocorp.swingtech21.games.ID;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    public LinkedList<GameObject> obj = new LinkedList<GameObject>();

    public void update(){
        for(int i = 0; i < obj.size(); i++){
            //GameObject tmpObj = obj.get(i);
            //tmpObj.update();
            obj.get(i).update(); //USE THIS
        }
    }

    public void render(Graphics g){
        for(int i = 0; i < obj.size(); i++){
            GameObject tmpObj = obj.get(i);
            tmpObj.render(g);
        }
    }

    public void addObj(GameObject obj){
        this.obj.add(obj);
    }

    public void removeObj(GameObject obj){
        this.obj.remove(obj);
    }

    public void removeAllObj(){
        for(int i = 0; i < obj.size(); i++){
            GameObject tmpObj = obj.get(i);
            removeObj(tmpObj);
        }
    }

    public boolean searchObj(GameObject obj){
        boolean status = false;
        for(GameObject tmpObj : this.obj){
            if (tmpObj.getId() == obj.getId()) {
                status = true;
                break;
            }
        }
        return status;
    }

    public boolean searchByID(ID id){
        boolean status = false;
        for(GameObject tmpObj : obj){
            if (tmpObj.getId() == id) {
                status = true;
                break;
            }
        }
        return status;
    }

}
