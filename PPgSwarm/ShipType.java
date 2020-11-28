package org.phypo.Game.PPgSwarm;

import java.util.*;
import java.awt.*;

import org.phypo.Game.PPgGame.*;
import org.phypo.Game.PPgSFX.*;
import org.phypo.PPg.PPgMath.*;

//=====================================
public enum ShipType{

    		VoidShip( Color.white ),
        
    		FieldShip( Color.blue ),        
				LaserShip( Color.red ),     
				MissileShip( Color.orange ),
				SupporShip( Color.green ),
				LeaderShip( Color.yellow );		

		public final Color cColor;
		
		ShipType( Color pColor ) { cColor = pColor; }
};
//=====================================
