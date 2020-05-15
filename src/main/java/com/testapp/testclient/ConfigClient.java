//package com.testapp.testclient;
//
//import com.wiley.authorservices.clients.ext.literatum.webflux.LiteratumPdfClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
////import org.springframework.web.reactive.function.client.WebClient;
//
//import java.util.function.Consumer;
////@Configuration
//public class ConfigClient {
////    @Bean
//    public LiteratumPdfClient literatumPdfClient() {
//        WebClient.Builder webClientBuilder=WebClient.builder();
//        return LiteratumPdfClient.builder()
//                .clientId("literatumPdfClientId")
//                .clientSecret("literatumPdfClientSecret")
//                .webClient(webClientBuilder)
//                .baseUri("url")
//                .reactorTcpOptions(tcp -> tcp.useSystemHttpProxyIgnoringNonProxyHosts())
//                .reactorTcpOptions(tcp->tcp.defaultInscuredSsl())
////                .mapException(extExceptionMapper(ASErrors.ARTICLE_PDF_DOWNLOADER_COMMUNICATION_ERROR))
//                .build();
//    }
//
////    @Bean
////    public WebClient webClient(){
////        return WebClient.builder()
////                .baseUrl("url")
////                .
////    }
//}
