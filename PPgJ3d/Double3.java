package org.phypo.Game.PPgJ3d;import com.jogamp.opengl.*;import org.phypo.PPg.PPgMath.*;//*************************************************public class Double3{				double cVect[] = new double[3];		//		public Double3( float A, float B, float C ){				cVect[0] = A;				cVect[1] = B;				cVect[2] = C;		}		//------------------------------------------------		public Double3( double A, double B, double C ){				cVect[0] = (double)A;				cVect[1] = (double)B;				cVect[2] = (double)C;		}		//------------------------------------------------  	public Double3( Double3 pSrc ){				cVect[0] = pSrc.cVect[0];				cVect[1] = pSrc.cVect[1];				cVect[2] = pSrc.cVect[2];		}		//------------------------------------------------  	public Double3( Float3 pSrc ){				cVect[0] = pSrc.cVect[0];				cVect[1] = pSrc.cVect[1];				cVect[2] = pSrc.cVect[2];		}				//------------------------------------------------		public Double3(){				cVect[0] = 0;				cVect[1] = 0;				cVect[2] = 0;		}				//------------------------------------------------		public Double3(double pf){				cVect[0] = pf;				cVect[1] = pf;				cVect[2] = pf;		}				//------------------------------------------------		//------------------------------------------------		//------------------------------------------------		final public double[]  get() { return cVect;}		final public void set(double A, double B, double C) { 				cVect[0]= A; 				cVect[1]= B; 				cVect[2]= C; 		}		//------------------------------------------------		final public void set( Double3 pSrc ) { 				cVect[0]= pSrc.cVect[0]; 				cVect[1]= pSrc.cVect[1]; 				cVect[2]= pSrc.cVect[2]; 		}		//------------------------------------------------		public double x() { return cVect[0]; }		public double y() { return cVect[1]; }		public double z() { return cVect[2]; }		//------------------------------------------------		final public void add( Double3 pToAdd ) {				cVect[0]+= pToAdd.cVect[0];				cVect[1]+= pToAdd.cVect[1];				cVect[2]+= pToAdd.cVect[2];		}		//------------------------------------------------		final public void sub( Double3 pToAdd ) {				cVect[0]-= pToAdd.cVect[0];				cVect[1]-= pToAdd.cVect[1];				cVect[2]-= pToAdd.cVect[2];		}		//------------------------------------------------		final public void addDelta( Double3 pToAdd, double pDelta ) {				cVect[0]+= pToAdd.cVect[0]*pDelta;				cVect[1]+= pToAdd.cVect[1]*pDelta;				cVect[2]+= pToAdd.cVect[2]*pDelta;		}		//------------------------------------------------		final public void add(  double pVal ) {				cVect[0] += pVal;				cVect[1] += pVal;				cVect[2] += pVal;		}		//------------------------------------------------		final public void sub(  double pVal ) {				cVect[0] -= pVal;				cVect[1] -= pVal;				cVect[2] -= pVal;		}		//------------------------------------------------		final public void multiply(  double pVal ) {				cVect[0] *= pVal;				cVect[1] *= pVal; 				cVect[2] *= pVal;		}		//------------------------------------------------		final public void divide(  double pVal ) {				pVal = 1.0/pVal;				cVect[0] *= pVal;				cVect[1] *= pVal;				cVect[2] *= pVal;		}		//------------------------------------------------				final public void limitVal( double pMax ) {				for( int i=0; i< 3 ; i++ ){						if( cVect[i] > pMax )								cVect[i] = pMax;						else								if( cVect[i] < -pMax )								cVect[i] = -pMax;				}		}		//------------------------------------------------				final public String toString() {				String lStr = new String();				for( int i=0; i< 3 ; i++ ){												lStr = lStr + Double.toString( cVect[i] ) + ' ';				}				return lStr;		}		//------------------------------------------------		//------------------------------------------------		//------------------------------------------------		final public double distanceSq( double pX, double pY, double pZ ){				double lDx = cVect[0] -pX;				double lDy = cVect[1] -pY;				double lDz = cVect[2] -pZ;				return (lDx*lDx + lDy*lDy + lDz*lDz );		}		//------------------------------------------------		final public double distanceSq( Double3 pF ){				double lDx = cVect[0] -pF.cVect[0];				double lDy = cVect[1] -pF.cVect[1] ;				double lDz = cVect[2] -pF.cVect[2];				return (lDx*lDx + lDy*lDy + lDz*lDz );		}		//------------------------------------------------		final public double distance( double pX, double pY, double pZ  ){				return Math.sqrt( distanceSq( pX, pY, pZ ) );		}		//------------------------------------------------		final public double distance( Double3 pF  ){				return Math.sqrt( distanceSq( pF ) );		}		//------------------------------------------------		//------------------------------------------------		//------------------------------------------------		static final public void Diff( Double3 A, Double3 B ,Double3 C ) {				C.cVect[0] = A.cVect[0] - B.cVect[0]; 				C.cVect[1] = A.cVect[1] - B.cVect[1]; 				C.cVect[2] = A.cVect[2] - B.cVect[2]; 				}		//------------------------------------------------		static final public Double3 Diff( Double3 A, Double3 B ) {				Double3 C = new Double3();				C.cVect[0] = A.cVect[0] - B.cVect[0]; 				C.cVect[1] = A.cVect[1] - B.cVect[1]; 				C.cVect[2] = A.cVect[2] - B.cVect[2]; 				return C;		}		//------------------------------------------------		static public void Crossprod( Double3 A, Double3 B, Double3 Prod ) {				Prod.cVect[0] = A.cVect[1] * B.cVect[2] - B.cVect[1] * A.cVect[2];				Prod.cVect[1] = A.cVect[2] * B.cVect[0] - B.cVect[2] * A.cVect[0];				Prod.cVect[2] = A.cVect[0] * B.cVect[1] - B.cVect[0] * A.cVect[1];		}				//------------------------------------------------		static public Double3 Crossprod( Double3 A, Double3 B ) {				Double3 Prod = new Double3();				Prod.cVect[0] = A.cVect[1] * B.cVect[2] - B.cVect[1] * A.cVect[2];				Prod.cVect[1] = A.cVect[2] * B.cVect[0] - B.cVect[2] * A.cVect[0];				Prod.cVect[2] = A.cVect[0] * B.cVect[1] - B.cVect[0] * A.cVect[1];				return Prod;		}				//------------------------------------------------		static public Double3 Middle( Double3 A, Double3 B ) {								Double3 Prod = new Double3( (double)(A.cVect[0] + B.cVect[0])*0.5,																	(double)(A.cVect[1] + B.cVect[1])*0.5,																	(double)(A.cVect[2] + B.cVect[2])*0.5);				return Prod;		}				//------------------------------------------------		static public Double3 Middle( Double3 A, Double3 B, Double3 C ) {								Double3 Prod = new Double3( (double)((A.cVect[0] + B.cVect[0] + C.cVect[0])*0.3333333333333333333),																	(double)((A.cVect[1] + B.cVect[1] + C.cVect[1])*0.33333333333333333333),																	(double)((A.cVect[2] + B.cVect[2] + C.cVect[2])*0.33333333333333333333));				return Prod;		}				//------------------------------------------------		static public Double3 Middle( Double3 A, Double3 B, Double3 C, Double3 D ) {								return new Double3( (double)((A.cVect[0] + B.cVect[0] + C.cVect[0] + D.cVect[0] )*0.25),													 (double)((A.cVect[1] + B.cVect[1] + C.cVect[1] + D.cVect[1] )*0.25),													 (double)((A.cVect[2] + B.cVect[2] + C.cVect[2] + D.cVect[2] )*0.25) );																		}				//------------------------------------------------		static public Double3 Middle( Double3 A, Double3 B, Double3 C, Double3 D, Double3 E ) {								return new Double3( (double)((A.cVect[0] + B.cVect[0] + C.cVect[0] + D.cVect[0]+ E.cVect[0] )*0.20),													 (double)((A.cVect[1] + B.cVect[1] + C.cVect[1] + D.cVect[1]+ E.cVect[1] )*0.20),													 (double)((A.cVect[2] + B.cVect[2] + C.cVect[2] + D.cVect[2]+ E.cVect[2] )*0.20) );																		}				//------------------------------------------------		static public Double3 Middle( Double3 pArray[] ) {										double X=0;				double Y=0;				double Z=0;								for( Double3 lVal : pArray ){						X += lVal.cVect[0];						Y += lVal.cVect[1];						Z += lVal.cVect[2];				}				double lFactor = 1.0/pArray.length;				X *= lFactor;				Y *= lFactor;				Z *= lFactor;														return  new Double3( X, Y, Z	);																		}				//------------------------------------------------		public void	normalize() {						double d = cVect[0]  * cVect[0] + cVect[1] * cVect[1] + cVect[2] * cVect[2];				if (d == 0.0) {						d = 1.0;				} else {						d = (double)(1.0 / Math.sqrt( d ));				}				//	System.out.println( "Double3 normalize x=" + cVect[0] + " y="+ cVect[1] +" z=" + cVect[2] 				//										+ " ->" + d  				//										);							d = 1.0 / d;				cVect[0] *= d;				cVect[1] *= d;				cVect[2] *= d;						//	System.out.println( "Double3 normalize x=" + cVect[0] + " y="+ cVect[1] +" z=" + cVect[2] + " d:" +d );		}		//------------------------------------------------		public void	normalize( double pVal) {								double d = (double) Math.sqrt( cVect[0]  * cVect[0] + cVect[1] * cVect[1] + cVect[2] * cVect[2]);				if (d == 0.0) {						d = 1.0;				}				//		System.out.println( "Double3 normalize x=" + cVect[0] + " y="+ cVect[1] +" z=" + cVect[2] 				//												+ " ->" + d   + " pVal:" + pVal );																		d = pVal / d;				cVect[0] *= d;				cVect[1] *= d;				cVect[2] *= d;								//	System.out.println( "Double3 normalize x=" + cVect[0] + " y="+ cVect[1] +" z=" + cVect[2] + " d:" +d );		}		//------------------------------------------------		//------------------------------------------------		//------------------------------------------------		final public Double3 random( PPgRandom pRand, double pMax ){				cVect[0] = pRand.nextDouble( pMax );				cVect[1] = pRand.nextDouble( pMax );				cVect[2] = pRand.nextDouble( pMax );				return this;		}		//------------------------------------------------		final public Double3 randomPositif( PPgRandom pRand, double pMin, double pMax ){				cVect[0] = pMin + pRand.nextDouble( pMax-pMin );				cVect[1] = pMin + pRand.nextDouble( pMax-pMin );				cVect[2] = pMin + pRand.nextDouble( pMax-pMin );				return this;		}		//------------------------------------------------		static public Double3 GetRandom( PPgRandom pRand, double pMax ){				Double3 lTmp = new Double3();				return lTmp.random( pRand, pMax  );		}		//------------------------------------------------		static public Double3 GetRandomPositif( PPgRandom pRand, double pMin,  double pMax ){				Double3 lTmp = new Double3();				return lTmp.randomPositif( pRand, pMin, pMax  );		}		//------------------------------------------------		//------------------------------------------------		//------------------------------------------------		final public void glNormal(GL2 pGl) { pGl.glNormal3dv( cVect, 0 );}		final public void glVertex(GL2 pGl) { pGl.glVertex3dv( cVect, 0 );}		final public void glRotate(GL2 pGl)  { 				pGl.glRotated( cVect[0], 1.0, 0.0, 0.0 );				pGl.glRotated( cVect[1], 0.0, 1.0, 0.0 );				pGl.glRotated( cVect[2], 0.0, 0.0, 1.0 );		}		final public void glScaled(GL2 pGl)     { pGl.glScaled( cVect[0], cVect[1], cVect[2] );}		final public void glTranslate(GL2 pGl)  { pGl.glTranslated( cVect[0], cVect[1], cVect[2] );}		final public void glColor(GL2 pGl) { pGl.glColor3dv( cVect, 0 );}}//*************************************************