/*
 * Copyright [2020] [hogae.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hogae.core.helper;

import com.google.common.base.Strings;

public class StringHelper {

    /**
     * 将""转为"null",将空字符串转为"null"字符串
     *
     * @param str
     * @return
     */
    public static String emptyToNull(String str) {
        return Strings.emptyToNull(str);
    }

    /**
     * a,b两个字符串是否有公共的前缀，如果有，返回前缀，如果没有，返回空字符串=>""
     *
     * @param a
     * @param b
     * @return
     */
    public static String commonPrefix(CharSequence a, CharSequence b) {
        return Strings.commonPrefix(a, b);
    }

    /**
     * a,b两个字符串是否有公共的后缀，如果有，返回后缀，如果没有，返回空字符串=>""
     *
     * @param a
     * @param b
     * @return
     */
    public static String commonSuffix(CharSequence a, CharSequence b) {
        return Strings.commonSuffix(a, b);
    }

    /**
     * 判断字符串是否为空或为null,如果是返回true,反之false;
     *
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str) {
        return Strings.isNullOrEmpty(str);
    }

    /**
     * null 转为 ""
     *
     * @param str
     * @return
     */
    public static String nullToEmpty(String str) {
        return Strings.nullToEmpty(str);
    }

    /**
     * 根据给出的minLength，将字符串用padChar在后面补齐minLength长度
     *
     * @param str
     * @param minLength
     * @param padChar
     * @return
     */
    public static String padEnd(String str, int minLength, char padChar) {
        return Strings.padEnd(str, minLength, padChar);
    }

    /**
     * 根据给出的minLength，将字符串用padChar在前面补齐minLength长度
     *
     * @param str
     * @param minLength
     * @param padChar
     * @return
     */
    public static String padStart(String str, int minLength, char padChar) {
        return Strings.padStart(str, minLength, padChar);
    }

    /**
     * 重复输出字符串，cout为重复次数
     *
     * @param str
     * @param count
     * @return
     */
    public static String repeat(String str, int count) {
        return Strings.repeat(str, count);
    }


    /**
     * 根据template，将arrgs填入字符格式化。 插入表示 %s,参数个数大于标识个数时，将在后面用[]符号包围
     *
     * @param template
     * @param args
     * @return
     */
    public static String lenientFormat(String template, Object... args) {
        return Strings.lenientFormat(template, args);
    }


    /**
     * 判断字符串是否为null
     *
     * @param str
     * @return
     */
    public static boolean isNull(String str) {
        return null == str;
    }

    /**
     * 判断字符串是否为 =>""
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return "".equals(str);
    }

    public static void main(String[] args) {
    }
}
