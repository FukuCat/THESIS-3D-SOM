package com.dlsu.somphony.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import static com.badlogic.gdx.graphics.GL20.GL_LINE_STRIP;

public class SomphonyLine extends GameObject {

    public Array<Vector3> points;
    public Color color;
    Model model;
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
        model = modelBuilder.end();
        modelInstance = new ModelInstance(model);
    }

    @Override
    public void input(float delta) {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(float delta) {

        updateModel();
    }

    @Override
    public void dispose() {
        model.dispose();
    }
}
