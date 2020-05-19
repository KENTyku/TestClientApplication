package com.testapp.testclient;

import com.wiley.authorservices.clients.ext.literatum.webflux.LiteratumPdfClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.function.Function;

@Configuration
public class ConfigClient {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Bean
    public LiteratumPdfClient literatumPdfClient() {
        return LiteratumPdfClient.builder()
                .clientId("uImBOpjnnZ")
                .clientSecret("WUmQBbmQ3kikw9zo5OYeukqXMF7qdglG")
                .webClient(webClientBuilder)
//                .baseUri("https://one-lts.literatumonline.com")
//                .baseUri("https://pericles.one-lts.literatumonline.com")
//                .baseUri("https://yandex.ru")
                .baseUri("https://apiclwsp-b20.xarin.caixabank.es")
                .reactorTcpOptions(tcp -> tcp.useSystemHttpProxyIgnoringNonProxyHosts())
//                .reactorTcpOptions(tcp->tcp.defaultSecuredSsl())
//                .reactorTcpOptions(tcp->tcp.defaultSsl())
//                .reactorTcpOptions(tcp->tcp.defaultInscuredSsl())
                .mapException(extExceptionMapper(ASErrors.ARTICLE_PDF_DOWNLOADER_COMMUNICATION_ERROR))
                .build();
    }

    private Function<Exception, Exception> extExceptionMapper(ASErrors asError) {
        return e ->
                new ExtServiceException(asError, e.getMessage(), e);
    }
}
