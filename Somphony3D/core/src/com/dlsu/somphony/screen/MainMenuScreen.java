package com.dlsu.somphony.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.dlsu.somphony.Driver;
import com.dlsu.somphony.input.XInputController;
import com.dlsu.somphony.model.Cube;
import com.dlsu.somphony.model.GameObject;
import com.dlsu.somphony.model.SomphonyLine;

import java.util.Iterator;

public class MainMenuScreen implements Screen {

    private final Driver game;

    public PerspectiveCamera camera;
    public CameraInputController camController;
    public ModelBatch modelBatch;
    // lighting
    public Environment environment;
    // game objects
    public Array<GameObject> actors;
    // controller
    public XInputController controller;

    public MainMenuScreen(final Driver game) {
        this.game = game;
        // camera
        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(10f, 10f, 10f);
        camera.lookAt(0,0,0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();
        camController = new CameraInputController(camera);
        Gdx.input.setInputProcessor(camController);


        // controller
        for (Controller c : Controllers.getControllers()) {
            System.out.println(c.getName());
        }
        controller = new XInputController();
        Controllers.addListener(controller);

        // create object
        actors = new Array<GameObject>();
        //actors.add(new Cube(controller));
        actors.add(new SomphonyLine(Color.BLUE));
        actors.add(new SomphonyLine(Color.ORANGE));


        modelBatch = new ModelBatch();

        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
    }

    @Override
    public void show() {

    }

    public void input(float delta){
        if(controller.buttons[XInputController.BUTTON_START]){
            camera.position.set(10f, 10f, 10f);
            camera.lookAt(0,0,0);
        }

        if(controller.axis[XInputController.AXIS_RY] > 0.25f || controller.axis[XInputController.AXIS_RY] < -0.25f)
            camera.position.add(0 , 0, camera.direction.z * delta * 100 * controller.axis[XInputController.AXIS_RY]);
        if(controller.axis[XInputController.AXIS_RX] > 0.25f || controller.axis[XInputController.AXIS_RX] < -0.25f)
            camera.position.add(0 , camera.direction.y * delta * 100 * controller.axis[XInputController.AXIS_RX], 0);
        if(controller.buttons[XInputController.BUTTON_RS])
            camera.position.add(camera.direction.x * delta * 100, 0, 0);
        camera.update();
    }

    public void update(float delta){

        Iterator<GameObject> iter = actors.iterator();
        while(iter.hasNext()) {
            GameObject actor = iter.next();
            actor.input(delta);
            actor.update(delta);
        }
        camController.update();
    }
    @Override
    public void render(float delta) {
        input(delta);

        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        update(delta);
        modelBatch.begin(camera);
        Iterator<GameObject> iter = actors.iterator();
        while(iter.hasNext()) {
            GameObject actor = iter.next();
            actor.render(delta);
            modelBatch.render(actor.modelInstance, environment);
        }
        modelBatch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        modelBatch.dispose();
        Iterator<GameObject> iter = actors.iterator();
        while(iter.hasNext()) {
            GameObject actor = iter.next();
            actor.dispose();
        }
    }
}
