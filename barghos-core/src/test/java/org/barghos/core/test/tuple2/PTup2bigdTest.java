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

/*
MIT License

Copyright (c) 2020 picatrix1899 (Florian Zilkenat)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package org.barghos.core.test.tuple2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import org.barghos.core.tuple2.PTup2bigd;
import org.barghos.core.tuple2.Tup2bigd;

/**
 * This class provides component tests for the class {@link PTup2bigd}.
 * 
 * @since 1.0.0.0
 */
class PTup2bigdTest
{
	/**
	 * This test ensures, that an instance of {@link PTup2bigd} generated from an existing tuple,
	 * returns the correct components.
	 * 
	 * @since 1.0.0.0
	 */
	@Test
	void gen_TupleTest()
	{
		PTup2bigd t = PTup2bigd.gen(new Tup2bigd(BigDecimal.valueOf(1.1), BigDecimal.valueOf(2.2)));
		
		assertEquals(BigDecimal.valueOf(1.1), t.getX());
		assertEquals(BigDecimal.valueOf(2.2), t.getY());
	}
	
	/**
	 * This test ensures, that an instance of {@link PTup2bigd} generated from a scalar,
	 * returns the correct components.
	 * 
	 * @since 1.0.0.0
	 */
	@Test
	void gen_ScalarTest()
	{
		PTup2bigd t = PTup2bigd.gen(BigDecimal.valueOf(1.1));
		
		assertEquals(BigDecimal.valueOf(1.1), t.getX());
		assertEquals(BigDecimal.valueOf(1.1), t.getY());
	}
	
	/**
	 * This test ensures, that an instance of {@link PTup2bigd} generated from two components,
	 * returns the correct components.
	 * 
	 * @since 1.0.0.0
	 */
	@Test
	void gen_ComponentsTest()
	{
		PTup2bigd t = PTup2bigd.gen(BigDecimal.valueOf(1.1), BigDecimal.valueOf(2.2));
		
		assertEquals(BigDecimal.valueOf(1.1), t.getX());
		assertEquals(BigDecimal.valueOf(2.2), t.getY());
	}
	
	/**
	 * This test ensures, that the {@link PTup2bigd#toString()} function prints the components correctly.
	 * 
	 * @since 1.0.0.0
	 */
	@Test
	void toStringTest()
	{
		PTup2bigd t = PTup2bigd.gen(BigDecimal.valueOf(1.1), BigDecimal.valueOf(2.2));
		
		assertEquals("ptup2bigd(x=1.1, y=2.2)", t.toString());
	}
	
	/**
	 * This test ensures, that the special policies for the function {@link PTup2bigd#equals(Object)} are working.
	 * 
	 * @since 1.0.0.0
	 */
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void equalsTest()
	{
		PTup2bigd t = PTup2bigd.gen(BigDecimal.valueOf(1.1), BigDecimal.valueOf(2.2));
		
		assertTrue(t.equals(t));
		assertFalse(t.equals(null));
		assertFalse(t.equals(0));
		assertFalse(t.equals(PTup2bigd.gen(BigDecimal.valueOf(2.2), BigDecimal.valueOf(2.2)))); // x wrong
		assertFalse(t.equals(PTup2bigd.gen(BigDecimal.valueOf(1.1), BigDecimal.valueOf(3.3)))); // y wrong
		
		assertTrue(t.equals(new Tup2bigd(BigDecimal.valueOf(1.1), BigDecimal.valueOf(2.2))));
		assertTrue(t.equals(PTup2bigd.gen(BigDecimal.valueOf(1.1), BigDecimal.valueOf(2.2))));	
	}
}