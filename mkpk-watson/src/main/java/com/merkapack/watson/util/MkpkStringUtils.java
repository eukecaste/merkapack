package com.merkapack.watson.util;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;


/**
 * <p>
 * Operations on {@link java.lang.String} that are {@code null} safe.
 * </p>
 *
 * <ul>
 * <li><b>IsEmpty/IsBlank</b> - checks if a String contains text</li>
 * <li><b>Trim/Strip</b> - removes leading and trailing whitespace</li>
 * <li><b>Equals</b> - compares two strings null-safe</li>
 * <li><b>startsWith</b> - check if a String starts with a prefix null-safe</li>
 * <li><b>endsWith</b> - check if a String ends with a suffix null-safe</li>
 * <li><b>IndexOf/LastIndexOf/Contains</b> - null-safe index-of checks
 * <li><b>IndexOfAny/LastIndexOfAny/IndexOfAnyBut/LastIndexOfAnyBut</b> -
 * index-of any of a set of Strings</li>
 * <li><b>ContainsOnly/ContainsNone/ContainsAny</b> - does String contains
 * only/none/any of these characters</li>
 * <li><b>Substring/Left/Right/Mid</b> - null-safe substring extractions</li>
 * <li><b>SubstringBefore/SubstringAfter/SubstringBetween</b> - substring
 * extraction relative to other strings</li>
 * <li><b>Split/Join</b> - splits a String into an array of substrings and vice
 * versa</li>
 * <li><b>Remove/Delete</b> - removes part of a String</li>
 * <li><b>Replace/Overlay</b> - Searches a String and replaces one String with
 * another</li>
 * <li><b>Chomp/Chop</b> - removes the last part of a String</li>
 * <li><b>AppendIfMissing</b> - appends a suffix to the end of the String if not
 * present</li>
 * <li><b>PrependIfMissing</b> - prepends a prefix to the start of the String if
 * not present</li>
 * <li><b>LeftPad/RightPad/Center/Repeat</b> - pads a String</li>
 * <li><b>UpperCase/LowerCase/SwapCase/Capitalize/Uncapitalize</b> - changes the
 * case of a String</li>
 * <li><b>CountMatches</b> - counts the number of occurrences of one String in
 * another</li>
 * <li><b>IsAlpha/IsNumeric/IsWhitespace/IsAsciiPrintable</b> - checks the
 * characters in a String</li>
 * <li><b>DefaultString</b> - protects against a null input String</li>
 * <li><b>Reverse/ReverseDelimited</b> - reverses a String</li>
 * <li><b>Abbreviate</b> - abbreviates a string using ellipsis</li>
 * <li><b>Difference</b> - compares Strings and reports on their differences</li>
 * <li><b>LevenshteinDistance</b> - the number of changes needed to change one
 * String into another</li>
 * </ul>
 *
 * <p>
 * The {@code StringUtils} class defines certain words related to String
 * handling.
 * </p>
 *
 * <ul>
 * <li>null - {@code null}</li>
 * <li>empty - a zero-length string ({@code ""})</li>
 * <li>space - the space character ({@code ' '}, char 32)</li>
 * <li>whitespace - the characters defined by
 * {@link Character#isWhitespace(char)}</li>
 * <li>trim - the characters &lt;= 32 as in {@link String#trim()}</li>
 * </ul>
 *
 * <p>
 * {@code StringUtils} handles {@code null} input Strings quietly. That is to
 * say that a {@code null} input will return {@code null}. Where a
 * {@code boolean} or {@code int} is being returned details vary by method.
 * </p>
 *
 * <p>
 * A side effect of the {@code null} handling is that a
 * {@code NullPointerException} should be considered a bug in
 * {@code StringUtils}.
 * </p>
 *
 * <p>
 * Methods in this class give sample code to explain their operation. The symbol
 * {@code *} is used to indicate any input including {@code null}.
 * </p>
 *
 * <p>
 * #ThreadSafe#
 * </p>
 * 
 * @see java.lang.String
 * @since 1.0
 * @version $Id$
 */
// @Immutable
public class MkpkStringUtils {

	// Performance testing notes (JDK 1.4, Jul03, scolebourne)
	// Whitespace:
	// Character.isWhitespace() is faster than WHITESPACE.indexOf()
	// where WHITESPACE is a string of all whitespace characters
	//
	// Character access:
	// String.charAt(n) versus toCharArray(), then array[n]
	// String.charAt(n) is about 15% worse for a 10K string
	// They are about equal for a length 50 string
	// String.charAt(n) is about 4 times better for a length 3 string
	// String.charAt(n) is best bet overall
	//
	// Append:
	// String.concat about twice as fast as StringBuffer.append
	// (not sure who tested this)
	/**
	 * A String for a space character.
	 *
	 * @since 3.2
	 */
	public static final String SPACE = " ";
	public static final String  PLUS = "+";
	public static final String DOT = ".";
	public static final String COMMA = ",";
	public static final String BULLET = "\u2022";
	public static final String PERCENT = "%";
	public static final String ASTERISK = "*";
	public static final String COLON = ":";
	public static final String HYPHEN = "-";
	public static final String UNDERSCORE = "_";
	public static final String QUESTION = "?";
	public static final String BACKSLASH = "\\";
	public static final String SLASH = "/";
	public static final String EQUAL = "=";
	public static final String OPEN_BRACKET = "[";
	public static final String CLOSE_BRACKET = "]";
	public static final String OPEN_PARENTHESIS = "(";
	public static final String CLOSE_PARENTHESIS= ")";
	public static final String ZERO = "0";
	public static final String ONE = "1";
	public static final String TWO = "2";
	public static final String THREE = "3";
	public static final String FOUR = "4";
	public static final String FIVE = "5";
	public static final String SIX = "6";
	public static final String SEVEN = "7";
	public static final String EIGHT = "8";
	public static final String NINE = "9";
	public static final String CR_LF = "\r\n";
	
	/**
     * Eight-bit Unicode Transformation Format.
     * <p>
     * Every implementation of the Java platform is required to support this character encoding.
     *
     * @see <a href="http://download.oracle.com/javase/6/docs/api/java/nio/charset/Charset.html">Standard charsets</a>
     */
    public static final String UTF_8 = "UTF-8";

	/**
	 * The empty String {@code ""}.
	 * 
	 * @since 2.0
	 */
	public static final String EMPTY = "";
	/**
	 * A String for linefeed LF ("\n").
	 *
	 * @see <a
	 *      href="http://docs.oracle.com/javase/specs/jls/se7/html/jls-3.html#jls-3.10.6">JLF:
	 *      Escape Sequences for Character and String Literals</a>
	 * @since 3.2
	 */
	public static final String LF = "\n";
	/**
	 * A String for carriage return CR ("\r").
	 *
	 * @see <a
	 *      href="http://docs.oracle.com/javase/specs/jls/se7/html/jls-3.html#jls-3.10.6">JLF:
	 *      Escape Sequences for Character and String Literals</a>
	 * @since 3.2
	 */
	public static final String CR = "\r";
	/**
	 * Represents a failed index search.
	 * 
	 * @since 2.1
	 */
	public static final int INDEX_NOT_FOUND = -1;
	/**
	 * <p>
	 * The maximum size to which the padding constant(s) can expand.
	 * </p>
	 */
	private static final int PAD_LIMIT = 8192;
	
	
	
	

	/**
	 * <p>
	 * {@code StringUtils} instances should NOT be constructed in standard
	 * programming. Instead, the class should be used as
	 * {@code StringUtils.trim(" foo ");}.
	 * </p>
	 *
	 * <p>
	 * This constructor is public to permit tools that require a JavaBean
	 * instance to operate.
	 * </p>
	 */
	public MkpkStringUtils() {
		super();
	}

	// SQL like 
	public static String SQLlike(final String str) {
		return isEmpty(str)?null:PERCENT + trim(str) + PERCENT;
	}

	// Empty checks
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks if a CharSequence is empty ("") or null.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isEmpty(null) = true
	 * StringUtils.isEmpty("") = true
	 * StringUtils.isEmpty(" ") = false
	 * StringUtils.isEmpty("bob") = false
	 * StringUtils.isEmpty(" bob ") = false
	 * </pre>
	 *
	 * <p>
	 * NOTE: This method changed in Lang version 2.0. It no longer trims the
	 * CharSequence. That functionality is available in isBlank().
	 * </p>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is empty or null
	 * @since 3.0 Changed signature from isEmpty(String) to
	 *        isEmpty(CharSequence)
	 */
	public static boolean isEmpty(final CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

	/**
	 * <p>
	 * Checks if a CharSequence is not empty ("") and not null.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isNotEmpty(null) = false
	 * StringUtils.isNotEmpty("") = false
	 * StringUtils.isNotEmpty(" ") = true
	 * StringUtils.isNotEmpty("bob") = true
	 * StringUtils.isNotEmpty(" bob ") = true
	 * </pre>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is not empty and not null
	 * @since 3.0 Changed signature from isNotEmpty(String) to
	 *        isNotEmpty(CharSequence)
	 */
	public static boolean isNotEmpty(final CharSequence cs) {
		return !isEmpty(cs);
	}

	/**
	 * <p>
	 * Checks if any one of the CharSequences are empty ("") or null.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isAnyEmpty(null) = true
	 * StringUtils.isAnyEmpty(null, "foo") = true
	 * StringUtils.isAnyEmpty("", "bar") = true
	 * StringUtils.isAnyEmpty("bob", "") = true
	 * StringUtils.isAnyEmpty(" bob ", null) = true
	 * StringUtils.isAnyEmpty(" ", "bar") = false
	 * StringUtils.isAnyEmpty("foo", "bar") = false
	 * </pre>
	 *
	 * @param css
	 *            the CharSequences to check, may be null or empty
	 * @return {@code true} if any of the CharSequences are empty or null
	 * @since 3.2
	 */
	public static boolean isAnyEmpty(final CharSequence... css) {
		if (MkpkArrayUtils.isEmpty(css)) {
			return true;
		}
		for (final CharSequence cs : css) {
			if (isEmpty(cs)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <p>
	 * Checks if none of the CharSequences are empty ("") or null.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isNoneEmpty(null) = false
	 * StringUtils.isNoneEmpty(null, "foo") = false
	 * StringUtils.isNoneEmpty("", "bar") = false
	 * StringUtils.isNoneEmpty("bob", "") = false
	 * StringUtils.isNoneEmpty(" bob ", null) = false
	 * StringUtils.isNoneEmpty(" ", "bar") = true
	 * StringUtils.isNoneEmpty("foo", "bar") = true
	 * </pre>
	 *
	 * @param css
	 *            the CharSequences to check, may be null or empty
	 * @return {@code true} if none of the CharSequences are empty or null
	 * @since 3.2
	 */
	public static boolean isNoneEmpty(final CharSequence... css) {
		return !isAnyEmpty(css);
	}

	/**
	 * <p>
	 * Checks if a CharSequence is whitespace, empty ("") or null.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isBlank(null) = true
	 * StringUtils.isBlank("") = true
	 * StringUtils.isBlank(" ") = true
	 * StringUtils.isBlank("bob") = false
	 * StringUtils.isBlank(" bob ") = false
	 * </pre>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is null, empty or whitespace
	 * @since 2.0
	 * @since 3.0 Changed signature from isBlank(String) to
	 *        isBlank(CharSequence)
	 */
	public static boolean isBlank(String cs) {
		if (cs == null || (cs.length()) == 0) {
			return true;
		}
		return trimToNull(cs) == null;
	}

	/**
	 * <p>
	 * Checks if a CharSequence is not empty (""), not null and not whitespace
	 * only.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isNotBlank(null) = false
	 * StringUtils.isNotBlank("") = false
	 * StringUtils.isNotBlank(" ") = false
	 * StringUtils.isNotBlank("bob") = true
	 * StringUtils.isNotBlank(" bob ") = true
	 * </pre>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is not empty and not null and
	 *         not whitespace
	 * @since 2.0
	 * @since 3.0 Changed signature from isNotBlank(String) to
	 *        isNotBlank(CharSequence)
	 */
	public static boolean isNotBlank(String cs) {
		return !isBlank(cs);
	}

	// Trim
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Removes control characters (char &lt;= 32) from both ends of this String,
	 * handling {@code null} by returning {@code null}.
	 * </p>
	 *
	 * <p>
	 * The String is trimmed using {@link String#trim()}. Trim removes start and
	 * end characters &lt;= 32. To strip whitespace use {@link #strip(String)}.
	 * </p>
	 *
	 * <p>
	 * To trim your choice of characters, use the {@link #strip(String, String)}
	 * methods.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.trim(null) = null
	 * StringUtils.trim("") = ""
	 * StringUtils.trim(" ") = ""
	 * StringUtils.trim("abc") = "abc"
	 * StringUtils.trim(" abc ") = "abc"
	 * </pre>
	 *
	 * @param str
	 *            the String to be trimmed, may be null
	 * @return the trimmed string, {@code null} if null String input
	 */
	public static String trim(final String str) {
		return str == null ? null : str.trim();
	}

	/**
	 * <p>
	 * Removes control characters (char &lt;= 32) from both ends of this String
	 * returning {@code null} if the String is empty ("") after the trim or if
	 * it is {@code null}.
	 *
	 * <p>
	 * The String is trimmed using {@link String#trim()}. Trim removes start and
	 * end characters &lt;= 32. To strip whitespace use
	 * {@link #stripToNull(String)}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.trimToNull(null) = null
	 * StringUtils.trimToNull("") = null
	 * StringUtils.trimToNull(" ") = null
	 * StringUtils.trimToNull("abc") = "abc"
	 * StringUtils.trimToNull(" abc ") = "abc"
	 * </pre>
	 *
	 * @param str
	 *            the String to be trimmed, may be null
	 * @return the trimmed String, {@code null} if only chars &lt;= 32, empty or
	 *         null String input
	 * @since 2.0
	 */
	public static String trimToNull(final String str) {
		final String ts = trim(str);
		return isEmpty(ts) ? null : ts;
	}

	/**
	 * <p>
	 * Removes control characters (char &lt;= 32) from both ends of this String
	 * returning an empty String ("") if the String is empty ("") after the trim
	 * or if it is {@code null}.
	 *
	 * <p>
	 * The String is trimmed using {@link String#trim()}. Trim removes start and
	 * end characters &lt;= 32. To strip whitespace use
	 * {@link #stripToEmpty(String)}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.trimToEmpty(null) = ""
	 * StringUtils.trimToEmpty("") = ""
	 * StringUtils.trimToEmpty(" ") = ""
	 * StringUtils.trimToEmpty("abc") = "abc"
	 * StringUtils.trimToEmpty(" abc ") = "abc"
	 * </pre>
	 *
	 * @param str
	 *            the String to be trimmed, may be null
	 * @return the trimmed String, or an empty String if {@code null} input
	 * @since 2.0
	 */
	public static String trimToEmpty(final String str) {
		return str == null ? EMPTY : str.trim();
	}

	// Equals
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Compares two CharSequences, returning {@code true} if they represent
	 * equal sequences of characters.
	 * </p>
	 *
	 * <p>
	 * {@code null}s are handled without exceptions. Two {@code null} references
	 * are considered to be equal. The comparison is case sensitive.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.equals(null, null) = true
	 * StringUtils.equals(null, "abc") = false
	 * StringUtils.equals("abc", null) = false
	 * StringUtils.equals("abc", "abc") = true
	 * StringUtils.equals("abc", "ABC") = false
	 * </pre>
	 *
	 * @see Object#equals(Object)
	 * @param cs1
	 *            the first CharSequence, may be {@code null}
	 * @param cs2
	 *            the second CharSequence, may be {@code null}
	 * @return {@code true} if the CharSequences are equal (case-sensitive), or
	 *         both {@code null}
	 * @since 3.0 Changed signature from equals(String, String) to
	 *        equals(CharSequence, CharSequence)
	 */
	public static boolean equals(final CharSequence cs1, final CharSequence cs2) {
		if (cs1 == cs2) {
			return true;
		}
		if (cs1 == null || cs2 == null) {
			return false;
		}
		if (cs1 instanceof String && cs2 instanceof String) {
			return cs1.equals(cs2);
		}
		return MkpkCharSequenceUtils.regionMatches(cs1, false, 0, cs2, 0,
				Math.max(cs1.length(), cs2.length()));
	}

	/**
	 * <p>
	 * Compares two CharSequences, returning {@code true} if they represent
	 * equal sequences of characters, ignoring case.
	 * </p>
	 *
	 * <p>
	 * {@code null}s are handled without exceptions. Two {@code null} references
	 * are considered equal. Comparison is case insensitive.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.equalsIgnoreCase(null, null) = true
	 * StringUtils.equalsIgnoreCase(null, "abc") = false
	 * StringUtils.equalsIgnoreCase("abc", null) = false
	 * StringUtils.equalsIgnoreCase("abc", "abc") = true
	 * StringUtils.equalsIgnoreCase("abc", "ABC") = true
	 * </pre>
	 *
	 * @param str1
	 *            the first CharSequence, may be null
	 * @param str2
	 *            the second CharSequence, may be null
	 * @return {@code true} if the CharSequence are equal, case insensitive, or
	 *         both {@code null}
	 * @since 3.0 Changed signature from equalsIgnoreCase(String, String) to
	 *        equalsIgnoreCase(CharSequence, CharSequence)
	 */
	public static boolean equalsIgnoreCase(final CharSequence str1,
			final CharSequence str2) {
		if (str1 == null || str2 == null) {
			return str1 == str2;
		} else if (str1 == str2) {
			return true;
		} else if (str1.length() != str2.length()) {
			return false;
		} else {
			return MkpkCharSequenceUtils.regionMatches(str1, true, 0, str2, 0,
					str1.length());
		}
	}

	// IndexOf
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Finds the first index within a CharSequence, handling {@code null}. This
	 * method uses {@link String#indexOf(int, int)} if possible.
	 * </p>
	 *
	 * <p>
	 * A {@code null} or empty ("") CharSequence will return
	 * {@code INDEX_NOT_FOUND (-1)}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.indexOf(null, *) = -1
	 * StringUtils.indexOf("", *) = -1
	 * StringUtils.indexOf("aabaabaa", 'a') = 0
	 * StringUtils.indexOf("aabaabaa", 'b') = 2
	 * </pre>
	 *
	 * @param seq
	 *            the CharSequence to check, may be null
	 * @param searchChar
	 *            the character to find
	 * @return the first index of the search character, -1 if no match or
	 *         {@code null} string input
	 * @since 2.0
	 * @since 3.0 Changed signature from indexOf(String, int) to
	 *        indexOf(CharSequence, int)
	 */
	public static int indexOf(final CharSequence seq, final int searchChar) {
		if (isEmpty(seq)) {
			return INDEX_NOT_FOUND;
		}
		return MkpkCharSequenceUtils.indexOf(seq, searchChar, 0);
	}

	/**
	 * <p>
	 * Finds the first index within a CharSequence from a start position,
	 * handling {@code null}. This method uses {@link String#indexOf(int, int)}
	 * if possible.
	 * </p>
	 *
	 * <p>
	 * A {@code null} or empty ("") CharSequence will return
	 * {@code (INDEX_NOT_FOUND) -1}. A negative start position is treated as
	 * zero. A start position greater than the string length returns {@code -1}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.indexOf(null, *, *) = -1
	 * StringUtils.indexOf("", *, *) = -1
	 * StringUtils.indexOf("aabaabaa", 'b', 0) = 2
	 * StringUtils.indexOf("aabaabaa", 'b', 3) = 5
	 * StringUtils.indexOf("aabaabaa", 'b', 9) = -1
	 * StringUtils.indexOf("aabaabaa", 'b', -1) = 2
	 * </pre>
	 *
	 * @param seq
	 *            the CharSequence to check, may be null
	 * @param searchChar
	 *            the character to find
	 * @param startPos
	 *            the start position, negative treated as zero
	 * @return the first index of the search character (always &ge; startPos),
	 *         -1 if no match or {@code null} string input
	 * @since 2.0
	 * @since 3.0 Changed signature from indexOf(String, int, int) to
	 *        indexOf(CharSequence, int, int)
	 */
	public static int indexOf(final CharSequence seq, final int searchChar,
			final int startPos) {
		if (isEmpty(seq)) {
			return INDEX_NOT_FOUND;
		}
		return MkpkCharSequenceUtils.indexOf(seq, searchChar, startPos);
	}

	/**
	 * <p>
	 * Finds the first index within a CharSequence, handling {@code null}. This
	 * method uses {@link String#indexOf(String, int)} if possible.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code -1}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.indexOf(null, *) = -1
	 * StringUtils.indexOf(*, null) = -1
	 * StringUtils.indexOf("", "") = 0
	 * StringUtils.indexOf("", *) = -1 (except when * = "")
	 * StringUtils.indexOf("aabaabaa", "a") = 0
	 * StringUtils.indexOf("aabaabaa", "b") = 2
	 * StringUtils.indexOf("aabaabaa", "ab") = 1
	 * StringUtils.indexOf("aabaabaa", "") = 0
	 * </pre>
	 *
	 * @param seq
	 *            the CharSequence to check, may be null
	 * @param searchSeq
	 *            the CharSequence to find, may be null
	 * @return the first index of the search CharSequence, -1 if no match or
	 *         {@code null} string input
	 * @since 2.0
	 * @since 3.0 Changed signature from indexOf(String, String) to
	 *        indexOf(CharSequence, CharSequence)
	 */
	public static int indexOf(final CharSequence seq,
			final CharSequence searchSeq) {
		if (seq == null || searchSeq == null) {
			return INDEX_NOT_FOUND;
		}
		return MkpkCharSequenceUtils.indexOf(seq, searchSeq, 0);
	}

	/**
	 * <p>
	 * Finds the first index within a CharSequence, handling {@code null}. This
	 * method uses {@link String#indexOf(String, int)} if possible.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code -1}. A negative start
	 * position is treated as zero. An empty ("") search CharSequence always
	 * matches. A start position greater than the string length only matches an
	 * empty search CharSequence.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.indexOf(null, *, *) = -1
	 * StringUtils.indexOf(*, null, *) = -1
	 * StringUtils.indexOf("", "", 0) = 0
	 * StringUtils.indexOf("", *, 0) = -1 (except when * = "")
	 * StringUtils.indexOf("aabaabaa", "a", 0) = 0
	 * StringUtils.indexOf("aabaabaa", "b", 0) = 2
	 * StringUtils.indexOf("aabaabaa", "ab", 0) = 1
	 * StringUtils.indexOf("aabaabaa", "b", 3) = 5
	 * StringUtils.indexOf("aabaabaa", "b", 9) = -1
	 * StringUtils.indexOf("aabaabaa", "b", -1) = 2
	 * StringUtils.indexOf("aabaabaa", "", 2) = 2
	 * StringUtils.indexOf("abc", "", 9) = 3
	 * </pre>
	 *
	 * @param seq
	 *            the CharSequence to check, may be null
	 * @param searchSeq
	 *            the CharSequence to find, may be null
	 * @param startPos
	 *            the start position, negative treated as zero
	 * @return the first index of the search CharSequence (always &ge;
	 *         startPos), -1 if no match or {@code null} string input
	 * @since 2.0
	 * @since 3.0 Changed signature from indexOf(String, String, int) to
	 *        indexOf(CharSequence, CharSequence, int)
	 */
	public static int indexOf(final CharSequence seq,
			final CharSequence searchSeq, final int startPos) {
		if (seq == null || searchSeq == null) {
			return INDEX_NOT_FOUND;
		}
		return MkpkCharSequenceUtils.indexOf(seq, searchSeq, startPos);
	}

	/**
	 * <p>
	 * Finds the n-th index within a CharSequence, handling {@code null}. This
	 * method uses {@link String#indexOf(String)} if possible.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code -1}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.ordinalIndexOf(null, *, *) = -1
	 * StringUtils.ordinalIndexOf(*, null, *) = -1
	 * StringUtils.ordinalIndexOf("", "", *) = 0
	 * StringUtils.ordinalIndexOf("aabaabaa", "a", 1) = 0
	 * StringUtils.ordinalIndexOf("aabaabaa", "a", 2) = 1
	 * StringUtils.ordinalIndexOf("aabaabaa", "b", 1) = 2
	 * StringUtils.ordinalIndexOf("aabaabaa", "b", 2) = 5
	 * StringUtils.ordinalIndexOf("aabaabaa", "ab", 1) = 1
	 * StringUtils.ordinalIndexOf("aabaabaa", "ab", 2) = 4
	 * StringUtils.ordinalIndexOf("aabaabaa", "", 1) = 0
	 * StringUtils.ordinalIndexOf("aabaabaa", "", 2) = 0
	 * </pre>
	 *
	 * <p>
	 * Note that 'head(CharSequence str, int n)' may be implemented as:
	 * </p>
	 *
	 * <pre>
	 * str.substring(0, lastOrdinalIndexOf(str, &quot;\n&quot;, n))
	 * </pre>
	 *
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param searchStr
	 *            the CharSequence to find, may be null
	 * @param ordinal
	 *            the n-th {@code searchStr} to find
	 * @return the n-th index of the search CharSequence, {@code -1} (
	 *         {@code INDEX_NOT_FOUND}) if no match or {@code null} string input
	 * @since 2.1
	 * @since 3.0 Changed signature from ordinalIndexOf(String, String, int) to
	 *        ordinalIndexOf(CharSequence, CharSequence, int)
	 */
	public static int ordinalIndexOf(final CharSequence str,
			final CharSequence searchStr, final int ordinal) {
		return ordinalIndexOf(str, searchStr, ordinal, false);
	}

	/**
	 * <p>
	 * Finds the n-th index within a String, handling {@code null}. This method
	 * uses {@link String#indexOf(String)} if possible.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code -1}.
	 * </p>
	 *
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param searchStr
	 *            the CharSequence to find, may be null
	 * @param ordinal
	 *            the n-th {@code searchStr} to find
	 * @param lastIndex
	 *            true if lastOrdinalIndexOf() otherwise false if
	 *            ordinalIndexOf()
	 * @return the n-th index of the search CharSequence, {@code -1} (
	 *         {@code INDEX_NOT_FOUND}) if no match or {@code null} string input
	 */
	// Shared code between ordinalIndexOf(String,String,int) and
	// lastOrdinalIndexOf(String,String,int)
	private static int ordinalIndexOf(final CharSequence str,
			final CharSequence searchStr, final int ordinal,
			final boolean lastIndex) {
		if (str == null || searchStr == null || ordinal <= 0) {
			return INDEX_NOT_FOUND;
		}
		if (searchStr.length() == 0) {
			return lastIndex ? str.length() : 0;
		}
		int found = 0;
		int index = lastIndex ? str.length() : INDEX_NOT_FOUND;
		do {
			if (lastIndex) {
				index = MkpkCharSequenceUtils.lastIndexOf(str, searchStr,
						index - 1);
			} else {
				index = MkpkCharSequenceUtils.indexOf(str, searchStr, index + 1);
			}
			if (index < 0) {
				return index;
			}
			found++;
		} while (found < ordinal);
		return index;
	}

	/**
	 * <p>
	 * Case in-sensitive find of the first index within a CharSequence.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code -1}. A negative start
	 * position is treated as zero. An empty ("") search CharSequence always
	 * matches. A start position greater than the string length only matches an
	 * empty search CharSequence.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.indexOfIgnoreCase(null, *) = -1
	 * StringUtils.indexOfIgnoreCase(*, null) = -1
	 * StringUtils.indexOfIgnoreCase("", "") = 0
	 * StringUtils.indexOfIgnoreCase("aabaabaa", "a") = 0
	 * StringUtils.indexOfIgnoreCase("aabaabaa", "b") = 2
	 * StringUtils.indexOfIgnoreCase("aabaabaa", "ab") = 1
	 * </pre>
	 *
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param searchStr
	 *            the CharSequence to find, may be null
	 * @return the first index of the search CharSequence, -1 if no match or
	 *         {@code null} string input
	 * @since 2.5
	 * @since 3.0 Changed signature from indexOfIgnoreCase(String, String) to
	 *        indexOfIgnoreCase(CharSequence, CharSequence)
	 */
	public static int indexOfIgnoreCase(final CharSequence str,
			final CharSequence searchStr) {
		return indexOfIgnoreCase(str, searchStr, 0);
	}

	/**
	 * <p>
	 * Case in-sensitive find of the first index within a CharSequence from the
	 * specified position.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code -1}. A negative start
	 * position is treated as zero. An empty ("") search CharSequence always
	 * matches. A start position greater than the string length only matches an
	 * empty search CharSequence.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.indexOfIgnoreCase(null, *, *) = -1
	 * StringUtils.indexOfIgnoreCase(*, null, *) = -1
	 * StringUtils.indexOfIgnoreCase("", "", 0) = 0
	 * StringUtils.indexOfIgnoreCase("aabaabaa", "A", 0) = 0
	 * StringUtils.indexOfIgnoreCase("aabaabaa", "B", 0) = 2
	 * StringUtils.indexOfIgnoreCase("aabaabaa", "AB", 0) = 1
	 * StringUtils.indexOfIgnoreCase("aabaabaa", "B", 3) = 5
	 * StringUtils.indexOfIgnoreCase("aabaabaa", "B", 9) = -1
	 * StringUtils.indexOfIgnoreCase("aabaabaa", "B", -1) = 2
	 * StringUtils.indexOfIgnoreCase("aabaabaa", "", 2) = 2
	 * StringUtils.indexOfIgnoreCase("abc", "", 9) = 3
	 * </pre>
	 *
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param searchStr
	 *            the CharSequence to find, may be null
	 * @param startPos
	 *            the start position, negative treated as zero
	 * @return the first index of the search CharSequence (always &ge;
	 *         startPos), -1 if no match or {@code null} string input
	 * @since 2.5
	 * @since 3.0 Changed signature from indexOfIgnoreCase(String, String, int)
	 *        to indexOfIgnoreCase(CharSequence, CharSequence, int)
	 */
	public static int indexOfIgnoreCase(final CharSequence str,
			final CharSequence searchStr, int startPos) {
		if (str == null || searchStr == null) {
			return INDEX_NOT_FOUND;
		}
		if (startPos < 0) {
			startPos = 0;
		}
		final int endLimit = str.length() - searchStr.length() + 1;
		if (startPos > endLimit) {
			return INDEX_NOT_FOUND;
		}
		if (searchStr.length() == 0) {
			return startPos;
		}
		for (int i = startPos; i < endLimit; i++) {
			if (MkpkCharSequenceUtils.regionMatches(str, true, i, searchStr, 0,
					searchStr.length())) {
				return i;
			}
		}
		return INDEX_NOT_FOUND;
	}

	// LastIndexOf
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Finds the last index within a CharSequence, handling {@code null}. This
	 * method uses {@link String#lastIndexOf(int)} if possible.
	 * </p>
	 *
	 * <p>
	 * A {@code null} or empty ("") CharSequence will return {@code -1}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.lastIndexOf(null, *) = -1
	 * StringUtils.lastIndexOf("", *) = -1
	 * StringUtils.lastIndexOf("aabaabaa", 'a') = 7
	 * StringUtils.lastIndexOf("aabaabaa", 'b') = 5
	 * </pre>
	 *
	 * @param seq
	 *            the CharSequence to check, may be null
	 * @param searchChar
	 *            the character to find
	 * @return the last index of the search character, -1 if no match or
	 *         {@code null} string input
	 * @since 2.0
	 * @since 3.0 Changed signature from lastIndexOf(String, int) to
	 *        lastIndexOf(CharSequence, int)
	 */
	public static int lastIndexOf(final CharSequence seq, final int searchChar) {
		if (isEmpty(seq)) {
			return INDEX_NOT_FOUND;
		}
		return MkpkCharSequenceUtils.lastIndexOf(seq, searchChar, seq.length());
	}

	/**
	 * <p>
	 * Finds the last index within a CharSequence from a start position,
	 * handling {@code null}. This method uses
	 * {@link String#lastIndexOf(int, int)} if possible.
	 * </p>
	 *
	 * <p>
	 * A {@code null} or empty ("") CharSequence will return {@code -1}. A
	 * negative start position returns {@code -1}. A start position greater than
	 * the string length searches the whole string. The search starts at the
	 * startPos and works backwards; matches starting after the start position
	 * are ignored.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.lastIndexOf(null, *, *) = -1
	 * StringUtils.lastIndexOf("", *, *) = -1
	 * StringUtils.lastIndexOf("aabaabaa", 'b', 8) = 5
	 * StringUtils.lastIndexOf("aabaabaa", 'b', 4) = 2
	 * StringUtils.lastIndexOf("aabaabaa", 'b', 0) = -1
	 * StringUtils.lastIndexOf("aabaabaa", 'b', 9) = 5
	 * StringUtils.lastIndexOf("aabaabaa", 'b', -1) = -1
	 * StringUtils.lastIndexOf("aabaabaa", 'a', 0) = 0
	 * </pre>
	 *
	 * @param seq
	 *            the CharSequence to check, may be null
	 * @param searchChar
	 *            the character to find
	 * @param startPos
	 *            the start position
	 * @return the last index of the search character (always &le; startPos), -1
	 *         if no match or {@code null} string input
	 * @since 2.0
	 * @since 3.0 Changed signature from lastIndexOf(String, int, int) to
	 *        lastIndexOf(CharSequence, int, int)
	 */
	public static int lastIndexOf(final CharSequence seq, final int searchChar,
			final int startPos) {
		if (isEmpty(seq)) {
			return INDEX_NOT_FOUND;
		}
		return MkpkCharSequenceUtils.lastIndexOf(seq, searchChar, startPos);
	}

	/**
	 * <p>
	 * Finds the last index within a CharSequence, handling {@code null}. This
	 * method uses {@link String#lastIndexOf(String)} if possible.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code -1}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.lastIndexOf(null, *) = -1
	 * StringUtils.lastIndexOf(*, null) = -1
	 * StringUtils.lastIndexOf("", "") = 0
	 * StringUtils.lastIndexOf("aabaabaa", "a") = 7
	 * StringUtils.lastIndexOf("aabaabaa", "b") = 5
	 * StringUtils.lastIndexOf("aabaabaa", "ab") = 4
	 * StringUtils.lastIndexOf("aabaabaa", "") = 8
	 * </pre>
	 *
	 * @param seq
	 *            the CharSequence to check, may be null
	 * @param searchSeq
	 *            the CharSequence to find, may be null
	 * @return the last index of the search String, -1 if no match or
	 *         {@code null} string input
	 * @since 2.0
	 * @since 3.0 Changed signature from lastIndexOf(String, String) to
	 *        lastIndexOf(CharSequence, CharSequence)
	 */
	public static int lastIndexOf(final CharSequence seq,
			final CharSequence searchSeq) {
		if (seq == null || searchSeq == null) {
			return INDEX_NOT_FOUND;
		}
		return MkpkCharSequenceUtils.lastIndexOf(seq, searchSeq, seq.length());
	}

	/**
	 * <p>
	 * Finds the n-th last index within a String, handling {@code null}. This
	 * method uses {@link String#lastIndexOf(String)}.
	 * </p>
	 *
	 * <p>
	 * A {@code null} String will return {@code -1}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.lastOrdinalIndexOf(null, *, *) = -1
	 * StringUtils.lastOrdinalIndexOf(*, null, *) = -1
	 * StringUtils.lastOrdinalIndexOf("", "", *) = 0
	 * StringUtils.lastOrdinalIndexOf("aabaabaa", "a", 1) = 7
	 * StringUtils.lastOrdinalIndexOf("aabaabaa", "a", 2) = 6
	 * StringUtils.lastOrdinalIndexOf("aabaabaa", "b", 1) = 5
	 * StringUtils.lastOrdinalIndexOf("aabaabaa", "b", 2) = 2
	 * StringUtils.lastOrdinalIndexOf("aabaabaa", "ab", 1) = 4
	 * StringUtils.lastOrdinalIndexOf("aabaabaa", "ab", 2) = 1
	 * StringUtils.lastOrdinalIndexOf("aabaabaa", "", 1) = 8
	 * StringUtils.lastOrdinalIndexOf("aabaabaa", "", 2) = 8
	 * </pre>
	 *
	 * <p>
	 * Note that 'tail(CharSequence str, int n)' may be implemented as:
	 * </p>
	 *
	 * <pre>
	 * str.substring(lastOrdinalIndexOf(str, &quot;\n&quot;, n) + 1)
	 * </pre>
	 *
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param searchStr
	 *            the CharSequence to find, may be null
	 * @param ordinal
	 *            the n-th last {@code searchStr} to find
	 * @return the n-th last index of the search CharSequence, {@code -1} (
	 *         {@code INDEX_NOT_FOUND}) if no match or {@code null} string input
	 * @since 2.5
	 * @since 3.0 Changed signature from lastOrdinalIndexOf(String, String, int)
	 *        to lastOrdinalIndexOf(CharSequence, CharSequence, int)
	 */
	public static int lastOrdinalIndexOf(final CharSequence str,
			final CharSequence searchStr, final int ordinal) {
		return ordinalIndexOf(str, searchStr, ordinal, true);
	}

	/**
	 * <p>
	 * Finds the last index within a CharSequence, handling {@code null}. This
	 * method uses {@link String#lastIndexOf(String, int)} if possible.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code -1}. A negative start
	 * position returns {@code -1}. An empty ("") search CharSequence always
	 * matches unless the start position is negative. A start position greater
	 * than the string length searches the whole string. The search starts at
	 * the startPos and works backwards; matches starting after the start
	 * position are ignored.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.lastIndexOf(null, *, *) = -1
	 * StringUtils.lastIndexOf(*, null, *) = -1
	 * StringUtils.lastIndexOf("aabaabaa", "a", 8) = 7
	 * StringUtils.lastIndexOf("aabaabaa", "b", 8) = 5
	 * StringUtils.lastIndexOf("aabaabaa", "ab", 8) = 4
	 * StringUtils.lastIndexOf("aabaabaa", "b", 9) = 5
	 * StringUtils.lastIndexOf("aabaabaa", "b", -1) = -1
	 * StringUtils.lastIndexOf("aabaabaa", "a", 0) = 0
	 * StringUtils.lastIndexOf("aabaabaa", "b", 0) = -1
	 * StringUtils.lastIndexOf("aabaabaa", "b", 1) = -1
	 * StringUtils.lastIndexOf("aabaabaa", "b", 2) = 2
	 * StringUtils.lastIndexOf("aabaabaa", "ba", 2) = -1
	 * StringUtils.lastIndexOf("aabaabaa", "ba", 2) = 2
	 * </pre>
	 *
	 * @param seq
	 *            the CharSequence to check, may be null
	 * @param searchSeq
	 *            the CharSequence to find, may be null
	 * @param startPos
	 *            the start position, negative treated as zero
	 * @return the last index of the search CharSequence (always &le; startPos),
	 *         -1 if no match or {@code null} string input
	 * @since 2.0
	 * @since 3.0 Changed signature from lastIndexOf(String, String, int) to
	 *        lastIndexOf(CharSequence, CharSequence, int)
	 */
	public static int lastIndexOf(final CharSequence seq,
			final CharSequence searchSeq, final int startPos) {
		if (seq == null || searchSeq == null) {
			return INDEX_NOT_FOUND;
		}
		return MkpkCharSequenceUtils.lastIndexOf(seq, searchSeq, startPos);
	}

	/**
	 * <p>
	 * Case in-sensitive find of the last index within a CharSequence.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code -1}. A negative start
	 * position returns {@code -1}. An empty ("") search CharSequence always
	 * matches unless the start position is negative. A start position greater
	 * than the string length searches the whole string.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.lastIndexOfIgnoreCase(null, *) = -1
	 * StringUtils.lastIndexOfIgnoreCase(*, null) = -1
	 * StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A") = 7
	 * StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B") = 5
	 * StringUtils.lastIndexOfIgnoreCase("aabaabaa", "AB") = 4
	 * </pre>
	 *
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param searchStr
	 *            the CharSequence to find, may be null
	 * @return the first index of the search CharSequence, -1 if no match or
	 *         {@code null} string input
	 * @since 2.5
	 * @since 3.0 Changed signature from lastIndexOfIgnoreCase(String, String)
	 *        to lastIndexOfIgnoreCase(CharSequence, CharSequence)
	 */
	public static int lastIndexOfIgnoreCase(final CharSequence str,
			final CharSequence searchStr) {
		if (str == null || searchStr == null) {
			return INDEX_NOT_FOUND;
		}
		return lastIndexOfIgnoreCase(str, searchStr, str.length());
	}

	/**
	 * <p>
	 * Case in-sensitive find of the last index within a CharSequence from the
	 * specified position.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code -1}. A negative start
	 * position returns {@code -1}. An empty ("") search CharSequence always
	 * matches unless the start position is negative. A start position greater
	 * than the string length searches the whole string. The search starts at
	 * the startPos and works backwards; matches starting after the start
	 * position are ignored.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.lastIndexOfIgnoreCase(null, *, *) = -1
	 * StringUtils.lastIndexOfIgnoreCase(*, null, *) = -1
	 * StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 8) = 7
	 * StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 8) = 5
	 * StringUtils.lastIndexOfIgnoreCase("aabaabaa", "AB", 8) = 4
	 * StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 9) = 5
	 * StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", -1) = -1
	 * StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 0) = 0
	 * StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 0) = -1
	 * </pre>
	 *
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param searchStr
	 *            the CharSequence to find, may be null
	 * @param startPos
	 *            the start position
	 * @return the last index of the search CharSequence (always &le; startPos),
	 *         -1 if no match or {@code null} input
	 * @since 2.5
	 * @since 3.0 Changed signature from lastIndexOfIgnoreCase(String, String,
	 *        int) to lastIndexOfIgnoreCase(CharSequence, CharSequence, int)
	 */
	public static int lastIndexOfIgnoreCase(final CharSequence str,
			final CharSequence searchStr, int startPos) {
		if (str == null || searchStr == null) {
			return INDEX_NOT_FOUND;
		}
		if (startPos > str.length() - searchStr.length()) {
			startPos = str.length() - searchStr.length();
		}
		if (startPos < 0) {
			return INDEX_NOT_FOUND;
		}
		if (searchStr.length() == 0) {
			return startPos;
		}
		for (int i = startPos; i >= 0; i--) {
			if (MkpkCharSequenceUtils.regionMatches(str, true, i, searchStr, 0,
					searchStr.length())) {
				return i;
			}
		}
		return INDEX_NOT_FOUND;
	}

	// Contains
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks if CharSequence contains a search character, handling {@code null}
	 * . This method uses {@link String#indexOf(int)} if possible.
	 * </p>
	 *
	 * <p>
	 * A {@code null} or empty ("") CharSequence will return {@code false}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.contains(null, *) = false
	 * StringUtils.contains("", *) = false
	 * StringUtils.contains("abc", 'a') = true
	 * StringUtils.contains("abc", 'z') = false
	 * </pre>
	 *
	 * @param seq
	 *            the CharSequence to check, may be null
	 * @param searchChar
	 *            the character to find
	 * @return true if the CharSequence contains the search character, false if
	 *         not or {@code null} string input
	 * @since 2.0
	 * @since 3.0 Changed signature from contains(String, int) to
	 *        contains(CharSequence, int)
	 */
	public static boolean contains(final CharSequence seq, final int searchChar) {
		if (isEmpty(seq)) {
			return false;
		}
		return MkpkCharSequenceUtils.indexOf(seq, searchChar, 0) >= 0;
	}

	/**
	 * <p>
	 * Checks if CharSequence contains a search CharSequence, handling
	 * {@code null}. This method uses {@link String#indexOf(String)} if
	 * possible.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code false}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.contains(null, *) = false
	 * StringUtils.contains(*, null) = false
	 * StringUtils.contains("", "") = true
	 * StringUtils.contains("abc", "") = true
	 * StringUtils.contains("abc", "a") = true
	 * StringUtils.contains("abc", "z") = false
	 * </pre>
	 *
	 * @param seq
	 *            the CharSequence to check, may be null
	 * @param searchSeq
	 *            the CharSequence to find, may be null
	 * @return true if the CharSequence contains the search CharSequence, false
	 *         if not or {@code null} string input
	 * @since 2.0
	 * @since 3.0 Changed signature from contains(String, String) to
	 *        contains(CharSequence, CharSequence)
	 */
	public static boolean contains(final CharSequence seq,
			final CharSequence searchSeq) {
		if (seq == null || searchSeq == null) {
			return false;
		}
		return MkpkCharSequenceUtils.indexOf(seq, searchSeq, 0) >= 0;
	}

	/**
	 * <p>
	 * Checks if CharSequence contains a search CharSequence irrespective of
	 * case, handling {@code null}. Case-insensitivity is defined as by
	 * {@link String#equalsIgnoreCase(String)}.
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code false}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.contains(null, *) = false
	 * StringUtils.contains(*, null) = false
	 * StringUtils.contains("", "") = true
	 * StringUtils.contains("abc", "") = true
	 * StringUtils.contains("abc", "a") = true
	 * StringUtils.contains("abc", "z") = false
	 * StringUtils.contains("abc", "A") = true
	 * StringUtils.contains("abc", "Z") = false
	 * </pre>
	 *
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param searchStr
	 *            the CharSequence to find, may be null
	 * @return true if the CharSequence contains the search CharSequence
	 *         irrespective of case or false if not or {@code null} string input
	 * @since 3.0 Changed signature from containsIgnoreCase(String, String) to
	 *        containsIgnoreCase(CharSequence, CharSequence)
	 */
	public static boolean containsIgnoreCase(final CharSequence str,
			final CharSequence searchStr) {
		if (str == null || searchStr == null) {
			return false;
		}
		final int len = searchStr.length();
		final int max = str.length() - len;
		for (int i = 0; i <= max; i++) {
			if (MkpkCharSequenceUtils.regionMatches(str, true, i, searchStr, 0,
					len)) {
				return true;
			}
		}
		return false;
	}

	// IndexOfAny chars
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Search a CharSequence to find the first index of any character in the
	 * given set of characters.
	 * </p>
	 *
	 * <p>
	 * A {@code null} String will return {@code -1}. A {@code null} or zero
	 * length search array will return {@code -1}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.indexOfAny(null, *) = -1
	 * StringUtils.indexOfAny("", *) = -1
	 * StringUtils.indexOfAny(*, null) = -1
	 * StringUtils.indexOfAny(*, []) = -1
	 * StringUtils.indexOfAny("zzabyycdxx",['z','a']) = 0
	 * StringUtils.indexOfAny("zzabyycdxx",['b','y']) = 3
	 * StringUtils.indexOfAny("aba", ['z']) = -1
	 * </pre>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @param searchChars
	 *            the chars to search for, may be null
	 * @return the index of any of the chars, -1 if no match or null input
	 * @since 2.0
	 * @since 3.0 Changed signature from indexOfAny(String, char[]) to
	 *        indexOfAny(CharSequence, char...)
	 */
	public static int indexOfAny(final CharSequence cs,
			final char... searchChars) {
		if (isEmpty(cs) || MkpkArrayUtils.isEmpty(searchChars)) {
			return INDEX_NOT_FOUND;
		}
		final int csLen = cs.length();
		final int csLast = csLen - 1;
		final int searchLen = searchChars.length;
		final int searchLast = searchLen - 1;
		for (int i = 0; i < csLen; i++) {
			final char ch = cs.charAt(i);
			for (int j = 0; j < searchLen; j++) {
				if (searchChars[j] == ch) {
					if (i < csLast && j < searchLast
							&& Character.isHighSurrogate(ch)) {
						// ch is a supplementary character
						if (searchChars[j + 1] == cs.charAt(i + 1)) {
							return i;
						}
					} else {
						return i;
					}
				}
			}
		}
		return INDEX_NOT_FOUND;
	}

	/**
	 * <p>
	 * Search a CharSequence to find the first index of any character in the
	 * given set of characters.
	 * </p>
	 *
	 * <p>
	 * A {@code null} String will return {@code -1}. A {@code null} search
	 * string will return {@code -1}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.indexOfAny(null, *) = -1
	 * StringUtils.indexOfAny("", *) = -1
	 * StringUtils.indexOfAny(*, null) = -1
	 * StringUtils.indexOfAny(*, "") = -1
	 * StringUtils.indexOfAny("zzabyycdxx", "za") = 0
	 * StringUtils.indexOfAny("zzabyycdxx", "by") = 3
	 * StringUtils.indexOfAny("aba","z") = -1
	 * </pre>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @param searchChars
	 *            the chars to search for, may be null
	 * @return the index of any of the chars, -1 if no match or null input
	 * @since 2.0
	 * @since 3.0 Changed signature from indexOfAny(String, String) to
	 *        indexOfAny(CharSequence, String)
	 */
	public static int indexOfAny(final CharSequence cs, final String searchChars) {
		if (isEmpty(cs) || isEmpty(searchChars)) {
			return INDEX_NOT_FOUND;
		}
		return indexOfAny(cs, searchChars.toCharArray());
	}

	// ContainsAny
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks if the CharSequence contains any character in the given set of
	 * characters.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code false}. A {@code null} or
	 * zero length search array will return {@code false}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.containsAny(null, *) = false
	 * StringUtils.containsAny("", *) = false
	 * StringUtils.containsAny(*, null) = false
	 * StringUtils.containsAny(*, []) = false
	 * StringUtils.containsAny("zzabyycdxx",['z','a']) = true
	 * StringUtils.containsAny("zzabyycdxx",['b','y']) = true
	 * StringUtils.containsAny("aba", ['z']) = false
	 * </pre>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @param searchChars
	 *            the chars to search for, may be null
	 * @return the {@code true} if any of the chars are found, {@code false} if
	 *         no match or null input
	 * @since 2.4
	 * @since 3.0 Changed signature from containsAny(String, char[]) to
	 *        containsAny(CharSequence, char...)
	 */
	public static boolean containsAny(final CharSequence cs,
			final char... searchChars) {
		if (isEmpty(cs) || MkpkArrayUtils.isEmpty(searchChars)) {
			return false;
		}
		final int csLength = cs.length();
		final int searchLength = searchChars.length;
		final int csLast = csLength - 1;
		final int searchLast = searchLength - 1;
		for (int i = 0; i < csLength; i++) {
			final char ch = cs.charAt(i);
			for (int j = 0; j < searchLength; j++) {
				if (searchChars[j] == ch) {
					if (Character.isHighSurrogate(ch)) {
						if (j == searchLast) {
							// missing low surrogate, fine, like
							// String.indexOf(String)
							return true;
						}
						if (i < csLast
								&& searchChars[j + 1] == cs.charAt(i + 1)) {
							return true;
						}
					} else {
						// ch is in the Basic Multilingual Plane
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains any character in the given set of
	 * characters.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code false}. A {@code null}
	 * search CharSequence will return {@code false}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.containsAny(null, *) = false
	 * StringUtils.containsAny("", *) = false
	 * StringUtils.containsAny(*, null) = false
	 * StringUtils.containsAny(*, "") = false
	 * StringUtils.containsAny("zzabyycdxx", "za") = true
	 * StringUtils.containsAny("zzabyycdxx", "by") = true
	 * StringUtils.containsAny("aba","z") = false
	 * </pre>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @param searchChars
	 *            the chars to search for, may be null
	 * @return the {@code true} if any of the chars are found, {@code false} if
	 *         no match or null input
	 * @since 2.4
	 * @since 3.0 Changed signature from containsAny(String, String) to
	 *        containsAny(CharSequence, CharSequence)
	 */
	public static boolean containsAny(final CharSequence cs,
			final CharSequence searchChars) {
		if (searchChars == null) {
			return false;
		}
		return containsAny(cs, MkpkCharSequenceUtils.toCharArray(searchChars));
	}

	// IndexOfAnyBut chars
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Searches a CharSequence to find the first index of any character not in
	 * the given set of characters.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code -1}. A {@code null} or
	 * zero length search array will return {@code -1}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.indexOfAnyBut(null, *) = -1
	 * StringUtils.indexOfAnyBut("", *) = -1
	 * StringUtils.indexOfAnyBut(*, null) = -1
	 * StringUtils.indexOfAnyBut(*, []) = -1
	 * StringUtils.indexOfAnyBut("zzabyycdxx", new char[] {'z', 'a'} ) = 3
	 * StringUtils.indexOfAnyBut("aba", new char[] {'z'} ) = 0
	 * StringUtils.indexOfAnyBut("aba", new char[] {'a', 'b'} ) = -1
	 * </pre>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @param searchChars
	 *            the chars to search for, may be null
	 * @return the index of any of the chars, -1 if no match or null input
	 * @since 2.0
	 * @since 3.0 Changed signature from indexOfAnyBut(String, char[]) to
	 *        indexOfAnyBut(CharSequence, char...)
	 */
	public static int indexOfAnyBut(final CharSequence cs,
			final char... searchChars) {
		if (isEmpty(cs) || MkpkArrayUtils.isEmpty(searchChars)) {
			return INDEX_NOT_FOUND;
		}
		final int csLen = cs.length();
		final int csLast = csLen - 1;
		final int searchLen = searchChars.length;
		final int searchLast = searchLen - 1;
		outer: for (int i = 0; i < csLen; i++) {
			final char ch = cs.charAt(i);
			for (int j = 0; j < searchLen; j++) {
				if (searchChars[j] == ch) {
					if (i < csLast && j < searchLast
							&& Character.isHighSurrogate(ch)) {
						if (searchChars[j + 1] == cs.charAt(i + 1)) {
							continue outer;
						}
					} else {
						continue outer;
					}
				}
			}
			return i;
		}
		return INDEX_NOT_FOUND;
	}

	/**
	 * <p>
	 * Search a CharSequence to find the first index of any character not in the
	 * given set of characters.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code -1}. A {@code null} or
	 * empty search string will return {@code -1}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.indexOfAnyBut(null, *) = -1
	 * StringUtils.indexOfAnyBut("", *) = -1
	 * StringUtils.indexOfAnyBut(*, null) = -1
	 * StringUtils.indexOfAnyBut(*, "") = -1
	 * StringUtils.indexOfAnyBut("zzabyycdxx", "za") = 3
	 * StringUtils.indexOfAnyBut("zzabyycdxx", "") = -1
	 * StringUtils.indexOfAnyBut("aba","ab") = -1
	 * </pre>
	 *
	 * @param seq
	 *            the CharSequence to check, may be null
	 * @param searchChars
	 *            the chars to search for, may be null
	 * @return the index of any of the chars, -1 if no match or null input
	 * @since 2.0
	 * @since 3.0 Changed signature from indexOfAnyBut(String, String) to
	 *        indexOfAnyBut(CharSequence, CharSequence)
	 */
	public static int indexOfAnyBut(final CharSequence seq,
			final CharSequence searchChars) {
		if (isEmpty(seq) || isEmpty(searchChars)) {
			return INDEX_NOT_FOUND;
		}
		final int strLen = seq.length();
		for (int i = 0; i < strLen; i++) {
			final char ch = seq.charAt(i);
			final boolean chFound = MkpkCharSequenceUtils.indexOf(searchChars,
					ch, 0) >= 0;
			if (i + 1 < strLen && Character.isHighSurrogate(ch)) {
				final char ch2 = seq.charAt(i + 1);
				if (chFound
						&& MkpkCharSequenceUtils.indexOf(searchChars, ch2, 0) < 0) {
					return i;
				}
			} else {
				if (!chFound) {
					return i;
				}
			}
		}
		return INDEX_NOT_FOUND;
	}

	// ContainsOnly
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks if the CharSequence contains only certain characters.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code false}. A {@code null}
	 * valid character array will return {@code false}. An empty CharSequence
	 * (length()=0) always returns {@code true}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.containsOnly(null, *) = false
	 * StringUtils.containsOnly(*, null) = false
	 * StringUtils.containsOnly("", *) = true
	 * StringUtils.containsOnly("ab", '') = false
	 * StringUtils.containsOnly("abab", 'abc') = true
	 * StringUtils.containsOnly("ab1", 'abc') = false
	 * StringUtils.containsOnly("abz", 'abc') = false
	 * </pre>
	 *
	 * @param cs
	 *            the String to check, may be null
	 * @param valid
	 *            an array of valid chars, may be null
	 * @return true if it only contains valid chars and is non-null
	 * @since 3.0 Changed signature from containsOnly(String, char[]) to
	 *        containsOnly(CharSequence, char...)
	 */
	public static boolean containsOnly(final CharSequence cs,
			final char... valid) {
		// All these pre-checks are to maintain API with an older version
		if (valid == null || cs == null) {
			return false;
		}
		if (cs.length() == 0) {
			return true;
		}
		if (valid.length == 0) {
			return false;
		}
		return indexOfAnyBut(cs, valid) == INDEX_NOT_FOUND;
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only certain characters.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code false}. A {@code null}
	 * valid character String will return {@code false}. An empty String
	 * (length()=0) always returns {@code true}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.containsOnly(null, *) = false
	 * StringUtils.containsOnly(*, null) = false
	 * StringUtils.containsOnly("", *) = true
	 * StringUtils.containsOnly("ab", "") = false
	 * StringUtils.containsOnly("abab", "abc") = true
	 * StringUtils.containsOnly("ab1", "abc") = false
	 * StringUtils.containsOnly("abz", "abc") = false
	 * </pre>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @param validChars
	 *            a String of valid chars, may be null
	 * @return true if it only contains valid chars and is non-null
	 * @since 2.0
	 * @since 3.0 Changed signature from containsOnly(String, String) to
	 *        containsOnly(CharSequence, String)
	 */
	public static boolean containsOnly(final CharSequence cs,
			final String validChars) {
		if (cs == null || validChars == null) {
			return false;
		}
		return containsOnly(cs, validChars.toCharArray());
	}

	// ContainsNone
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks that the CharSequence does not contain certain characters.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code true}. A {@code null}
	 * invalid character array will return {@code true}. An empty CharSequence
	 * (length()=0) always returns true.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.containsNone(null, *) = true
	 * StringUtils.containsNone(*, null) = true
	 * StringUtils.containsNone("", *) = true
	 * StringUtils.containsNone("ab", '') = true
	 * StringUtils.containsNone("abab", 'xyz') = true
	 * StringUtils.containsNone("ab1", 'xyz') = true
	 * StringUtils.containsNone("abz", 'xyz') = false
	 * </pre>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @param searchChars
	 *            an array of invalid chars, may be null
	 * @return true if it contains none of the invalid chars, or is null
	 * @since 2.0
	 * @since 3.0 Changed signature from containsNone(String, char[]) to
	 *        containsNone(CharSequence, char...)
	 */
	public static boolean containsNone(final CharSequence cs,
			final char... searchChars) {
		if (cs == null || searchChars == null) {
			return true;
		}
		final int csLen = cs.length();
		final int csLast = csLen - 1;
		final int searchLen = searchChars.length;
		final int searchLast = searchLen - 1;
		for (int i = 0; i < csLen; i++) {
			final char ch = cs.charAt(i);
			for (int j = 0; j < searchLen; j++) {
				if (searchChars[j] == ch) {
					if (Character.isHighSurrogate(ch)) {
						if (j == searchLast) {
							// missing low surrogate, fine, like
							// String.indexOf(String)
							return false;
						}
						if (i < csLast
								&& searchChars[j + 1] == cs.charAt(i + 1)) {
							return false;
						}
					} else {
						// ch is in the Basic Multilingual Plane
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks that the CharSequence does not contain certain characters.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code true}. A {@code null}
	 * invalid character array will return {@code true}. An empty String ("")
	 * always returns true.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.containsNone(null, *) = true
	 * StringUtils.containsNone(*, null) = true
	 * StringUtils.containsNone("", *) = true
	 * StringUtils.containsNone("ab", "") = true
	 * StringUtils.containsNone("abab", "xyz") = true
	 * StringUtils.containsNone("ab1", "xyz") = true
	 * StringUtils.containsNone("abz", "xyz") = false
	 * </pre>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @param invalidChars
	 *            a String of invalid chars, may be null
	 * @return true if it contains none of the invalid chars, or is null
	 * @since 2.0
	 * @since 3.0 Changed signature from containsNone(String, String) to
	 *        containsNone(CharSequence, String)
	 */
	public static boolean containsNone(final CharSequence cs,
			final String invalidChars) {
		if (cs == null || invalidChars == null) {
			return true;
		}
		return containsNone(cs, invalidChars.toCharArray());
	}

	// IndexOfAny strings
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Find the first index of any of a set of potential substrings.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code -1}. A {@code null} or
	 * zero length search array will return {@code -1}. A {@code null} search
	 * array entry will be ignored, but a search array containing "" will return
	 * {@code 0} if {@code str} is not null. This method uses
	 * {@link String#indexOf(String)} if possible.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.indexOfAny(null, *) = -1
	 * StringUtils.indexOfAny(*, null) = -1
	 * StringUtils.indexOfAny(*, []) = -1
	 * StringUtils.indexOfAny("zzabyycdxx", ["ab","cd"]) = 2
	 * StringUtils.indexOfAny("zzabyycdxx", ["cd","ab"]) = 2
	 * StringUtils.indexOfAny("zzabyycdxx", ["mn","op"]) = -1
	 * StringUtils.indexOfAny("zzabyycdxx", ["zab","aby"]) = 1
	 * StringUtils.indexOfAny("zzabyycdxx", [""]) = 0
	 * StringUtils.indexOfAny("", [""]) = 0
	 * StringUtils.indexOfAny("", ["a"]) = -1
	 * </pre>
	 *
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param searchStrs
	 *            the CharSequences to search for, may be null
	 * @return the first index of any of the searchStrs in str, -1 if no match
	 * @since 3.0 Changed signature from indexOfAny(String, String[]) to
	 *        indexOfAny(CharSequence, CharSequence...)
	 */
	public static int indexOfAny(final CharSequence str,
			final CharSequence... searchStrs) {
		if (str == null || searchStrs == null) {
			return INDEX_NOT_FOUND;
		}
		final int sz = searchStrs.length;
		// String's can't have a MAX_VALUEth index.
		int ret = Integer.MAX_VALUE;
		int tmp = 0;
		for (int i = 0; i < sz; i++) {
			final CharSequence search = searchStrs[i];
			if (search == null) {
				continue;
			}
			tmp = MkpkCharSequenceUtils.indexOf(str, search, 0);
			if (tmp == INDEX_NOT_FOUND) {
				continue;
			}
			if (tmp < ret) {
				ret = tmp;
			}
		}
		return ret == Integer.MAX_VALUE ? INDEX_NOT_FOUND : ret;
	}

	/**
	 * <p>
	 * Find the latest index of any of a set of potential substrings.
	 * </p>
	 *
	 * <p>
	 * A {@code null} CharSequence will return {@code -1}. A {@code null} search
	 * array will return {@code -1}. A {@code null} or zero length search array
	 * entry will be ignored, but a search array containing "" will return the
	 * length of {@code str} if {@code str} is not null. This method uses
	 * {@link String#indexOf(String)} if possible
	 * </p>
	 *
	 * <pre>
	 * StringUtils.lastIndexOfAny(null, *) = -1
	 * StringUtils.lastIndexOfAny(*, null) = -1
	 * StringUtils.lastIndexOfAny(*, []) = -1
	 * StringUtils.lastIndexOfAny(*, [null]) = -1
	 * StringUtils.lastIndexOfAny("zzabyycdxx", ["ab","cd"]) = 6
	 * StringUtils.lastIndexOfAny("zzabyycdxx", ["cd","ab"]) = 6
	 * StringUtils.lastIndexOfAny("zzabyycdxx", ["mn","op"]) = -1
	 * StringUtils.lastIndexOfAny("zzabyycdxx", ["mn","op"]) = -1
	 * StringUtils.lastIndexOfAny("zzabyycdxx", ["mn",""]) = 10
	 * </pre>
	 *
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param searchStrs
	 *            the CharSequences to search for, may be null
	 * @return the last index of any of the CharSequences, -1 if no match
	 * @since 3.0 Changed signature from lastIndexOfAny(String, String[]) to
	 *        lastIndexOfAny(CharSequence, CharSequence)
	 */
	public static int lastIndexOfAny(final CharSequence str,
			final CharSequence... searchStrs) {
		if (str == null || searchStrs == null) {
			return INDEX_NOT_FOUND;
		}
		final int sz = searchStrs.length;
		int ret = INDEX_NOT_FOUND;
		int tmp = 0;
		for (int i = 0; i < sz; i++) {
			final CharSequence search = searchStrs[i];
			if (search == null) {
				continue;
			}
			tmp = MkpkCharSequenceUtils.lastIndexOf(str, search, str.length());
			if (tmp > ret) {
				ret = tmp;
			}
		}
		return ret;
	}

	// Substring
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Gets a substring from the specified String avoiding exceptions.
	 * </p>
	 *
	 * <p>
	 * A negative start position can be used to start {@code n} characters from
	 * the end of the String.
	 * </p>
	 *
	 * <p>
	 * A {@code null} String will return {@code null}. An empty ("") String will
	 * return "".
	 * </p>
	 *
	 * <pre>
	 * StringUtils.substring(null, *) = null
	 * StringUtils.substring("", *) = ""
	 * StringUtils.substring("abc", 0) = "abc"
	 * StringUtils.substring("abc", 2) = "c"
	 * StringUtils.substring("abc", 4) = ""
	 * StringUtils.substring("abc", -2) = "bc"
	 * StringUtils.substring("abc", -4) = "abc"
	 * </pre>
	 *
	 * @param str
	 *            the String to get the substring from, may be null
	 * @param start
	 *            the position to start from, negative means count back from the
	 *            end of the String by this many characters
	 * @return substring from start position, {@code null} if null String input
	 */
	public static String substring(final String str, int start) {
		if (str == null) {
			return null;
		}
		// handle negatives, which means last n characters
		if (start < 0) {
			start = str.length() + start; // remember start is negative
		}
		if (start < 0) {
			start = 0;
		}
		if (start > str.length()) {
			return EMPTY;
		}
		return str.substring(start);
	}

	/**
	 * <p>
	 * Gets a substring from the specified String avoiding exceptions.
	 * </p>
	 *
	 * <p>
	 * A negative start position can be used to start/end {@code n} characters
	 * from the end of the String.
	 * </p>
	 *
	 * <p>
	 * The returned substring starts with the character in the {@code start}
	 * position and ends before the {@code end} position. All position counting
	 * is zero-based -- i.e., to start at the beginning of the string use
	 * {@code start = 0}. Negative start and end positions can be used to
	 * specify offsets relative to the end of the String.
	 * </p>
	 *
	 * <p>
	 * If {@code start} is not strictly to the left of {@code end}, "" is
	 * returned.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.substring(null, *, *) = null
	 * StringUtils.substring("", * , *) = "";
	 * StringUtils.substring("abc", 0, 2) = "ab"
	 * StringUtils.substring("abc", 2, 0) = ""
	 * StringUtils.substring("abc", 2, 4) = "c"
	 * StringUtils.substring("abc", 4, 6) = ""
	 * StringUtils.substring("abc", 2, 2) = ""
	 * StringUtils.substring("abc", -2, -1) = "b"
	 * StringUtils.substring("abc", -4, 2) = "ab"
	 * </pre>
	 *
	 * @param str
	 *            the String to get the substring from, may be null
	 * @param start
	 *            the position to start from, negative means count back from the
	 *            end of the String by this many characters
	 * @param end
	 *            the position to end at (exclusive), negative means count back
	 *            from the end of the String by this many characters
	 * @return substring from start position to end position, {@code null} if
	 *         null String input
	 */
	public static String substring(final String str, int start, int end) {
		if (str == null) {
			return null;
		}
		// handle negatives
		if (end < 0) {
			end = str.length() + end; // remember end is negative
		}
		if (start < 0) {
			start = str.length() + start; // remember start is negative
		}
		// check length next
		if (end > str.length()) {
			end = str.length();
		}
		// if start is greater than end, return ""
		if (start > end) {
			return EMPTY;
		}
		if (start < 0) {
			start = 0;
		}
		if (end < 0) {
			end = 0;
		}
		return str.substring(start, end);
	}

	// Left/Right/Mid
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Gets the leftmost {@code len} characters of a String.
	 * </p>
	 *
	 * <p>
	 * If {@code len} characters are not available, or the String is
	 * {@code null}, the String will be returned without an exception. An empty
	 * String is returned if len is negative.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.left(null, *) = null
	 * StringUtils.left(*, -ve) = ""
	 * StringUtils.left("", *) = ""
	 * StringUtils.left("abc", 0) = ""
	 * StringUtils.left("abc", 2) = "ab"
	 * StringUtils.left("abc", 4) = "abc"
	 * </pre>
	 *
	 * @param str
	 *            the String to get the leftmost characters from, may be null
	 * @param len
	 *            the length of the required String
	 * @return the leftmost characters, {@code null} if null String input
	 */
	public static String left(final String str, final int len) {
		if (str == null) {
			return null;
		}
		if (len < 0) {
			return EMPTY;
		}
		if (str.length() <= len) {
			return str;
		}
		return str.substring(0, len);
	}

	/**
	 * <p>
	 * Gets the rightmost {@code len} characters of a String.
	 * </p>
	 *
	 * <p>
	 * If {@code len} characters are not available, or the String is
	 * {@code null}, the String will be returned without an an exception. An
	 * empty String is returned if len is negative.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.right(null, *) = null
	 * StringUtils.right(*, -ve) = ""
	 * StringUtils.right("", *) = ""
	 * StringUtils.right("abc", 0) = ""
	 * StringUtils.right("abc", 2) = "bc"
	 * StringUtils.right("abc", 4) = "abc"
	 * </pre>
	 *
	 * @param str
	 *            the String to get the rightmost characters from, may be null
	 * @param len
	 *            the length of the required String
	 * @return the rightmost characters, {@code null} if null String input
	 */
	public static String right(final String str, final int len) {
		if (str == null) {
			return null;
		}
		if (len < 0) {
			return EMPTY;
		}
		if (str.length() <= len) {
			return str;
		}
		return str.substring(str.length() - len);
	}

	/**
	 * <p>
	 * Gets {@code len} characters from the middle of a String.
	 * </p>
	 *
	 * <p>
	 * If {@code len} characters are not available, the remainder of the String
	 * will be returned without an exception. If the String is {@code null},
	 * {@code null} will be returned. An empty String is returned if len is
	 * negative or exceeds the length of {@code str}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.mid(null, *, *) = null
	 * StringUtils.mid(*, *, -ve) = ""
	 * StringUtils.mid("", 0, *) = ""
	 * StringUtils.mid("abc", 0, 2) = "ab"
	 * StringUtils.mid("abc", 0, 4) = "abc"
	 * StringUtils.mid("abc", 2, 4) = "c"
	 * StringUtils.mid("abc", 4, 2) = ""
	 * StringUtils.mid("abc", -2, 2) = "ab"
	 * </pre>
	 *
	 * @param str
	 *            the String to get the characters from, may be null
	 * @param pos
	 *            the position to start from, negative treated as zero
	 * @param len
	 *            the length of the required String
	 * @return the middle characters, {@code null} if null String input
	 */
	public static String mid(final String str, int pos, final int len) {
		if (str == null) {
			return null;
		}
		if (len < 0 || pos > str.length()) {
			return EMPTY;
		}
		if (pos < 0) {
			pos = 0;
		}
		if (str.length() <= pos + len) {
			return str.substring(pos);
		}
		return str.substring(pos, pos + len);
	}

	// SubStringAfter/SubStringBefore
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Gets the substring before the first occurrence of a separator. The
	 * separator is not returned.
	 * </p>
	 *
	 * <p>
	 * A {@code null} string input will return {@code null}. An empty ("")
	 * string input will return the empty string. A {@code null} separator will
	 * return the input string.
	 * </p>
	 *
	 * <p>
	 * If nothing is found, the string input is returned.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.substringBefore(null, *) = null
	 * StringUtils.substringBefore("", *) = ""
	 * StringUtils.substringBefore("abc", "a") = ""
	 * StringUtils.substringBefore("abcba", "b") = "a"
	 * StringUtils.substringBefore("abc", "c") = "ab"
	 * StringUtils.substringBefore("abc", "d") = "abc"
	 * StringUtils.substringBefore("abc", "") = ""
	 * StringUtils.substringBefore("abc", null) = "abc"
	 * </pre>
	 *
	 * @param str
	 *            the String to get a substring from, may be null
	 * @param separator
	 *            the String to search for, may be null
	 * @return the substring before the first occurrence of the separator,
	 *         {@code null} if null String input
	 * @since 2.0
	 */
	public static String substringBefore(final String str,
			final String separator) {
		if (isEmpty(str) || separator == null) {
			return str;
		}
		if (separator.isEmpty()) {
			return EMPTY;
		}
		final int pos = str.indexOf(separator);
		if (pos == INDEX_NOT_FOUND) {
			return str;
		}
		return str.substring(0, pos);
	}

	/**
	 * <p>
	 * Gets the substring after the first occurrence of a separator. The
	 * separator is not returned.
	 * </p>
	 *
	 * <p>
	 * A {@code null} string input will return {@code null}. An empty ("")
	 * string input will return the empty string. A {@code null} separator will
	 * return the empty string if the input string is not {@code null}.
	 * </p>
	 *
	 * <p>
	 * If nothing is found, the empty string is returned.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.substringAfter(null, *) = null
	 * StringUtils.substringAfter("", *) = ""
	 * StringUtils.substringAfter(*, null) = ""
	 * StringUtils.substringAfter("abc", "a") = "bc"
	 * StringUtils.substringAfter("abcba", "b") = "cba"
	 * StringUtils.substringAfter("abc", "c") = ""
	 * StringUtils.substringAfter("abc", "d") = ""
	 * StringUtils.substringAfter("abc", "") = "abc"
	 * </pre>
	 *
	 * @param str
	 *            the String to get a substring from, may be null
	 * @param separator
	 *            the String to search for, may be null
	 * @return the substring after the first occurrence of the separator,
	 *         {@code null} if null String input
	 * @since 2.0
	 */
	public static String substringAfter(final String str, final String separator) {
		if (isEmpty(str)) {
			return str;
		}
		if (separator == null) {
			return EMPTY;
		}
		final int pos = str.indexOf(separator);
		if (pos == INDEX_NOT_FOUND) {
			return EMPTY;
		}
		return str.substring(pos + separator.length());
	}

	/**
	 * <p>
	 * Gets the substring before the last occurrence of a separator. The
	 * separator is not returned.
	 * </p>
	 *
	 * <p>
	 * A {@code null} string input will return {@code null}. An empty ("")
	 * string input will return the empty string. An empty or {@code null}
	 * separator will return the input string.
	 * </p>
	 *
	 * <p>
	 * If nothing is found, the string input is returned.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.substringBeforeLast(null, *) = null
	 * StringUtils.substringBeforeLast("", *) = ""
	 * StringUtils.substringBeforeLast("abcba", "b") = "abc"
	 * StringUtils.substringBeforeLast("abc", "c") = "ab"
	 * StringUtils.substringBeforeLast("a", "a") = ""
	 * StringUtils.substringBeforeLast("a", "z") = "a"
	 * StringUtils.substringBeforeLast("a", null) = "a"
	 * StringUtils.substringBeforeLast("a", "") = "a"
	 * </pre>
	 *
	 * @param str
	 *            the String to get a substring from, may be null
	 * @param separator
	 *            the String to search for, may be null
	 * @return the substring before the last occurrence of the separator,
	 *         {@code null} if null String input
	 * @since 2.0
	 */
	public static String substringBeforeLast(final String str,
			final String separator) {
		if (isEmpty(str) || isEmpty(separator)) {
			return str;
		}
		final int pos = str.lastIndexOf(separator);
		if (pos == INDEX_NOT_FOUND) {
			return str;
		}
		return str.substring(0, pos);
	}

	/**
	 * <p>
	 * Gets the substring after the last occurrence of a separator. The
	 * separator is not returned.
	 * </p>
	 *
	 * <p>
	 * A {@code null} string input will return {@code null}. An empty ("")
	 * string input will return the empty string. An empty or {@code null}
	 * separator will return the empty string if the input string is not
	 * {@code null}.
	 * </p>
	 *
	 * <p>
	 * If nothing is found, the empty string is returned.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.substringAfterLast(null, *) = null
	 * StringUtils.substringAfterLast("", *) = ""
	 * StringUtils.substringAfterLast(*, "") = ""
	 * StringUtils.substringAfterLast(*, null) = ""
	 * StringUtils.substringAfterLast("abc", "a") = "bc"
	 * StringUtils.substringAfterLast("abcba", "b") = "a"
	 * StringUtils.substringAfterLast("abc", "c") = ""
	 * StringUtils.substringAfterLast("a", "a") = ""
	 * StringUtils.substringAfterLast("a", "z") = ""
	 * </pre>
	 *
	 * @param str
	 *            the String to get a substring from, may be null
	 * @param separator
	 *            the String to search for, may be null
	 * @return the substring after the last occurrence of the separator,
	 *         {@code null} if null String input
	 * @since 2.0
	 */
	public static String substringAfterLast(final String str,
			final String separator) {
		if (isEmpty(str)) {
			return str;
		}
		if (isEmpty(separator)) {
			return EMPTY;
		}
		final int pos = str.lastIndexOf(separator);
		if (pos == INDEX_NOT_FOUND || pos == str.length() - separator.length()) {
			return EMPTY;
		}
		return str.substring(pos + separator.length());
	}

	// Substring between
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Gets the String that is nested in between two instances of the same
	 * String.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}. A {@code null} tag
	 * returns {@code null}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.substringBetween(null, *) = null
	 * StringUtils.substringBetween("", "") = ""
	 * StringUtils.substringBetween("", "tag") = null
	 * StringUtils.substringBetween("tagabctag", null) = null
	 * StringUtils.substringBetween("tagabctag", "") = ""
	 * StringUtils.substringBetween("tagabctag", "tag") = "abc"
	 * </pre>
	 *
	 * @param str
	 *            the String containing the substring, may be null
	 * @param tag
	 *            the String before and after the substring, may be null
	 * @return the substring, {@code null} if no match
	 * @since 2.0
	 */
	public static String substringBetween(final String str, final String tag) {
		return substringBetween(str, tag, tag);
	}

	/**
	 * <p>
	 * Gets the String that is nested in between two Strings. Only the first
	 * match is returned.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}. A {@code null}
	 * open/close returns {@code null} (no match). An empty ("") open and close
	 * returns an empty string.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.substringBetween("wx[b]yz", "[", "]") = "b"
	 * StringUtils.substringBetween(null, *, *) = null
	 * StringUtils.substringBetween(*, null, *) = null
	 * StringUtils.substringBetween(*, *, null) = null
	 * StringUtils.substringBetween("", "", "") = ""
	 * StringUtils.substringBetween("", "", "]") = null
	 * StringUtils.substringBetween("", "[", "]") = null
	 * StringUtils.substringBetween("yabcz", "", "") = ""
	 * StringUtils.substringBetween("yabcz", "y", "z") = "abc"
	 * StringUtils.substringBetween("yabczyabcz", "y", "z") = "abc"
	 * </pre>
	 *
	 * @param str
	 *            the String containing the substring, may be null
	 * @param open
	 *            the String before the substring, may be null
	 * @param close
	 *            the String after the substring, may be null
	 * @return the substring, {@code null} if no match
	 * @since 2.0
	 */
	public static String substringBetween(final String str, final String open,
			final String close) {
		if (str == null || open == null || close == null) {
			return null;
		}
		final int start = str.indexOf(open);
		if (start != INDEX_NOT_FOUND) {
			final int end = str.indexOf(close, start + open.length());
			if (end != INDEX_NOT_FOUND) {
				return str.substring(start + open.length(), end);
			}
		}
		return null;
	}

	/**
	 * <p>
	 * Searches a String for substrings delimited by a start and end tag,
	 * returning all matching substrings in an array.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}. A {@code null}
	 * open/close returns {@code null} (no match). An empty ("") open/close
	 * returns {@code null} (no match).
	 * </p>
	 *
	 * <pre>
	 * StringUtils.substringsBetween("[a][b][c]", "[", "]") = ["a","b","c"]
	 * StringUtils.substringsBetween(null, *, *) = null
	 * StringUtils.substringsBetween(*, null, *) = null
	 * StringUtils.substringsBetween(*, *, null) = null
	 * StringUtils.substringsBetween("", "[", "]") = []
	 * </pre>
	 *
	 * @param str
	 *            the String containing the substrings, null returns null, empty
	 *            returns empty
	 * @param open
	 *            the String identifying the start of the substring, empty
	 *            returns null
	 * @param close
	 *            the String identifying the end of the substring, empty returns
	 *            null
	 * @return a String Array of substrings, or {@code null} if no match
	 * @since 2.3
	 */
	public static String[] substringsBetween(final String str,
			final String open, final String close) {
		if (str == null || isEmpty(open) || isEmpty(close)) {
			return null;
		}
		final int strLen = str.length();
		if (strLen == 0) {
			return MkpkArrayUtils.EMPTY_STRING_ARRAY;
		}
		final int closeLen = close.length();
		final int openLen = open.length();
		final List<String> list = new ArrayList<String>();
		int pos = 0;
		while (pos < strLen - closeLen) {
			int start = str.indexOf(open, pos);
			if (start < 0) {
				break;
			}
			start += openLen;
			final int end = str.indexOf(close, start);
			if (end < 0) {
				break;
			}
			list.add(str.substring(start, end));
			pos = end + closeLen;
		}
		if (list.isEmpty()) {
			return null;
		}
		return list.toArray(new String[list.size()]);
	}

	/**
	 * <p>
	 * Splits the provided text into an array, separator specified. This is an
	 * alternative to using StringTokenizer.
	 * </p>
	 *
	 * <p>
	 * The separator is not included in the returned String array. Adjacent
	 * separators are treated as one separator. For more control over the split
	 * use the StrTokenizer class.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.split(null, *) = null
	 * StringUtils.split("", *) = []
	 * StringUtils.split("a.b.c", '.') = ["a", "b", "c"]
	 * StringUtils.split("a..b.c", '.') = ["a", "b", "c"]
	 * StringUtils.split("a:b:c", '.') = ["a:b:c"]
	 * StringUtils.split("a b c", ' ') = ["a", "b", "c"]
	 * </pre>
	 *
	 * @param str
	 *            the String to parse, may be null
	 * @param separatorChar
	 *            the character used as the delimiter
	 * @return an array of parsed Strings, {@code null} if null String input
	 * @since 2.0
	 */
	public static String[] split(final String str, final char separatorChar) {
		return splitWorker(str, separatorChar, false);
	}

	/**
	 * <p>
	 * Splits the provided text into an array, separator specified, preserving
	 * all tokens, including empty tokens created by adjacent separators. This
	 * is an alternative to using StringTokenizer.
	 * </p>
	 *
	 * <p>
	 * The separator is not included in the returned String array. Adjacent
	 * separators are treated as separators for empty tokens. For more control
	 * over the split use the StrTokenizer class.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.splitPreserveAllTokens(null, *) = null
	 * StringUtils.splitPreserveAllTokens("", *) = []
	 * StringUtils.splitPreserveAllTokens("a.b.c", '.') = ["a", "b", "c"]
	 * StringUtils.splitPreserveAllTokens("a..b.c", '.') = ["a", "", "b", "c"]
	 * StringUtils.splitPreserveAllTokens("a:b:c", '.') = ["a:b:c"]
	 * StringUtils.splitPreserveAllTokens("a\tb\nc", null) = ["a", "b", "c"]
	 * StringUtils.splitPreserveAllTokens("a b c", ' ') = ["a", "b", "c"]
	 * StringUtils.splitPreserveAllTokens("a b c ", ' ') = ["a", "b", "c", ""]
	 * StringUtils.splitPreserveAllTokens("a b c ", ' ') = ["a", "b", "c", "", ""]
	 * StringUtils.splitPreserveAllTokens(" a b c", ' ') = ["", a", "b", "c"]
	 * StringUtils.splitPreserveAllTokens(" a b c", ' ') = ["", "", a", "b", "c"]
	 * StringUtils.splitPreserveAllTokens(" a b c ", ' ') = ["", a", "b", "c", ""]
	 * </pre>
	 *
	 * @param str
	 *            the String to parse, may be {@code null}
	 * @param separatorChar
	 *            the character used as the delimiter, {@code null} splits on
	 *            whitespace
	 * @return an array of parsed Strings, {@code null} if null String input
	 * @since 2.1
	 */
	public static String[] splitPreserveAllTokens(final String str,
			final char separatorChar) {
		return splitWorker(str, separatorChar, true);
	}

	/**
	 * Performs the logic for the {@code split} and
	 * {@code splitPreserveAllTokens} methods that do not return a maximum array
	 * length.
	 *
	 * @param str
	 *            the String to parse, may be {@code null}
	 * @param separatorChar
	 *            the separate character
	 * @param preserveAllTokens
	 *            if {@code true}, adjacent separators are treated as empty
	 *            token separators; if {@code false}, adjacent separators are
	 *            treated as one separator.
	 * @return an array of parsed Strings, {@code null} if null String input
	 */
	private static String[] splitWorker(final String str,
			final char separatorChar, final boolean preserveAllTokens) {
		// Performance tuned for 2.0 (JDK1.4)
		if (str == null) {
			return null;
		}
		final int len = str.length();
		if (len == 0) {
			return MkpkArrayUtils.EMPTY_STRING_ARRAY;
		}
		final List<String> list = new ArrayList<String>();
		int i = 0, start = 0;
		boolean match = false;
		boolean lastMatch = false;
		while (i < len) {
			if (str.charAt(i) == separatorChar) {
				if (match || preserveAllTokens) {
					list.add(str.substring(start, i));
					match = false;
					lastMatch = true;
				}
				start = ++i;
				continue;
			}
			lastMatch = false;
			match = true;
			i++;
		}
		if (match || preserveAllTokens && lastMatch) {
			list.add(str.substring(start, i));
		}
		return list.toArray(new String[list.size()]);
	}

	// Joining
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing
	 * the provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No separator is added to the joined String. Null objects or empty strings
	 * within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null) = null
	 * StringUtils.join([]) = ""
	 * StringUtils.join([null]) = ""
	 * StringUtils.join(["a", "b", "c"]) = "abc"
	 * StringUtils.join([null, "", "a"]) = "a"
	 * </pre>
	 *
	 * @param <T>
	 *            the specific type of values to join together
	 * @param elements
	 *            the values to join together, may be null
	 * @return the joined String, {@code null} if null array input
	 * @since 2.0
	 * @since 3.0 Changed signature to use varargs
	 */
	@SafeVarargs
	public static <T> String join(final T... elements) {
		return join(elements, null);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing
	 * the provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty
	 * strings within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *) = null
	 * StringUtils.join([], *) = ""
	 * StringUtils.join([null], *) = ""
	 * StringUtils.join(["a", "b", "c"], ';') = "a;b;c"
	 * StringUtils.join(["a", "b", "c"], null) = "abc"
	 * StringUtils.join([null, "", "a"], ';') = ";;a"
	 * </pre>
	 *
	 * @param array
	 *            the array of values to join together, may be null
	 * @param separator
	 *            the separator character to use
	 * @return the joined String, {@code null} if null array input
	 * @since 2.0
	 */
	public static String join(final Object[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing
	 * the provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty
	 * strings within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *) = null
	 * StringUtils.join([], *) = ""
	 * StringUtils.join([null], *) = ""
	 * StringUtils.join([1, 2, 3], ';') = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array
	 *            the array of values to join together, may be null
	 * @param separator
	 *            the separator character to use
	 * @return the joined String, {@code null} if null array input
	 * @since 3.2
	 */
	public static String join(final long[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing
	 * the provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty
	 * strings within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *) = null
	 * StringUtils.join([], *) = ""
	 * StringUtils.join([null], *) = ""
	 * StringUtils.join([1, 2, 3], ';') = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array
	 *            the array of values to join together, may be null
	 * @param separator
	 *            the separator character to use
	 * @return the joined String, {@code null} if null array input
	 * @since 3.2
	 */
	public static String join(final int[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing
	 * the provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty
	 * strings within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *) = null
	 * StringUtils.join([], *) = ""
	 * StringUtils.join([null], *) = ""
	 * StringUtils.join([1, 2, 3], ';') = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array
	 *            the array of values to join together, may be null
	 * @param separator
	 *            the separator character to use
	 * @return the joined String, {@code null} if null array input
	 * @since 3.2
	 */
	public static String join(final short[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing
	 * the provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty
	 * strings within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *) = null
	 * StringUtils.join([], *) = ""
	 * StringUtils.join([null], *) = ""
	 * StringUtils.join([1, 2, 3], ';') = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array
	 *            the array of values to join together, may be null
	 * @param separator
	 *            the separator character to use
	 * @return the joined String, {@code null} if null array input
	 * @since 3.2
	 */
	public static String join(final byte[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing
	 * the provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty
	 * strings within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *) = null
	 * StringUtils.join([], *) = ""
	 * StringUtils.join([null], *) = ""
	 * StringUtils.join([1, 2, 3], ';') = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array
	 *            the array of values to join together, may be null
	 * @param separator
	 *            the separator character to use
	 * @return the joined String, {@code null} if null array input
	 * @since 3.2
	 */
	public static String join(final char[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing
	 * the provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty
	 * strings within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *) = null
	 * StringUtils.join([], *) = ""
	 * StringUtils.join([null], *) = ""
	 * StringUtils.join([1, 2, 3], ';') = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array
	 *            the array of values to join together, may be null
	 * @param separator
	 *            the separator character to use
	 * @return the joined String, {@code null} if null array input
	 * @since 3.2
	 */
	public static String join(final float[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing
	 * the provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty
	 * strings within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *) = null
	 * StringUtils.join([], *) = ""
	 * StringUtils.join([null], *) = ""
	 * StringUtils.join([1, 2, 3], ';') = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array
	 *            the array of values to join together, may be null
	 * @param separator
	 *            the separator character to use
	 * @return the joined String, {@code null} if null array input
	 * @since 3.2
	 */
	public static String join(final double[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing
	 * the provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty
	 * strings within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *) = null
	 * StringUtils.join([], *) = ""
	 * StringUtils.join([null], *) = ""
	 * StringUtils.join(["a", "b", "c"], ';') = "a;b;c"
	 * StringUtils.join(["a", "b", "c"], null) = "abc"
	 * StringUtils.join([null, "", "a"], ';') = ";;a"
	 * </pre>
	 *
	 * @param array
	 *            the array of values to join together, may be null
	 * @param separator
	 *            the separator character to use
	 * @param startIndex
	 *            the first index to start joining from. It is an error to pass
	 *            in an end index past the end of the array
	 * @param endIndex
	 *            the index to stop joining from (exclusive). It is an error to
	 *            pass in an end index past the end of the array
	 * @return the joined String, {@code null} if null array input
	 * @since 2.0
	 */
	public static String join(final Object[] array, final char separator,
			final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = new StringBuilder(noOfItems * 16);
		for (int i = startIndex; i < endIndex; i++) {
			if (i > startIndex) {
				buf.append(separator);
			}
			if (array[i] != null) {
				buf.append(array[i]);
			}
		}
		return buf.toString();
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing
	 * the provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty
	 * strings within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *) = null
	 * StringUtils.join([], *) = ""
	 * StringUtils.join([null], *) = ""
	 * StringUtils.join([1, 2, 3], ';') = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array
	 *            the array of values to join together, may be null
	 * @param separator
	 *            the separator character to use
	 * @param startIndex
	 *            the first index to start joining from. It is an error to pass
	 *            in an end index past the end of the array
	 * @param endIndex
	 *            the index to stop joining from (exclusive). It is an error to
	 *            pass in an end index past the end of the array
	 * @return the joined String, {@code null} if null array input
	 * @since 3.2
	 */
	public static String join(final long[] array, final char separator,
			final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = new StringBuilder(noOfItems * 16);
		for (int i = startIndex; i < endIndex; i++) {
			if (i > startIndex) {
				buf.append(separator);
			}
			buf.append(array[i]);
		}
		return buf.toString();
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing
	 * the provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty
	 * strings within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *) = null
	 * StringUtils.join([], *) = ""
	 * StringUtils.join([null], *) = ""
	 * StringUtils.join([1, 2, 3], ';') = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array
	 *            the array of values to join together, may be null
	 * @param separator
	 *            the separator character to use
	 * @param startIndex
	 *            the first index to start joining from. It is an error to pass
	 *            in an end index past the end of the array
	 * @param endIndex
	 *            the index to stop joining from (exclusive). It is an error to
	 *            pass in an end index past the end of the array
	 * @return the joined String, {@code null} if null array input
	 * @since 3.2
	 */
	public static String join(final int[] array, final char separator,
			final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = new StringBuilder(noOfItems * 16);
		for (int i = startIndex; i < endIndex; i++) {
			if (i > startIndex) {
				buf.append(separator);
			}
			buf.append(array[i]);
		}
		return buf.toString();
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing
	 * the provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty
	 * strings within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *) = null
	 * StringUtils.join([], *) = ""
	 * StringUtils.join([null], *) = ""
	 * StringUtils.join([1, 2, 3], ';') = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array
	 *            the array of values to join together, may be null
	 * @param separator
	 *            the separator character to use
	 * @param startIndex
	 *            the first index to start joining from. It is an error to pass
	 *            in an end index past the end of the array
	 * @param endIndex
	 *            the index to stop joining from (exclusive). It is an error to
	 *            pass in an end index past the end of the array
	 * @return the joined String, {@code null} if null array input
	 * @since 3.2
	 */
	public static String join(final byte[] array, final char separator,
			final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = new StringBuilder(noOfItems * 16);
		for (int i = startIndex; i < endIndex; i++) {
			if (i > startIndex) {
				buf.append(separator);
			}
			buf.append(array[i]);
		}
		return buf.toString();
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing
	 * the provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty
	 * strings within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *) = null
	 * StringUtils.join([], *) = ""
	 * StringUtils.join([null], *) = ""
	 * StringUtils.join([1, 2, 3], ';') = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array
	 *            the array of values to join together, may be null
	 * @param separator
	 *            the separator character to use
	 * @param startIndex
	 *            the first index to start joining from. It is an error to pass
	 *            in an end index past the end of the array
	 * @param endIndex
	 *            the index to stop joining from (exclusive). It is an error to
	 *            pass in an end index past the end of the array
	 * @return the joined String, {@code null} if null array input
	 * @since 3.2
	 */
	public static String join(final short[] array, final char separator,
			final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = new StringBuilder(noOfItems * 16);
		for (int i = startIndex; i < endIndex; i++) {
			if (i > startIndex) {
				buf.append(separator);
			}
			buf.append(array[i]);
		}
		return buf.toString();
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing
	 * the provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty
	 * strings within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *) = null
	 * StringUtils.join([], *) = ""
	 * StringUtils.join([null], *) = ""
	 * StringUtils.join([1, 2, 3], ';') = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array
	 *            the array of values to join together, may be null
	 * @param separator
	 *            the separator character to use
	 * @param startIndex
	 *            the first index to start joining from. It is an error to pass
	 *            in an end index past the end of the array
	 * @param endIndex
	 *            the index to stop joining from (exclusive). It is an error to
	 *            pass in an end index past the end of the array
	 * @return the joined String, {@code null} if null array input
	 * @since 3.2
	 */
	public static String join(final char[] array, final char separator,
			final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = new StringBuilder(noOfItems * 16);
		for (int i = startIndex; i < endIndex; i++) {
			if (i > startIndex) {
				buf.append(separator);
			}
			buf.append(array[i]);
		}
		return buf.toString();
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing
	 * the provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty
	 * strings within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *) = null
	 * StringUtils.join([], *) = ""
	 * StringUtils.join([null], *) = ""
	 * StringUtils.join([1, 2, 3], ';') = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array
	 *            the array of values to join together, may be null
	 * @param separator
	 *            the separator character to use
	 * @param startIndex
	 *            the first index to start joining from. It is an error to pass
	 *            in an end index past the end of the array
	 * @param endIndex
	 *            the index to stop joining from (exclusive). It is an error to
	 *            pass in an end index past the end of the array
	 * @return the joined String, {@code null} if null array input
	 * @since 3.2
	 */
	public static String join(final double[] array, final char separator,
			final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = new StringBuilder(noOfItems * 16);
		for (int i = startIndex; i < endIndex; i++) {
			if (i > startIndex) {
				buf.append(separator);
			}
			buf.append(array[i]);
		}
		return buf.toString();
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing
	 * the provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty
	 * strings within the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *) = null
	 * StringUtils.join([], *) = ""
	 * StringUtils.join([null], *) = ""
	 * StringUtils.join([1, 2, 3], ';') = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 * @param array
	 *            the array of values to join together, may be null
	 * @param separator
	 *            the separator character to use
	 * @param startIndex
	 *            the first index to start joining from. It is an error to pass
	 *            in an end index past the end of the array
	 * @param endIndex
	 *            the index to stop joining from (exclusive). It is an error to
	 *            pass in an end index past the end of the array
	 * @return the joined String, {@code null} if null array input
	 * @since 3.2
	 */
	public static String join(final float[] array, final char separator,
			final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = new StringBuilder(noOfItems * 16);
		for (int i = startIndex; i < endIndex; i++) {
			if (i > startIndex) {
				buf.append(separator);
			}
			buf.append(array[i]);
		}
		return buf.toString();
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing
	 * the provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. A {@code null} separator
	 * is the same as an empty String (""). Null objects or empty strings within
	 * the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *) = null
	 * StringUtils.join([], *) = ""
	 * StringUtils.join([null], *) = ""
	 * StringUtils.join(["a", "b", "c"], "--") = "a--b--c"
	 * StringUtils.join(["a", "b", "c"], null) = "abc"
	 * StringUtils.join(["a", "b", "c"], "") = "abc"
	 * StringUtils.join([null, "", "a"], ',') = ",,a"
	 * </pre>
	 *
	 * @param array
	 *            the array of values to join together, may be null
	 * @param separator
	 *            the separator character to use, null treated as ""
	 * @return the joined String, {@code null} if null array input
	 */
	public static String join(final Object[] array, final String separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	/**
	 * <p>
	 * Joins the elements of the provided array into a single String containing
	 * the provided list of elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. A {@code null} separator
	 * is the same as an empty String (""). Null objects or empty strings within
	 * the array are represented by empty strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.join(null, *, *, *) = null
	 * StringUtils.join([], *, *, *) = ""
	 * StringUtils.join([null], *, *, *) = ""
	 * StringUtils.join(["a", "b", "c"], "--", 0, 3) = "a--b--c"
	 * StringUtils.join(["a", "b", "c"], "--", 1, 3) = "b--c"
	 * StringUtils.join(["a", "b", "c"], "--", 2, 3) = "c"
	 * StringUtils.join(["a", "b", "c"], "--", 2, 2) = ""
	 * StringUtils.join(["a", "b", "c"], null, 0, 3) = "abc"
	 * StringUtils.join(["a", "b", "c"], "", 0, 3) = "abc"
	 * StringUtils.join([null, "", "a"], ',', 0, 3) = ",,a"
	 * </pre>
	 *
	 * @param array
	 *            the array of values to join together, may be null
	 * @param separator
	 *            the separator character to use, null treated as ""
	 * @param startIndex
	 *            the first index to start joining from.
	 * @param endIndex
	 *            the index to stop joining from (exclusive).
	 * @return the joined String, {@code null} if null array input; or the empty
	 *         string if {@code endIndex - startIndex <= 0}. The number of
	 *         joined entries is given by {@code endIndex - startIndex}
	 * @throws ArrayIndexOutOfBoundsException
	 *             ife<br>
	 *             {@code startIndex < 0} or <br>
	 *             {@code startIndex >= array.length()} or <br>
	 *             {@code endIndex < 0} or <br>
	 *             {@code endIndex > array.length()}
	 */
	public static String join(final Object[] array, String separator,
			final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		if (separator == null) {
			separator = EMPTY;
		}
		// endIndex - startIndex > 0: Len = NofStrings *(len(firstString) +
		// len(separator))
		// (Assuming that all Strings are roughly equally long)
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = new StringBuilder(noOfItems * 16);
		for (int i = startIndex; i < endIndex; i++) {
			if (i > startIndex) {
				buf.append(separator);
			}
			if (array[i] != null) {
				buf.append(array[i]);
			}
		}
		return buf.toString();
	}

	/**
	 * <p>
	 * Joins the elements of the provided {@code Iterator} into a single String
	 * containing the provided elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty
	 * strings within the iteration are represented by empty strings.
	 * </p>
	 *
	 * <p>
	 * See the examples here: {@link #join(Object[],char)}.
	 * </p>
	 *
	 * @param iterator
	 *            the {@code Iterator} of values to join together, may be null
	 * @param separator
	 *            the separator character to use
	 * @return the joined String, {@code null} if null iterator input
	 * @since 2.0
	 */
	public static String join(final Iterator<?> iterator, final char separator) {
		// handle null, zero and one elements before building a buffer
		if (iterator == null) {
			return null;
		}
		if (!iterator.hasNext()) {
			return EMPTY;
		}
		final Object first = iterator.next();
		if (!iterator.hasNext()) {
			final String result = Objects.toString(first, EMPTY);
			return result;
		}
		// two or more elements
		final StringBuilder buf = new StringBuilder(256); // Java default is 16,
															// probably too
															// small
		if (first != null) {
			buf.append(first);
		}
		while (iterator.hasNext()) {
			buf.append(separator);
			final Object obj = iterator.next();
			if (obj != null) {
				buf.append(obj);
			}
		}
		return buf.toString();
	}

	/**
	 * <p>
	 * Joins the elements of the provided {@code Iterator} into a single String
	 * containing the provided elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. A {@code null} separator
	 * is the same as an empty String ("").
	 * </p>
	 *
	 * <p>
	 * See the examples here: {@link #join(Object[],String)}.
	 * </p>
	 *
	 * @param iterator
	 *            the {@code Iterator} of values to join together, may be null
	 * @param separator
	 *            the separator character to use, null treated as ""
	 * @return the joined String, {@code null} if null iterator input
	 */
	public static String join(final Iterator<?> iterator, final String separator) {
		// handle null, zero and one elements before building a buffer
		if (iterator == null) {
			return null;
		}
		if (!iterator.hasNext()) {
			return EMPTY;
		}
		final Object first = iterator.next();
		if (!iterator.hasNext()) {
			final String result = Objects.toString(first, EMPTY);
			return result;
		}
		// two or more elements
		final StringBuilder buf = new StringBuilder(256); // Java default is 16,
															// probably too
															// small
		if (first != null) {
			buf.append(first);
		}
		while (iterator.hasNext()) {
			if (separator != null) {
				buf.append(separator);
			}
			final Object obj = iterator.next();
			if (obj != null) {
				buf.append(obj);
			}
		}
		return buf.toString();
	}

	/**
	 * <p>
	 * Joins the elements of the provided {@code Iterable} into a single String
	 * containing the provided elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. Null objects or empty
	 * strings within the iteration are represented by empty strings.
	 * </p>
	 *
	 * <p>
	 * See the examples here: {@link #join(Object[],char)}.
	 * </p>
	 *
	 * @param iterable
	 *            the {@code Iterable} providing the values to join together,
	 *            may be null
	 * @param separator
	 *            the separator character to use
	 * @return the joined String, {@code null} if null iterator input
	 * @since 2.3
	 */
	public static String join(final Iterable<?> iterable, final char separator) {
		if (iterable == null) {
			return null;
		}
		return join(iterable.iterator(), separator);
	}

	/**
	 * <p>
	 * Joins the elements of the provided {@code Iterable} into a single String
	 * containing the provided elements.
	 * </p>
	 *
	 * <p>
	 * No delimiter is added before or after the list. A {@code null} separator
	 * is the same as an empty String ("").
	 * </p>
	 *
	 * <p>
	 * See the examples here: {@link #join(Object[],String)}.
	 * </p>
	 *
	 * @param iterable
	 *            the {@code Iterable} providing the values to join together,
	 *            may be null
	 * @param separator
	 *            the separator character to use, null treated as ""
	 * @return the joined String, {@code null} if null iterator input
	 * @since 2.3
	 */
	public static String join(final Iterable<?> iterable, final String separator) {
		if (iterable == null) {
			return null;
		}
		return join(iterable.iterator(), separator);
	}

	// Delete
	// -----------------------------------------------------------------------
	// Remove
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Removes a substring only if it is at the beginning of a source string,
	 * otherwise returns the source string.
	 * </p>
	 *
	 * <p>
	 * A {@code null} source string will return {@code null}. An empty ("")
	 * source string will return the empty string. A {@code null} search string
	 * will return the source string.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.removeStart(null, *) = null
	 * StringUtils.removeStart("", *) = ""
	 * StringUtils.removeStart(*, null) = *
	 * StringUtils.removeStart("www.domain.com", "www.") = "domain.com"
	 * StringUtils.removeStart("domain.com", "www.") = "domain.com"
	 * StringUtils.removeStart("www.domain.com", "domain") = "www.domain.com"
	 * StringUtils.removeStart("abc", "") = "abc"
	 * </pre>
	 *
	 * @param str
	 *            the source String to search, may be null
	 * @param remove
	 *            the String to search for and remove, may be null
	 * @return the substring with the string removed if found, {@code null} if
	 *         null String input
	 * @since 2.1
	 */
	public static String removeStart(final String str, final String remove) {
		if (isEmpty(str) || isEmpty(remove)) {
			return str;
		}
		if (str.startsWith(remove)) {
			return str.substring(remove.length());
		}
		return str;
	}

	/**
	 * <p>
	 * Case insensitive removal of a substring if it is at the beginning of a
	 * source string, otherwise returns the source string.
	 * </p>
	 *
	 * <p>
	 * A {@code null} source string will return {@code null}. An empty ("")
	 * source string will return the empty string. A {@code null} search string
	 * will return the source string.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.removeStartIgnoreCase(null, *) = null
	 * StringUtils.removeStartIgnoreCase("", *) = ""
	 * StringUtils.removeStartIgnoreCase(*, null) = *
	 * StringUtils.removeStartIgnoreCase("www.domain.com", "www.") = "domain.com"
	 * StringUtils.removeStartIgnoreCase("www.domain.com", "WWW.") = "domain.com"
	 * StringUtils.removeStartIgnoreCase("domain.com", "www.") = "domain.com"
	 * StringUtils.removeStartIgnoreCase("www.domain.com", "domain") = "www.domain.com"
	 * StringUtils.removeStartIgnoreCase("abc", "") = "abc"
	 * </pre>
	 *
	 * @param str
	 *            the source String to search, may be null
	 * @param remove
	 *            the String to search for (case insensitive) and remove, may be
	 *            null
	 * @return the substring with the string removed if found, {@code null} if
	 *         null String input
	 * @since 2.4
	 */
	public static String removeStartIgnoreCase(final String str,
			final String remove) {
		if (isEmpty(str) || isEmpty(remove)) {
			return str;
		}
		if (startsWithIgnoreCase(str, remove)) {
			return str.substring(remove.length());
		}
		return str;
	}

	/**
	 * <p>
	 * Removes a substring only if it is at the end of a source string,
	 * otherwise returns the source string.
	 * </p>
	 *
	 * <p>
	 * A {@code null} source string will return {@code null}. An empty ("")
	 * source string will return the empty string. A {@code null} search string
	 * will return the source string.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.removeEnd(null, *) = null
	 * StringUtils.removeEnd("", *) = ""
	 * StringUtils.removeEnd(*, null) = *
	 * StringUtils.removeEnd("www.domain.com", ".com.") = "www.domain.com"
	 * StringUtils.removeEnd("www.domain.com", ".com") = "www.domain"
	 * StringUtils.removeEnd("www.domain.com", "domain") = "www.domain.com"
	 * StringUtils.removeEnd("abc", "") = "abc"
	 * </pre>
	 *
	 * @param str
	 *            the source String to search, may be null
	 * @param remove
	 *            the String to search for and remove, may be null
	 * @return the substring with the string removed if found, {@code null} if
	 *         null String input
	 * @since 2.1
	 */
	public static String removeEnd(final String str, final String remove) {
		if (isEmpty(str) || isEmpty(remove)) {
			return str;
		}
		if (str.endsWith(remove)) {
			return str.substring(0, str.length() - remove.length());
		}
		return str;
	}

	/**
	 * <p>
	 * Case insensitive removal of a substring if it is at the end of a source
	 * string, otherwise returns the source string.
	 * </p>
	 *
	 * <p>
	 * A {@code null} source string will return {@code null}. An empty ("")
	 * source string will return the empty string. A {@code null} search string
	 * will return the source string.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.removeEndIgnoreCase(null, *) = null
	 * StringUtils.removeEndIgnoreCase("", *) = ""
	 * StringUtils.removeEndIgnoreCase(*, null) = *
	 * StringUtils.removeEndIgnoreCase("www.domain.com", ".com.") = "www.domain.com"
	 * StringUtils.removeEndIgnoreCase("www.domain.com", ".com") = "www.domain"
	 * StringUtils.removeEndIgnoreCase("www.domain.com", "domain") = "www.domain.com"
	 * StringUtils.removeEndIgnoreCase("abc", "") = "abc"
	 * StringUtils.removeEndIgnoreCase("www.domain.com", ".COM") = "www.domain")
	 * StringUtils.removeEndIgnoreCase("www.domain.COM", ".com") = "www.domain")
	 * </pre>
	 *
	 * @param str
	 *            the source String to search, may be null
	 * @param remove
	 *            the String to search for (case insensitive) and remove, may be
	 *            null
	 * @return the substring with the string removed if found, {@code null} if
	 *         null String input
	 * @since 2.4
	 */
	public static String removeEndIgnoreCase(final String str,
			final String remove) {
		if (isEmpty(str) || isEmpty(remove)) {
			return str;
		}
		if (endsWithIgnoreCase(str, remove)) {
			return str.substring(0, str.length() - remove.length());
		}
		return str;
	}

	/**
	 * <p>
	 * Removes all occurrences of a substring from within the source string.
	 * </p>
	 *
	 * <p>
	 * A {@code null} source string will return {@code null}. An empty ("")
	 * source string will return the empty string. A {@code null} remove string
	 * will return the source string. An empty ("") remove string will return
	 * the source string.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.remove(null, *) = null
	 * StringUtils.remove("", *) = ""
	 * StringUtils.remove(*, null) = *
	 * StringUtils.remove(*, "") = *
	 * StringUtils.remove("queued", "ue") = "qd"
	 * StringUtils.remove("queued", "zz") = "queued"
	 * </pre>
	 *
	 * @param str
	 *            the source String to search, may be null
	 * @param remove
	 *            the String to search for and remove, may be null
	 * @return the substring with the string removed if found, {@code null} if
	 *         null String input
	 * @since 2.1
	 */
	public static String remove(final String str, final String remove) {
		if (isEmpty(str) || isEmpty(remove)) {
			return str;
		}
		return replace(str, remove, EMPTY, -1);
	}

	public static String removeTabsAndNewLine(final String str) {
		if (isEmpty(str)) {
			return str;
		}
		String s = replace(str, "\t", EMPTY, -1);
		s = replace(str, "\n", EMPTY, -1);
		return s; 
	}

	/**
	 * <p>
	 * Removes all occurrences of a character from within the source string.
	 * </p>
	 *
	 * <p>
	 * A {@code null} source string will return {@code null}. An empty ("")
	 * source string will return the empty string.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.remove(null, *) = null
	 * StringUtils.remove("", *) = ""
	 * StringUtils.remove("queued", 'u') = "qeed"
	 * StringUtils.remove("queued", 'z') = "queued"
	 * </pre>
	 *
	 * @param str
	 *            the source String to search, may be null
	 * @param remove
	 *            the char to search for and remove, may be null
	 * @return the substring with the char removed if found, {@code null} if
	 *         null String input
	 * @since 2.1
	 */
	public static String remove(final String str, final char remove) {
		if (isEmpty(str) || str.indexOf(remove) == INDEX_NOT_FOUND) {
			return str;
		}
		final char[] chars = str.toCharArray();
		int pos = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != remove) {
				chars[pos++] = chars[i];
			}
		}
		return new String(chars, 0, pos);
	}

	// Replacing
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Replaces a String with another String inside a larger String, once.
	 * </p>
	 *
	 * <p>
	 * A {@code null} reference passed to this method is a no-op.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.replaceOnce(null, *, *) = null
	 * StringUtils.replaceOnce("", *, *) = ""
	 * StringUtils.replaceOnce("any", null, *) = "any"
	 * StringUtils.replaceOnce("any", *, null) = "any"
	 * StringUtils.replaceOnce("any", "", *) = "any"
	 * StringUtils.replaceOnce("aba", "a", null) = "aba"
	 * StringUtils.replaceOnce("aba", "a", "") = "ba"
	 * StringUtils.replaceOnce("aba", "a", "z") = "zba"
	 * </pre>
	 *
	 * @see #replace(String text, String searchString, String replacement, int
	 *      max)
	 * @param text
	 *            text to search and replace in, may be null
	 * @param searchString
	 *            the String to search for, may be null
	 * @param replacement
	 *            the String to replace with, may be null
	 * @return the text with any replacements processed, {@code null} if null
	 *         String input
	 */
	public static String replaceOnce(final String text,
			final String searchString, final String replacement) {
		return replace(text, searchString, replacement, 1);
	}

	/**
	 * <p>
	 * Replaces all occurrences of a String within another String.
	 * </p>
	 *
	 * <p>
	 * A {@code null} reference passed to this method is a no-op.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.replace(null, *, *) = null
	 * StringUtils.replace("", *, *) = ""
	 * StringUtils.replace("any", null, *) = "any"
	 * StringUtils.replace("any", *, null) = "any"
	 * StringUtils.replace("any", "", *) = "any"
	 * StringUtils.replace("aba", "a", null) = "aba"
	 * StringUtils.replace("aba", "a", "") = "b"
	 * StringUtils.replace("aba", "a", "z") = "zbz"
	 * </pre>
	 *
	 * @see #replace(String text, String searchString, String replacement, int
	 *      max)
	 * @param text
	 *            text to search and replace in, may be null
	 * @param searchString
	 *            the String to search for, may be null
	 * @param replacement
	 *            the String to replace it with, may be null
	 * @return the text with any replacements processed, {@code null} if null
	 *         String input
	 */
	public static String replace(final String text, final String searchString,
			final String replacement) {
		return replace(text, searchString, replacement, -1);
	}

	/**
	 * <p>
	 * Replaces a String with another String inside a larger String, for the
	 * first {@code max} values of the search String.
	 * </p>
	 *
	 * <p>
	 * A {@code null} reference passed to this method is a no-op.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.replace(null, *, *, *) = null
	 * StringUtils.replace("", *, *, *) = ""
	 * StringUtils.replace("any", null, *, *) = "any"
	 * StringUtils.replace("any", *, null, *) = "any"
	 * StringUtils.replace("any", "", *, *) = "any"
	 * StringUtils.replace("any", *, *, 0) = "any"
	 * StringUtils.replace("abaa", "a", null, -1) = "abaa"
	 * StringUtils.replace("abaa", "a", "", -1) = "b"
	 * StringUtils.replace("abaa", "a", "z", 0) = "abaa"
	 * StringUtils.replace("abaa", "a", "z", 1) = "zbaa"
	 * StringUtils.replace("abaa", "a", "z", 2) = "zbza"
	 * StringUtils.replace("abaa", "a", "z", -1) = "zbzz"
	 * </pre>
	 *
	 * @param text
	 *            text to search and replace in, may be null
	 * @param searchString
	 *            the String to search for, may be null
	 * @param replacement
	 *            the String to replace it with, may be null
	 * @param max
	 *            maximum number of values to replace, or {@code -1} if no
	 *            maximum
	 * @return the text with any replacements processed, {@code null} if null
	 *         String input
	 */
	public static String replace(final String text, final String searchString,
			final String replacement, int max) {
		if (isEmpty(text) || isEmpty(searchString) || replacement == null
				|| max == 0) {
			return text;
		}
		int start = 0;
		int end = text.indexOf(searchString, start);
		if (end == INDEX_NOT_FOUND) {
			return text;
		}
		final int replLength = searchString.length();
		int increase = replacement.length() - replLength;
		increase = increase < 0 ? 0 : increase;
		increase *= max < 0 ? 16 : max > 64 ? 64 : max;
		final StringBuilder buf = new StringBuilder(text.length() + increase);
		while (end != INDEX_NOT_FOUND) {
			buf.append(text.substring(start, end)).append(replacement);
			start = end + replLength;
			if (--max == 0) {
				break;
			}
			end = text.indexOf(searchString, start);
		}
		buf.append(text.substring(start));
		return buf.toString();
	}

	/**
	 * <p>
	 * Replaces all occurrences of Strings within another String.
	 * </p>
	 *
	 * <p>
	 * A {@code null} reference passed to this method is a no-op, or if any
	 * "search string" or "string to replace" is null, that replace will be
	 * ignored. This will not repeat. For repeating replaces, call the
	 * overloaded method.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.replaceEach(null, *, *) = null
	 * StringUtils.replaceEach("", *, *) = ""
	 * StringUtils.replaceEach("aba", null, null) = "aba"
	 * StringUtils.replaceEach("aba", new String[0], null) = "aba"
	 * StringUtils.replaceEach("aba", null, new String[0]) = "aba"
	 * StringUtils.replaceEach("aba", new String[]{"a"}, null) = "aba"
	 * StringUtils.replaceEach("aba", new String[]{"a"}, new String[]{""}) = "b"
	 * StringUtils.replaceEach("aba", new String[]{null}, new String[]{"a"}) = "aba"
	 * StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"w", "t"}) = "wcte"
	 * (example of how it does not repeat)
	 * StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"d", "t"}) = "dcte"
	 * </pre>
	 *
	 * @param text
	 *            text to search and replace in, no-op if null
	 * @param searchList
	 *            the Strings to search for, no-op if null
	 * @param replacementList
	 *            the Strings to replace them with, no-op if null
	 * @return the text with any replacements processed, {@code null} if null
	 *         String input
	 * @throws IllegalArgumentException
	 *             if the lengths of the arrays are not the same (null is ok,
	 *             and/or size 0)
	 * @since 2.4
	 */
	public static String replaceEach(final String text,
			final String[] searchList, final String[] replacementList) {
		return replaceEach(text, searchList, replacementList, false, 0);
	}

	/**
	 * <p>
	 * Replaces all occurrences of Strings within another String.
	 * </p>
	 *
	 * <p>
	 * A {@code null} reference passed to this method is a no-op, or if any
	 * "search string" or "string to replace" is null, that replace will be
	 * ignored.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.replaceEach(null, *, *, *) = null
	 * StringUtils.replaceEach("", *, *, *) = ""
	 * StringUtils.replaceEach("aba", null, null, *) = "aba"
	 * StringUtils.replaceEach("aba", new String[0], null, *) = "aba"
	 * StringUtils.replaceEach("aba", null, new String[0], *) = "aba"
	 * StringUtils.replaceEach("aba", new String[]{"a"}, null, *) = "aba"
	 * StringUtils.replaceEach("aba", new String[]{"a"}, new String[]{""}, *) = "b"
	 * StringUtils.replaceEach("aba", new String[]{null}, new String[]{"a"}, *) = "aba"
	 * StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"w", "t"}, *) = "wcte"
	 * (example of how it repeats)
	 * StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"d", "t"}, false) = "dcte"
	 * StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"d", "t"}, true) = "tcte"
	 * StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"d", "ab"}, true) = IllegalStateException
	 * StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"d", "ab"}, false) = "dcabe"
	 * </pre>
	 *
	 * @param text
	 *            text to search and replace in, no-op if null
	 * @param searchList
	 *            the Strings to search for, no-op if null
	 * @param replacementList
	 *            the Strings to replace them with, no-op if null
	 * @return the text with any replacements processed, {@code null} if null
	 *         String input
	 * @throws IllegalStateException
	 *             if the search is repeating and there is an endless loop due
	 *             to outputs of one being inputs to another
	 * @throws IllegalArgumentException
	 *             if the lengths of the arrays are not the same (null is ok,
	 *             and/or size 0)
	 * @since 2.4
	 */
	public static String replaceEachRepeatedly(final String text,
			final String[] searchList, final String[] replacementList) {
		// timeToLive should be 0 if not used or nothing to replace, else it's
		// the length of the replace array
		final int timeToLive = searchList == null ? 0 : searchList.length;
		return replaceEach(text, searchList, replacementList, true, timeToLive);
	}

	/**
	 * <p>
	 * Replaces all occurrences of Strings within another String.
	 * </p>
	 *
	 * <p>
	 * A {@code null} reference passed to this method is a no-op, or if any
	 * "search string" or "string to replace" is null, that replace will be
	 * ignored.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.replaceEach(null, *, *, *) = null
	 * StringUtils.replaceEach("", *, *, *) = ""
	 * StringUtils.replaceEach("aba", null, null, *) = "aba"
	 * StringUtils.replaceEach("aba", new String[0], null, *) = "aba"
	 * StringUtils.replaceEach("aba", null, new String[0], *) = "aba"
	 * StringUtils.replaceEach("aba", new String[]{"a"}, null, *) = "aba"
	 * StringUtils.replaceEach("aba", new String[]{"a"}, new String[]{""}, *) = "b"
	 * StringUtils.replaceEach("aba", new String[]{null}, new String[]{"a"}, *) = "aba"
	 * StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"w", "t"}, *) = "wcte"
	 * (example of how it repeats)
	 * StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"d", "t"}, false) = "dcte"
	 * StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"d", "t"}, true) = "tcte"
	 * StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"d", "ab"}, *) = IllegalStateException
	 * </pre>
	 *
	 * @param text
	 *            text to search and replace in, no-op if null
	 * @param searchList
	 *            the Strings to search for, no-op if null
	 * @param replacementList
	 *            the Strings to replace them with, no-op if null
	 * @param repeat
	 *            if true, then replace repeatedly until there are no more
	 *            possible replacements or timeToLive < 0
	 * @param timeToLive
	 *            if less than 0 then there is a circular reference and endless
	 *            loop
	 * @return the text with any replacements processed, {@code null} if null
	 *         String input
	 * @throws IllegalStateException
	 *             if the search is repeating and there is an endless loop due
	 *             to outputs of one being inputs to another
	 * @throws IllegalArgumentException
	 *             if the lengths of the arrays are not the same (null is ok,
	 *             and/or size 0)
	 * @since 2.4
	 */
	private static String replaceEach(final String text,
			final String[] searchList, final String[] replacementList,
			final boolean repeat, final int timeToLive) {
		// mchyzer Performance note: This creates very few new objects (one
		// major goal)
		// let me know if there are performance requests, we can create a
		// harness to measure
		if (text == null || text.isEmpty() || searchList == null
				|| searchList.length == 0 || replacementList == null
				|| replacementList.length == 0) {
			return text;
		}
		// if recursing, this shouldn't be less than 0
		if (timeToLive < 0) {
			throw new IllegalStateException(
					"Aborting to protect against StackOverflowError - "
							+ "output of one loop is the input of another");
		}
		final int searchLength = searchList.length;
		final int replacementLength = replacementList.length;
		// make sure lengths are ok, these need to be equal
		if (searchLength != replacementLength) {
			throw new IllegalArgumentException(
					"Search and Replace array lengths don't match: "
							+ searchLength + " vs " + replacementLength);
		}
		// keep track of which still have matches
		final boolean[] noMoreMatchesForReplIndex = new boolean[searchLength];
		// index on index that the match was found
		int textIndex = -1;
		int replaceIndex = -1;
		int tempIndex = -1;
		// index of replace array that will replace the search string found
		// NOTE: logic duplicated below START
		for (int i = 0; i < searchLength; i++) {
			if (noMoreMatchesForReplIndex[i] || searchList[i] == null
					|| searchList[i].isEmpty() || replacementList[i] == null) {
				continue;
			}
			tempIndex = text.indexOf(searchList[i]);
			// see if we need to keep searching for this
			if (tempIndex == -1) {
				noMoreMatchesForReplIndex[i] = true;
			} else {
				if (textIndex == -1 || tempIndex < textIndex) {
					textIndex = tempIndex;
					replaceIndex = i;
				}
			}
		}
		// NOTE: logic mostly below END
		// no search strings found, we are done
		if (textIndex == -1) {
			return text;
		}
		int start = 0;
		// get a good guess on the size of the result buffer so it doesn't have
		// to double if it goes over a bit
		int increase = 0;
		// count the replacement text elements that are larger than their
		// corresponding text being replaced
		for (int i = 0; i < searchList.length; i++) {
			if (searchList[i] == null || replacementList[i] == null) {
				continue;
			}
			final int greater = replacementList[i].length()
					- searchList[i].length();
			if (greater > 0) {
				increase += 3 * greater; // assume 3 matches
			}
		}
		// have upper-bound at 20% increase, then let Java take over
		increase = Math.min(increase, text.length() / 5);
		final StringBuilder buf = new StringBuilder(text.length() + increase);
		while (textIndex != -1) {
			for (int i = start; i < textIndex; i++) {
				buf.append(text.charAt(i));
			}
			buf.append(replacementList[replaceIndex]);
			start = textIndex + searchList[replaceIndex].length();
			textIndex = -1;
			replaceIndex = -1;
			tempIndex = -1;
			// find the next earliest match
			// NOTE: logic mostly duplicated above START
			for (int i = 0; i < searchLength; i++) {
				if (noMoreMatchesForReplIndex[i] || searchList[i] == null
						|| searchList[i].isEmpty()
						|| replacementList[i] == null) {
					continue;
				}
				tempIndex = text.indexOf(searchList[i], start);
				// see if we need to keep searching for this
				if (tempIndex == -1) {
					noMoreMatchesForReplIndex[i] = true;
				} else {
					if (textIndex == -1 || tempIndex < textIndex) {
						textIndex = tempIndex;
						replaceIndex = i;
					}
				}
			}
			// NOTE: logic duplicated above END
		}
		final int textLength = text.length();
		for (int i = start; i < textLength; i++) {
			buf.append(text.charAt(i));
		}
		final String result = buf.toString();
		if (!repeat) {
			return result;
		}
		return replaceEach(result, searchList, replacementList, repeat,
				timeToLive - 1);
	}

	// Replace, character based
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Replaces all occurrences of a character in a String with another. This is
	 * a null-safe version of {@link String#replace(char, char)}.
	 * </p>
	 *
	 * <p>
	 * A {@code null} string input returns {@code null}. An empty ("") string
	 * input returns an empty string.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.replaceChars(null, *, *) = null
	 * StringUtils.replaceChars("", *, *) = ""
	 * StringUtils.replaceChars("abcba", 'b', 'y') = "aycya"
	 * StringUtils.replaceChars("abcba", 'z', 'y') = "abcba"
	 * </pre>
	 *
	 * @param str
	 *            String to replace characters in, may be null
	 * @param searchChar
	 *            the character to search for, may be null
	 * @param replaceChar
	 *            the character to replace, may be null
	 * @return modified String, {@code null} if null string input
	 * @since 2.0
	 */
	public static String replaceChars(final String str, final char searchChar,
			final char replaceChar) {
		if (str == null) {
			return null;
		}
		return str.replace(searchChar, replaceChar);
	}

	/**
	 * <p>
	 * Replaces multiple characters in a String in one go. This method can also
	 * be used to delete characters.
	 * </p>
	 *
	 * <p>
	 * For example:<br>
	 * <code>replaceChars(&quot;hello&quot;, &quot;ho&quot;, &quot;jy&quot;) = jelly</code>
	 * .
	 * </p>
	 *
	 * <p>
	 * A {@code null} string input returns {@code null}. An empty ("") string
	 * input returns an empty string. A null or empty set of search characters
	 * returns the input string.
	 * </p>
	 *
	 * <p>
	 * The length of the search characters should normally equal the length of
	 * the replace characters. If the search characters is longer, then the
	 * extra search characters are deleted. If the search characters is shorter,
	 * then the extra replace characters are ignored.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.replaceChars(null, *, *) = null
	 * StringUtils.replaceChars("", *, *) = ""
	 * StringUtils.replaceChars("abc", null, *) = "abc"
	 * StringUtils.replaceChars("abc", "", *) = "abc"
	 * StringUtils.replaceChars("abc", "b", null) = "ac"
	 * StringUtils.replaceChars("abc", "b", "") = "ac"
	 * StringUtils.replaceChars("abcba", "bc", "yz") = "ayzya"
	 * StringUtils.replaceChars("abcba", "bc", "y") = "ayya"
	 * StringUtils.replaceChars("abcba", "bc", "yzx") = "ayzya"
	 * </pre>
	 *
	 * @param str
	 *            String to replace characters in, may be null
	 * @param searchChars
	 *            a set of characters to search for, may be null
	 * @param replaceChars
	 *            a set of characters to replace, may be null
	 * @return modified String, {@code null} if null string input
	 * @since 2.0
	 */
	public static String replaceChars(final String str,
			final String searchChars, String replaceChars) {
		if (isEmpty(str) || isEmpty(searchChars)) {
			return str;
		}
		if (replaceChars == null) {
			replaceChars = EMPTY;
		}
		boolean modified = false;
		final int replaceCharsLength = replaceChars.length();
		final int strLength = str.length();
		final StringBuilder buf = new StringBuilder(strLength);
		for (int i = 0; i < strLength; i++) {
			final char ch = str.charAt(i);
			final int index = searchChars.indexOf(ch);
			if (index >= 0) {
				modified = true;
				if (index < replaceCharsLength) {
					buf.append(replaceChars.charAt(index));
				}
			} else {
				buf.append(ch);
			}
		}
		if (modified) {
			return buf.toString();
		}
		return str;
	}

	// Overlay
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Overlays part of a String with another String.
	 * </p>
	 *
	 * <p>
	 * A {@code null} string input returns {@code null}. A negative index is
	 * treated as zero. An index greater than the string length is treated as
	 * the string length. The start index is always the smaller of the two
	 * indices.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.overlay(null, *, *, *) = null
	 * StringUtils.overlay("", "abc", 0, 0) = "abc"
	 * StringUtils.overlay("abcdef", null, 2, 4) = "abef"
	 * StringUtils.overlay("abcdef", "", 2, 4) = "abef"
	 * StringUtils.overlay("abcdef", "", 4, 2) = "abef"
	 * StringUtils.overlay("abcdef", "zzzz", 2, 4) = "abzzzzef"
	 * StringUtils.overlay("abcdef", "zzzz", 4, 2) = "abzzzzef"
	 * StringUtils.overlay("abcdef", "zzzz", -1, 4) = "zzzzef"
	 * StringUtils.overlay("abcdef", "zzzz", 2, 8) = "abzzzz"
	 * StringUtils.overlay("abcdef", "zzzz", -2, -3) = "zzzzabcdef"
	 * StringUtils.overlay("abcdef", "zzzz", 8, 10) = "abcdefzzzz"
	 * </pre>
	 *
	 * @param str
	 *            the String to do overlaying in, may be null
	 * @param overlay
	 *            the String to overlay, may be null
	 * @param start
	 *            the position to start overlaying at
	 * @param end
	 *            the position to stop overlaying before
	 * @return overlayed String, {@code null} if null String input
	 * @since 2.0
	 */
	public static String overlay(final String str, String overlay, int start,
			int end) {
		if (str == null) {
			return null;
		}
		if (overlay == null) {
			overlay = EMPTY;
		}
		final int len = str.length();
		if (start < 0) {
			start = 0;
		}
		if (start > len) {
			start = len;
		}
		if (end < 0) {
			end = 0;
		}
		if (end > len) {
			end = len;
		}
		if (start > end) {
			final int temp = start;
			start = end;
			end = temp;
		}
		return new StringBuilder(len + start - end + overlay.length() + 1)
				.append(str.substring(0, start)).append(overlay)
				.append(str.substring(end)).toString();
	}

	// Chomping
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Removes one newline from end of a String if it's there, otherwise leave
	 * it alone. A newline is &quot;{@code \n}&quot;, &quot;{@code \r}&quot;, or
	 * &quot;{@code \r\n}&quot;.
	 * </p>
	 *
	 * <p>
	 * NOTE: This method changed in 2.0. It now more closely matches Perl chomp.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.chomp(null) = null
	 * StringUtils.chomp("") = ""
	 * StringUtils.chomp("abc \r") = "abc "
	 * StringUtils.chomp("abc\n") = "abc"
	 * StringUtils.chomp("abc\r\n") = "abc"
	 * StringUtils.chomp("abc\r\n\r\n") = "abc\r\n"
	 * StringUtils.chomp("abc\n\r") = "abc\n"
	 * StringUtils.chomp("abc\n\rabc") = "abc\n\rabc"
	 * StringUtils.chomp("\r") = ""
	 * StringUtils.chomp("\n") = ""
	 * StringUtils.chomp("\r\n") = ""
	 * </pre>
	 *
	 * @param str
	 *            the String to chomp a newline from, may be null
	 * @return String without newline, {@code null} if null String input
	 */
	public static String chomp(final String str) {
		if (isEmpty(str)) {
			return str;
		}
		if (str.length() == 1) {
			final char ch = str.charAt(0);
			if (ch == MkpkCharUtils.CR || ch == MkpkCharUtils.LF) {
				return EMPTY;
			}
			return str;
		}
		int lastIdx = str.length() - 1;
		final char last = str.charAt(lastIdx);
		if (last == MkpkCharUtils.LF) {
			if (str.charAt(lastIdx - 1) == MkpkCharUtils.CR) {
				lastIdx--;
			}
		} else if (last != MkpkCharUtils.CR) {
			lastIdx++;
		}
		return str.substring(0, lastIdx);
	}

	/**
	 * <p>
	 * Removes {@code separator} from the end of {@code str} if it's there,
	 * otherwise leave it alone.
	 * </p>
	 *
	 * <p>
	 * NOTE: This method changed in version 2.0. It now more closely matches
	 * Perl chomp. For the previous behavior, use
	 * {@link #substringBeforeLast(String, String)}. This method uses
	 * {@link String#endsWith(String)}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.chomp(null, *) = null
	 * StringUtils.chomp("", *) = ""
	 * StringUtils.chomp("foobar", "bar") = "foo"
	 * StringUtils.chomp("foobar", "baz") = "foobar"
	 * StringUtils.chomp("foo", "foo") = ""
	 * StringUtils.chomp("foo ", "foo") = "foo "
	 * StringUtils.chomp(" foo", "foo") = " "
	 * StringUtils.chomp("foo", "foooo") = "foo"
	 * StringUtils.chomp("foo", "") = "foo"
	 * StringUtils.chomp("foo", null) = "foo"
	 * </pre>
	 *
	 * @param str
	 *            the String to chomp from, may be null
	 * @param separator
	 *            separator String, may be null
	 * @return String without trailing separator, {@code null} if null String
	 *         input
	 * @deprecated This feature will be removed in Lang 4.0, use
	 *             {@link StringUtils#removeEnd(String, String)} instead
	 */
	@Deprecated
	public static String chomp(final String str, final String separator) {
		return removeEnd(str, separator);
	}

	// Chopping
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Remove the last character from a String.
	 * </p>
	 *
	 * <p>
	 * If the String ends in {@code \r\n}, then remove both of them.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.chop(null) = null
	 * StringUtils.chop("") = ""
	 * StringUtils.chop("abc \r") = "abc "
	 * StringUtils.chop("abc\n") = "abc"
	 * StringUtils.chop("abc\r\n") = "abc"
	 * StringUtils.chop("abc") = "ab"
	 * StringUtils.chop("abc\nabc") = "abc\nab"
	 * StringUtils.chop("a") = ""
	 * StringUtils.chop("\r") = ""
	 * StringUtils.chop("\n") = ""
	 * StringUtils.chop("\r\n") = ""
	 * </pre>
	 *
	 * @param str
	 *            the String to chop last character from, may be null
	 * @return String without last character, {@code null} if null String input
	 */
	public static String chop(final String str) {
		if (str == null) {
			return null;
		}
		final int strLen = str.length();
		if (strLen < 2) {
			return EMPTY;
		}
		final int lastIdx = strLen - 1;
		final String ret = str.substring(0, lastIdx);
		final char last = str.charAt(lastIdx);
		if (last == MkpkCharUtils.LF
				&& ret.charAt(lastIdx - 1) == MkpkCharUtils.CR) {
			return ret.substring(0, lastIdx - 1);
		}
		return ret;
	}

	// Conversion
	// -----------------------------------------------------------------------
	// Padding
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Repeat a String {@code repeat} times to form a new String.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.repeat(null, 2) = null
	 * StringUtils.repeat("", 0) = ""
	 * StringUtils.repeat("", 2) = ""
	 * StringUtils.repeat("a", 3) = "aaa"
	 * StringUtils.repeat("ab", 2) = "abab"
	 * StringUtils.repeat("a", -2) = ""
	 * </pre>
	 *
	 * @param str
	 *            the String to repeat, may be null
	 * @param repeat
	 *            number of times to repeat str, negative treated as zero
	 * @return a new String consisting of the original String repeated,
	 *         {@code null} if null String input
	 */
	public static String repeat(final String str, final int repeat) {
		// Performance tuned for 2.0 (JDK1.4)
		if (str == null) {
			return null;
		}
		if (repeat <= 0) {
			return EMPTY;
		}
		final int inputLength = str.length();
		if (repeat == 1 || inputLength == 0) {
			return str;
		}
		if (inputLength == 1 && repeat <= PAD_LIMIT) {
			return repeat(str.charAt(0), repeat);
		}
		final int outputLength = inputLength * repeat;
		switch (inputLength) {
		case 1:
			return repeat(str.charAt(0), repeat);
		case 2:
			final char ch0 = str.charAt(0);
			final char ch1 = str.charAt(1);
			final char[] output2 = new char[outputLength];
			for (int i = repeat * 2 - 2; i >= 0; i--, i--) {
				output2[i] = ch0;
				output2[i + 1] = ch1;
			}
			return new String(output2);
		default:
			final StringBuilder buf = new StringBuilder(outputLength);
			for (int i = 0; i < repeat; i++) {
				buf.append(str);
			}
			return buf.toString();
		}
	}

	/**
	 * <p>
	 * Repeat a String {@code repeat} times to form a new String, with a String
	 * separator injected each time.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.repeat(null, null, 2) = null
	 * StringUtils.repeat(null, "x", 2) = null
	 * StringUtils.repeat("", null, 0) = ""
	 * StringUtils.repeat("", "", 2) = ""
	 * StringUtils.repeat("", "x", 3) = "xxx"
	 * StringUtils.repeat("?", ", ", 3) = "?, ?, ?"
	 * </pre>
	 *
	 * @param str
	 *            the String to repeat, may be null
	 * @param separator
	 *            the String to inject, may be null
	 * @param repeat
	 *            number of times to repeat str, negative treated as zero
	 * @return a new String consisting of the original String repeated,
	 *         {@code null} if null String input
	 * @since 2.5
	 */
	public static String repeat(final String str, final String separator,
			final int repeat) {
		if (str == null || separator == null) {
			return repeat(str, repeat);
		}
		// given that repeat(String, int) is quite optimized, better to rely on
		// it than try and splice this into it
		final String result = repeat(str + separator, repeat);
		return removeEnd(result, separator);
	}

	/**
	 * <p>
	 * Returns padding using the specified delimiter repeated to a given length.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.repeat('e', 0) = ""
	 * StringUtils.repeat('e', 3) = "eee"
	 * StringUtils.repeat('e', -2) = ""
	 * </pre>
	 *
	 * <p>
	 * Note: this method doesn't not support padding with <a
	 * href="http://www.unicode.org/glossary/#supplementary_character">Unicode
	 * Supplementary Characters</a> as they require a pair of {@code char}s to
	 * be represented. If you are needing to support full I18N of your
	 * applications consider using {@link #repeat(String, int)} instead.
	 * </p>
	 *
	 * @param ch
	 *            character to repeat
	 * @param repeat
	 *            number of times to repeat char, negative treated as zero
	 * @return String with repeated character
	 * @see #repeat(String, int)
	 */
	public static String repeat(final char ch, final int repeat) {
		final char[] buf = new char[repeat];
		for (int i = repeat - 1; i >= 0; i--) {
			buf[i] = ch;
		}
		return new String(buf);
	}

	/**
	 * <p>
	 * Right pad a String with spaces (' ').
	 * </p>
	 *
	 * <p>
	 * The String is padded to the size of {@code size}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.rightPad(null, *) = null
	 * StringUtils.rightPad("", 3) = " "
	 * StringUtils.rightPad("bat", 3) = "bat"
	 * StringUtils.rightPad("bat", 5) = "bat "
	 * StringUtils.rightPad("bat", 1) = "bat"
	 * StringUtils.rightPad("bat", -1) = "bat"
	 * </pre>
	 *
	 * @param str
	 *            the String to pad out, may be null
	 * @param size
	 *            the size to pad to
	 * @return right padded String or original String if no padding is
	 *         necessary, {@code null} if null String input
	 */
	public static String rightPad(final String str, final int size) {
		return rightPad(str, size, ' ');
	}

	public static String rightPad(Number number, int size) {
		return rightPad(MkpkNumberUtils.toString(number), size, ' ');
	}
	
	/**
	 * <p>
	 * Right pad a String with a specified character.
	 * </p>
	 *
	 * <p>
	 * The String is padded to the size of {@code size}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.rightPad(null, *, *) = null
	 * StringUtils.rightPad("", 3, 'z') = "zzz"
	 * StringUtils.rightPad("bat", 3, 'z') = "bat"
	 * StringUtils.rightPad("bat", 5, 'z') = "batzz"
	 * StringUtils.rightPad("bat", 1, 'z') = "bat"
	 * StringUtils.rightPad("bat", -1, 'z') = "bat"
	 * </pre>
	 *
	 * @param str
	 *            the String to pad out, may be null
	 * @param size
	 *            the size to pad to
	 * @param padChar
	 *            the character to pad with
	 * @return right padded String or original String if no padding is
	 *         necessary, {@code null} if null String input
	 * @since 2.0
	 */
	public static String rightPad(final String str, final int size,
			final char padChar) {
		if (str == null) {
			return null;
		}
		final int pads = size - str.length();
		if (pads <= 0) {
			return str; // returns original String when possible
		}
		if (pads > PAD_LIMIT) {
			return rightPad(str, size, String.valueOf(padChar));
		}
		return str.concat(repeat(padChar, pads));
	}

	/**
	 * <p>
	 * Right pad a String with a specified String.
	 * </p>
	 *
	 * <p>
	 * The String is padded to the size of {@code size}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.rightPad(null, *, *) = null
	 * StringUtils.rightPad("", 3, "z") = "zzz"
	 * StringUtils.rightPad("bat", 3, "yz") = "bat"
	 * StringUtils.rightPad("bat", 5, "yz") = "batyz"
	 * StringUtils.rightPad("bat", 8, "yz") = "batyzyzy"
	 * StringUtils.rightPad("bat", 1, "yz") = "bat"
	 * StringUtils.rightPad("bat", -1, "yz") = "bat"
	 * StringUtils.rightPad("bat", 5, null) = "bat "
	 * StringUtils.rightPad("bat", 5, "") = "bat "
	 * </pre>
	 *
	 * @param str
	 *            the String to pad out, may be null
	 * @param size
	 *            the size to pad to
	 * @param padStr
	 *            the String to pad with, null or empty treated as single space
	 * @return right padded String or original String if no padding is
	 *         necessary, {@code null} if null String input
	 */
	public static String rightPad(final String str, final int size,
			String padStr) {
		if (str == null) {
			return null;
		}
		if (isEmpty(padStr)) {
			padStr = SPACE;
		}
		final int padLen = padStr.length();
		final int strLen = str.length();
		final int pads = size - strLen;
		if (pads <= 0) {
			return str; // returns original String when possible
		}
		if (padLen == 1 && pads <= PAD_LIMIT) {
			return rightPad(str, size, padStr.charAt(0));
		}
		if (pads == padLen) {
			return str.concat(padStr);
		} else if (pads < padLen) {
			return str.concat(padStr.substring(0, pads));
		} else {
			final char[] padding = new char[pads];
			final char[] padChars = padStr.toCharArray();
			for (int i = 0; i < pads; i++) {
				padding[i] = padChars[i % padLen];
			}
			return str.concat(new String(padding));
		}
	}

	/**
	 * <p>
	 * Left pad a String with spaces (' ').
	 * </p>
	 *
	 * <p>
	 * The String is padded to the size of {@code size}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.leftPad(null, *) = null
	 * StringUtils.leftPad("", 3) = " "
	 * StringUtils.leftPad("bat", 3) = "bat"
	 * StringUtils.leftPad("bat", 5) = " bat"
	 * StringUtils.leftPad("bat", 1) = "bat"
	 * StringUtils.leftPad("bat", -1) = "bat"
	 * </pre>
	 *
	 * @param str
	 *            the String to pad out, may be null
	 * @param size
	 *            the size to pad to
	 * @return left padded String or original String if no padding is necessary,
	 *         {@code null} if null String input
	 */
	public static String leftPad(final String str, final int size) {
		return leftPad(str, size, ' ');
	}

	/**
	 * <p>
	 * Left pad a String with a specified character.
	 * </p>
	 *
	 * <p>
	 * Pad to a size of {@code size}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.leftPad(null, *, *) = null
	 * StringUtils.leftPad("", 3, 'z') = "zzz"
	 * StringUtils.leftPad("bat", 3, 'z') = "bat"
	 * StringUtils.leftPad("bat", 5, 'z') = "zzbat"
	 * StringUtils.leftPad("bat", 1, 'z') = "bat"
	 * StringUtils.leftPad("bat", -1, 'z') = "bat"
	 * </pre>
	 *
	 * @param str
	 *            the String to pad out, may be null
	 * @param size
	 *            the size to pad to
	 * @param padChar
	 *            the character to pad with
	 * @return left padded String or original String if no padding is necessary,
	 *         {@code null} if null String input
	 * @since 2.0
	 */
	public static String leftPad(final String str, final int size,
			final char padChar) {
		if (str == null) {
			return null;
		}
		final int pads = size - str.length();
		if (pads <= 0) {
			return str; // returns original String when possible
		}
		if (pads > PAD_LIMIT) {
			return leftPad(str, size, String.valueOf(padChar));
		}
		return repeat(padChar, pads).concat(str);
	}

	/**
	 * <p>
	 * Left pad a String with a specified String.
	 * </p>
	 *
	 * <p>
	 * Pad to a size of {@code size}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.leftPad(null, *, *) = null
	 * StringUtils.leftPad("", 3, "z") = "zzz"
	 * StringUtils.leftPad("bat", 3, "yz") = "bat"
	 * StringUtils.leftPad("bat", 5, "yz") = "yzbat"
	 * StringUtils.leftPad("bat", 8, "yz") = "yzyzybat"
	 * StringUtils.leftPad("bat", 1, "yz") = "bat"
	 * StringUtils.leftPad("bat", -1, "yz") = "bat"
	 * StringUtils.leftPad("bat", 5, null) = " bat"
	 * StringUtils.leftPad("bat", 5, "") = " bat"
	 * </pre>
	 *
	 * @param str
	 *            the String to pad out, may be null
	 * @param size
	 *            the size to pad to
	 * @param padStr
	 *            the String to pad with, null or empty treated as single space
	 * @return left padded String or original String if no padding is necessary,
	 *         {@code null} if null String input
	 */
	public static String leftPad(final String str, final int size, String padStr) {
		if (str == null) {
			return null;
		}
		if (isEmpty(padStr)) {
			padStr = SPACE;
		}
		final int padLen = padStr.length();
		final int strLen = str.length();
		final int pads = size - strLen;
		if (pads <= 0) {
			return str; // returns original String when possible
		}
		if (padLen == 1 && pads <= PAD_LIMIT) {
			return leftPad(str, size, padStr.charAt(0));
		}
		if (pads == padLen) {
			return padStr.concat(str);
		} else if (pads < padLen) {
			return padStr.substring(0, pads).concat(str);
		} else {
			final char[] padding = new char[pads];
			final char[] padChars = padStr.toCharArray();
			for (int i = 0; i < pads; i++) {
				padding[i] = padChars[i % padLen];
			}
			return new String(padding).concat(str);
		}
	}

	/**
	 * Gets a CharSequence length or {@code 0} if the CharSequence is
	 * {@code null}.
	 *
	 * @param cs
	 *            a CharSequence or {@code null}
	 * @return CharSequence length or {@code 0} if the CharSequence is
	 *         {@code null}.
	 * @since 2.4
	 * @since 3.0 Changed signature from length(String) to length(CharSequence)
	 */
	public static int length(final CharSequence cs) {
		return cs == null ? 0 : cs.length();
	}

	// Centering
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Centers a String in a larger String of size {@code size} using the space
	 * character (' ').
	 * </p>
	 *
	 * <p>
	 * If the size is less than the String length, the String is returned. A
	 * {@code null} String returns {@code null}. A negative size is treated as
	 * zero.
	 * </p>
	 *
	 * <p>
	 * Equivalent to {@code center(str, size, " ")}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.center(null, *) = null
	 * StringUtils.center("", 4) = " "
	 * StringUtils.center("ab", -1) = "ab"
	 * StringUtils.center("ab", 4) = " ab "
	 * StringUtils.center("abcd", 2) = "abcd"
	 * StringUtils.center("a", 4) = " a "
	 * </pre>
	 *
	 * @param str
	 *            the String to center, may be null
	 * @param size
	 *            the int size of new String, negative treated as zero
	 * @return centered String, {@code null} if null String input
	 */
	public static String center(final String str, final int size) {
		return center(str, size, ' ');
	}

	/**
	 * <p>
	 * Centers a String in a larger String of size {@code size}. Uses a supplied
	 * character as the value to pad the String with.
	 * </p>
	 *
	 * <p>
	 * If the size is less than the String length, the String is returned. A
	 * {@code null} String returns {@code null}. A negative size is treated as
	 * zero.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.center(null, *, *) = null
	 * StringUtils.center("", 4, ' ') = " "
	 * StringUtils.center("ab", -1, ' ') = "ab"
	 * StringUtils.center("ab", 4, ' ') = " ab "
	 * StringUtils.center("abcd", 2, ' ') = "abcd"
	 * StringUtils.center("a", 4, ' ') = " a "
	 * StringUtils.center("a", 4, 'y') = "yayy"
	 * </pre>
	 *
	 * @param str
	 *            the String to center, may be null
	 * @param size
	 *            the int size of new String, negative treated as zero
	 * @param padChar
	 *            the character to pad the new String with
	 * @return centered String, {@code null} if null String input
	 * @since 2.0
	 */
	public static String center(String str, final int size, final char padChar) {
		if (str == null || size <= 0) {
			return str;
		}
		final int strLen = str.length();
		final int pads = size - strLen;
		if (pads <= 0) {
			return str;
		}
		str = leftPad(str, strLen + pads / 2, padChar);
		str = rightPad(str, size, padChar);
		return str;
	}

	/**
	 * <p>
	 * Centers a String in a larger String of size {@code size}. Uses a supplied
	 * String as the value to pad the String with.
	 * </p>
	 *
	 * <p>
	 * If the size is less than the String length, the String is returned. A
	 * {@code null} String returns {@code null}. A negative size is treated as
	 * zero.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.center(null, *, *) = null
	 * StringUtils.center("", 4, " ") = " "
	 * StringUtils.center("ab", -1, " ") = "ab"
	 * StringUtils.center("ab", 4, " ") = " ab "
	 * StringUtils.center("abcd", 2, " ") = "abcd"
	 * StringUtils.center("a", 4, " ") = " a "
	 * StringUtils.center("a", 4, "yz") = "yayz"
	 * StringUtils.center("abc", 7, null) = " abc "
	 * StringUtils.center("abc", 7, "") = " abc "
	 * </pre>
	 *
	 * @param str
	 *            the String to center, may be null
	 * @param size
	 *            the int size of new String, negative treated as zero
	 * @param padStr
	 *            the String to pad the new String with, must not be null or
	 *            empty
	 * @return centered String, {@code null} if null String input
	 * @throws IllegalArgumentException
	 *             if padStr is {@code null} or empty
	 */
	public static String center(String str, final int size, String padStr) {
		if (str == null || size <= 0) {
			return str;
		}
		if (isEmpty(padStr)) {
			padStr = SPACE;
		}
		final int strLen = str.length();
		final int pads = size - strLen;
		if (pads <= 0) {
			return str;
		}
		str = leftPad(str, strLen + pads / 2, padStr);
		str = rightPad(str, size, padStr);
		return str;
	}

	// Case conversion
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts a String to upper case as per {@link String#toUpperCase()}.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.upperCase(null) = null
	 * StringUtils.upperCase("") = ""
	 * StringUtils.upperCase("aBc") = "ABC"
	 * </pre>
	 *
	 * <p>
	 * <strong>Note:</strong> As described in the documentation for
	 * {@link String#toUpperCase()}, the result of this method is affected by
	 * the current locale. For platform-independent case transformations, the
	 * method {@link #lowerCase(String, Locale)} should be used with a specific
	 * locale (e.g. {@link Locale#ENGLISH}).
	 * </p>
	 *
	 * @param str
	 *            the String to upper case, may be null
	 * @return the upper cased String, {@code null} if null String input
	 */
	public static String upperCase(final String str) {
		if (str == null) {
			return null;
		}
		return str.toUpperCase();
	}

	// Count matches
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Counts how many times the substring appears in the larger string.
	 * </p>
	 *
	 * <p>
	 * A {@code null} or empty ("") String input returns {@code 0}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.countMatches(null, *) = 0
	 * StringUtils.countMatches("", *) = 0
	 * StringUtils.countMatches("abba", null) = 0
	 * StringUtils.countMatches("abba", "") = 0
	 * StringUtils.countMatches("abba", "a") = 2
	 * StringUtils.countMatches("abba", "ab") = 1
	 * StringUtils.countMatches("abba", "xxx") = 0
	 * </pre>
	 *
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param sub
	 *            the substring to count, may be null
	 * @return the number of occurrences, 0 if either CharSequence is
	 *         {@code null}
	 * @since 3.0 Changed signature from countMatches(String, String) to
	 *        countMatches(CharSequence, CharSequence)
	 */
	public static int countMatches(final CharSequence str,
			final CharSequence sub) {
		if (isEmpty(str) || isEmpty(sub)) {
			return 0;
		}
		int count = 0;
		int idx = 0;
		while ((idx = MkpkCharSequenceUtils.indexOf(str, sub, idx)) != INDEX_NOT_FOUND) {
			count++;
			idx += sub.length();
		}
		return count;
	}

	/**
	 * <p>
	 * Counts how many times the char appears in the given string.
	 * </p>
	 *
	 * <p>
	 * A {@code null} or empty ("") String input returns {@code 0}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.countMatches(null, *) = 0
	 * StringUtils.countMatches("", *) = 0
	 * StringUtils.countMatches("abba", 0) = 0
	 * StringUtils.countMatches("abba", 'a') = 2
	 * StringUtils.countMatches("abba", 'b') = 2
	 * StringUtils.countMatches("abba", 'x') = 0
	 * </pre>
	 *
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param ch
	 *            the char to count
	 * @return the number of occurrences, 0 if the CharSequence is {@code null}
	 * @since 3.4
	 */
	public static int countMatches(final CharSequence str, final char ch) {
		if (isEmpty(str)) {
			return 0;
		}
		int count = 0;
		// We could also call str.toCharArray() for faster look ups but that
		// would generate more garbage.
		for (int i = 0; i < str.length(); i++) {
			if (ch == str.charAt(i)) {
				count++;
			}
		}
		return count;
	}

	// Character Tests
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks if the CharSequence contains only Unicode letters.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence
	 * (length()=0) will return {@code false}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isAlpha(null) = false
	 * StringUtils.isAlpha("") = false
	 * StringUtils.isAlpha(" ") = false
	 * StringUtils.isAlpha("abc") = true
	 * StringUtils.isAlpha("ab2c") = false
	 * StringUtils.isAlpha("ab-c") = false
	 * </pre>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if only contains letters, and is non-null
	 * @since 3.0 Changed signature from isAlpha(String) to
	 *        isAlpha(CharSequence)
	 * @since 3.0 Changed "" to return false and not true
	 */
	public static boolean isAlpha(final CharSequence cs) {
		if (isEmpty(cs)) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (Character.isLetter(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only Unicode letters and space (' ').
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false} An empty CharSequence (length()=0)
	 * will return {@code true}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isAlphaSpace(null) = false
	 * StringUtils.isAlphaSpace("") = true
	 * StringUtils.isAlphaSpace(" ") = true
	 * StringUtils.isAlphaSpace("abc") = true
	 * StringUtils.isAlphaSpace("ab c") = true
	 * StringUtils.isAlphaSpace("ab2c") = false
	 * StringUtils.isAlphaSpace("ab-c") = false
	 * </pre>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if only contains letters and space, and is non-null
	 * @since 3.0 Changed signature from isAlphaSpace(String) to
	 *        isAlphaSpace(CharSequence)
	 */
	public static boolean isAlphaSpace(final CharSequence cs) {
		if (cs == null) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (Character.isLetter(cs.charAt(i)) == false
					&& cs.charAt(i) != ' ') {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only Unicode letters or digits.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence
	 * (length()=0) will return {@code false}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isAlphanumeric(null) = false
	 * StringUtils.isAlphanumeric("") = false
	 * StringUtils.isAlphanumeric(" ") = false
	 * StringUtils.isAlphanumeric("abc") = true
	 * StringUtils.isAlphanumeric("ab c") = false
	 * StringUtils.isAlphanumeric("ab2c") = true
	 * StringUtils.isAlphanumeric("ab-c") = false
	 * </pre>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if only contains letters or digits, and is non-null
	 * @since 3.0 Changed signature from isAlphanumeric(String) to
	 *        isAlphanumeric(CharSequence)
	 * @since 3.0 Changed "" to return false and not true
	 */
	public static boolean isAlphanumeric(final CharSequence cs) {
		if (isEmpty(cs)) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (Character.isLetterOrDigit(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only Unicode letters, digits or space
	 * ({@code ' '}).
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence
	 * (length()=0) will return {@code true}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isAlphanumericSpace(null) = false
	 * StringUtils.isAlphanumericSpace("") = true
	 * StringUtils.isAlphanumericSpace(" ") = true
	 * StringUtils.isAlphanumericSpace("abc") = true
	 * StringUtils.isAlphanumericSpace("ab c") = true
	 * StringUtils.isAlphanumericSpace("ab2c") = true
	 * StringUtils.isAlphanumericSpace("ab-c") = false
	 * </pre>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if only contains letters, digits or space, and is
	 *         non-null
	 * @since 3.0 Changed signature from isAlphanumericSpace(String) to
	 *        isAlphanumericSpace(CharSequence)
	 */
	public static boolean isAlphanumericSpace(final CharSequence cs) {
		if (cs == null) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (Character.isLetterOrDigit(cs.charAt(i)) == false
					&& cs.charAt(i) != ' ') {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only ASCII printable characters.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence
	 * (length()=0) will return {@code true}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isAsciiPrintable(null) = false
	 * StringUtils.isAsciiPrintable("") = true
	 * StringUtils.isAsciiPrintable(" ") = true
	 * StringUtils.isAsciiPrintable("Ceki") = true
	 * StringUtils.isAsciiPrintable("ab2c") = true
	 * StringUtils.isAsciiPrintable("!ab-c~") = true
	 * StringUtils.isAsciiPrintable("\u0020") = true
	 * StringUtils.isAsciiPrintable("\u0021") = true
	 * StringUtils.isAsciiPrintable("\u007e") = true
	 * StringUtils.isAsciiPrintable("\u007f") = false
	 * StringUtils.isAsciiPrintable("Ceki G\u00fclc\u00fc") = false
	 * </pre>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if every character is in the range 32 thru 126
	 * @since 2.1
	 * @since 3.0 Changed signature from isAsciiPrintable(String) to
	 *        isAsciiPrintable(CharSequence)
	 */
	public static boolean isAsciiPrintable(final CharSequence cs) {
		if (cs == null) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (MkpkCharUtils.isAsciiPrintable(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only Unicode digits. A decimal point
	 * is not a Unicode digit and returns false.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence
	 * (length()=0) will return {@code false}.
	 * </p>
	 *
	 * <p>
	 * Note that the method does not allow for a leading sign, either positive
	 * or negative. Also, if a String passes the numeric test, it may still
	 * generate a NumberFormatException when parsed by Integer.parseInt or
	 * Long.parseLong, e.g. if the value is outside the range for int or long
	 * respectively.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isNumeric(null) = false
	 * StringUtils.isNumeric("") = false
	 * StringUtils.isNumeric(" ") = false
	 * StringUtils.isNumeric("123") = true
	 * StringUtils.isNumeric("\u0967\u0968\u0969") = true
	 * StringUtils.isNumeric("12 3") = false
	 * StringUtils.isNumeric("ab2c") = false
	 * StringUtils.isNumeric("12-3") = false
	 * StringUtils.isNumeric("12.3") = false
	 * StringUtils.isNumeric("-123") = false
	 * StringUtils.isNumeric("+123") = false
	 * </pre>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if only contains digits, and is non-null
	 * @since 3.0 Changed signature from isNumeric(String) to
	 *        isNumeric(CharSequence)
	 * @since 3.0 Changed "" to return false and not true
	 */
	public static boolean isNumeric(final CharSequence cs) {
		if (isEmpty(cs)) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (Character.isDigit(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only Unicode digits or space (
	 * {@code ' '}). A decimal point is not a Unicode digit and returns false.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence
	 * (length()=0) will return {@code true}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isNumericSpace(null) = false
	 * StringUtils.isNumericSpace("") = true
	 * StringUtils.isNumericSpace(" ") = true
	 * StringUtils.isNumericSpace("123") = true
	 * StringUtils.isNumericSpace("12 3") = true
	 * StringUtils.isNumeric("\u0967\u0968\u0969") = true
	 * StringUtils.isNumeric("\u0967\u0968 \u0969") = true
	 * StringUtils.isNumericSpace("ab2c") = false
	 * StringUtils.isNumericSpace("12-3") = false
	 * StringUtils.isNumericSpace("12.3") = false
	 * </pre>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if only contains digits or space, and is non-null
	 * @since 3.0 Changed signature from isNumericSpace(String) to
	 *        isNumericSpace(CharSequence)
	 */
	public static boolean isNumericSpace(final CharSequence cs) {
		if (cs == null) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (Character.isDigit(cs.charAt(i)) == false && cs.charAt(i) != ' ') {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only lowercase characters.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence
	 * (length()=0) will return {@code false}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isAllLowerCase(null) = false
	 * StringUtils.isAllLowerCase("") = false
	 * StringUtils.isAllLowerCase(" ") = false
	 * StringUtils.isAllLowerCase("abc") = true
	 * StringUtils.isAllLowerCase("abC") = false
	 * </pre>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if only contains lowercase characters, and is
	 *         non-null
	 * @since 2.5
	 * @since 3.0 Changed signature from isAllLowerCase(String) to
	 *        isAllLowerCase(CharSequence)
	 */
	public static boolean isAllLowerCase(final CharSequence cs) {
		if (cs == null || isEmpty(cs)) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (Character.isLowerCase(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only uppercase characters.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty String (length()=0) will
	 * return {@code false}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isAllUpperCase(null) = false
	 * StringUtils.isAllUpperCase("") = false
	 * StringUtils.isAllUpperCase(" ") = false
	 * StringUtils.isAllUpperCase("ABC") = true
	 * StringUtils.isAllUpperCase("aBC") = false
	 * </pre>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if only contains uppercase characters, and is
	 *         non-null
	 * @since 2.5
	 * @since 3.0 Changed signature from isAllUpperCase(String) to
	 *        isAllUpperCase(CharSequence)
	 */
	public static boolean isAllUpperCase(final CharSequence cs) {
		if (cs == null || isEmpty(cs)) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (Character.isUpperCase(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	// Defaults
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Returns either the passed in String, or if the String is {@code null}, an
	 * empty String ("").
	 * </p>
	 *
	 * <pre>
	 * StringUtils.defaultString(null) = ""
	 * StringUtils.defaultString("") = ""
	 * StringUtils.defaultString("bat") = "bat"
	 * </pre>
	 *
	 * @see MkpkObjectUtils#toString(Object)
	 * @see String#valueOf(Object)
	 * @param str
	 *            the String to check, may be null
	 * @return the passed in String, or the empty String if it was {@code null}
	 */
	public static String defaultString(final String str) {
		return str == null ? EMPTY : str;
	}

	/**
	 * <p>
	 * Returns either the passed in String, or if the String is {@code null},
	 * the value of {@code defaultStr}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.defaultString(null, "NULL") = "NULL"
	 * StringUtils.defaultString("", "NULL") = ""
	 * StringUtils.defaultString("bat", "NULL") = "bat"
	 * </pre>
	 *
	 * @see MkpkObjectUtils#toString(Object,String)
	 * @see String#valueOf(Object)
	 * @param str
	 *            the String to check, may be null
	 * @param defaultStr
	 *            the default String to return if the input is {@code null}, may
	 *            be null
	 * @return the passed in String, or the default if it was {@code null}
	 */
	public static String defaultString(final String str, final String defaultStr) {
		return str == null ? defaultStr : str;
	}

	/**
	 * <p>
	 * Returns either the passed in CharSequence, or if the CharSequence is
	 * whitespace, empty ("") or {@code null}, the value of {@code defaultStr}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.defaultIfBlank(null, "NULL") = "NULL"
	 * StringUtils.defaultIfBlank("", "NULL") = "NULL"
	 * StringUtils.defaultIfBlank(" ", "NULL") = "NULL"
	 * StringUtils.defaultIfBlank("bat", "NULL") = "bat"
	 * StringUtils.defaultIfBlank("", null) = null
	 * </pre>
	 * 
	 * @param <T>
	 *            the specific kind of CharSequence
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param defaultStr
	 *            the default CharSequence to return if the input is whitespace,
	 *            empty ("") or {@code null}, may be null
	 * @return the passed in CharSequence, or the default
	 * @see StringUtils#defaultString(String, String)
	 */
	public static String defaultIfBlank(String str, String defaultStr) {
		return isBlank(str) ? defaultStr : str;
	}

	/**
	 * <p>
	 * Returns either the passed in CharSequence, or if the CharSequence is
	 * empty or {@code null}, the value of {@code defaultStr}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.defaultIfEmpty(null, "NULL") = "NULL"
	 * StringUtils.defaultIfEmpty("", "NULL") = "NULL"
	 * StringUtils.defaultIfEmpty(" ", "NULL") = " "
	 * StringUtils.defaultIfEmpty("bat", "NULL") = "bat"
	 * StringUtils.defaultIfEmpty("", null) = null
	 * </pre>
	 * 
	 * @param <T>
	 *            the specific kind of CharSequence
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param defaultStr
	 *            the default CharSequence to return if the input is empty ("")
	 *            or {@code null}, may be null
	 * @return the passed in CharSequence, or the default
	 * @see StringUtils#defaultString(String, String)
	 */
	public static <T extends CharSequence> T defaultIfEmpty(final T str,
			final T defaultStr) {
		return isEmpty(str) ? defaultStr : str;
	}

	// Reversing
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Reverses a String as per {@link StringBuilder#reverse()}.
	 * </p>
	 *
	 * <p>
	 * A {@code null} String returns {@code null}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.reverse(null) = null
	 * StringUtils.reverse("") = ""
	 * StringUtils.reverse("bat") = "tab"
	 * </pre>
	 *
	 * @param str
	 *            the String to reverse, may be null
	 * @return the reversed String, {@code null} if null String input
	 */
	public static String reverse(final String str) {
		if (str == null) {
			return null;
		}
		return new StringBuilder(str).reverse().toString();
	}

	/**
	 * <p>
	 * Reverses a String that is delimited by a specific character.
	 * </p>
	 *
	 * <p>
	 * The Strings between the delimiters are not reversed. Thus
	 * java.lang.String becomes String.lang.java (if the delimiter is
	 * {@code '.'}).
	 * </p>
	 *
	 * <pre>
	 * StringUtils.reverseDelimited(null, *) = null
	 * StringUtils.reverseDelimited("", *) = ""
	 * StringUtils.reverseDelimited("a.b.c", 'x') = "a.b.c"
	 * StringUtils.reverseDelimited("a.b.c", ".") = "c.b.a"
	 * </pre>
	 *
	 * @param str
	 *            the String to reverse, may be null
	 * @param separatorChar
	 *            the separator character to use
	 * @return the reversed String, {@code null} if null String input
	 * @since 2.0
	 */
	public static String reverseDelimited(final String str,
			final char separatorChar) {
		if (str == null) {
			return null;
		}
		// could implement manually, but simple way is to reuse other,
		// probably slower, methods.
		final String[] strs = split(str, separatorChar);
		MkpkArrayUtils.reverse(strs);
		return join(strs, separatorChar);
	}

	// Abbreviating
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Abbreviates a String using ellipses. This will turn
	 * "Now is the time for all good men" into "Now is the time for..."
	 * </p>
	 *
	 * <p>
	 * Specifically:
	 * </p>
	 * <ul>
	 * <li>If {@code str} is less than {@code maxWidth} characters long, return
	 * it.</li>
	 * <li>Else abbreviate it to {@code (substring(str, 0, max-3) + "...")}.</li>
	 * <li>If {@code maxWidth} is less than {@code 4}, throw an
	 * {@code IllegalArgumentException}.</li>
	 * <li>In no case will it return a String of length greater than
	 * {@code maxWidth}.</li>
	 * </ul>
	 *
	 * <pre>
	 * StringUtils.abbreviate(null, *) = null
	 * StringUtils.abbreviate("", 4) = ""
	 * StringUtils.abbreviate("abcdefg", 6) = "abc..."
	 * StringUtils.abbreviate("abcdefg", 7) = "abcdefg"
	 * StringUtils.abbreviate("abcdefg", 8) = "abcdefg"
	 * StringUtils.abbreviate("abcdefg", 4) = "a..."
	 * StringUtils.abbreviate("abcdefg", 3) = IllegalArgumentException
	 * </pre>
	 *
	 * @param str
	 *            the String to check, may be null
	 * @param maxWidth
	 *            maximum length of result String, must be at least 4
	 * @return abbreviated String, {@code null} if null String input
	 * @throws IllegalArgumentException
	 *             if the width is too small
	 * @since 2.0
	 */
	public static String abbreviate(final String str, final int maxWidth) {
		return abbreviate(str, 0, maxWidth);
	}

	/**
	 * <p>
	 * Abbreviates a String using ellipses. This will turn
	 * "Now is the time for all good men" into "...is the time for..."
	 * </p>
	 *
	 * <p>
	 * Works like {@code abbreviate(String, int)}, but allows you to specify a
	 * "left edge" offset. Note that this left edge is not necessarily going to
	 * be the leftmost character in the result, or the first character following
	 * the ellipses, but it will appear somewhere in the result.
	 *
	 * <p>
	 * In no case will it return a String of length greater than
	 * {@code maxWidth}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.abbreviate(null, *, *) = null
	 * StringUtils.abbreviate("", 0, 4) = ""
	 * StringUtils.abbreviate("abcdefghijklmno", -1, 10) = "abcdefg..."
	 * StringUtils.abbreviate("abcdefghijklmno", 0, 10) = "abcdefg..."
	 * StringUtils.abbreviate("abcdefghijklmno", 1, 10) = "abcdefg..."
	 * StringUtils.abbreviate("abcdefghijklmno", 4, 10) = "abcdefg..."
	 * StringUtils.abbreviate("abcdefghijklmno", 5, 10) = "...fghi..."
	 * StringUtils.abbreviate("abcdefghijklmno", 6, 10) = "...ghij..."
	 * StringUtils.abbreviate("abcdefghijklmno", 8, 10) = "...ijklmno"
	 * StringUtils.abbreviate("abcdefghijklmno", 10, 10) = "...ijklmno"
	 * StringUtils.abbreviate("abcdefghijklmno", 12, 10) = "...ijklmno"
	 * StringUtils.abbreviate("abcdefghij", 0, 3) = IllegalArgumentException
	 * StringUtils.abbreviate("abcdefghij", 5, 6) = IllegalArgumentException
	 * </pre>
	 *
	 * @param str
	 *            the String to check, may be null
	 * @param offset
	 *            left edge of source String
	 * @param maxWidth
	 *            maximum length of result String, must be at least 4
	 * @return abbreviated String, {@code null} if null String input
	 * @throws IllegalArgumentException
	 *             if the width is too small
	 * @since 2.0
	 */
	public static String abbreviate(final String str, int offset,
			final int maxWidth) {
		if (str == null) {
			return null;
		}
		if (maxWidth < 4) {
			throw new IllegalArgumentException(
					"Minimum abbreviation width is 4");
		}
		if (str.length() <= maxWidth) {
			return str;
		}
		if (offset > str.length()) {
			offset = str.length();
		}
		if (str.length() - offset < maxWidth - 3) {
			offset = str.length() - (maxWidth - 3);
		}
		final String abrevMarker = "...";
		if (offset <= 4) {
			return str.substring(0, maxWidth - 3) + abrevMarker;
		}
		if (maxWidth < 7) {
			throw new IllegalArgumentException(
					"Minimum abbreviation width with offset is 7");
		}
		if (offset + maxWidth - 3 < str.length()) {
			return abrevMarker
					+ abbreviate(str.substring(offset), maxWidth - 3);
		}
		return abrevMarker + str.substring(str.length() - (maxWidth - 3));
	}

	/**
	 * <p>
	 * Abbreviates a String to the length passed, replacing the middle
	 * characters with the supplied replacement String.
	 * </p>
	 *
	 * <p>
	 * This abbreviation only occurs if the following criteria is met:
	 * </p>
	 * <ul>
	 * <li>Neither the String for abbreviation nor the replacement String are
	 * null or empty</li>
	 * <li>The length to truncate to is less than the length of the supplied
	 * String</li>
	 * <li>The length to truncate to is greater than 0</li>
	 * <li>The abbreviated String will have enough room for the length supplied
	 * replacement String and the first and last characters of the supplied
	 * String for abbreviation</li>
	 * </ul>
	 * <p>
	 * Otherwise, the returned String will be the same as the supplied String
	 * for abbreviation.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.abbreviateMiddle(null, null, 0) = null
	 * StringUtils.abbreviateMiddle("abc", null, 0) = "abc"
	 * StringUtils.abbreviateMiddle("abc", ".", 0) = "abc"
	 * StringUtils.abbreviateMiddle("abc", ".", 3) = "abc"
	 * StringUtils.abbreviateMiddle("abcdef", ".", 4) = "ab.f"
	 * </pre>
	 *
	 * @param str
	 *            the String to abbreviate, may be null
	 * @param middle
	 *            the String to replace the middle characters with, may be null
	 * @param length
	 *            the length to abbreviate {@code str} to.
	 * @return the abbreviated String if the above criteria is met, or the
	 *         original String supplied for abbreviation.
	 * @since 2.5
	 */
	public static String abbreviateMiddle(final String str,
			final String middle, final int length) {
		if (isEmpty(str) || isEmpty(middle)) {
			return str;
		}
		if (length >= str.length() || length < middle.length() + 2) {
			return str;
		}
		final int targetSting = length - middle.length();
		final int startOffset = targetSting / 2 + targetSting % 2;
		final int endOffset = str.length() - targetSting / 2;
		final StringBuilder builder = new StringBuilder(length);
		builder.append(str.substring(0, startOffset));
		builder.append(middle);
		builder.append(str.substring(endOffset));
		return builder.toString();
	}

	// Difference
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Compares two Strings, and returns the portion where they differ. More
	 * precisely, return the remainder of the second String, starting from where
	 * it's different from the first. This means that the difference between
	 * "abc" and "ab" is the empty String and not "c".
	 * </p>
	 *
	 * <p>
	 * For example,
	 * {@code difference("i am a machine", "i am a robot") -> "robot"}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.difference(null, null) = null
	 * StringUtils.difference("", "") = ""
	 * StringUtils.difference("", "abc") = "abc"
	 * StringUtils.difference("abc", "") = ""
	 * StringUtils.difference("abc", "abc") = ""
	 * StringUtils.difference("abc", "ab") = ""
	 * StringUtils.difference("ab", "abxyz") = "xyz"
	 * StringUtils.difference("abcde", "abxyz") = "xyz"
	 * StringUtils.difference("abcde", "xyz") = "xyz"
	 * </pre>
	 *
	 * @param str1
	 *            the first String, may be null
	 * @param str2
	 *            the second String, may be null
	 * @return the portion of str2 where it differs from str1; returns the empty
	 *         String if they are equal
	 * @see #indexOfDifference(CharSequence,CharSequence)
	 * @since 2.0
	 */
	public static String difference(final String str1, final String str2) {
		if (str1 == null) {
			return str2;
		}
		if (str2 == null) {
			return str1;
		}
		final int at = indexOfDifference(str1, str2);
		if (at == INDEX_NOT_FOUND) {
			return EMPTY;
		}
		return str2.substring(at);
	}

	/**
	 * <p>
	 * Compares two CharSequences, and returns the index at which the
	 * CharSequences begin to differ.
	 * </p>
	 *
	 * <p>
	 * For example,
	 * {@code indexOfDifference("i am a machine", "i am a robot") -> 7}
	 * </p>
	 *
	 * <pre>
	 * StringUtils.indexOfDifference(null, null) = -1
	 * StringUtils.indexOfDifference("", "") = -1
	 * StringUtils.indexOfDifference("", "abc") = 0
	 * StringUtils.indexOfDifference("abc", "") = 0
	 * StringUtils.indexOfDifference("abc", "abc") = -1
	 * StringUtils.indexOfDifference("ab", "abxyz") = 2
	 * StringUtils.indexOfDifference("abcde", "abxyz") = 2
	 * StringUtils.indexOfDifference("abcde", "xyz") = 0
	 * </pre>
	 *
	 * @param cs1
	 *            the first CharSequence, may be null
	 * @param cs2
	 *            the second CharSequence, may be null
	 * @return the index where cs1 and cs2 begin to differ; -1 if they are equal
	 * @since 2.0
	 * @since 3.0 Changed signature from indexOfDifference(String, String) to
	 *        indexOfDifference(CharSequence, CharSequence)
	 */
	public static int indexOfDifference(final CharSequence cs1,
			final CharSequence cs2) {
		if (cs1 == cs2) {
			return INDEX_NOT_FOUND;
		}
		if (cs1 == null || cs2 == null) {
			return 0;
		}
		int i;
		for (i = 0; i < cs1.length() && i < cs2.length(); ++i) {
			if (cs1.charAt(i) != cs2.charAt(i)) {
				break;
			}
		}
		if (i < cs2.length() || i < cs1.length()) {
			return i;
		}
		return INDEX_NOT_FOUND;
	}

	/**
	 * <p>
	 * Compares all CharSequences in an array and returns the index at which the
	 * CharSequences begin to differ.
	 * </p>
	 *
	 * <p>
	 * For example,
	 * <code>indexOfDifference(new String[] {"i am a machine", "i am a robot"}) -&gt; 7</code>
	 * </p>
	 *
	 * <pre>
	 * StringUtils.indexOfDifference(null) = -1
	 * StringUtils.indexOfDifference(new String[] {}) = -1
	 * StringUtils.indexOfDifference(new String[] {"abc"}) = -1
	 * StringUtils.indexOfDifference(new String[] {null, null}) = -1
	 * StringUtils.indexOfDifference(new String[] {"", ""}) = -1
	 * StringUtils.indexOfDifference(new String[] {"", null}) = 0
	 * StringUtils.indexOfDifference(new String[] {"abc", null, null}) = 0
	 * StringUtils.indexOfDifference(new String[] {null, null, "abc"}) = 0
	 * StringUtils.indexOfDifference(new String[] {"", "abc"}) = 0
	 * StringUtils.indexOfDifference(new String[] {"abc", ""}) = 0
	 * StringUtils.indexOfDifference(new String[] {"abc", "abc"}) = -1
	 * StringUtils.indexOfDifference(new String[] {"abc", "a"}) = 1
	 * StringUtils.indexOfDifference(new String[] {"ab", "abxyz"}) = 2
	 * StringUtils.indexOfDifference(new String[] {"abcde", "abxyz"}) = 2
	 * StringUtils.indexOfDifference(new String[] {"abcde", "xyz"}) = 0
	 * StringUtils.indexOfDifference(new String[] {"xyz", "abcde"}) = 0
	 * StringUtils.indexOfDifference(new String[] {"i am a machine", "i am a robot"}) = 7
	 * </pre>
	 *
	 * @param css
	 *            array of CharSequences, entries may be null
	 * @return the index where the strings begin to differ; -1 if they are all
	 *         equal
	 * @since 2.4
	 * @since 3.0 Changed signature from indexOfDifference(String...) to
	 *        indexOfDifference(CharSequence...)
	 */
	public static int indexOfDifference(final CharSequence... css) {
		if (css == null || css.length <= 1) {
			return INDEX_NOT_FOUND;
		}
		boolean anyStringNull = false;
		boolean allStringsNull = true;
		final int arrayLen = css.length;
		int shortestStrLen = Integer.MAX_VALUE;
		int longestStrLen = 0;
		// find the min and max string lengths; this avoids checking to make
		// sure we are not exceeding the length of the string each time through
		// the bottom loop.
		for (int i = 0; i < arrayLen; i++) {
			if (css[i] == null) {
				anyStringNull = true;
				shortestStrLen = 0;
			} else {
				allStringsNull = false;
				shortestStrLen = Math.min(css[i].length(), shortestStrLen);
				longestStrLen = Math.max(css[i].length(), longestStrLen);
			}
		}
		// handle lists containing all nulls or all empty strings
		if (allStringsNull || longestStrLen == 0 && !anyStringNull) {
			return INDEX_NOT_FOUND;
		}
		// handle lists containing some nulls or some empty strings
		if (shortestStrLen == 0) {
			return 0;
		}
		// find the position with the first difference across all strings
		int firstDiff = -1;
		for (int stringPos = 0; stringPos < shortestStrLen; stringPos++) {
			final char comparisonChar = css[0].charAt(stringPos);
			for (int arrayPos = 1; arrayPos < arrayLen; arrayPos++) {
				if (css[arrayPos].charAt(stringPos) != comparisonChar) {
					firstDiff = stringPos;
					break;
				}
			}
			if (firstDiff != -1) {
				break;
			}
		}
		if (firstDiff == -1 && shortestStrLen != longestStrLen) {
			// we compared all of the characters up to the length of the
			// shortest string and didn't find a match, but the string lengths
			// vary, so return the length of the shortest string.
			return shortestStrLen;
		}
		return firstDiff;
	}

	/**
	 * <p>
	 * Compares all Strings in an array and returns the initial sequence of
	 * characters that is common to all of them.
	 * </p>
	 *
	 * <p>
	 * For example,
	 * <code>getCommonPrefix(new String[] {"i am a machine", "i am a robot"}) -&gt; "i am a "</code>
	 * </p>
	 *
	 * <pre>
	 * StringUtils.getCommonPrefix(null) = ""
	 * StringUtils.getCommonPrefix(new String[] {}) = ""
	 * StringUtils.getCommonPrefix(new String[] {"abc"}) = "abc"
	 * StringUtils.getCommonPrefix(new String[] {null, null}) = ""
	 * StringUtils.getCommonPrefix(new String[] {"", ""}) = ""
	 * StringUtils.getCommonPrefix(new String[] {"", null}) = ""
	 * StringUtils.getCommonPrefix(new String[] {"abc", null, null}) = ""
	 * StringUtils.getCommonPrefix(new String[] {null, null, "abc"}) = ""
	 * StringUtils.getCommonPrefix(new String[] {"", "abc"}) = ""
	 * StringUtils.getCommonPrefix(new String[] {"abc", ""}) = ""
	 * StringUtils.getCommonPrefix(new String[] {"abc", "abc"}) = "abc"
	 * StringUtils.getCommonPrefix(new String[] {"abc", "a"}) = "a"
	 * StringUtils.getCommonPrefix(new String[] {"ab", "abxyz"}) = "ab"
	 * StringUtils.getCommonPrefix(new String[] {"abcde", "abxyz"}) = "ab"
	 * StringUtils.getCommonPrefix(new String[] {"abcde", "xyz"}) = ""
	 * StringUtils.getCommonPrefix(new String[] {"xyz", "abcde"}) = ""
	 * StringUtils.getCommonPrefix(new String[] {"i am a machine", "i am a robot"}) = "i am a "
	 * </pre>
	 *
	 * @param strs
	 *            array of String objects, entries may be null
	 * @return the initial sequence of characters that are common to all Strings
	 *         in the array; empty String if the array is null, the elements are
	 *         all null or if there is no common prefix.
	 * @since 2.4
	 */
	public static String getCommonPrefix(final String... strs) {
		if (strs == null || strs.length == 0) {
			return EMPTY;
		}
		final int smallestIndexOfDiff = indexOfDifference(strs);
		if (smallestIndexOfDiff == INDEX_NOT_FOUND) {
			// all strings were identical
			if (strs[0] == null) {
				return EMPTY;
			}
			return strs[0];
		} else if (smallestIndexOfDiff == 0) {
			// there were no common initial characters
			return EMPTY;
		} else {
			// we found a common initial character sequence
			return strs[0].substring(0, smallestIndexOfDiff);
		}
	}

	// Misc
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Find the Levenshtein distance between two Strings.
	 * </p>
	 *
	 * <p>
	 * This is the number of changes needed to change one String into another,
	 * where each change is a single character modification (deletion, insertion
	 * or substitution).
	 * </p>
	 *
	 * <p>
	 * The previous implementation of the Levenshtein distance algorithm was
	 * from <a
	 * href="http://www.merriampark.com/ld.htm">http://www.merriampark.com
	 * /ld.htm</a>
	 * </p>
	 *
	 * <p>
	 * Chas Emerick has written an implementation in Java, which avoids an
	 * OutOfMemoryError which can occur when my Java implementation is used with
	 * very large strings.<br>
	 * This implementation of the Levenshtein distance algorithm is from <a
	 * href="http://www.merriampark.com/ldjava.htm">http://www.merriampark.com/
	 * ldjava.htm</a>
	 * </p>
	 *
	 * <pre>
	 * StringUtils.getLevenshteinDistance(null, *) = IllegalArgumentException
	 * StringUtils.getLevenshteinDistance(*, null) = IllegalArgumentException
	 * StringUtils.getLevenshteinDistance("","") = 0
	 * StringUtils.getLevenshteinDistance("","a") = 1
	 * StringUtils.getLevenshteinDistance("aaapppp", "") = 7
	 * StringUtils.getLevenshteinDistance("frog", "fog") = 1
	 * StringUtils.getLevenshteinDistance("fly", "ant") = 3
	 * StringUtils.getLevenshteinDistance("elephant", "hippo") = 7
	 * StringUtils.getLevenshteinDistance("hippo", "elephant") = 7
	 * StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz") = 8
	 * StringUtils.getLevenshteinDistance("hello", "hallo") = 1
	 * </pre>
	 *
	 * @param s
	 *            the first String, must not be null
	 * @param t
	 *            the second String, must not be null
	 * @return result distance
	 * @throws IllegalArgumentException
	 *             if either String input {@code null}
	 * @since 3.0 Changed signature from getLevenshteinDistance(String, String)
	 *        to getLevenshteinDistance(CharSequence, CharSequence)
	 */
	public static int getLevenshteinDistance(CharSequence s, CharSequence t) {
		if (s == null || t == null) {
			throw new IllegalArgumentException("Strings must not be null");
		}
		/*
		 * The difference between this impl. and the previous is that, rather
		 * than creating and retaining a matrix of size s.length() + 1 by
		 * t.length() + 1, we maintain two single-dimensional arrays of length
		 * s.length() + 1. The first, d, is the 'current working' distance array
		 * that maintains the newest distance cost counts as we iterate through
		 * the characters of String s. Each time we increment the index of
		 * String t we are comparing, d is copied to p, the second int[]. Doing
		 * so allows us to retain the previous cost counts as required by the
		 * algorithm (taking the minimum of the cost count to the left, up one,
		 * and diagonally up and to the left of the current cost count being
		 * calculated). (Note that the arrays aren't really copied anymore, just
		 * switched...this is clearly much better than cloning an array or doing
		 * a System.arraycopy() each time through the outer loop.) Effectively,
		 * the difference between the two implementations is this one does not
		 * cause an out of memory condition when calculating the LD over two
		 * very large strings.
		 */
		int n = s.length(); // length of s
		int m = t.length(); // length of t
		if (n == 0) {
			return m;
		} else if (m == 0) {
			return n;
		}
		if (n > m) {
			// swap the input strings to consume less memory
			final CharSequence tmp = s;
			s = t;
			t = tmp;
			n = m;
			m = t.length();
		}
		int p[] = new int[n + 1]; // 'previous' cost array, horizontally
		int d[] = new int[n + 1]; // cost array, horizontally
		int _d[]; // placeholder to assist in swapping p and d
		// indexes into strings s and t
		int i; // iterates through s
		int j; // iterates through t
		char t_j; // jth character of t
		int cost; // cost
		for (i = 0; i <= n; i++) {
			p[i] = i;
		}
		for (j = 1; j <= m; j++) {
			t_j = t.charAt(j - 1);
			d[0] = j;
			for (i = 1; i <= n; i++) {
				cost = s.charAt(i - 1) == t_j ? 0 : 1;
				// minimum of cell to the left+1, to the top+1, diagonally left
				// and up +cost
				d[i] = Math.min(Math.min(d[i - 1] + 1, p[i] + 1), p[i - 1]
						+ cost);
			}
			// copy current distance counts to 'previous row' distance counts
			_d = p;
			p = d;
			d = _d;
		}
		// our last action in the above loop was to switch d and p, so p now
		// actually has the most recent cost counts
		return p[n];
	}

	/**
	 * <p>
	 * Find the Levenshtein distance between two Strings if it's less than or
	 * equal to a given threshold.
	 * </p>
	 *
	 * <p>
	 * This is the number of changes needed to change one String into another,
	 * where each change is a single character modification (deletion, insertion
	 * or substitution).
	 * </p>
	 *
	 * <p>
	 * This implementation follows from Algorithms on Strings, Trees and
	 * Sequences by Dan Gusfield and Chas Emerick's implementation of the
	 * Levenshtein distance algorithm from <a
	 * href="http://www.merriampark.com/ld.htm"
	 * >http://www.merriampark.com/ld.htm</a>
	 * </p>
	 *
	 * <pre>
	 * StringUtils.getLevenshteinDistance(null, *, *) = IllegalArgumentException
	 * StringUtils.getLevenshteinDistance(*, null, *) = IllegalArgumentException
	 * StringUtils.getLevenshteinDistance(*, *, -1) = IllegalArgumentException
	 * StringUtils.getLevenshteinDistance("","", 0) = 0
	 * StringUtils.getLevenshteinDistance("aaapppp", "", 8) = 7
	 * StringUtils.getLevenshteinDistance("aaapppp", "", 7) = 7
	 * StringUtils.getLevenshteinDistance("aaapppp", "", 6)) = -1
	 * StringUtils.getLevenshteinDistance("elephant", "hippo", 7) = 7
	 * StringUtils.getLevenshteinDistance("elephant", "hippo", 6) = -1
	 * StringUtils.getLevenshteinDistance("hippo", "elephant", 7) = 7
	 * StringUtils.getLevenshteinDistance("hippo", "elephant", 6) = -1
	 * </pre>
	 *
	 * @param s
	 *            the first String, must not be null
	 * @param t
	 *            the second String, must not be null
	 * @param threshold
	 *            the target threshold, must not be negative
	 * @return result distance, or {@code -1} if the distance would be greater
	 *         than the threshold
	 * @throws IllegalArgumentException
	 *             if either String input {@code null} or negative threshold
	 */
	public static int getLevenshteinDistance(CharSequence s, CharSequence t,
			final int threshold) {
		if (s == null || t == null) {
			throw new IllegalArgumentException("Strings must not be null");
		}
		if (threshold < 0) {
			throw new IllegalArgumentException("Threshold must not be negative");
		}
		/*
		 * This implementation only computes the distance if it's less than or
		 * equal to the threshold value, returning -1 if it's greater. The
		 * advantage is performance: unbounded distance is O(nm), but a bound of
		 * k allows us to reduce it to O(km) time by only computing a diagonal
		 * stripe of width 2k + 1 of the cost table. It is also possible to use
		 * this to compute the unbounded Levenshtein distance by starting the
		 * threshold at 1 and doubling each time until the distance is found;
		 * this is O(dm), where d is the distance. One subtlety comes from
		 * needing to ignore entries on the border of our stripe eg. p[] =
		 * |#|#|#|* d[] = *|#|#|#| We must ignore the entry to the left of the
		 * leftmost member We must ignore the entry above the rightmost member
		 * Another subtlety comes from our stripe running off the matrix if the
		 * strings aren't of the same size. Since string s is always swapped to
		 * be the shorter of the two, the stripe will always run off to the
		 * upper right instead of the lower left of the matrix. As a concrete
		 * example, suppose s is of length 5, t is of length 7, and our
		 * threshold is 1. In this case we're going to walk a stripe of length
		 * 3. The matrix would look like so: 1 2 3 4 5 1 |#|#| | | | 2 |#|#|#| |
		 * | 3 | |#|#|#| | 4 | | |#|#|#| 5 | | | |#|#| 6 | | | | |#| 7 | | | | |
		 * | Note how the stripe leads off the table as there is no possible way
		 * to turn a string of length 5 into one of length 7 in edit distance of
		 * 1. Additionally, this implementation decreases memory usage by using
		 * two single-dimensional arrays and swapping them back and forth
		 * instead of allocating an entire n by m matrix. This requires a few
		 * minor changes, such as immediately returning when it's detected that
		 * the stripe has run off the matrix and initially filling the arrays
		 * with large values so that entries we don't compute are ignored. See
		 * Algorithms on Strings, Trees and Sequences by Dan Gusfield for some
		 * discussion.
		 */
		int n = s.length(); // length of s
		int m = t.length(); // length of t
		// if one string is empty, the edit distance is necessarily the length
		// of the other
		if (n == 0) {
			return m <= threshold ? m : -1;
		} else if (m == 0) {
			return n <= threshold ? n : -1;
		}
		if (n > m) {
			// swap the two strings to consume less memory
			final CharSequence tmp = s;
			s = t;
			t = tmp;
			n = m;
			m = t.length();
		}
		int p[] = new int[n + 1]; // 'previous' cost array, horizontally
		int d[] = new int[n + 1]; // cost array, horizontally
		int _d[]; // placeholder to assist in swapping p and d
		// fill in starting table values
		final int boundary = Math.min(n, threshold) + 1;
		for (int i = 0; i < boundary; i++) {
			p[i] = i;
		}
		// these fills ensure that the value above the rightmost entry of our
		// stripe will be ignored in following loop iterations
		Arrays.fill(p, boundary, p.length, Integer.MAX_VALUE);
		Arrays.fill(d, Integer.MAX_VALUE);
		// iterates through t
		for (int j = 1; j <= m; j++) {
			final char t_j = t.charAt(j - 1); // jth character of t
			d[0] = j;
			// compute stripe indices, constrain to array size
			final int min = Math.max(1, j - threshold);
			final int max = (j > Integer.MAX_VALUE - threshold) ? n : Math.min(
					n, j + threshold);
			// the stripe may lead off of the table if s and t are of different
			// sizes
			if (min > max) {
				return -1;
			}
			// ignore entry left of leftmost
			if (min > 1) {
				d[min - 1] = Integer.MAX_VALUE;
			}
			// iterates through [min, max] in s
			for (int i = min; i <= max; i++) {
				if (s.charAt(i - 1) == t_j) {
					// diagonally left and up
					d[i] = p[i - 1];
				} else {
					// 1 + minimum of cell to the left, to the top, diagonally
					// left and up
					d[i] = 1 + Math.min(Math.min(d[i - 1], p[i]), p[i - 1]);
				}
			}
			// copy current distance counts to 'previous row' distance counts
			_d = p;
			p = d;
			d = _d;
		}
		// if p[n] is greater than the threshold, there's no guarantee on it
		// being the correct
		// distance
		if (p[n] <= threshold) {
			return p[n];
		}
		return -1;
	}

	// startsWith
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Check if a CharSequence starts with a specified prefix.
	 * </p>
	 *
	 * <p>
	 * {@code null}s are handled without exceptions. Two {@code null} references
	 * are considered to be equal. The comparison is case sensitive.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.startsWith(null, null) = true
	 * StringUtils.startsWith(null, "abc") = false
	 * StringUtils.startsWith("abcdef", null) = false
	 * StringUtils.startsWith("abcdef", "abc") = true
	 * StringUtils.startsWith("ABCDEF", "abc") = false
	 * </pre>
	 *
	 * @see java.lang.String#startsWith(String)
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param prefix
	 *            the prefix to find, may be null
	 * @return {@code true} if the CharSequence starts with the prefix, case
	 *         sensitive, or both {@code null}
	 * @since 2.4
	 * @since 3.0 Changed signature from startsWith(String, String) to
	 *        startsWith(CharSequence, CharSequence)
	 */
	public static boolean startsWith(final CharSequence str,
			final CharSequence prefix) {
		return startsWith(str, prefix, false);
	}

	/**
	 * <p>
	 * Case insensitive check if a CharSequence starts with a specified prefix.
	 * </p>
	 *
	 * <p>
	 * {@code null}s are handled without exceptions. Two {@code null} references
	 * are considered to be equal. The comparison is case insensitive.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.startsWithIgnoreCase(null, null) = true
	 * StringUtils.startsWithIgnoreCase(null, "abc") = false
	 * StringUtils.startsWithIgnoreCase("abcdef", null) = false
	 * StringUtils.startsWithIgnoreCase("abcdef", "abc") = true
	 * StringUtils.startsWithIgnoreCase("ABCDEF", "abc") = true
	 * </pre>
	 *
	 * @see java.lang.String#startsWith(String)
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param prefix
	 *            the prefix to find, may be null
	 * @return {@code true} if the CharSequence starts with the prefix, case
	 *         insensitive, or both {@code null}
	 * @since 2.4
	 * @since 3.0 Changed signature from startsWithIgnoreCase(String, String) to
	 *        startsWithIgnoreCase(CharSequence, CharSequence)
	 */
	public static boolean startsWithIgnoreCase(final CharSequence str,
			final CharSequence prefix) {
		return startsWith(str, prefix, true);
	}

	/**
	 * <p>
	 * Check if a CharSequence starts with a specified prefix (optionally case
	 * insensitive).
	 * </p>
	 *
	 * @see java.lang.String#startsWith(String)
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param prefix
	 *            the prefix to find, may be null
	 * @param ignoreCase
	 *            indicates whether the compare should ignore case (case
	 *            insensitive) or not.
	 * @return {@code true} if the CharSequence starts with the prefix or both
	 *         {@code null}
	 */
	private static boolean startsWith(final CharSequence str,
			final CharSequence prefix, final boolean ignoreCase) {
		if (str == null || prefix == null) {
			return str == null && prefix == null;
		}
		if (prefix.length() > str.length()) {
			return false;
		}
		return MkpkCharSequenceUtils.regionMatches(str, ignoreCase, 0, prefix,
				0, prefix.length());
	}

	/**
	 * <p>
	 * Check if a CharSequence starts with any of an array of specified strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.startsWithAny(null, null) = false
	 * StringUtils.startsWithAny(null, new String[] {"abc"}) = false
	 * StringUtils.startsWithAny("abcxyz", null) = false
	 * StringUtils.startsWithAny("abcxyz", new String[] {""}) = false
	 * StringUtils.startsWithAny("abcxyz", new String[] {"abc"}) = true
	 * StringUtils.startsWithAny("abcxyz", new String[] {null, "xyz", "abc"}) = true
	 * </pre>
	 *
	 * @param string
	 *            the CharSequence to check, may be null
	 * @param searchStrings
	 *            the CharSequences to find, may be null or empty
	 * @return {@code true} if the CharSequence starts with any of the the
	 *         prefixes, case insensitive, or both {@code null}
	 * @since 2.5
	 * @since 3.0 Changed signature from startsWithAny(String, String[]) to
	 *        startsWithAny(CharSequence, CharSequence...)
	 */
	public static boolean startsWithAny(final CharSequence string,
			final CharSequence... searchStrings) {
		if (isEmpty(string) || MkpkArrayUtils.isEmpty(searchStrings)) {
			return false;
		}
		for (final CharSequence searchString : searchStrings) {
			if (startsWith(string, searchString)) {
				return true;
			}
		}
		return false;
	}

	// endsWith
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Check if a CharSequence ends with a specified suffix.
	 * </p>
	 *
	 * <p>
	 * {@code null}s are handled without exceptions. Two {@code null} references
	 * are considered to be equal. The comparison is case sensitive.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.endsWith(null, null) = true
	 * StringUtils.endsWith(null, "def") = false
	 * StringUtils.endsWith("abcdef", null) = false
	 * StringUtils.endsWith("abcdef", "def") = true
	 * StringUtils.endsWith("ABCDEF", "def") = false
	 * StringUtils.endsWith("ABCDEF", "cde") = false
	 * </pre>
	 *
	 * @see java.lang.String#endsWith(String)
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param suffix
	 *            the suffix to find, may be null
	 * @return {@code true} if the CharSequence ends with the suffix, case
	 *         sensitive, or both {@code null}
	 * @since 2.4
	 * @since 3.0 Changed signature from endsWith(String, String) to
	 *        endsWith(CharSequence, CharSequence)
	 */
	public static boolean endsWith(final CharSequence str,
			final CharSequence suffix) {
		return endsWith(str, suffix, false);
	}

	/**
	 * <p>
	 * Case insensitive check if a CharSequence ends with a specified suffix.
	 * </p>
	 *
	 * <p>
	 * {@code null}s are handled without exceptions. Two {@code null} references
	 * are considered to be equal. The comparison is case insensitive.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.endsWithIgnoreCase(null, null) = true
	 * StringUtils.endsWithIgnoreCase(null, "def") = false
	 * StringUtils.endsWithIgnoreCase("abcdef", null) = false
	 * StringUtils.endsWithIgnoreCase("abcdef", "def") = true
	 * StringUtils.endsWithIgnoreCase("ABCDEF", "def") = true
	 * StringUtils.endsWithIgnoreCase("ABCDEF", "cde") = false
	 * </pre>
	 *
	 * @see java.lang.String#endsWith(String)
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param suffix
	 *            the suffix to find, may be null
	 * @return {@code true} if the CharSequence ends with the suffix, case
	 *         insensitive, or both {@code null}
	 * @since 2.4
	 * @since 3.0 Changed signature from endsWithIgnoreCase(String, String) to
	 *        endsWithIgnoreCase(CharSequence, CharSequence)
	 */
	public static boolean endsWithIgnoreCase(final CharSequence str,
			final CharSequence suffix) {
		return endsWith(str, suffix, true);
	}

	/**
	 * <p>
	 * Check if a CharSequence ends with a specified suffix (optionally case
	 * insensitive).
	 * </p>
	 *
	 * @see java.lang.String#endsWith(String)
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param suffix
	 *            the suffix to find, may be null
	 * @param ignoreCase
	 *            indicates whether the compare should ignore case (case
	 *            insensitive) or not.
	 * @return {@code true} if the CharSequence starts with the prefix or both
	 *         {@code null}
	 */
	private static boolean endsWith(final CharSequence str,
			final CharSequence suffix, final boolean ignoreCase) {
		if (str == null || suffix == null) {
			return str == null && suffix == null;
		}
		if (suffix.length() > str.length()) {
			return false;
		}
		final int strOffset = str.length() - suffix.length();
		return MkpkCharSequenceUtils.regionMatches(str, ignoreCase, strOffset,
				suffix, 0, suffix.length());
	}

	/**
	 * <p>
	 * Check if a CharSequence ends with any of an array of specified strings.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.endsWithAny(null, null) = false
	 * StringUtils.endsWithAny(null, new String[] {"abc"}) = false
	 * StringUtils.endsWithAny("abcxyz", null) = false
	 * StringUtils.endsWithAny("abcxyz", new String[] {""}) = true
	 * StringUtils.endsWithAny("abcxyz", new String[] {"xyz"}) = true
	 * StringUtils.endsWithAny("abcxyz", new String[] {null, "xyz", "abc"}) = true
	 * </pre>
	 *
	 * @param string
	 *            the CharSequence to check, may be null
	 * @param searchStrings
	 *            the CharSequences to find, may be null or empty
	 * @return {@code true} if the CharSequence ends with any of the the
	 *         prefixes, case insensitive, or both {@code null}
	 * @since 3.0
	 */
	public static boolean endsWithAny(final CharSequence string,
			final CharSequence... searchStrings) {
		if (isEmpty(string) || MkpkArrayUtils.isEmpty(searchStrings)) {
			return false;
		}
		for (final CharSequence searchString : searchStrings) {
			if (endsWith(string, searchString)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Appends the suffix to the end of the string if the string does not
	 * already end in the suffix.
	 *
	 * @param str
	 *            The string.
	 * @param suffix
	 *            The suffix to append to the end of the string.
	 * @param ignoreCase
	 *            Indicates whether the compare should ignore case.
	 * @param suffixes
	 *            Additional suffixes that are valid terminators (optional).
	 *
	 * @return A new String if suffix was appened, the same string otherwise.
	 */
	private static String appendIfMissing(final String str,
			final CharSequence suffix, final boolean ignoreCase,
			final CharSequence... suffixes) {
		if (str == null || isEmpty(suffix) || endsWith(str, suffix, ignoreCase)) {
			return str;
		}
		if (suffixes != null && suffixes.length > 0) {
			for (final CharSequence s : suffixes) {
				if (endsWith(str, s, ignoreCase)) {
					return str;
				}
			}
		}
		return str + suffix.toString();
	}

	/**
	 * Appends the suffix to the end of the string if the string does not
	 * already end with any the suffixes.
	 *
	 * <pre>
	 * StringUtils.appendIfMissing(null, null) = null
	 * StringUtils.appendIfMissing("abc", null) = "abc"
	 * StringUtils.appendIfMissing("", "xyz") = "xyz"
	 * StringUtils.appendIfMissing("abc", "xyz") = "abcxyz"
	 * StringUtils.appendIfMissing("abcxyz", "xyz") = "abcxyz"
	 * StringUtils.appendIfMissing("abcXYZ", "xyz") = "abcXYZxyz"
	 * </pre>
	 * <p>
	 * With additional suffixes,
	 * </p>
	 * 
	 * <pre>
	 * StringUtils.appendIfMissing(null, null, null) = null
	 * StringUtils.appendIfMissing("abc", null, null) = "abc"
	 * StringUtils.appendIfMissing("", "xyz", null) = "xyz"
	 * StringUtils.appendIfMissing("abc", "xyz", new CharSequence[]{null}) = "abcxyz"
	 * StringUtils.appendIfMissing("abc", "xyz", "") = "abc"
	 * StringUtils.appendIfMissing("abc", "xyz", "mno") = "abcxyz"
	 * StringUtils.appendIfMissing("abcxyz", "xyz", "mno") = "abcxyz"
	 * StringUtils.appendIfMissing("abcmno", "xyz", "mno") = "abcmno"
	 * StringUtils.appendIfMissing("abcXYZ", "xyz", "mno") = "abcXYZxyz"
	 * StringUtils.appendIfMissing("abcMNO", "xyz", "mno") = "abcMNOxyz"
	 * </pre>
	 *
	 * @param str
	 *            The string.
	 * @param suffix
	 *            The suffix to append to the end of the string.
	 * @param suffixes
	 *            Additional suffixes that are valid terminators.
	 *
	 * @return A new String if suffix was appened, the same string otherwise.
	 *
	 * @since 3.2
	 */
	public static String appendIfMissing(final String str,
			final CharSequence suffix, final CharSequence... suffixes) {
		return appendIfMissing(str, suffix, false, suffixes);
	}

	/**
	 * Appends the suffix to the end of the string if the string does not
	 * already end, case insensitive, with any of the suffixes.
	 *
	 * <pre>
	 * StringUtils.appendIfMissingIgnoreCase(null, null) = null
	 * StringUtils.appendIfMissingIgnoreCase("abc", null) = "abc"
	 * StringUtils.appendIfMissingIgnoreCase("", "xyz") = "xyz"
	 * StringUtils.appendIfMissingIgnoreCase("abc", "xyz") = "abcxyz"
	 * StringUtils.appendIfMissingIgnoreCase("abcxyz", "xyz") = "abcxyz"
	 * StringUtils.appendIfMissingIgnoreCase("abcXYZ", "xyz") = "abcXYZ"
	 * </pre>
	 * <p>
	 * With additional suffixes,
	 * </p>
	 * 
	 * <pre>
	 * StringUtils.appendIfMissingIgnoreCase(null, null, null) = null
	 * StringUtils.appendIfMissingIgnoreCase("abc", null, null) = "abc"
	 * StringUtils.appendIfMissingIgnoreCase("", "xyz", null) = "xyz"
	 * StringUtils.appendIfMissingIgnoreCase("abc", "xyz", new CharSequence[]{null}) = "abcxyz"
	 * StringUtils.appendIfMissingIgnoreCase("abc", "xyz", "") = "abc"
	 * StringUtils.appendIfMissingIgnoreCase("abc", "xyz", "mno") = "axyz"
	 * StringUtils.appendIfMissingIgnoreCase("abcxyz", "xyz", "mno") = "abcxyz"
	 * StringUtils.appendIfMissingIgnoreCase("abcmno", "xyz", "mno") = "abcmno"
	 * StringUtils.appendIfMissingIgnoreCase("abcXYZ", "xyz", "mno") = "abcXYZ"
	 * StringUtils.appendIfMissingIgnoreCase("abcMNO", "xyz", "mno") = "abcMNO"
	 * </pre>
	 *
	 * @param str
	 *            The string.
	 * @param suffix
	 *            The suffix to append to the end of the string.
	 * @param suffixes
	 *            Additional suffixes that are valid terminators.
	 *
	 * @return A new String if suffix was appened, the same string otherwise.
	 *
	 * @since 3.2
	 */
	public static String appendIfMissingIgnoreCase(final String str,
			final CharSequence suffix, final CharSequence... suffixes) {
		return appendIfMissing(str, suffix, true, suffixes);
	}

	/**
	 * Prepends the prefix to the start of the string if the string does not
	 * already start with any of the prefixes.
	 *
	 * @param str
	 *            The string.
	 * @param prefix
	 *            The prefix to prepend to the start of the string.
	 * @param ignoreCase
	 *            Indicates whether the compare should ignore case.
	 * @param prefixes
	 *            Additional prefixes that are valid (optional).
	 *
	 * @return A new String if prefix was prepended, the same string otherwise.
	 */
	private static String prependIfMissing(final String str,
			final CharSequence prefix, final boolean ignoreCase,
			final CharSequence... prefixes) {
		if (str == null || isEmpty(prefix)
				|| startsWith(str, prefix, ignoreCase)) {
			return str;
		}
		if (prefixes != null && prefixes.length > 0) {
			for (final CharSequence p : prefixes) {
				if (startsWith(str, p, ignoreCase)) {
					return str;
				}
			}
		}
		return prefix.toString() + str;
	}

	/**
	 * Prepends the prefix to the start of the string if the string does not
	 * already start with any of the prefixes.
	 *
	 * <pre>
	 * StringUtils.prependIfMissing(null, null) = null
	 * StringUtils.prependIfMissing("abc", null) = "abc"
	 * StringUtils.prependIfMissing("", "xyz") = "xyz"
	 * StringUtils.prependIfMissing("abc", "xyz") = "xyzabc"
	 * StringUtils.prependIfMissing("xyzabc", "xyz") = "xyzabc"
	 * StringUtils.prependIfMissing("XYZabc", "xyz") = "xyzXYZabc"
	 * </pre>
	 * <p>
	 * With additional prefixes,
	 * </p>
	 * 
	 * <pre>
	 * StringUtils.prependIfMissing(null, null, null) = null
	 * StringUtils.prependIfMissing("abc", null, null) = "abc"
	 * StringUtils.prependIfMissing("", "xyz", null) = "xyz"
	 * StringUtils.prependIfMissing("abc", "xyz", new CharSequence[]{null}) = "xyzabc"
	 * StringUtils.prependIfMissing("abc", "xyz", "") = "abc"
	 * StringUtils.prependIfMissing("abc", "xyz", "mno") = "xyzabc"
	 * StringUtils.prependIfMissing("xyzabc", "xyz", "mno") = "xyzabc"
	 * StringUtils.prependIfMissing("mnoabc", "xyz", "mno") = "mnoabc"
	 * StringUtils.prependIfMissing("XYZabc", "xyz", "mno") = "xyzXYZabc"
	 * StringUtils.prependIfMissing("MNOabc", "xyz", "mno") = "xyzMNOabc"
	 * </pre>
	 *
	 * @param str
	 *            The string.
	 * @param prefix
	 *            The prefix to prepend to the start of the string.
	 * @param prefixes
	 *            Additional prefixes that are valid.
	 *
	 * @return A new String if prefix was prepended, the same string otherwise.
	 *
	 * @since 3.2
	 */
	public static String prependIfMissing(final String str,
			final CharSequence prefix, final CharSequence... prefixes) {
		return prependIfMissing(str, prefix, false, prefixes);
	}

	/**
	 * Prepends the prefix to the start of the string if the string does not
	 * already start, case insensitive, with any of the prefixes.
	 *
	 * <pre>
	 * StringUtils.prependIfMissingIgnoreCase(null, null) = null
	 * StringUtils.prependIfMissingIgnoreCase("abc", null) = "abc"
	 * StringUtils.prependIfMissingIgnoreCase("", "xyz") = "xyz"
	 * StringUtils.prependIfMissingIgnoreCase("abc", "xyz") = "xyzabc"
	 * StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz") = "xyzabc"
	 * StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz") = "XYZabc"
	 * </pre>
	 * <p>
	 * With additional prefixes,
	 * </p>
	 * 
	 * <pre>
	 * StringUtils.prependIfMissingIgnoreCase(null, null, null) = null
	 * StringUtils.prependIfMissingIgnoreCase("abc", null, null) = "abc"
	 * StringUtils.prependIfMissingIgnoreCase("", "xyz", null) = "xyz"
	 * StringUtils.prependIfMissingIgnoreCase("abc", "xyz", new CharSequence[]{null}) = "xyzabc"
	 * StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "") = "abc"
	 * StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "mno") = "xyzabc"
	 * StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz", "mno") = "xyzabc"
	 * StringUtils.prependIfMissingIgnoreCase("mnoabc", "xyz", "mno") = "mnoabc"
	 * StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz", "mno") = "XYZabc"
	 * StringUtils.prependIfMissingIgnoreCase("MNOabc", "xyz", "mno") = "MNOabc"
	 * </pre>
	 *
	 * @param str
	 *            The string.
	 * @param prefix
	 *            The prefix to prepend to the start of the string.
	 * @param prefixes
	 *            Additional prefixes that are valid (optional).
	 *
	 * @return A new String if prefix was prepended, the same string otherwise.
	 *
	 * @since 3.2
	 */
	public static String prependIfMissingIgnoreCase(final String str,
			final CharSequence prefix, final CharSequence... prefixes) {
		return prependIfMissing(str, prefix, true, prefixes);
	}

	/**
	 * <p>
	 * Wraps a string with a char.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.wrap(null, *) = null
	 * StringUtils.wrap("", *) = ""
	 * StringUtils.wrap("ab", '\0') = "ab"
	 * StringUtils.wrap("ab", 'x') = "xabx"
	 * StringUtils.wrap("ab", '\'') = "'ab'"
	 * StringUtils.wrap("\"ab\"", '\"') = "\"\"ab\"\""
	 * </pre>
	 *
	 * @param str
	 *            the string to be wrapped, may be {@code null}
	 * @param wrapWith
	 *            the char that will wrap {@code str}
	 * @return the wrapped string, or {@code null} if {@code str==null}
	 * @since 3.4
	 */
	public static String wrap(final String str, final char wrapWith) {
		if (isEmpty(str) || wrapWith == '\0') {
			return str;
		}
		return wrapWith + str + wrapWith;
	}

	/**
	 * <p>
	 * Wraps a String with another String.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.wrap(null, *) = null
	 * StringUtils.wrap("", *) = ""
	 * StringUtils.wrap("ab", null) = "ab"
	 * StringUtils.wrap("ab", "x") = "xabx"
	 * StringUtils.wrap("ab", "\"") = "\"ab\""
	 * StringUtils.wrap("\"ab\"", "\"") = "\"\"ab\"\""
	 * StringUtils.wrap("ab", "'") = "'ab'"
	 * StringUtils.wrap("'abcd'", "'") = "''abcd''"
	 * StringUtils.wrap("\"abcd\"", "'") = "'\"abcd\"'"
	 * StringUtils.wrap("'abcd'", "\"") = "\"'abcd'\""
	 * </pre>
	 *
	 * @param str
	 *            the String to be wrapper, may be null
	 * @param wrapWith
	 *            the String that will wrap str
	 * @return wrapped String, {@code null} if null String input
	 * @since 3.4
	 */
	public static String wrap(final String str, final String wrapWith) {
		if (isEmpty(str) || isEmpty(wrapWith)) {
			return str;
		}
		return wrapWith.concat(str).concat(wrapWith);
	}

	/**
	 * Convert Roman Numeral to Decimal.
	 * 
	 * @param string
	 *            Roman Numeral
	 * @return Decimal
	 * @throws IllegalArgumentException
	 *             If string is {@code null}, is empty or is not a roman
	 *             numeral.
	 */
	public static int romanIntValue(String string) {
		if (string == null)
			throw new IllegalArgumentException("null string");
		if (string.isEmpty())
			throw new IllegalArgumentException("empty string");
		return __romanIntValue(string);
	}

    // Compare
    //-----------------------------------------------------------------------
    /**
     * <p>Compare two Strings lexicographically, as per {@link String#compareTo(String)}, returning :</p>
     * <ul>
     *  <li>{@code int = 0}, if {@code str1} is equal to {@code str2} (or both {@code null})</li>
     *  <li>{@code int < 0}, if {@code str1} is less than {@code str2}</li>
     *  <li>{@code int > 0}, if {@code str1} is greater than {@code str2}</li>
     * </ul>
     *
     * <p>This is a {@code null} safe version of :</p>
     * <blockquote><pre>str1.compareTo(str2)</pre></blockquote>
     *
     * <p>{@code null} value is considered less than non-{@code null} value.
     * Two {@code null} references are considered equal.</p>
     *
     * <pre>
     * StringUtils.compare(null, null)   = 0
     * StringUtils.compare(null , "a")   &lt; 0
     * StringUtils.compare("a", null)    &gt; 0
     * StringUtils.compare("abc", "abc") = 0
     * StringUtils.compare("a", "b")     &lt; 0
     * StringUtils.compare("b", "a")     &gt; 0
     * StringUtils.compare("a", "B")     &gt; 0
     * StringUtils.compare("ab", "abc")  &lt; 0
     * </pre>
     *
     * @see #compare(String, String, boolean)
     * @see String#compareTo(String)
     * @param str1  the String to compare from
     * @param str2  the String to compare to
     * @return &lt; 0, 0, &gt; 0, if {@code str1} is respectively less, equal or greater than {@code str2}
     * @since 3.5
     */
    public static int compare(final String str1, final String str2) {
        return compare(str1, str2, true);
    }

    /**
     * <p>Compare two Strings lexicographically, as per {@link String#compareTo(String)}, returning :</p>
     * <ul>
     *  <li>{@code int = 0}, if {@code str1} is equal to {@code str2} (or both {@code null})</li>
     *  <li>{@code int < 0}, if {@code str1} is less than {@code str2}</li>
     *  <li>{@code int > 0}, if {@code str1} is greater than {@code str2}</li>
     * </ul>
     *
     * <p>This is a {@code null} safe version of :</p>
     * <blockquote><pre>str1.compareTo(str2)</pre></blockquote>
     *
     * <p>{@code null} inputs are handled according to the {@code nullIsLess} parameter.
     * Two {@code null} references are considered equal.</p>
     *
     * <pre>
     * StringUtils.compare(null, null, *)     = 0
     * StringUtils.compare(null , "a", true)  &lt; 0
     * StringUtils.compare(null , "a", false) &gt; 0
     * StringUtils.compare("a", null, true)   &gt; 0
     * StringUtils.compare("a", null, false)  &lt; 0
     * StringUtils.compare("abc", "abc", *)   = 0
     * StringUtils.compare("a", "b", *)       &lt; 0
     * StringUtils.compare("b", "a", *)       &gt; 0
     * StringUtils.compare("a", "B", *)       &gt; 0
     * StringUtils.compare("ab", "abc", *)    &lt; 0
     * </pre>
     *
     * @see String#compareTo(String)
     * @param str1  the String to compare from
     * @param str2  the String to compare to
     * @param nullIsLess  whether consider {@code null} value less than non-{@code null} value
     * @return &lt; 0, 0, &gt; 0, if {@code str1} is respectively less, equal ou greater than {@code str2}
     * @since 3.5
     */
    public static int compare(final String str1, final String str2, final boolean nullIsLess) {
        if (str1 == str2) {
            return 0;
        }
        if (str1 == null) {
            return nullIsLess ? -1 : 1;
        }
        if (str2 == null) {
            return nullIsLess ? 1 : - 1;
        }
        return str1.compareTo(str2);
    }

    /**
     * <p>Compare two Strings lexicographically, ignoring case differences,
     * as per {@link String#compareToIgnoreCase(String)}, returning :</p>
     * <ul>
     *  <li>{@code int = 0}, if {@code str1} is equal to {@code str2} (or both {@code null})</li>
     *  <li>{@code int < 0}, if {@code str1} is less than {@code str2}</li>
     *  <li>{@code int > 0}, if {@code str1} is greater than {@code str2}</li>
     * </ul>
     *
     * <p>This is a {@code null} safe version of :</p>
     * <blockquote><pre>str1.compareToIgnoreCase(str2)</pre></blockquote>
     *
     * <p>{@code null} value is considered less than non-{@code null} value.
     * Two {@code null} references are considered equal.
     * Comparison is case insensitive.</p>
     *
     * <pre>
     * StringUtils.compareIgnoreCase(null, null)   = 0
     * StringUtils.compareIgnoreCase(null , "a")   &lt; 0
     * StringUtils.compareIgnoreCase("a", null)    &gt; 0
     * StringUtils.compareIgnoreCase("abc", "abc") = 0
     * StringUtils.compareIgnoreCase("abc", "ABC") = 0
     * StringUtils.compareIgnoreCase("a", "b")     &lt; 0
     * StringUtils.compareIgnoreCase("b", "a")     &gt; 0
     * StringUtils.compareIgnoreCase("a", "B")     &lt; 0
     * StringUtils.compareIgnoreCase("A", "b")     &lt; 0
     * StringUtils.compareIgnoreCase("ab", "ABC")  &lt; 0
     * </pre>
     *
     * @see #compareIgnoreCase(String, String, boolean)
     * @see String#compareToIgnoreCase(String)
     * @param str1  the String to compare from
     * @param str2  the String to compare to
     * @return &lt; 0, 0, &gt; 0, if {@code str1} is respectively less, equal ou greater than {@code str2},
     *          ignoring case differences.
     * @since 3.5
     */
    public static int compareIgnoreCase(final String str1, final String str2) {
        return compareIgnoreCase(str1, str2, true);
    }

    /**
     * <p>Compare two Strings lexicographically, ignoring case differences,
     * as per {@link String#compareToIgnoreCase(String)}, returning :</p>
     * <ul>
     *  <li>{@code int = 0}, if {@code str1} is equal to {@code str2} (or both {@code null})</li>
     *  <li>{@code int < 0}, if {@code str1} is less than {@code str2}</li>
     *  <li>{@code int > 0}, if {@code str1} is greater than {@code str2}</li>
     * </ul>
     *
     * <p>This is a {@code null} safe version of :</p>
     * <blockquote><pre>str1.compareToIgnoreCase(str2)</pre></blockquote>
     *
     * <p>{@code null} inputs are handled according to the {@code nullIsLess} parameter.
     * Two {@code null} references are considered equal.
     * Comparison is case insensitive.</p>
     *
     * <pre>
     * StringUtils.compareIgnoreCase(null, null, *)     = 0
     * StringUtils.compareIgnoreCase(null , "a", true)  &lt; 0
     * StringUtils.compareIgnoreCase(null , "a", false) &gt; 0
     * StringUtils.compareIgnoreCase("a", null, true)   &gt; 0
     * StringUtils.compareIgnoreCase("a", null, false)  &lt; 0
     * StringUtils.compareIgnoreCase("abc", "abc", *)   = 0
     * StringUtils.compareIgnoreCase("abc", "ABC", *)   = 0
     * StringUtils.compareIgnoreCase("a", "b", *)       &lt; 0
     * StringUtils.compareIgnoreCase("b", "a", *)       &gt; 0
     * StringUtils.compareIgnoreCase("a", "B", *)       &lt; 0
     * StringUtils.compareIgnoreCase("A", "b", *)       &lt; 0
     * StringUtils.compareIgnoreCase("ab", "abc", *)    &lt; 0
     * </pre>
     *
     * @see String#compareToIgnoreCase(String)
     * @param str1  the String to compare from
     * @param str2  the String to compare to
     * @param nullIsLess  whether consider {@code null} value less than non-{@code null} value
     * @return &lt; 0, 0, &gt; 0, if {@code str1} is respectively less, equal ou greater than {@code str2},
     *          ignoring case differences.
     * @since 3.5
     */
    public static int compareIgnoreCase(final String str1, final String str2, final boolean nullIsLess) {
        if (str1 == str2) {
            return 0;
        }
        if (str1 == null) {
            return nullIsLess ? -1 : 1;
        }
        if (str2 == null) {
            return nullIsLess ? 1 : - 1;
        }
        return str1.compareToIgnoreCase(str2);
    }

    // ------------------------------------------------------------------------

	private static int __romanIntValue(String string) {
		String number = string.toUpperCase();
		if (number.isEmpty())
			return 0;
		if (number.startsWith("M"))
			return 1000 + __romanIntValue(number.substring(1));
		if (number.startsWith("CM"))
			return 900 + __romanIntValue(number.substring(2));
		if (number.startsWith("D"))
			return 500 + __romanIntValue(number.substring(1));
		if (number.startsWith("CD"))
			return 400 + __romanIntValue(number.substring(2));
		if (number.startsWith("C"))
			return 100 + __romanIntValue(number.substring(1));
		if (number.startsWith("XC"))
			return 90 + __romanIntValue(number.substring(2));
		if (number.startsWith("L"))
			return 50 + __romanIntValue(number.substring(1));
		if (number.startsWith("XL"))
			return 40 + __romanIntValue(number.substring(2));
		if (number.startsWith("X"))
			return 10 + __romanIntValue(number.substring(1));
		if (number.startsWith("IX"))
			return 9 + __romanIntValue(number.substring(2));
		if (number.startsWith("V"))
			return 5 + __romanIntValue(number.substring(1));
		if (number.startsWith("IV"))
			return 4 + __romanIntValue(number.substring(2));
		if (number.startsWith("I"))
			return 1 + __romanIntValue(number.substring(1));
		throw new IllegalArgumentException("unexpected roman numerals");
	}
}
