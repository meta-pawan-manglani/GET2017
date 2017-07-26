package shopingStoreTerminal;

import java.io.*;
import java.util.*;

/**
 * The Class Reader.
 * 
 * Utility Reader class
 * 
 * @author Pawan Manglani
 * @version 1.1 26-JUL-2017
 */
public class Reader {

	/** The reader. */
	private BufferedReader reader;

	/** The file. */
	private File file;

	/** The product. */
	private Product product;

	/** The product promo. */
	private ProductPromo productPromo;

	/** The order promo. */
	private OrderPromo orderPromo;

	/** The input reader. */
	private InputStreamReader inputReader;

	/** The console reader. */
	private BufferedReader consoleReader;

	/** The product list. */
	private HashSet<Product> productList;

	/** The promo list. */
	private ArrayList<ProductPromo> promoList;

	/** The order promo list. */
	private ArrayList<OrderPromo> orderPromoList;

	/**
	 * Instantiates a new reader.
	 *
	 * @param fileName the file name
	 * @throws FileNotFoundException 
	 */
	public Reader(String fileName) throws FileNotFoundException {
		try {
			file = new File(fileName);
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new FileNotFoundException(fileName + " File not found");
		}
	}

	/**
	 * Instantiates a new reader.
	 *
	 * @param inputStream the input stream
	 */
	public Reader(InputStream inputStream) {
		inputReader = new InputStreamReader(inputStream);
		consoleReader = new BufferedReader(inputReader);
	}

	/**
	 * Read products.
	 *
	 * @return the hash set
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws NumberFormatException the number format exception
	 */
	public HashSet<Product> readProducts() throws IOException,NumberFormatException,NullPointerException {
		productList = new HashSet<>();
		boolean flag = false;
		String line;
		while((line = reader.readLine()) != null) {
			if(!line.trim().equalsIgnoreCase("")) {
				String lineArray[] = line.split(",");
				if(lineArray.length<3) {
					throw new NullPointerException("File ProductList is not in proper format");
				}
				product = new Product();
				product.setProductId(lineArray[0]);
				if(productList.contains(product.getProductId())) {
					throw new IOException("Duplicate Product Halting the program");
				}
				product.setProductName(lineArray[1]);
				product.setProductPrice(Double.parseDouble(lineArray[2]));

				productList.add(product);
				flag = true;
			}
		}
		if(!flag) {
			throw new NullPointerException("File ProductList is not in proper format");
		}
		return productList;
	}

	/**
	 * Read promo.
	 *
	 * @return the array list
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws NumberFormatException the number format exception
	 */
	public ArrayList<ProductPromo> readPromo() throws IOException,NumberFormatException,NullPointerException {
		promoList = new ArrayList<>();
		boolean flag = false;
		String line;
		while((line = reader.readLine()) != null) {
			if(!line.trim().equalsIgnoreCase("")) {
				String lineArray[] = line.split(",");
				if(lineArray.length<3) {
					throw new NullPointerException("File ProductPromo is not in proper format");
				}
				productPromo = new ProductPromo();
				productPromo.setPromotionType(lineArray[0]);
				productPromo.setDiscountAmount(Double.parseDouble(lineArray[1]));
				String productId[] = lineArray[2].split(";");
				ArrayList<String> temp = new ArrayList<>();
				for(String id: productId) {
					temp.add(id);
				}
				productPromo.setProductIds(temp);
				promoList.add(productPromo);
				flag = true;
			}
		}
		if(!flag) {
			throw new NullPointerException("File ProductPromo is not in proper format");
		}
		return promoList;
	}


	/**
	 * ReadOrderPromo.
	 *
	 * @return the array list containing the Promotion on order
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws NumberFormatException the number format exception
	 */
	public ArrayList<OrderPromo> readOrderPromo() throws IOException,NumberFormatException {
		orderPromoList = new ArrayList<>();
		boolean flag = false;
		String line;
		while((line = reader.readLine()) != null) {
			if(!line.trim().equalsIgnoreCase("")) {
				String lineArray[] = line.split(",");
				if(lineArray.length<3) {
					throw new NullPointerException("File OrderPromo is not in proper format");
				}
				orderPromo = new OrderPromo();
				orderPromo.setPromotionType(lineArray[0]);
				orderPromo.setDiscountAmount(Double.parseDouble(lineArray[1]));
				orderPromo.setThresholdAmount(Double.parseDouble(lineArray[2]));
				orderPromoList.add(orderPromo);
				flag = true;
			}
		}
		if(!flag) {
			throw new NullPointerException("File OrderPromo is not in proper format");
		}
		return orderPromoList;

	}

	/**
	 * Next line.
	 *
	 * @return the next String console
	 */
	public String nextLine() {
		String input="";
		try {
			input = consoleReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return input;
	}

	/**
	 * Close.
	 * Use to close the resource
	 */
	public void close() {
		try {
			reader.close();
		} catch (IOException e) {
			System.out.println("Exception occur while closing the Reader");
		}
	}


}
