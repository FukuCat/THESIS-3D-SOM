package com.dlsu.somphony.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.dlsu.somphony.Driver;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Somphony3D";
		config.foregroundFPS = 60;
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new Driver(), config);
	}
}
