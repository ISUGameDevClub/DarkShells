using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Player_Health : MonoBehaviour {

	public GameObject player;
	public BoxCollider2D playerBC;
	public GameObject camera;
	public Vector2 startPos;
	private bool hasDied;


	// Use this for initialization
	void Start () {
		hasDied = false;
		player = GameObject.Find("Player");
		playerBC = player.GetComponent<BoxCollider2D>();
		camera = GameObject.Find("Main Camera");
		startPos = player.GetComponent<Transform>().position;
	}

	// Update is called once per frame
	void Update () {
		if(hasDied){
			print("you died");
			hasDied = false;
		}
	}

	void OnCollisionEnter2D(Collision2D col){
		GameObject collider = col.gameObject;
		if(collider.tag.Equals("KillPlayer")){
			hasDied = true;
			player.GetComponent<Transform>().position = startPos;
		}
	}
}
