using System.Collections;
using System.Collections.Generic;
using UnityEngine;

//This script will be in a game object whose job is to keep track of all the falling objects in the game, including randomly spawning the various kinds at the top of the screen 
//within camera range.
//Created by Michael Reyes, based off design by Kevin Wickart.
public class Falling_Behavior_Manager : MonoBehaviour {

    private List<List<Falling_Behavior>> masterList;
    //Include lists of all falling objects...
    private List<Falling_Behavior> condimentA;
    private int numWantedCondimentsA;
    private List<Falling_Behavior> condimentB;
    private int numWantedCondimentsB;

	// Use this for initialization
	void Start () {
        condimentA = new List<Falling_Behavior>();
        condimentB = new List<Falling_Behavior>();
        masterList = new List<List<Falling_Behavior>>();
	}
	
	// Update is called once per frame
	void Update () {
		
	}
}


/* Idea/Algorithm
 * Go through masterList and randomly choose a type of condiment to drop.
 *  ----In that condiment list, if the condiment's Object doesnt exist yet, create it. Else, move the invisible condiment to top of screen and set to revisible.
 *  ~ Repeat ~
 * 
 */
