package com.launchPad.web.util;


import network.nerve.heterogeneous.core.HtgWalletApi;

/**
 * @Author leedan
 * @Description :
 * @Date 2022/9/16  11:34
 * @Version 1.0
 */

public class HtgWalletApiService {
    private static HtgWalletApi htgWalletApi;

//    private static HtgWalletApi htgEnulsWalletApi;
//
//    private static HtgWalletApi htgLineaWalletApi;

    public static synchronized  HtgWalletApi getHtgWalletApi(){
        if (htgWalletApi == null){
            return  HtgWalletApi.getInstance("NULS", "ENULS Testnet", "https://beta.evmapi2.nuls.io");
        }
        return htgWalletApi;
    }


//    public static synchronized  HtgWalletApi getEnulsHtgWalletApi(){
//        if (htgEnulsWalletApi == null){
//            return  HtgWalletApi.getInstance(EventType.enusl_symbol, EventType.enuls_chainName, EventType.enuls_rpcAddress);
//        }
//        return htgEnulsWalletApi;
//    }
//
//    public static synchronized  HtgWalletApi getLineaHtgWalletApi(){
//        if (htgLineaWalletApi == null){
//            return  HtgWalletApi.getInstance(EventType.linea_symbol, EventType.linea_chainName, EventType.linea_rpcAddress);
//        }
//        return htgLineaWalletApi;
//    }



}
