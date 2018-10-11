using System.Collections;
using System.Collections.Generic;
using UnityEngine;

// This script can be used to apply it to objects that are meant to fall down to the floor and stay there.
// Created by Michael Reyes
public class Falling_Behavior : MonoBehaviour {
    // Use this for initialization

    private Rigidbody2D rb;
    public float fallSpeed = 8.0f;
    public float spinSpeed = 250.0f;
    public bool IsGrounded;
    //Create a random for which way to rotate?

	void Start () {
        rb = GetComponent<Rigidbody2D>();
	}
	
    public void checkGrounded()
    {
        if(rb.IsTouchingLayers(Physics2D.AllLayers))
        {
            IsGrounded = true;
        }
        else
        {
            IsGrounded = false;
        }
    }

	// Update is called once per frame
	void Update () {
        checkGrounded();
        if (!IsGrounded)
        {
            transform.Translate(Vector2.down * fallSpeed * Time.deltaTime, Space.World); //Check for collisions in code? Or with rigidbody2d in unity? If done in unity, either platforms or coins should have rigidbody2d.
            transform.Rotate(Vector2.one, spinSpeed * Time.deltaTime);
        }
	}
}
