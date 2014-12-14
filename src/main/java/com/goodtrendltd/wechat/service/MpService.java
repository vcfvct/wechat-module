package com.goodtrendltd.wechat.service;

import com.goodtrendltd.wechat.model.incoming.IncomingBaseMessage;
import com.goodtrendltd.wechat.model.outgoing.OutGoingBaseMessage;

/**
 * Created by LeOn on 12/11/14.
 */
public interface MpService {
    public boolean checkSignature(String signature, String timestamp, String nonce);

    public String handleIncomingMessage(String incomingBaseMessage);
}
