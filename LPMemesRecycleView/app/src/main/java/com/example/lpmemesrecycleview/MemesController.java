package com.example.lpmemesrecycleview;


import java.util.HashMap;

public class MemesController {

    public Meme[] MEMES = {FUCK, FFFFFUUUU, MEGUSTA, MOTHER, OKAY, POKEFACE, TROLL, FOREVER};

    public HashMap<String, Meme> MEME_MAP = new HashMap<>();

    public MemesController(){
        for (Meme meme : MEMES){
            MEME_MAP.put(String.valueOf(meme.getId()), meme);
        }
    }

    public static final Meme FOREVER = new Meme("Forever Alone",R.drawable.alone,0);
    public static final Meme FUCK = new Meme("Fuck Yea",R.drawable.fuck,1000);
    public static final Meme FFFFFUUUU = new Meme("FFFFFUUUUUUUU",R.drawable.fuuu,24);
    public static final Meme MEGUSTA = new Meme("Me Gusta",R.drawable.megusta,69);
    public static final Meme MOTHER = new Meme("Mother of God",R.drawable.mother,55);
    public static final Meme OKAY = new Meme("Okay",R.drawable.okay,-1);
    public static final Meme POKEFACE = new Meme("Poke Face",R.drawable.poker,6666);
    public static final Meme TROLL = new Meme("Troll Face",R.drawable.troll,62);
}
