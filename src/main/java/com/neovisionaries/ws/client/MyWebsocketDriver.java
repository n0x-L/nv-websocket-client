package com.neovisionaries.ws.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class MyWebsocketDriver {
	
	String serverAddress = "wss://echo.websocket.org/";
	int serverPort = 8888;
	
	private static final int timeout = 5000;

	public static void main(String[] args) throws Exception {
		
		//ProxySettings settings = factory.getProxySettings();
		WebSocket ws = new WebSocketFactory().createSocket("wss://echo.websocket.org/", 5000);
		
		
		// Set up websocket protocol
		//ws.addProtocol("101 Switching Protocols");
		
		
		
		// Register a listener to receive WebSocket events
		ws.addListener(new WebSocketAdapter() {
			public void onTextMessage(WebSocket websocket, String message) throws Exception {
				System.out.println(message);
			}
		});
		
		try {
			ws.connect();
			System.out.println(ws.isOpen());
			BufferedReader in = getInput();
			
			String text;
			
			while ((text = in.readLine()) != null)
			{
				if(text.contentEquals("exit"))
				{
					break;
				}
				
				ws.sendText(text);
			}
			//ws.sendText("my test.");
			
			ws.disconnect();
			
		}
		
		catch (OpeningHandshakeException e)
		{
			// Status line.
		    StatusLine sl = e.getStatusLine();
		    System.out.println("=== Status Line ===");
		    System.out.format("HTTP Version  = %s\n", sl.getHttpVersion());
		    System.out.format("Status Code   = %d\n", sl.getStatusCode());
		    System.out.format("Reason Phrase = %s\n", sl.getReasonPhrase());
		    
		 // HTTP headers.
		    Map<String, List<String>> headers = e.getHeaders();
		    System.out.println("=== HTTP Headers ===");
		    for (Map.Entry<String, List<String>> entry : headers.entrySet())
		    {
		        // Header name.
		        String name = entry.getKey();

		        // Values of the header.
		        List<String> values = entry.getValue();

		        if (values == null || values.size() == 0)
		        {
		            // Print the name only.
		            System.out.println(name);
		            continue;
		        }

		        for (String value : values)
		        {
		            // Print the name and the value.
		            System.out.format("%s: %s\n", name, value);
		        }
		    }
		}
		catch (HostnameUnverifiedException e1)
		{
			System.out.println("Certificate of the peer does not match the expected hostname.");
			System.err.println(e1);
		}
		catch (WebSocketException e2)
		{
			System.err.println(e2);
		}
	}

	
	private static BufferedReader getInput() throws IOException
	{
		return new BufferedReader(new InputStreamReader(System.in));
	}

}
