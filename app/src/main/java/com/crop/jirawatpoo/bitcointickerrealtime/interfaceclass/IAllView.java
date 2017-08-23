package com.crop.jirawatpoo.bitcointickerrealtime.interfaceclass;

import com.crop.jirawatpoo.bitcointickerrealtime.dao.Pricecheck.pricerespone;

/**
 * Created by jirawat.poo on 8/23/2017 AD.
 */

public interface IAllView {

    void apicallsuccess(pricerespone pricerespone);

    void apicallfail(Throwable throwable);
}
