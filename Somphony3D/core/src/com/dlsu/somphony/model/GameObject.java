package com.dlsu.somphony.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;

public abstract class GameObject {

    public Vector3 rotation;
    public Vector3 position;
    public ModelInstance modelInstance;


    public GameObject(){
        rotation = new Vector3();
        position = new Vector3();
    }

    public GameObject(ModelInstance modelInstance){
        rotation = new Vector3();
        position = new Vector3();
        this.modelInstance = modelInstance;
        initialize();
    }
    public abstract void initialize();
    public abstract void input(float delta);
    public abstract void update(float delta);
    public abstract void render(float delta);
    public abstract void dispose();

    public void setYaw(float y){
        rotation.y = y;
    }

    public void setPitch(float z){
        rotation.z = z;
    }

    public void setRoll(float x){
        rotation.x = x;
    }

    public void updateModel(){
        modelInstance.transform.setFromEulerAngles(rotation.y, rotation.x, rotation.z).trn(position.z, position.y, position.x);
    }

}
