package com.ic.base.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinUtils {

	/**
	 * @描述 字符串转汉语拼音,非中文把大写转换成小写
	 * @param string, boolean:true(获取汉字完整拼音) false(获取汉字拼音首字母)
	 * @author zpx
	 * @return string--汉语拼音
	 */
	public static String stringToPinyin(String str, boolean isComplete) {
		if (str == null)
			return null;
		String lowerString = str.toLowerCase();
		char[] cArray = null;
		cArray = lowerString.toCharArray();
		HanyuPinyinOutputFormat hpof = new HanyuPinyinOutputFormat();

		hpof.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		hpof.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		hpof.setVCharType(HanyuPinyinVCharType.WITH_V);

		String pinyin = "";
		String[] charPinyin = new String[cArray.length];
		try {
			for (int i = 0; i < cArray.length; i++) {
				if (Character.toString(cArray[i]).matches("[\\u4E00-\\u9FA5]+")) {
					charPinyin = PinyinHelper.toHanyuPinyinStringArray(cArray[i], hpof);
					if (isComplete) {
						pinyin += charPinyin[0];
					} else if (charPinyin[0] != null && charPinyin[0].length() > 0) {
						pinyin += charPinyin[0].substring(0, 1);
					}
				} else {
					pinyin += Character.toString(cArray[i]);
				}
			}
		} catch (BadHanyuPinyinOutputFormatCombination e1) {
			e1.printStackTrace();
		}
		return pinyin;
	}
	
	public static void main(String[] args) {
		System.out.println(stringToPinyin("重庆这个按时hdhkUHH无二无借款", true));
		System.out.println(stringToPinyin("中天科盛（上海）企业发展股份有限公司", false));
		System.out.println(stringToPinyin(null, false) + " " + null);
	}
}
