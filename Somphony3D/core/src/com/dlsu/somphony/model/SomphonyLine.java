package com.dlsu.somphony.model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class SomphonyLine extends GameObject {

    public Array<Vector3> points;
    public Color color;
    Model lineModel;

    public SomphonyLine(Color color){
        this.color = color;

        // generate test lines

        points = new Array<Vector3>();
        points.add(new Vector3(0.0f, 0.0f, 0.0f - 5.0f));
        for(int i = 1; i < 10; i++){
            points.add(new Vector3(
                    MathUtils.random(-0.2f, 0.2f) + points.get(i - 1).x,
                    MathUtils.random(-0.2f, 0.2f) + points.get(i - 1).y,
                    1.0f * i - 5.0f));
        }
        points.add(new Vector3(0.0f, 0.0f, 10.0f - 5.0f));
        initialize();
    }

    public SomphonyLine(Color color, Array<Vector3> points){
        this.color = color;
        this.points = points;
        initialize();
    }

    @Override
    public void initialize() {
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
        modelInstance = new ModelInstance(lineModel);
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
    }

    @Override
    public void dispose() {
        lineModel.dispose();
    }
}
