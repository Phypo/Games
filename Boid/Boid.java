
package org.phypo.Game.Boid;

import java.awt.Color;
import java.awt.Graphics;


import java.awt.geom.Point2D;
import java.lang.Math;

import java.util.Random;
import java.util.ArrayList;

import java.awt.*;



import java.util.*;



import org.phypo.PPg.PPgMath.*;
import org.phypo.Game.PPgGame.*;


/**
 * A boid is an object that is part of a flock. 
 * The boid follows a few simple rules that gives emergent behaviour when lots of boids are placed in the world.
 * 
 * @author Poul Henriksen 
 * @version 2.0
 */


//*************************************************

public class Boid extends ActorMobil
{
    MyGamer cMyGamer;
		

    /** Distance the wall-force will start working from.  */
    private final static int WALL_DIST = 50;    
    /** The size of wall force when it is at max. */
    private final static int WALL_FORCE = 200;
    
    /**  Maximum speed of the boid. */
    private final static int MAX_SPEED = 10;
    /**  Minimum speed of the boid. */
    private final static int MIN_SPEED = 2;
    /** The speed is divided by this. */
    private final static int SPEED_DIVIDER = 15; 
     
    /** Distance from which repulsion from other objects start working.*/
    private final static int REPULSE_DIST = 40;   
    /** Distance from which alignment with other boids start working. */ 
    private final static int ALIGN_DIST = 150;    
    /** Distance from which attraction to other boids start working. */ 
    private final static int ATTRACT_DIST = 150;
    
    /**
     * Creates a new boid with minimum speed in a random direction.
     */
    public Boid( MyGamer pMyGamer, int pX, int pY) 
    { 
	super( pX, pY , EnumFaction.Blue );

	cMyGamer = pMyGamer;

        setMaxSpeed(MAX_SPEED);
        setMinSpeed(MIN_SPEED);
        
        PPgVector vel = new  PPgVector();
        vel.setDirection( Math.toRadians(((Math.random())*360)) );
        vel.setLength(MIN_SPEED);
        setSpeed(vel);
    }
    
    /**
     * Flock!
     */
    public void act (double pTimeDelta) 
    {      
        acc();
        super.act(  pTimeDelta);
    }    
    
    /**
     * Calculate accelaration by appling the boid rules
     */
    private void acc() {
				Point2D.Double lMousePos = 	 	cMyGamer.getLastPoint();

				

				PPgVector acc = new PPgVector((lMousePos.x - getLocation().x) *1.0,
																(lMousePos.y - getLocation().y) * 1.0 );

				//		PPgVector acc = new PPgVector(0,0);


        acc.add(getFlockAttraction(ATTRACT_DIST).divide(7.5));     
        acc.add(getFlockRepulsion(REPULSE_DIST).multiply(1));
				//        acc.add(getFlockAlignment(ALIGN_DIST).divide(8));
				acc.add(getWallForce());
        setAccelaration(acc);
    }
    
    /**
     * Get the size of the wall force on this boid. Will make the boid avoid the world boundaries.
     */    
    public PPgVector getWallForce() {
    	Point2D.Double location = getLocation();
        //Special border repulse rules:
        PPgVector wallForce = new PPgVector(0,0);
        if(location.getX() <= WALL_DIST) {
            double distFactor = (WALL_DIST - location.getX()) / WALL_DIST;
            wallForce.add(new PPgVector(WALL_FORCE * distFactor, 0));
        }
        if( (World.Get().getWidth() - location.getX()) <= WALL_DIST) {
            double distFactor = (WALL_DIST - (World.Get().getWidth() - location.getX())) / WALL_DIST;
            wallForce.subtract(new PPgVector(WALL_FORCE * distFactor, 0));
        }
        if(location.getY() <= WALL_DIST) {
            double distFactor = (WALL_DIST - location.getY()) / WALL_DIST;
            wallForce.add(new PPgVector(0, WALL_FORCE * distFactor));
        }
        if(World.Get().getHeight() - location.getY() <=  WALL_DIST) {
            double distFactor = (WALL_DIST - (World.Get().getHeight() - location.getY())) / WALL_DIST;
            wallForce.subtract(new PPgVector(0, WALL_FORCE * distFactor));
        }
        return wallForce;
    }
 
    /**
     * Get the center of all the boids within the given distance. 
     * That is, the average of all the positions of the other boids.
     */
    public PPgVector getCenterOfMass(int distance) {
        java.util.List neighbours = ((Sky)World.Get()).getObjectsInRange( getLocation(), distance );
        //add me
        neighbours.add(this);
        PPgVector centre = new PPgVector();
        for(Object o : neighbours) {
            Boid b = (Boid) o;
            centre.add(b.getLocation());
        }
        return centre.divide(neighbours.size()); 
    }

    /**
     * Get the attraction from the other boids within the given distance.
     */
    public PPgVector getFlockAttraction(int distance) {
        //distance to the centre of mass
        PPgVector distCom = getCenterOfMass(distance).subtract(getLocation());
        return distCom;        
    }
    
    /**
     * Get the repulsion from the other boids within the given distance.
     */
    public PPgVector getFlockRepulsion(int distance) {
        PPgVector repulse = new PPgVector();
        java.util.List neighbours = ((Sky)World.Get()).getObjectsInRange( getLocation(), distance );
        for(Object o : neighbours) {            
            ActorMobil  other = (ActorMobil) o;
            //dist to other actor 
            Point2D.Double lPt = getLocation();
            PPgVector dist = ((PPgVector) getLocation()).subtract(other.getLocation());
            if(dist.getLength() > distance) {
                // Make sure we are looking at the logical distance.
                continue;
            }
            repulse.add(dist.setLength(distance - dist.getLength()));
        }
        return repulse;        
    }
    
    /**
     * Get the average velocity of all boids within the given distance.
     */
    private PPgVector getAverageSpeed(int distance) {
        java.util.List neighbours = ((Sky)World.Get()).getObjectsInRange(  getLocation(), distance );
        //add me
        neighbours.add(this);
        PPgVector avg = new PPgVector();
        for(Object o : neighbours) {
            Boid b = (Boid) o;
            avg.add(b.getSpeed());
        }
        return avg.divide(neighbours.size());
    }
    
    /**
     * Get the relative direction this boid should be facing to match the average direction of the flock.
     */
    private PPgVector getFlockAlignment(int distance) {
        PPgVector avgVel = getAverageSpeed(distance);
        avgVel.subtract(getSpeed());
        return avgVel;
    }
		//-------------------------- 
		public void draw( Graphics2D pG ){
		
		Point2D.Double lPos      = getLocation();
		PPgVector lSpeed = getSpeed();
				
		int lVx[]=new int[5];
		int lVy[]=new int[5];

		

		int lSize =10;

		// La pointe
		lVx[0] = lSize;
		lVy[0] = 0;


		// partie basse
		lVx[1] = -lSize;
		lVy[1] = -lSize;

		// la base
		lVx[2] = -lSize/2;
		lVy[2] = 0;

		// partie haute
		lVx[3] = -lSize;
		lVy[3] = lSize;

		lVx[4] = lVx[0];
		lVy[4] = lVy[0];

		lSpeed.transformDirection( lVx, lVy, 5 );

		
		for( int i=0; i< 5; i++ ) {
				lVx[i] += lPos.x;
				lVy[i] += lPos.y;
		}
		

		pG.setColor( Color.green );
		pG.fillPolygon( lVx, lVy, 4 );
		
		
		pG.setColor( Color.red );
		pG.drawPolyline(  lVx, lVy, 5 );
		
		
		
		pG.setColor( Color.blue );
		
		
		pG.drawLine( (int)lPos.getX(), (int)lPos.getY(), 
								 (int)(lPos.getX()+lSpeed.getX()/5), 
								 (int)(lPos.getY()+lSpeed.getY()/5) );	

			
				//		System.out.println( "draw x=" + lPos.getX() + "y=" + (int)lPos.getY() );
			
				/*				


				pG.setColor( Color.red );

						pG.drawLine( (int)(lToAvoid.x-10), (int)(lToAvoid.y-10), (int)(lToAvoid.x+10), (int)(lToAvoid.y+10) );							
						pG.drawLine( (int)(lToAvoid.x-10), (int)(lToAvoid.y+10), (int)(lToAvoid.x+10), (int)(lToAvoid.y-10) );	
						

				pG.setColor( Color.green );

				for( Point2D.Double lToAttract : cToAttract) {						
						pG.drawLine( (int)(lToAttract.x-10), (int)(lToAttract.y-10), (int)(lToAttract.x+10), (int)(lToAttract.y+10) );							
						pG.drawLine( (int)(lToAttract.x-10), (int)(lToAttract.y+10), (int)(lToAttract.x+10), (int)(lToAttract.y-10) );	
				*/

		}
}

//*************************************************
