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

import org.phypo.PPg.PPgMath.*;
import org.phypo.Game.PPgGame.*;

//***********************************
public class Test extends FrameGamer {

		Test(   Point2D.Double pPosViewInit, boolean  pFlagFullScreen, boolean  pFlagDeco, int pWidth, int pHeight, int pDepth ) {
			super(  null,  new JFrame( "Swarm"), "Boid",  pPosViewInit, pFlagFullScreen, pFlagDeco, pWidth, pHeight, pDepth );

				
			  MyGamer lGamer = new MyGamer( "Test", this,  1, 1 );
				PanelBox lPanelBox = new SimplePanel( lGamer, 0,0, pWidth, pHeight );
				addPanelBox( lPanelBox  );
				
				Sky lWorld = new Sky( pWidth, pHeight );
				lWorld.addGamerHuman( lGamer );
				lWorld.populate( lGamer, 300);

				initDisplayBuffer();				
				displayBuffer();
		}
		//---------------------------------
		//---------------------------------
		//---------------------------------
		static String GetParamString( String[] args, String p_prefix, String pDefault ){
				
				int l = p_prefix.length();
				
				for( int i=0; i<  args.length; i++){
						
						String arg = args[i];
						
						if( arg.startsWith( p_prefix ))
								{
										return arg.substring( l );
								}
				}
				return pDefault;
		}
		//---------------------------------
		static boolean ExistParam( String[] args, String p_prefix){
				
				int l = p_prefix.length();
			
				for( int i=0; i<  args.length; i++){
						
						String arg = args[i];
						
						if( arg.startsWith( p_prefix ))
								{
										return true;
								}
				}
				return false;
		}
		//---------------------------------
		
		static Integer GetParamInt( String[] args, String p_prefix, Integer pDefault){
				
				int l = p_prefix.length();
				
				for( int i=0; i<  args.length; i++){
						
						String arg = args[i];
						
						if( arg.startsWith( p_prefix ))
								{
										try{
												return new Integer( arg.substring(l));
										}catch(NumberFormatException ex){
												System.out.println( "Mauvais format pour commande "+p_prefix);
												return null;
					}					
								}
				}
				return pDefault;
		}
		//---------------------------------
		static boolean GetParam( String[] args, String p_prefix ){
				
				int l = p_prefix.length();
				
				for( int i=0; i<  args.length; i++){
						
						String arg = args[i];
						
						if( arg.startsWith( p_prefix ))
										return true;
				}
				return false;
		}	
		//-----------------------------
		//-----------------------------
		//-----------------------------

		public static void main(String[] args) {
				
				Integer lVerbose  = GetParamInt( args, "-v", 0 );
				
				
				///				IniParam.ReadIni(lIniObj);
				//				World.sFurtifMode = ExistParam( args, "--F" );
				//World.sDebug      = ExistParam( args, "--G" );

				
				int lW      = GetParamInt( args, "-w", 800 );
				int lH      = GetParamInt( args, "-h", 600 );

				int lDepth  = 0;

				boolean lFlagDeco = !ExistParam( args, "-D" );
				

				boolean lFlagFullScreen = false;
				String lStrFullScreen = GetParamString( args, "-S", null );


				if(lStrFullScreen != null ){

						lFlagFullScreen = true;
						if( lStrFullScreen.compareTo( "800x600-8" )==0 ){
								lW = 800;
								lH = 600;
								lDepth = 8;
						}
						else
						if( lStrFullScreen.compareTo( "1280x1024-32" )==0 ){
								lW = 1280;
								lH = 1024;
								lDepth = 32;
						}
						else {
								// garde le mode courant !!!
								lW=0;
								lH=0;
								lDepth = 0;
						}								
				}
				

	//////					PPgVector.SetEco(true);


				String lFileXml = GetParamString( args, "-X", null );

				new Test( new Point2D.Double( 200, 200 ), lFlagFullScreen, lFlagDeco, lW, lH, lDepth );				
				
				World.Get().start();

				/*			try {
						while( true )
								sleep(100);										
				}catch(Exception e){ }
				*/
		}
}
//***********************************
