package com.dan.sample;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="model")
public class Model {

    @Id
    private String id;
    
    private String aStringProp;
    
    private int anIntProp;

    public Model(){}
    
    public Model(String s, int i) {
        this.aStringProp = s;
        this.anIntProp = i;
    }
    
    
    public String getaStringProp() {
        return aStringProp;
    }

    public void setaStringProp(String aStringProp) {
        this.aStringProp = aStringProp;
    }

    public int getAnIntProp() {
        return anIntProp;
    }

    public void setAnIntProp(int anIntProp) {
        this.anIntProp = anIntProp;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Model [id=" + id + ", aStringProp=" + aStringProp + ", anIntProp=" + anIntProp + "]";
    }
    
}
