package com.dlsu.somphony.model;

import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.dlsu.somphony.input.XInputController;

public class Cube extends GameObject {

    XInputController controller;

    public Cube(ModelInstance modelInstance, XInputController controller) {
        super(modelInstance);
        this.controller = controller;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void input(float delta) {
        if(controller.buttons[XInputController.BUTTON_A])
            rotation.add(new Vector3(0,0,10));
        if(controller.buttons[XInputController.BUTTON_B])
            rotation.add(new Vector3(0,10,0));
        if(controller.buttons[XInputController.BUTTON_X])
            rotation.add(new Vector3(10,0,0));
        if(controller.axis[XInputController.AXIS_LY] > 0.25f || controller.axis[XInputController.AXIS_LY] < -0.25f)
            rotation.add(new Vector3(controller.axis[XInputController.AXIS_LY] * delta * 100,0,0));
        if(controller.axis[XInputController.AXIS_LX] > 0.25f || controller.axis[XInputController.AXIS_LX] < -0.25f)
            rotation.add(new Vector3(0, -controller.axis[XInputController.AXIS_LX] * delta * 100,0));
        if(controller.buttons[XInputController.BUTTON_LS])
            rotation.add(new Vector3(0,0,delta * 100));
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(float delta) {
        updateModel();
    }
}
