package org.phypo.Game.Boid;




import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.awt.Robot;

import java.awt.geom.Point2D;

import java.util.*;

import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;




import org.phypo.Game.PPgGame.*;


/**
 ** Sous fentre permettant de voir les application et les connexions 
 ** sous forme graphique.
 ** 
 */


//***********************************
@SuppressWarnings("serial")
final public class SimplePanel extends PanelBox
{ 		
		int cMemClickX=0;
		int cMemClickY=0;
		
		int cMemClickX2=0;
		int cMemClickY2=0;
		
		Rectangle cRectSelect=null;
		
		
		//--------------------------
		public SimplePanel( GamerHuman pGamer, 
												int pX, int pY, int pWidth, int pHeight) { 		
				
 				super( pGamer, pX, pY, pWidth, pHeight );				
		}  																					
		//------------------------------------------
		//------------------------------------------ 
		//------------------------------------------ 

		public void mousePressed( MouseEvent pEv ) {

			System.out.println( "SimplePanel.mousePressed" );
		}
		//-------------------------- 
		public void mouseReleased( MouseEvent pEv ) {

			System.out.println( "SimplePanel.mouseReleased" );
		}		

		// -----------------------------
		public void mouseClicked( MouseEvent pEv ) {

				System.out.println( "SimplePanel.mouseClicked" );

		}
		//-------------------------------------
		public void mouseDragged( MouseEvent pEv ){

				System.out.println( "SimplePanel.mouseDragged" );
		}
		//-------------------------------------
		public void mouseMoved( MouseEvent pEv ){

				//				System.out.println( "SimplePanel.mouseMoved" );
				//				System.out.println( "SimplePanel.mouseMoved" );
				Point2D.Double lPoint = new Point2D.Double( pEv.getX(), pEv.getY() );

				getGamerHuman().actionMouseMoved( lPoint, cFlagCtrl, cFlagShift, cFlagAlt );
		}
		//------------------------------------------
		//------------------------------------------ 
		//------------------------------------------ 
		
		public void paint(){

				if( World.IsPause()) {						
						cGC.drawString( "PAUSE", 100, 100 );
						return ;
				}

				// inutile si pixmap ou autre 
				cGC.setColor( Color.white );
				cGC.fillRect( 0, 0, (int)cSize.getWidth(),   (int)cSize.getHeight() );

		
				//				System.out.println( ">>>>>>>>>> SimplePanel.paint" );					
				World.Get().beginSceneDraw(  getGC() );
				World.Get().endSceneDraw( getGC() );
			//World.Get().draw( getGC() );
				/* 
				 ON VA ESSAYER DE SE PASSER DE RENDER
						 EN IMPLEMENTANT DIRECTEMENT LE RENDU DANS LE PANEL !!!!

						 IL VA FALOIR CREER LE GRAPHICS CONTEXT 2D ICI  PUIS PASSER LES OBJETS DE WORLS EN REVUE
				*/
			
			System.out.println( "fps:" + 1/World.sCurrentFpsTime ); //  + " = " + World.sCurrentFpsTime  + " " + World.Get().cWantedFrameDuration );	


		}
}
		//***********************************















