package com.chang.omg.infrastructure.api.maplestorym;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.chang.omg.infrastructure.config.property.MapleStoryMProperties;
import com.chang.omg.infrastructure.domain.maplestorym.CharacterBasic;
import com.chang.omg.infrastructure.domain.maplestorym.CharacterItemEquipment;
import com.chang.omg.infrastructure.domain.maplestorym.Ocid;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MapleStoryMApiRestTemplate implements MapleStoryMApi {

    private final RestTemplate restTemplate;
    private final MapleStoryMProperties mapleStoryMProperties;

    public Ocid getCharacterOcid(final String characterName, final String worldName) {
        return restTemplate.exchange(
                        createOcidApiUri(characterName, worldName),
                        HttpMethod.GET,
                        new HttpEntity<>(createHttpHeaders()),
                        Ocid.class)
                .getBody();
    }

    private String createOcidApiUri(final String characterName, final String worldName) {
        return UriComponentsBuilder.fromHttpUrl(
                        mapleStoryMProperties.getBaseUrl() + mapleStoryMProperties.getOcidApiUri()
                )
                .queryParam("character_name", characterName)
                .queryParam("world_name", worldName)
                .build()
                .toUriString();
    }

    public CharacterBasic getCharacterBasic(final String ocid) {
        return restTemplate.exchange(
                        createApiUrl(ocid, mapleStoryMProperties.getBasicApiUri()),
                        HttpMethod.GET,
                        new HttpEntity<>(createHttpHeaders()),
                        CharacterBasic.class)
                .getBody();
    }

    public CharacterItemEquipment getCharacterItem(final String ocid) {
        return restTemplate.exchange(
                        createApiUrl(ocid, mapleStoryMProperties.getItemApiUri()),
                        HttpMethod.GET,
                        new HttpEntity<>(createHttpHeaders()),
                        CharacterItemEquipment.class)
                .getBody();
    }

    private String createApiUrl(final String ocid, final String requestUri) {
        return UriComponentsBuilder.fromHttpUrl(mapleStoryMProperties.getBaseUrl() + requestUri)
                .queryParam("ocid", ocid)
                .build()
                .toUriString();
    }

    private HttpHeaders createHttpHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        headers.add(mapleStoryMProperties.getHeaderKey(), mapleStoryMProperties.getHeaderValue());

        return headers;
    }
}
