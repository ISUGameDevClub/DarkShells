using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Player_Health : MonoBehaviour {

	private GameObject player;
    public GameObject[] checkPoints;
	private BoxCollider2D playerBC;
	//private GameObject camera;
	private Vector2 startPos;
	private bool hasDied;


	// Use this for initialization
	void Start () {
		hasDied = false;
		player = GameObject.Find("Player");
		playerBC = player.GetComponent<BoxCollider2D>();
		//camera = GameObject.Find("Main Camera");
		startPos = player.GetComponent<Transform>().position;
	}

	// Update is called once per frame
	void Update () {
        CheckOffMap();
        HitCheckPoint();
        //print(checkPoints[0].transform.position.x + " " + player.transform.position.x);
	}

    void CheckOffMap()
    {
        if (hasDied)
        {
            print("you died");
            hasDied = false;
        }
    }

    //void HitCheckPoint()
    //{
    //    if (checkPoints.Length != 0)
    //    {
    //        for (int i = 0; i < checkPoints.Length; i++)
    //        {
    //            if (checkPoints[i].transform.position.x == player.transform.position.x)
    //            {
    //                print("hit checkpoint!");
    //            }
    //        }
    //    }
    //}

    void HitCheckPoint()
    {
        if (checkPoints.Length != 0)
        {
            for (int i = 0; i < checkPoints.Length; i++)
            {
                RaycastHit2D hit = Physics2D.Raycast(checkPoints[i].transform.position, Vector2.up);
                if (hit.collider != null)
                {
                    if (hit.collider.gameObject.CompareTag("Player"))
                    {
                        print("hit checkpoint!");
                        startPos = checkPoints[i].transform.position;
                    }
                }
            }
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
