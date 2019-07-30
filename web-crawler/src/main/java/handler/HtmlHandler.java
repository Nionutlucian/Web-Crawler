package handler;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.model.Product;

public class HtmlHandler {

	private String url1;
	private Document doc;

	public HtmlHandler(String url1) {
		this.url1 = url1;
	}

	public ArrayList<Product> test() throws IOException {
		doc = Jsoup.connect(url1).get();
		Elements productsTop = doc.getElementsByClass("card-heading");
		Elements productsMiddle = doc.getElementsByClass("card-section-mid-inner");
		Elements productsBottom = doc.getElementsByClass("product-new-price");
		ArrayList<Product> products = new ArrayList<>();
		Product prod;

		for (Element p : productsTop) {
			if (p.getElementsByTag("a").attr("href") != "") {
				prod = new Product();
				prod.setImage(p.getElementsByTag("img").attr("src"));
				prod.setUrl(p.getElementsByTag("a").attr("href"));
				prod.setProvider("eMAG");
				products.add(prod);
			}
		}
		int i = 0;
		for (Element p : productsMiddle) {
			products.get(i).setTitle(p.getElementsByTag("a").attr("title"));
			i++;
		}
		i = 0;
		for (Element p : productsBottom) {
			if(p.ownText().length()!=0) {
				products.get(i).setPrice(p.ownText());
				i++;
			}
		}

		for (Product p : products) {
			String x = p.getUrl();
			String y = x.substring(x.indexOf("/"), x.indexOf("/pd"));
			String z = y.substring(y.lastIndexOf("-") + 1);
			p.setCodProdus(z);
			if(getCelPrice(z)==null) {
				p.setCelPrice("1000000");
			}else {
			p.setCelPrice(getCelPrice(z));
			}
			//System.out.println(p.toString());
		}
		for(Product p : products) {
			String x = p.getPrice().replace(".", "");
			if(Integer.valueOf(x) > Integer.valueOf(p.getCelPrice()) && p.getCelPrice() !=null) {
				p.setProvider("CEL");
				p.setPrice(p.getCelPrice());
			}
		}

		return products;
	}
	
	
	public String getCelPrice(String codProd) throws IOException {
		doc = Jsoup.connect("http://www.cel.ro/cauta/" + codProd + "/").get();
		Elements productsBottom = doc.getElementsByClass("pret_n");
		String x = null;
		String y = null;
		for (Element p : productsBottom) {
			 x = p.getElementsByTag("b").text();
//			 System.out.println(x.substring(0, x.indexOf(" lei")));
			 y = x.substring(0, x.indexOf(" lei"));
			 
		}
		return y;
	}
}
