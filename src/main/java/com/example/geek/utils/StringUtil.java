package com.example.geek.utils;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringUtil {
    public static String nulltoEmpty(String str) {
        if (str == null) {
            return ConstStrings.EMPTY;
        }
        return str;
    }

    public static List<Integer> strParseToList(String str){
        if (str == null || StringUtils.isEmpty(str)){
            return null;
        }
        int[] a = Arrays.stream(str.split(",")).mapToInt(s -> Integer.parseInt(s)).filter(x->!StringUtils.isEmpty(x)).toArray();
        List<Integer> list = Arrays.stream( a ).boxed().collect(Collectors.toList());
        return list;
    }

    public static List<String> strParseToSringList(String str){
        if (str == null || StringUtils.isEmpty(str)){
            return Collections.EMPTY_LIST;
        }
        List<String> list = Arrays.stream(str.split(",")).map(s -> s.trim()).filter(x->!StringUtils.isEmpty(x)).collect(Collectors.toList());
        return list;
    }

    public static Set<Integer> strParseToSet(String str){
        if (str == null || StringUtils.isEmpty(str)){
            return null;
        }
        int[] a = Arrays.stream(str.split(",")).mapToInt(s -> Integer.parseInt(s)).filter(x->!StringUtils.isEmpty(x)).toArray();
        Set<Integer> list = Arrays.stream( a ).boxed().collect(Collectors.toSet());
        return list;
    }

    public static String listToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null && list.size() > 0) {
            //Lambda表达式
            return list.stream().collect(Collectors.joining(","));
        }else {
            return "";
        }
    }
    public static boolean isDoubleOrFloat(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
        return pattern.matcher(str).matches();
    }
}
