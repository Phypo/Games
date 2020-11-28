package org.phypo.Game.Boid;



import java.io.*;
import java.lang.*;
import java.util.*;

import javax.swing.*;

import java.io.*;
import java.io.PrintStream;
import java.util.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.WindowConstants;

import java.awt.geom.Point2D;
import java.awt.event.*;




import org.phypo.Game.PPgGame.*;

//***********************************
public class MyGamer extends GamerHuman {

		Point2D.Double cMousePos = new Point2D.Double();


		MyGamer(  String pName, InterfaceDisplayGamer pDisplayGamer, int pGamerId, int pGroupId ){
				super( pName, pDisplayGamer, pGamerId, pGroupId );
		}

		//------------------------------------------------		

		public void keyPressed( KeyEvent pEv ) {
				//			System.out.println( "MyGamer.keyPressed : ");
		}
		public void actionPerformed( ActionEvent pEv ){
				//			System.out.println( "MyGamer.actionPerformed : " );
		}	
		public void mouseClicked( MouseEvent pEv )     {
				//			System.out.println( "MyGamer.mouseClicked : " );
		}
		public void mouseMoved( MouseEvent pEv )   {
				//			System.out.println( "MyGamer.mouseMoved : ");

				cMousePos.setLocation( pEv.getX(), pEv.getY() );
		}
		public Point2D.Double getMousePosition() {
				//		System.out.println( "MyGamer.getMousePosition : " + cMousePos );
				return cMousePos;
		}
};
//***********************************
