package com.offer.string;
/**
 * 字符串转换为整数
 * 需要注意的细节：
 * 1、空字符串处理
 * 2、非法字符处理
 * 3、负值处理
 * 4、防止越界处理
 * @author bupt
 *
 */
public class StringToInt {

	/**
	 * Java api 中的标准实现
	 * 函数说明：Character.digit(ch,radix)
	 * 该函数判断ch字符在给定的radix（进制）下表示的值，如果不在radix的范围，返回-1
	 * 例如：
	 * radix = 10时，ch >= '0' && ch <= '9'时返回正确的值（ch = '0'返回0，ch = '9'返回9）
	 * 当ch不在这个范围内时（例如'a','b'），返回-1
	 * radix = 8时，ch >= '0' && ch <= '7'时返回正确的值（ch = '0'返回0，ch = '7'返回7）
	 * 当ch不在这个范围内时（例如'8', '9''a','b'），返回-1
	 *  radix = 11时，ch >= '0' && ch <= '9' || ch = 'a'(a是10的11进制表示法)时返回正确的值（ch = '0'返回0，ch = 'a'返回10）
	 * 当ch不在这个范围内时（例如'b', 'c'），返回-1
	 * @param s
	 * @param radix
	 * @return
	 * @throws NumberFormatException
	 */
	public static int parseInt(String s, int radix)
			throws NumberFormatException
	{
        if (s == null) {
            throw new NumberFormatException("null");
        }

		if (radix < Character.MIN_RADIX) {
		    throw new NumberFormatException("radix " + radix +
						    " less than Character.MIN_RADIX");
		}

		if (radix > Character.MAX_RADIX) {
		    throw new NumberFormatException("radix " + radix +
						    " greater than Character.MAX_RADIX");
		}

		int result = 0;
		boolean negative = false;
		int i = 0, max = s.length();
		int limit;
		int multmin;
		int digit;

		if (max > 0) {
		    if (s.charAt(0) == '-') {
				negative = true;
				limit = Integer.MIN_VALUE;
				i++;
		    } else {
		    	limit = -Integer.MAX_VALUE; //将limit设为负数
		    }
		    multmin = limit / radix; // limit / 10
		    if (i < max) {
				digit = Character.digit(s.charAt(i++),radix);
				if (digit < 0) {
				    //throw NumberFormatException.forInputString(s);
					throw new NumberFormatException("null");
				} else {
				    result = -digit;  //将整数变为负值，与本身是负值的情况实现统一
				}
		    }
		    while (i < max) {
				// Accumulating negatively avoids surprises near MAX_VALUE
				digit = Character.digit(s.charAt(i++),radix);
				if (digit < 0) {
				    //throw NumberFormatException.forInputString(s);
					throw new NumberFormatException("null");
				}
				//乘之前先保证不溢出
				if (result < multmin) { //注意是< ,因为multmin是负值，即当result>=multmin时说明不会越界
				    //throw NumberFormatException.forInputString(s);
					throw new NumberFormatException("null");
				}
				result *= radix;
				//减之前先保证不溢出
				if (result < limit + digit) {
				    //throw NumberFormatException.forInputString(s);
					throw new NumberFormatException("null");
				}
				result -= digit; //注意是 - 不是 +
		    }
		} else {
		    //throw NumberFormatException.forInputString(s);
			throw new NumberFormatException("null");
		}
		if (negative) {
		    if (i > 1) {
		    	return result;
		    } else {	/* Only got "-" */
			//throw NumberFormatException.forInputString(s);
		    	throw new NumberFormatException("null");
		    }
		} else {
		    return -result;
		}
	 }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
