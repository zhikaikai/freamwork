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

import com.google.common.base.CaseFormat;
import com.google.common.base.Preconditions;

public class ConverterHelper {

    private static CaseFormat lowerHyphen = CaseFormat.LOWER_HYPHEN;

    private static CaseFormat lowerCamel = CaseFormat.LOWER_CAMEL;

    private static CaseFormat lowerUnderscore = CaseFormat.LOWER_UNDERSCORE;

    private static CaseFormat upperCamel = CaseFormat.UPPER_CAMEL;

    private static CaseFormat upperUnderscore = CaseFormat.UPPER_UNDERSCORE;

    private static String convertFromLowerHyphen(CaseFormat caseFormat, String str) {
        Preconditions.checkNotNull(str, "str 不能为 null !");
        return lowerHyphen.to(caseFormat, str);
    }

    private static String convertFromLowerUnderscore(CaseFormat caseFormat, String str) {
        Preconditions.checkNotNull(str, "str 不能为 null !");
        return lowerUnderscore.to(caseFormat, str);
    }

    private static String convertFromUpperUnderscore(CaseFormat caseFormat, String str) {
        Preconditions.checkNotNull(str, "str 不能为 null !");
        return upperUnderscore.to(caseFormat, str);
    }

    private static String convertFromLowerCamel(CaseFormat caseFormat, String str) {
        Preconditions.checkNotNull(str, "str 不能为 null !");
        return lowerCamel.to(caseFormat, str);
    }

    private static String convertFromUpperCamel(CaseFormat caseFormat, String str) {
        Preconditions.checkNotNull(str, "str 不能为 null !");
        return upperCamel.to(caseFormat, str);
    }

    /**
     * 驼峰首字母小写
     *
     * @param str
     * @return
     */
    public static String convertCamelToFirstCharlowerCase(String str) {
        return convertFromUpperCamel(upperCamel, str);
    }

    /**
     * 驼峰首字母大写
     *
     * @param str
     * @return
     */
    public static String convertCamelToFirstCharUpperCase(String str) {
        return convertFromLowerCamel(lowerCamel, str);
    }

    /**
     * 驼峰转下划线，大写
     *
     * @param str
     * @return
     */
    public static String convertCamelToUnderscoreUpperCase(String str) {
        return convertFromLowerCamel(upperUnderscore, str);
    }

    /**
     * 驼峰转连接符  小写
     *
     * @param str
     * @return
     */
    public static String convertCamelToHyphenLowerCase(String str) {
        return convertFromLowerCamel(lowerHyphen, str);
    }

    /**
     * 驼峰转下划线 小写
     *
     * @param str
     * @return
     */
    public static String convertCamelToUnderscoreLowerCase(String str) {
        return convertFromLowerCamel(lowerUnderscore, str);
    }

    /**
     * "_" 转"-"，下划线转连接符,转小写
     *
     * @param str
     * @return
     */
    public static String convertUnderscoreToHyphenLowerCase(String str) {
        return convertFromUpperUnderscore(lowerHyphen, str);
    }

    /**
     * "_" 转换成 "-"，下划线转连接符
     *
     * @param str
     * @return
     */
    public static String convertUnderscoreToHyphen(String str) {
        return convertFromLowerUnderscore(lowerHyphen, str);
    }

    /**
     * "-" 转换成 "_"
     *
     * @param str
     * @return
     */
    public static String convertHyphenToUnderscore(String str) {
        return convertFromLowerHyphen(lowerUnderscore, str);
    }

    /**
     * "-" 转换成 "_" 连接符转下划线并且全部转大写
     *
     * @param str
     * @return
     */
    public static String convertHyphenToUnderscoreUpperCase(String str) {
        return convertFromLowerHyphen(upperUnderscore, str);
    }

    /**
     * 字符串转小写
     *
     * @param str
     * @return
     */
    public static String convertToLowerCase(String str) {
        return convertFromUpperUnderscore(lowerUnderscore, str);
    }

    /**
     * 全部转大写
     *
     * @param str
     * @return
     */
    public static String convertToUpperCase(String str) {
        return convertFromLowerUnderscore(upperUnderscore, str);
    }

    /**
     * 连接符转驼峰 首字母小写
     *
     * @param str
     * @return
     */
    public static String convertHyphenToLowerCamel(String str) {
        return convertFromLowerHyphen(lowerCamel, str);
    }

    /**
     * 连接符转驼峰 首字母大写
     *
     * @param str
     * @return
     */
    public static String convertHyphenToUpperCamel(String str) {
        return convertFromLowerHyphen(upperCamel, str);
    }

    /**
     * 下划线转驼峰 首字母小写
     *
     * @param str
     * @return
     */
    public static String convertUnderscoreToLowerCamel(String str) {
        return convertFromLowerUnderscore(lowerCamel, str);
    }

    /**
     * 下划线转驼峰 首字母大写
     *
     * @param str
     * @return
     */
    public static String convertUnderscoreToUpperCamel(String str) {
        return convertFromLowerUnderscore(upperCamel, str);
    }

}
