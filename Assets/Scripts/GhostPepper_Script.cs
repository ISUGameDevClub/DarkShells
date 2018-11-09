using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GhostPepper_Script : MonoBehaviour {

    //Variables
    public GameObject player;

	// Use this for initialization
	void Start () {
        
	}
	
	// Update is called once per frame
	void Update () {
        SpeedUp(player);
	}

    //speed up the player
    void SpeedUp(GameObject gameObject)
    {
        RaycastHit2D hit = Physics2D.Raycast(this.transform.position, Vector2.down, 1);
        if (hit.collider != null)
        {
            if (hit.collider.gameObject.CompareTag("Player"))
            {
                print("Picked up ghost pepper!");
                player.GetComponent<Player_Movement>().SetPlayerSpeed(20);
                this.gameObject.SetActive(false);
            }
        }
    }
}
