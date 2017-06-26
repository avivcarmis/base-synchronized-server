package com.example.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncodingUtils {

    private static final String UTF8_ENCODING = "UTF-8";

    public static String readResourceFile(String path) throws IOException {
        InputStream inputStream = EncodingUtils.class.getResourceAsStream(path);
        StringWriter writer = new StringWriter();
        try {
            IOUtils.copy(inputStream, writer, UTF8_ENCODING);
        } catch (NullPointerException e) {
            throw new IOException("resource not found");
        }
        return writer.toString();
    }

}
