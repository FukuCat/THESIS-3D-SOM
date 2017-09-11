package com.dlsu.somphony.model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

public class SomphonyGrid extends GameObject {

    public Array<Vector3> points;
    public Color color;

    Array<ModelInstance> modelInstanceArray;
    Array<Model> modelArray;

    public SomphonyGrid(Color color){
        this.color = color;
        initialize();
    }

    @Override
    public void initialize() {
        modelInstanceArray = new Array<ModelInstance>();
        modelArray = new Array<Model>();

        points = new Array<Vector3>();
        ModelBuilder modelBuilder = new ModelBuilder();
        points.add(new Vector3(-0.5f, -0.5f, -5.0f));
        points.add(new Vector3(-0.5f, -0.5f, 5.0f));
        modelBuilder.begin();
        MeshPartBuilder builder = modelBuilder.part("line", 1, 3, new Material());
        //builder.setColor(Color.RED);
        //builder.line(0.0f, 0.0f, -5.0f, 0.0f, 0.0f, 5.0f);
        builder.setColor(color);
        if(points.size > 1)
            for(int i = 0; i < points.size - 1; i++)
        builder.line(points.get(i).x, points.get(i).y, points.get(i).z,
                points.get(i + 1).x, points.get(i + 1).y, points.get(i + 1).z);
        modelArray.add(modelBuilder.end());

        points = new Array<Vector3>();
        points.add(new Vector3(0.5f, 0.5f, -5.0f));
        points.add(new Vector3(0.5f, 0.5f, 5.0f));

        modelBuilder.begin();
        builder = modelBuilder.part("line", 1, 3, new Material());
        builder.setColor(color);
        for(int i = 0; i < points.size - 1; i++)
            builder.line(points.get(i).x, points.get(i).y, points.get(i).z,
                    points.get(i + 1).x, points.get(i + 1).y, points.get(i + 1).z);
        modelArray.add(modelBuilder.end());

        points = new Array<Vector3>();
        points.add(new Vector3(0.5f, -0.5f, -5.0f));
        points.add(new Vector3(0.5f, -0.5f, 5.0f));

        modelBuilder.begin();
        builder = modelBuilder.part("line", 1, 3, new Material());
        builder.setColor(color);
        for(int i = 0; i < points.size - 1; i++)
            builder.line(points.get(i).x, points.get(i).y, points.get(i).z,
                    points.get(i + 1).x, points.get(i + 1).y, points.get(i + 1).z);
        modelArray.add(modelBuilder.end());

        points = new Array<Vector3>();
        points.add(new Vector3(-0.5f, 0.5f, -5.0f));
        points.add(new Vector3(-0.5f, 0.5f, 5.0f));

        modelBuilder.begin();

        builder = modelBuilder.part("line", 1, 3, new Material());
        builder.setColor(color);
        for(int i = 0; i < points.size - 1; i++)
            builder.line(points.get(i).x, points.get(i).y, points.get(i).z,
                    points.get(i + 1).x, points.get(i + 1).y, points.get(i + 1).z);
        modelArray.add(modelBuilder.end());

        points = new Array<Vector3>();
        points.add(new Vector3(-0.5f, -0.5f, -5.0f));
        points.add(new Vector3(-0.5f, 0.5f, -5.0f));
        points.add(new Vector3(0.5f, 0.5f, -5.0f));
        points.add(new Vector3(0.5f, -0.5f, -5.0f));
        points.add(new Vector3(-0.5f, -0.5f, -5.0f));

        modelBuilder.begin();
        builder = modelBuilder.part("line", 1, 3, new Material());
        builder.setColor(color);
        for(int i = 0; i < points.size - 1; i++)
            builder.line(points.get(i).x, points.get(i).y, points.get(i).z,
                    points.get(i + 1).x, points.get(i + 1).y, points.get(i + 1).z);
        modelArray.add(modelBuilder.end());

        points = new Array<Vector3>();
        points.add(new Vector3(-0.5f, -0.5f, 5.0f));
        points.add(new Vector3(-0.5f, 0.5f, 5.0f));
        points.add(new Vector3(0.5f, 0.5f, 5.0f));
        points.add(new Vector3(0.5f, -0.5f, 5.0f));
        points.add(new Vector3(-0.5f, -0.5f, 5.0f));
        modelBuilder.begin();
        builder = modelBuilder.part("line", 1, 3, new Material());
        builder.setColor(color);
        for(int i = 0; i < points.size - 1; i++)
            builder.line(points.get(i).x, points.get(i).y, points.get(i).z,
                    points.get(i + 1).x, points.get(i + 1).y, points.get(i + 1).z);
        modelArray.add(modelBuilder.end());

        Iterator<Model> iterModelArray = modelArray.iterator();
        while(iterModelArray.hasNext()) {
            modelInstanceArray.add(new ModelInstance(iterModelArray.next()));
        }
    }

    @Override
    public void input(float delta) {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(float delta, ModelBatch modelBatch, Environment environment) {
        //updateModel();
        Iterator<ModelInstance> iterModelInstanceArray = modelInstanceArray.iterator();
        ModelInstance modelInstance;
        while(iterModelInstanceArray.hasNext()) {
            modelInstance = iterModelInstanceArray.next();
            modelInstance.transform.setFromEulerAngles(rotation.y, rotation.x, rotation.z).trn(position.z, position.y, position.x);
            modelBatch.render(modelInstance, environment);
        }
    }

    @Override
    public void dispose() {
        Iterator<Model> iterModelArray = modelArray.iterator();
        while(iterModelArray.hasNext()) {
            iterModelArray.next().dispose();
        }
    }
}
