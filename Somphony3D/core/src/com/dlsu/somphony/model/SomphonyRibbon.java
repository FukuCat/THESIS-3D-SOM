package com.dlsu.somphony.model;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;

public class SomphonyRibbon extends GameObject {
    @Override
    public void initialize() {

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

    }
}
