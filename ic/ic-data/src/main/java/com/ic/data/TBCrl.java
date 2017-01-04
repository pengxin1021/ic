package com.ic.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ic.data.util.DataBundle;
import com.ic.utils.HttpRestUtils;
import com.ic.utils.HttpRestUtils.HttpResult;

public class TBCrl extends Crl {

	private static Logger logger = LoggerFactory.getLogger(TBCrl.class);

	public static void main(String[] args) {
		TBCrl crl = new TBCrl();
		crl.page();
	}

	public void page() {
		for (int i = DataBundle.TBPage;; i++) {
			String url = DataBundle.TBUrl + (i * 20);
			boolean hasResult = getShopUrl(url);
			if (!hasResult) {
				break;
			}
		}
	}

	public boolean getShopUrl(String url) {
		boolean hasResult = true;
		try {
			HttpResult result = HttpRestUtils.fetchGetURLContent(url,
					null, "UTF-8", "UTF-8", false, null);
			if (result.getStatusCode() == 200) {
				logger.info(result.getResultString());
				Document document = Jsoup.parse(result.getResultString());
				logger.info(document.toString());
				Elements elements = document.select("li[class=list-item]").select("a[class=shop-name J_shop_name]");
				for (Element element : elements) {
					String shopUrl = "https:" + element.attr("href");
					getShopDetail(shopUrl);
				}
			} else {
				hasResult = false;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return hasResult;
	}

	public void getShopDetail(String url) {
		System.out.println(url);
	}

}
