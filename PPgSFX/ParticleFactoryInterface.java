package org.phypo.Game.PPgSFX;



import java.awt.Color;

import org.phypo.Game.PPgGame.*;
import org.phypo.PPg.PPgMath.PPgRandom;

//*************************************************

public interface ParticleFactoryInterface {

	public 	ParticleInterface newInstance( ParticleEngine pMyEngine, PPgRandom pRand, int lNum );

};

//*************************************************
