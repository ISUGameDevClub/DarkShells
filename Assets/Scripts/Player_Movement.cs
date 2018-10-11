using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Player_Movement : MonoBehaviour {

	public int playerSpeed;
	private float moveX;
	private Rigidbody2D rb;
	private bool isFacingRight = true;
	public int jumpPower;

	// Use this for initialization
	void Start () {
		rb = GetComponent<Rigidbody2D>();
	}
	
	// Update is called once per frame
	void Update () {
		moveX = Input.GetAxis("Horizontal");
		MovePlayer();
		FacingRight();
		JumpPlayer();
	}

	//Moves player left and right
	void MovePlayer(){
		rb.velocity = new Vector2(moveX * playerSpeed, rb.velocity.y);
	}

	void FacingRight(){
		if(moveX < 0.0f && isFacingRight){
			isFacingRight = false;
			Vector2 localScale = gameObject.transform.localScale;
			localScale.x *= -1;
			transform.localScale = localScale;
		}
		else if(moveX > 0.0f && !isFacingRight){
			isFacingRight = true;
			Vector2 localScale = gameObject.transform.localScale;
			localScale.x *= -1;
			transform.localScale = localScale;
		}
	}

	void JumpPlayer(){
		if(Input.GetKeyDown("space") && rb.IsTouchingLayers(Physics2D.AllLayers)){
			rb.AddForce(new Vector2(0, jumpPower));
		}
	}
}
