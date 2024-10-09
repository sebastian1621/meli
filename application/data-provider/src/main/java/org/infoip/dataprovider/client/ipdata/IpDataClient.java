package org.infoip.dataprovider.client.ipdata;

import org.infoip.dataprovider.client.RestClient;
import org.infoip.dataprovider.client.ipdata.model.response.IpInfoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IpDataClient extends RestClient<IpInfoResponse> {
    protected IpDataClient(
            @Value("${ipapi.url}") String ipInfoApiUrl,
            @Value("${ipapi.accesskey}") String accessKey
    ) {
        super(ipInfoApiUrl, accessKey);
    }
}
