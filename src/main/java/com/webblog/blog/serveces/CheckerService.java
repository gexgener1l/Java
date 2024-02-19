package com.webblog.blog.serveces;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CheckerService {

    // Private constructor to hide the implicit public one
    private CheckerService() {
        // Private constructor implementation (if needed)
    }

    public static String checkSite(String url) {
        try {
            Connection.Response response = Jsoup.connect(url).execute();
            int statusCode = response.statusCode();
            Document document = response.parse();
            String pageTitle = document.title();
            String content = "content";

            // Мета-теги
            Elements metaTags = document.select("meta");
            String metaDescription = metaTags.select("meta[name=description]").attr(content);
            String metaKeywords = metaTags.select("meta[name=keywords]").attr(content);

            // Дата последнего обновления
            String lastModified = document.select("meta[name=last-modified]").attr(content);

            return "{ \"status\": \"success\", \"message\": \"Сайт " + url + " проверен\", \"pageTitle\": \"" + pageTitle + "\", \"statusCode\": " + statusCode + ", \"lastModified\": \"" + lastModified + "\", \"metaDescription\": \"" + metaDescription + "\", \"metaKeywords\": \"" + metaKeywords + "\" }";
        } catch (IOException e) {
            return createErrorMessage(url, e);
        }
    }

    private static String createErrorMessage(String url, Exception e) {
        return "{ \"status\": \"error\", \"message\": \"Ошибка при проверке сайта " + url + "\", \"errorDetails\": \"" + e.getMessage() + "\" }";
    }
}