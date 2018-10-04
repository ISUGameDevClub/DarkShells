using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Enemy_Movement : MonoBehaviour {

	private Rigidbody2D rb;
	public float enemySpeed = 3f;
	public float leftLimit = -3f;
	public float rightLimit = 3f;
	private float moveX;
	private float startingPos;
	private bool changeDirection = true;

	// Use this for initialization
	void Start () {
		rb = GetComponent<Rigidbody2D>();
		moveX = transform.position.x;
		startingPos = transform.position.x;
		changeDirection = true;
	}

	// Update is called once per frame
	void Update () {
		moveX = transform.position.x;
		ChangeDirection();
	}

	void ChangeDirection(){
		if (changeDirection == true) {
			if (moveX < (startingPos + rightLimit)) {
				rb.velocity = new Vector2(enemySpeed, rb.velocity.y);
			} else {
				changeDirection = false;
			}
		} 

		else {
			if (moveX > (startingPos + leftLimit)) {
				rb.velocity = new Vector2(enemySpeed * -1, rb.velocity.y);
			} else {
				changeDirection = true;
			}
		}
	}
}
