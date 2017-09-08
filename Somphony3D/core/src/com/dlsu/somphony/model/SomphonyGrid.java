package com.dlsu.somphony.model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class SomphonyGrid extends GameObject {

    public Array<Vector3> points;
    public Color color;
    Model startGridModel;
    Model endGridModel;
    Model lineModel;

    ModelInstance gridStartInstance;
    ModelInstance gridEndInstance;

    public SomphonyGrid(Color color){
        this.color = color;
        initialize();
    }

    @Override
    public void initialize() {
        points = new Array<Vector3>();
        points.add(new Vector3(0.0f - 0.5f, 1.0f - 0.5f, -5.0f));
        points.add(new Vector3(0.0f - 0.5f, 1.0f - 0.5f, 5.0f));
        ModelBuilder modelBuilder = new ModelBuilder();
        modelBuilder.begin();
        MeshPartBuilder builder = modelBuilder.part("line", 1, 3, new Material());
        //builder.setColor(Color.RED);
        //builder.line(0.0f, 0.0f, -5.0f, 0.0f, 0.0f, 5.0f);
        builder.setColor(color);
        if(points.size > 1)
            for(int i = 0; i < points.size - 1; i++)
        builder.line(points.get(i).x, points.get(i).y, points.get(i).z,
                points.get(i + 1).x, points.get(i + 1).y, points.get(i + 1).z);
        lineModel = modelBuilder.end();

        points = new Array<Vector3>();
        points.add(new Vector3(0.0f - 0.5f, 0.0f - 0.5f, -5.0f));
        points.add(new Vector3(0.0f - 0.5f, 1.0f - 0.5f, -5.0f));
        points.add(new Vector3(1.0f - 0.5f, 1.0f - 0.5f, -5.0f));

        modelBuilder.begin();
        builder = modelBuilder.part("line", 1, 3, new Material());
        builder.setColor(color);
        for(int i = 0; i < points.size - 1; i++)
            builder.line(points.get(i).x, points.get(i).y, points.get(i).z,
                    points.get(i + 1).x, points.get(i + 1).y, points.get(i + 1).z);
        startGridModel = modelBuilder.end();

        points = new Array<Vector3>();
        points.add(new Vector3(0.0f - 0.5f, 0.0f - 0.5f, 5.0f));
        points.add(new Vector3(0.0f - 0.5f, 1.0f - 0.5f, 5.0f));
        points.add(new Vector3(1.0f - 0.5f, 1.0f - 0.5f, 5.0f));
        modelBuilder.begin();
        builder = modelBuilder.part("line", 1, 3, new Material());
        builder.setColor(color);
        for(int i = 0; i < points.size - 1; i++)
            builder.line(points.get(i).x, points.get(i).y, points.get(i).z,
                    points.get(i + 1).x, points.get(i + 1).y, points.get(i + 1).z);
        endGridModel = modelBuilder.end();

        modelInstance = new ModelInstance(lineModel);
        gridStartInstance = new ModelInstance(startGridModel);
        gridEndInstance = new ModelInstance(endGridModel);
    }

    @Override
    public void input(float delta) {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(float delta, ModelBatch modelBatch, Environment environment) {
        updateModel();
        modelBatch.render(modelInstance, environment);
        modelBatch.render(gridStartInstance, environment);
        modelBatch.render(gridEndInstance, environment);
    }

    @Override
    public void dispose() {
        lineModel.dispose();
        startGridModel.dispose();
        endGridModel.dispose();
    }
}
