package com.example.lpmemesrecycleview;


import java.util.HashMap;

public class MemesController {

    public Meme[] MEMES = {FOREVER,FUCK, FFFFFUUUU, MEGUSTA, MOTHER, OKAY, POKEFACE, TROLL, FOREVER2,FUCK2, FFFFFUUUU2, MEGUSTA2, MOTHER2, OKAY2, POKEFACE2, TROLL2, FOREVER3,FUCK3, FFFFFUUUU3, MEGUSTA3, MOTHER3, OKAY3, POKEFACE3, TROLL3, FOREVER3};

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

    public static final Meme FOREVER2 = new Meme("Forever Alone",R.drawable.alone,0);
    public static final Meme FUCK2 = new Meme("Fuck Yea",R.drawable.fuck,1000);
    public static final Meme FFFFFUUUU2 = new Meme("FFFFFUUUUUUUU",R.drawable.fuuu,24);
    public static final Meme MEGUSTA2 = new Meme("Me Gusta",R.drawable.megusta,69);
    public static final Meme MOTHER2 = new Meme("Mother of God",R.drawable.mother,55);
    public static final Meme OKAY2 = new Meme("Okay",R.drawable.okay,-1);
    public static final Meme POKEFACE2 = new Meme("Poke Face",R.drawable.poker,6666);
    public static final Meme TROLL2 = new Meme("Troll Face",R.drawable.troll,62);

    public static final Meme FOREVER3 = new Meme("Forever Alone",R.drawable.alone,0);
    public static final Meme FUCK3 = new Meme("Fuck Yea",R.drawable.fuck,1000);
    public static final Meme FFFFFUUUU3 = new Meme("FFFFFUUUUUUUU",R.drawable.fuuu,24);
    public static final Meme MEGUSTA3 = new Meme("Me Gusta",R.drawable.megusta,69);
    public static final Meme MOTHER3 = new Meme("Mother of God",R.drawable.mother,55);
    public static final Meme OKAY3 = new Meme("Okay",R.drawable.okay,-1);
    public static final Meme POKEFACE3 = new Meme("Poke Face",R.drawable.poker,6666);
    public static final Meme TROLL3 = new Meme("Troll Face",R.drawable.troll,62);

}
