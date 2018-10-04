using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Player_Health : MonoBehaviour {

	public bool hasDied;
	public GameObject player;
	public GameObject camera;
	public Vector2 startPos;

	// Use this for initialization
	void Start () {
		hasDied = false;
		player = GameObject.Find("Player");
		camera = GameObject.Find("Main Camera");
		startPos = player.GetComponent<Transform>().position;
	}

	// Update is called once per frame
	void Update () {
		fallDeathCheck();
		if(hasDied){
			print("you died");
			hasDied = false;
		}
	}

	void fallDeathCheck(){
		//float playerHeight = player.GetComponent<Transform>().position.y;

		//float cameraHeight = camera.GetComponent<Camera_System>().yMin;
		//if(playerHeight < (cameraHeight - 4)){
		//	hasDied = true;
		//	player.GetComponent<Transform>().position = startPos;
		//}
	}
}
