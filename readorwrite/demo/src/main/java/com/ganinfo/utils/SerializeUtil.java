package com.ganinfo.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化工具类
 * @author laocunzhang
 *
 */
public class SerializeUtil {
	/**
	 * 序列化
	 * @param value
	 * @return
	 */
	public static byte[] serialize(Object value) {

		if (value == null) {

			throw new NullPointerException("Can't serialize null");

		}

		byte[] rv = null;

		ByteArrayOutputStream bos = null;

		ObjectOutputStream os = null;

		try {

			bos = new ByteArrayOutputStream();

			os = new ObjectOutputStream(bos);

			os.writeObject(value);

			os.close();

			bos.close();

			rv = bos.toByteArray();

		} catch (IOException e) {

			throw new IllegalArgumentException("Non-serializable object", e);

		} finally {

			try {

				if (os != null)
					os.close();

				if (bos != null)
					bos.close();

			} catch (Exception e2) {

				e2.printStackTrace();

			}

		}

		return rv;

	}

	/**反序列化
	 * @param bytes
	 * @return
	 */
	public static Object unserialize(byte[] bytes) {

		Object rv = null;

		ByteArrayInputStream bis = null;

		ObjectInputStream is = null;

		try {

			if (bytes != null) {

				bis = new ByteArrayInputStream(bytes);

				is = new ObjectInputStream(bis);

				rv = is.readObject();

				is.close();

				bis.close();

			}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (is != null)
					is.close();

				if (bis != null)
					bis.close();

			} catch (Exception e2) {

				e2.printStackTrace();

			}
		}

		return rv;

	}

}
