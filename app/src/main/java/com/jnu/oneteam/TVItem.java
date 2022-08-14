package com.jnu.oneteam;
public class TVItem {
     String TVBroadcast;
     int TVImage;
     String TVName;
     String TVStar;
     String TVSum;
     String TVHeat;

     //每一个榜单项目内容
    public TVItem(int TVImage, String TVName, String TVStar, String TVSum, String TVBroadcast, String TVHeat){
        this.TVImage=TVImage;
        this.TVName=TVName;
        this.TVStar=TVStar;
        this.TVSum=TVSum;
        this.TVBroadcast=TVBroadcast;
        this.TVHeat=TVHeat;

    }

    public String getTVBroadcast() {
        return TVBroadcast;
    }

    public int getTVImage() {
        return TVImage;
    }

    public String getTVName() {
        return TVName;
    }

    public String getTVStar() {
        return TVStar;
    }

    public String getTVSum() {
        return TVSum;
    }

    public String getTVHeat() {
        return TVHeat;
    }
}
