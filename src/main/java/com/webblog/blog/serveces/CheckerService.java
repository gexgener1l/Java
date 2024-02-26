package com.webblog.blog.serveces;

import com.webblog.blog.DTOClasses.ResponseDTO;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

public class CheckerService {

    private CheckerService() {
    }

    @GetMapping("/check/{url}")
    public static ResponseEntity<ResponseDTO> checkSite(@PathVariable String url) {
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
            String lastModified = document.select("meta[name=last-modified]").attr(content);

            // Создание объекта MyResponseDTO
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setStatus("success");
            responseDTO.setMessage("Сайт " + url + " проверен");
            responseDTO.setPageTitle(pageTitle);
            responseDTO.setStatusCode(statusCode);
            responseDTO.setLastModified(lastModified);
            responseDTO.setMetaDescription(metaDescription);
            responseDTO.setMetaKeywords(metaKeywords);

            return ResponseEntity.ok(responseDTO);
        } catch (IOException e) {
            // Обработка ошибки и возврат ошибочного ответа
            ResponseDTO errorResponseDTO = new ResponseDTO();
            errorResponseDTO.setStatus("error");
            errorResponseDTO.setMessage("Ошибка при проверке сайта " + url);
            // Дополнительная информация об ошибке, если необходимо
            errorResponseDTO.setErrorDetails(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDTO);
        }
    }
}