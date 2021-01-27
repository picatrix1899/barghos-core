/*******************************************************************************
 * Copyright (C) 2021 picatrix1899 (Florian Zilkenat)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/

package org.barghos.core.color;

import org.barghos.core.api.color.LDRColor3R;
import org.barghos.core.api.tuple3.Tup3fR;
import org.barghos.core.api.tuple3.Tup3iR;
import org.barghos.core.util.ArgumentNullException;
import org.barghos.core.Barghos;

/**
 * This class is a readonly version of a low dynamic range (LDR/Standard) RGB-Color.
 * 
 * @author picatrix1899
 * 
 * @sice 1.0.0.0
 */
public abstract class PLDRColor3 implements LDRColor3R
{
	private PLDRColor3() { }
	
	/**
	 * This generate a readonly PLDRColor3 with the components adopted from t.
	 * The values of t are interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * 
	 * @param t A tuple that the components are adopted from.
	 * 
	 * @return A new readonly PLDRColor3 with the given components.
	 * 
	 * @sice 1.0.0.0
	 */
	public static PLDRColor3 gen(Tup3fR t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
		}
		
		return gen(t.getX(), t.getY(), t.getZ());
	}
	
	/**
	 * This generate a readonly PLDRColor3 with the components set to scalar.
	 * The scalar is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * 
	 * @param scalar A value that the components are set to.
	 * 
	 * @return A new readonly PLDRColor3 with the given components.
	 * 
	 * @sice 1.0.0.0
	 */
	public static PLDRColor3 gen(float scalar)
	{
		return gen(scalar, scalar, scalar);
	}
	
	/**
	 * This generate a readonly PLDRColor3 with the components set to r, g and b.
	 * r, g and b are interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * 
	 * @param r The red component in unitspace.
	 * @param g The green component in unitspace.
	 * @param b The blue component in unitspace.
	 * 
	 * @return A new readonly PLDRColor3 with the given components.
	 * 
	 * @sice 1.0.0.0
	 */
	public static PLDRColor3 gen(float r, float g, float b)
	{
		return new PLDRColor3()
		{
			public float getUnityR() { return clampF(r); }
			public float getUnityG() { return clampF(g); }
			public float getUnityB() { return clampF(b); }
			
			public int getR() { return clampI(Math.round(r * 255)); }
			public int getG() { return clampI(Math.round(g * 255)); }
			public int getB() { return clampI(Math.round(b * 255)); }
		};
	}
	
	/**
	 * This generate a readonly PLDRColor3 with the components adopted from t.
	 * The values of t are interpreted as in colorspace (0 - 255) and are clamped to these limit.
	 * 
	 * @param t A tuple that the components are adopted from.
	 * 
	 * @return A new readonly PLDRColor3 with the given components.
	 * 
	 * @sice 1.0.0.0
	 */
	public static PLDRColor3 gen(Tup3iR t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
		}
		
		return gen(t.getX(), t.getY(), t.getZ());
	}
	
	/**
	 * This generate a readonly PLDRColor3 with the components set to scalar.
	 * The scalar is interpreted as in colorrange (0 - 255) and are clamped to these limit.
	 * 
	 * @param scalar A value that the components are set to.
	 * 
	 * @return A new readonly PLDRColor3 with the given components.
	 * 
	 * @sice 1.0.0.0
	 */
	public static PLDRColor3 gen(int scalar)
	{
		return gen(scalar, scalar, scalar);
	}
	
	/**
	 * This generate a readonly PLDRColor3 with the components set to r, g and b.
	 * r, g and b are interpreted as in colorspace (0 - 255) and are clamped to these limit.
	 * 
	 * @param r The red component in colorspace.
	 * @param g The green component in colorspace.
	 * @param b The blue component in colorspace.
	 * 
	 * @return A new readonly PLDRColor3 with the given components.
	 * 
	 * @sice 1.0.0.0
	 */
	public static PLDRColor3 gen(int r, int g, int b)
	{
		return new PLDRColor3()
		{
			public float getUnityR() { return clampF(r * 0.00392156862f); }
			public float getUnityG() { return clampF(g * 0.00392156862f); }
			public float getUnityB() { return clampF(b * 0.00392156862f); }
			
			public int getR() { return clampI(r); }
			public int getG() { return clampI(g); }
			public int getB() { return clampI(b); }
		};
	}
	
	protected float clampF(float value)
	{
		return value > 1.0f ? 1.0f : value < 0.0f ? 0.0f : value;
	}
	
	protected int clampI(int value)
	{
		return value > 255 ? 255 : value < 0 ? 0 : value;
	}
}