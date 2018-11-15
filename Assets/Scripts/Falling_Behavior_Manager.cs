using System.Collections;
using System.Collections.Generic;
using UnityEngine;

//This script will be in a game object whose job is to keep track of all the falling objects in the game, including randomly spawning the various kinds at the top of the screen 
//within camera range.
//Created by Michael Reyes
/* Idea/Algorithm
 * Go through masterList and randomly choose a type of condiment to drop.
 *  ----In that condiment list, if the condiment's Object doesnt exist yet, create it. Else, move the invisible condiment to top of screen and set to revisible.
 *  ~ Repeat ~
 * 
 */
public class Falling_Behavior_Manager : MonoBehaviour {
    
    private GameObject[] condimentA;
    private int maxNumCondimentsA = 5;                             
    private int numCondimentsA;
    private int condimentACounter;

    private GameObject[] condimentB;
    private int maxNumCondimentsB = 5;
    private int numCondimentsB;
    private int condimentBCounter;
    
    System.Random rand;
    private float aboveCameraHeight;
    private float randomPositionXAxis;

    public GameObject character;
    public GameObject condimentAPrefab;
    public GameObject condimentBPrefab;

    private float timeSinceLastSpawn;
    private float spawnRate = 1f; //Every nf seconds...

    public GameObject killLine;

    private float distanceFromPlayerDespawn;

    // Use this for initialization
    void Start () {
        condimentA = new GameObject[maxNumCondimentsA];
        condimentB = new GameObject[maxNumCondimentsB];
        numCondimentsA = 0;
        condimentACounter = 0;
        numCondimentsB = 0;
        condimentBCounter = 0;
        rand = new System.Random();
        timeSinceLastSpawn = 0;
        character = GameObject.Find("Player");
        killLine = GameObject.Find("Kill Line");
        distanceFromPlayerDespawn = 16f;
    }

    // Update is called once per frame
    void Update () {
        checkCondimentsCollected();
        checkDeadCondiments();
        checkTimePassed();
        randomPositionXAxis = rand.Next((int)Camera.main.transform.position.x-((int)Camera.main.orthographicSize), (int)Camera.main.transform.position.x + ((int)Camera.main.orthographicSize)); //Random number within the camera view. 
        aboveCameraHeight = (Camera.main.transform.position.y + Camera.main.orthographicSize);
	}

    public void checkTimePassed()
    {
        timeSinceLastSpawn += Time.deltaTime;
        if (timeSinceLastSpawn >= spawnRate)
        {
            timeSinceLastSpawn = 0;
            spawnCondiment(rand.Next(0, 2)); //Random number between 0 and 1;
        }
    }

    private void spawnCondiment(int randNumOfCondiment)
    {
        if(randNumOfCondiment == 0)
        {
            if(condimentACounter == maxNumCondimentsA)
            {
                condimentACounter = 0;
            }
            if((condimentA[condimentACounter] == null) && (numCondimentsA) < maxNumCondimentsA)
            {
                //create object from Prefab
                condimentA[condimentACounter] = Instantiate(condimentAPrefab, new Vector3(randomPositionXAxis, aboveCameraHeight, 0), Quaternion.identity);
                numCondimentsA++;
            }
            else if(condimentA[condimentACounter].gameObject.activeInHierarchy == false) //If the object is invisible, it means the condiment has been picked up, so we can reuse it. Else, we should not move it.
            {
                //move that specific condiment to a random location above the screen(specific height) so it can fall down again, and set it to active/visible again.
                condimentA[condimentACounter].GetComponent<Rigidbody2D>().transform.position = new Vector2(randomPositionXAxis,aboveCameraHeight); //Changes position
                condimentA[condimentACounter].gameObject.SetActive(true); //Sets object to active
            }
            condimentACounter++;
        }
        else if(randNumOfCondiment == 1)
        {
            //Same as first condiment, but the next condiment.
            if (condimentBCounter == maxNumCondimentsB)
            {
                condimentBCounter = 0;
            }
            if ((condimentB[condimentBCounter] == null) && (numCondimentsB) < maxNumCondimentsB)
            {
                //create object from Prefab
                condimentB[condimentBCounter] = Instantiate(condimentBPrefab, new Vector3(randomPositionXAxis, aboveCameraHeight, 0), Quaternion.identity);
                numCondimentsB++;
            }
            else if (condimentB[condimentBCounter].gameObject.activeInHierarchy == false) //If the object is invisible, it means the condiment has been picked up, so we can reuse it. Else, we should not move it.
            {
                //move that specific condiment to a random location above the screen(specific height) so it can fall down again, and set it to active/visible again.
                condimentB[condimentBCounter].GetComponent<Rigidbody2D>().transform.position = new Vector2(randomPositionXAxis, aboveCameraHeight); //Changes position
                condimentB[condimentBCounter].gameObject.SetActive(true); //Sets object to active
            }
            condimentBCounter++;
        }
    }

    private void checkCondimentsCollected()
    {
        for(int i = 0; i<condimentA.Length; i++)
        {
            if(condimentA[i] != null && (condimentA[i].activeInHierarchy == true))
            {
                if(condimentA[i].GetComponent<Collider2D>().IsTouching(character.GetComponent<Collider2D>()) == true)
                {
                    condimentA[i].gameObject.SetActive(false); //Sets object to non-active
                }
            }
        }
        for (int i = 0; i < condimentB.Length; i++)
        {
            if (condimentB[i] != null && (condimentB[i].activeInHierarchy == true))
            {
                if (condimentB[i].GetComponent<Collider2D>().IsTouching(character.GetComponent<Collider2D>()) == true)
                {                    
                    condimentB[i].gameObject.SetActive(false); //Sets object to non-active
                }
            }
        }
    }

    private void checkDeadCondiments()
    {
        //Checks if condiments fall off platforms/collides with something that should kill them OR if the condiment is a certain distance from the player
        for (int i = 0; i < condimentA.Length; i++)
        {
            if (condimentA[i] != null && (condimentA[i].activeInHierarchy == true))
            {
                //Checks if condiments fall off platforms/collides with something that should kill them
                if (condimentA[i].GetComponent<CircleCollider2D>().IsTouching(killLine.GetComponent<BoxCollider2D>())) //If it is below a certain line, dead, deactivate it
                {
                    condimentA[i].gameObject.SetActive(false); //Sets object to non-active
                }

                //Checks if the condiment is a certain distance from the player
                if(Mathf.Abs((character.GetComponent<Rigidbody2D>().transform.position.x)-(condimentA[i].GetComponent<Rigidbody2D>().transform.position.x)) > distanceFromPlayerDespawn)
                {
                    condimentA[i].gameObject.SetActive(false); //Sets object to non-active
                }
            }
        }
        for (int i = 0; i < condimentB.Length; i++)
        {
            if (condimentB[i] != null && (condimentB[i].activeInHierarchy == true))
            {
                //Checks if condiments fall off platforms/collides with something that should kill them
                if (condimentB[i].GetComponent<CircleCollider2D>().IsTouching(killLine.GetComponent<BoxCollider2D>())) //If it is below a certain line, dead, deactivate it
                {
                    condimentB[i].gameObject.SetActive(false); //Sets object to non-active
                }

                //Checks if the condiment is a certain distance from the player
                if (Mathf.Abs((character.GetComponent<Rigidbody2D>().transform.position.x) - (condimentB[i].GetComponent<Rigidbody2D>().transform.position.x)) > distanceFromPlayerDespawn)
                {
                    condimentB[i].gameObject.SetActive(false); //Sets object to non-active
                }
            }
        }
    }
}