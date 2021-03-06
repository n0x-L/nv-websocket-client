package com.neovisionaries.ws.client;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class MyWebsocketDriver {

	public static void main(String[] args) throws Exception {
		
		// Create a WebSocketFactory instance
		WebSocketFactory factory = new WebSocketFactory();
		
		// Set a server name for SNI (Server Name Indication)
		
		
		// Get the associated ProxySettings instance
		ProxySettings settings = factory.getProxySettings();
		
		// Set a proxy server
		
		
		// Create the URI
		
		
		//String sURI = myUri.toString();
		
		// Create a WebSocket. The scheme part can be one of:
		// 'ws', 'wss', 'http', and 'https'
		//WebSocket ws = new WebSocketFactory().createSocket("ws://inputstreamreader.link", 5000);
		//WebSocket ws = new WebSocketFactory().createSocket("wss://echo.websocket.org/", 5000);
		WebSocket ws = new WebSocketFactory().createSocket(myUri, 5000);
		
		
		
		HandshakeBuilder w = ws.getHandshakeBuilder();
		
		//w.buildRequestLine();
		//w.buildHeaders();
		
		// Test - check request line
		System.out.println(w.buildRequestLine());
		
		// Test - Check headers
		
		for(int i = 0; i < w.buildHeaders().size(); i++) {
			
			String[] f = w.buildHeaders().get(i);
			for(int j = 0; j < f.length; j++) {
				System.out.println(f[j]);
			}
			
		}
		
		
		
		
		
		
		
		//System.out.println(ws.getURI());
		
		
		FileOutputStream outputStream = new FileOutputStream("logs");
		
		
		// Register a listener to receive WebSocket events
		ws.addListener(new WebSocketAdapter() {
			public void onTextMessage(WebSocket websocket, String message) throws Exception {
				//System.out.println(message);
				// Write the incoming data to the file
				byte b[] = message.getBytes();
				outputStream.write(b);
				outputStream.write("\n".getBytes());
				
				
			}
		});
		
		// Register a listener to receive WebSocket events
				ws.addListener(new WebSocketAdapter() {
					public void onTextMessage(WebSocket websocket, byte[] data) throws Exception {
						//System.out.println(message);
						// Write the incoming data to the file
						
						outputStream.write(data);
						outputStream.write("\n".getBytes());
						
						
					}
				});
		
		// Register a listener to receive WebSocket events
				ws.addListener(new WebSocketAdapter() {
					public void onFrame(WebSocket websocket, WebSocketFrame message) throws Exception {
						//System.out.println(message);
						// Write the incoming data to the file
						byte b[] = message.getPayload();
						outputStream.write(b);
						outputStream.write("\n".getBytes());
						
						
					}
				});
		
		// Register a listener to receive WebSocket events
				ws.addListener(new WebSocketAdapter() {
					public void onContinuationFrame(WebSocket websocket, WebSocketFrame message) throws Exception {
						//System.out.println(message);
						// Write the incoming data to the file
						byte b[] = message.getPayload();
						outputStream.write(b);
						outputStream.write("\n".getBytes());
						
						
					}
				});
				
		// Register a listener to receive WebSocket events
				ws.addListener(new WebSocketAdapter() {
					public void onBinaryFrame(WebSocket websocket, WebSocketFrame message) throws Exception {
						//System.out.println(message);
						// Write the incoming data to the file
						byte b[] = message.getPayload();
						outputStream.write(b);
						outputStream.write("\n".getBytes());
						
						
					}
				});
				
				
				
		// Register a listener to receive WebSocket events
				ws.addListener(new WebSocketAdapter() {
					public void onCloseFrame(WebSocket websocket, WebSocketFrame message) throws Exception {
						//System.out.println(message);
						// Write the incoming data to the file
						byte b[] = message.getPayload();
						outputStream.write(b);
						outputStream.write("\n".getBytes());
						
						
					}
				});
		
/*
		try {
			ws.connect();
			
			BufferedReader in = getInput();
			
			String text;
			
			while ((text = in.readLine()) != null)
			{
				if(text.contentEquals("exit"))
				{
					break;
				}
				
				//ws.sendText(text);
			}
			
			
			ws.disconnect();
			outputStream.close();
			
		}
		
		catch (OpeningHandshakeException e)
		{
			System.out.println("Opening Handshake Exception thrown");
			
			System.out.println(e);
			
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
			System.out.println("WebSocket Exception.");
			System.err.println(e2);
		}
		*/

	}

	
	private static BufferedReader getInput() throws IOException
	{
		return new BufferedReader(new InputStreamReader(System.in));
	}

}
