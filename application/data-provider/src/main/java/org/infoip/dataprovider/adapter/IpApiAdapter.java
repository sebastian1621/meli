package org.infoip.dataprovider.adapter;

import org.infoip.core.entity.IpInfo;
import org.infoip.core.exceptions.ExternalApiException;
import org.infoip.dataprovider.client.ipdata.IpDataClient;
import org.infoip.dataprovider.client.ipdata.model.response.IpInfoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRulesException;
import java.util.List;

@Component
public class IpApiAdapter {

    private final IpDataClient ipCountryClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(IpApiAdapter.class);

    public IpApiAdapter(final IpDataClient ipCountryClient) {
        this.ipCountryClient = ipCountryClient;
    }

    public IpInfo getIpInfo(final String ip) throws ExternalApiException {
        final IpInfoResponse ipInfoResponse = ipCountryClient.getRequest(List.of(ip));
        return new IpInfo(
                ipInfoResponse.getCountry(),
                ipInfoResponse.getIsoCode(),
                ipInfoResponse.getIsoName(),
                ipInfoResponse.getLatitude(),
                ipInfoResponse.getLongitude(),
                ipInfoResponse.getDistance(),
                ipInfoResponse.getLocation(),
                calculateZonedDateTime(ipInfoResponse)
        );
    }

    private ZonedDateTime calculateZonedDateTime(final IpInfoResponse ipInfoResponse) {
        try {
            final ZoneId zoneId = ZoneId.of(ipInfoResponse.getIsoName() + "/" + ipInfoResponse.getLocation().getCapital());
            return ZonedDateTime.now(zoneId);
        } catch (ZoneRulesException e) {
            LOGGER.error("Error while calculating ZonedDateTime", e);
            return null;
        }
    }
}
