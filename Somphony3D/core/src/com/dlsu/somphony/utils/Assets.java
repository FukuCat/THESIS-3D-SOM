package com.dlsu.somphony.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ObjectMap;

import java.util.HashMap;

public class Assets {

    private ObjectMap<String, Music> musicMap;
    private ObjectMap<String, Sound> soundMap;
    private ObjectMap<String, Texture> textureMap;
    private ObjectMap<String, BitmapFont> fontMap;

    public Assets(){
        musicMap = new ObjectMap<String, Music>();
        soundMap = new ObjectMap<String, Sound>();
        textureMap = new ObjectMap<String, Texture>();
        fontMap = new ObjectMap<String, BitmapFont>();
    }

    public void loadTexture (String name, String file) {
        textureMap.put(name, new Texture(Gdx.files.internal(file)));
    }

    public Texture getTexture(String name){
        return textureMap.get(name);
    }

    public void loadMusic(String name, String file){
        musicMap.put(name, Gdx.audio.newMusic(Gdx.files.internal(file)));
    }

    public Music getMusic(String name){
        return musicMap.get(name);
    }

    public void loadSound(String name, String file){
        soundMap.put(name, Gdx.audio.newSound(Gdx.files.internal(file)));
    }

    public Sound getSound(String name){
        return soundMap.get(name);
    }

    public void loadFont(String name, String fntFile, String pngFile){
        fontMap.put(name, new BitmapFont(Gdx.files.internal(fntFile), Gdx.files.internal(pngFile), false));
    }

    public BitmapFont getFont(String name){
        return fontMap.get(name);
    }

}
