package org.infoip.dataprovider.provider;

import org.infoip.core.entity.IpInfo;
import org.infoip.core.exceptions.ExternalApiException;
import org.infoip.core.provider.IpInfoProvider;
import org.infoip.dataprovider.adapter.IpApiAdapter;
import org.springframework.stereotype.Component;

@Component
public class IpInfoProviderImpl implements IpInfoProvider {
    private final IpApiAdapter ipApiAdapter;

    public IpInfoProviderImpl(final IpApiAdapter ipApiAdapter) {
        this.ipApiAdapter = ipApiAdapter;
    }

    @Override
    public IpInfo getIpInfo(final String ip) throws ExternalApiException {
        return ipApiAdapter.getIpInfo(ip);
    }
}
