package com.example.demo.uitility;

import java.net.Socket;
import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.message.types.GrantType;

public class Token {

    //public static final String TOKEN_REQUEST_URL = "https://dev-tlprompt-api.thailife.com:8243/token";
    //public static final String CLIENT_ID = "Q0MIVPoE34aW9beSqdZPXHP9NWoa";
    //public static final String CLIENT_SECRET = "w7P5E5W7N_wb1LxkMan_pHKXW5oa";

    public String tokenRequestUrl;
    public String clientId;
    public String clientSecret;

    public Token()
    {
        //default
        tokenRequestUrl = "https://dev-tlprompt-api.thailife.com:8243/token";
        clientId = "Q0MIVPoE34aW9beSqdZPXHP9NWoa";
        clientSecret = "w7P5E5W7N_wb1LxkMan_pHKXW5oa";
    }


    public String get(String env) {

        if(env.equals("sit"))
        {
            tokenRequestUrl = "http://sit-tlprompt-api.thailife.com:8280/token";
            clientId = "8qI2SWIBhZKye_qz0zj0n70tRfQa";
            clientSecret = "D19TfD1t6NpxyqH3XoKTpHzdKtca";
        }

        try {

            OAuthClient client = new OAuthClient(new URLConnectionClient());

            trustAllHosts();

            OAuthClientRequest request = OAuthClientRequest.tokenLocation(tokenRequestUrl)
            .setGrantType(GrantType.CLIENT_CREDENTIALS)
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            //.setScope(SCOPE)
            .buildBodyMessage();

            System.out.println(request.getBody());

            String token = client.accessToken(request, OAuth.HttpMethod.POST, OAuthJSONAccessTokenResponse.class).getAccessToken();
            
            return token;

        } catch (Exception exn) {
            exn.printStackTrace();

            return null;
        }
    }

    private static String base64EncodedBasicAuthentication() {
        // TODO Auto-generated method stub
        return null;
    }

    public void trustAllHosts()
    {
        try
        {
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509ExtendedTrustManager()
                    {
                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers()
                        {
                            return null;
                        }

                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
                        {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
                        {
                        }

                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] xcs, String string, Socket socket) throws CertificateException
                        {

                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] xcs, String string, Socket socket) throws CertificateException
                        {

                        }

                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] xcs, String string, SSLEngine ssle) throws CertificateException
                        {

                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] xcs, String string, SSLEngine ssle) throws CertificateException
                        {

                        }

                    }
            };

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new  HostnameVerifier()
            {
                @Override
                public boolean verify(String hostname, SSLSession session)
                {
                    return true;
                }
            };
            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}