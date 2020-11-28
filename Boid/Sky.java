package org.phypo.Game.Boid;



import java.awt.Color;
import java.awt.geom.Point2D;

import  java.util.*;

import org.phypo.Game.PPgGame.*;


/**
 * A world for the boids.
 * 
 * @author Poul Henriksen 
 * @version 2.0
 */

//*************************************************

public class Sky extends World
{


		double cWidth;
		double cHeight;

		public double getWidth()  { return cWidth;}
		public double getHeight() { return cHeight;}

    /**
     * Constructor for objects of class Sky.
     * 
     */
		//------------------------------------------------
		java.util.List getObjectsInRange( Point2D.Double lCenter, double pDistance) {
				ArrayList<ActorBase> lResult = new ArrayList<ActorBase>();
				pDistance = pDistance*pDistance;

				for( ActorBase lActor : cActors ) {
						if( lCenter.distanceSq( ((Boid)lActor).getLocation()) <= pDistance )
								lResult.add( lActor );	
				}
				return lResult;
		}



		//------------------------------------------------

    public Sky( int pWidth, int pHeight) {
				cWidth = pWidth;
				cHeight = pHeight;

        
				//        getBackground().setColor(new Color(188,164,255));
				//        getBackground().fill();
        
    }

		//------------------------------------------------
    
     public void populate(MyGamer pMyGamer, int number) {
        for(int i=0; i < number; i++) {            
             int x = (int) (Math.random() * getWidth());          
             int y = (int) (Math.random() * getHeight());
             Boid b = new Boid( pMyGamer, x, y );
             addActor( b );
        }
    }
}
//*************************************************
