package org.phypo.Game.PPgJ3d;



import org.phypo.Game.PPgGame.*;
import org.phypo.PPg.PPgMath.PPgRandom;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.*;

//*************************************************

public interface ParticleFactoryInterface {

	public 	ParticleInterface newInstance( ParticleEngine pMyEngine, PPgRandom pRand, int lNum );

};

//*************************************************
