package org.Excerise1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



import org.json.JSONObject;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		String url="https://api.chucknorris.io/jokes/random";
		//RequestBuild
		HttpRequest request=HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		
		//RequestObject
		HttpClient clients=HttpClient.newBuilder().build();
		
		//Get Response
		HttpResponse<String> httpResponse=clients.send(request,HttpResponse.BodyHandlers.ofString());

	//	HttpEntity responseEntity=httpResponse.getEntity();
	  	
	
		JSONObject  responseObject=new JSONObject(httpResponse.body());
	
		System.out.println("Created At :"+responseObject.getString("created_at"));
		System.out.println("Icon_url:  :"+responseObject.getString("icon_url"));
		System.out.println("Id         :"+responseObject.getString("id"));
		System.out.println("Updated At :"+responseObject.getString("updated_at"));
		System.out.println("Url        :"+responseObject.getString("url"));
		System.out.println("Value      :"+responseObject.getString("value"));

	}

}
