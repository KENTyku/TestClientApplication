package com.testapp.testclient;

import com.wiley.authorservices.clients.ext.literatum.webflux.LiteratumPdfClient;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
import java.util.function.Function;

@Configuration
public class ConfigClient {
    private static final Logger LOG = LoggerFactory.getLogger(ConfigClient.class);

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

    @Bean
    public WebClient testClient() {
        WebClient.Builder client = WebClient.builder();
        sslContextConfigure(client, false);
        return client
                .baseUrl("https://apiclwsp-b20.xarin.caixabank.es")
//                .baseUrl("https://yandex.ru")
                .build();
    }





    private void sslContextConfigure(WebClient.Builder builder, boolean skipSslCertCheck) {
        if (skipSslCertCheck) {
            try {
                SslContext sslContext = SslContextBuilder
                        .forClient()
                        .trustManager(new EmptyX509TrustManager())
                        .build();
                HttpClient httpClient = HttpClient.create().secure(sslSpec -> sslSpec.sslContext(sslContext));
                ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);
                builder.clientConnector(connector);
            } catch (SSLException e) {
                LOG.debug("Custom SslContext preparation is failed.", e);
            }
        }
    }

    private Function<Exception, Exception> extExceptionMapper(ASErrors asError) {
        return e ->
                new ExtServiceException(asError, e.getMessage(), e);
    }

//    @SuppressFBWarnings("WEAK_TRUST_MANAGER")
    private static class EmptyX509TrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
        }
    }
}
