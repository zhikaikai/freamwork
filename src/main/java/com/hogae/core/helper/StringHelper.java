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

import com.alibaba.fastjson.JSON;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

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

    /**
     * 常量 值为null
     */
    private final static String NULLTEXT = "null";

    /**
     * 返回 Joiner，并用separator连接字符
     *
     * @param separator
     * @return
     */
    private static Joiner joinerOn(String separator) {
        return Joiner.on(separator);
    }

    /**
     * 返回 Joiner，跳过null值，并用separator连接字符
     *
     * @param separator
     * @return
     */
    private static Joiner joinerOnSkipNulls(String separator) {
        return joinerOn(separator).skipNulls();
    }

    /**
     * 返回 Joiner，使用nullText替换null值，并用separator连接字符
     *
     * @param separator
     * @return
     */
    private static Joiner joinerOnUseForNull(String separator, final String nullText) {
        return joinerOn(separator).useForNull(nullText);
    }

    public static String joinerOnUseForNull(String separator, final String nullText, String keyValueSeparator, Map<?, ?> map) {
        return joinerOn(separator).useForNull(nullText).withKeyValueSeparator(keyValueSeparator).join(map);
    }

    /**
     * 返回 parts拼接后的字符串，忽略null值，并用separator连接字符
     *
     * @param separator
     * @param parts
     * @return
     */
    public static String joinerSkipNulls(String separator, Iterable<?> parts) {
        return joinerOnSkipNulls(separator).join(parts);
    }

    /**
     * 返回 parts拼接后的字符串，忽略null值，并用separator连接字符
     *
     * @param separator
     * @param parts
     * @return
     */
    public static String joinerSkipNulls(String separator, Iterator<?> parts) {
        return joinerOnSkipNulls(separator).join(parts);
    }

    /**
     * 返回 parts拼接后的字符串，忽略null值，并用separator连接字符
     *
     * @param separator
     * @param parts     这里parts为对象数组，拼接后为内存地址
     * @return
     */
    public static String joinerSkipNulls(String separator, Object[] parts) {
        return joinerOnSkipNulls(separator).join(parts);
    }

    /**
     * 返回 first，second，rest拼接后的字符串，忽略null值，并用separator连接字符
     *
     * @param separator
     * @param first     非空
     * @param second    非空
     * @param rest      Iterable
     * @return
     */
    public static String joinerSkipNulls(String separator, Object first, Object second, Object... rest) {
        return joinerOnSkipNulls(separator).join(first, second, rest);
    }

    /**
     * 返回 parts拼接后的字符串，使用nullText替换null值，并用separator连接字符
     *
     * @param separator
     * @param nullText
     * @param parts
     * @return
     */
    public static String joinerUseForNull(String separator, final String nullText, Iterable<?> parts) {
        return joinerOnUseForNull(separator, nullText).join(parts);
    }

    /**
     * 返回 parts拼接后的字符串，使用nullText替换null值，并用separator连接字符
     *
     * @param separator
     * @param nullText
     * @param parts
     * @return
     */
    public static String joinerUseForNull(String separator, final String nullText, Iterator<?> parts) {
        return joinerOnUseForNull(separator, nullText).join(parts);
    }

    /**
     * 返回 parts拼接后的字符串，使用nullText替换null值，并用separator连接字符
     *
     * @param separator
     * @param nullText
     * @param parts     这里parts为对象数组，拼接后为内存地址
     * @return
     */
    public static String joinerUseForNull(String separator, final String nullText, Object[] parts) {
        return joinerOnUseForNull(separator, nullText).join(parts);
    }


    /**
     * 返回 first，second，rest拼接后的字符串，使用nullText替换null值，并用separator连接字符
     *
     * @param separator
     * @param nullText
     * @param first     非空
     * @param second    非空
     * @param rest      Iterable
     * @return
     */
    public static String joinerUseForNull(String separator, final String nullText, Object first, Object second, Object... rest) {
        return joinerOnUseForNull(separator, nullText).join(first, second, rest);
    }

    /**
     * 返回 parts拼接后的字符串，使用常量NULLTEXT替换null值，并用separator连接字符
     *
     * @param separator
     * @param parts
     * @return
     */
    public static String joinerUseForNull(String separator, Iterable<?> parts) {
        return joinerUseForNull(separator, NULLTEXT, parts);
    }

    /**
     * 返回 parts拼接后的字符串，使用常量NULLTEXT替换null值，并用separator连接字符
     *
     * @param separator
     * @param parts
     * @return
     */
    public static String joinerUseForNull(String separator, Iterator<?> parts) {
        return joinerUseForNull(separator, NULLTEXT, parts);
    }

    /**
     * 返回 parts拼接后的字符串，使用常量NULLTEXT替换null值，并用separator连接字符
     *
     * @param separator
     * @param parts     这里parts为对象数组，拼接后为内存地址
     * @return
     */
    public static String joinerUseForNull(String separator, Object[] parts) {
        return joinerUseForNull(separator, NULLTEXT, parts);
    }

    /**
     * 返回 first，second，rest拼接后的字符串，使用NULLTEXT替换null值，并用separator连接字符
     *
     * @param separator
     * @param first     非空
     * @param second    非空
     * @param rest      Iterable
     * @return
     */
    public static String joinerUseForNull(String separator, Object first, Object second, Object... rest) {
        return joinerUseForNull(separator, NULLTEXT, first, second, rest);
    }

    private static Splitter splitterOn(char separator) {
        return Splitter.on(separator);
    }

    private static Splitter splitterOn(final CharMatcher separatorMatcher) {
        return Splitter.on(separatorMatcher);
    }

    private static Splitter splitterOn(final String separator) {
        return Splitter.on(separator);
    }

    private static Splitter splitterOn(Pattern separatorPattern) {
        return Splitter.on(separatorPattern);
    }

    private static Splitter splitterOnPattern(String separatorPattern) {
        return Splitter.onPattern(separatorPattern);
    }

    private static Splitter splitterOnLimit(char separator, int maxItems) {
        return Splitter.on(separator).limit(maxItems);
    }

    private static Splitter splitterOnLimit(final CharMatcher separatorMatcher, int maxItems) {
        return Splitter.on(separatorMatcher).limit(maxItems);
    }

    private static Splitter splitterOnLimit(final String separator, int maxItems) {
        return Splitter.on(separator).limit(maxItems);
    }

    private static Splitter splitterOnLimit(Pattern separatorPattern, int maxItems) {
        return Splitter.on(separatorPattern).limit(maxItems);
    }

    private static Splitter splitterOnPatternLimit(String separatorPattern, int maxItems) {
        return Splitter.onPattern(separatorPattern).limit(maxItems);
    }


    private static Splitter splitterOnOmitEmptyStrings(char separator) {
        return Splitter.on(separator).omitEmptyStrings();
    }

    private static Splitter splitterOnOmitEmptyStrings(final CharMatcher separatorMatcher) {
        return Splitter.on(separatorMatcher).omitEmptyStrings();
    }

    private static Splitter splitterOnOmitEmptyStrings(final String separator) {
        return Splitter.on(separator).omitEmptyStrings();
    }

    private static Splitter splitterOnOmitEmptyStrings(Pattern separatorPattern) {
        return Splitter.on(separatorPattern).omitEmptyStrings();
    }

    private static Splitter splitterOnPatternOmitEmptyStrings(String separatorPattern) {
        return Splitter.onPattern(separatorPattern).omitEmptyStrings();
    }

    private static Splitter splitterOnTrimResults(char separator) {
        return Splitter.on(separator).trimResults();
    }

    private static Splitter splitterOnTrimResults(final CharMatcher separatorMatcher) {
        return Splitter.on(separatorMatcher).trimResults();
    }

    private static Splitter splitterOnTrimResults(final String separator) {
        return Splitter.on(separator).trimResults();
    }

    private static Splitter splitterOnTrimResults(Pattern separatorPattern) {
        return Splitter.on(separatorPattern).trimResults();
    }

    private static Splitter splitterOnPatternTrimResults(String separatorPattern) {
        return Splitter.onPattern(separatorPattern).trimResults();
    }


    private static Splitter splitterOnTrimResults(char separator, CharMatcher trimmer) {
        return Splitter.on(separator).trimResults(trimmer);
    }

    private static Splitter splitterOnTrimResults(final CharMatcher separatorMatcher, CharMatcher trimmer) {
        return Splitter.on(separatorMatcher).trimResults(trimmer);
    }

    private static Splitter splitterOnTrimResults(final String separator, CharMatcher trimmer) {
        return Splitter.on(separator).trimResults(trimmer);
    }

    private static Splitter splitterOnTrimResults(Pattern separatorPattern, CharMatcher trimmer) {
        return Splitter.on(separatorPattern).trimResults(trimmer);
    }

    private static Splitter splitterOnPatternTrimResults(String separatorPattern, CharMatcher trimmer) {
        return Splitter.onPattern(separatorPattern).trimResults(trimmer);
    }

    public static Iterable<String> splitterSplit(char separator, final CharSequence sequence) {
        return splitterOn(separator).split(sequence);
    }

    public static List<String> splitterSplitToList(char separator, final CharSequence sequence) {
        return splitterOn(separator).splitToList(sequence);
    }

    public static Stream<String> splitterSplitToStream(char separator, final CharSequence sequence) {
        return splitterOn(separator).splitToStream(sequence);
    }

    public static Map<String, String> splitterWithKeyValueSeparatorSplit(char separator, char keyValueSplitter, final CharSequence sequence) {
        return splitterOn(separator).withKeyValueSeparator(keyValueSplitter).split(sequence);
    }

    public static Map<String, String> splitterWithKeyValueSeparatorSplit(char separator, String keyValueSplitter, final CharSequence sequence) {
        return splitterOn(separator).withKeyValueSeparator(keyValueSplitter).split(sequence);
    }

    public static Map<String, String> splitterWithKeyValueSeparatorSplit(char separator, Splitter keyValueSplitter, final CharSequence sequence) {
        return splitterOn(separator).withKeyValueSeparator(keyValueSplitter).split(sequence);
    }


    public static void main(String[] args) {
        String str = "";
//        System.out.println(Joiner.on('-').join(Lists.newArrayList("a","b","c",null)));
        System.out.println(Joiner.on('-').skipNulls().join(Lists.newArrayList("a", "b", "c", null)));
        System.out.println(Joiner.on("-").useForNull("null").join(Lists.newArrayList("a", "b", "c", null)));
        System.out.println(Joiner.on(":").join("ss", "aa", "cc", "dd", "qq", "null"));
        System.out.println(JSON.toJSONString(Splitter.on(":").split("1:2:3:4:")));
        System.out.println(JSON.toJSONString(new String("1:2:3:4:").split(":")));
        System.out.println(StringHelper.joinerSkipNulls(":", Arrays.asList("1", "2", "3", "")));
        System.out.println(JSON.toJSONString(splitterOn(":").split("1:2:3:")));
        ;
    }
}
