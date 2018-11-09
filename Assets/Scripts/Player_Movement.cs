using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Player_Movement : MonoBehaviour {

	public int playerSpeed;
	private float moveX;
	private Rigidbody2D rb;
	private bool isFacingRight;
    private bool isGrounded;
	public int jumpPower;

	// Use this for initialization
	void Start () {
		rb = GetComponent<Rigidbody2D>();
        isFacingRight = true;
        isGrounded = false;
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

    //Changes sprite direction
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

    //Controls player ability to jump
	void JumpPlayer(){
		if(Input.GetKeyDown("space") && isGrounded){
			rb.AddForce(new Vector2(0, jumpPower));
		}
	}

    //Checks when player touches ground
    void OnCollisionEnter2D(Collision2D collision){
        if (collision.gameObject.CompareTag("Ground")){
            isGrounded = true;
        }
    }

    //Checks when player leaves ground
    void OnCollisionExit2D(Collision2D collision){
        if (collision.gameObject.CompareTag("Ground")){
            isGrounded = false;
        }
    }

    //checks where player currently is
    void OnCollisionStay2D(Collision2D collision)
    {
        if (collision.gameObject.CompareTag("Ground"))
        {
            isGrounded = true;
        }
    }

    //sets playerSpeed
    public void SetPlayerSpeed(int newSpeed)
    {
        playerSpeed = newSpeed;
    }
}
