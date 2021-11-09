package com.portfolio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PortFolioValue {
	
	private static final Pattern PATTERN = Pattern.compile("(\"[A-Z]{3}\"):(\\d+\\.?\\d*)");
	private static final String FileLocation = "bobs_crypto.txt";
	
	public static void main(String[] args) throws Exception
	{
		getPortFolioValue();
	}
	
	private static void getPortFolioValue()
	{
		try
		{
			File file = new File(FileLocation);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			BigDecimal portFolioValue = BigDecimal.ZERO;
			while ((st = br.readLine()) != null)
			{
				String [] stock = st.split("=");
				String ticker = stock[0];
				String tickerQuantity = stock[1];
				
				BigDecimal tickerValue = getTickerValue(stock[0]);
				 
				BigDecimal tickerTotalValue = tickerValue.multiply(BigDecimal.valueOf(Integer.parseInt(tickerQuantity)));
				System.out.println("Coin : "+ticker+"   Quantity : "+padLeftSpace(tickerQuantity,5)+" :  Price : "+padLeftSpace(tickerValue.toString(),10)+" :  Total Price : "+padLeftSpace(tickerTotalValue.toString(),10));
				portFolioValue = portFolioValue.add(tickerTotalValue);
			}
			System.out.println("\n portFolioValue : " +portFolioValue);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static BigDecimal getTickerValue(String ticker) throws Exception{
		
		URL url = new URL("https://min-api.cryptocompare.com/data/price?fsym="+ticker+"&tsyms=EUR");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("accept", "application/json");
		InputStream responseStream = connection.getInputStream();
		int bufferSize = 1024;
		char[] buffer = new char[bufferSize];
		StringBuilder out = new StringBuilder();
		Reader in = new InputStreamReader(responseStream, StandardCharsets.UTF_8);
		for (int numRead; (numRead = in.read(buffer, 0, buffer.length)) > 0; ) {
		    out.append(buffer, 0, numRead);
		}
		return getTickerVal(out.toString());
	}

	private static BigDecimal getTickerVal(String response) {
        final Matcher matcher = PATTERN.matcher(response);
        if (matcher.find()) {
            return BigDecimal.valueOf(Double.parseDouble(matcher.group(2)));
        } else {
            return null;
        }
    }
	
	public static String padLeftSpace(String inputString, int length) {
	    if (inputString.length() >= length) {
	        return inputString;
	    }
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < length - inputString.length()) {
	        sb.append(' ');
	    }
	    sb.append(inputString);

	    return sb.toString();
	}
}
