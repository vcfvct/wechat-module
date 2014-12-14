package com.goodtrendltd.wechat.model.outgoing;

/**
 * Created by LeOn on 12/11/14.
 /**
 * 音乐消息
 */
public class MusicMessageOutGoing extends OutGoingBaseMessage {
    /**
     * 音乐
     */
    private Music music;

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
}