package com.testapp.testclient;

import com.wiley.authorservices.clients.ext.literatum.webflux.LiteratumPdfClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class LiteratumNewClient extends LiteratumPdfClient {
    public LiteratumNewClient(String clientId, String clientSecret, WebClient nativeClient) {
        super(clientId, clientSecret, nativeClient);
    }

    private Mono<String> getData() {
        return this.webClient.get().uri("/test").retrieve().bodyToMono(String.class);
    }

    public static ClientIdSpec<LiteratumNewClient> builder() {
        return new LiteratumNewClient.Builder();
    }

    private static class Builder extends com.wiley.authorservices.clients.ext.literatum.webflux.LiteratumPdfClient.Builder<LiteratumNewClient> {
        private Builder() {
        }

        protected LiteratumNewClient createClientInstance(org.springframework.web.reactive.function.client.WebClient.Builder webClientBuilder) {
            return new LiteratumNewClient(this.clientId, this.clientSecret, webClientBuilder.build());
        }
    }
}
