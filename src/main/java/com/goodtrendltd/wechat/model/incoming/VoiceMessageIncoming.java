package com.goodtrendltd.wechat.model.incoming;

/**
 * Created by LeOn on 12/11/14.
 */
public class VoiceMessageIncoming extends IncomingBaseMessage {
    /**
     * 媒体ID
     */
    private String mediaId;
    /**
     * 语音格式
     */
    private String format;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String getOutputMsg()
    {
        return null;
    }
}
