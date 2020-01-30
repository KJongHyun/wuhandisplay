package kr.wuhan.service;

import kr.wuhan.vo.WuhanData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class WuhanDataServiceImpl implements WuhanDataService {

    public WuhanData getWuhanData() {
        ArrayList<String> counts = new ArrayList<String>();
        Document doc = null;

        try {
            String url = "https://www.worldometers.info/coronavirus/";
            doc = Jsoup.connect(url).get();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements elements = doc.select("div.maincounter-number");

        for (Element element : elements.select("span")) {
            counts.add(element.text());
        }

        WuhanData wuhanData = new WuhanData();
        wuhanData.setCases(counts.get(0));
        wuhanData.setDeaths(counts.get(1));


        return wuhanData;
    }
}
