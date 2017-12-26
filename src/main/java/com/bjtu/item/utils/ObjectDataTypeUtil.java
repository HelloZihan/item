package com.bjtu.item.utils;

/**
 * Created by zj on 17-9-22.
 */
public class ObjectDataTypeUtil {

	public static Byte toByte(Object o) {
		try {
			return o instanceof Number ? Byte.valueOf(((Number) o).byteValue()) : Byte.valueOf(o.toString());
		} catch (Exception var2) {
			return null;
		}
	}

	public static Integer toInteger(Object o) {
		try {
			return o instanceof Number ? Integer.valueOf(((Number) o).intValue()) : Integer.valueOf(o.toString());
		} catch (Exception var2) {
			return null;
		}
	}

	public static Long toLong(Object o) {
		try {
			return o instanceof Number ? Long.valueOf(((Number) o).longValue()) : Long.valueOf(o.toString());
		} catch (Exception var2) {
			return null;
		}
	}

	public static Double toDouble(Object o) {
		try {
			return o instanceof Number ? Double.valueOf(((Number) o).doubleValue()) : Double.valueOf(o.toString());
		} catch (Exception var2) {
			return null;
		}
	}

	public static String toString(Object o) {
		return null == o ? null : o.toString();
	}
}
