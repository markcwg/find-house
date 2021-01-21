package com.study.findhouse.utils;

import com.study.findhouse.pojo.House;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author markcwg
 * @email caiwg@sucsoft.com
 * @date 2021/1/20 16:57
 */
@Component
public class HtmlParserUtils {

//    public static void main(String[] args) throws IOException {
//        new HtmlParserUtils().parser();;
//    }

    public List<House> parser () throws IOException {
        List<House> list = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            String url = "https://km.zu.ke.com/zufang/pg" + i + "rt200600000001";
            Document document = Jsoup.parse(new URL(url), 300000);
            //获取房源列表
            Elements list1 = document.getElementsByClass("content__list");
            Element element1 = list1.get(0);
            //获取单个房源信息
            Elements list2 = element1.getElementsByClass("content__list--item");
            for (Element element : list2) {
                String imgUrl = element.getElementsByTag("img").eq(0).attr("data-src");
                Element element2 = element.getElementsByClass("content__list--item--main").get(0);
                String title = element2.getElementsByClass("content__list--item--title").get(0).getElementsByTag("a").get(0).text();
                String price = element2.getElementsByClass("content__list--item-price").get(0).getElementsByTag("em").text();
                House house = new House(imgUrl,price,title);
                list.add(house);
            }
        }
        return list;
    }
}
