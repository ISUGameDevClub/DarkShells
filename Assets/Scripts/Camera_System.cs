using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Camera_System : MonoBehaviour {

	#region variables 
	//variables
	public GameObject player;       //player object
	public float distanceAhead;     //distance to keep ahead of player
	//public float yMin = 0			//minimum distance the camera can move
	//public float yMax = 3.69		//maximum distance the camera can move
	private Vector3 playerPos;      //player's position
	#endregion

	#region Start and Update functions
	// Use this for initialization
	void Start () {

	}

	// Update is called once per frame
	void Update () {
		playerPos = player.transform.position;
		playerPos.z = -10;
		playerPos.x += distanceAhead;
		this.transform.position = playerPos;

		//float y = Mathf.Clamp(player.transform.position.y, yMin, yMax);
		//gameObject.transform.position = new Vector3(x, y, gameObject.transform.position.z);

	}
	#endregion
}
