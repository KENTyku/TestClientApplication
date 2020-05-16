package com.testapp.testclient;

import com.wiley.authorservices.clients.ext.literatum.webflux.LiteratumPdfClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.function.Function;

@Configuration
public class ConfigClient {
    @Bean
    public LiteratumPdfClient literatumPdfClient() {
        WebClient.Builder webClientBuilder=WebClient.builder();
        return LiteratumPdfClient.builder()
                .clientId("uImBOpjnnZ")
                .clientSecret("WUmQBbmQ3kikw9zo5OYeukqXMF7qdglG")
                .webClient(webClientBuilder)
                .baseUri("https://pericles.one-lts.literatumonline.com")
                .reactorTcpOptions(tcp -> tcp.useSystemHttpProxyIgnoringNonProxyHosts())
                .reactorTcpOptions(tcp->tcp.defaultInscuredSsl())
                .mapException(extExceptionMapper(ASErrors.ARTICLE_PDF_DOWNLOADER_COMMUNICATION_ERROR))
                .build();
    }

    @Bean
    LiteratumNewClient literatumNewClient() {
        WebClient.Builder builder = WebClient.builder();
        return LiteratumNewClient.builder()
                .clientId("uImBOpjnnZ")
                .clientSecret("WUmQBbmQ3kikw9zo5OYeukqXMF7qdglG")
                .webClient(builder)
                .baseUri("https://pericles.one-lts.literatumonline.com")
                .reactorTcpOptions(tcp -> tcp.useSystemHttpProxyIgnoringNonProxyHosts())
                .reactorTcpOptions(tcp -> tcp.defaultInscuredSsl())
                .mapException(extExceptionMapper(ASErrors.ARTICLE_PDF_DOWNLOADER_COMMUNICATION_ERROR))
                .build();
    }

    private Function<Exception, Exception> extExceptionMapper(ASErrors asError) {
        return e ->
                new ExtServiceException(asError, e.getMessage(), e);
    }
}
