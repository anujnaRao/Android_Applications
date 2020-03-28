package com.example.crudoperations;

import java.io.Serializable;

public class UserModel implements Serializable {
    private String name,model,variat;
    private int id;
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String string){
        this.name = name;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String string){
        this.model = model;
    }

    public String getVariat(){
        return variat;
    }

    public void setVariat(String string){
        this.variat = variat;
    }
}
